import ConfigParser
import os
import re

class BuildItemsParser:
    
    # Config
    dotaBuildItemsFile = ""
    javaTemplateLocation = ""
    javaTargetLocation = ""
    itemsToken = ""
    itemCountToken = ""
    
    # Item parsing
    itemContents = ""
    javaTemplate = ""
    javaOutput = ""
    compiledOpenPattern = None
    compiledClosePattern = None
    
    def __init__(self):
        print "===================================="
        print "=   DotA hero build items parser   ="
        print "===================================="
        
        self.compiledOpenPattern = re.compile("^\t//==================================", re.DOTALL | re.MULTILINE)
        self.compiledClosePattern = re.compile("^\t}$", re.DOTALL | re.MULTILINE)
        
        self.loadConfig();
        self.loadItemsFile();
        self.loadJavaTemplate();
        self.parseAllItems();
        self.saveJavaFile();

    """
        Loads and parses the config file for the item parser. 
    """
    def loadConfig(self):
        print "loadConfig():"
        
        config = ConfigParser.ConfigParser()
        file = open("BuildItemsParser.cfg")
        config.readfp(file)
        file.close()
        
        self.dotaBuildItemsFile = config.get("Items", "dotaBuildItemsFile")
        self.javaTemplateLocation = config.get("Java", "template")
        self.javaTargetLocation = config.get("Java", "target")
        self.itemsToken = config.get("Java", "itemsToken")
        self.itemCountToken = config.get("Java", "itemCountToken")
        
        print " - Items file: " + self.dotaBuildItemsFile
        print " - Java template: " + self.javaTemplateLocation
        print " - Java target: " + self.javaTargetLocation
        print " - Java items token: " + self.itemsToken
        print " - Java item count token: " + self.itemCountToken

    """
        Loads the DotA items file.
    """
    def loadItemsFile(self):
        print "loadItemsFile(): " + self.dotaBuildItemsFile
        file = open(self.dotaBuildItemsFile)
        self.itemContents = file.read()
        file.close()
        
    """
        Loads the Java template.
    """
    def loadJavaTemplate(self):
        print "loadJavaTemplate(): " + self.javaTemplateLocation
        file = open(self.javaTemplateLocation)
        self.javaTemplate = file.read()
        file.close()
    
    """
        Parses the DotA items file.
    """
    def parseAllItems(self):
        print "parseAllItems()"
        # store in self.javaOutput
        itemPosition = self.getItemPosition(0)
        
        while itemPosition:
            #print " - item: %s" % (itemPosition,)
            itemString = self.itemContents[itemPosition[0]:itemPosition[1]]
            # Grab attrs
            self.javaOutput += "\t\t" + self.parseSingleItem(itemString) + "\n"
            itemPosition = self.getItemPosition(itemPosition[1])
            
    """
        Finds the start and end position of an item to parse.
        
        @param startPosition: position to start searching from.
    """
    def getItemPosition(self, startPosition):
        result = None
        
        match = self.compiledOpenPattern.search(self.itemContents, startPosition)
        if match:
            itemStart = match.start()
            match = self.compiledClosePattern.search(self.itemContents, itemStart)
            itemEnd = match.start()
            result = itemStart, itemEnd
        
        return result
        
    """
        Parses a single hero item and returns the Java string that we need to
        inject.
        
        @param item: The item to parse.
    """
    def parseSingleItem(self, item):
        abilityTranslatedName = self.findItemName(item, "Unknown")
        id = self.findPropertyValue(item, "ID", "-1")
        abilityName = self.findPropertyValue(item, "AbilityName", "")
        abilityBehavior = self.findPropertyValue(item, "AbilityBehavior", "-1")
        
        abilityCastRange = self.findPropertyValue(item, "AbilityCastRange", "")
        abilityCastPoint = self.findPropertyValue(item, "AbilityCastPoint", "-1")
        abilityCooldown = self.findPropertyValue(item, "AbilityCooldown", "")
        abilityManaCost = self.findPropertyValue(item, "AbilityManaCost", "")
        
        itemCost = self.findPropertyValue(item, "ItemCost", "-1")
        itemShopTags = self.findPropertyValue(item, "ItemShopTags", "")
        itemQuality = self.findPropertyValue(item, "ItemQuality", "")
        sideShop = self.findPropertyValue(item, "SideShop", "0")
        invalidHeroes = self.findPropertyValue(item, "InvalidHeroes", "")
        
        result = "itemList[" + id + "] = new BuildItemVO("
        result += id + ", "
        result += "\"" + abilityTranslatedName + "\", "
        result += "\"" + abilityName + "\", "
        result += "-1, " if abilityBehavior == "-1" else "BuildItemVO.AbilityBehavior." + abilityBehavior.replace(" | ", ".behaviourValue + BuildItemVO.AbilityBehavior.") + ".behaviourValue, "
        
        result += "null, " if abilityCastRange == "" else "new int[]{" + abilityCastRange.replace(" ", ", ") + "}, "
        result += abilityCastPoint + ", "
        result += "null, " if abilityCooldown == "" else "new double[]{" + abilityCooldown.replace(" ", ", ") + "}, "
        result += "null, " if abilityManaCost == "" else "new int[]{" + abilityManaCost.replace(" ", ", ") + "}, "
        
        result += itemCost + ", "
        result += "null, " if itemShopTags == "" else "new String[]{\"" + itemShopTags.replace(";", "\", \"") + "\"}, "
        result += "\"" + itemQuality + "\", "
        result += ("true" if sideShop == "1" else "false")  + ", "
        result += "null" if invalidHeroes == "" else "new String[]{\"" + invalidHeroes.replace(";", "\", \"") + "\"}"
        result += ");"
        
        return result

	"""
		Find a hero build item's translated name, i.e. "Blink dagger".
		
		@param item: The item to search through.
		@param defaultValue: Default value to use if the property (or value) 
            can't be found. 
	"""
    def findItemName(self, item, defaultValue):
		result = defaultValue
		nameStart = item.find("// ") + 3
		nameEnd = item.find("//=", 4) - 2
		
		foundName = item[nameStart:nameEnd]
		if len(foundName) > 0:
			result = foundName

		return result;
		
    """
        Finds a single property's value.
        
        @param item: The item to search through.
        @param propertyName: The property we're looking for.
        @param defaultValue: Default value to use if the property (or value) 
            can't be found. 
    """
    def findPropertyValue(self, item, propertyName, defaultValue):
        result = defaultValue
        namePosition = item.find(propertyName)
        
        if namePosition > -1:
            valueStart = item.find("\"", namePosition + len(propertyName) + 1)
            if valueStart > -1:
                valueStart += 1
                valueEnd = item.find("\"", valueStart)
                if valueEnd > -1:
                    result = item[valueStart:valueEnd]
        
        return result
        
    """
        Finds the field that indicates how many IDs are already in use.
    """
    def getItemCount(self):
        print "getItemCount()"
        countIdentifier = "// next free ID: "
        
        countStart = self.itemContents.find(countIdentifier)
        countStart += len(countIdentifier)
        
        countEnd = self.itemContents.find("\n", countStart)
        
        return self.itemContents[countStart:countEnd]
        
    """
        Save the Java class.
    """
    def saveJavaFile(self):
        print "saveJavaFile(): " + self.javaTargetLocation
        fileOutput = self.javaTemplate.replace(self.itemsToken, self.javaOutput)
        fileOutput = fileOutput.replace(self.itemCountToken, self.getItemCount())
        
        file = open(self.javaTargetLocation, "w")
        file.write(fileOutput);
        file.close();
        print "Done!"

if __name__ == "__main__":
    BuildItemsParser()
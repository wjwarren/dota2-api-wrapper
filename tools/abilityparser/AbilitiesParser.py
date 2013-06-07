import ConfigParser
import os
import re
"""
	Simple tool to parse the DotA2 npc_abilities.txt file and spit out a Java class that lists all abilities.
	
	At the time of writing, only the "meepo_poof" is causing a small issue as its "AbilityBehavior" value contained
	double pipes ("|") between the values. Either manually remove the double pipe in the text file OR fix the Java
	class that this script spits out.
"""
class AbilitiesParser:
    
	# Misc
    abilityCountOffset = 5001;

    # Config
    dotaAbilitiesFile = ""
    javaTemplateLocation = ""
    javaTargetLocation = ""
    abilitiesToken = ""
    abilityCountToken = ""
    
    # Item parsing
    abilitiesContents = ""
    javaTemplate = ""
    javaOutput = ""
    compiledOpenPattern = None
    compiledClosePattern = None
    
    def __init__(self):
        print "=================================="
        print "=   DotA hero abilities parser   ="
        print "=================================="
        
        self.compiledOpenPattern = re.compile("^\t//==================================", re.DOTALL | re.MULTILINE)
        self.compiledClosePattern = re.compile("^\t}$", re.DOTALL | re.MULTILINE)
        
        self.loadConfig();
        self.loadAbilitiesFile();
        self.loadJavaTemplate();
        self.parseAllAbilities();
        self.saveJavaFile();

    """
        Loads and parses the config file for the item parser. 
    """
    def loadConfig(self):
        print "loadConfig():"
        
        config = ConfigParser.ConfigParser()
        file = open("AbilitiesParser.cfg")
        config.readfp(file)
        file.close()
        
        self.dotaAbilitiesFile = config.get("Abilities", "dotaAbilitiesFile")
        self.javaTemplateLocation = config.get("Java", "template")
        self.javaTargetLocation = config.get("Java", "target")
        self.abilitiesToken = config.get("Java", "abilitiesToken")
        self.abilityCountToken = config.get("Java", "abilityCountToken")
        
        print " - Abilities file: " + self.dotaAbilitiesFile
        print " - Java template: " + self.javaTemplateLocation
        print " - Java target: " + self.javaTargetLocation
        print " - Java ability token: " + self.abilitiesToken
        print " - Java ability count token: " + self.abilityCountToken

    """
        Loads the DotA abilities file.
    """
    def loadAbilitiesFile(self):
        print "loadAbilitiesFile(): " + self.dotaAbilitiesFile
        file = open(self.dotaAbilitiesFile)
        self.abilitiesContents = file.read()
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
        Parses the DotA abilities file.
    """
    def parseAllAbilities(self):
        print "parseAllAbilities()"
        abilityPosition = self.getAbilityPosition(0)
        
        while abilityPosition:
            abilityString = self.abilitiesContents[abilityPosition[0]:abilityPosition[1]]
            # Grab attrs
            self.javaOutput += "\t\t" + self.parseSingleAbility(abilityString) + "\n"
            abilityPosition = self.getAbilityPosition(abilityPosition[1])
            
    """
        Finds the start and end position of an ability to parse.
        
        @param startPosition: position to start searching from.
    """
    def getAbilityPosition(self, startPosition):
        result = None
        
        match = self.compiledOpenPattern.search(self.abilitiesContents, startPosition)
        if match:
            itemStart = match.start()
            match = self.compiledClosePattern.search(self.abilitiesContents, itemStart)
            itemEnd = match.start()
            result = itemStart, itemEnd
        
        return result
        
    """
        Parses a single hero item and returns the Java string that we need to
        inject.
        
        @param item: The item to parse.
    """
    def parseSingleAbility(self, item):
        # General
        abilityId = self.findPropertyValue(item, "ID", "-1")
        abilityName = self.findAbilityName(item, "Unknown")
        abilityNameToken = self.findPropertyValue(item, "AbilityName", "")
        abilityType = self.findPropertyValue(item, "AbilityType", "null")
        abilityBehavior = self.findPropertyValue(item, "AbilityBehavior", "-1")
        abilityOnCastbar = self.findPropertyValue(item, "OnCastbar", "-1")
        abilityOnLearnbar = self.findPropertyValue(item, "OnLearnbar", "-1")
        
		# Stats
        abilityCastRange = self.findPropertyValue(item, "AbilityCastRange", "-1")
        abilityCastRangeBuffer = self.findPropertyValue(item, "AbilityCastRangeBuffer", "-1")
        abilityCastPoint = self.findPropertyValue(item, "AbilityCastPoint", "null")
        abilityChannelTime = self.findPropertyValue(item, "AbilityChannelTime", "null")
        abilityCooldown = self.findPropertyValue(item, "AbilityCooldown", "null")
        abilityDuration = self.findPropertyValue(item, "AbilityDuration", "null")
        abilitySharedCooldown = self.findPropertyValue(item, "AbilitySharedCooldown", "")
        abilityDamage = self.findPropertyValue(item, "AbilityDamage", "null")
        abilityManaCost = self.findPropertyValue(item, "AbilityManaCost", "null")
        abilityModifierSupportValue = self.findPropertyValue(item, "AbilityModifierSupportValue", "-1")
        abilityModifierSupportBonus = self.findPropertyValue(item, "AbilityModifierSupportBonus", "-1")

        result = "addAbility(new AbilityVO("
        # General
        result += abilityId + ", "
        result += "\"" + abilityName + "\", "
        result += "\"" + abilityNameToken + "\", "
        result += "null, " if abilityType == "null" else "AbilityVO.Type." + abilityType + ", "
        result += "-1, " if abilityBehavior == "-1" else "AbilityVO.Behavior." + abilityBehavior.replace(" | ", ".behaviourValue + AbilityVO.Behavior.") + ".behaviourValue, "
        result += "-1, " if abilityOnCastbar == "-1" else abilityOnCastbar + ", "
        result += "-1, " if abilityOnLearnbar == "-1" else abilityOnLearnbar + ", "
        
        # Stats
        result += "null, " if abilityCastRange == "null" else "new int[]{" + abilityCastRange.replace(" ", ", ") + "}, "
        result += "-1, " if abilityCastRangeBuffer == "-1" else abilityCastRangeBuffer + ", "
        result += "null, " if abilityCastPoint == "null" else "new double[]{" + abilityCastPoint.replace(" ", ", ") + "}, "
        result += "null, " if abilityChannelTime == "null" else "new double[]{" + abilityChannelTime.replace(" ", ", ") + "}, "
        result += "null, " if abilityCooldown == "null" else "new double[]{" + abilityCooldown.replace(" ", ", ") + "}, "
        result += "null, " if abilityDuration == "null" else "new double[]{" + abilityDuration.replace(" ", ", ") + "}, "
        result += "\"" + abilitySharedCooldown + "\", "
        result += "null, " if abilityDamage == "null" else "new double[]{" + abilityDamage.replace(" ", ", ") + "}, "
        result += "null, " if abilityManaCost == "null" else "new int[]{" + abilityManaCost.replace(" ", ", ") + "}, "
        result += abilityModifierSupportValue + ", "
        result += abilityModifierSupportBonus

        result += "));"
        
        return result

	"""
		Find a hero ability's translated name, i.e. "Blink dagger".
		
		@param item: The item to search through.
		@param defaultValue: Default value to use if the property (or value) 
            can't be found. 
	"""
    def findAbilityName(self, item, defaultValue):
		result = defaultValue
		namePrefix = "Ability: "
		
		nameStartString = "// "
		nameStart = item.find(nameStartString) + len(nameStartString)
		nameEnd = item.find("\n", nameStart)
		
		foundName = item[nameStart:nameEnd]
		if len(foundName) > 0:
			result = foundName
			if namePrefix in result:
				result = result[len(namePrefix):len(result)]

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
    def getAbilitiesCount(self):
        print "getAbilitiesCount()"
        countIdentifier = "Next free ID "

        # Count is always at the end of the file.
        startOffset = len(self.abilitiesContents) - 200
        countStart = self.abilitiesContents.find(countIdentifier, startOffset)
        countStart += len(countIdentifier)
        
        countEnd = self.abilitiesContents.find("\n", countStart)

        return str(int(self.abilitiesContents[countStart:countEnd]) - self.abilityCountOffset)
        
    """
        Save the Java class.
    """
    def saveJavaFile(self):
        print "saveJavaFile(): " + self.javaTargetLocation
        fileOutput = self.javaTemplate.replace(self.abilitiesToken, self.javaOutput)
        fileOutput = fileOutput.replace(self.abilityCountToken, self.getAbilitiesCount())
        
        file = open(self.javaTargetLocation, "w")
        file.write(fileOutput);
        file.close();
        print "Done!"

if __name__ == "__main__":
    AbilitiesParser()
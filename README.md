dota2-api-wrapper
=================

An Android API wrapper for Dota 2.

###Requirements
* [Google GSON](http://code.google.com/p/google-gson/) (A library to convert JSON to Java and Java to JSON.)
* (Optional) [Python](http://python.org/)

###Overview
This project will deserialize DotA API responses into typed Java objects. Potentially saving you a lot of headache when dealing with JSON strings.

####Example

Creating a request URL:
```java
HashMap<String, String> matchParams = new HashMap<String, String>();
matchParams.put(SteamRequest.Parameter.API_KEY,"your_steam_api_key");
matchParams.put(GetMatchDetails.Parameter.MATCH_ID, "1219429");

GetMatchDetails matchDetailsRequest = new GetMatchDetails();
String url = matchDetailsRequest.createRequestUrl(DotaRequest.ApplicationID.BETA, matchParams);
```

Parsing the response:
```java
GsonUtil util = new GsonUtil();
Gson gson = new Gson();

GetMatchDetailsResponse matchDetailsResponse = gson.fromJson(util.getStrippedResult(matchDetailsResponse), GetMatchDetailsResponse.class);
```

###Generating HeroBuildItemList.java
If you have Python installed you can generate the `src/nl/ansuz/android/steam/dota/util/HeroBuildItemList.java` file by running the BuildItemsParser Python script found in `tools/itemparser`.

First extract `scripts/npc/items.txt` from `<path to steam>/Steam/steamapps/common/dota 2 beta/dota/pak01_dir.vpk` using [GCFScape](http://nemesis.thewavelength.net/index.php?p=26).

After this, tweak `tools/itemparser/BuildItemsParser.cfg` to meet your needs.

Last, run `python tools/itemparser/BuildItemsParser.py`
PvPTitles
=========

This plugin is based on the Hero titles from Guild Wars and takes the idea of PvP Titles. These Titles reflect a player's success in defeating other players by earning Titles after a specific amount of Kills.

## Features
* Get new Titles on Player kills
* Set your own Titles and their Fame amount
* Check out the Fame System
* One simple command for all your desires /rank 

##Commands
* /rank - Displays your info
* /ladder - Shows top 5 players with fame

##Permissions
pvptitles.rank - Activates /rank command.

pvptitles.ladder - Activates /ladder command.

pvptitles.chat - Enable rank in chat, REQUIRED true in config

```yaml
PrefixColor: green
RankNames:
- None
- Hero
- Fierce Hero
- Mighty Hero
- Deadly Hero
- Terrifying Hero
- Conquering Hero
- Subjugating Hero
- Vanquishing Hero
- Renowned Hero
- Illustrious Hero
- Eminent Hero
- King's Hero
- Emperor's Hero
- Balthazar's Hero
- Legendary Hero
ReqFame:
- 0
- 25
- 75
- 180
- 360
- 600
- 1000
- 1680
- 2800
- 4665
- 7750
- 12960
- 21600
- 36000
- 60000
- 100000
```

**Standard Rank**

The standard rank is none (wont be displayed unless you override the none rank) if you want to give players a normal rank to start with change none to anything else.


**Add/Remove Fame/Ranks**

You can always add a new Title and required fame or remove a existing. Be careful there must be the exact same amount of titles to fame otherwise you will get a error message on your console.


**Prefix Color**

Here is a list of all colors you can use regardless lower/uppercase
* BLACK
* DARK_BLUE
* DARK_GREEN
* DARK_AQUA
* DARK_RED
* DARK_PURPLE
* GOLD
* GRAY
* DARK_GRAY
* BLUE
* GREEN
* AQUA
* RED
* LIGHT_PURPLE
* YELLOW
* WHITE
* MAGIC

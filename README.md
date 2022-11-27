# Different Emerald Trades

A Simple Mod to allow users to change out the emeralds in villager trades.

Requires Fabric

Configuration:

Disable.All.Trades=false #boolean | default: false
Randomize.Emeralds=false #boolean | default: false
Randomize.Everything=false #boolean | default: false
Get.Value.From.Item.IDs=false #boolean | default: false

and

First.Buy.Item.Provider=minecraft:emerald #string | default: minecraft:emerald
Second.Buy.Item.Provider=minecraft:emerald #string | default: minecraft:emerald
Sell.Item.Provider=minecraft:emerald #string | default: minecraft:emerald
 

Each slot can be a different config. If you want all options to be the same, then you MUST have the same option on each line. and
For the Item ID section simply replace the minecraft:air with the item id of the item you want, as though you were using the /give command. for example:
minecraft:iron_ingot
or if modded, for example:
emerald_tools:ruby

for having all emeralds replaced with diamonds the config will look like:

Config.With.Integers=: #ONLY set the option you want to true | default: :
Disable.All.Trades=false #boolean | default: false
Randomize.Emeralds=false #boolean | default: false
Randomize.Everything=false #boolean | default: false
Get.Value.From.Item.IDs=true #boolean | default: false
Config.With.Item.IDs=: #Replace minecraft:emerald with any other item in the same format, as though you were using the /give command. | default: :
First.Buy.Item.Provider=minecraft:diamond #string | default: minecraft:emerald
Second.Buy.Item.Provider=minecraft:diamond #string | default: minecraft:emerald
Sell.Item.Provider=minecraft:diamond #string | default: minecraft:emerald




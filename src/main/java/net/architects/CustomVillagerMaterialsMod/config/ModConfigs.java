package net.architects.CustomVillagerMaterialsMod.config;

import com.mojang.datafixers.util.Pair;
import net.architects.CustomVillagerMaterialsMod.CustomeVillagerMaterialsMod;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;
    public static int FirstBuyMaterialInt;
    public static int SecondBuyMaterialInt;
    public static int SellMaterialInt;

    public static Item FirstBuyMaterial;
    public static Item SecondBuyMaterial;
    public static Item SellMaterial;

    public static String FirstBuyMaterialString;
    public static String SecondBuyMaterialString;
    public static String SellMaterialString;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(CustomeVillagerMaterialsMod.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("Config.With.Integers", ":"), "Buy Material== 1: Disable trading, 2: Randomize Emeralds, 3: Randomize Everything");
        configs.addKeyValuePair(new Pair<>("First.Buy.Integer.Provider", 0), "int");
        configs.addKeyValuePair(new Pair<>("Second.Buy.Integer.Provider", 0), "int");
        configs.addKeyValuePair(new Pair<>("Sell.Integer.Provider", 0), "int");

        configs.addKeyValuePair(new Pair<>("Config.With.Item.IDs", ":"), "If you want any of the above options then leave the following as minecraft:air ");

        configs.addKeyValuePair(new Pair<>("First.Buy.Item.Provider", "minecraft:emerald"), "string");
        configs.addKeyValuePair(new Pair<>("Second.Buy.Item.Provider", "minecraft:emerald"), "string");
        configs.addKeyValuePair(new Pair<>("Sell.Item.Provider", "minecraft:emerald"), "string");
    }

    private static void assignConfigs() {
        FirstBuyMaterialInt = CONFIG.getOrDefault("First.Buy.Integer.Provider", 0);
        SecondBuyMaterialInt = CONFIG.getOrDefault("Second.Buy.Integer.Provider", 0);
        SellMaterialInt = CONFIG.getOrDefault("Sell.Integer.Provider", 0);

        FirstBuyMaterialString =  CONFIG.getOrDefault("First.Buy.Item.Provider", "minecraft:emerald");
        SecondBuyMaterialString =  CONFIG.getOrDefault("Second.Buy.Item.Provider", "minecraft:emerald");
        SellMaterialString =  CONFIG.getOrDefault("Sell.Item.Provider", "minecraft:emerald");

//        FirstBuyMaterial =  Registry.ITEM.get(Identifier.tryParse(CONFIG.getOrDefault("First.Buy.Item.Provider", "minecraft:air")));
//        SecondBuyMaterial =  Registry.ITEM.get(Identifier.tryParse(CONFIG.getOrDefault("Second.Buy.Item.Provider", "minecraft:air")));
//        SellMaterial =  Registry.ITEM.get(Identifier.tryParse(CONFIG.getOrDefault("Sell.Item.Provider", "minecraft:air")));

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}

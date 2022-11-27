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

    public static boolean DisableTrades;

    public static boolean RandomEmeralds;

    public static boolean RandomEverything;

    public static boolean ItemFromID;

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
        configs.addKeyValuePair(new Pair<>("Config.With.Integers", ":"), "ONLY set the option you want to true");
        configs.addKeyValuePair(new Pair<>("Disable.All.Trades", false), "boolean");
        configs.addKeyValuePair(new Pair<>("Randomize.Emeralds", false), "boolean");
        configs.addKeyValuePair(new Pair<>("Randomize.Everything", false), "boolean");
        configs.addKeyValuePair(new Pair<>("Get.Value.From.Item.IDs", false), "boolean");

        configs.addKeyValuePair(new Pair<>("Config.With.Item.IDs", ":"), "Replace minecraft:emerald with any other item in the same format, as though you were using the /give command.");

        configs.addKeyValuePair(new Pair<>("First.Buy.Item.Provider", "minecraft:emerald"), "string");
        configs.addKeyValuePair(new Pair<>("Second.Buy.Item.Provider", "minecraft:emerald"), "string");
        configs.addKeyValuePair(new Pair<>("Sell.Item.Provider", "minecraft:emerald"), "string");
    }

    private static void assignConfigs() {
        DisableTrades = CONFIG.getOrDefault("Disable.All.Trades", false);
        RandomEmeralds = CONFIG.getOrDefault("Randomize.Emeralds", false);
        RandomEverything = CONFIG.getOrDefault("Randomize.Everything", false);
        ItemFromID = CONFIG.getOrDefault("Get.Value.From.Item.IDs", false);

        FirstBuyMaterialString =  CONFIG.getOrDefault("First.Buy.Item.Provider", "minecraft:emerald");
        SecondBuyMaterialString =  CONFIG.getOrDefault("Second.Buy.Item.Provider", "minecraft:emerald");
        SellMaterialString =  CONFIG.getOrDefault("Sell.Item.Provider", "minecraft:emerald");

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}

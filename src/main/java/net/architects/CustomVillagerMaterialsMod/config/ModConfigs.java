package net.architects.CustomVillagerMaterialsMod.config;

import com.mojang.datafixers.util.Pair;
import net.architects.CustomVillagerMaterialsMod.CustomeVillagerMaterialsMod;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;
    public static int FirstBuyMaterialInt;
    public static int SecondBuyMaterialInt;
    public static int SellMaterialInt;

    public static Item FirstBuyMaterial;
    public static Item SecondBuyMaterial;
    public static Item SellMaterial;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(CustomeVillagerMaterialsMod.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("Config.With.Integers", ":"), "Buy Material== 1: Emerald, 2: Diamond, 3: Iron Ingot, 4: Raw Iron, 5: Iron Nugget, 6: Gold Ingot, 7: Raw Gold, 8: Gold Nugget, " +
                "9: Copper Ingot, 10: Raw Copper, 11: Amethyst, 12: Coal, 13: Lapis, 14: Redstone, 15: Quartz, 16: Glowstone Dust, 17: Dirt, 18: Disable, 19:Random(change emeralds), 20:RANDOM(EVERYTHING)");
        configs.addKeyValuePair(new Pair<>("First.Buy.Material.Integer.Provider", 1), "int");
        configs.addKeyValuePair(new Pair<>("Second.Buy.Material.Integer.Provider", 1), "int");
        configs.addKeyValuePair(new Pair<>("Sell.Material.Integer.Provider", 1), "int");
    }

    private static void assignConfigs() {
        FirstBuyMaterialInt = CONFIG.getOrDefault("First.Buy.Material.Integer.Provider", 1);
        SecondBuyMaterialInt = CONFIG.getOrDefault("Second.Buy.Material.Integer.Provider", 1);
        SellMaterialInt = CONFIG.getOrDefault("Sell.Material.Integer.Provider", 1);


        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}

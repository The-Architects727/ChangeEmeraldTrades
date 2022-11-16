package net.architects.CustomVillagerMaterialsMod.config;

import com.mojang.datafixers.util.Pair;
import net.architects.CustomVillagerMaterialsMod.CustomeVillagerMaterialsMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

    public static Item FirstBuyMaterialPassIn;
    public static Item SecondBuyMaterialPassIn;
    public static Item SellMaterialPassIn;

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(CustomeVillagerMaterialsMod.MOD_ID + "config").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("Config.With.Integers", ":"), "Buy Material== 1: Emerald, 2: Diamond, 3: Iron Ingot, 4: Raw Iron, 5: Gold Nugget, 6: Gold Ingot, 7: Raw Gold, 8: Gold Nugget, " +
                "9: Copper Ingot, 10: Raw Copper, 11: Amethyst, 12: Coal, 13: Lapis, 14: Redstone, 15: Quartz, 16: Glowstone Dust, 17: Dirt, 18: Air(Disable)");
        configs.addKeyValuePair(new Pair<>("First.Buy.Material.Integer.Provider", 1), "int");
        configs.addKeyValuePair(new Pair<>("Second.Buy.Material.Integer.Provider", 1), "int");
        configs.addKeyValuePair(new Pair<>("Sell.Material.Integer.Provider", 1), "int");
    }

    private static void assignConfigs() {
        FirstBuyMaterialInt = CONFIG.getOrDefault("First.Buy.Material.Integer.Provider", 1);
        SecondBuyMaterialInt = CONFIG.getOrDefault("Second.Buy.Material.Integer.Provider", 1);
        SellMaterialInt = CONFIG.getOrDefault("Sell.Material.Integer.Provider", 1);


        switch(FirstBuyMaterialInt)
        {

            case 2 :
                FirstBuyMaterial = Items.DIAMOND;
                break;

            case 3 :
                FirstBuyMaterial = Items.IRON_INGOT;
                break;

            case 4 :
                FirstBuyMaterial = Items.RAW_IRON;
                break;

            case 5 :
                FirstBuyMaterial = Items.IRON_NUGGET;
                break;

            case 6 :
                FirstBuyMaterial = Items.GOLD_INGOT;
                break;

            case 7 :
                FirstBuyMaterial = Items.RAW_GOLD;
                break;

            case 8 :
                FirstBuyMaterial = Items.GOLD_NUGGET;
                break;

            case 9 :
                FirstBuyMaterial = Items.COPPER_INGOT;
                break;

            case 10 :
                FirstBuyMaterial = Items.RAW_COPPER;
                break;

            case 11 :
                FirstBuyMaterial = Items.AMETHYST_SHARD;
                break;

            case 12 :
                FirstBuyMaterial = Items.COAL;
                break;

            case 13 :
                FirstBuyMaterial = Items.LAPIS_LAZULI;
                break;

            case 14 :
                FirstBuyMaterial = Items.REDSTONE;
                break;

            case 15 :
                FirstBuyMaterial = Items.QUARTZ;
                break;

            case 16 :
                FirstBuyMaterial = Items.GLOWSTONE_DUST;
                break;

            case 17 :
                FirstBuyMaterial = Items.DIRT;
                break;

            case 18 :
                FirstBuyMaterial = Items.AIR;
                break;

            default :
                FirstBuyMaterial = Items.EMERALD;
        }

        switch(SecondBuyMaterialInt)
        {

            case 2 :
                SecondBuyMaterial = Items.DIAMOND;
                break;

            case 3 :
                SecondBuyMaterial = Items.IRON_INGOT;
                break;

            case 4 :
                SecondBuyMaterial = Items.RAW_IRON;
                break;

            case 5 :
                SecondBuyMaterial = Items.IRON_NUGGET;
                break;

            case 6 :
                SecondBuyMaterial = Items.GOLD_INGOT;
                break;

            case 7 :
                SecondBuyMaterial = Items.RAW_GOLD;
                break;

            case 8 :
                SecondBuyMaterial = Items.GOLD_NUGGET;
                break;

            case 9 :
                SecondBuyMaterial = Items.COPPER_INGOT;
                break;

            case 10 :
                SecondBuyMaterial = Items.RAW_COPPER;
                break;

            case 11 :
                SecondBuyMaterial = Items.AMETHYST_SHARD;
                break;

            case 12 :
                SecondBuyMaterial = Items.COAL;
                break;

            case 13 :
                SecondBuyMaterial = Items.LAPIS_LAZULI;
                break;

            case 14 :
                SecondBuyMaterial = Items.REDSTONE;
                break;

            case 15 :
                SecondBuyMaterial = Items.QUARTZ;
                break;

            case 16 :
                SecondBuyMaterial = Items.GLOWSTONE_DUST;
                break;

            case 17 :
                SecondBuyMaterial = Items.DIRT;
                break;

            case 18 :
                SecondBuyMaterial = Items.AIR;
                break;

            default :
                SecondBuyMaterial = Items.EMERALD;
        }

        switch(SellMaterialInt)
        {

            case 2 :
                SellMaterial = Items.DIAMOND;
                break;

            case 3 :
                SellMaterial = Items.IRON_INGOT;
                break;

            case 4 :
                SellMaterial = Items.RAW_IRON;
                break;

            case 5 :
                SellMaterial = Items.IRON_NUGGET;
                break;

            case 6 :
                SellMaterial = Items.GOLD_INGOT;
                break;

            case 7 :
                SellMaterial = Items.RAW_GOLD;
                break;

            case 8 :
                SellMaterial = Items.GOLD_NUGGET;
                break;

            case 9 :
                SellMaterial = Items.COPPER_INGOT;
                break;

            case 10 :
                SellMaterial = Items.RAW_COPPER;
                break;

            case 11 :
                SellMaterial = Items.AMETHYST_SHARD;
                break;

            case 12 :
                SellMaterial = Items.COAL;
                break;

            case 13 :
                SellMaterial = Items.LAPIS_LAZULI;
                break;

            case 14 :
                SellMaterial = Items.REDSTONE;
                break;

            case 15 :
                SellMaterial = Items.QUARTZ;
                break;

            case 16 :
                SellMaterial = Items.GLOWSTONE_DUST;
                break;

            case 17 :
                SellMaterial = Items.DIRT;
                break;

            case 18 :
                SellMaterial = Items.AIR;
                break;

            default :
                SellMaterial = Items.EMERALD;
        }

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}

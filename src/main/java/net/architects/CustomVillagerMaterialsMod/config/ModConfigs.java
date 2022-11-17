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

        FirstBuyMaterial = switchItem(FirstBuyMaterialInt);
        SecondBuyMaterial = switchItem(SecondBuyMaterialInt);
        SellMaterial = switchItem(SellMaterialInt);

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }

    private static Item switchItem(int configInt) {
        Item item;
        switch(configInt)
        {
            case 2 :
                item = Items.DIAMOND;
                break;

            case 3 :
                item = Items.IRON_INGOT;
                break;

            case 4 :
                item = Items.RAW_IRON;
                break;

            case 5 :
                item = Items.IRON_NUGGET;
                break;

            case 6 :
                item = Items.GOLD_INGOT;
                break;

            case 7 :
                item = Items.RAW_GOLD;
                break;

            case 8 :
                item = Items.GOLD_NUGGET;
                break;

            case 9 :
                item = Items.COPPER_INGOT;
                break;

            case 10 :
                item = Items.RAW_COPPER;
                break;

            case 11 :
                item = Items.AMETHYST_SHARD;
                break;

            case 12 :
                item = Items.COAL;
                break;

            case 13 :
                item = Items.LAPIS_LAZULI;
                break;

            case 14 :
                item = Items.REDSTONE;
                break;

            case 15 :
                item = Items.QUARTZ;
                break;

            case 16 :
                item = Items.GLOWSTONE_DUST;
                break;

            case 17 :
                item = Items.DIRT;
                break;

            case 18 :
                item = Items.AIR;
                break;

            default :
                item = Items.EMERALD;
        }

        if(item == null) {
            item = Items.EMERALD;
        }

        return item;
    }
}

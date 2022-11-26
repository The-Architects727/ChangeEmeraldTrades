package net.architects.CustomVillagerMaterialsMod.mixin;

import net.architects.CustomVillagerMaterialsMod.config.ModConfigs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.random.CheckedRandom;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.TradeOffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Random;


@Mixin(TradeOffer.class)
public class CustomTradeMaterial{

    @ModifyVariable(method = "<init>(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;IIIFI)V", at = @At("HEAD"), ordinal = 0)
    private static ItemStack StormlightMod$replaceFirstBuyItem(ItemStack item)
    {
        if(ModConfigs.FirstBuyMaterialInt == 18) {
            ItemStack itemStack = disableAllItems();
            return itemStack;
        } else if (ModConfigs.FirstBuyMaterialInt == 19){
            if (item.getItem() == Items.EMERALD) {
                ItemStack itemStack;
                Item itemChosen = getRandomItem();
                if (itemChosen.getMaxCount() < item.getCount()) {
                    itemStack = new ItemStack(itemChosen, itemChosen.getMaxCount());
                } else {
                    itemStack = new ItemStack(itemChosen, item.getCount());
                }
                return itemStack;
            }
        } else if (ModConfigs.FirstBuyMaterialInt == 20){
            ItemStack itemStack;
            Item itemChosen = getRandomItem();
            if (itemChosen.getMaxCount() < item.getCount()) {
                itemStack = new ItemStack(itemChosen, itemChosen.getMaxCount());
            } else {
                itemStack = new ItemStack(itemChosen, item.getCount());
            }
            return itemStack;
        } else {
            if (item.getItem() == Items.EMERALD)
                item = new ItemStack(returnItemFromInt(ModConfigs.FirstBuyMaterialInt), item.getCount());
            return item;
        }
        return new ItemStack(Items.EMERALD, item.getCount());
    }

    @ModifyVariable(method = "<init>(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;IIIFI)V", at = @At("HEAD"), ordinal = 1)
    private static ItemStack StormlightMod$replaceSecondBuyItem(ItemStack item)
    {
        if(ModConfigs.SecondBuyMaterialInt == 18) {
            ItemStack itemStack = disableAllItems();
            return itemStack;
        } else if (ModConfigs.SecondBuyMaterialInt == 19){
            if (item.getItem() == Items.EMERALD) {
                ItemStack itemStack;
                Item itemChosen = getRandomItem();
                if (itemChosen.getMaxCount() < item.getCount()) {
                    itemStack = new ItemStack(itemChosen, itemChosen.getMaxCount());
                } else {
                    itemStack = new ItemStack(itemChosen, item.getCount());
                }
                return itemStack;
            }
        } else if (ModConfigs.SecondBuyMaterialInt == 20){
            ItemStack itemStack;
            Item itemChosen = getRandomItem();
            if (itemChosen.getMaxCount() < item.getCount()) {
                itemStack = new ItemStack(itemChosen, itemChosen.getMaxCount());
            } else {
                itemStack = new ItemStack(itemChosen, item.getCount());
            }
            return itemStack;
        } else {
            if (item.getItem() == Items.EMERALD)
                item = new ItemStack(returnItemFromInt(ModConfigs.SecondBuyMaterialInt), item.getCount());
            return item;
        }
        return new ItemStack(Items.EMERALD, item.getCount());

    }

    @ModifyVariable(method = "<init>(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;IIIFI)V", at = @At("HEAD"), ordinal = 2)
    private static ItemStack StormlightMod$replaceSellItem(ItemStack item)
    {
        if(ModConfigs.SellMaterialInt == 18) {
            ItemStack itemStack = disableAllItems();
            return itemStack;
        } else if (ModConfigs.SellMaterialInt == 19){
            if (item.getItem() == Items.EMERALD) {
                ItemStack itemStack;
                Item itemChosen = getRandomItem();
                if (itemChosen.getMaxCount() < item.getCount()) {
                    itemStack = new ItemStack(itemChosen, itemChosen.getMaxCount());
                } else {
                    itemStack = new ItemStack(itemChosen, item.getCount());
                }
                return itemStack;
            }
        } else if (ModConfigs.SellMaterialInt == 20){
            ItemStack itemStack;
            Item itemChosen = getRandomItem();
            if (itemChosen.getMaxCount() < item.getCount()) {
                itemStack = new ItemStack(itemChosen, itemChosen.getMaxCount());
            } else {
                itemStack = new ItemStack(itemChosen, item.getCount());
            }
            return itemStack;
        } else {
            if (item.getItem() == Items.EMERALD)
                item = new ItemStack(returnItemFromInt(ModConfigs.SellMaterialInt), item.getCount());
            return item;
        }
        return new ItemStack(Items.EMERALD, item.getCount());

    }
    private static Item returnItemFromInt(int integerDenotion) {
        Item item;
        switch(integerDenotion)
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

            default :
                item = Items.EMERALD;
        }

        if(item == null) {
            item = Items.EMERALD;
        }

        return item;
    }

    private static Random rollSeed = new Random();

    private static ItemStack disableAllItems() {
        ItemStack stack = new ItemStack(Items.AIR, 0);
        return stack;
    }

    private static Item getRandomItem() {
        Item item;

        item = Registry.ITEM.getRandom(net.minecraft.util.math.random.Random.create()).get().value();

        if(Illegal(item)) {
            item = Items.EMERALD;
        }

        return item;
    }


    private static boolean Illegal(Item item) {
        return item == Items.BARRIER || item == null || item == Items.COMMAND_BLOCK || item == Items.COMMAND_BLOCK_MINECART ||
                item == Items.CHAIN_COMMAND_BLOCK || item == Items.REPEATING_COMMAND_BLOCK || item == Items.STRUCTURE_BLOCK ||
                item == Items.STRUCTURE_VOID || item == Items.AIR;
    }

}

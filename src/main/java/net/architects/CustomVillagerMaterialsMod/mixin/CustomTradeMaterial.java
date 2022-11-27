package net.architects.CustomVillagerMaterialsMod.mixin;

import net.architects.CustomVillagerMaterialsMod.config.ModConfigs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
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
        Random roll = new Random();
        if(ModConfigs.DisableTrades && !ModConfigs.RandomEmeralds && !ModConfigs.RandomEverything && !ModConfigs.ItemFromID) {
            ItemStack itemStack = disableAllItems();
            return itemStack;
        } else if (!ModConfigs.DisableTrades && ModConfigs.RandomEmeralds && !ModConfigs.RandomEverything && !ModConfigs.ItemFromID && item.getItem() == Items.EMERALD) {
            ItemStack itemStack;
            Item itemChosen = getRandomItem();
            if (itemChosen.getMaxCount() < item.getCount()) {
                itemStack = new ItemStack(itemChosen, itemChosen.getMaxCount());
            } else {
                itemStack = new ItemStack(itemChosen, item.getCount());
            }
            return itemStack;
        } else if (!ModConfigs.DisableTrades && !ModConfigs.RandomEmeralds && ModConfigs.RandomEverything && !ModConfigs.ItemFromID) {
            ItemStack itemStack;
            Item itemChosen = getRandomItem();
            if(item.getCount() == 0) {
                itemStack = item;
            } else {
                itemStack = new ItemStack(itemChosen, roll.nextInt(itemChosen.getMaxCount()) + 1);
            }
            return itemStack;
        } else if (!ModConfigs.DisableTrades && !ModConfigs.RandomEmeralds && !ModConfigs.RandomEverything && ModConfigs.ItemFromID && item.getItem() == Items.EMERALD) {
            return new ItemStack(Registry.ITEM.get(Identifier.tryParse(ModConfigs.FirstBuyMaterialString)), item.getCount());
        } else {
            return item;
        }

    }

    @ModifyVariable(method = "<init>(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;IIIFI)V", at = @At("HEAD"), ordinal = 1)
    private static ItemStack StormlightMod$replaceSecondBuyItem(ItemStack item)
    {
        Random roll = new Random();
        if(ModConfigs.DisableTrades && !ModConfigs.RandomEmeralds && !ModConfigs.RandomEverything && !ModConfigs.ItemFromID) {
            ItemStack itemStack = disableAllItems();
            return itemStack;
        } else if (!ModConfigs.DisableTrades && ModConfigs.RandomEmeralds && !ModConfigs.RandomEverything && !ModConfigs.ItemFromID && item.getItem() == Items.EMERALD) {
            ItemStack itemStack;
            Item itemChosen = getRandomItem();
            if (itemChosen.getMaxCount() < item.getCount()) {
                itemStack = new ItemStack(itemChosen, itemChosen.getMaxCount());
            } else {
                itemStack = new ItemStack(itemChosen, item.getCount());
            }
            return itemStack;
        } else if (!ModConfigs.DisableTrades && !ModConfigs.RandomEmeralds && ModConfigs.RandomEverything && !ModConfigs.ItemFromID) {
            ItemStack itemStack;
            Item itemChosen = getRandomItem();
            if(item.getCount() == 0) {
                itemStack = item;
            } else {
                itemStack = new ItemStack(itemChosen, roll.nextInt(itemChosen.getMaxCount()) + 1);
            }
            return itemStack;
        } else if (!ModConfigs.DisableTrades && !ModConfigs.RandomEmeralds && !ModConfigs.RandomEverything && ModConfigs.ItemFromID && item.getItem() == Items.EMERALD) {
            return new ItemStack(Registry.ITEM.get(Identifier.tryParse(ModConfigs.SecondBuyMaterialString)), item.getCount());
        } else {
            return item;
        }

    }

    @ModifyVariable(method = "<init>(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;IIIFI)V", at = @At("HEAD"), ordinal = 2)
    private static ItemStack StormlightMod$replaceSellItem(ItemStack item)
    {
        Random roll = new Random();
        if(ModConfigs.DisableTrades && !ModConfigs.RandomEmeralds && !ModConfigs.RandomEverything && !ModConfigs.ItemFromID) {
            ItemStack itemStack = disableAllItems();
            return itemStack;
        } else if (!ModConfigs.DisableTrades && ModConfigs.RandomEmeralds && !ModConfigs.RandomEverything && !ModConfigs.ItemFromID && item.getItem() == Items.EMERALD) {
            ItemStack itemStack;
            Item itemChosen = getRandomItem();
            if (itemChosen.getMaxCount() < item.getCount()) {
                itemStack = new ItemStack(itemChosen, itemChosen.getMaxCount());
            } else {
                itemStack = new ItemStack(itemChosen, item.getCount());
            }
            return itemStack;
        } else if (!ModConfigs.DisableTrades && !ModConfigs.RandomEmeralds && ModConfigs.RandomEverything && !ModConfigs.ItemFromID) {
            ItemStack itemStack;
            Item itemChosen = getRandomItem();
            if(item.getCount() == 0) {
                itemStack = item;
            } else {
                itemStack = new ItemStack(itemChosen, roll.nextInt(itemChosen.getMaxCount()) + 1);
            }
            return itemStack;
        } else if (!ModConfigs.DisableTrades && !ModConfigs.RandomEmeralds && !ModConfigs.RandomEverything && ModConfigs.ItemFromID && item.getItem() == Items.EMERALD) {
            return new ItemStack(Registry.ITEM.get(Identifier.tryParse(ModConfigs.SellMaterialString)), item.getCount());
        } else {
            return item;
        }

    }

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
                item == Items.STRUCTURE_VOID || item == Items.AIR || item == Items.BEDROCK || item == Items.POTION || item == Items.LINGERING_POTION ||
                item == Items.SPLASH_POTION;
    }

}

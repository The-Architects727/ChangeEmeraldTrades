package net.architects.CustomVillagerMaterialsMod.mixin;

import net.architects.CustomVillagerMaterialsMod.config.ModConfigs;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;



@Mixin(TradeOffer.class)
public class CustomTradeMaterial{

    @ModifyVariable(method = "<init>(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;IIIFI)V", at = @At("HEAD"), ordinal = 0)
    private static ItemStack StormlightMod$replaceEmeraldsWithDiamondsBase1(ItemStack item)
    {
        if (item.getItem() == Items.EMERALD)
            item = new ItemStack(ModConfigs.FirstBuyMaterial, item.getCount());
        return item;
    }

    @ModifyVariable(method = "<init>(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;IIIFI)V", at = @At("HEAD"), ordinal = 1)
    private static ItemStack StormlightMod$replaceEmeraldsWithDiamondsBase2(ItemStack item)
    {
        if (item.getItem() == Items.EMERALD)
            item = new ItemStack(ModConfigs.SecondBuyMaterial, item.getCount());
        return item;
    }

    @ModifyVariable(method = "<init>(Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;Lnet/minecraft/item/ItemStack;IIIFI)V", at = @At("HEAD"), ordinal = 2)
    private static ItemStack StormlightMod$replaceEmeraldsWithDiamondsBase3(ItemStack item)
    {
        if (item.getItem() == Items.EMERALD)
            item = new ItemStack(ModConfigs.SellMaterial, item.getCount());
        return item;
    }
}

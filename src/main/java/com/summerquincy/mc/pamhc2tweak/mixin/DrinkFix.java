package com.summerquincy.mc.pamhc2tweak.mixin;

import com.summerquincy.mc.pamhc2tweak.DrinksData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemStack.class)
public abstract class DrinkFix {

    @Inject(method = "getUseAnimation", at = @At("RETURN"), cancellable = true)
    public void inject$getUseAnimation(CallbackInfoReturnable<UseAnim> cir) {
        if ((Object) this instanceof ItemStack stack) {
            String itemKey = ForgeRegistries.ITEMS.getKey(stack.getItem()).toString();
            if (DrinksData.DRINKABLES.contains(itemKey) || DrinksData.THICKS.contains(itemKey)) {
                cir.setReturnValue(UseAnim.DRINK);
            }
        }
    }

    @Inject(method = "getDrinkingSound", at = @At("RETURN"), cancellable = true)
    public void inject$etDrinkingSound(CallbackInfoReturnable<SoundEvent> cir) {
        if ((Object) this instanceof ItemStack stack) {
            String itemKey = ForgeRegistries.ITEMS.getKey(stack.getItem()).toString();
            if (DrinksData.THICKS.contains(itemKey)) {
                cir.setReturnValue(SoundEvents.HONEY_DRINK);
            }
        }
    }
}


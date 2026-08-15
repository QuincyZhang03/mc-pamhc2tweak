package com.summerquincy.mc.pamhc2tweak;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class HoneyMuffinFix {
    public static final RegistryObject<Item> ITEM_CHOCOLATEMUFFIN = PamHC2TweakMod.APPEND_ITEMS.register("honeymuffinitem",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(isPamHCNerfLoaded() ? 4 : 8).saturationMod(1.2f).build())));

    public static boolean isPamHCNerfLoaded() {
        return ModList.get().isLoaded("hc2nerf");
    }

    public static void init(){}
}

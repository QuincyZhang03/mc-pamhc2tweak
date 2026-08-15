package com.summerquincy.mc.pamhc2tweak;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("unused")
public class HoneyMuffinFix {
    public static final RegistryObject<Item> ITEM_CHOCOLATEMUFFIN = getHoneyMuffinItem();

    public static RegistryObject<Item> getHoneyMuffinItem() {
        if (ModList.get().isLoaded(PamHC2TweakMod.ROOT_ID_FOODCORE)) {
            return PamHC2TweakMod.APPEND_ITEMS.register("honeymuffinitem",
                    () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(isPamHCNerfLoaded() ? 4 : 8).saturationMod(1.2f).build())));
        }
        return null;
    }

    public static boolean isPamHCNerfLoaded() {
        return ModList.get().isLoaded("hc2nerf");
    }

    @SubscribeEvent
    public static void addToCreativeTab(BuildCreativeModeTabContentsEvent e) {
        if (Objects.equals(BuiltInRegistries.CREATIVE_MODE_TAB.getKey(e.getTab()), ResourceLocation.fromNamespaceAndPath(PamHC2TweakMod.ROOT_ID_FOODCORE, "foodcore_tab")) && ITEM_CHOCOLATEMUFFIN != null) {
            var entries = e.getEntries();
            Item preceding = ForgeRegistries.ITEMS.getValue(ResourceLocation.fromNamespaceAndPath("pamhc2foodcore", "sweetberrymuffinitem"));
            if (preceding != null) {
                entries.putAfter(new ItemStack(preceding), new ItemStack(ITEM_CHOCOLATEMUFFIN.get()), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            } else {
                e.accept(ITEM_CHOCOLATEMUFFIN);
            }
        }
    }

    public static void init() {
    }
}

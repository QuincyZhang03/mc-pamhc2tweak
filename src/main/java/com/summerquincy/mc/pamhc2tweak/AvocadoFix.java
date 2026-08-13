package com.summerquincy.mc.pamhc2tweak;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AvocadoFix {

    public static RegistryObject<Item> PAMAVOCADO = ModList.get().isLoaded("pamhc2trees") ?
            PamHC2TweakMod.ITEMS.register("pamavocado", () -> {
                Block avocadoBlock = ForgeRegistries.BLOCKS.getValue(ResourceLocation.fromNamespaceAndPath("pamhc2trees", "pamavocado"));
                if (avocadoBlock != null) {
                    return new BlockItem(avocadoBlock, new Item.Properties());
                }
                return Items.AIR;
            })
            : null;


    @SubscribeEvent
    public static void addToCreativeTab(BuildCreativeModeTabContentsEvent e) {
        if (Objects.equals(BuiltInRegistries.CREATIVE_MODE_TAB.getKey(e.getTab()), ResourceLocation.fromNamespaceAndPath("pamhc2trees", "trees_tab")) && PAMAVOCADO != null) {
            e.accept(PAMAVOCADO);
        }
    }

}

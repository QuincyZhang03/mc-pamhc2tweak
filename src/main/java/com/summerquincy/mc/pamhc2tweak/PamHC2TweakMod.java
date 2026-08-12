package com.summerquincy.mc.pamhc2tweak;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PamHC2TweakMod.MODID)
public class PamHC2TweakMod {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "pamhc2tweak";
    // Directly reference a slf4j logger

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);


    @SuppressWarnings("unused")
    private static final Logger LOGGER = LogUtils.getLogger();

    public PamHC2TweakMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        ITEMS.register(modEventBus);
    }
}

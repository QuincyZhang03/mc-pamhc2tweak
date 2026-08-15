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

@Mod(PamHC2TweakMod.MODID)
public class PamHC2TweakMod {
    public static final String MODID = "pamhc2tweak";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<Item> APPEND_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "pamhc2foodcore");
    @SuppressWarnings("unused")
    public static final Logger LOGGER = LogUtils.getLogger();

    public PamHC2TweakMod(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        AvocadoFix.init();
        HoneyMuffinFix.init();
        ITEMS.register(modEventBus);
        APPEND_ITEMS.register(modEventBus);
    }
}

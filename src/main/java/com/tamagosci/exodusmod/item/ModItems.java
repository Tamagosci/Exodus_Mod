package com.tamagosci.exodusmod.item;

import com.tamagosci.exodusmod.ModCreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.tamagosci.exodusmod.ExodusMod;

public class ModItems {
   public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExodusMod.MOD_ID);

   public static final RegistryObject<Item> ZIRCON = ITEMS.register("zircon",() -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXODUS_TAB)));

   public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_zircon",() -> new Item(new Item.Properties().tab(ModCreativeModeTab.EXODUS_TAB)));

   public static void register(IEventBus eventBus) {
      ITEMS.register(eventBus);
   }
}
package com.tamagosci.exodusmod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
   public static final CreativeModeTab EXODUS_TAB = new CreativeModeTab("exodus_tab") {
      @Override
      public ItemStack makeIcon() {
         return new ItemStack(ModItems.ZIRCON.get());
      }
   };
}
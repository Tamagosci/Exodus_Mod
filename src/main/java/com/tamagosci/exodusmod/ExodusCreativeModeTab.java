package com.tamagosci.exodusmod;

import com.tamagosci.exodusmod.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ExodusCreativeModeTab {
   public static final CreativeModeTab EXODUS_TAB = new CreativeModeTab("exodus_tab") {
      @Override
      public ItemStack makeIcon() {
         return new ItemStack(ModItems.ZIRCON.get());
      }
   };
}
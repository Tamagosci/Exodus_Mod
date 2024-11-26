package com.tamagosci.exodusmod.event;

import com.tamagosci.exodusmod.ExodusMod;
import com.tamagosci.exodusmod.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
	// Handle Key presses
	@Mod.EventBusSubscriber(modid = ExodusMod.MOD_ID, value = Dist.CLIENT)
	public static class ClientForgeEvents {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.Key event) {
			if(KeyBinding.OPEN_MENU_KEY.consumeClick()) {
				Minecraft.getInstance().player.sendSystemMessage(Component.literal("This is a client-side message"));
			}
		}
	}

	// Register Keybindings in the options menu
	@Mod.EventBusSubscriber(modid = ExodusMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class ClientModBusEvents {
		@SubscribeEvent
		public static void onKeyRegister(RegisterKeyMappingsEvent event) {
			event.register(KeyBinding.OPEN_MENU_KEY);
		}
	}
}
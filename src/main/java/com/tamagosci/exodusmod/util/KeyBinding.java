package com.tamagosci.exodusmod.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {
	public static final String KEY_EXODUS_CATEGORY = "key.category.exodus.exodus_mod";
	public static final String KEY_NAME_OPEN_MENU = "key.exodus.open_menu";

	public static final KeyMapping OPEN_MENU_KEY = new KeyMapping(
		KEY_NAME_OPEN_MENU,
		KeyConflictContext.IN_GAME,
		InputConstants.Type.KEYSYM,
		GLFW.GLFW_KEY_HOME,
		KEY_EXODUS_CATEGORY
	);
}
package com.tamagosci.exodusmod.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.concurrent.ThreadLocalRandom;

public class EightBallItem extends Item {
	public EightBallItem(Properties pProperties) {
		super(pProperties);
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
		if(!pLevel.isClientSide() && pUsedHand == InteractionHand.MAIN_HAND){
			// Output a random number
			int randomInt = ThreadLocalRandom.current().nextInt(10);
			pPlayer.sendSystemMessage(Component.literal("Your number is " + randomInt));
			// Set a cooldown
			pPlayer.getCooldowns().addCooldown(this, 100);
		}
		return super.use(pLevel, pPlayer, pUsedHand);
	}

	private int getRandomNumber() {
		return RandomSource.createNewThreadLocalInstance().nextInt(10);
	}
}
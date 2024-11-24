package com.tamagosci.exodusmod.block.custom;

import it.unimi.dsi.fastutil.booleans.BooleanPredicate;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;

public class ZirconLampBlock extends Block {
	public static final BooleanProperty LIT = BooleanProperty.create("lit"); //<-- This in blockstate

	public ZirconLampBlock(Properties pProperties) {
		super(pProperties);
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
		pBuilder.add(LIT);
		super.createBlockStateDefinition(pBuilder);
	}

	@Override
	public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {
		if (!pLevel.isClientSide && pHand == InteractionHand.MAIN_HAND) {
			pLevel.setBlock(pPos, pState.cycle(LIT), 3);
		}
		return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
	}
}
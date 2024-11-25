package com.tamagosci.exodusmod.block;

import com.tamagosci.exodusmod.ExodusCreativeModeTab;
import com.tamagosci.exodusmod.ExodusMod;
import com.tamagosci.exodusmod.block.custom.JumpyBlock;
import com.tamagosci.exodusmod.block.custom.ZirconLampBlock;
import com.tamagosci.exodusmod.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
		ForgeRegistries.BLOCKS,
		ExodusMod.MOD_ID
	);

	private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab)
	{
		RegistryObject<T> blockRegistry = BLOCKS.register(name, block);
		registerBlockItem(name, blockRegistry, tab);
		return blockRegistry;
	}

	private static <T extends Block> RegistryObject<Item> registerBlockItem(
		String name,
		RegistryObject<T> block,
		CreativeModeTab tab
	)
	{
		return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}

	public static void register(IEventBus eventBus) {
		BLOCKS.register(eventBus);
	}

	//
	// Actual Blocks
	//

	public static final RegistryObject<Block> ZIRCON_BLOCK = registerBlock(
		"zircon_block",
		() -> new Block(BlockBehaviour.Properties.of(Material.STONE)
															  .strength(4f)
															  .requiresCorrectToolForDrops()),
		ExodusCreativeModeTab.EXODUS_TAB
	);
	public static final RegistryObject<Block> ZIRCON_ORE = registerBlock(
		"zircon_ore", () -> new DropExperienceBlock(
			BlockBehaviour.Properties.of(Material.STONE)
											 .strength(5f)
											 .requiresCorrectToolForDrops(), UniformInt.of(3, 7)),
		ExodusCreativeModeTab.EXODUS_TAB
	);
	public static final RegistryObject<Block> DEEPSLATE_ZIRCON_ORE = registerBlock(
		"deepslate_zircon_ore", () -> new DropExperienceBlock(
			BlockBehaviour.Properties.of(Material.STONE)
											 .strength(6f)
											 .requiresCorrectToolForDrops(), UniformInt.of(3, 7)),
		 ExodusCreativeModeTab.EXODUS_TAB
	);

	public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock(
		"jumpy_block",
		() -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE)
																	 .strength(3f)),
		ExodusCreativeModeTab.EXODUS_TAB
	);

	public static final RegistryObject<Block> ZIRCON_LAMP = registerBlock(
		"zircon_lamp",
		() -> new ZirconLampBlock(BlockBehaviour.Properties.of(Material.STONE)
																			.strength(3f)
																			.lightLevel(state -> state.getValue(ZirconLampBlock.LIT) ? 15 : 0)),
		ExodusCreativeModeTab.EXODUS_TAB
	);
}
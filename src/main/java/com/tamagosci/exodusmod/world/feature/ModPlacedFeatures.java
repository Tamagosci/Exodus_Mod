package com.tamagosci.exodusmod.world.feature;

import com.tamagosci.exodusmod.ExodusMod;
import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class ModPlacedFeatures {
	public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
		DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, ExodusMod.MOD_ID);

	// The following 3 helper methods come from vanilla ore placement
	public static List<PlacementModifier> orePlacement(PlacementModifier placementModifier1, PlacementModifier placementModifier2) {
		return List.of(placementModifier1, InSquarePlacement.spread(), placementModifier2, BiomeFilter.biome());
	}
	public static List<PlacementModifier> commonOrePlacement(int veinsPerChunk, PlacementModifier placementModifier) {
		return orePlacement(CountPlacement.of(veinsPerChunk), placementModifier);
	}
	public static List<PlacementModifier> rareOrePlacement(int chunksPerVein, PlacementModifier placementModifier) {
		return orePlacement(RarityFilter.onAverageOnceEvery(chunksPerVein), placementModifier);
	}

	public static final RegistryObject<PlacedFeature> ZIRCON_ORE_PLACED = PLACED_FEATURES.register(
		"zircon_ore_placed",
		() -> new PlacedFeature(
			ModConfiguredFeatures.ZIRCON_ORE.getHolder().get(),
			commonOrePlacement(
				7,
				HeightRangePlacement.triangle(
					VerticalAnchor.aboveBottom(-80),
					VerticalAnchor.aboveBottom(80)
				)
			)
		)
	);

	public static void register(IEventBus eventBus) {
		PLACED_FEATURES.register(eventBus);
	}
}
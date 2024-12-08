package net.brocker.unforgivingmaze.datagen;

import net.brocker.unforgivingmaze.block.BlockSet;
import net.brocker.unforgivingmaze.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    private void configureBlockSet(RegistryWrapper.WrapperLookup wrapperLookup, BlockSet blockSet) {
        blockSet.FENCE.ifPresent(block -> getOrCreateTagBuilder(BlockTags.FENCES).add(block));
        blockSet.FENCE_GATE.ifPresent(block -> getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(block));
        blockSet.WALL.ifPresent(block -> getOrCreateTagBuilder(BlockTags.WALLS).add(block));
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        configureBlockSet(wrapperLookup, ModBlocks.FADED_MARBLE);
        configureBlockSet(wrapperLookup, ModBlocks.FADED_MARBLE_BRICKS);
    }
}

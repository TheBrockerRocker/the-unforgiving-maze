package net.brocker.unforgivingmaze.datagen;

import net.brocker.unforgivingmaze.TheUnforgivingMaze;
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

        TheUnforgivingMaze.LOGGER.info("Configured tags for " + blockSet.NAME + " blockset");
    }
    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        configureBlockSet(wrapperLookup, ModBlocks.FADED_MARBLE);
        configureBlockSet(wrapperLookup, ModBlocks.FADED_MARBLE_BRICKS);

        configureBlockSet(wrapperLookup, ModBlocks.YELLOW_STONE);

        configureBlockSet(wrapperLookup, ModBlocks.PLAIN_STONE);

        configureBlockSet(wrapperLookup, ModBlocks.PLAIN_STONE_BRICKS);
        configureBlockSet(wrapperLookup, ModBlocks.MOSSY_PLAIN_STONE_BRICKS);
        configureBlockSet(wrapperLookup, ModBlocks.CRACKED_PLAIN_STONE_BRICKS);

        configureBlockSet(wrapperLookup, ModBlocks.DARK_STONE);

        configureBlockSet(wrapperLookup, ModBlocks.DARK_STONE_BRICKS);
        configureBlockSet(wrapperLookup, ModBlocks.MOSSY_DARK_STONE_BRICKS);
        configureBlockSet(wrapperLookup, ModBlocks.CRACKED_DARK_STONE_BRICKS);

        TheUnforgivingMaze.LOGGER.info("Configured block tags");
    }
}

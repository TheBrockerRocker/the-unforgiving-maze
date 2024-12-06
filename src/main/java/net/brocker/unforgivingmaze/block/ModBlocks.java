package net.brocker.unforgivingmaze.block;

import net.brocker.unforgivingmaze.TheUnforgivingMaze;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block FADED_MARBLE = registerBlock("faded_marble",
            new Block(AbstractBlock.Settings.create().strength(-1f, 3600f).requiresTool().sounds(BlockSoundGroup.TUFF)));
    public static final Block FADED_MARBLE_BRICKS = registerBlock("faded_marble_bricks",
            new Block(AbstractBlock.Settings.create().strength(-1f).requiresTool().sounds(BlockSoundGroup.TUFF)));

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(TheUnforgivingMaze.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TheUnforgivingMaze.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TheUnforgivingMaze.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
            TheUnforgivingMaze.LOGGER.info("Registering Mod Blocks for " + TheUnforgivingMaze.MOD_ID);
    }
}

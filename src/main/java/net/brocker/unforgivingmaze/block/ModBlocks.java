package net.brocker.unforgivingmaze.block;

import net.brocker.unforgivingmaze.TheUnforgivingMaze;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block FADED_MARBLE = register(
            AbstractBlock.Settings.create()
                    .strength(-1f, 3600f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.TUFF)
            ,
            "faded_marble",
            true
    );
    public static final Block FADED_MARBLE_BRICKS = register(
            AbstractBlock.Settings.create()
                    .strength(-1f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.TUFF)
            ,
            "faded_marble_bricks",
            true
    );

    private static Block register(AbstractBlock.Settings blockSettings, String name, boolean shouldRegisterItem) {
        // Register the block and its item.
        Identifier id = Identifier.of(TheUnforgivingMaze.MOD_ID, name);
        // Required in 1.21.2+
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id);
        // Create the block
        final Block block = new Block(blockSettings.registryKey(key));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings()
                    .useBlockPrefixedTranslationKey()
                    .registryKey(itemKey));
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }
    public static void registerModBlocks() {
            TheUnforgivingMaze.LOGGER.info("Registering Mod Blocks for " + TheUnforgivingMaze.MOD_ID);
    }
}

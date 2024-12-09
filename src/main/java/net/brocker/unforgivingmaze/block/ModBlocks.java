package net.brocker.unforgivingmaze.block;

import net.brocker.unforgivingmaze.TheUnforgivingMaze;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final BlockSet FADED_MARBLE = new BlockSet(
            "faded_marble",
            AbstractBlock.Settings.create()
                    // -1f hardness means the block can't be broken or moved,
                    // having a resistance of 6 means it can be destroyed by explosions
                    .strength(-1f, 6)
                    .requiresTool()
                    .sounds(BlockSoundGroup.TUFF)
    )
            .addStairs()
            .addSlab()
            .addWall()
            .addPressurePlate(BlockSetType.IRON)
            .addButton(BlockSetType.IRON, 20);
    public static final BlockSet FADED_MARBLE_BRICKS = new BlockSet(
            "faded_marble_bricks",
            AbstractBlock.Settings.create()
                    // We set the hardness really high because blocks with a hardness of -1f can not be moved
                    .strength(6000000.0F, 6000000.0F)
                    .requiresTool()
                    .pistonBehavior(PistonBehavior.PUSH_ONLY)
                    .sounds(BlockSoundGroup.TUFF)
    )
            .addStairs()
            .addSlab()
            .addWall()
            .addPressurePlate(BlockSetType.IRON)
            .addButton(BlockSetType.IRON, 20);
    public static final BlockSet YELLOW_STONE = new BlockSet(
            "yellow_stone",
            AbstractBlock.Settings.create()
                    // Low hardness so the player can break it but high resistance
                    // so explosions can't destroy it
                    .strength(2f, 6000000.0F)
                    .requiresTool()
                    .pistonBehavior(PistonBehavior.BLOCK)
                    .sounds(BlockSoundGroup.STONE)
    )
            .addStairs()
            .addSlab()
            .addWall()
            .addPressurePlate(BlockSetType.IRON)
            .addButton(BlockSetType.IRON, 20);
    public static final BlockSet PLAIN_STONE = new BlockSet(
            "plain_stone",
            AbstractBlock.Settings.create()
                    .strength(-1f, 3600f)
                    .requiresTool()
                    .pistonBehavior(PistonBehavior.BLOCK)
                    .sounds(BlockSoundGroup.STONE)
    )
            .addChiseled()
            .addStairs()
            .addSlab()
            .addWall()
            .addPressurePlate(BlockSetType.IRON)
            .addButton(BlockSetType.IRON, 20);
    public static final BlockSet PLAIN_STONE_BRICKS = new BlockSet(
            "plain_stone_bricks",
            AbstractBlock.Settings.create()
                    .strength(-1f, 3600f)
                    .requiresTool()
                    .pistonBehavior(PistonBehavior.BLOCK)
                    .sounds(BlockSoundGroup.STONE)
    )
            .addStairs()
            .addSlab()
            .addWall();
    public static final BlockSet MOSSY_PLAIN_STONE_BRICKS = new BlockSet(
            "mossy_plain_stone_bricks",
            AbstractBlock.Settings.create()
                    .strength(-1f, 3600f)
                    .requiresTool()
                    .pistonBehavior(PistonBehavior.BLOCK)
                    .sounds(BlockSoundGroup.STONE)
    )
            .addStairs()
            .addSlab()
            .addWall();
    public static final BlockSet CRACKED_PLAIN_STONE_BRICKS = new BlockSet(
            "cracked_plain_stone_bricks",
            AbstractBlock.Settings.create()
                    .strength(-1f, 3600f)
                    .requiresTool()
                    .pistonBehavior(PistonBehavior.BLOCK)
                    .sounds(BlockSoundGroup.STONE)
    )
            .addStairs()
            .addSlab()
            .addWall();
    public static final BlockSet DARK_STONE = new BlockSet(
            "dark_stone",
            AbstractBlock.Settings.create()
                    .strength(-1f, 3600f)
                    .requiresTool()
                    .pistonBehavior(PistonBehavior.BLOCK)
                    .sounds(BlockSoundGroup.STONE)
    )
            .addChiseled()
            .addStairs()
            .addSlab()
            .addWall()
            .addPressurePlate(BlockSetType.IRON)
            .addButton(BlockSetType.IRON, 20);
    public static final BlockSet DARK_STONE_BRICKS = new BlockSet(
            "dark_stone_bricks",
            AbstractBlock.Settings.create()
                    .strength(-1f, 3600f)
                    .requiresTool()
                    .pistonBehavior(PistonBehavior.BLOCK)
                    .sounds(BlockSoundGroup.STONE)
    )
            .addStairs()
            .addSlab()
            .addWall();
    public static final BlockSet MOSSY_DARK_STONE_BRICKS = new BlockSet(
            "mossy_dark_stone_bricks",
            AbstractBlock.Settings.create()
                    .strength(-1f, 3600f)
                    .requiresTool()
                    .pistonBehavior(PistonBehavior.BLOCK)
                    .sounds(BlockSoundGroup.STONE)
    )
            .addStairs()
            .addSlab()
            .addWall();
    public static final BlockSet CRACKED_DARK_STONE_BRICKS = new BlockSet(
            "cracked_dark_stone_bricks",
            AbstractBlock.Settings.create()
                    .strength(-1f, 3600f)
                    .requiresTool()
                    .pistonBehavior(PistonBehavior.BLOCK)
                    .sounds(BlockSoundGroup.STONE)
    )
            .addStairs()
            .addSlab()
            .addWall();

    private static Identifier getId(String name) {
        return Identifier.of(TheUnforgivingMaze.MOD_ID, name);
    }
    private static RegistryKey<Block> getBlockRegistryKey(Identifier id) {
        return  RegistryKey.of(RegistryKeys.BLOCK, id);
    }
    private static RegistryKey<Item> getItemRegistryKey(Identifier id) {
        return  RegistryKey.of(RegistryKeys.ITEM, id);
    }
    private static Block register(Block block, Identifier id, boolean shouldRegisterItem) {
        // Register the block and its item.

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:air` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings()
                    .useBlockPrefixedTranslationKey()
                    .registryKey(
                            getItemRegistryKey(id)
                    ));
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }
    public static void registerModBlocks() {
            TheUnforgivingMaze.LOGGER.info("Registering Mod Blocks for " + TheUnforgivingMaze.MOD_ID);
    }
}

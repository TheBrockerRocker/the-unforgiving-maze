package net.brocker.unforgivingmaze.item;

import com.terraformersmc.modmenu.util.mod.Mod;
import net.brocker.unforgivingmaze.TheUnforgivingMaze;
import net.brocker.unforgivingmaze.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
	public static final ItemGroup ITEM_GROUP_GEAR = register("gear", FabricItemGroup.builder()
            .displayName(Text.translatable("item_group.unforgiving_maze.gear"))
			.icon(() -> new ItemStack(Items.DIAMOND_AXE))
            .entries((displayContext, entries) -> {
				entries.add(Items.DIAMOND_AXE);
            })
            .build());
    public static final ItemGroup ITEM_GROUP_BLOCKS = register("blocks", FabricItemGroup.builder()
            .displayName(Text.translatable("item_group.unforgiving_maze.blocks"))
			.icon(() -> new ItemStack(ModBlocks.FADED_MARBLE_BRICKS.BLOCK.asItem()))
            .entries((displayContext, entries) -> {
				ModBlocks.FADED_MARBLE.addToItemGroup(entries);
				ModBlocks.FADED_MARBLE_BRICKS.addToItemGroup(entries);
				ModBlocks.YELLOW_STONE.addToItemGroup(entries);
				ModBlocks.PLAIN_STONE.addToItemGroup(entries);
				ModBlocks.PLAIN_STONE_BRICKS.addToItemGroup(entries);
				ModBlocks.CRACKED_PLAIN_STONE_BRICKS.addToItemGroup(entries);
				ModBlocks.MOSSY_PLAIN_STONE_BRICKS.addToItemGroup(entries);
				ModBlocks.DARK_STONE.addToItemGroup(entries);
				ModBlocks.DARK_STONE_BRICKS.addToItemGroup(entries);
				ModBlocks.CRACKED_DARK_STONE_BRICKS.addToItemGroup(entries);
				ModBlocks.MOSSY_DARK_STONE_BRICKS.addToItemGroup(entries);
            })
            .build());
    public static final ItemGroup ITEM_GROUP_ITEMS = register("items", FabricItemGroup.builder()
            .displayName(Text.translatable("item_group.unforgiving_maze.items"))
			.icon(() -> new ItemStack(ModItems.T1_BOSS_TICKET))
            .entries((displayContext, entries) -> {
				entries.add(ModItems.BADGE);
				entries.add(ModItems.T1_BOSS_TICKET);
				entries.add(ModItems.T1_MOB_TICKET);
            })
            .build());

	private static ItemGroup register(String name, ItemGroup itemGroup) {
		return Registry.register(Registries.ITEM_GROUP, Identifier.of(TheUnforgivingMaze.MOD_ID, name), itemGroup);
	}
	public static void registerItemGroups() {
		TheUnforgivingMaze.LOGGER.info("Registering Item Groups for " + TheUnforgivingMaze.MOD_ID);
	}
}

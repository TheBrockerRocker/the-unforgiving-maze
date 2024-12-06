package net.brocker.unforgivingmaze.item;

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
            .displayName(Text.translatable("itemGroup.unforgiving_maze.gear"))
			.icon(() -> new ItemStack(Items.DIAMOND_AXE))
            .entries((displayContext, entries) -> {
				entries.add(Items.DIAMOND_AXE);
            })
            .build());
    public static final ItemGroup ITEM_GROUP_BLOCKS = register("blocks", FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.unforgiving_maze.blocks"))
			.icon(() -> new ItemStack(ModBlocks.FADED_MARBLE_BRICKS.asItem()))
            .entries((displayContext, entries) -> {
				entries.add(ModBlocks.FADED_MARBLE);
				entries.add(ModBlocks.FADED_MARBLE_BRICKS);
            })
            .build());
    public static final ItemGroup ITEM_GROUP_ITEMS = register("items", FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.unforgiving_maze.items"))
			.icon(() -> new ItemStack(Items.DIAMOND))
            .entries((displayContext, entries) -> {
				entries.add(Items.DIAMOND);
            })
            .build());

	private static ItemGroup register(String name, ItemGroup itemGroup) {
		return Registry.register(Registries.ITEM_GROUP, Identifier.of(TheUnforgivingMaze.MOD_ID, name), itemGroup);
	}
	public static void registerItemGroups() {
		TheUnforgivingMaze.LOGGER.info("Registering Item Groups for " + TheUnforgivingMaze.MOD_ID);
	}
}

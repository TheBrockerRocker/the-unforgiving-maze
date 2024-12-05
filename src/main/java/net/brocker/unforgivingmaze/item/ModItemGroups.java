package net.brocker.unforgivingmaze.item;

import net.brocker.unforgivingmaze.TheUnforgivingMaze;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
	private static ItemGroup registerItemGroup(String name, ItemGroup itemGroup) {
		return Registry.register(Registries.ITEM_GROUP, Identifier.of(TheUnforgivingMaze.MOD_ID, name), itemGroup);
	}

	// The icons and entries are temporary and will be removed when we add our own items.
	// Without the icon and entries the groups will not appear.
	public static final ItemGroup ITEM_GROUP_GEAR = registerItemGroup("gear", FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.unforgivingMaze.gear"))
			.icon(() -> new ItemStack(Items.DIAMOND_AXE))
            .entries((displayContext, entries) -> {
				entries.add(Items.DIAMOND_AXE);
            })
            .build());
    public static final ItemGroup ITEM_GROUP_BLOCKS = registerItemGroup("blocks", FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.unforgivingMaze.blocks"))
			.icon(() -> new ItemStack(Items.DIAMOND_BLOCK))
            .entries((displayContext, entries) -> {
				entries.add(Items.DIAMOND_BLOCK);
            })
            .build());
    public static final ItemGroup ITEM_GROUP_ITEMS = registerItemGroup("items", FabricItemGroup.builder()
            .displayName(Text.translatable("itemGroup.unforgivingMaze.items"))
			.icon(() -> new ItemStack(Items.DIAMOND))
            .entries((displayContext, entries) -> {
				entries.add(Items.DIAMOND);
            })
            .build());

	public static void registerItemGroups() {
		TheUnforgivingMaze.LOGGER.info("Registering Item Groups for " + TheUnforgivingMaze.MOD_ID);
	}
}

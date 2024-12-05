package net.brocker.unforgivingmaze.item;

import net.brocker.unforgivingmaze.TheUnforgivingMaze;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TheUnforgivingMaze.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TheUnforgivingMaze.LOGGER.info("registering mod items for " + TheUnforgivingMaze.MOD_ID);
    }
}

package net.brocker.unforgivingmaze;

import net.brocker.unforgivingmaze.block.ModBlocks;
import net.brocker.unforgivingmaze.config.ModConfig;
import net.brocker.unforgivingmaze.item.ModItemGroups;
import net.brocker.unforgivingmaze.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheUnforgivingMaze implements ModInitializer {
	public static final String MOD_ID = "unforgiving_maze";
	public static final Logger LOGGER = LoggerFactory.getLogger("Unforgiving Maze");

	@Override
	public void onInitialize() {
		ModConfig.initialize();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModItemGroups.registerItemGroups();

		// Save config on game close
		Runtime.getRuntime().addShutdownHook(new Thread(ModConfig.HANDLER::save));
	}
}
package net.brocker.unforgivingmaze;

import net.brocker.unforgivingmaze.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TheUnforgivingMaze implements ModInitializer {
	public static final String MOD_ID = "unforgiving-maze";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}
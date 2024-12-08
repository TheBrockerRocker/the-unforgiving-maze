package net.brocker.unforgivingmaze.config;

import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.SerialEntry;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.brocker.unforgivingmaze.TheUnforgivingMaze;
import net.fabricmc.loader.api.FabricLoader;
public class ModConfig {
	public static final ConfigClassHandler<ModConfig> HANDLER = ConfigClassHandler.createBuilder(ModConfig.class)
			.serializer(config -> GsonConfigSerializerBuilder.create(config)
					.setPath(FabricLoader.getInstance().getConfigDir().resolve(TheUnforgivingMaze.MOD_ID + ".json5"))
					.setJson5(true)
					.build())
			.build();

	@SerialEntry(comment = "Whether or not shrines should spawn. When disabled you can only access dungeons via a command.")
	public boolean shouldShrinesSpawn = true;

	public static void initialize() {
		TheUnforgivingMaze.LOGGER.info("Loading Config");
		ModConfig.HANDLER.load();

		TheUnforgivingMaze.LOGGER.info("shouldShrinesSpawn " + ModConfig.HANDLER.instance().shouldShrinesSpawn);
	}
}

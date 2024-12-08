package net.brocker.unforgivingmaze.config;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import dev.isxander.yacl3.api.*;
import dev.isxander.yacl3.api.controller.TickBoxControllerBuilder;
import net.minecraft.text.Text;

public class ModMenuIntegration implements ModMenuApi {
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		final ModConfig defaults = ModConfig.HANDLER.defaults();
		final ModConfig config = ModConfig.HANDLER.instance();

		return parentScreen -> YetAnotherConfigLib.createBuilder()
				.title(Text.literal("The Unforgiving Maze Mod Configuration"))
				.category(ConfigCategory.createBuilder()
						.name(Text.literal("Shrines"))
						.tooltip(Text.literal("Shrine configuration, used to open portals to dungeons."))
						.group(OptionGroup.createBuilder()
								.name(Text.literal("Spawning"))
								.description(OptionDescription.of(Text.literal("Structure spawns")))
								.option(Option.<Boolean>createBuilder()
										.name(Text.literal("Should spawn"))
										.description(OptionDescription.of(Text.literal("Whether or not shrines should spawn. When disabled you can only access dungeons via a command.")))
										.binding(
												defaults.shouldShrinesSpawn,
												() -> config.shouldShrinesSpawn,
												value -> config.shouldShrinesSpawn = value
										)
										.controller(TickBoxControllerBuilder::create)
										.build())
								.build())
						.build())
				.save(ModConfig.HANDLER::save)
				.build()
				.generateScreen(parentScreen);
	}
}
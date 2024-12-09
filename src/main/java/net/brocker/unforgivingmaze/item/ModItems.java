package net.brocker.unforgivingmaze.item;

import net.brocker.unforgivingmaze.TheUnforgivingMaze;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item T1_MOB_TICKET = register(
            new Item(
                    new Item.Settings()
                            .registryKey(
                                    getItemRegistryKey(getId("t1_mob_ticket"))
                            )
            ),
            getId("t1_mob_ticket")
    );
    public static final Item T1_BOSS_TICKET = register(
            new Item(
                    new Item.Settings()
                            .registryKey(
                                    getItemRegistryKey(getId("t1_boss_ticket"))
                            )
            ),
            getId("t1_boss_ticket")
    );
    public static final Item BADGE = register(
            new Item(
                    new Item.Settings()
                            .registryKey(
                                    getItemRegistryKey(getId("badge"))
                            )
            ),
            getId("badge")
    );

    private static Identifier getId(String name) {
        return Identifier.of(TheUnforgivingMaze.MOD_ID, name);
    }
    private static RegistryKey<Item> getItemRegistryKey(Identifier id) {
        return  RegistryKey.of(RegistryKeys.ITEM, id);
    }
    private static Item register(Item item, Identifier id) {
        return Registry.register(Registries.ITEM, id, item);
    }

    public static void registerModItems() {
        TheUnforgivingMaze.LOGGER.info("Registering Mod Items for " + TheUnforgivingMaze.MOD_ID);
    }
}

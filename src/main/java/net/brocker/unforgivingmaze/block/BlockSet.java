package net.brocker.unforgivingmaze.block;

import net.brocker.unforgivingmaze.TheUnforgivingMaze;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class BlockSet {
	public final String NAME;
	private final AbstractBlock.Settings DEFAULT_SETTINGS;
	public Block BLOCK;
	public Optional<Block> CHISELED = Optional.empty();
	public Optional<Block> STAIR = Optional.empty();
	public Optional<Block> SLAB = Optional.empty();
	public Optional<Block> BUTTON = Optional.empty();
	public Optional<Block> PRESSURE_PLATE = Optional.empty();
	public Optional<Block> FENCE = Optional.empty();
	public Optional<Block> FENCE_GATE = Optional.empty();
	public Optional<Block> WALL = Optional.empty();
	public Optional<Block> DOOR = Optional.empty();
	public Optional<Block> TRAPDOOR = Optional.empty();

	public BlockSet(String name, AbstractBlock.Settings settings) {
		this.NAME = name;
		this.DEFAULT_SETTINGS = settings;

		final Identifier id = this.getId(this.NAME);
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		this.BLOCK = this.register(
				new Block(
						settings.registryKey(registryKey)
				), id
		);
	}
	public BlockSet addChiseled() {
		final Identifier id = this.getId("chiseled_" + this.NAME);
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = this.DEFAULT_SETTINGS.registryKey(registryKey);
		this.CHISELED = Optional.of(
				this.register(new Block(blockSettings), id)
		);
		return this;
	}
	public BlockSet addChiseled(AbstractBlock.Settings settings) {
		final Identifier id = this.getId("chiseled_" + this.NAME);
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = settings.registryKey(registryKey);
		this.CHISELED = Optional.of(
				this.register(new Block(blockSettings), id)
		);
		return this;
	}
	public BlockSet addStairs() {
		final Identifier id = this.getId(this.NAME + "_stairs");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = this.DEFAULT_SETTINGS.registryKey(registryKey);
		this.STAIR = Optional.of(
				this.register(new StairsBlock(this.BLOCK.getDefaultState(), blockSettings), id)
		);
		return this;
	}
	public BlockSet addStairs(AbstractBlock.Settings settings) {
		final Identifier id = this.getId(this.NAME + "_stairs");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = settings.registryKey(registryKey);
		this.STAIR = Optional.of(
				this.register(new StairsBlock(this.BLOCK.getDefaultState(), blockSettings), id)
		);
		return this;
	}
	public BlockSet addSlab() {
		final Identifier id = this.getId(this.NAME + "_slab");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = this.DEFAULT_SETTINGS.registryKey(registryKey);
		this.SLAB = Optional.of(
				this.register(new SlabBlock(blockSettings), id)
		);
		return this;
	}
	public BlockSet addSlab(AbstractBlock.Settings settings) {
		final Identifier id = this.getId(this.NAME + "_slab");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = settings.registryKey(registryKey);
		this.SLAB = Optional.of(
				this.register(new SlabBlock(blockSettings), id)
		);
		return this;

	}
	public BlockSet addButton(BlockSetType blockSetType, int pressTicks) {
		final Identifier id = this.getId(this.NAME + "_button");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = this.DEFAULT_SETTINGS.noCollision().registryKey(registryKey);
		this.BUTTON = Optional.of(
				this.register(new ButtonBlock(blockSetType, pressTicks, blockSettings), id)
		);
		return this;
	}
	public BlockSet addButton(BlockSetType blockSetType, int pressTicks, AbstractBlock.Settings settings) {
		final Identifier id = this.getId(this.NAME + "_button");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = settings.noCollision().registryKey(registryKey);
		this.BUTTON = Optional.of(
				this.register(new ButtonBlock(blockSetType, pressTicks, blockSettings), id)
		);
		return this;
	}
	public BlockSet addPressurePlate(BlockSetType blockSetType) {
		final Identifier id = this.getId(this.NAME + "_pressure_plate");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = this.DEFAULT_SETTINGS.registryKey(registryKey);
		this.PRESSURE_PLATE = Optional.of(
				this.register(new PressurePlateBlock(blockSetType, blockSettings), id)
		);
		return this;
	}
	public BlockSet addPressurePlate(BlockSetType blockSetType, AbstractBlock.Settings settings) {
		final Identifier id = this.getId(this.NAME + "_pressure_plate");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = settings.registryKey(registryKey);
		this.PRESSURE_PLATE = Optional.of(
				this.register(new PressurePlateBlock(blockSetType, blockSettings), id)
		);
		return this;
	}
	public BlockSet addFence() {
		final Identifier id = this.getId(this.NAME + "_fence");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = this.DEFAULT_SETTINGS.registryKey(registryKey);
		this.FENCE = Optional.of(
				this.register(new FenceBlock(blockSettings), id)
		);
		return this;
	}
	public BlockSet addFence(AbstractBlock.Settings settings) {
		final Identifier id = this.getId(this.NAME + "_fence");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = settings.registryKey(registryKey);
		this.FENCE = Optional.of(
				this.register(new FenceBlock(blockSettings), id)
		);
		return this;
	}
	public BlockSet addFenceGate(WoodType woodType) {
		final Identifier id = this.getId(this.NAME + "_fence_gate");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = this.DEFAULT_SETTINGS.registryKey(registryKey);
		this.FENCE_GATE = Optional.of(
				this.register(new FenceGateBlock(woodType, blockSettings), id)
		);
		return this;
	}
	public BlockSet addFenceGate(WoodType woodType, AbstractBlock.Settings settings) {
		final Identifier id = this.getId(this.NAME + "_fence_gate");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = settings.registryKey(registryKey);
		this.FENCE_GATE = Optional.of(
				this.register(new FenceGateBlock(woodType, blockSettings), id)
		);
		return this;
	}
	public BlockSet addWall() {
		final Identifier id = this.getId(this.NAME + "_wall");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = this.DEFAULT_SETTINGS.registryKey(registryKey);
		this.WALL = Optional.of(
				this.register(new WallBlock(blockSettings), id)
		);
		return this;
	}
	public BlockSet addWall(AbstractBlock.Settings settings) {
		final Identifier id = this.getId(this.NAME + "_wall");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = settings.registryKey(registryKey);
		this.WALL = Optional.of(
				this.register(new WallBlock(blockSettings), id)
		);
		return this;
	}
	public BlockSet addDoor(BlockSetType blockSetType) {
		final Identifier id = this.getId(this.NAME + "_door");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = this.DEFAULT_SETTINGS.nonOpaque().registryKey(registryKey);
		this.DOOR = Optional.of(
				this.register(new DoorBlock(blockSetType, blockSettings), id)
		);
		return this;
	}
	public BlockSet addDoor(BlockSetType blockSetType, AbstractBlock.Settings settings) {
		final Identifier id = this.getId(this.NAME + "_door");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = settings.nonOpaque().registryKey(registryKey);
		this.DOOR = Optional.of(
				this.register(new DoorBlock(blockSetType, blockSettings), id)
		);
		return this;
	}
	public BlockSet addTrapdoor(BlockSetType blockSetType) {
		final Identifier id = this.getId(this.NAME + "_trapdoor");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = this.DEFAULT_SETTINGS.nonOpaque().registryKey(registryKey);
		this.TRAPDOOR = Optional.of(
				this.register(new TrapdoorBlock(blockSetType, blockSettings), id)
		);
		return this;
	}
	public BlockSet addTrapdoor(BlockSetType blockSetType, AbstractBlock.Settings settings) {
		final Identifier id = this.getId(this.NAME + "_trapdoor");
		final RegistryKey<Block> registryKey = this.getBlockRegistryKey(id);
		final AbstractBlock.Settings blockSettings = settings.nonOpaque().registryKey(registryKey);
		this.TRAPDOOR = Optional.of(
				this.register(new TrapdoorBlock(blockSetType, blockSettings), id)
		);
		return this;
	}

	private Identifier getId(String name) {
		return Identifier.of(TheUnforgivingMaze.MOD_ID, name);
	}
	private RegistryKey<Block> getBlockRegistryKey(Identifier id) {
		return  RegistryKey.of(RegistryKeys.BLOCK, id);
	}
	private RegistryKey<Item> getItemRegistryKey(Identifier id) {
		return  RegistryKey.of(RegistryKeys.ITEM, id);
	}
	private Block register(Block block, Identifier id) {
		// Register the block and its item.
		BlockItem blockItem = new BlockItem(block, new Item.Settings()
				.useBlockPrefixedTranslationKey()
				.registryKey(
						this.getItemRegistryKey(id)
				));
		Registry.register(Registries.ITEM, id, blockItem);
		return Registry.register(Registries.BLOCK, id, block);
	}
	public void addToItemGroup(ItemGroup.Entries entries) {
		entries.add(this.BLOCK);
		this.CHISELED.ifPresent(entries::add);
		this.STAIR.ifPresent(entries::add);
		this.SLAB.ifPresent(entries::add);
		this.WALL.ifPresent(entries::add);
		this.FENCE.ifPresent(entries::add);
		this.FENCE_GATE.ifPresent(entries::add);
		this.DOOR.ifPresent(entries::add);
		this.TRAPDOOR.ifPresent(entries::add);
		this.PRESSURE_PLATE.ifPresent(entries::add);
		this.BUTTON.ifPresent(entries::add);
	}
}

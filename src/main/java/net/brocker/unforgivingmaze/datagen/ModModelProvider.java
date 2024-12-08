package net.brocker.unforgivingmaze.datagen;

import net.brocker.unforgivingmaze.block.BlockSet;
import net.brocker.unforgivingmaze.block.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    private void generateBlockStateModelsForBlockSet(BlockStateModelGenerator blockStateModelGenerator, BlockSet blockSet) {
        BlockStateModelGenerator.BlockTexturePool pool = blockStateModelGenerator.registerCubeAllModelTexturePool(blockSet.BLOCK);

        blockSet.STAIR.ifPresent(pool::stairs);
        blockSet.SLAB.ifPresent(pool::slab);

        blockSet.BUTTON.ifPresent(pool::button);
        blockSet.PRESSURE_PLATE.ifPresent(pool::pressurePlate);

        blockSet.FENCE.ifPresent(pool::fence);
        blockSet.FENCE_GATE.ifPresent(pool::fenceGate);

        blockSet.WALL.ifPresent(pool::wall);

        blockSet.DOOR.ifPresent(blockStateModelGenerator::registerDoor);
        blockSet.TRAPDOOR.ifPresent(blockStateModelGenerator::registerTrapdoor);
    }
    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        generateBlockStateModelsForBlockSet(blockStateModelGenerator, ModBlocks.FADED_MARBLE);
        generateBlockStateModelsForBlockSet(blockStateModelGenerator, ModBlocks.FADED_MARBLE_BRICKS);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}

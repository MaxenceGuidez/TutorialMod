package com.maxenceguidez.tutorialmod.block.entity;

import com.maxenceguidez.tutorialmod.TutorialMod;
import com.maxenceguidez.tutorialmod.block.ModBlocks;
import com.maxenceguidez.tutorialmod.block.entity.custom.GrowthChamberBlockEntity;
import com.maxenceguidez.tutorialmod.block.entity.custom.PedestalBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<PedestalBlockEntity>> PEDESTAL_BE = BLOCK_ENTITIES.register("pedestal_be", () -> new BlockEntityType<>(PedestalBlockEntity::new, Set.of(ModBlocks.PEDESTAL.get())));

    public static final RegistryObject<BlockEntityType<GrowthChamberBlockEntity>> GROWTH_CHAMBER_BE = BLOCK_ENTITIES.register("growth_chamber_be", () -> new BlockEntityType<>(GrowthChamberBlockEntity::new, Set.of(ModBlocks.GROWTH_CHAMBER.get())));

    public static void register(IEventBus event) {
        BLOCK_ENTITIES.register(event);
    }
}

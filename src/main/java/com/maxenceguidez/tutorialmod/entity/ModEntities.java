package com.maxenceguidez.tutorialmod.entity;

import com.maxenceguidez.tutorialmod.TutorialMod;
import com.maxenceguidez.tutorialmod.entity.custom.ChairEntity;
import com.maxenceguidez.tutorialmod.entity.custom.TomahawkProjectileEntity;
import com.maxenceguidez.tutorialmod.entity.custom.TriceratopsEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TutorialMod.MOD_ID);

    public static ResourceKey<EntityType<?>> TRICERATOPS_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("triceratops"));
    public static ResourceKey<EntityType<?>> TOMAHAWK_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("tomahawk"));
    public static ResourceKey<EntityType<?>> CHAIR_KEY = ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.withDefaultNamespace("chair_entity"));

    public static final RegistryObject<EntityType<TriceratopsEntity>> TRICERATOPS = ENTITY_TYPES.register("triceratops",
            () -> EntityType.Builder.of(TriceratopsEntity::new, MobCategory.CREATURE).sized(1.5f, 1.5f).build(TRICERATOPS_KEY));

    public static final RegistryObject<EntityType<TomahawkProjectileEntity>> TOMAHAWK = ENTITY_TYPES.register("tomahawk",
            () -> EntityType.Builder.<TomahawkProjectileEntity>of(TomahawkProjectileEntity::new, MobCategory.MISC).sized(.5f, 1.15f).build(TOMAHAWK_KEY));

    public static final RegistryObject<EntityType<ChairEntity>> CHAIR = ENTITY_TYPES.register("chair_entity",
            () -> EntityType.Builder.of(ChairEntity::new, MobCategory.MISC).sized(.5f, .5f).build(CHAIR_KEY));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}

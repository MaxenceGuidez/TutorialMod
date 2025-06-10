package com.maxenceguidez.tutorialmod.particle;

import com.maxenceguidez.tutorialmod.TutorialMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<SimpleParticleType> ALEXANDRITE_PARTICLES = PARTICLE_TYPES.register("alexandrite_particles", () -> new SimpleParticleType(true));

    public static void register(IEventBus event) {
        PARTICLE_TYPES.register(event);
    }
}

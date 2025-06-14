package com.maxenceguidez.tutorialmod.entity.client;

import com.maxenceguidez.tutorialmod.entity.TriceratopsVariant;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.AnimationState;

public class TriceratopsRenderState extends LivingEntityRenderState {
    public final AnimationState idleAnimationState = new AnimationState();
    public TriceratopsVariant variant;
}

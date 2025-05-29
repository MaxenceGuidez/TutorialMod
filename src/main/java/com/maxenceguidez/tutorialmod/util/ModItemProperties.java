package com.maxenceguidez.tutorialmod.util;

import com.maxenceguidez.tutorialmod.TutorialMod;
import com.maxenceguidez.tutorialmod.component.ModDataComponentTypes;
import com.maxenceguidez.tutorialmod.item.ModItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;

public class ModItemProperties {
    public static void addCustomItemProperties() {
        ItemProperties.register(ModItems.CHISEL.get(), ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "used"),
                (itemStack, clientLevel, livingEntity, i) -> itemStack.get(ModDataComponentTypes.COORDINATES.get()) != null ? 1f : 0f);
    }
}

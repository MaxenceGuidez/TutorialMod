package com.maxenceguidez.tutorialmod.item.custom;

import com.maxenceguidez.tutorialmod.block.ModBlocks;
import com.maxenceguidez.tutorialmod.component.ModDataComponentTypes;
import com.maxenceguidez.tutorialmod.particle.ModParticles;
import com.maxenceguidez.tutorialmod.sound.ModSounds;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Map;

public class ChiselItem extends Item {
    private static final Map<Block, Block> CHISEL_MAP = Map.of(
            Blocks.STONE, Blocks.STONE_BRICKS,
            Blocks.END_STONE, Blocks.END_STONE_BRICKS,
            Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
            Blocks.DIRT, ModBlocks.ALEXANDRITE_BLOCK.get()
    );

    public ChiselItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        Block clickedBlock = level.getBlockState(pContext.getClickedPos()).getBlock();

        if (CHISEL_MAP.containsKey(clickedBlock)) {
            if (!level.isClientSide()) {
                level.setBlockAndUpdate(pContext.getClickedPos(), CHISEL_MAP.get(clickedBlock).defaultBlockState());

                pContext.getItemInHand().hurtAndBreak(1, (ServerLevel) level, (ServerPlayer) pContext.getPlayer(),
                        item -> pContext.getPlayer().onEquippedItemBroken(item, EquipmentSlot.MAINHAND)
                );

                level.playSound(null, pContext.getClickedPos(), ModSounds.CHISEL_USE.get(), SoundSource.BLOCKS);

                ((ServerLevel) level).sendParticles(new BlockParticleOption(ParticleTypes.BLOCK, clickedBlock.defaultBlockState()),
                        pContext.getClickedPos().getX() + .5, pContext.getClickedPos().getY() + 1.0, pContext.getClickedPos().getZ() + .5, 10, 0, 0, 0, 1);

                ((ServerLevel) level).sendParticles(ParticleTypes.HAPPY_VILLAGER,
                        pContext.getClickedPos().getX() + .5, pContext.getClickedPos().getY() + 1.0, pContext.getClickedPos().getZ() + .5, 4, 0, 0, 0, 3);

                ((ServerLevel) level).sendParticles(ModParticles.ALEXANDRITE_PARTICLES.get(),
                        pContext.getClickedPos().getX() + .5, pContext.getClickedPos().getY() + 1.0, pContext.getClickedPos().getZ() + .5, 8, 0, 0, 0, 2);

                pContext.getItemInHand().set(ModDataComponentTypes.COORDINATES.get(), pContext.getClickedPos());
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        if (Screen.hasShiftDown()) {
            pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.chisel"));
        } else {
            pTooltipComponents.add(Component.translatable("tooltip.tutorialmod.shift"));
        }

        if (pStack.get(ModDataComponentTypes.COORDINATES.get()) != null) {
            pTooltipComponents.add(
                    Component.translatable("tooltip.tutorialmod.chisel.coordinates")
                            .append(Component.literal(String.valueOf(pStack.get(ModDataComponentTypes.COORDINATES.get()))))
            );
        }

        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}

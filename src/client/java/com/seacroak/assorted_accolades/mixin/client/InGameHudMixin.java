package com.seacroak.assorted_accolades.mixin.client;

import com.seacroak.assorted_accolades.AccoladesModClient;
import com.seacroak.assorted_accolades.block.BingoParticipantTrophy2023;
import com.seacroak.assorted_accolades.registry.MainRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.MultilineText;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.render.RenderTickCounter;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Unique
    MinecraftClient client = MinecraftClient.getInstance();

    @Inject(at = @At("TAIL"), method = "render")
    public void render(DrawContext context, RenderTickCounter tickCounter, CallbackInfo ci) throws Exception {
        if (!AccoladesModClient.trophyInteracted) return;
        if (!client.options.hudHidden && client.player != null) {
            if (AccoladesModClient.trophyInteractedIdentifier != null) {
                final MultilineText textToDisplay = MultilineText.create(client.textRenderer,
                        Text.translatable(AccoladesModClient.trophyInteractedIdentifier + "_info"),
                        client.getWindow().getScaledWidth() - 150);
                int textPosX = (client.getWindow().getScaledWidth() / 2);
                int textPosY = (client.getWindow().getScaledHeight() / 2) + 50;
                textToDisplay.drawCenterWithShadow(context, textPosX, textPosY,12,0xffdb66);
            }
        }
    }


}
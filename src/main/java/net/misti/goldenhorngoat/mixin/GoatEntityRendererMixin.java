package net.misti.goldenhorngoat.mixin;

import net.minecraft.client.renderer.entity.GoatRenderer;
import net.minecraft.client.renderer.entity.state.GoatRenderState;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.animal.goat.Goat;
import net.misti.goldenhorngoat.render.ScreamingGoatState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GoatRenderer.class)
public class GoatEntityRendererMixin {
    @Unique
    private static final Identifier SCREAMING_TEXTURE =
            Identifier.fromNamespaceAndPath("golden-horn-goat", "textures/entity/goat/screaming_goat.png");

    @Inject(
            method = "extractRenderState(Lnet/minecraft/world/entity/animal/goat/Goat;Lnet/minecraft/client/renderer/entity/state/GoatRenderState;F)V",
            at = @At("TAIL")
    )
    private void screaminggoatidentifier$copyScreamingFlag(
            Goat goat,
            GoatRenderState state,
            float tickDelta,
            CallbackInfo ci
    ) {
        ((ScreamingGoatState) state).screaminggoatidentifier$setScreaming(goat.isScreamingGoat());
    }

    @Inject(
            method = "getTextureLocation(Lnet/minecraft/client/renderer/entity/state/GoatRenderState;)Lnet/minecraft/resources/Identifier;",
            at = @At("HEAD"),
            cancellable = true
    )
    private void screaminggoatidentifier$swapTexture(
            GoatRenderState state,
            CallbackInfoReturnable<Identifier> cir
    ) {
        if (((ScreamingGoatState) state).screaminggoatidentifier$isScreaming()) {
            cir.setReturnValue(SCREAMING_TEXTURE);
        }
    }
}
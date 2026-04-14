package net.misti.goldenhorngoat.mixin;

import net.misti.goldenhorngoat.render.ScreamingGoatState;
import net.minecraft.client.render.entity.GoatEntityRenderer;
import net.minecraft.client.render.entity.state.GoatEntityRenderState;
import net.minecraft.entity.passive.GoatEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(GoatEntityRenderer.class)
public class GoatEntityRendererMixin {
    @Unique
    private static final Identifier SCREAMING_TEXTURE =
            Identifier.of("golden-horn-goat", "textures/entity/goat/screaming_goat.png");

    @Inject(
            method = "updateRenderState(Lnet/minecraft/entity/passive/GoatEntity;Lnet/minecraft/client/render/entity/state/GoatEntityRenderState;F)V",
            at = @At("TAIL")
    )
    private void screaminggoatidentifier$copyScreamingFlag(
            GoatEntity goat,
            GoatEntityRenderState state,
            float tickDelta,
            CallbackInfo ci
    ) {
        ((ScreamingGoatState) state).screaminggoatidentifier$setScreaming(goat.isScreaming());
    }

    @Inject(
            method = "getTexture(Lnet/minecraft/client/render/entity/state/GoatEntityRenderState;)Lnet/minecraft/util/Identifier;",
            at = @At("HEAD"),
            cancellable = true
    )
    private void screaminggoatidentifier$swapTexture(
            GoatEntityRenderState state,
            CallbackInfoReturnable<Identifier> cir
    ) {
        if (((ScreamingGoatState) state).screaminggoatidentifier$isScreaming()) {
            cir.setReturnValue(SCREAMING_TEXTURE);
        }
    }
}
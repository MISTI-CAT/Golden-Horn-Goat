package net.misti.goldenhorngoat.mixin;

import net.misti.goldenhorngoat.render.ScreamingGoatState;
import net.minecraft.client.render.entity.state.GoatEntityRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(GoatEntityRenderState.class)
public class GoatEntityRenderStateMixin implements ScreamingGoatState {
    @Unique
    private boolean screaminggoatidentifier$screaming;

    @Override
    public boolean screaminggoatidentifier$isScreaming() {
        return this.screaminggoatidentifier$screaming;
    }

    @Override
    public void screaminggoatidentifier$setScreaming(boolean screaming) {
        this.screaminggoatidentifier$screaming = screaming;
    }
}
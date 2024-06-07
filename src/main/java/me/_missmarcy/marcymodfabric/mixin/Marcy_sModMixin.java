package me._missmarcy.marcymodfabric.mixin;

import me._missmarcy.marcymodfabric.Marcy_sMod;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class Marcy_sModMixin {

    @Inject(at = @At("HEAD"), method = "init()V")
    private void init(CallbackInfo info) { Marcy_sMod.LOGGER.info("This line is printed by an example mod mixin!");}
}

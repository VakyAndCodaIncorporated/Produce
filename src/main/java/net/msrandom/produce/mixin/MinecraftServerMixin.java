package net.msrandom.produce.mixin;

import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.datafixers.DataFixer;
import net.minecraft.resources.DataPackRegistries;
import net.minecraft.resources.ResourcePackList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerProfileCache;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.chunk.listener.IChunkStatusListenerFactory;
import net.minecraft.world.storage.IServerConfiguration;
import net.minecraft.world.storage.SaveFormat;
import net.msrandom.produce.ProduceMod;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.net.Proxy;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Inject(method = "<init>", at = @At("TAIL"))
    private void construct(Thread serverThread, DynamicRegistries.Impl p_i232576_2_, SaveFormat.LevelSave anvilConverterForAnvilFile, IServerConfiguration p_i232576_4_, ResourcePackList dataPacks, Proxy serverProxy, DataFixer dataFixer, DataPackRegistries dataRegistries, MinecraftSessionService sessionService, GameProfileRepository profileRepo, PlayerProfileCache profileCache, IChunkStatusListenerFactory chunkStatusListenerFactory, CallbackInfo ci) {
        ProduceMod.server = (MinecraftServer) (Object) this;
    }
}
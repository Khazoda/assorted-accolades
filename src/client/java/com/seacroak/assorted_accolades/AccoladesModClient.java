package com.seacroak.assorted_accolades;

import com.seacroak.assorted_accolades.block.BaseTrophy;
import com.seacroak.assorted_accolades.registry.MainRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.ActionResult;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class AccoladesModClient implements ClientModInitializer {

	ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
	private static ScheduledFuture<?> future = null;
	public static boolean trophyInteracted = false;
	public static String trophyInteractedIdentifier = null;

	@Override
	public void onInitializeClient() {
		BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.BASE_TROPHY, RenderLayer.getCutoutMipped());
		BlockRenderLayerMap.INSTANCE.putBlock(MainRegistry.BINGO_COMPLETIONIST_TROPHY_2023, RenderLayer.getCutoutMipped());

		UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
			MinecraftClient client = MinecraftClient.getInstance();
			assert client.world != null;
			Block block = client.world.getBlockState(hitResult.getBlockPos()).getBlock();
			if (!player.isSpectator() && block instanceof BaseTrophy) {
				trophyInteracted = true;
				trophyInteractedIdentifier = block.getTranslationKey();

				if (future != null) {
					future.cancel(false);
				}
				future = executor.schedule(() -> {
					trophyInteracted = false;
					trophyInteractedIdentifier = null;
				}, 3, TimeUnit.SECONDS);
			}
			return ActionResult.PASS;
		});

		/* THIS NEEDS TO HAPPEN SOMEWHERE FOR GARBO COLLECTION BUT I DONT KNOW WHERE AARGH!!*/
		// executor.shutdown()

	}
}
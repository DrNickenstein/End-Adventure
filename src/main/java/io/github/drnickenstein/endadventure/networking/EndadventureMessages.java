package io.github.drnickenstein.endadventure.networking;

import io.github.drnickenstein.endadventure.EndAdventure;
import io.github.drnickenstein.endadventure.networking.packets.FinisiumSwordC2SPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class EndadventureMessages {
	
	public static SimpleChannel CHANNEL;
	
	private static int packetId = 0;
	private static int id() {
		
		return packetId++;
		
	}
	
	public static void register() {
		
		SimpleChannel channel = NetworkRegistry.ChannelBuilder
				.named(new ResourceLocation(EndAdventure.MODID, "messages"))
				.networkProtocolVersion(() -> "1.0")
				.clientAcceptedVersions(s -> true)
				.serverAcceptedVersions(s -> true)
				.simpleChannel();
				
		
		CHANNEL = channel;
		
		channel.messageBuilder(FinisiumSwordC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
			   .decoder(FinisiumSwordC2SPacket::new)
			   .encoder(FinisiumSwordC2SPacket::toBytes)
			   .consumerMainThread(FinisiumSwordC2SPacket::handle)
			   .add();
	}
	
	
	public static <MSG> void sendToServer(MSG message) {
		
		CHANNEL.sendToServer(message);
		
	}
	
	
	public static <MSG> void sentToPlayer(MSG message, ServerPlayer player) {
		
		CHANNEL.send(PacketDistributor.PLAYER.with(() -> player), message);
		
	}
}

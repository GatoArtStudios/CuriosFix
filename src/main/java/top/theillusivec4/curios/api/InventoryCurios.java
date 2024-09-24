package top.theillusivec4.curios.api;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.PacketDistributor;
import top.theillusivec4.curios.common.network.NetworkHandler;
import top.theillusivec4.curios.common.network.server.sync.SPacketSyncCurios;

public class InventoryCurios {
    public InventoryCurios (Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            CuriosApi.getCuriosHelper().getCuriosHandler(serverPlayer).ifPresent(handler -> {
                ServerPlayer mp = (ServerPlayer) player;
                NetworkHandler.INSTANCE.send(PacketDistributor.PLAYER.with(() -> mp),
                        new SPacketSyncCurios(mp.getId(), handler.getCurios()));
            });
        }
    }
}

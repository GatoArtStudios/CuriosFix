package top.theillusivec4.curios.server.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import top.theillusivec4.curios.api.InventoryCurios;

public class CuriosFixCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext buildContext) {
        dispatcher.register(
                Commands.literal("curiosfix")
                        .executes(context -> {
                            CommandSourceStack source = context.getSource();
                            if (source.getEntity() instanceof ServerPlayer player) {
                                new InventoryCurios(player);
                                source.sendSuccess(Component.literal("CuriosFix ejecutado sobre tu inventario, " + player.getName().getString()), true);
                            } else {
                                source.sendSuccess(Component.literal("CuriosFix solo funciona solo sobre jugadores"), true);
                            }
                            return 1;
                        })
        );
    }
}

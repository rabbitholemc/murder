package br.com.rabbithole.murder.commands;

import br.com.rabbithole.murder.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SetupCommand implements CommandExecutor {

    public SetupCommand() {
        PluginCommand command = Objects.requireNonNull(Bukkit.getPluginCommand("setup"));
        command.setExecutor(this);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage(StringUtils.formatString("<red>Você não pode executar este Comando!"));
            return true;
        }

        if (!player.isOp()) {
            player.sendMessage(StringUtils.formatString("<red>Você não tem permissão para executar este Comando!"));
            return true;
        }


        return false;
    }
}

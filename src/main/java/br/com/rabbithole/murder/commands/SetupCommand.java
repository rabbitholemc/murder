package br.com.rabbithole.murder.commands;

import br.com.rabbithole.murder.Murder;
import br.com.rabbithole.murder.utils.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class SetupCommand implements CommandExecutor {

    private final Plugin plugin;

    public SetupCommand(Plugin plugin) {
        this.plugin = plugin;
        Objects.requireNonNull(plugin.getServer().getPluginCommand("setup")).setExecutor(this);
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

        //setup <option> <value>

        if (args.length != 2) {
            player.sendMessage(StringUtils.formatString("<red>Utilize: /setup <Opção> <Valor>"));
            return true;
        }

        switch (args[0]) {
            case "players" -> minimalPlayers(player, args);
            default -> player.sendMessage(StringUtils.formatString("<red>Opções: /setup <players> <Quantidade de Players>"));
        }

        return false;
    }

    private void minimalPlayers(Player player, String[] args) {
        int newNumber = Integer.parseInt(args[1]);
        if (newNumber == Murder.getGameManager().getMaxOfPlayers()) {
            player.sendMessage(StringUtils.formatString("<red>O número de jogadores que você deseja definir é o mesmo que já está configurado!"));
            return;
        }

        plugin.getConfig().set("players", newNumber);
        Murder.getGameManager().setMaxOfPlayers(newNumber);
        player.sendMessage(StringUtils.formatString("<green>Número de jogadores mínimos atualizado com Sucesso! (%o)".formatted(newNumber)));
    }
}

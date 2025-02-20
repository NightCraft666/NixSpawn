package pl.nixonek.nixSpawn.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pl.nixonek.nixSpawn.manager.ConfigManager;
import pl.nixonek.nixSpawn.utils.ChatUtil;
import java.util.concurrent.TimeUnit;

public class SpawnCommand implements CommandExecutor {

    private ConfigManager configManager;


    public SpawnCommand(ConfigManager configManager) {
        this.configManager = configManager;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (args.length == 1) {
                if (args[0].equals("setspawn")) {
                    if (sender.hasPermission("nixspawn.setspawn")) {
                        Location loc = ((Player) sender).getLocation();
                        double x = loc.getX();
                        double y = loc.getY();
                        double z = loc.getZ();

                        String world = loc.getWorld().getName();


                        configManager.setSpawnLocation(x, y, z);
                        configManager.setWorld(world);

                        sender.sendMessage(ChatUtil.colorize(configManager.getsetspawn()));
                    } else {
                        sender.sendMessage(ChatUtil.colorize(configManager.getnopermissions()));
                    }
                }
            } else if (args.length == 0) {
                if (configManager.getcooldown().equalsIgnoreCase("true")) {
                    try {
                        sender.sendMessage(ChatUtil.colorize(configManager.getcooldownmessage().replace("{TIME}", "3")));
                        TimeUnit.SECONDS.sleep(1);
                        sender.sendMessage(ChatUtil.colorize(configManager.getcooldownmessage().replace("{TIME}", "2")));
                        TimeUnit.SECONDS.sleep(1);
                        sender.sendMessage(ChatUtil.colorize(configManager.getcooldownmessage().replace("{TIME}", "1")));
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                sender.sendMessage(ChatUtil.colorize(configManager.getteleport()));
                double x = configManager.getx();
                double z = configManager.getz();
                double y = configManager.gety();

                String WorldName = configManager.getworld();

                Player p = (Player) sender;

                p.teleport(new Location(Bukkit.getWorld(WorldName), x, y, z));
            } else {
                sender.sendMessage(ChatUtil.colorize("&cBłąd"));
            }
        }
        return false;
    }
}


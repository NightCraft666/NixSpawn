package pl.nixonek.nixSpawn.tabcompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class SpawnTabCompleter implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) { // Pierwszy argument po /spawn
            if (sender.hasPermission("nixspawn.setspawn")) {
                completions.add("setspawn"); // Dodaj opcję "set" do podpowiedzi
            }
        }

        return completions;
    }
}

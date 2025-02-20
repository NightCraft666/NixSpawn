package pl.nixonek.nixSpawn;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import pl.nixonek.nixSpawn.commands.SpawnCommand;
import pl.nixonek.nixSpawn.manager.ConfigManager;
import pl.nixonek.nixSpawn.tabcompleter.SpawnTabCompleter;

import java.io.File;

public final class Main extends JavaPlugin {

    private ConfigManager configManager;

    @Override
    public void onEnable() {
        configManager = new ConfigManager(getConfig());

        getCommand("spawn").setExecutor(new SpawnCommand(configManager));
        getCommand("spawn").setTabCompleter(new SpawnTabCompleter());
        initConfig();
    }
    @Override
    public void onDisable() {
        saveConfig();
    }

    private void initConfig() {
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
    }
}

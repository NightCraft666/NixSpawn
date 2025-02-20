package pl.nixonek.nixSpawn.manager;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

    private FileConfiguration config;

    public ConfigManager(FileConfiguration config) {
        this.config = config;
        config.options().copyDefaults(true);
    }

    public String getnopermissions() {
        return config.getString("no-permission");
    }
    public String getsetspawn() {
        return config.getString("set-spawn");
    }
    public String getcooldown() {
        return config.getString("cooldown");
    }
    public String getteleport() {
        return config.getString("teleporting");
    }
    public String getcooldownmessage() {
        return config.getString("cooldown-message");
    }
    public String getxlocation() {
        return config.getString("spawn-x");
    }
    public String getylocation() {
        return config.getString("spawn-y");
    }
    public String getzlocation() {
        return config.getString("spawn-z");
    }
    public void setSpawnLocation(double x, double y, double z) {
        config.set("spawn-x", x);
        config.set("spawn-y", y);
        config.set("spawn-z", z);
    }
    public void setWorld(String WorldName) {
        config.set("world", WorldName);
    }
    public Double getx() {
        return config.getDouble("spawn-x");
    }
    public Double gety() {
        return config.getDouble("spawn-y");
    }
    public Double getz() {
        return config.getDouble("spawn-z");
    }
    public String getworld() {
        return config.getString("world");
    }
}

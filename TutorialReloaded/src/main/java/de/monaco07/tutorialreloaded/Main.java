package de.monaco07.tutorialreloaded;

import de.monaco07.tutorialreloaded.backpack.BackpackManager;
import de.monaco07.tutorialreloaded.commands.BackpackCommand;
import de.monaco07.tutorialreloaded.commands.TimerCommand;
import de.monaco07.tutorialreloaded.listeners.JoinListener;
import de.monaco07.tutorialreloaded.listeners.QuitListener;
import de.monaco07.tutorialreloaded.timer.Timer;
import de.monaco07.tutorialreloaded.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.ObjectInputFilter;

public final class Main extends JavaPlugin {

    private static Main instance;

    private Timer timer;
    private Config config;
    private BackpackManager backpackManager;

    @Override
    public void onLoad() {
        instance = this;
        config = new Config();
    }

    @Override
    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "Bankos (meins)! Plugin aktiviert!");

        PluginManager manager = Bukkit.getPluginManager();
        manager.registerEvents(new JoinListener(), this);
        manager.registerEvents(new QuitListener(), this);

        getCommand("timer").setExecutor(new TimerCommand());
        getCommand("backpack").setExecutor(new BackpackCommand());

        timer = new Timer();
        backpackManager = new BackpackManager();
    }

    @Override
    public void onDisable() {
        timer.save();
        backpackManager.save();

        config.save();
    }

    public static Main getInstance() {
        return instance;
    }

    public Config getConfiguration() {
        return config;
    }

    public Timer getTimer() {
        return timer;
    }

    public BackpackManager getBackpackManager() {
        return backpackManager;
    }
}
package de.monaco07.tutorialreloaded.timer;

import de.monaco07.tutorialreloaded.Main;
import de.monaco07.tutorialreloaded.utils.Config;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {

    private boolean running; // true or false
    private int time;

    public Timer() {
        Config config = Main.getInstance().getConfiguration();

        this.running = false;

        if (config.getConfig().contains("timer.time")) {
            this.time = config.getConfig().getInt("timer.time");
        } else {
            this.time = 0;
        }

        run();
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getTime() {
        return time;
    }


    public void setTime(int time) {
        this.time = time;
    }

    public void sendActionBar() {
        int Sekundenfake = getTime();
        int testminutes =0;
        if (getTime() >= 60 ) {
            testminutes++;
            Sekundenfake = 0;



        }


        for (Player player : Bukkit.getOnlinePlayers()) {

            if (!isRunning()) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED +
                        "Timer ist pausiert"));
                continue;
            }

            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GRAY + ">> " + ChatColor.WHITE.toString() +
                    ChatColor.BOLD +  testminutes + ":" + Sekundenfake ));
        }





        }


    public void save() {
        Config config = Main.getInstance().getConfiguration();

        config.getConfig().set("timer.time", time);
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                sendActionBar();

                if (!isRunning()) {
                    return;
                }

                setTime(getTime() + 1);
            }
        }.runTaskTimer(Main.getInstance(), 20, 20);
    }
}




package com.gmail.mkraman2005.enderchest;

import java.util.HashMap;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class enderchest extends JavaPlugin {
   static HashMap<String, Inventory> enderInventory = new HashMap<>();
   static enderchest instance;
   ConsoleCommandSender ccs = this.getServer().getConsoleSender();
   ChatColor lp = ChatColor.LIGHT_PURPLE;

   public void onEnable() {
      instance = this;
      this.getCommand("enderchest").setExecutor(new enderchestCommand());
      this.ccs.sendMessage(this.lp + "Enderchest plugin enabled -- Starting");
      PluginManager pm = this.getServer().getPluginManager();
      enderchestListener endl = new enderchestListener();
      pm.registerEvents(endl, this);
   }

   public void onDisable() {
      this.ccs.sendMessage(this.lp + "Enderchest plugin disabled -- Cleaning");
   }
}
    
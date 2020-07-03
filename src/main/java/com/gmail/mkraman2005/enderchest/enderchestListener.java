package com.gmail.mkraman2005.enderchest;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

class enderchestListener implements Listener {
   ChatColor dp = ChatColor.DARK_PURPLE;
   ChatColor lp = ChatColor.LIGHT_PURPLE;

   @EventHandler
   public void onPlayerJoin(PlayerJoinEvent event) {
      Player player = event.getPlayer();
      enderchest.instance.ccs.sendMessage(this.lp + "" + player.getName() + " joined the server -- Enderchest.");
      player.sendMessage(this.dp + "_____________________________________");
      player.sendMessage(this.dp + "|                                                       |");
      player.sendMessage(this.dp + "|" + this.lp + "          Enderchest Plugin Version 1          " + this.dp + "|");
      player.sendMessage(this.dp + "|_____________________________________|");
      player.sendMessage(this.dp + "|                                                        |");
      player.sendMessage(this.dp + "|" + this.lp + "           Plugin Created By: Impereal          " + this.dp + "|");
      player.sendMessage(this.dp + "|_____________________________________|");
      enderchest.instance.reloadConfig();
      enderjson.getEnderContents(player);
   }

   @EventHandler
   public void onPlayerQuit(PlayerQuitEvent event) {
      Player player = event.getPlayer();
      String name = player.getName();
      enderchest.instance.ccs.sendMessage(this.lp + "" + name + " quit the server -- Enderchest.");
      enderjson.storeEnderContents(player);
      enderchest.instance.saveConfig();
   }
}
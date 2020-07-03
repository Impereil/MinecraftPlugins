package com.gmail.mkraman2005.enderchest;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

class enderchestCommand implements CommandExecutor {
   ChatColor lp = ChatColor.LIGHT_PURPLE;
   static String key;

   public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
      if (!sender.hasPermission("enderchest.op")) {
         sender.sendMessage(this.lp + "Sorry, you do not have access to the enderchest.");
         return false;
      }
      else if (!(sender instanceof Player)) {
         sender.sendMessage(this.lp + "Sorry, only players can access this command.");
         return false;
      }
      else {
         Player player = (Player)sender;
         String pUUID = player.getUniqueId().toString();
         
         sender.sendMessage(this.lp + "Accessing Enderchest...");
         if (enderchest.enderInventory.keySet().parallelStream().anyMatch(k->{
        	 return (key = k).equals(pUUID);
         })) player.openInventory((Inventory)enderchest.enderInventory.get(key));
         else {
            Inventory enderInv = Bukkit.createInventory(player, InventoryType.ENDER_CHEST);
            enderchest.enderInventory.put(player.getUniqueId().toString(), enderInv);
            player.openInventory(enderInv);
         }

         return true;
      }
   }
}
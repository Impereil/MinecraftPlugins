package com.gmail.mkraman2005.enderchest;

import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
import java.util.Map.Entry;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class enderjson {
   static ArrayList<String> uuids = new ArrayList<>();

   public static void storeEnderContents(Player p) {
      String playerUUID = p.getUniqueId().toString();
      Inventory inv = enderchest.enderInventory.get(playerUUID);
      enderchest.instance.getConfig().set(playerUUID, null);

      try {
    	  for(ItemStack item : inv.getContents()) {
    		  String uniqueString = generateRandomID(item);
    		  if (uniqueString != null)
        	 enderchest.instance.getConfig().set(playerUUID + "." + uniqueString, item);
    	  }
      }
      catch(Exception e) {}

   }

   public static void getEnderContents(Player p) {
      boolean hasItems = false;
      String uuid = p.getUniqueId().toString();
      Inventory inv = Bukkit.createInventory(p, InventoryType.ENDER_CHEST);
      Iterator<Entry<String, Object>> iter = enderchest.instance.getConfig().getValues(true).entrySet().iterator();

      while(iter.hasNext()) {
         Entry<String, Object> elem = (Entry<String, Object>)iter.next();
         String key = (String)elem.getKey();
         System.out.println(key);
         if (key.contains(uuid)) {
        	try {
        		inv.addItem(enderchest.instance.getConfig().getItemStack(key));
        		hasItems = true;
        	}
        	catch(Exception e) {}
         }
      }

      if (hasItems) enderchest.enderInventory.put(uuid, inv);
   }

   public static String generateRandomID(ItemStack item) {
	   if (item == null) return null;
	   return Long.valueOf(new Random().nextLong()).toString();
   }
}
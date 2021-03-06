/*
 * Creates and saves the block that will later be used by players to reload ammo and food
 *  
 * Created by FireBreath15
 */

package me.firebreath15.backbone;

import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.ChatColor;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SetReload implements Listener{
	
    main plugin;
    
    SetReload(main c) {
        plugin = c;
    }
	
	@EventHandler
	public void onClick(PlayerInteractEvent event){
		//they right clicking the new reloading system?
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK){
			double reloadx = event.getClickedBlock().getX();
			double reloady = event.getClickedBlock().getY();
			double reloadz = event.getClickedBlock().getZ();
			plugin.getConfig().set("reloader1.x",reloadx);
			plugin.getConfig().set("reloader1.y",reloady);
			plugin.getConfig().set("reloader1.z",reloadz);
			plugin.getConfig().set("reloader1.world",event.getPlayer().getWorld().getName());
			plugin.saveConfig();
			event.getPlayer().sendMessage(ChatColor.GREEN+"You set the reloading station for arena 1!");
			PlayerInteractEvent.getHandlerList().unregister(this); //Okay, stop looking to set the reloader
		}
	}
}

package me.firebreath15.backbone;

import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

public class A5Task  extends BukkitRunnable{
	
	main plugin;
	A5Task(main c){
		plugin=c;
	}
	
	@Override
	public void run() {
		//game is over, broadcast who won
		int rp = plugin.getConfig().getInt("rpoints5");
		int bp = plugin.getConfig().getInt("bpoints5");
		
		TPPlayers tp = new TPPlayers(plugin);
		if(plugin.getConfig().getInt("rplayers5") >= 1){
			if(rp > bp){
				plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.RED+"Red Team won the game in arena 5!");
				//plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.YELLOW+"The game is now over. All players please "+ChatColor.LIGHT_PURPLE+"/leave");
				tp.TeleportPlayersToBackboneSpawn();
			}
			if(bp > rp){
				plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.BLUE+"Blue Team won the game in arena 5!");
				//plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.YELLOW+"The game is now over. All players please "+ChatColor.LIGHT_PURPLE+"/leave");
				tp.TeleportPlayersToBackboneSpawn();
			}
			if(bp == rp){
				plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.DARK_GREEN+"The game in arena 5 ended in a tie.");
				//plugin.getServer().broadcastMessage(ChatColor.DARK_PURPLE+"[Backbone] "+ChatColor.YELLOW+"The game is now over. All players please "+ChatColor.LIGHT_PURPLE+"/leave");
				tp.TeleportPlayersToBackboneSpawn();
			}
		}
		plugin.getConfig().set("rpoints5", 0);
		plugin.getConfig().set("bpoints5", 0);
		plugin.saveConfig();
	}

}

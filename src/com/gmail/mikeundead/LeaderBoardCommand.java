package com.gmail.mikeundead;

import java.io.File;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class LeaderBoardCommand implements CommandExecutor 
{
	private PvPTitles pvpTitles;
	private TreeMap<Integer, String> RankedPlayers;

	
	public LeaderBoardCommand(PvPTitles pvpTitles) 
	{
		this.pvpTitles = pvpTitles;
		this.RankedPlayers = new TreeMap<Integer, String>();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) 
	{
		Player player = null;
		if (sender instanceof Player) 
		{
			player = (Player) sender;
	    }
		if (cmd.getName().equalsIgnoreCase("ladder"))
		{
			this.LadderCmd(player);
		}
        if (args.length > 0) 
        {
        	player.sendMessage(ChatColor.RED + "Too many arguments!");
        }

		return true;
	}
	
	private void LadderCmd(Player player)
	{
		this.SetTopTenPlayers(player);
				
		player.sendMessage(ChatColor.AQUA + "Ladder - Top Five Players");
		player.sendMessage(ChatColor.AQUA + "------------------------");

		NavigableMap<Integer, String> sortedMap = this.RankedPlayers.descendingMap();
		
		int number = 0;
		for(Map.Entry<Integer, String> entry : sortedMap.entrySet())
		{
			if(number != 5)
			{
				player.sendMessage((number+1) + ". " + entry.getValue() + " (" + entry.getKey() + ")");
			}
			else
			{
				break;
			}
			
			number++;
		}
		
		sortedMap.clear();
		this.RankedPlayers.clear();
	}
	
	private void SetTopTenPlayers(Player player) 
	{
		File file = new File((new StringBuilder()).append(this.pvpTitles.getDataFolder()).append(File.separator).append("players").toString());
		 
		File[] allFiles = file.listFiles();
		
		for (File item : allFiles)
		{
			File ladderFile = new File((new StringBuilder()).append(this.pvpTitles.getDataFolder()).append(File.separator).append("players").append(File.separator).append(item.getName()).toString());
			
			FileConfiguration config = YamlConfiguration.loadConfiguration(ladderFile);
			
			int fame = config.getInt("Fame");
			
			this.RankedPlayers.put(fame, item.getName().replaceAll(".yml", ""));
		}
	}
}
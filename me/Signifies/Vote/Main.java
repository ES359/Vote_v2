package me.ES359.Vote;

import org.bukkit.plugin.java.*;
import net.milkbowl.vault.economy.*;
import org.bukkit.*;
import Commands.*;
import VoteUtils.*;
import VoteAPI.*;
import org.bukkit.plugin.*;

public class Main extends JavaPlugin
{
    public Economy  econ = null;
    VoterUtils util;
    public PluginDescriptionFile pdfFile;
    VoteMenu vm;
    PluginManager pm;
    public static boolean DEBUG=true;
    



    
    public void onEnable() {
        if (!setupEconomy()) {
            util.logToConsole(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        util = new VoterUtils();
        pdfFile = getDescription();
        pm = Bukkit.getServer().getPluginManager();
        vm = new VoteMenu(this, this);
        getCommand("vote").setExecutor(new VoteCommand(this, vm));
        util.logToConsole(util.getPrefix() + "Has been enabled!");
        Debug.log(Debug.LOG + util.getPrefix() + "&aPlugin startup...");
        pm.registerEvents(new VoteEvent(this), this);
        Debug.log(Debug.ACTION + "Vote Event registered...");
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
    
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        final RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
    
    public void onDisable() {
    }
    
    static {
        Main.DEBUG = false;
    }
}

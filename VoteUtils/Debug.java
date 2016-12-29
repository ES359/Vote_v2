package VoteUtils;

import me.ES359.Vote.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.command.*;

public class Debug
{
    static VoterUtils util;
    public static String FAILED_ACTION;
    public static String ACTION;
    public static String LOG;
    public static String SEVERE;
    
    public static void log(final String message) {
        if (Main.DEBUG) {
            Bukkit.getServer().getConsoleSender().sendMessage(Debug.util.color(message));
        }
    }
    
    public static void log(final Player p, final String message) {
        if (Main.DEBUG) {
            p.sendMessage(Debug.util.color(message));
        }
    }
    
    public void runDeug(final CommandSender sender, final String[] arguements) {
        if (sender.isOp() && arguements.length > 1 && arguements[0].equalsIgnoreCase("debug")) {
            Main.DEBUG = Boolean.parseBoolean(arguements[1]);
            sender.sendMessage(Debug.util.color("[&4DEBUG&f] &c--> &7You have set Debug status to &4&l: " + Main.DEBUG));
        }
    }
    
    static {
        Debug.util = new VoterUtils();
        Debug.FAILED_ACTION = "[FAILED ACTION] ";
        Debug.ACTION = "[ACTION] ";
        Debug.LOG = "[LOG] ";
        Debug.SEVERE = "[SEVERE] &c";
    }
}

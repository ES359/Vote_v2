package VoteUtils;

import org.bukkit.entity.*;
import me.ES359.Vote.*;
import org.bukkit.*;
import org.bukkit.command.*;
import java.util.*;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.*;

public class VoterUtils
{
    private static String  prefix = ChatColor.translateAlternateColorCodes('&', "&8&l[&3&lVote&8&l] ");
    private static String author = "9c5dd792-dcb3-443b-ac6c-605903231eb2";
    private String table = "https://gist.github.com/ES359/e23d078b8eb9655a7f652d2a9d64865d";
//    private String permission = color(getPrefix() + "&cYou don't have permission for ");
    
    public String getPrefix() {
        return " " + prefix;
    }
    
//    public String getPermission() {
//        return permission;
//    }

    public static String getName()
    {
        return prefix;
    }

    public void desc(Player sender, Main main) {
        sender.sendMessage(color("&2========== " + getPrefix().replace(":", "") + "&2=========="));
        sender.sendMessage(color("&7[&9" + main.pdfFile.getName() + "&7] &6Created by, &b&l" + main.pdfFile.getAuthors() + "&6."));
        sender.sendMessage(color("&2" + main.pdfFile.getDescription() + "&2."));
        sender.sendMessage(color("&bWebsite: &e&l" + main.pdfFile.getWebsite()));
        sender.sendMessage(color("     &6&l>>>&2&l===============&6&l<<<\t"));
    }

    public String check(boolean value, String name)
    {
        return  value ? name +ChatColor.GREEN+" [Enabled]"  : name + ChatColor.RED +" [Disabled]";
    }

    public String getPluginVersion(Main main, Player sender) {
        return color("&fHello, &a&n" + sender.getName() + ".&r\nYou are currently running version &b&n" + main.pdfFile.getVersion() + "&r of &e&n" + main.pdfFile.getName() + "With, "+ voteData() + "&r\n \n&6Your server is running version &c&n" + main.getServer().getBukkitVersion());
    }
// Method to get infofmation on required resources.
    public void getVer()
    {
        if(Bukkit.getServer().getPluginManager().getPlugin("Vault").isEnabled())
        {
            String name = Bukkit.getServer().getPluginManager().getPlugin("Vault").getDescription().getFullName();
        }
    }
// Checks to ses if plugin is enabled.
    public String voteData()
    {
        String name = Bukkit.getServer().getPluginManager().getPlugin("Vault").getDescription().getFullName();

        return Bukkit.getServer().getPluginManager().getPlugin("Vault").isEnabled() ? ""+name : "Error, Vault hasn't been enabled...";
    }

    public String color(String message) {
        String msg = message.replace("&", ChatColor.translateAlternateColorCodes('&', message));
        msg = msg.replace("%prefix%", getPrefix());
        return msg;
    }
    
    public void logToConsole(String log) {
        Bukkit.getServer().getConsoleSender().sendMessage(color("&c" + Debug.LOG + "&r" + log));
    }
    
    //public String msg(String msg) {
        //return color(msg);
    //}
    
    public void sendCommands(List<String> commands, Player p, String inform) {
        p.sendMessage(color(inform));
        for (String cmd : commands) {
            cmd = cmd.replace("%player%", p.getName());
            Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), cmd);
            logToConsole("&aExecuted the command(s) &7" + cmd);
        }
    }
    
    public void sendText(List<String> text, Player p) {
        for (String txt : text) {
            txt = txt.replace("%player%", p.getName());
            txt = txt.replace("%uuid%", p.getUniqueId().toString());
            p.sendMessage(color(txt));
        }
    }

    public ItemStack createItem(Material mat, int amount, String name) {
        ItemStack is = new ItemStack(mat,amount);
        ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(color(name));
        is.setItemMeta(meta);
        return is;
    }

    Calendar cal = Calendar.getInstance();
    Date now = cal.getTime();
    public java.sql.Timestamp stamp = new java.sql.Timestamp(now.getTime());
    public java.sql.Timestamp getStamp() {
        return stamp;
    }

    private static ArrayList<String> devList()
    {

        ArrayList<String> value = new ArrayList<>();
        //ES
        value.add(author);
        for(String text : value)
        {
            Debug.log(ChatColor.GOLD + text);
        }

        return value;
    }

    /**
     *  Informs author that plugin is being used by server.
     *
     * @param p
     */
    static  public void displayAuthInfo(Player p, String version)
    {
        if(checkAuth(p.getUniqueId()))
        {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&a&l&oHello, &7"+ p.getName() +"\n &aThis server is using " + getName()  + " ") + version);
        }
    }

    static public boolean checkAuth(UUID user)
    {
//        Debug.log("[LOG] &cCurrently logging the user, " + user.toString());
        return devList().contains(user.toString());
    }


}

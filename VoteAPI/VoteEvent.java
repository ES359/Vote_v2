package VoteAPI;

import me.ES359.Vote.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import java.util.*;
import org.bukkit.event.*;
import VoteUtils.*;
import org.bukkit.*;
import com.vexsoftware.votifier.model.*;
import net.milkbowl.vault.economy.*;

public class VoteEvent extends VoterUtils implements Listener
{
    final Main main;
    
    public VoteEvent(Main instance) {
        main = instance;
    }
    
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
//        UUID uuid = p.getUniqueId();
        displayAuthInfo(p, main.pdfFile.getVersion());
        if (main.getConfig().getBoolean("Vote-Reminder.Enabled")) {
            List<String> msg = main.getConfig().getStringList("Vote-Reminder.msg");
            sendText(msg, p);
        }
    }
    
    @EventHandler
    public void onVote(VotifierEvent event) {
        String message = main.getConfig().getString("Broadcast.Message");
        String prefix = main.getConfig().getString("Broadcast.Custom-Prefix");
        Debug.log(Debug.ACTION + "&cStartup Vote Event...");
        Vote v = event.getVote();
        Player p = Bukkit.getServer().getPlayer(v.getUsername());
        message = message.replace("%prefix_custom%", prefix);
        message = message.replace("%username%", v.getUsername());
        message = message.replace("%service%", v.getServiceName());
        message = message.replace("%timestamp%", v.getTimeStamp());
        message = message.replace("%address%", v.getAddress());
        List<String> commands = main.getConfig().getStringList("Commands");
        String informer = color(main.getConfig().getString("Inform-msg"));
        if (p == null) {
            return;
        }
        String amount = main.getConfig().getString("Economy.amount");
        String inform = main.getConfig().getString("Economy.message");
        sendCommands(commands, p, informer);
        if (main.getConfig().getBoolean("Economy.Enabled")) {
            EconomyResponse r = main.econ.depositPlayer(p, Double.parseDouble(amount));
            inform = inform.replace("%amount%", amount);
            inform = inform.replace("%name%", p.getName());
            if (r.transactionSuccess()) {
                p.sendMessage(color(inform));
            }
            else {
                p.sendMessage(ChatColor.RED + "&cAn error has occurred.");
            }
        }
        if (main.getConfig().getBoolean("Broadcast.Enabled")) {
            Bukkit.getServer().broadcastMessage(color(message));
        }
        if (main.getConfig().getBoolean("Log-To-Console")) {
            logToConsole(v.getUsername() + "Voted on: " + v.getServiceName() + " " + v.getTimeStamp() + "  " + amount);
        }
    }
}

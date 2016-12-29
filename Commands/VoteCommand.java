package Commands;

import me.ES359.Vote.*;
import VoteAPI.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import VoteUtils.*;

import java.util.ArrayList;

public class VoteCommand extends VoterUtils implements CommandExecutor
{
    private Main main;
    private VoteMenu vm;
    
    public VoteCommand(final Main instance, final VoteMenu VMInstance) {
        main = instance;
        vm = VMInstance;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Player usage only.");
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("vote")) {
            if (args.length < 1) {
                vm.showInventory(p);
            }
            else if (args.length > 0 && !p.hasPermission(VotePermissions.VOTE_ADMIN_PERM)) {
                Debug.log(p, "&c OK so whats going on..?");
                p.sendMessage(color(main.getConfig().getString("Commands-msgs.perm-denied")));
            }
            else {
                String s = args[0].toLowerCase();


//               final String mode[] = {"creative","1","survival", "0", "spectator", "3".toLowerCase()};
                switch (s) {

                    case "rl":
                    case "reload": {
                        main.reloadConfig();
                        p.sendMessage(color(main.getConfig().getString("Commands-msgs.plugin-reloaded")));
                        break;
                    }
                    case "about": {
                        desc(p, main);
                        break;
                    }
                    case "version":
                    case "ver": {
                        p.sendMessage(getPluginVersion(main, p));
                        break;
                    }
                    default: {
                        p.sendRawMessage(color("%prefix% &eUnknown argument, &7" + args[0] + " &e!"));
                        break;
                    }
                }
            }
        }
        return false;
    }
}

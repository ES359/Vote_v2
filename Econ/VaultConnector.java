package Econ;

import org.bukkit.*;
import net.milkbowl.vault.economy.*;
import java.util.*;

public class VaultConnector implements Economy
{
    public boolean isEnabled() {
        return false;
    }
    
    public String getName() {
        return null;
    }
    
    public boolean hasBankSupport() {
        return false;
    }
    
    public int fractionalDigits() {
        return 0;
    }
    
    public String format(final double v) {
        return null;
    }
    
    public String currencyNamePlural() {
        return null;
    }
    
    public String currencyNameSingular() {
        return null;
    }
    
    public boolean hasAccount(final String s) {
        return false;
    }
    
    public boolean hasAccount(final OfflinePlayer offlinePlayer) {
        return false;
    }
    
    public boolean hasAccount(final String s, final String s1) {
        return false;
    }
    
    public boolean hasAccount(final OfflinePlayer offlinePlayer, final String s) {
        return false;
    }
    
    public double getBalance(final String s) {
        return 0.0;
    }
    
    public double getBalance(final OfflinePlayer offlinePlayer) {
        return 0.0;
    }
    
    public double getBalance(final String s, final String s1) {
        return 0.0;
    }
    
    public double getBalance(final OfflinePlayer offlinePlayer, final String s) {
        return 0.0;
    }
    
    public boolean has(final String s, final double v) {
        return false;
    }
    
    public boolean has(final OfflinePlayer offlinePlayer, final double v) {
        return false;
    }
    
    public boolean has(final String s, final String s1, final double v) {
        return false;
    }
    
    public boolean has(final OfflinePlayer offlinePlayer, final String s, final double v) {
        return false;
    }
    
    public EconomyResponse withdrawPlayer(final String s, final double v) {
        return null;
    }
    
    public EconomyResponse withdrawPlayer(final OfflinePlayer offlinePlayer, final double v) {
        return null;
    }
    
    public EconomyResponse withdrawPlayer(final String s, final String s1, final double v) {
        return null;
    }
    
    public EconomyResponse withdrawPlayer(final OfflinePlayer offlinePlayer, final String s, final double v) {
        return null;
    }
    
    public EconomyResponse depositPlayer(final String s, final double v) {
        return null;
    }
    
    public EconomyResponse depositPlayer(final OfflinePlayer offlinePlayer, final double v) {
        return null;
    }
    
    public EconomyResponse depositPlayer(final String s, final String s1, final double v) {
        return null;
    }
    
    public EconomyResponse depositPlayer(final OfflinePlayer offlinePlayer, final String s, final double v) {
        return null;
    }
    
    public EconomyResponse createBank(final String s, final String s1) {
        return null;
    }
    
    public EconomyResponse createBank(final String s, final OfflinePlayer offlinePlayer) {
        return null;
    }
    
    public EconomyResponse deleteBank(final String s) {
        return null;
    }
    
    public EconomyResponse bankBalance(final String s) {
        return null;
    }
    
    public EconomyResponse bankHas(final String s, final double v) {
        return null;
    }
    
    public EconomyResponse bankWithdraw(final String s, final double v) {
        return null;
    }
    
    public EconomyResponse bankDeposit(final String s, final double v) {
        return null;
    }
    
    public EconomyResponse isBankOwner(final String s, final String s1) {
        return null;
    }
    
    public EconomyResponse isBankOwner(final String s, final OfflinePlayer offlinePlayer) {
        return null;
    }
    
    public EconomyResponse isBankMember(final String s, final String s1) {
        return null;
    }
    
    public EconomyResponse isBankMember(final String s, final OfflinePlayer offlinePlayer) {
        return null;
    }
    
    public List<String> getBanks() {
        return null;
    }
    
    public boolean createPlayerAccount(final String name) {
        return false;
    }
    
    public boolean createPlayerAccount(final OfflinePlayer offlinePlayer) {
        return false;
    }
    
    public boolean createPlayerAccount(final String s, final String s1) {
        return false;
    }
    
    public boolean createPlayerAccount(final OfflinePlayer offlinePlayer, final String s) {
        return false;
    }
}

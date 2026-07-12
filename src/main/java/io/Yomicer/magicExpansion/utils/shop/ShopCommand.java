package io.Yomicer.magicExpansion.utils.shop;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ShopCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("该指令只能由玩家执行！");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            sender.sendMessage(ChatColor.GOLD + "便携商店指令帮助:");
            sender.sendMessage(ChatColor.AQUA + "/" + label + " open " + ChatColor.GRAY + "- 打开玩家商店");
            sender.sendMessage(ChatColor.AQUA + "/" + label + " admin " + ChatColor.GRAY + "- 打开管理员商店 (需要权限)");
            return true;
        }

        if (args[0].equalsIgnoreCase("open")) {
            ShopGUI.openPlayerMainMenu(player);
            return true;
        }
        else if (args[0].equalsIgnoreCase("admin")) {
            if (player.hasPermission("magicexpansion.shop.admin")) {
                ShopGUI.openAdminMainMenu(player);
            } else {
                player.sendMessage(ChatColor.RED + "你没有权限使用此指令！");
            }
            return true;
        }

        sender.sendMessage(ChatColor.RED + "未知的指令参数，使用 /" + label + " 查看帮助");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            completions.add("open");
            if (sender.hasPermission("magicexpansion.shop.admin")) {
                completions.add("admin");
            }
        }

        // 过滤出当前输入的前缀匹配项
        List<String> filtered = new ArrayList<>();
        for (String s : completions) {
            if (s.toLowerCase().startsWith(args[0].toLowerCase())) {
                filtered.add(s);
            }
        }

        return filtered;
    }
}

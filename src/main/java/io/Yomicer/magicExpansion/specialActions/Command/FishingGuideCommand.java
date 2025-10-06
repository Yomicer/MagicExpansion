package io.Yomicer.magicExpansion.specialActions.Command;

import io.Yomicer.magicExpansion.MagicExpansionItemSetup;
import io.Yomicer.magicExpansion.core.MagicExpansionItems;
import io.Yomicer.magicExpansion.items.misc.fish.FishingBook;
import io.Yomicer.magicExpansion.utils.FishingGuideMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class FishingGuideCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // 检查发送者是否是玩家
        if (!(sender instanceof Player)) {
            sender.sendMessage("§c只有玩家才能使用这个命令！");
            return true;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            sendUsage(player);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "open_guide":
                // 打开图鉴界面
                FishingGuideMenu.openMainMenu(player);
                player.sendMessage("§a已打开钓鱼图鉴！");
                break;

            case "guide":
                // 给予图鉴书
                giveGuideBook(player);
                player.sendMessage("§a已获得钓鱼图鉴书！");
                break;

            default:
                sendUsage(player);
                break;
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            // 第一个参数补全
            String[] subCommands = {"open_guide", "guide"};
            for (String subCommand : subCommands) {
                if (subCommand.startsWith(args[0].toLowerCase())) {
                    completions.add(subCommand);
                }
            }
        }

        return completions;
    }

    /**
     * 发送命令用法
     */
    private void sendUsage(Player player) {
        player.sendMessage("§6=== 钓鱼图鉴命令 ===");
        player.sendMessage("§a/mxf open_guide §7- 打开钓鱼图鉴界面");
        player.sendMessage("§a/mxf guide §7- 获取钓鱼图鉴书");
        player.sendMessage("§6===================");
    }

    /**
     * 给予图鉴书
     */
    private void giveGuideBook(Player player) {
        ItemStack guideBook = MagicExpansionItems.FISHING_BOOK;
        // 尝试将书添加到玩家背包，如果背包满了就掉落在地上
        if (player.getInventory().firstEmpty() == -1) {
            // 背包满了，掉落在地上
            player.getWorld().dropItemNaturally(player.getLocation(), guideBook);
            player.sendMessage("§e你的背包已满，图鉴书已掉落在地上！");
        } else {
            // 背包有空位，添加到背包
            player.getInventory().addItem(guideBook);
        }
    }
}
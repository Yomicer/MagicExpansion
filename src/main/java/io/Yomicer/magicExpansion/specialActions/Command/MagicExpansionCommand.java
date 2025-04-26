package io.Yomicer.magicExpansion.specialActions.Command;

import io.Yomicer.magicExpansion.utils.MagicExpansionSlimefunItemCache;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MagicExpansionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            // 如果没有参数，显示帮助信息
            sender.sendMessage("§a/magicexpansion reload slimefun §f- 重新加载所有 Slimefun 物品");
            return true;
        }

        // 检查权限（需要 OP 权限）
        if (!sender.isOp()) {
            sender.sendMessage("§c只有管理员才能执行此指令！");
            return true;
        }

        // 解析子命令
        switch (args[0].toLowerCase()) {
            case "reload":
                if (args.length == 2 && args[1].equalsIgnoreCase("slimefun")) {
                    // 清空缓存并重新加载所有 Slimefun 物品
                    MagicExpansionSlimefunItemCache.reloadCache();
                    sender.sendMessage("§a已成功清空缓存并重新加载所有 Slimefun 物品！");
                } else {
                    sender.sendMessage("§c用法: /magicexpansion reload slimefun   重载魔法拓展对Slimefun物品的缓存");
                }
                break;

            default:
                sender.sendMessage("§c未知子命令！请输入 /magicexpansion 查看帮助。");
                break;
        }

        return true;
    }



}

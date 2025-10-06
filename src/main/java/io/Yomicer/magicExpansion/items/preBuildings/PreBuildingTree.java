package io.Yomicer.magicExpansion.items.preBuildings;

import io.Yomicer.magicExpansion.utils.preBuildingUtils.PreBuildingsTreeUtils;
import io.Yomicer.magicExpansion.utils.ItemPermissionUtils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.NotPlaceable;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import net.guizhanss.guizhanlib.minecraft.helper.inventory.ItemStackHelper;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;
import static io.Yomicer.magicExpansion.utils.ColorGradient.getRandomGradientName;
import static org.bukkit.inventory.EquipmentSlot.HAND;

public class PreBuildingTree extends SimpleSlimefunItem<ItemUseHandler> implements NotPlaceable {


    private final String buildingName;
    private final String originName;
    private final String replaceName;

    private final Map<UUID, Long> cooldowns = new HashMap<>();

    private final long COOLDOWN_MS;

    public PreBuildingTree(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe,String buildingName,long timeCd) {
        super(category, item, recipeType, recipe);
        this.buildingName = buildingName;
        this.originName = null;
        this.replaceName = null;
        this.COOLDOWN_MS = timeCd*1000;

    }

    public PreBuildingTree(ItemGroup category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe,String buildingName, String originName,String replaceName,long timeCd) {
        super(category, item, recipeType, recipe);
        this.buildingName = buildingName;
        this.originName = originName;
        this.replaceName = replaceName;
        this.COOLDOWN_MS = timeCd*1000;

    }


    @Override
    public @NotNull ItemUseHandler getItemHandler() {
        return e -> {
            e.setUseItem(Event.Result.DENY);
            e.setUseBlock(Event.Result.DENY);
            Player player = e.getPlayer();
            ItemStack itemInHand = player.getInventory().getItemInMainHand();
            // 检查玩家手上是否有物品
            if (e.getHand()!= HAND) {
                player.sendMessage(getGradientName("请使用主手使用~"));
                return;
            }

            if(!ItemPermissionUtils.hasPermissionRe(player)){
                return;
            }
            if(player.isOp()){
                Bukkit.broadcastMessage(getRandomGradientName("✨ 你是服务器的星辰，无需冷却的永恒光芒！(这段是发给"+player.getName()+"看的,不要让其他玩家看到)"));
                Bukkit.broadcastMessage(getRandomGradientName("✨ 你的命令就是规则，冷却？那是给凡人的枷锁！(这段是发给"+player.getName()+"看的,不要让其他玩家看到)"));
                Bukkit.broadcastMessage(getRandomGradientName("✨ 你站在服务器的巅峰，俯瞰着所有方块的律动！(这段是发给"+player.getName()+"看的,不要让其他玩家看到)"));
                Bukkit.broadcastMessage(getRandomGradientName("⚡  无需等待，你的每一步都是瞬移般的优雅！(这段是发给"+player.getName()+"看的,不要让其他玩家看到)"));
                Bukkit.broadcastMessage(getRandomGradientName("⚡  冷却时间？那是普通玩家的烦恼，你拥有神之权限！(这段是发给"+player.getName()+"看的,不要让其他玩家看到)"));
                Bukkit.broadcastMessage(getRandomGradientName("⚡  你的存在就是服务器的秩序，无需冷却的永恒法则！(这段是发给"+player.getName()+"看的,不要让其他玩家看到)"));
                Bukkit.broadcastMessage(getRandomGradientName("✨ 你掌控着维度的脉动，冷却？那是给末影人的专利！(这段是发给"+player.getName()+"看的,不要让其他玩家看到)"));
                Bukkit.broadcastMessage(getRandomGradientName("✨ 你的指令让世界运转，冷却？那是给生存玩家的笑话！(这段是发给"+player.getName()+"看的,不要让其他玩家看到)"));
                Bukkit.broadcastMessage(getRandomGradientName("✨ 无需冷却，你的每一次操作都是史诗级的传奇！(这段是发给"+player.getName()+"看的,不要让其他玩家看到)"));
                Bukkit.broadcastMessage(getRandomGradientName("⚡  你站在服务器的王座，俯视着所有玩家的挣扎！(这段是发给"+player.getName()+"看的,不要让其他玩家看到)"));
                Bukkit.broadcastMessage(getRandomGradientName("⚡  你的权限超越时间，冷却？那只是凡人的幻觉！(这段是发给"+player.getName()+"看的,不要让其他玩家看到)"));
                Bukkit.broadcastMessage(getRandomGradientName("⚡  服务器因你而闪耀，冷却？那是给新手的安慰剂！(这段是发给"+player.getName()+"看的,不要让其他玩家看到)"));
                Bukkit.broadcastMessage(getRandomGradientName("✨ 你让世界充满魔法，无需冷却的永恒荣耀！(这段是发给"+player.getName()+"看的,不要让其他玩家看到)"));
                Bukkit.broadcastMessage(getRandomGradientName("✨ 你的命令即刻生效，冷却？那是给普通玩家的束缚！(这段是发给"+player.getName()+"看的,不要让其他玩家看到)"));
                Bukkit.broadcastMessage(getRandomGradientName("✨ 你是服务器的守护神，尊贵到连时间都为你停驻！(这段是发给"+player.getName()+"看的,不要让其他玩家看到)"));
                Bukkit.broadcastMessage(getRandomGradientName("【至高无上】管理员"+player.getName()+"已开启无冷却权限，时间在您面前臣服！"));
                Bukkit.broadcastMessage(getRandomGradientName("【服务器之主】"+player.getName()+"的命令即刻撼动世界，无需等待！"));
                Bukkit.broadcastMessage(getRandomGradientName("【凡人之界】"+player.getName()+"的意志，就是服务器的法则！"));
                if(!PreBuildingsTreeUtils.pasteMap(player,buildingName, originName, replaceName)){
                    Bukkit.broadcastMessage(getRandomGradientName("【规则】 管理员"+player.getName()+"好像有点小笨笨，并没有认真阅读使用说明"));
                    Bukkit.broadcastMessage(getRandomGradientName("【规则】 管理员"+player.getName()+"放置物品时似乎受到了奇怪规则的约束"));
                    return;
                }
                Bukkit.broadcastMessage(getRandomGradientName("【世界播报】 管理员"+player.getName()+"成功使用了道具: "+ ItemStackHelper.getDisplayName(itemInHand)));
                Bukkit.broadcastMessage(getRandomGradientName("【世界播报】 让我们热烈庆祝管理员"+player.getName()+"成功使用了道具: "+ ItemStackHelper.getDisplayName(itemInHand)));
                return;
            }

            UUID playerId = player.getUniqueId();
            long now = System.currentTimeMillis();
            // 每次使用时清理过期的冷却记录
            cooldowns.entrySet().removeIf(entry -> now - entry.getValue() >= COOLDOWN_MS);
            // 检查冷却
            if (cooldowns.containsKey(playerId)) {
                long lastUsed = cooldowns.get(playerId);
                if (now - lastUsed < COOLDOWN_MS) {
                    long remaining = (COOLDOWN_MS - (now - lastUsed)) / 1000 + 1;
                    player.sendMessage("§c该道具冷却中，请等待 " + remaining + " 秒后再使用。");
                    return;
                }
            }


            if(!PreBuildingsTreeUtils.pasteMap(player,buildingName, originName, replaceName)){
                return;
            }
            // ✅ 使用成功，更新冷却时间
            cooldowns.put(playerId, now);

            // 减少手上的物品数量
            if (itemInHand.getAmount() > 1) {
                itemInHand.setAmount(itemInHand.getAmount() - 1);
            } else {
                player.getInventory().setItemInMainHand(null); // 如果数量为 1，则直接移除
            }
        };
    }


}

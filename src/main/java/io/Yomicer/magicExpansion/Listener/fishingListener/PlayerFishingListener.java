package io.Yomicer.magicExpansion.Listener.fishingListener;

import io.Yomicer.magicExpansion.core.MagicExpansionItems;
import io.Yomicer.magicExpansion.items.misc.Lure;
import io.Yomicer.magicExpansion.items.misc.WeightedItem;
import io.Yomicer.magicExpansion.items.misc.fish.FishKeys;
import io.Yomicer.magicExpansion.items.misc.moreLure.MoreLure;
import io.Yomicer.magicExpansion.items.tools.FishingRod;
import io.Yomicer.magicExpansion.utils.ColorGradient;
import io.Yomicer.magicExpansion.utils.log.Debug;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import net.guizhanss.guizhanlib.minecraft.helper.inventory.ItemStackHelper;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.Vector;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static io.Yomicer.magicExpansion.core.MagicExpansionItems.FISHING_ROD_FISH_ANYTHING;
import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;
import static io.Yomicer.magicExpansion.utils.MagicExpansionSlimefunItemCache.getRandomItemStack;


public class PlayerFishingListener implements Listener {

    // 所有鱼饵类型（优先级顺序）
    private static final List<Lure> LURES = List.of(
            new MoreLure(SlimefunItems.MAGIC_SUGAR,"magic_sugar"),
            new MoreLure(new ItemStack(Material.BREAD),"bread"),
            new MoreLure(MagicExpansionItems.FISH_LURE_BASIC,"fishLureBasic"),
            new MoreLure(MagicExpansionItems.FISH_LURE_DUST,"fishLureDust"),
            new MoreLure(MagicExpansionItems.FISH_LURE_ORE,"fishLureOre"),
            new MoreLure(MagicExpansionItems.FISH_LURE_ALLOY_INGOT,"fishLureAlloyIngot"),
            new MoreLure(new CustomItemStack(new ItemStack(Material.PRISMARINE_SHARD),getGradientName("鱼饵·记忆碎片"),
                    getGradientName("这个鱼饵可以钓到任何物品"),
                    getGradientName("他存在于过去或者是未来"),
                    getGradientName("你现在看到的他并非真正的他")),
                    "fishLureFinal")
    );

    private static final Set<ItemStack> RANDOM_FISH_TYPES = new HashSet<>();

    static {
        RANDOM_FISH_TYPES.add(MagicExpansionItems.RANDOM_FISH_COMMON);
        RANDOM_FISH_TYPES.add(MagicExpansionItems.RANDOM_FISH_UNCOMMON);
        RANDOM_FISH_TYPES.add(MagicExpansionItems.RANDOM_FISH_RARE);
        RANDOM_FISH_TYPES.add(MagicExpansionItems.RANDOM_FISH_RARE_POOL_DUST);
        RANDOM_FISH_TYPES.add(MagicExpansionItems.RANDOM_FISH_RARE_POOL_ORE);
        RANDOM_FISH_TYPES.add(MagicExpansionItems.RANDOM_FISH_RARE_POOL_INDUSTRY);
        RANDOM_FISH_TYPES.add(MagicExpansionItems.RANDOM_FISH_EPIC);
        RANDOM_FISH_TYPES.add(MagicExpansionItems.RANDOM_FISH_EPIC_POOL_INDUSTRY);
        RANDOM_FISH_TYPES.add(MagicExpansionItems.RANDOM_FISH_EPIC_POOL_ALLOY_INGOT);
        RANDOM_FISH_TYPES.add(MagicExpansionItems.RANDOM_FISH_LEGENDARY);

    }




    @EventHandler
    public void onFish(PlayerFishEvent e) {
        if (e.getState() != PlayerFishEvent.State.CAUGHT_FISH) return;

        Player player = e.getPlayer();
        ItemStack rod = player.getInventory().getItemInMainHand();

        SlimefunItem sfItem = SlimefunItem.getByItem(rod);







        if (!(sfItem instanceof FishingRod fishingRod)) return;

        Set<String> supportedKeys = fishingRod.getLootTable().keySet();

        Lure activeLure = null;

        ItemStack offHand = player.getInventory().getItemInOffHand();
        if (offHand != null) {
            activeLure = LURES.stream()
                    .filter(lure -> supportedKeys.contains(lure.getKey())) // 鱼竿支持
                    .filter(lure -> SlimefunUtils.isItemSimilar(offHand, lure.getItem(), true))
                    .findFirst()
                    .orElse(null);
        }
        if (activeLure == null) {
            activeLure = LURES.stream()
                    .filter(lure -> supportedKeys.contains(lure.getKey()))
                    .filter(lure -> lure.hasLure(player))
                    .findFirst()
                    .orElse(null);
        }
        if (activeLure != null) {
            consumeLure(player, activeLure);
        }
        ItemStack drop = getSmartLoot(player, fishingRod).clone();
        Entity hook = e.getHook();
        Location hookLocation = hook.getLocation();

        Entity caught = e.getCaught();
        if (caught instanceof Item item) {
            item.remove();
        }

        if(isAnythingItem(drop)){
            drop = getRandomItemStack();
        }


        if (isRandomFish(drop)) {
            drop = FishKeys.enchantDropWithFishData(player, drop, rod);
        }


        if (drop != null) {
            Item rewardItem = player.getWorld().dropItem(hookLocation, drop);
            rewardItem.setPickupDelay(0);
            Vector direction = player.getLocation().add(0,2,0).toVector()
                    .subtract(hookLocation.toVector())
                    .normalize()
                    .multiply(2.5);
            rewardItem.setVelocity(direction);
            rewardItem.setGlowing(true);
        }
        String itemName = ItemStackHelper.getDisplayName(drop);
        String message = phrases.get(new Random().nextInt(phrases.size()));
        player.sendMessage((ColorGradient.getRandomGradientName(message))+" §r"+itemName+ColorGradient.getRandomGradientName(" ！！"));
    }

    List<String> phrases = List.of(
            "💨 水面泛起漩涡，你钓上了：",
            "⚡ 鱼竿一颤，你拉到了：",
            "❄ 寒光一闪，你捞起：",
            "★ 欧气爆发！你钓到了：",
            "☆ 闪光！你钓上了：",
            "♪ 听，BGM响了：",
            "♫ 恭喜！你钓到了：",
            "∞ 钓鱼佬永不空军！：",
            "✓ 成功捕获：",
            "✗ 又是垃圾：",
            "☀ 今日晴，适合欧：",
            "☁ 今天非酋附体："
    );

    private boolean isRandomFish(ItemStack item) {
        if (item == null || item.getType().isAir()) return false;
        for (ItemStack randomFish : RANDOM_FISH_TYPES) {
            if (SlimefunUtils.isItemSimilar(item, randomFish, true)) {
                return true;
            }
        }
        return false;
    }
    private boolean isAnythingItem(ItemStack item) {
        if (item == null || item.getType().isAir()) return false;
        return SlimefunUtils.isItemSimilar(item, FISHING_ROD_FISH_ANYTHING, true);
    }


    private ItemStack getSmartLoot(Player player, FishingRod fishingRod) {
        Set<String> supportedKeys = fishingRod.getLootTable().keySet();
        Lure activeLure = null;
        ItemStack offHand = player.getInventory().getItemInOffHand();
        if (offHand != null) {
            activeLure = LURES.stream()
                    .filter(lure -> supportedKeys.contains(lure.getKey())) // 鱼竿支持
                    .filter(lure -> SlimefunUtils.isItemSimilar(offHand, lure.getItem(), true))
                    .findFirst()
                    .orElse(null);
        }
        if (activeLure == null) {
            activeLure = LURES.stream()
                    .filter(lure -> supportedKeys.contains(lure.getKey()))
                    .filter(lure -> lure.hasLure(player))
                    .findFirst()
                    .orElse(null);
        }
        List<WeightedItem> pool = fishingRod.getLootPoolForLure(activeLure);
        return getRandomItemFromWeightedPool(pool != null ? pool : getDefaultLootPool());
    }

    private ItemStack getRandomItemFromWeightedPool(List<WeightedItem> pool) {
        int total = pool.stream().mapToInt(WeightedItem::getWeight).sum();
        int r = new Random().nextInt(total), current = 0;
        for (WeightedItem w : pool) if ((current += w.getWeight()) > r) return w.getItem().clone();
        return pool.get(0).getItem().clone();
    }

    private List<WeightedItem> getDefaultLootPool() {
        return List.of(
                new WeightedItem(new ItemStack(Material.COD), 50),
                new WeightedItem(new ItemStack(Material.INK_SAC), 30)
        );
    }

    private void consumeLure(Player player, Lure lure) {
        PlayerInventory inv = player.getInventory();
        ItemStack requiredItem = lure.getItem();

        for (int i = 0; i < inv.getSize(); i++) {
            ItemStack item = inv.getItem(i);
            if (item != null &&
                    SlimefunUtils.isItemSimilar(item, requiredItem, true)) {
                if (item.getAmount() > 1) {
                    item.setAmount(item.getAmount() - 1);
                    player.sendMessage((ColorGradient.getRandomGradientName("钓鱼佬，你消耗了 1 个"))+" §r"+ItemStackHelper.getDisplayName(item)+ ColorGradient.getRandomGradientName(" ！"));
                } else {
                    inv.setItem(i, null);
                    player.sendMessage(ItemStackHelper.getDisplayName(item)+ColorGradient.getRandomGradientName(" 是刚才那一组的最后 1 个！"));
                }
                player.updateInventory();
                break;
            }
        }
    }



}

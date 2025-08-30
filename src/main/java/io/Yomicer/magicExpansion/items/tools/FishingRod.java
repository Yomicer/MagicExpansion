package io.Yomicer.magicExpansion.items.tools;

import io.Yomicer.magicExpansion.items.misc.Lure;
import io.Yomicer.magicExpansion.items.misc.WeightedItem;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

public class FishingRod extends SlimefunItem {

    private final Map<Enchantment, Integer> enchantments;
    private final boolean glow;
    private final Map<String, List<WeightedItem>> lootTable;
    /**
     * 构造器
     *
     * @param itemGroup   分类
     * @param item        物品
     * @param recipeType  合成方式
     * @param recipe      合成表
     * @param enchantments 要添加的附魔（附魔 -> 等级）
     * @param glow         是否显示附魔光效（true=发光，false=隐藏附魔）
     */
    public FishingRod(ItemGroup itemGroup,
                      SlimefunItemStack item,
                      RecipeType recipeType,
                      ItemStack[] recipe,
                      Map<Enchantment, Integer> enchantments,
                      boolean glow,
                      Map<String, List<WeightedItem>> lootTable) {
        super(itemGroup, item, recipeType, recipe);
        this.enchantments = enchantments;
        this.glow = glow;
        this.lootTable = lootTable;
    }


    @Override
    public void preRegister() {
        ItemStack itemStack = getItem();
        ItemMeta meta = itemStack.getItemMeta();

        if (meta != null) {
            // 1. 设置无法破坏（原有功能）
            meta.setUnbreakable(true);

            // 2. 添加外部传入的附魔
            if (enchantments != null && !enchantments.isEmpty()) {
                for (Map.Entry<Enchantment, Integer> entry : enchantments.entrySet()) {
                    Enchantment enchant = entry.getKey();
                    int level = entry.getValue();
                    if (enchant != null && level > 0) {
                        meta.addEnchant(enchant, level, true);
                    }
                }
            }
            if (!glow) {
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
            }
            itemStack.setItemMeta(meta);
        }

    }
    public List<WeightedItem> getLootPoolForLure(Lure lure) {
        String key = lure != null ? lure.getKey() : "default";
        return lootTable.getOrDefault(key, getDefaultLootPool());
    }

    private List<WeightedItem> getDefaultLootPool() {
        return List.of(
                new WeightedItem(new ItemStack(Material.COD), 50),
                new WeightedItem(new ItemStack(Material.INK_SAC), 30)
        );
    }

    // ✅ 新增：暴露 lootMap
    public Map<String, List<WeightedItem>> getLootTable() {
        return lootTable;
    }




}

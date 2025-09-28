package io.Yomicer.magicExpansion.Listener;

import io.Yomicer.magicExpansion.utils.log.Debug;
import io.github.thebusybiscuit.slimefun4.api.events.SlimefunItemRegistryFinalizedEvent;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RecipePreLoader implements Listener {

    // 存储每种机器类型的配方列表
    private static final Map<RecipeType, List<Map<ItemStack, Integer>>> RECIPES_BY_TYPE = new ConcurrentHashMap<>();

    // 外部常量引用
    public static final List<Map<ItemStack, Integer>> ENHANCED_CRAFTING_TABLE_RECIPES = getOrCreateList(RecipeType.ENHANCED_CRAFTING_TABLE);
    public static final List<Map<ItemStack, Integer>> ARMOR_FORGE_RECIPES = getOrCreateList(RecipeType.ARMOR_FORGE);
    public static final List<Map<ItemStack, Integer>> ANCIENT_ALTAR_RECIPES = getOrCreateList(RecipeType.ANCIENT_ALTAR);
    public static final List<Map<ItemStack, Integer>> GOLD_PAN_RECIPES = getOrCreateList(RecipeType.GOLD_PAN);
    public static final List<Map<ItemStack, Integer>> HEATED_PRESSURE_CHAMBER_RECIPES = getOrCreateList(RecipeType.HEATED_PRESSURE_CHAMBER);
    public static final List<Map<ItemStack, Integer>> MAGIC_WORKBENCH_RECIPES = getOrCreateList(RecipeType.MAGIC_WORKBENCH);
    public static final List<Map<ItemStack, Integer>> ORE_CRUSHER_RECIPES = getOrCreateList(RecipeType.ORE_CRUSHER);

    @EventHandler
    public void onSlimefunRegistryFinalized(SlimefunItemRegistryFinalizedEvent event) {

        long start = System.currentTimeMillis();

        loadRecipes(ENHANCED_CRAFTING_TABLE_RECIPES, RecipeType.ENHANCED_CRAFTING_TABLE);
        loadRecipes(ARMOR_FORGE_RECIPES, RecipeType.ARMOR_FORGE);
        loadRecipes(ANCIENT_ALTAR_RECIPES, RecipeType.ANCIENT_ALTAR);
        loadRecipes(GOLD_PAN_RECIPES, RecipeType.GOLD_PAN);
        loadRecipes(HEATED_PRESSURE_CHAMBER_RECIPES, RecipeType.HEATED_PRESSURE_CHAMBER);
        loadRecipes(MAGIC_WORKBENCH_RECIPES, RecipeType.MAGIC_WORKBENCH);
        loadRecipes(ORE_CRUSHER_RECIPES, RecipeType.ORE_CRUSHER);

        long time = System.currentTimeMillis() - start;
        Debug.logInfo("✅ 配方预加载完成，耗时 " + time + "ms");
    }

    /**
     * 加载指定 RecipeType 的所有配方
     */
    private void loadRecipes(List<Map<ItemStack, Integer>> recipeList, RecipeType type) {
        if (recipeList == null || type == null) return;

        // ✅ 最兼容方式获取所有物品：通过 SlimefunRegistry
        Map<?, SlimefunItem> items = Slimefun.getRegistry().getSlimefunItemIds();

        int count = 0;

        for (SlimefunItem item : items.values()) {
            if (item == null) continue;

            // 检查 RecipeType 是否匹配
            if (item.getRecipeType() != type) {
                continue;
            }

            ItemStack[] recipe = item.getRecipe();
            if (recipe == null || recipe.length == 0) continue;

            // 检查是否有有效材料
            boolean hasIngredient = false;
            for (ItemStack ing : recipe) {
                if (ing != null && ing.getType() != Material.AIR) {
                    hasIngredient = true;
                    break;
                }
            }
            if (!hasIngredient) continue;

            Map<ItemStack, Integer> recipeMap = new HashMap<>();

            for (ItemStack ingredient : recipe) {
                if (ingredient == null || ingredient.getType() == Material.AIR) {
                    continue;
                }

                // 合并相同物品
                boolean merged = false;
                for (ItemStack key : recipeMap.keySet()) {
                    if (isSimilar(key, ingredient)) {
                        recipeMap.put(key, recipeMap.get(key) + ingredient.getAmount());
                        merged = true;
                        break;
                    }
                }

                if (!merged) {
                    recipeMap.put(ingredient.clone(), ingredient.getAmount());
                }
            }

            if (!recipeMap.isEmpty()) {
                recipeList.add(Collections.unmodifiableMap(new HashMap<>(recipeMap)));
                count++;
            }
        }

        // ✅ 显示机器名称（fallback 到 toString）
        String typeName = getRecipeTypeName(type);
        Debug.logInfo("📊 已加载 [" + typeName + "] 类型配方: " + count + " 个");
    }
    /**
     * 获取 RecipeType 的显示名称（尽可能友好）
     */
    private String getRecipeTypeName(RecipeType type) {
        // 如果你有自定义名称映射，可以在这里加
        Map<RecipeType, String> NAMES = new HashMap<>();
        NAMES.put(RecipeType.ENHANCED_CRAFTING_TABLE, "增强型合成台");
        NAMES.put(RecipeType.ARMOR_FORGE, "盔甲锻造台");
        NAMES.put(RecipeType.ANCIENT_ALTAR, "远古祭坛");
        NAMES.put(RecipeType.GOLD_PAN, "淘金盘");
        NAMES.put(RecipeType.HEATED_PRESSURE_CHAMBER, "加热压力室");
        NAMES.put(RecipeType.MAGIC_WORKBENCH, "魔法工作台");
        NAMES.put(RecipeType.ORE_CRUSHER, "矿物粉碎机");

        return NAMES.getOrDefault(type, type.toString());
    }


    /**
     * 判断两个 ItemStack 是否相似（类型相同即可，或可扩展 NBT 比较）
     */
    private boolean isSimilar(ItemStack a, ItemStack b) {
        if (a == null || b == null) return false;
        if (a.getType() != b.getType()) return false;
        return a.getDurability() == b.getDurability();
    }

    /**
     * 初始化或获取列表
     */
    private static List<Map<ItemStack, Integer>> getOrCreateList(RecipeType type) {
        List<Map<ItemStack, Integer>> list = new ArrayList<>();
        RECIPES_BY_TYPE.put(type, Collections.unmodifiableList(list));
        return list;
    }

    // ✅ 获取某个机器的所有配方
    public static List<Map<ItemStack, Integer>> getRecipes(RecipeType type) {
        return RECIPES_BY_TYPE.getOrDefault(type, Collections.emptyList());
    }

    // ✅ 获取所有已加载类型
    public static Set<RecipeType> getLoadedTypes() {
        return Collections.unmodifiableSet(new HashSet<>(RECIPES_BY_TYPE.keySet()));
    }


}

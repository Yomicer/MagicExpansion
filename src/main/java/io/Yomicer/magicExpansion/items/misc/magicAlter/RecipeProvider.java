package io.Yomicer.magicExpansion.items.misc.magicAlter;

import org.bukkit.Material;

import java.util.List;
import java.util.Map;

public interface RecipeProvider {
    void registerRecipes(Map<String, MagicAltarRecipe> recipes);
    void registerAltarPatterns(List<Material[][]> patternList);
}

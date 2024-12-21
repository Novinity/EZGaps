package me.novinity.eZGaps;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Iterator;
import java.util.function.Supplier;
import java.util.logging.Level;

public final class EZGaps extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Iterator<Recipe> iter = getServer().recipeIterator();
        while (iter.hasNext()) {
            Recipe r = iter.next();
            if (r.getResult().getType().equals(Material.GOLDEN_APPLE)) {
                iter.remove();
            }
        }

        ShapedRecipe gappleRecipe = new ShapedRecipe(new NamespacedKey(this, "golden_apple"), new ItemStack(Material.GOLDEN_APPLE, 1));
        gappleRecipe.shape(" G ", "GXG", " G ");
        gappleRecipe.setIngredient('G', Material.GOLD_INGOT);
        gappleRecipe.setIngredient('X', Material.APPLE);

        Bukkit.addRecipe(gappleRecipe);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

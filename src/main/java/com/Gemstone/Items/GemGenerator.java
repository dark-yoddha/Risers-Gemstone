package com.Gemstone.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GemGenerator implements Listener {

    /**
     * A central dispatcher method to create a specific gem by its name.
     * This method calls the appropriate dedicated creation method for each gem type.
     *
     * @param gemName The full name of the gem (e.g., "Water Gem", "Air Gem").
     * @param modelData The CustomModelData integer for the gem's texture.
     * @return The created ItemStack representing the gem.
     */
    public static ItemStack createGem(String gemName, int modelData) {
        // Remove color codes and convert to lowercase for consistent checking
        String key = ChatColor.stripColor(gemName.toLowerCase());

        switch (key) {
            case "water gem":
                return createWaterGem(modelData);
            case "shock gem":
                return createShockGem(modelData);
            case "air gem":
                return createAirGem(modelData);
            case "fire gem":
                return createFireGem(modelData);
            case "strength gem":
                return createStrengthGem(modelData);
            case "speed gem":
                return createSpeedGem(modelData);
            case "spirit gem":
                return createSpiritGem(modelData);
            case "luck gem":
                return createLuckGem(modelData);
            case "curse gem":
                return createCurseGem(modelData);
            case "healing gem":
                return createHealingGem(modelData);
            default:
                // Return null or a default item if the gem name is not recognized.
                return null;
        }
    }

    /**
     * Creates a standardized lore list for the gems.
     *
     * @param description The lore description of the gem.
     * @param abilities A list of strings, each representing a single ability.
     * @return A formatted List of Strings for the item's lore.
     */
    private static List<String> createLore(String description, List<String> abilities) {
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + description);
        lore.add("");
        lore.add(ChatColor.WHITE + "" + ChatColor.BOLD + "Abilities:");

        // Add each ability to the lore
        for (String ability : abilities) {
            lore.add(ChatColor.AQUA + "• " + ChatColor.GRAY + ability);
        }

        lore.add("");
        lore.add(ChatColor.WHITE + "" + ChatColor.BOLD + "Activation:");
        lore.add(ChatColor.AQUA + "• " + ChatColor.GRAY + "" + ChatColor.ITALIC + "Shift + 5 fast right clicks" + ChatColor.RESET + ChatColor.GRAY + " to awaken its power.");

        return lore;
    }

    // --- Specific Gemstone Creation Methods ---

    public static ItemStack createWaterGem(int modelData) {
        // Water Gem is now a Trident with specific enchantments
        ItemStack waterGem = new ItemStack(Material.TRIDENT);
        ItemMeta meta = waterGem.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.BLUE + "Water Gem");
            meta.setCustomModelData(modelData);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

            // Add enchantments as requested
            meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
            meta.addEnchant(Enchantment.RIPTIDE, 3, true);
            meta.addEnchant(Enchantment.SHARPNESS, 5, true);

            List<String> abilities = new ArrayList<>();
            abilities.add("Grants effects when in water or when it rains/thunders.");
            abilities.add("Deals 1.5x less damage in the Nether.");

            // Updated lore: concise and to the point
            meta.setLore(createLore(
                    "Depths and powerful currents.",
                    abilities
            ));
            waterGem.setItemMeta(meta);
        }
        return waterGem;
    }

    public static ItemStack createShockGem(int modelData) {
        // Shock Gem is now a Trident with specific enchantments
        ItemStack shockGem = new ItemStack(Material.TRIDENT);
        ItemMeta meta = shockGem.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.AQUA + "Shock Gem");
            meta.setCustomModelData(modelData);
            meta.setUnbreakable(true);
            meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);

            // Add enchantments as requested
            meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);
            meta.addEnchant(Enchantment.LOYALTY, 3, true);
            meta.addEnchant(Enchantment.SHARPNESS, 5, true);

            List<String> abilities = new ArrayList<>();
            abilities.add("Can summon a lightning strike.");
            abilities.add("Gives effects when this ability is used.");

            // Updated lore: concise and to the point
            meta.setLore(createLore(
                    "Raw electricity and storms.",
                    abilities
            ));
            shockGem.setItemMeta(meta);
        }
        return shockGem;
    }

    public static ItemStack createAirGem(int modelData) {
        // Air Gem is now a White Dye
        ItemStack airGem = new ItemStack(Material.WHITE_DYE);
        ItemMeta meta = airGem.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.WHITE + "Air Gem");
            meta.setUnbreakable(true);
            meta.setCustomModelData(modelData);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);

            // Add enchantment as requested
            meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);

            List<String> abilities = new ArrayList<>();
            abilities.add("Can use unlimited Wind Charges.");
            abilities.add("Can enchant a mace with Wind Burst 3.");
            abilities.add("Grants resistance to fall damage.");

            // Updated lore: concise and to the point
            meta.setLore(createLore(
                    "Untamed energy of wind.",
                    abilities
            ));
            airGem.setItemMeta(meta);
        }
        return airGem;
    }

    public static ItemStack createFireGem(int modelData) {
        // Fire Gem is now an Orange Dye
        ItemStack fireGem = new ItemStack(Material.ORANGE_DYE);
        ItemMeta meta = fireGem.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.GOLD + "Fire Gem");
            meta.setUnbreakable(true);
            meta.setCustomModelData(modelData);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);

            // Add enchantment as requested
            meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);

            List<String> abilities = new ArrayList<>();
            abilities.add("Grants resistance to fire and lava damage.");
            abilities.add("Gives effects when the player is on fire.");
            abilities.add("Deals 1.5x more damage in the Nether.");

            // Updated lore: concise and to the point
            meta.setLore(createLore(
                    "Primordial fire's fury.",
                    abilities
            ));
            fireGem.setItemMeta(meta);
        }
        return fireGem;
    }

    public static ItemStack createStrengthGem(int modelData) {
        // Strength Gem is now a Red Dye
        ItemStack strengthGem = new ItemStack(Material.RED_DYE);
        ItemMeta meta = strengthGem.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.RED + "Strength Gem");
            meta.setUnbreakable(true);
            meta.setCustomModelData(modelData);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);

            // Add enchantment as requested
            meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);

            List<String> abilities = new ArrayList<>();
            abilities.add("Grants a Strength effect.");
            abilities.add("Can enchant a sword with Sharpness 5.");

            // Updated lore: concise and to the point
            meta.setLore(createLore(
                    "Titan's will, immense power.",
                    abilities
            ));
            strengthGem.setItemMeta(meta);
        }
        return strengthGem;
    }

    public static ItemStack createSpeedGem(int modelData) {
        // Speed Gem is now a Light Blue Dye
        ItemStack speedGem = new ItemStack(Material.LIGHT_BLUE_DYE);
        ItemMeta meta = speedGem.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.DARK_AQUA + "Speed Gem");
            meta.setUnbreakable(true);
            meta.setCustomModelData(modelData);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);

            // Add enchantment as requested
            meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);

            List<String> abilities = new ArrayList<>();
            abilities.add("Has a 10-block teleportation ability.");
            abilities.add("Grants a Speed effect.");

            // Updated lore: concise and to the point
            meta.setLore(createLore(
                    "Essence of sprinting wind.",
                    abilities
            ));
            speedGem.setItemMeta(meta);
        }
        return speedGem;
    }

    public static ItemStack createSpiritGem(int modelData) {
        // Spirit Gem is now a Gray Dye
        ItemStack spiritGem = new ItemStack(Material.GRAY_DYE);
        ItemMeta meta = spiritGem.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.GRAY + "Spirit Gem");
            meta.setUnbreakable(true);
            meta.setCustomModelData(modelData);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);

            // Add enchantment as requested
            meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);

            List<String> abilities = new ArrayList<>();
            abilities.add("Can capture mobs and contain their spirits.");
            abilities.add("Can resummon the captured spirits to attack opponents.");

            // Updated lore: concise and to the point
            meta.setLore(createLore(
                    "Ethereal threads of a forgotten realm.",
                    abilities
            ));
            spiritGem.setItemMeta(meta);
        }
        return spiritGem;
    }

    public static ItemStack createLuckGem(int modelData) {
        // Luck Gem is now a Lime Dye
        ItemStack luckGem = new ItemStack(Material.LIME_DYE);
        ItemMeta meta = luckGem.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.GREEN + "Luck Gem");
            meta.setUnbreakable(true);
            meta.setCustomModelData(modelData);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);

            // Add enchantment as requested
            meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);

            List<String> abilities = new ArrayList<>();
            abilities.add("Can enchant swords with Looting 5.");
            abilities.add("Can enchant pickaxes with Fortune 5.");
            abilities.add("Grants a Luck effect.");

            // Updated lore: concise and to the point
            meta.setLore(createLore(
                    "Twists the threads of fate.",
                    abilities
            ));
            luckGem.setItemMeta(meta);
        }
        return luckGem;
    }

    public static ItemStack createCurseGem(int modelData) {
        // Curse Gem is now a Black Dye
        ItemStack curseGem = new ItemStack(Material.BLACK_DYE);
        ItemMeta meta = curseGem.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.DARK_RED + "Curse Gem");
            meta.setUnbreakable(true);
            meta.setCustomModelData(modelData);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);

            // Add enchantment as requested
            meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);

            List<String> abilities = new ArrayList<>();
            abilities.add("Applies Wither and Blindness effects to opponents.");
            abilities.add("Deals 1.5x more damage in the Nether.");
            abilities.add("Deals 1.5x less damage in the Overworld.");

            // Updated lore: concise and to the point
            meta.setLore(createLore(
                    "Malevolent, corrupting power.",
                    abilities
            ));
            curseGem.setItemMeta(meta);
        }
        return curseGem;
    }

    public static ItemStack createHealingGem(int modelData) {
        // Healing Gem is now a Pink Dye
        ItemStack healingGem = new ItemStack(Material.PINK_DYE);
        ItemMeta meta = healingGem.getItemMeta();
        if (meta != null) {
            meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Healing Gem");
            meta.setUnbreakable(true);
            meta.setCustomModelData(modelData);
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);

            // Add enchantment as requested
            meta.addEnchant(Enchantment.BINDING_CURSE, 1, true);

            List<String> abilities = new ArrayList<>();
            abilities.add("Gives 4 extra hearts to the player.");
            abilities.add("Grants Regeneration and Resistance effects.");
            abilities.add("Gives effects to players within a 5-block radius for a short time.");

            // Updated lore: concise and to the point
            meta.setLore(createLore(
                    "Life force of the world.",
                    abilities
            ));
            healingGem.setItemMeta(meta);
        }
        return healingGem;
    }
}
package com.Gemstone.Commands;

import java.util.*;
import org.bukkit.command.*;

public class GemstoneTabCompleter implements TabCompleter {
    private final List<String> gems = Arrays.asList("strength", "fire", "speed", "spirit", "luck", "curse", "healing", "air", "shock", "water");

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            completions.add("give");
            completions.add("take");
            completions.add("reload");
            return filterList(completions, args[0]);
        }

        if (args.length == 2 && (args[0].equalsIgnoreCase("give") || args[0].equalsIgnoreCase("take"))) {
            return null;
        }

        if (args.length == 3 && (args[0].equalsIgnoreCase("give") || args[0].equalsIgnoreCase("take"))) {
            return filterList(gems, args[2]);
        }

        return Collections.emptyList();
    }

    private List<String> filterList(List<String> original, String input) {
        List<String> filtered = new ArrayList<>();
        String lowerInput = input.toLowerCase();
        for (String item : original) {
            if (item.toLowerCase().startsWith(lowerInput)) {
                filtered.add(item);
            }
        }
        return filtered;
    }
}
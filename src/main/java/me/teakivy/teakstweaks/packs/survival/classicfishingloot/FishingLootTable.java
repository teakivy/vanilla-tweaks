package me.teakivy.teakstweaks.packs.survival.classicfishingloot;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class FishingLootTable {

    static HashMap<Enchantment, Integer> enchants = new HashMap<>();

    public static void register() {
        if (enchants.isEmpty()) {
            addEnchant(Enchantment.MENDING, 1);
            addEnchant(Enchantment.UNBREAKING, 3);
            addEnchant(Enchantment.VANISHING_CURSE, 1);

            addEnchant(Enchantment.AQUA_AFFINITY, 1);
            addEnchant(Enchantment.BLAST_PROTECTION, 4);
            addEnchant(Enchantment.BINDING_CURSE, 1);
            addEnchant(Enchantment.DEPTH_STRIDER, 3);
            addEnchant(Enchantment.FEATHER_FALLING, 4);
            addEnchant(Enchantment.FIRE_PROTECTION, 4);
            addEnchant(Enchantment.FROST_WALKER, 2);
            addEnchant(Enchantment.PROJECTILE_PROTECTION, 4);
            addEnchant(Enchantment.PROTECTION, 4);
            addEnchant(Enchantment.RESPIRATION, 3);
            addEnchant(Enchantment.SOUL_SPEED, 3);
            addEnchant(Enchantment.THORNS, 3);

            addEnchant(Enchantment.BANE_OF_ARTHROPODS, 5);
            addEnchant(Enchantment.CHANNELING, 1);
            addEnchant(Enchantment.EFFICIENCY, 5);
            addEnchant(Enchantment.FIRE_ASPECT, 1);
            addEnchant(Enchantment.LOOTING, 3);
            addEnchant(Enchantment.KNOCKBACK, 2);
            addEnchant(Enchantment.SHARPNESS, 5);
            addEnchant(Enchantment.SMITE, 5);
            addEnchant(Enchantment.SWEEPING_EDGE, 3);

            addEnchant(Enchantment.FLAME, 1);
            addEnchant(Enchantment.IMPALING, 5);
            addEnchant(Enchantment.INFINITY, 1);
            addEnchant(Enchantment.LOYALTY, 3);
            addEnchant(Enchantment.RIPTIDE, 3);
            addEnchant(Enchantment.MULTISHOT, 1);
            addEnchant(Enchantment.PIERCING, 4);
            addEnchant(Enchantment.POWER, 5);
            addEnchant(Enchantment.PUNCH, 2);
            addEnchant(Enchantment.QUICK_CHARGE, 3);

            addEnchant(Enchantment.FORTUNE, 3);
            addEnchant(Enchantment.LURE, 3);
            addEnchant(Enchantment.LUCK_OF_THE_SEA, 3);
            addEnchant(Enchantment.SILK_TOUCH, 1);
        }
    }

    private static void addEnchant(Enchantment enchantment, Integer maxLevel) {
        enchants.put(enchantment, maxLevel);
    }

    public static ItemStack generateFishingLoot(int los, boolean inJungle) {
        Random rand = new Random();
        double lootType = (rand.nextInt(10000) + 1) / 100;
        if (!inJungle) {
            if (los == 0) {
                if (lootType <= 85) {
                    return generateFishLoot(60, 25, 2, 13);
                }
                if (lootType <= 85 + 5) {
                    return generateTreasureLoot(16.7, 16.7, 16.7, 16.7, 16.7, 16.7);
                }
                return generateJunkLoot(17, 10, 2, 10, 10, 10, 5, 5,  10, 10, 1, 10);
            }
            if (los == 1) {
                if (lootType <= 84.8) {
                    return generateFishLoot(60.1, 25, 2, 12.9);
                }
                if (lootType <= 84.8 + 7.1) {
                    return generateTreasureLoot(16.7, 16.7, 16.7, 16.7, 16.7, 16.7);
                }
                return generateJunkLoot(17, 10, 2, 10, 10, 10, 5, 5,  10, 10, 1, 10);
            }
            if (los == 2) {
                if (lootType <= 84.8) {
                    return generateFishLoot(59.9, 25.02, 2.007, 13);
                }
                if (lootType <= 84.8 + 9.2) {
                    return generateTreasureLoot(16.7, 16.7, 16.7, 16.7, 16.7, 16.7);
                }
                return generateJunkLoot(17, 10, 2, 10, 10, 10, 5, 5,  10, 10, 1, 10);
            }
            if (los == 3) {
                if (lootType <= 84.5) {
                    return generateFishLoot(60, 25, 2, 13);
                }
                if (lootType <= 84.5 + 11.3) {
                    return generateTreasureLoot(16.7, 16.7, 16.7, 16.7, 16.7, 16.7);
                }
                return generateJunkLoot(17, 10, 2, 10, 10, 10, 5, 5,  10, 10, 1, 10);
            }
            if (los > 3 && los < 10) {
                if (lootType <= 60) {
                    return generateFishLoot(60, 25, 2, 13);
                }
                if (lootType <= 60 + 38) {
                    return generateTreasureLoot(16.7, 16.7, 16.7, 16.7, 16.7, 16.7);
                }
                return generateJunkLoot(17, 10, 2, 10, 10, 10, 5, 5,  10, 10, 1, 10);
            }
            if (los >= 10) {
                return generateTreasureLoot(16.7, 16.7, 16.7, 16.7, 16.7, 16.7);
            }
        }
        return new ItemStack(Material.COD);
    }


    private static ItemStack generateFishLoot(double cod, double salmon, double tropical, double pufferfish) {
        Random rand = new Random();
        int fish = rand.nextInt(100) + 1;
        if (fish <= cod) {
            return new ItemStack(Material.COD);
        }
        if (fish <= cod + salmon) {
            return new ItemStack(Material.SALMON);
        }
        if (fish <= cod + salmon + tropical) {
            return new ItemStack(Material.TROPICAL_FISH);
        }
        return new ItemStack(Material.PUFFERFISH);
    }

    private static ItemStack generateTreasureLoot(double bow, double enchantedBook, double fishingRod, double nameTag, double nautilusShell, double saddle) {
        Random rand = new Random();
        int fish = rand.nextInt(100) + 1;
        if (fish <= bow) {
            return getTreasureBow();
        }
        if (fish <= bow + enchantedBook) {
            return getTreasureBook();
        }
        if (fish <= bow + enchantedBook + fishingRod) {
            return getTreasureFishingRod();
        }
        if (fish <= bow + enchantedBook + fishingRod + nameTag) {
            return new ItemStack(Material.NAME_TAG);
        }
        if (fish <= bow + enchantedBook + fishingRod + nameTag + nautilusShell) {
            return new ItemStack(Material.NAUTILUS_SHELL);
        }
        return new ItemStack(Material.SADDLE);
    }

    private static ItemStack generateJunkLoot(double lilyPad, double bowl, double fishingRod, double leather, double leatherBoots, double rottenFlesh, double stick, double string, double waterBottls, double bone, double inkSac, double tripwireHook) {
        Random rand = new Random();
        int fish = rand.nextInt(100) + 1;
        if (fish <= lilyPad) {
            return new ItemStack(Material.LILY_PAD);
        }
        if (fish <= lilyPad + bowl) {
            return new ItemStack(Material.BOWL);
        }
        if (fish <= lilyPad + bowl + fishingRod) {
            return getJunkFishingRod();
        }
        if (fish <= lilyPad + bowl + fishingRod + leather) {
            return new ItemStack(Material.LEATHER);
        }
        if (fish <= lilyPad + bowl + fishingRod + leather + leatherBoots) {
            return getJunkBoots();
        }
        if (fish <= lilyPad + bowl + fishingRod + leather + leatherBoots + rottenFlesh) {
            return new ItemStack(Material.ROTTEN_FLESH);
        }
        if (fish <= lilyPad + bowl + fishingRod + leather + leatherBoots + rottenFlesh + stick) {
            return new ItemStack(Material.STICK);
        }
        if (fish <= lilyPad + bowl + fishingRod + leather + leatherBoots + rottenFlesh + stick + string) {
            return new ItemStack(Material.STRING);
        }
        if (fish <= lilyPad + bowl + fishingRod + leather + leatherBoots + rottenFlesh + stick + waterBottls + bone) {
            return new ItemStack(Material.BONE);
        }
        if (fish <= lilyPad + bowl + fishingRod + leather + leatherBoots + rottenFlesh + stick + waterBottls + bone + inkSac) {
            return new ItemStack(Material.INK_SAC);
        }
        return new ItemStack(Material.TRIPWIRE_HOOK);
    }

    public static ItemStack getJunkFishingRod() {
        ItemStack item = new ItemStack(Material.FISHING_ROD);
        item.setDurability((short) (new Random().nextInt(item.getType().getMaxDurability()) + 1));
        return item;
    }

    public static ItemStack getJunkBoots() {
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
        item.setDurability((short) (new Random().nextInt(item.getType().getMaxDurability()) + 1));
        return item;
    }

    public static ItemStack getTreasureBow() {
        ItemStack item = new ItemStack(Material.BOW);

        HashMap<Enchantment, Integer> possibleEnchants = new HashMap<>();
        possibleEnchants.put(Enchantment.FLAME, 1);
        possibleEnchants.put(Enchantment.INFINITY, 1);
        possibleEnchants.put(Enchantment.MENDING, 1);
        possibleEnchants.put(Enchantment.POWER, 5);
        possibleEnchants.put(Enchantment.PUNCH, 2);
        possibleEnchants.put(Enchantment.UNBREAKING, 3);

        Random rand = new Random();

        List<Enchantment> enchantments = new ArrayList<>();
        possibleEnchants.forEach((enchant, max) -> {
            enchantments.add(enchant);
        });

        for (int i = 0; i < possibleEnchants.size(); i++) {
            if (rand.nextInt(4) == 2) {
                if (!(enchantments.get(i) == Enchantment.MENDING && item.getEnchantments().containsKey(Enchantment.INFINITY))) {
                    item.addUnsafeEnchantment(enchantments.get(i), rand.nextInt(possibleEnchants.get(enchantments.get(i))) + 1);
                }
            }
        }

        item.setDurability((short) (rand.nextInt(item.getType().getMaxDurability()) + 1));
        return item;
    }

    public static ItemStack getTreasureFishingRod() {
        ItemStack item = new ItemStack(Material.FISHING_ROD);

        HashMap<Enchantment, Integer> possibleEnchants = new HashMap<>();
        possibleEnchants.put(Enchantment.LUCK_OF_THE_SEA, 3);
        possibleEnchants.put(Enchantment.LURE, 3);
        possibleEnchants.put(Enchantment.MENDING, 1);
        possibleEnchants.put(Enchantment.UNBREAKING, 3);

        Random rand = new Random();

        List<Enchantment> enchantments = new ArrayList<>();
        possibleEnchants.forEach((enchant, max) -> {
            enchantments.add(enchant);
        });

        for (int i = 0; i < possibleEnchants.size(); i++) {
            if (rand.nextInt(4) == 2) {
                item.addUnsafeEnchantment(enchantments.get(i), rand.nextInt(possibleEnchants.get(enchantments.get(i))) + 1);
            }
        }

        item.setDurability((short) (rand.nextInt(item.getType().getMaxDurability()) + 1));
        return item;
    }

    public static ItemStack getTreasureBook() {
        register();
        ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();

        Random rand = new Random();

        List<Enchantment> enchantments = new ArrayList<>();
        enchants.forEach((enchant, max) -> {
            enchantments.add(enchant);
        });

        for (int i = 0; i < enchants.size(); i++) {
            int tonextlevel = 17;
            if (item.getEnchantments().size() >= 3) tonextlevel = 35;
            if (item.getEnchantments().size() >= 4) tonextlevel = 43;
            if (item.getEnchantments().size() >= 5) tonextlevel = 50;
            if (item.getEnchantments().size() >= 7) tonextlevel = 100;
            if (rand.nextInt(tonextlevel) == 2) {
                meta.addStoredEnchant(enchantments.get(i), rand.nextInt(enchants.get(enchantments.get(i))) + 1, true);
            }
        }
        if (meta.getEnchants().isEmpty()) {
            meta.addStoredEnchant(Enchantment.EFFICIENCY, rand.nextInt(Enchantment.EFFICIENCY.getMaxLevel()) + 1, true);
        }
        item.setItemMeta(meta);
        return item;
    }
}

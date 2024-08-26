package me.teakivy.teakstweaks.packs.wanderingtraderannouncements;

import me.teakivy.teakstweaks.packs.BasePack;
import me.teakivy.teakstweaks.packs.PackType;
import me.teakivy.teakstweaks.utils.MM;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntitySpawnEvent;

public class WanderingTraderAnnouncements extends BasePack {

    public WanderingTraderAnnouncements() {
        super("wandering-trader-announcements",  PackType.MOBS, Material.EMERALD);
    }

    @EventHandler
    public void onWanderingTraderSpawn(EntitySpawnEvent event) {
        if (event.getEntity().getType() != EntityType.WANDERING_TRADER) return;

        int radius = getConfig().getInt("radius");
        if (radius < 0) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendMessage(MM.toString(getText("announcement_all")));
            }
            return;
        }

        event.getEntity().getWorld().getNearbyEntities(event.getEntity().getLocation(), radius, radius, radius).forEach(entity -> {
            if (entity.getType() == EntityType.PLAYER) {
                entity.sendMessage(MM.toString(getText("announcement")));
            }
        });
    }
}

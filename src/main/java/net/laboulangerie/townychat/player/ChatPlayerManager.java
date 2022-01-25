package net.laboulangerie.townychat.player;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ChatPlayerManager {
    private Map<UUID, ChatPlayer> playersMap;

    public ChatPlayerManager() {
        this.playersMap = new HashMap<>();

        Bukkit.getOnlinePlayers().stream().forEach(p -> loadPlayer(p));
    }

    public void loadPlayer(Player player) {
        ChatPlayer chatPlayer = new ChatPlayer(player);
        this.playersMap.put(player.getUniqueId(), chatPlayer);
    }

    public void unloadPlayer(Player player) {
        this.playersMap.remove(player.getUniqueId());
    }

    public ChatPlayer getChatPlayer(Player player) {
        return this.playersMap.get(player.getUniqueId());
    }

    public Set<ChatPlayer> getPlayers() {
        return (Set<ChatPlayer>) this.playersMap.values();
    }

}

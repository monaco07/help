package de.monaco07.tutorialreloaded.backpack;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import de.monaco07.tutorialreloaded.utils.Base64;

import java.io.IOException;
import java.util.UUID;

public class Backpack {

    private final UUID uuid;
    private final Inventory inventory;

    public Backpack(UUID uuid) {
        this.uuid = uuid;
        this.inventory = Bukkit.createInventory(null, 54 /* vielfaches von 9 */, "Backpack");
    }

    public Backpack(UUID uuid, String base64) throws IOException {
        this.uuid = uuid;
        this.inventory = Bukkit.createInventory(null, 54 /* vielfaches von 9 */, "Backpack");
        this.inventory.setContents(Base64.itemStackArrayFromBase64(base64));
    }

    public UUID getUuid() {
        return uuid;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String toBase64() {
        return Base64.itemStackArrayToBase64(inventory.getContents());
    }
}

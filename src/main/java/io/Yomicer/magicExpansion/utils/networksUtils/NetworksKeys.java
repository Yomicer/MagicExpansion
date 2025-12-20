package io.Yomicer.magicExpansion.utils.networksUtils;

import org.bukkit.NamespacedKey;
import org.jetbrains.annotations.NotNull;

public class NetworksKeys {


    public static final String NETWORKS_ID = "networks"; // Official version / Chinese localized version
    public static final String NETWORKS_CHANGED_ID = "networks-changed"; // Xinzi version

    public static final NamespacedKey ITEM = newKey("item");
    public static final NamespacedKey ITEM2 = customNewKey(NETWORKS_ID, "item");
    public static final NamespacedKey ITEM3 = customNewKey(NETWORKS_CHANGED_ID, "item");

    public static final NamespacedKey AMOUNT = newKey("amount");
    public static final NamespacedKey AMOUNT2 = customNewKey(NETWORKS_ID, "amount");
    public static final NamespacedKey AMOUNT3 = customNewKey(NETWORKS_CHANGED_ID, "amount");

    public static final NamespacedKey MAX_AMOUNT = newKey("max_amount");
    public static final NamespacedKey MAX_AMOUNT2 = customNewKey(NETWORKS_ID, "max_amount");
    public static final NamespacedKey MAX_AMOUNT3 = customNewKey(NETWORKS_CHANGED_ID, "max_amount");

    public static final NamespacedKey VOID = newKey("void");
    public static final NamespacedKey VOID2 = customNewKey(NETWORKS_ID, "void");
    public static final NamespacedKey VOID3 = customNewKey(NETWORKS_CHANGED_ID, "void");

    public static final NamespacedKey SUPPORTS_CUSTOM_MAX_AMOUNT = newKey("supports_custom_max_amount");

    public static final NamespacedKey QUANTUM_STORAGE_INSTANCE = newKey("quantum_storage");
    public static final NamespacedKey QUANTUM_STORAGE_INSTANCE2 = customNewKey(NETWORKS_ID, "quantum_storage");
    public static final NamespacedKey QUANTUM_STORAGE_INSTANCE3 = customNewKey(NETWORKS_CHANGED_ID, "quantum_storage");



    public static NamespacedKey newKey(@NotNull String key) {
        return new NamespacedKey("networks", key);
    }
    public static NamespacedKey customNewKey(@NotNull String namespace, @NotNull String key) {
        return new NamespacedKey(namespace, key);
    }

}

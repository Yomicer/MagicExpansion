package io.Yomicer.magicExpansion;

import io.Yomicer.magicExpansion.Listener.SlimefunRegistryFinalized;
import io.Yomicer.magicExpansion.specialActions.Command.MagicExpansionCommand;
import io.Yomicer.magicExpansion.utils.ColorGradient;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import lombok.SneakyThrows;
import org.bukkit.plugin.java.JavaPlugin;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class MagicExpansionMachines extends JavaPlugin implements SlimefunAddon {
    private static MagicExpansionMachines instance;

    @SneakyThrows
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        getLogger().info("§b魔法拓展加载中！");

        // Registering Items
        MagicExpansionItemSetup.setup(this);

        // Registering Command
        this.getCommand("magicexpansion").setExecutor(new MagicExpansionCommand());
        // 注册事件监听器
        getServer().getPluginManager().registerEvents(new SlimefunRegistryFinalized(), this);



        getLogger().info("§b魔法拓展已成功启用！");










    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("§b魔法拓展已成功卸载！");
    }
    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Nullable
    @Override
    public String getBugTrackerURL() {
        return "";
    }

    public static MagicExpansionMachines getInstance() {
        return instance;
    }
}

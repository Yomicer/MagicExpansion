package io.Yomicer.magicExpansion;

import io.Yomicer.magicExpansion.Listener.SlimefunRegistryFinalized;
import io.Yomicer.magicExpansion.specialActions.Command.MagicExpansionCommand;
import io.Yomicer.magicExpansion.utils.ColorGradient;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import lombok.SneakyThrows;
import net.guizhanss.guizhanlibplugin.updater.GuizhanUpdater;
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
        // Read something from your config.yml
        Config cfg = new Config(this);

        getLogger().info("§b魔法拓展加载中！");

        if (cfg.getBoolean("options.auto-update") && getDescription().getVersion().startsWith("Build ")) {
            getLogger().info("§b正在加载更新！");
            GuizhanUpdater.start(this, getFile(), "Yomicer", "MagicExpansion", "master");
            getLogger().info("§b更新完毕！");
        }else{
            getLogger().info("§b已是最新版！");
        }

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

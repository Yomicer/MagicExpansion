package io.Yomicer.magicExpansion;

import io.Yomicer.magicExpansion.Listener.SlimefunRegistryFinalized;
import io.Yomicer.magicExpansion.Listener.SlimefunRegistryGiftBox;
import io.Yomicer.magicExpansion.Listener.SlimefunRegistryListener;
import io.Yomicer.magicExpansion.Listener.bossListener.BasicBossAttackListener;
import io.Yomicer.magicExpansion.Listener.bossListener.BasicBossDropListener;
import io.Yomicer.magicExpansion.Listener.fishingListener.PlayerFishingListener;
import io.Yomicer.magicExpansion.Listener.magicItemEffectManager.ArrowHitLocationListener;
import io.Yomicer.magicExpansion.Listener.magicItemEffectManager.ItemEffectAttackListener;
import io.Yomicer.magicExpansion.Listener.worldListener.Events;
import io.Yomicer.magicExpansion.specialActions.Command.MagicExpansionCommand;
import io.Yomicer.magicExpansion.Listener.magicItemEffectManager.ItemEffectKillListener;
import io.Yomicer.magicExpansion.specialActions.Command.WorldCommand;
import io.Yomicer.magicExpansion.utils.Language;
import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import lombok.SneakyThrows;
import net.guizhanss.guizhanlibplugin.updater.GuizhanUpdater;
import org.bukkit.plugin.java.JavaPlugin;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.File;

public class MagicExpansion extends JavaPlugin implements SlimefunAddon {
    public static boolean testmod=false;
    public static boolean clearConfig=false;
    public static boolean testmode(){
        return testmod;
    }
    private static MagicExpansion instance;




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
        ConfigLoader.load(this);
        Language.loadConfig(ConfigLoader.LANGUAGE);
        getLogger().info("§b语言包加载完毕！");

        // Registering Items
        MagicExpansionItemSetup.setup(this);
        MagicExpansionRecipeMachineSetup.setup(this);
        MagicExpansionPowerMachineSetup.setup(this);
        MagicExpansionQuickMachineSetup.setup(this);
        getLogger().info("§b物品注册完毕！");




        // Registering Command
        this.getCommand("magicexpansion").setExecutor(new MagicExpansionCommand());
        this.getCommand("mx").setExecutor(new WorldCommand(this));

        // 创建地图保存目录
        File mapsDir = new File(getDataFolder(), "maps");
        if (!mapsDir.exists()) {
            mapsDir.mkdirs();
        }
        getLogger().info("§b指令注册完毕");
        // 注册事件监听器
        getServer().getPluginManager().registerEvents(new SlimefunRegistryFinalized(), this);
        getServer().getPluginManager().registerEvents(new SlimefunRegistryListener(), this);
        getServer().getPluginManager().registerEvents(new SlimefunRegistryGiftBox(), this);
        getServer().getPluginManager().registerEvents(new ItemEffectAttackListener(), this);
        getServer().getPluginManager().registerEvents(new ItemEffectKillListener(), this);
        getServer().getPluginManager().registerEvents(new ArrowHitLocationListener(), this);
        getServer().getPluginManager().registerEvents(new BasicBossAttackListener(), this);
        getServer().getPluginManager().registerEvents(new BasicBossDropListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerFishingListener(), this);
        getServer().getPluginManager().registerEvents(new Events(), this);
        getLogger().info("§b监听注册完毕！");



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

    public static MagicExpansion getInstance() {
        return instance;
    }
}

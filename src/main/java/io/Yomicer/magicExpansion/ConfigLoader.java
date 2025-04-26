package io.Yomicer.magicExpansion;

import com.google.common.base.Charsets;
import io.github.thebusybiscuit.slimefun4.libraries.dough.config.Config;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.util.logging.Logger;

public class ConfigLoader {


    public static boolean TESTMODE = MagicExpansionMachines.testmode();

    public static void load(Plugin plugin) {
        ConfigLoader.plugin=plugin;
        init();
        //final File scAddonFile = new File(plugin.getDataFolder(), "language.yml");
        //copyFile(scAddonFile, "language");
        CONFIG=loadExternalConfig("config");
        INNERCONFIG=loadInternalConfig("config");
        if(INNERCONFIG.getBoolean("options.test")) {
            MagicExpansionMachines.testmod=true;
            TESTMODE=true;
            Logger.getLogger("Addon is running on TEST MODE");
        }
        if(INNERCONFIG.getBoolean("options.clear-old-config")) {
            MagicExpansionMachines.testmod=true;
        }
        LANGUAGE=loadInternalConfig("language");   //new Config(plugin,"language.yml");

    }
    public static Plugin plugin;
    public static Config CONFIG;
    public static Config INNERCONFIG;
    public static Config LANGUAGE;
    public static Config SERVER_CONFIG;
    public static void init() {
        SERVER_CONFIG=new Config(plugin);
    }
    public static void copyFile(File file, String name) {
        if(MagicExpansionMachines.clearConfig){

            try{
                Files.delete(file.toPath());
            }catch(Throwable e){
                Logger.getLogger("[TEST MODE] FAILED TO DELETE FILE: "+file.getAbsolutePath());
            }
        }
        if (!file.exists()) {
            try {
                if(!file.toPath().getParent().toFile().exists()) {
                    Files.createDirectories(file.toPath().getParent());
                }
                Files.copy(plugin.getClass().getResourceAsStream("/"+ name + ".yml"),file.toPath());
            } catch (Throwable e) {

                Logger.getLogger("创建配置文件时找不到相关默认配置文件,即将生成空文件");
                try{
                    Files.createDirectories(file.toPath().getParent());
                    Files.createFile(file.toPath());
                }catch (IOException e1){
                    Logger.getLogger("创建空配置文件失败!");
                }
            }

        }
    }
    public static Config loadInternalConfig(String name){
        FileConfiguration config = new YamlConfiguration();
        try{
            config.load((Reader)( new InputStreamReader(plugin.getClass().getResourceAsStream("/"+ name + ".yml"), Charsets.UTF_8)));
            config.getString("options.test");

        }catch (Throwable e){
            Logger.getLogger("failed to load internal config " + name + ".yml, Error: " + e.getMessage());
            return null;
        }
        return new Config(null,config);
    }
    public static Config loadExternalConfig(String name){
        FileConfiguration config = new YamlConfiguration();
        final File cfgFile = new File(plugin.getDataFolder(), "%s.yml".formatted(name));
        copyFile(cfgFile, name);
        return new Config(plugin, "%s.yml".formatted(name));
    }





}

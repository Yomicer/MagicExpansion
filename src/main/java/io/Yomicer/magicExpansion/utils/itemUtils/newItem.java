package io.Yomicer.magicExpansion.utils.itemUtils;

import io.Yomicer.magicExpansion.utils.ColorGradient;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import java.util.Arrays;
import java.util.List;


import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientName;
import static io.Yomicer.magicExpansion.utils.ColorGradient.getGradientNameVer2;

public class newItem {



    public static final String ADDON_ID="MAGIC_EXPANSION";
    public static boolean USE_IDDECORATOR=true;

    public static String idDecorator(String b){
        if(USE_IDDECORATOR){
            return ADDON_ID+"_"+b;
        }
        else return b;
    }




    public static String concat(String... strs){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<strs.length;++i){
            sb.append(strs[i]);
        }
        return sb.toString();
    }



    public static SlimefunItemStack themed(String id, Material itemStack, String name, String... lore){
        return themed(id,new ItemStack(itemStack),name,lore);
    }
    public static SlimefunItemStack themed(String id, ItemStack itemStack, String name, String... lore){
        return themed(id, itemStack, name, Arrays.asList(lore));
    }
    public static SlimefunItemStack themed(String id , Material itemStack , String name, List<String> lore){
        return themed(id,new ItemStack(itemStack),name,lore);
    }
    public static  SlimefunItemStack themed(String id, ItemStack itemStack, String name, List<String> lore){
        // 对 lore 的每一行应用变色方法
        List<String> coloredLore = lore.stream()
                .map(ColorGradient::getGradientName)
                .toList();
        return new SlimefunItemStack(
                idDecorator(id),
                itemStack,
                getGradientName(name),
                coloredLore.toArray(String[]::new)
        );
    }

    public static SlimefunItemStack themedVer2(String id, Material itemStack, String name, String... lore){
        return themedVer2(id,new ItemStack(itemStack),name,lore);
    }
    public static SlimefunItemStack themedVer2(String id, ItemStack itemStack, String name, String... lore){
        return themedVer2(id, itemStack, name, Arrays.asList(lore));
    }
    public static SlimefunItemStack themedVer2(String id , Material itemStack , String name, List<String> lore){
        return themedVer2(id,new ItemStack(itemStack),name,lore);
    }
    public static  SlimefunItemStack themedVer2(String id, ItemStack itemStack, String name, List<String> lore){
        // 对 lore 的每一行应用变色方法
        List<String> coloredLore = lore.stream()
                .map(ColorGradient::getGradientNameVer2)
                .toList();
        return new SlimefunItemStack(
                idDecorator(id),
                itemStack,
                getGradientNameVer2(name),
                coloredLore.toArray(String[]::new)
        );
    }




    public static SlimefunItemStack themedOrigin(String id, Material itemStack, String name, String... lore){
        return themed(id,new ItemStack(itemStack),name,lore);
    }
    public static SlimefunItemStack themedOrigin(String id, ItemStack itemStack, String name, String... lore){
        return themed(id, itemStack, name, Arrays.asList(lore));
    }
    public static SlimefunItemStack themedOrigin(String id , Material itemStack , String name, List<String> lore){
        return themed(id,new ItemStack(itemStack),name,lore);
    }
    public static  SlimefunItemStack themedOrigin(String id, ItemStack itemStack, String name, List<String> lore){
        return new SlimefunItemStack(
                idDecorator(id),
                itemStack,
                name,
                lore.toArray(String[]::new)
        );
    }



    public static ItemStack themed(ItemStack itemStack, String name, List<String>  lore){
        // 对 lore 的每一行应用变色方法
        List<String> coloredLore = lore.stream()
                .map(ColorGradient::getGradientName)
                .toList();
        return new CustomItemStack(
                itemStack,
                getGradientName(name),
                coloredLore.toArray(String[]::new)
        );
    }

    public static ItemStack themed(Material material, String name, String... lore){
        return themed(new ItemStack(material),name,Arrays.asList(lore));
    }
    public static ItemStack themed(Material material, String name, List<String> lore){
        return themed(new ItemStack(material),name,lore);
    }
    public static ItemStack themed(ItemStack itemStack, String name, String... lore){
        return themed(itemStack,name,Arrays.asList(lore));
    }

    public static ItemStack themed(ItemStack itemStack, String name, List<String>  lore, int notGradient){
        return new CustomItemStack(
                itemStack,
                getGradientName(name),
                lore.toArray(String[]::new)
        );
    }










}

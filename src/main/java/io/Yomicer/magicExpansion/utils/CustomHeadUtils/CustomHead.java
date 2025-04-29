package io.Yomicer.magicExpansion.utils.CustomHeadUtils;

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.SlimefunUtils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.net.URL;

public enum CustomHead {
    MAGICSOLO("8adb25ab9976d89d0bd8118d72c1c06bb907060c1e02a729b652d1e86b1ebbbc"),
    BOT_PINK("c4d257ab13a12b18f9561eb3dc41b92b50d4ad4c91059d4400bee41602527488"),
    BOT_RED("b6b5a0d309833a3ea2f1e63976d6d5f0059e637224b8889f8af364453f656769"),
    BOT_ORANGE("dbff6904eac2c42db8259fb3c04c2f717fd06e6352b271120c8b89255c2d9c63"),
    BOT_YELLOW("23dbd0224bd1dc73e60815ada74103052b91399caa6d8a83220e4d1574d0dafe"),
    BOT_GREEN("4a794f8f82d46191181ebf8e2ee22854d04ec9bfb0711682a7603535305a98dc"),
    BOT_PURPLE("68bf39b376b71432d0147da37f379a4e38bef7ad479bbc7b8a30b6407e67a3c9"),
    ;






    private ItemStack item;
    public ItemStack getItem() {

        return item;
    }

    CustomHead(String hashcode){
        item= new CustomItemStack(SlimefunUtils.getCustomHead(hashcode));
    }


    public static String getHash(ItemStack item){
        if(item!=null&&(item.getType()== Material.PLAYER_HEAD||item.getType()==Material.PLAYER_WALL_HEAD)){
            ItemMeta meta=item.getItemMeta();
            if(meta instanceof SkullMeta){
                try{
                    URL t=((SkullMeta)meta).getOwnerProfile().getTextures().getSkin();
                    String path=t.getPath();
                    String[] parts=path.split("/");
                    return parts[parts.length-1];
                }catch (Throwable t){
                }
            }
        }
        return null;
    }
    public static ItemStack getHead(String hashcode){
        try{
            return new CustomItemStack(SlimefunUtils.getCustomHead(hashcode));
        }catch (Throwable t){
            return new ItemStack(Material.PLAYER_HEAD);
        }
    }




}

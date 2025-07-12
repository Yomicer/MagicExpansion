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
    STAR_HEEAD("45f5cab199508725ea2bbe3ed2d84b891c5d8b7ee7eaedc69e67196dc6fee3d9"),


    BLUE_GIFT_BOX("bb09df8f3875b95c9d057728152f9f44e540fd7af825df44b3db4155cceec429"),
    WHITE_GIFT_BOX("5df2835975acee173426c5c65233f4c1b506a76dfcd418e30076536c8ef3d39c"),
    GREEN_GIFT_BOX("e7866805f875339efb94e667837c193f2a1bcedec8b41babbbf0bb7a7c8f6148"),
    PURPLE_GIFT_BOX("40894781820f81b706a081577d7391a6c30f2c474b087aca14d54b6f659f2ea7"),
    GOLD_GIFT_BOX("9d5c38fb56320fa13637acfe82077b6d780b889f7742d69bcc6e5ae035eafd27"),

    JING_LIU("184ce70321102c37cdbf03881ae35790c6ddd76770188886ec23768672a6ad33"),
    SILVER_WOLF("8f93911bf545c1a24ffa6e2c064a3ba0e9e0e1c4258b45711c2fbe03e15dbda3"),
    KAFKA("93a4ee47e38f7a96836472e0218c89c43b947a189a0a9ca44be10860a1caef4e"),
    SUNDAY("c6689533748d6c76a9582b4269b8ddeb2e7047a5e6115804203a5a56653d6d08"),
    LUNAE("dc5653cdc03a5622fb425ccfd00a76ec9d733281fdf9d65582924ac9c491f214"),
    HUOHUO("5bde3d18fc60562e48bbbbdd9a80207bd66609cdc767dea9c4f35e4b22c26331"),


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

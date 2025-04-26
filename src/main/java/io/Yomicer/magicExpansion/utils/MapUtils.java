package io.Yomicer.magicExpansion.utils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import io.Yomicer.magicExpansion.Listener.worldListener.Events;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MapUtils {
    private static final Gson gson = new Gson();

    public static void exportMap(Player player) {
        Location p1 = Events.point1.get(player.getUniqueId());
        Location p2 = Events.point2.get(player.getUniqueId());

        if (p1 == null || p2 == null) {
            player.sendMessage("Please select two points first!");
            return;
        }

        List<BlockData> blocks = getBlocksInRegion(p1, p2);
        String fileName = "map_" + System.currentTimeMillis() + ".json";
        File file = new File(player.getServer().getPluginManager().getPlugin("MagicExpansion").getDataFolder(), "maps/" + fileName);

        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(blocks, writer);
            player.sendMessage("Map exported successfully: " + fileName);
        } catch (IOException e) {
            player.sendMessage("Failed to export map: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void pasteMap(Player player, String fileName) {
        File file = new File(player.getServer().getPluginManager().getPlugin("MagicExpansion").getDataFolder(), "maps/" + fileName + ".json");

        if (!file.exists()) {
            player.sendMessage("§cFile not found!");
            return;
        }

        // 获取玩家注视的目标方块
        Block targetBlock = getTargetBlock(player);
        if (targetBlock == null) {
            player.sendMessage("§cYou need to look at a block!");
            return;
        }

        // 粘贴位置为目标方块上方 1 格
        Location pasteLocation = targetBlock.getLocation().add(0, 1, 0);

        try (FileReader reader = new FileReader(file)) {
            Type listType = new TypeToken<List<BlockData>>() {}.getType();
            List<BlockData> blocks = gson.fromJson(reader, listType);

            for (BlockData blockData : blocks) {
                Location location = new Location(
                        player.getWorld(),
                        pasteLocation.getBlockX() + blockData.x,
                        pasteLocation.getBlockY() + blockData.y,
                        pasteLocation.getBlockZ() + blockData.z
                );
                location.getBlock().setType(Material.valueOf(blockData.type));
            }

            player.sendMessage("§aMap pasted successfully above the target block!");
        } catch (IOException e) {
            player.sendMessage("§cFailed to paste map: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * 获取玩家注视的目标方块
     */
    private static Block getTargetBlock(Player player) {
        BlockIterator iterator = new BlockIterator(player, 10); // 最远检测 5 格
        while (iterator.hasNext()) {
            Block block = iterator.next();
            if (!block.getType().isAir()) {
                return block;
            }
        }
        return null; // 如果没有找到非空气方块，返回 null
    }

    public static List<BlockData> getBlocksInRegion(Location p1, Location p2) {
        List<BlockData> blocks = new ArrayList<>();
        int minX = Math.min(p1.getBlockX(), p2.getBlockX());
        int minY = Math.min(p1.getBlockY(), p2.getBlockY());
        int minZ = Math.min(p1.getBlockZ(), p2.getBlockZ());
        int maxX = Math.max(p1.getBlockX(), p2.getBlockX());
        int maxY = Math.max(p1.getBlockY(), p2.getBlockY());
        int maxZ = Math.max(p1.getBlockZ(), p2.getBlockZ());

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                for (int z = minZ; z <= maxZ; z++) {
                    Block block = p1.getWorld().getBlockAt(x, y, z);

                    // 跳过空气方块
                    if (block.getType() == Material.AIR) {
                        continue;
                    }

                    // 添加非空气方块到列表
                    blocks.add(new BlockData(
                            x - minX,
                            y - minY,
                            z - minZ,
                            block.getType().name()
                    ));
                }
            }
        }
        return blocks;
    }

    public static class BlockData {
        public int x, y, z;
        public String type;

        public BlockData(int x, int y, int z, String type) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.type = type;
        }
    }
}

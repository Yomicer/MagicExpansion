package io.Yomicer.magicExpansion.utils.preBuildingUtils;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.util.BlockIterator;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

public class PreBuildingsTreeUtils {

    private static final Gson gson = new Gson();

    /**
     * 粘贴地图到玩家注视的目标方块上方
     */
    public static boolean pasteMap(Player player, String fileName, String originName, String replaceName) {
        // 从 resources/buildings 文件夹中读取 JSON 文件
        InputStream inputStream = PreBuildingsTreeUtils.class.getClassLoader().getResourceAsStream("buildings/" + fileName + ".json");

        if (inputStream == null) {
            player.sendMessage("§c路径错误，请不要随意修改插件设置!");
            return false; // 文件不存在，返回 false
        }

        // 获取玩家注视的目标方块
        Block targetBlock = getTargetBlock(player);
        if (targetBlock == null) {
            player.sendMessage("§c你需要看向一个方块!");
            return false; // 没有目标方块，返回 false
        }

        // 粘贴位置为目标方块上方 1 格
        Location pasteLocation = targetBlock.getLocation().add(0, 1, 0);

        try (InputStreamReader reader = new InputStreamReader(inputStream)) {
            Type listType = new TypeToken<List<BlockData>>() {}.getType();
            List<BlockData> blocks = gson.fromJson(reader, listType);

            if (!(originName == null) && !(replaceName == null)) {
                // 替换 "OAK" 为 "CHERRY"
                for (BlockData blockData : blocks) {
                    if (blockData.type != null && blockData.type.contains(originName)) {
                        blockData.type = blockData.type.replace(originName, replaceName);
                    }
                }
            }

            // 检查是否有冲突
            if (hasConflicts(blocks, pasteLocation, player.getWorld())) {
                player.sendMessage("§c当前空间大小不足，请选择其他地方放置。");
                return false; // 存在冲突，返回 false
            }

            // 如果没有冲突，则开始粘贴
            for (BlockData blockData : blocks) {
                Location location = new Location(
                        player.getWorld(),
                        pasteLocation.getBlockX() + blockData.x,
                        pasteLocation.getBlockY() + blockData.y,
                        pasteLocation.getBlockZ() + blockData.z
                );

                if (blockData.blockState != null && !blockData.blockState.isEmpty()) {
                    location.getBlock().setBlockData(Bukkit.createBlockData(blockData.blockState));
                } else {
                    location.getBlock().setType(Material.valueOf(blockData.type));
                }
            }

            player.sendMessage("§a预制菜启动！");
            return true; // 成功粘贴，返回 true
        } catch (IOException e) {
            player.sendMessage("§cFailed to create: " + e.getMessage());
            e.printStackTrace();
            return false; // 发生异常，返回 false
        }
    }

    public static boolean pasteMap(Player player, String fileName) {
        return pasteMap(player, fileName, null, null);
    }

    /**
     * 检查是否有冲突
     */
    private static boolean hasConflicts(List<BlockData> blocks, Location pasteLocation, org.bukkit.World world) {
        for (BlockData blockData : blocks) {
            Location location = new Location(
                    world,
                    pasteLocation.getBlockX() + blockData.x,
                    pasteLocation.getBlockY() + blockData.y,
                    pasteLocation.getBlockZ() + blockData.z
            );

            Block block = location.getBlock();
            if (!block.getType().isAir()) {
                return true; // 发现冲突
            }
        }
        return false; // 没有冲突
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

    /**
     * 内部类：存储单个方块的数据
     */
    private static class BlockData {
        public int x;
        public int y;
        public int z;
        public String type;
        public String blockState; // 新增字段，用于保存方块状态

        // 默认构造函数
        public BlockData() {}

        // 如果需要的话，可以添加带参数的构造函数
        public BlockData(int x, int y, int z, String type, String blockState) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.type = type;
            this.blockState = blockState;
        }
    }






}

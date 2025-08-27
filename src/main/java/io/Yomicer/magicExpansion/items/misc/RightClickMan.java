package io.Yomicer.magicExpansion.items.misc;

import com.xzavier0722.mc.plugin.slimefun4.storage.controller.SlimefunBlockData;
import com.xzavier0722.mc.plugin.slimefun4.storage.util.StorageCacheUtils;
import io.Yomicer.magicExpansion.items.electric.entitykillMachinee.EntityKillMachine;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.handlers.BlockBreakHandler;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static io.Yomicer.magicExpansion.utils.Utils.doGlow;

public class RightClickMan extends SlimefunItem implements EnergyNetComponent {


    public RightClickMan(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        constructMenu("交互机器人");
        addItemHandler(onBreak());
    }

    private final int[] pinkCandle = {6,7,8,24,25,26};
    private final int[] blueCandle = {15,17};
    private final int[] upBorder = {0,18};
    private final int[] downBorder = {1,19};
    private final int[] eastBorder = {2,20};
    private final int[] southBorder = {3,21};
    private final int[] westBorder = {4,22};
    private final int[] northBorder = {5,23};


    private final int[] inputSlots = {9,10,11,12,13,14};

    @Override
    public void preRegister() {
        addItemHandler(new BlockTicker() {

            @Override
            public void tick(Block b, SlimefunItem sf, SlimefunBlockData data) {
                RightClickMan.this.tick(b);
            }

            @Override
            public boolean isSynchronized() {
                return true;
            }
        });
    }
    protected void tick(Block block) {

        BlockMenu menu = StorageCacheUtils.getMenu(block.getLocation());
        List<Integer> validSlots = new ArrayList<>(); // 用于存储符合条件的槽位索引
        for (int i = 9; i <= 14; i++) {
            if (menu.getItemInSlot(i) != null && menu.getItemInSlot(i).getType() != Material.AIR) {
                validSlots.add(i); // 将符合条件的索引添加到列表中
            }
        }

        World world = block.getLocation().getWorld();
        // 获取距离该方块50格范围内的所有玩家
        List<Player> nearbyPlayers = world.getPlayers().stream()
                .filter(player -> player.getLocation().distanceSquared(block.getLocation()) <= 2500) // 50^2 = 2500
                .sorted(Comparator.comparingDouble(a -> a.getLocation().distance(block.getLocation())))
                .toList();

        if (nearbyPlayers.isEmpty()) {
            return;
        }
        Player nearestPlayer = nearbyPlayers.get(0);

        Location loc = block.getLocation();
        String directions = "";

        if (validSlots.contains(9)){
            // 模拟右键点击该方块  模拟向上
            Location loc1 = loc.clone().add(0,1,0);
            Block targetBlock1 = loc1.getBlock();
            if (nearestPlayer != null) {
                PlayerInteractEvent interactEvent = new PlayerInteractEvent(
                        nearestPlayer,
                        Action.RIGHT_CLICK_BLOCK,
                        new ItemStack(Material.AIR),
                        targetBlock1,
                        BlockFace.SELF
                );
                Bukkit.getPluginManager().callEvent(interactEvent);
                directions += "上 ";
            }
        }
        if (validSlots.contains(10)){
            // 模拟右键点击该方块  模拟向下
            Location loc2 = loc.clone().add(0,-1,0);
            Block targetBlock2 = loc2.getBlock();
            if (nearestPlayer != null) {
                PlayerInteractEvent interactEvent = new PlayerInteractEvent(
                        nearestPlayer,
                        Action.RIGHT_CLICK_BLOCK,
                        new ItemStack(Material.AIR),
                        targetBlock2,
                        BlockFace.SELF
                );
                Bukkit.getPluginManager().callEvent(interactEvent);
                directions += "下 ";
            }
        }
        if (validSlots.contains(11)){
            // 模拟右键点击该方块  模拟向东
            Location loc3 = loc.clone().add(1,0,0);
            Block targetBlock3 = loc3.getBlock();
            if (nearestPlayer != null) {
                PlayerInteractEvent interactEvent = new PlayerInteractEvent(
                        nearestPlayer,
                        Action.RIGHT_CLICK_BLOCK,
                        new ItemStack(Material.AIR),
                        targetBlock3,
                        BlockFace.SELF
                );
                Bukkit.getPluginManager().callEvent(interactEvent);
                directions += "东 ";
            }
        }
        if (validSlots.contains(12)){
            // 模拟右键点击该方块  模拟向南
            Location loc4 = loc.clone().add(0,0,1);
            Block targetBlock4 = loc4.getBlock();
            if (nearestPlayer != null) {
                PlayerInteractEvent interactEvent = new PlayerInteractEvent(
                        nearestPlayer,
                        Action.RIGHT_CLICK_BLOCK,
                        new ItemStack(Material.AIR),
                        targetBlock4,
                        BlockFace.SELF
                );
                Bukkit.getPluginManager().callEvent(interactEvent);
                directions += "南 ";
            }
        }
        if (validSlots.contains(13)){
            // 模拟右键点击该方块  模拟向西
            Location loc5 = loc.clone().add(-1,0,0);
            Block targetBlock5 = loc5.getBlock();
            if (nearestPlayer != null) {
                PlayerInteractEvent interactEvent = new PlayerInteractEvent(
                        nearestPlayer,
                        Action.RIGHT_CLICK_BLOCK,
                        new ItemStack(Material.AIR),
                        targetBlock5,
                        BlockFace.SELF
                );
                Bukkit.getPluginManager().callEvent(interactEvent);
                directions += "西 ";
            }
        }
        if (validSlots.contains(14)){
            // 模拟右键点击该方块  模拟向北
            Location loc6 = loc.clone().add(0,0,-1);
            Block targetBlock6 = loc6.getBlock();
            if (nearestPlayer != null) {
                PlayerInteractEvent interactEvent = new PlayerInteractEvent(
                        nearestPlayer,
                        Action.RIGHT_CLICK_BLOCK,
                        new ItemStack(Material.AIR),
                        targetBlock6,
                        BlockFace.SELF
                );
                Bukkit.getPluginManager().callEvent(interactEvent);
                directions += "北";
            }
        }

        if(menu != null && menu.hasViewer() &&nearestPlayer!=null) {
            //inter
            menu.addItem(16, new CustomItemStack(new ItemStack(Material.PINK_CANDLE), "§b交互机器人",
                            "§b工作类型：§e" + "右键交互方块",
                            "§b交互速度：§e1次/粘液刻",
                            "§b模拟玩家：§e"+ nearestPlayer.getName(),
                            "§b模拟方向：§e"+ directions,
                            "§b耗电速度：§e" + "这个机器人不花电的",
                            "§b电量存储：§e" + "这个机器人不储存电"),
                    (p, slot, item, action) -> false);

        }
        if(menu != null && menu.hasViewer() &&nearestPlayer==null) {
            //inter
            menu.addItem(16, new CustomItemStack(new ItemStack(Material.PINK_CANDLE), "§b交互机器人",
                            "§b工作类型：§e" + "右键交互方块",
                            "§b交互速度：§e1次/粘液刻",
                            "§c未检测到玩家在附近",
                            "§b耗电速度：§e" + "这个机器人不花电的",
                            "§b电量存储：§e" + "这个机器人不储存电"),
                    (p, slot, item, action) -> false);

        }



    }

    private void constructMenu(String displayName) {
        new BlockMenuPreset(getId(), displayName) {

            @Override
            public void init() {
                constructMenu(this);
            }

            @Override
            public boolean canOpen(@Nonnull Block b, @Nonnull Player p) {
                return p.hasPermission("slimefun.inventory.bypass")
                        || Slimefun.getProtectionManager().hasPermission(p, b.getLocation(),
                        Interaction.INTERACT_BLOCK);
            }

            @Override
            public int[] getSlotsAccessedByItemTransport(ItemTransportFlow itemTransportFlow) {
                return new int[]{
                        9,10,11,12,13,14
                };
            }
        };
    }
    protected void constructMenu(BlockMenuPreset preset) {

        for (int i : pinkCandle ) {
            preset.addItem(i, new CustomItemStack(doGlow(new ItemStack (Material.PINK_CANDLE)), " "),
                    (p, slot, item, action) -> false);
        }

        for (int i : blueCandle) {
            preset.addItem(i, new CustomItemStack(doGlow(new ItemStack (Material.BLUE_CANDLE)), " "),
                    (p, slot, item, action) -> false);
        }
        for (int i : upBorder) {
            preset.addItem(i, new CustomItemStack(doGlow(new ItemStack (Material.WHITE_CONCRETE)), "§e向上","§b此处放置物品，机器人与上方方块交互"),
                    (p, slot, item, action) -> false);
        }
        for (int i : downBorder) {
            preset.addItem(i, new CustomItemStack(doGlow(new ItemStack (Material.BLACK_CONCRETE)), "§e向下","§b此处放置物品，机器人与下方方块交互"),
                    (p, slot, item, action) -> false);
        }
        for (int i : eastBorder) {
            preset.addItem(i, new CustomItemStack(doGlow(new ItemStack (Material.RED_CONCRETE)), "§e向东","§b此处放置物品，机器人与东方方块交互"),
                    (p, slot, item, action) -> false);
        }
        for (int i : southBorder) {
            preset.addItem(i, new CustomItemStack(doGlow(new ItemStack (Material.BLUE_CONCRETE)), "§e向南","§b此处放置物品，机器人与南方方块交互"),
                    (p, slot, item, action) -> false);
        }
        for (int i : westBorder) {
            preset.addItem(i, new CustomItemStack(doGlow(new ItemStack (Material.GREEN_CONCRETE)), "§e向西","§b此处放置物品，机器人与西方方块交互"),
                    (p, slot, item, action) -> false);
        }
        for (int i : northBorder) {
            preset.addItem(i, new CustomItemStack(doGlow(new ItemStack (Material.YELLOW_CONCRETE)), "§e向北","§b此处放置物品，机器人与北方方块交互"),
                    (p, slot, item, action) -> false);
        }

        preset.addItem(16, new CustomItemStack(new ItemStack (Material.RED_CANDLE), " "),
                (p, slot, item, action) -> false);

    }

    private BlockBreakHandler onBreak() {
        return new BlockBreakHandler(false, false) {
            @Override
            public void onPlayerBreak(@Nonnull BlockBreakEvent e, @Nonnull ItemStack i, @Nonnull List<ItemStack> list) {
                Block b = e.getBlock();
                BlockMenu inv = StorageCacheUtils.getMenu(b.getLocation());

                if (inv != null) {
                    inv.dropItems(b.getLocation(), inputSlots);
                }

            }
        };
    }

    @Override
    public @NotNull EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.NONE;
    }

    @Override
    public int getCapacity() {
        return 0;
    }
}

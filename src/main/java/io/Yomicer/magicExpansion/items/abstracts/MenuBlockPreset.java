package io.Yomicer.magicExpansion.items.abstracts;

import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import io.github.thebusybiscuit.slimefun4.libraries.dough.protection.Interaction;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.api.inventory.DirtyChestMenu;
import me.mrCookieSlime.Slimefun.api.item_transport.ItemTransportFlow;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

final class MenuBlockPreset extends BlockMenuPreset {
    private final MenuBlock menuBlock;

    @ParametersAreNonnullByDefault
    MenuBlockPreset(MenuBlock menuBlock) {
        super(menuBlock.getId(), menuBlock.getItemName());
        this.menuBlock = menuBlock;
        menuBlock.setup(this);
    }

    @ParametersAreNonnullByDefault
    public void newInstance(BlockMenu menu, Block b) {
        this.menuBlock.onNewInstance(menu, b);
    }

    @ParametersAreNonnullByDefault
    public int[] getSlotsAccessedByItemTransport(DirtyChestMenu menu, ItemTransportFlow flow, ItemStack item) {
        return this.menuBlock.getTransportSlots(menu, flow, item);
    }

    public void init() {
    }

    @ParametersAreNonnullByDefault
    public boolean canOpen(Block b, Player p) {
        return Slimefun.getProtectionManager().hasPermission(p, b.getLocation(), Interaction.INTERACT_BLOCK) && this.menuBlock.canUse(p, false);
    }

    @ParametersAreNonnullByDefault
    public int[] getSlotsAccessedByItemTransport(ItemTransportFlow flow) {
        if (flow == ItemTransportFlow.INSERT) {
            return this.menuBlock.getInputSlots();
        } else {
            return this.menuBlock.getOutputSlots();
        }
    }
}

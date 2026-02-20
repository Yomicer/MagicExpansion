package io.Yomicer.magicExpansion.utils.networksUtils;

import com.jeff_media.morepersistentdatatypes.DataType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.jetbrains.annotations.NotNull;

/**
 * A {@link PersistentDataType} for {@link }
 * Creatively thieved from {@see <a href="https://github.com/baked-libs/dough/blob/main/dough-data/src/main/java/io/github/bakedlibs/dough/data/persistent/PersistentUUIDDataType.java">PersistentUUIDDataType}
 *
 * @author Sfiguz7
 * @author Walshy
 */
public class PersistentQuantumStorageType implements PersistentDataType<PersistentDataContainer, QuantumCache> {

    public static final PersistentDataType<PersistentDataContainer, QuantumCache> TYPE =
            new PersistentQuantumStorageType();

    @Override
    @NotNull
    public Class<PersistentDataContainer> getPrimitiveType() {
        return PersistentDataContainer.class;
    }

    @Override
    @NotNull
    public Class<QuantumCache> getComplexType() {
        return QuantumCache.class;
    }

    @Override
    @NotNull
    public PersistentDataContainer toPrimitive(
            @NotNull QuantumCache complex, @NotNull PersistentDataAdapterContext context) {
        final PersistentDataContainer container = context.newPersistentDataContainer();

        if (complex.getItemStack() != null) {
            container.set(NetworksKeys.ITEM, DataType.ITEM_STACK, complex.getItemStack());
        }
        container.set(NetworksKeys.AMOUNT, DataType.LONG, complex.getAmountLong());
        container.set(NetworksKeys.MAX_AMOUNT, DataType.LONG, complex.getLimitLong());
        container.set(NetworksKeys.VOID, DataType.BOOLEAN, complex.isVoidExcess());
        container.set(NetworksKeys.SUPPORTS_CUSTOM_MAX_AMOUNT, DataType.BOOLEAN, complex.supportsCustomMaxAmount());
        return container;
    }

    @Override
    @NotNull
    public QuantumCache fromPrimitive(
            @NotNull PersistentDataContainer primitive, @NotNull PersistentDataAdapterContext context) {
        ItemStack item = primitive.get(NetworksKeys.ITEM, DataType.ITEM_STACK);
        if (item == null) {
            item = primitive.get(NetworksKeys.ITEM2, DataType.ITEM_STACK);
        }
        if (item == null) {
            item = primitive.get(NetworksKeys.ITEM3, DataType.ITEM_STACK);
        }

        Long amount;
        try {
            amount = primitive.get(NetworksKeys.AMOUNT, DataType.LONG);
            if (amount == null) {
                amount = primitive.get(NetworksKeys.AMOUNT2, DataType.LONG);
            }
            if (amount == null) {
                amount = primitive.getOrDefault(NetworksKeys.AMOUNT3, DataType.LONG, 0L);
            }
        } catch (Throwable ignored) {
            Integer amountI;
            amountI = primitive.get(NetworksKeys.AMOUNT, DataType.INTEGER);
            if (amountI == null) {
                amountI = primitive.get(NetworksKeys.AMOUNT2, DataType.INTEGER);
            }
            if (amountI == null) {
                amountI = primitive.getOrDefault(NetworksKeys.AMOUNT3, DataType.INTEGER, 0);
            }
            amount = amountI.longValue();
        }

        Long limit;
        try {
            limit = primitive.get(NetworksKeys.MAX_AMOUNT, DataType.LONG);
            if (limit == null) {
                limit = primitive.get(NetworksKeys.MAX_AMOUNT2, DataType.LONG);
            }
            if (limit == null) {
                limit = primitive.getOrDefault(NetworksKeys.MAX_AMOUNT3, DataType.LONG, 64L);
            }
        } catch (Throwable ignored) {
            Integer limitI;
            limitI = primitive.get(NetworksKeys.MAX_AMOUNT, DataType.INTEGER);
            if (limitI == null) {
                limitI = primitive.get(NetworksKeys.MAX_AMOUNT2, DataType.INTEGER);
            }
            if (limitI == null) {
                limitI = primitive.getOrDefault(NetworksKeys.MAX_AMOUNT3, DataType.INTEGER, 64);
            }
            limit = limitI.longValue();
        }

        Boolean voidExcess = primitive.get(NetworksKeys.VOID, DataType.BOOLEAN);
        if (voidExcess == null) {
            voidExcess = primitive.get(NetworksKeys.VOID2, DataType.BOOLEAN);
        }
        if (voidExcess == null) {
            voidExcess = primitive.getOrDefault(NetworksKeys.VOID3, DataType.BOOLEAN, false);
        }

        boolean supportsCustomMaxAmount =
                primitive.getOrDefault(NetworksKeys.SUPPORTS_CUSTOM_MAX_AMOUNT, DataType.BOOLEAN, false);

        return new QuantumCache(item, amount, limit, voidExcess, supportsCustomMaxAmount);
    }
}

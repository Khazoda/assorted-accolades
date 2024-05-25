package com.seacroak.assorted_accolades;

import com.seacroak.assorted_accolades.registry.ItemGroupRegistry;
import com.seacroak.assorted_accolades.registry.MainRegistry;
import com.seacroak.assorted_accolades.util.GenericUtils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;



import static com.seacroak.assorted_accolades.Constants.ACCOLADES_ID;
import static com.seacroak.assorted_accolades.Constants.ACCOLADES_LOGGER;

public class AccoladesMod implements ModInitializer {
    public static final ItemGroup BRONZE_ITEMGROUP = ItemGroupRegistry.createItemGroup();

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM_GROUP, GenericUtils.ID(ACCOLADES_ID), BRONZE_ITEMGROUP);
        MainRegistry.init();
        ACCOLADES_LOGGER.info("[Accolades] Finished Loading!");
    }
}
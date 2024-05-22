package com.seacroak.accolades.registry;


import com.seacroak.accolades.block.BaseTrophy;
import com.seacroak.accolades.util.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import static com.seacroak.accolades.Constants.ACCOLADES_LOGGER;

public final class MainRegistry {
  /* Item Settings */
  static final Item.Settings defaultItemSettings = new Item.Settings().maxCount(1);

  /* Trophies */
  public static final BaseTrophy BASE_TROPHY = registerBlock("base_trophy", new BaseTrophy(), defaultItemSettings);


  public static void init() {
    ACCOLADES_LOGGER.info("[Accolades] Initializing Main Registry");
  }

  /* Registration Functions */
  private static <B extends Block> B registerBlock(String name, B block, Item.Settings itemSettings) {
    return RegistryHelper.registerBlock(name, block, itemSettings);
  }

  private static <B extends Block> B registerBlockOnly(String name, B block) {
    return RegistryHelper.registerBlockOnly(name, block);
  }

  private static <I extends BlockItem> BlockItem registerBlockItem(String name, I blockItem) {
    return RegistryHelper.registerBlockItem(name, blockItem);
  }

  private static Item registerItem(String name) {
    return RegistryHelper.registerItem(name, new Item(defaultItemSettings));
  }

}

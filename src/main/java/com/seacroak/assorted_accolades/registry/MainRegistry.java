package com.seacroak.assorted_accolades.registry;


import com.seacroak.assorted_accolades.block.BaseTrophy;
import com.seacroak.assorted_accolades.block.BingoCompletionistTrophy2023;
import com.seacroak.assorted_accolades.block.BingoHatContestWinnerTrophy2023;
import com.seacroak.assorted_accolades.block.BingoParticipantTrophy2023;
import com.seacroak.assorted_accolades.util.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

import static com.seacroak.assorted_accolades.Constants.ACCOLADES_LOGGER;

public final class MainRegistry {
  /* Item Settings */
  static final Item.Settings defaultItemSettings = new Item.Settings().maxCount(1);

  /* Trophies */
  public static final BaseTrophy BASE_TROPHY = registerBlock("base_trophy", new BaseTrophy(), defaultItemSettings);
  public static final BingoCompletionistTrophy2023 BINGO_COMPLETIONIST_TROPHY_2023 = registerBlock("bingo_completionist_trophy_2023", new BingoCompletionistTrophy2023(), defaultItemSettings);
  public static final BingoParticipantTrophy2023 BINGO_PARTICIPANT_TROPHY_2023 = registerBlock("bingo_participant_trophy_2023", new BingoParticipantTrophy2023(), defaultItemSettings);
  public static final BingoHatContestWinnerTrophy2023 BINGO_HAT_CONTEST_WINNER_TROPHY_2023 = registerBlock("bingo_hat_contest_winner_trophy_2023", new BingoHatContestWinnerTrophy2023(), defaultItemSettings);


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

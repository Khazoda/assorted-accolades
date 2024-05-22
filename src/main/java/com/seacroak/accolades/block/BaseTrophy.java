package com.seacroak.accolades.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;

public class BaseTrophy extends HorizontalFacingBlock {
  public BaseTrophy() {
    super(Settings.create().strength(3.5f).instrument(Instrument.IRON_XYLOPHONE).sounds(BlockSoundGroup.STONE).requiresTool().nonOpaque());
  }

  @Override
  protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
    return null;
  }
}

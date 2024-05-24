package com.seacroak.assorted_accolades.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;


public class ItemGroupRegistry {
    public static ItemGroup createItemGroup() {
        return FabricItemGroup.builder()
                .icon(() -> new ItemStack(MainRegistry.BASE_TROPHY))
                .displayName(Text.translatable("assorted-accolades.itemGroup"))
                .entries((displayContext, entries) -> {
                    entries.add(new ItemStack(MainRegistry.BASE_TROPHY));
                    entries.add(new ItemStack(MainRegistry.BINGO_PARTICIPANT_TROPHY_2023));
                    entries.add(new ItemStack(MainRegistry.BINGO_COMPLETIONIST_TROPHY_2023));
                    entries.add(new ItemStack(MainRegistry.BINGO_HAT_CONTEST_WINNER_TROPHY_2023));
                }).build();
    }

}

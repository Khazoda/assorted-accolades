package com.seacroak.assorted_accolades.util;

import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import static com.seacroak.assorted_accolades.Constants.ACCOLADES_ID;

public class GenericUtils {
    @NotNull
    public static Identifier ID(@NotNull String path) {
        return Identifier.of(ACCOLADES_ID, path);
    }


}

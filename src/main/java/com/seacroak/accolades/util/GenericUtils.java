package com.seacroak.accolades.util;

import com.seacroak.accolades.AccoladesMod;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import static com.seacroak.accolades.Constants.ACCOLADES_ID;

public class GenericUtils {
    @NotNull
    public static Identifier ID(@NotNull String path) {
        return new Identifier(ACCOLADES_ID, path);
    }


}

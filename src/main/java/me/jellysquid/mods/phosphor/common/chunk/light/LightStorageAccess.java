package me.jellysquid.mods.phosphor.common.chunk.light;

import net.minecraft.world.chunk.NibbleArray;
import net.minecraft.world.lighting.LightEngine;

public interface LightStorageAccess {
    NibbleArray callGetLightSection(long sectionPos, boolean cached);

    /**
     * Returns the light value for a position that does not have an associated lightmap.
     * This is analogous to {@link net.minecraft.world.lighting.SectionLightStorage#getLight(long)}, but uses the cached light data.
     */
    int getLightWithoutLightmap(long blockPos);

    void enableLightUpdates(long chunkPos);

    /**
     * Disables light updates and source light for the provided <code>chunkPos</code> and additionally removes all light data associated to the chunk.
     */
    void disableChunkLight(long chunkPos, LightEngine<?, ?> lightProvider);

    void invokeSetColumnEnabled(long chunkPos, boolean enabled);
}

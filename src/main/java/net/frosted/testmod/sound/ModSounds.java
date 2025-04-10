package net.frosted.testmod.sound;

import net.frosted.testmod.TestMod;
import net.minecraft.block.jukebox.JukeboxSong;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static final SoundEvent CHISEL_USE = registerSoundEvents("chisel_use");

    public static final SoundEvent MAGIC_BLOCK_BREAK = registerSoundEvents("magic_block_break");
    public static final SoundEvent MAGIC_BLOCK_STEP = registerSoundEvents("magic_block_step");
    public static final SoundEvent MAGIC_BLOCK_PLACE = registerSoundEvents("magic_block_place");
    public static final SoundEvent MAGIC_BLOCK_HIT = registerSoundEvents("magic_block_hit");
    public static final SoundEvent MAGIC_BLOCK_FALL = registerSoundEvents("magic_block_fall");

    public static final BlockSoundGroup MAGIC_BLOCK_SOUNDS = new BlockSoundGroup(1f, 1f,
            MAGIC_BLOCK_BREAK, MAGIC_BLOCK_STEP, MAGIC_BLOCK_PLACE, MAGIC_BLOCK_HIT, MAGIC_BLOCK_FALL);

    public static final SoundEvent BAR_BRAWL = registerSoundEvents("bar_brawl");
    public static final RegistryKey<JukeboxSong> BAR_BRAWL_KEY = RegistryKey.of(RegistryKeys.JUKEBOX_SONG, Identifier.of(TestMod.MOD_ID, "bar_brawl"));

    private static SoundEvent registerSoundEvents(String name) {
        Identifier id = Identifier.of(TestMod.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds() {
        TestMod.LOGGER.info("Registering Mod Sounds for " + TestMod.MOD_ID);
    }
}

package net.frosted.testmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.frosted.testmod.TestMod;
import net.frosted.testmod.item.custom.ChiselItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    public static final Item RED_KYBER_CRYSTAL = registerItem("red_kyber_crystal", new Item(new Item.Settings()));
    public static final Item BLUE_KYBER_CRYSTAL = registerItem("blue_kyber_crystal", new Item(new Item.Settings()));
    public static final Item GREEN_KYBER_CRYSTAL = registerItem("green_kyber_crystal", new Item(new Item.Settings()));
    public static final Item RED_LIGHTSABER = registerItem("red_lightsaber", new Item(new Item.Settings()));
    public static final Item CHISEL = registerItem("chisel", new ChiselItem(new Item.Settings().maxDamage(32)));
    public static final Item CAULIFLOWER = registerItem("cauliflower", new Item(new Item.Settings().food(ModFoodComponents.CAULIFLOWER)){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.testmod.cauliflower"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static Item STARLIGHT_ASHES = registerItem("starlight_ashes", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(TestMod.MOD_ID, name), item);
    }

    public  static void registeredModItems(){
        TestMod.LOGGER.info("Registering mod items for" + TestMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(RED_KYBER_CRYSTAL);
            fabricItemGroupEntries.add(BLUE_KYBER_CRYSTAL);
            fabricItemGroupEntries.add(GREEN_KYBER_CRYSTAL);
            fabricItemGroupEntries.add(CAULIFLOWER);
            fabricItemGroupEntries.add(STARLIGHT_ASHES);
        });
    }
}

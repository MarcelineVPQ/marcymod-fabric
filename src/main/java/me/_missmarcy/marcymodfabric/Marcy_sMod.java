package me._missmarcy.marcymodfabric;

import me._missmarcy.marcymodfabric.items.Spear;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Marcy_sMod implements ModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("marcymod-fabric");

    public static final Item BANANA = new Item(new Item.Settings().maxCount(16).food(FoodComponents.COOKED_BEEF)); //from Minecraft class
    public static final Item SPEAR = new Spear(new Item.Settings().maxCount(1));
    // for versions below 1.20.4
    //public static final Item BANANA = new Item(new FabricItemSettings().maxCount(32).food()); //from Fabric class

    //Custom Item Group for our mod
    private static final ItemGroup MARCYMOD_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(SPEAR))
            .displayName(Text.of("Marcy's Mod"))
            .entries((context, entries) -> {
                entries.add(BANANA);
                entries.add(SPEAR);
            })
            .build();

    @Override
    public void onInitialize() {

        LOGGER.info("Marcy's Mod has started up. The begging of a new Mod Future.");

        //add items to Existing Item Groups
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
//            entries.addBefore(Items.STONE_SWORD, SPEAR);
//        });


        //register the items so they show up In Game
        Registry.register(Registries.ITEM_GROUP, new Identifier("marcymod-fabric", "marcymod_group"), MARCYMOD_GROUP);
        Registry.register(Registries.ITEM, new Identifier("marcymod-fabric", "banana"), BANANA);
        Registry.register(Registries.ITEM, new Identifier("marcymod-fabric", "spear"), SPEAR);

    }

}


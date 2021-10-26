package com.jdawg3636.velveetashells;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

@Mod(modid = VelveetaShells.MODID, name = VelveetaShells.NAME, version = VelveetaShells.VERSION)
@Mod.EventBusSubscriber
public class VelveetaShells {

    /*
     * Mod Boiler Plate
     */

    public static final String MODID = "velveetashells";
    public static final String NAME = "Velveeta Shells & Cheese";
    public static final String VERSION = "1.0";
    private static Logger logger;

    /*
     * Content
     */

    public static final CreativeTabs VELVEETA_SHELLS_CREATIVE_TAB = new CreativeTabs("velveetashells") {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem()
        {
            return new ItemStack(getVelveetaShellsCreativeTabIcon());
        }
    };

    public static final Item VELVEETA_SHELLS_AND_CHEESE_ITEM = (new ItemFood(20, 1F, false)).setAlwaysEdible().setRegistryName("velveeta_shells_and_cheese").setUnlocalizedName("velveeta_shells_and_cheese").setCreativeTab(VELVEETA_SHELLS_CREATIVE_TAB);

    public static Item getVelveetaShellsCreativeTabIcon() {
        return VELVEETA_SHELLS_AND_CHEESE_ITEM;
    }

    /*
     * Event Handling
     */

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(VELVEETA_SHELLS_AND_CHEESE_ITEM);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onRegisterModels(ModelRegistryEvent event) {
        // Register Item Renders
        ModelLoader.setCustomModelResourceLocation(VELVEETA_SHELLS_AND_CHEESE_ITEM, 0, new ModelResourceLocation(VELVEETA_SHELLS_AND_CHEESE_ITEM.getRegistryName(), "inventory"));
    }

}

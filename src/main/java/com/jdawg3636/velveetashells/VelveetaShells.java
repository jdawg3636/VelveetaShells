package com.jdawg3636.velveetashells;

import net.minecraft.item.*;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod(VelveetaShells.MODID)
@Mod.EventBusSubscriber
public class VelveetaShells {

    public static final String MODID = "velveetashells";

    public static final ItemGroup VELVEETA_SHELLS_CREATIVE_TAB = new ItemGroup("velveetashells") {
        @OnlyIn(Dist.CLIENT)
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(VELVEETA_SHELLS_AND_CHEESE_ITEM::get);
        }
    };

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> VELVEETA_SHELLS_AND_CHEESE_ITEM = ITEMS.register("velveeta_shells_and_cheese",() -> new Item((new Item.Properties())
            .tab(VELVEETA_SHELLS_CREATIVE_TAB)
            .food(new Food.Builder()
                    .nutrition(20)
                    .saturationMod(1F)
                    .alwaysEat()
                    .build()
            )
    ));

    public VelveetaShells() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

}

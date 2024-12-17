package com.jdawg3636.velveetashells;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(VelveetaShells.MODID)
@Mod.EventBusSubscriber
public class VelveetaShells {

    public static final String MODID = "velveetashells";

    public static CreativeModeTab VELVEETA_SHELLS_CREATIVE_TAB;

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> VELVEETA_SHELLS_AND_CHEESE_ITEM = ITEMS.register("velveeta_shells_and_cheese",() -> new Item((new Item.Properties())
            .food(new FoodProperties.Builder()
                    .nutrition(20)
                    .saturationMod(1F)
                    .alwaysEat()
                    .build()
            )
    ));

    public VelveetaShells() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onRegisterCreativeModeTabEvent);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onBuildContentsCreativeModeTabEvent);
    }

    public void onRegisterCreativeModeTabEvent(CreativeModeTabEvent.Register event) {
        VELVEETA_SHELLS_CREATIVE_TAB = event.registerCreativeModeTab(
                new net.minecraft.resources.ResourceLocation(MODID, MODID),
                builder -> builder
                        .icon(() -> VELVEETA_SHELLS_AND_CHEESE_ITEM.get().getDefaultInstance())
                        .title(net.minecraft.network.chat.Component.translatable("itemGroup.velveetashells"))
                        .build()
        );
    }

    public void onBuildContentsCreativeModeTabEvent(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == VELVEETA_SHELLS_CREATIVE_TAB) {
            event.accept(VELVEETA_SHELLS_AND_CHEESE_ITEM);
        }
    }

}

package example.examplemod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = "my_mod")
public final class ItemInitializer {

    // 我们一会会用到它。
    public static Item firstItem;

    // 和正常的事件一样，你不需要手动调用此方法！Forge 会自动调用它的。
    @SubscribeEvent
    public static void registerItem(RegistryEvent.Register<Item> event) {
        event.getRegistry().register(new Item()
                .setCreativeTab(EXAMPLE_CREATIVE_TAB)
                .setTranslationKey("my_mod.aaa")
                .setRegistryName("my_mod:aaa"));
        event.getRegistry().register(
                firstItem = new Item()
                        .setCreativeTab(EXAMPLE_CREATIVE_TAB)
                        // 注意此名字和 registry name 不是一个概念。
                        // 这个名字仅用于国际化支持。
                        // 这个方法也返回 Item。
                        .setTranslationKey("my_mod.example_item")
                        .setRegistryName("my_mod:first_item")
        );
    }

    // 我们需要一个 CreativeTabs 的实例，当然那个类下面就有原版的 10 个，可以直接拿来用，
// 但是你不觉得有一个自己的更方便吗……
// 一般是使用匿名内部类，就像这样。
    public static final CreativeTabs EXAMPLE_CREATIVE_TAB = new CreativeTabs("example_tab") {
        // 获得用作标签图标的 ItemStack。你大可以往里面塞各种奇奇怪怪的数据。
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.DIAMOND);
        }
    };
}
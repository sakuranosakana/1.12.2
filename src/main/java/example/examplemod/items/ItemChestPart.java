package example.examplemod.items;

import example.examplemod.MyMod;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemChestPart extends Item {

    public ItemChestPart(String name) {
        setCreativeTab(CreativeTabs.MATERIALS);
        setTranslationKey(name);
        setRegistryName(MyMod.MODID, name);
    }
}
package example.examplemod.tileentities;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public final class MyLavaFurnaceEntity extends TileEntity {

    private int progress;
    private int fuel;

    /**
     * @param fuel 玩家当前手持的物品（见 MyLavaFurnace.onBlockActivated）
     * @return 尝试消耗燃料后的剩余物品，有可能仍然是未经修改的 fuel 实例
     */
    public ItemStack tryAcceptFuel(ItemStack fuel) {
        if (fuel.getItem() == Items.LAVA_BUCKET) {
            this.fuel += 1000;
            return new ItemStack(Items.BUCKET);
        } else {
            return fuel;
        }
    }

    public int getFuel() {
        return this.fuel;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        this.progress = tag.getInteger("Progress");
        this.fuel = tag.getInteger("Fuel");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        tag.setInteger("Progress", this.progress);
        tag.setInteger("Fuel", this.fuel);
        return super.writeToNBT(tag);
    }

}
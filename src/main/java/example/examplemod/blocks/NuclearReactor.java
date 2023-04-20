package example.examplemod.blocks;

import example.examplemod.MyMod;
import example.examplemod.tileentities.MyLavaFurnaceEntity;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

import static example.examplemod.items.ItemInitializer.EXAMPLE_CREATIVE_TAB;

@Mod.EventBusSubscriber(modid = "my_mod")
public final class NuclearReactor extends Block{
    public static Block myBlock;
    public NuclearReactor() {
        super(Material.ROCK, MapColor.LIGHT_BLUE);
        setTranslationKey("nuclearRector");
        setRegistryName(MyMod.MODID, "nuclearRector");
        setHardness(2.5F);
        setSoundType(SoundType.STONE);
        setHarvestLevel("pickaxe", 0);
    }
    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new MyLavaFurnaceEntity();
    }
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        TileEntity tile = world.getTileEntity(pos);
        if (tile instanceof MyLavaFurnaceEntity && !world.isRemote) {
            player.setHeldItem(hand, ((MyLavaFurnaceEntity)tile).tryAcceptFuel(player.getHeldItem(hand)));
            player.sendStatusMessage(new TextComponentString("Fuel: " + ((MyLavaFurnaceEntity) tile).getFuel()), true);
            return true;
        }
        return false;
    }
}
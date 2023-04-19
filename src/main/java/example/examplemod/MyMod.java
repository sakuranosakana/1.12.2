package example.examplemod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

// Mod主类的标记。其中只有modid是必填项。
//
// modid 不允许使用大写字母，最大长度 64，不能为空。
// 推荐在 modid 中只使用小写字母、数字、连字符和下划线，换言之即只使用满足正则表达式
// [a-z0-9\-_]{1,64} 的 modid。
// 发现不符合要求的 modid 时，会抛出 IllegalArgumentException 阻止游戏启动。
//
// name 没有限制。若不填则直接使用 modid 充当 name，但仍然会产生警告。
// 一般来说，name 都满足正则表达式 [\w ]+。但也有少许例外。
//
// version 没有限制，若不填则使用 1.0，并产生警告。
// 对于 version 来说，***强烈***推荐只用数字和点，比如只有 MAJOR.MINOR.PATCH 的 SemVer。
//
// useMetadata = true 让 Forge 以 mcmod.info 里的信息为准。它的格式在“Mod 的元数据”一节
// 会有详细说明。
@Mod(modid = "my_mod", name = "My First Mod", version = "0.0.0", useMetadata = true)
public enum MyMod {
    INSTANCE;

    // Mod 主类实例的“工厂”。
    // 别的 Mod 开发教程肯定使用的是@Mod.Instance
    // 这里之所以这么写，是因为主类是 enum，换言之父类是 java.lang.Enum
    // 因此，FML 直接 Class.newInstance() 的话一定会报错，java.lang.Enum 没有零参构造器
    @Mod.InstanceFactory
    public static MyMod getInstance() {
        return INSTANCE;
    }

    // 一个入口方法。
    // Mod的加载大致分为 6 个阶段，每个阶段均有一个事件代表，
    // 而 @Mod.EventHandler 注解则标记该方法将订阅此事件。
    // Mod 加载时的六个阶段对应的事件，以时间顺序排列：
    //    FMLConstructionEvent
    //    FMLPreInitializationEvent
    //    FMLInitializationEvent
    //    FMLInterModComms.IMCEvent
    //    FMLPostInitializationEvent
    //    FMLLoadCompleteEvent
    // 其中，PreInit.、Init.、IMCEvent 和 PostInit. 是最常用的四个事件，
    // 剩下两个事件只有在相当少见的情况下才会用到，大可暂时无视。
    @Mod.EventHandler
    public void preLoad(FMLPreInitializationEvent event) {
        System.out.println("Hello, Forge");
    }
}
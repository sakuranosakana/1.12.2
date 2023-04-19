package example.examplemod.algorithm;

import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NuclearFission {
    @SubscribeEvent
    public void a(EntityItemPickupEvent event) {
        int XiaoLv = 1;
        int exXiaoLv = 1;
        int ranShao = 10000;
        int fullXiaoLv = XiaoLv + exXiaoLv;
        int faDianLiang = fullXiaoLv * 5;
        int fullFaDianLiang = ranShao * faDianLiang;
        int faReLiang = 1;
        int time = 1;
        int reLiang = faReLiang * time;
        if (reLiang >= 4000) {System.out.println("警告！高温使附近燃烧");}
        System.out.println("calorific value:"+faReLiang+"generated energy:"+faDianLiang+"gross generation:"+fullFaDianLiang);
    }
}
/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Exception
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.Void
 *  java.util.Set
 *  java.util.concurrent.CompletableFuture
 *  java.util.concurrent.Executor
 *  java.util.function.BiConsumer
 *  java.util.function.Function
 *  java.util.stream.Collectors
 *  net.minecraft.class_2960
 *  net.minecraft.class_3300
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable
 *  software.bernie.geckolib.cache.GeckoLibCache
 */
package cn.pixellive.mc.game.mixin.model;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaam.aaaaaa;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import net.minecraft.class_2960;
import net.minecraft.class_3300;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import software.bernie.geckolib.cache.GeckoLibCache;

@Mixin(value={GeckoLibCache.class})
public class GeckoLibCacheMixin {
    @Unique
    private static final String ANIMATION_PATH;
    @Unique
    private static final String MODEL_PATH;

    @Inject(method={"loadResources"}, at={@At(value="HEAD")}, remap=false)
    private static <T> void onLoadResources(Executor executor, class_3300 class_33002, String string, Function<class_2960, T> function, BiConsumer<class_2960, T> biConsumer, CallbackInfoReturnable<CompletableFuture<Void>> callbackInfoReturnable) {
        if (string.equals((Object)"animations")) {
            GeckoLibCacheMixin.loadEncryptedAnimations(executor, function, biConsumer);
        } else if (string.equals((Object)"geo")) {
            GeckoLibCacheMixin.loadEncryptedModels(executor, function, biConsumer);
        }
    }

    @Unique
    private static <T> void loadEncryptedAnimations(Executor executor, Function<class_2960, T> function, BiConsumer<class_2960, T> biConsumer) {
        Set<String> set = GeckoLibCacheMixin.getResourcesWithSuffix("assets/pixellivegame/animations/", ".animation.json");
        for (String string : set) {
            byte[] byArray = aaaaaa.你为什么要破解我的代码aaaaaa(string);
            if (byArray == null) continue;
            String string2 = string.substring("assets/pixellivegame/".length());
            class_2960 class_29602 = class_2960.method_60655((String)"pixellivegame", (String)string2);
            CompletableFuture.supplyAsync(() -> {
                try {
                    return function.apply((Object)class_29602);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return null;
                }
            }, (Executor)executor).thenAccept(object -> {
                if (object != null) {
                    biConsumer.accept((Object)class_29602, object);
                }
            });
        }
    }

    @Unique
    private static <T> void loadEncryptedModels(Executor executor, Function<class_2960, T> function, BiConsumer<class_2960, T> biConsumer) {
        Set<String> set = GeckoLibCacheMixin.getResourcesWithSuffix("assets/pixellivegame/geo/", ".geo.json");
        for (String string : set) {
            byte[] byArray = aaaaaa.你为什么要破解我的代码aaaaaa(string);
            if (byArray == null) continue;
            String string2 = string.substring("assets/pixellivegame/".length());
            class_2960 class_29602 = class_2960.method_60655((String)"pixellivegame", (String)string2);
            CompletableFuture.supplyAsync(() -> {
                try {
                    return function.apply((Object)class_29602);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    return null;
                }
            }, (Executor)executor).thenAccept(object -> {
                if (object != null) {
                    biConsumer.accept((Object)class_29602, object);
                }
            });
        }
    }

    @Unique
    private static Set<String> getResourcesWithSuffix(String string, String string2) {
        return (Set)aaaaaa.你为什么要破解我的代码aaaaad().keySet().stream().filter(string3 -> string3.startsWith(string) && string3.endsWith(string2)).collect(Collectors.toSet());
    }

    static {
        MODEL_PATH = "assets/pixellivegame/geo/";
        ANIMATION_PATH = "assets/pixellivegame/animations/";
    }
}


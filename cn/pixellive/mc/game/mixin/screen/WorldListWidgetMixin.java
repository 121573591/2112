/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.gson.Gson
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  java.io.File
 *  java.io.IOException
 *  java.io.Reader
 *  java.io.StringReader
 *  java.lang.Object
 *  java.lang.String
 *  java.nio.file.CopyOption
 *  java.nio.file.FileVisitResult
 *  java.nio.file.FileVisitor
 *  java.nio.file.Files
 *  java.nio.file.LinkOption
 *  java.nio.file.Path
 *  java.nio.file.SimpleFileVisitor
 *  java.nio.file.StandardCopyOption
 *  java.nio.file.attribute.BasicFileAttributes
 *  java.nio.file.attribute.FileAttribute
 *  java.util.Arrays
 *  java.util.Map$Entry
 *  java.util.Optional
 *  net.fabricmc.loader.api.FabricLoader
 *  net.minecraft.class_310
 *  net.minecraft.class_34
 *  net.minecraft.class_437
 *  net.minecraft.class_528$class_4272
 *  org.spongepowered.asm.mixin.Final
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Shadow
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package cn.pixellive.mc.game.mixin.screen;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaax;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaah.aaaaaa.aaaaap;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.CopyOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.class_310;
import net.minecraft.class_34;
import net.minecraft.class_437;
import net.minecraft.class_528;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_528.class_4272.class})
public abstract class WorldListWidgetMixin {
    @Final
    @Shadow
    class_34 field_19138;

    @Inject(method={"play"}, at={@At(value="HEAD")}, cancellable=true)
    private void onPlay(CallbackInfo callbackInfo) {
        Optional optional = Optional.of((Object)((class_528.class_4272)this));
        if (optional.isPresent()) {
            class_528.class_4272 class_42722 = (class_528.class_4272)optional.get();
            Path path = this.field_19138.method_27020().getParent().resolve("game_settings.json");
            if (Files.exists((Path)path, (LinkOption[])new LinkOption[0])) {
                try {
                    JsonObject jsonObject;
                    String string = Files.readString((Path)path);
                    Gson gson = new Gson();
                    try (StringReader stringReader = new StringReader(string);){
                        jsonObject = (JsonObject)gson.fromJson((Reader)stringReader, JsonObject.class);
                    }
                    for (Map.Entry entry : jsonObject.entrySet()) {
                        Path path2;
                        File file2;
                        String string2 = (String)entry.getKey();
                        JsonElement jsonElement = (JsonElement)entry.getValue();
                        if (!string2.equals((Object)"gameStages")) continue;
                        String string3 = jsonElement.getAsString();
                        if (!aaaaap.我草你怎么反编译我模组aaaaaa.contains((Object)string3)) {
                            class_310.method_1551().method_1507((class_437)new aaaaax(string3));
                            callbackInfo.cancel();
                            return;
                        }
                        if (string3.equals((Object)"生存挑战") || (file2 = (File)Arrays.stream((Object[])(path2 = FabricLoader.getInstance().getGameDir().resolve("originsaves")).toFile().listFiles()).filter(file -> file.isDirectory() && file.getName().equals((Object)string3)).findFirst().orElse(null)) == null) break;
                        final Path path3 = path.getParent();
                        try {
                            Files.walkFileTree((Path)path3, (FileVisitor)new SimpleFileVisitor<Path>(this){

                                public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                                    if (!path.getFileName().toString().equals((Object)"game_settings.json")) {
                                        Files.delete((Path)path);
                                    }
                                    return FileVisitResult.CONTINUE;
                                }

                                public FileVisitResult postVisitDirectory(Path path, IOException iOException) throws IOException {
                                    if (!path.equals((Object)path3)) {
                                        Files.delete((Path)path);
                                    }
                                    return FileVisitResult.CONTINUE;
                                }
                            });
                        }
                        catch (IOException iOException) {
                            // empty catch block
                        }
                        try {
                            Files.walkFileTree((Path)file2.toPath(), (FileVisitor)new SimpleFileVisitor<Path>(this){

                                public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                                    Path path2 = path3.resolve(file2.toPath().relativize(path));
                                    Files.createDirectories((Path)path2, (FileAttribute[])new FileAttribute[0]);
                                    return FileVisitResult.CONTINUE;
                                }

                                public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
                                    if (!path.getFileName().toString().equals((Object)"game_settings.json")) {
                                        Path path2 = path3.resolve(file2.toPath().relativize(path));
                                        Files.copy((Path)path, (Path)path2, (CopyOption[])new CopyOption[]{StandardCopyOption.REPLACE_EXISTING});
                                    }
                                    return FileVisitResult.CONTINUE;
                                }
                            });
                        }
                        catch (IOException iOException) {}
                        break;
                    }
                }
                catch (IOException iOException) {
                    // empty catch block
                }
            }
        }
    }
}


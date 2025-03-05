/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.CharSequence
 *  java.lang.Class
 *  java.lang.Exception
 *  java.lang.NoSuchFieldException
 *  java.lang.Object
 *  java.lang.String
 *  java.lang.reflect.Field
 *  java.lang.reflect.Method
 *  java.util.ArrayList
 *  java.util.Iterator
 *  java.util.List
 *  net.minecraft.class_2561
 *  net.minecraft.class_310
 *  net.minecraft.class_332
 *  net.minecraft.class_364
 *  net.minecraft.class_4185
 *  net.minecraft.class_4185$class_4241
 *  net.minecraft.class_437
 *  net.minecraft.class_5244
 *  net.minecraft.class_525
 *  net.minecraft.class_526
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Inject
 *  org.spongepowered.asm.mixin.injection.ModifyArg
 *  org.spongepowered.asm.mixin.injection.callback.CallbackInfo
 */
package cn.pixellive.mc.game.mixin.screen;

import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaad.aaaaaa.aaaaao;
import aaaaaa.aaaaaa.aaaaaa.aaaaaa.aaaaaf.aaaaac.aaaaab;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import net.minecraft.class_2561;
import net.minecraft.class_310;
import net.minecraft.class_332;
import net.minecraft.class_364;
import net.minecraft.class_4185;
import net.minecraft.class_437;
import net.minecraft.class_5244;
import net.minecraft.class_525;
import net.minecraft.class_526;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value={class_526.class}, priority=1500)
public class SelectWorldScreenMixin {
    private class_4185 selectButton = null;
    private class_4185 editButton = null;
    private class_4185 recreateButton = null;
    private class_4185 createButton = null;
    private class_4185 deleteButton = null;
    private class_4185 backButton = null;
    private class_4185 customSelectButton = null;
    private class_4185 customDeleteButton = null;
    private List<class_4185> originalButtons = new ArrayList();
    private List<class_4185> customButtons = new ArrayList();

    @ModifyArg(method={"<init>"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/Screen;<init>(Lnet/minecraft/text/Text;)V"), index=0)
    private static class_2561 modifyScreenTitle(class_2561 class_25612) {
        return class_2561.method_43471((String)"pixellivegame.select_gameplay.title");
    }

    @Inject(method={"init"}, at={@At(value="TAIL")})
    private void afterInit(CallbackInfo callbackInfo) {
        class_526 class_5263 = (class_526)this;
        this.findOriginalButtons(class_5263);
        this.createCustomButtons(class_5263);
    }

    private void findOriginalButtons(class_526 class_5263) {
        this.originalButtons.clear();
        int n = class_5263.field_22789 / 2;
        int n2 = class_5263.field_22790 - 30;
        for (Object object : class_5263.method_25396()) {
            if (!(object instanceof class_4185)) continue;
            class_4185 class_41852 = (class_4185)object;
            String string = class_41852.method_25369().getString();
            int n3 = class_41852.hashCode();
            this.originalButtons.add((Object)class_41852);
            if (string.contains((CharSequence)"selectWorld.select") || string.contains((CharSequence)"Play Selected World") || string.equals((Object)"进入选中的世界")) {
                this.selectButton = class_41852;
                continue;
            }
            if (string.contains((CharSequence)"selectWorld.edit") || string.contains((CharSequence)"Edit") || string.equals((Object)"编辑")) {
                this.editButton = class_41852;
                continue;
            }
            if (string.contains((CharSequence)"selectWorld.recreate") || string.contains((CharSequence)"Re-create") || string.equals((Object)"重建")) {
                this.recreateButton = class_41852;
                continue;
            }
            if (string.contains((CharSequence)"selectWorld.create") || string.contains((CharSequence)"Create New World") || string.equals((Object)"创建新的世界")) {
                this.createButton = class_41852;
                continue;
            }
            if (string.contains((CharSequence)"selectWorld.delete") || string.contains((CharSequence)"Delete") || string.equals((Object)"删除")) {
                this.deleteButton = class_41852;
                continue;
            }
            if (!string.contains((CharSequence)"gui.cancel") && !string.contains((CharSequence)"Cancel") && !string.contains((CharSequence)"gui.back") && !string.contains((CharSequence)"Back") && !string.equals((Object)class_5244.field_24339.getString()) && !string.equals((Object)"返回") || string.equals((Object)"删除") || string.equals((Object)"重建")) continue;
            this.backButton = class_41852;
        }
        if (this.selectButton == null || this.createButton == null || this.deleteButton == null || this.backButton == null) {
            for (Object object : this.originalButtons) {
                int n4 = object.method_46426();
                int n5 = object.method_46427();
                if (this.selectButton == null && n4 < n && n5 < class_5263.field_22790 / 2) {
                    this.selectButton = object;
                }
                if (this.createButton == null && n4 > n && n5 < class_5263.field_22790 / 2) {
                    this.createButton = object;
                }
                if (this.deleteButton == null && n4 < n && n5 > class_5263.field_22790 / 2) {
                    this.deleteButton = object;
                }
                if (this.backButton != null || n5 <= class_5263.field_22790 - 50) continue;
                this.backButton = object;
            }
        }
    }

    private void createCustomButtons(class_526 class_5263) {
        this.customButtons.clear();
        int n = class_5263.field_22789;
        int n2 = class_5263.field_22790;
        int n3 = 150;
        int n4 = 20;
        int n5 = 4;
        int n6 = 10;
        int n7 = n2 - n6 - n4;
        int n8 = n7 - n4 - n5;
        int n9 = n / 2 - n3 - n5 / 2;
        int n10 = n / 2 + n5 / 2;
        class_4185.class_4241 class_42412 = this.selectButton != null ? this.getButtonPressAction(this.selectButton) : null;
        class_4185.class_4241 class_42413 = this.createButton != null ? this.getButtonPressAction(this.createButton) : null;
        class_4185.class_4241 class_42414 = this.deleteButton != null ? this.getButtonPressAction(this.deleteButton) : null;
        class_4185.class_4241 class_42415 = this.backButton != null ? this.getButtonPressAction(this.backButton) : null;
        try {
            class_4185 class_418532;
            Method method = class_437.class.getDeclaredMethod("addDrawableChild", new Class[]{class_364.class});
            method.setAccessible(true);
            for (class_4185 class_418532 : this.originalButtons) {
                try {
                    class_418532.field_22764 = false;
                }
                catch (Exception exception) {
                    aaaaab.你为什么要破解我的代码aaaaaa().error("[SelectWorldScreenMixin] 无法隐藏原始按钮: {}", (Object)exception.getMessage());
                }
            }
            Iterator iterator = class_4185.method_46430((class_2561)class_2561.method_43471((String)"pixellivegame.select_gameplay.play"), class_41852 -> {
                if (class_42412 != null) {
                    class_42412.onPress(this.selectButton);
                } else {
                    aaaaab.你为什么要破解我的代码aaaaaa().error("[SelectWorldScreenMixin] 选择按钮未定义动作");
                }
            }).method_46433(n9, n8).method_46437(n3, n4).method_46431();
            if (this.selectButton != null) {
                iterator.field_22763 = this.selectButton.field_22763;
            }
            this.customSelectButton = iterator;
            method.invoke((Object)class_5263, new Object[]{iterator});
            this.customButtons.add((Object)iterator);
            class_418532 = class_4185.method_46430((class_2561)class_2561.method_43471((String)"pixellivegame.select_gameplay.create"), class_41852 -> {
                try {
                    if (class_42413 != null) {
                        class_42413.onPress(this.createButton);
                        class_310.method_1551().execute(() -> {
                            class_437 class_4372 = class_310.method_1551().field_1755;
                            if (class_4372 instanceof class_525) {
                                aaaaao aaaaao2 = new aaaaao((class_525)class_4372, (class_437)class_5263);
                                class_310.method_1551().method_1507((class_437)aaaaao2);
                            } else {
                                aaaaab.你为什么要破解我的代码aaaaaa().error("[SelectWorldScreenMixin] 未能找到CreateWorldScreen，无法跳转");
                            }
                        });
                    } else {
                        class_310 class_3102 = class_310.method_1551();
                        try {
                            Method method = class_310.class.getDeclaredMethod("openCreateWorldScreen", new Class[]{class_437.class});
                            method.setAccessible(true);
                            method.invoke((Object)class_3102, new Object[]{class_5263});
                            class_3102.execute(() -> {
                                class_437 class_4372 = class_3102.field_1755;
                                if (class_4372 instanceof class_525) {
                                    aaaaao aaaaao2 = new aaaaao((class_525)class_4372, (class_437)class_5263);
                                    class_3102.method_1507((class_437)aaaaao2);
                                }
                            });
                        }
                        catch (Exception exception) {
                            class_5263.method_25419();
                        }
                    }
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                    class_5263.method_25419();
                }
            }).method_46433(n10, n8).method_46437(n3, n4).method_46431();
            method.invoke((Object)class_5263, new Object[]{class_418532});
            this.customButtons.add((Object)class_418532);
            class_4185 class_41854 = class_4185.method_46430((class_2561)class_2561.method_43471((String)"pixellivegame.select_gameplay.delete"), class_41852 -> {
                if (class_42414 != null) {
                    class_42414.onPress(this.deleteButton);
                } else {
                    aaaaab.你为什么要破解我的代码aaaaaa().error("[SelectWorldScreenMixin] 未找到删除按钮操作，使用默认动作");
                }
            }).method_46433(n9, n7).method_46437(n3, n4).method_46431();
            if (this.deleteButton != null) {
                class_41854.field_22763 = this.deleteButton.field_22763;
            }
            this.customDeleteButton = class_41854;
            method.invoke((Object)class_5263, new Object[]{class_41854});
            this.customButtons.add((Object)class_41854);
            class_4185 class_41855 = class_4185.method_46430((class_2561)class_2561.method_43470((String)"返回主界面"), class_41852 -> {
                if (class_42415 != null) {
                    class_42415.onPress(this.backButton);
                } else {
                    class_5263.method_25419();
                }
            }).method_46433(n10, n7).method_46437(n3, n4).method_46431();
            method.invoke((Object)class_5263, new Object[]{class_41855});
            this.customButtons.add((Object)class_41855);
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error("创建自定义按钮失败");
            exception.printStackTrace();
        }
    }

    @Inject(method={"render"}, at={@At(value="HEAD")})
    private void beforeRender(class_332 class_3322, int n, int n2, float f, CallbackInfo callbackInfo) {
        for (class_4185 class_41852 : this.originalButtons) {
            if (class_41852 == null) continue;
            class_41852.field_22764 = false;
        }
        if (this.selectButton != null && this.customSelectButton != null) {
            this.customSelectButton.field_22763 = this.selectButton.field_22763;
        }
        if (this.deleteButton != null && this.customDeleteButton != null) {
            this.customDeleteButton.field_22763 = this.deleteButton.field_22763;
        }
    }

    private class_4185.class_4241 getButtonPressAction(class_4185 class_41852) {
        Class clazz;
        for (String string : clazz = new Class[]{"onPress", "pressAction", "action", "clickAction", "onClick"}) {
            try {
                Field field = class_4185.class.getDeclaredField(string);
                field.setAccessible(true);
                Object object = field.get((Object)class_41852);
                if (!(object instanceof class_4185.class_4241)) continue;
                return (class_4185.class_4241)object;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                aaaaab.你为什么要破解我的代码aaaaaa().error("[SelectWorldScreenMixin] 按钮字段不存在:{}", (Object)string);
            }
            catch (Exception exception) {
                aaaaab.你为什么要破解我的代码aaaaaa().error("[SelectWorldScreenMixin] 获取字段{}时出错", (Object)string);
            }
        }
        try {
            Field[] fieldArray;
            Class clazz2 = class_41852.getClass();
            for (Field field : fieldArray = clazz2.getDeclaredFields()) {
                if (!class_4185.class_4241.class.isAssignableFrom(field.getType())) continue;
                field.setAccessible(true);
                Object object = field.get((Object)class_41852);
                return (class_4185.class_4241)object;
            }
        }
        catch (Exception exception) {
            aaaaab.你为什么要破解我的代码aaaaaa().error("[SelectWorldScreenMixin] 尝试通过类型匹配查找字段时出错");
        }
        return class_41853 -> {
            try {
                Method method = class_4185.class.getDeclaredMethod("onPress", new Class[0]);
                method.setAccessible(true);
                method.invoke((Object)class_41852, new Object[0]);
            }
            catch (Exception exception) {
                aaaaab.你为什么要破解我的代码aaaaaa().error("[SelectWorldScreenMixin] 无法调用原始按钮的onPress方法");
                try {
                    class_41852.method_25306();
                }
                catch (Exception exception2) {
                    aaaaab.你为什么要破解我的代码aaaaaa().error("[SelectWorldScreenMixin] 无法调用原始按钮的方法");
                }
            }
        };
    }
}


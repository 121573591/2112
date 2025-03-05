/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 *  java.util.List
 */
package tech.ordinaryroad.live.chat.client.codec.douyin.protobuf;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.GradeBuffInfo;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.GradeBuffInfoOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.GradeIcon;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.GradeIconOrBuilder;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.Image;
import tech.ordinaryroad.live.chat.client.codec.douyin.protobuf.ImageOrBuilder;

public interface PayGradeOrBuilder
extends MessageOrBuilder {
    public long getTotalDiamondCount();

    public boolean hasDiamondIcon();

    public Image getDiamondIcon();

    public ImageOrBuilder getDiamondIconOrBuilder();

    public String getName();

    public ByteString getNameBytes();

    public boolean hasIcon();

    public Image getIcon();

    public ImageOrBuilder getIconOrBuilder();

    public String getNextName();

    public ByteString getNextNameBytes();

    public long getLevel();

    public boolean hasNextIcon();

    public Image getNextIcon();

    public ImageOrBuilder getNextIconOrBuilder();

    public long getNextDiamond();

    public long getNowDiamond();

    public long getThisGradeMinDiamond();

    public long getThisGradeMaxDiamond();

    public long getPayDiamondBak();

    public String getGradeDescribe();

    public ByteString getGradeDescribeBytes();

    public List<GradeIcon> getGradeIconListList();

    public GradeIcon getGradeIconList(int var1);

    public int getGradeIconListCount();

    public List<? extends GradeIconOrBuilder> getGradeIconListOrBuilderList();

    public GradeIconOrBuilder getGradeIconListOrBuilder(int var1);

    public long getScreenChatType();

    public boolean hasImIcon();

    public Image getImIcon();

    public ImageOrBuilder getImIconOrBuilder();

    public boolean hasImIconWithLevel();

    public Image getImIconWithLevel();

    public ImageOrBuilder getImIconWithLevelOrBuilder();

    public boolean hasLiveIcon();

    public Image getLiveIcon();

    public ImageOrBuilder getLiveIconOrBuilder();

    public boolean hasNewImIconWithLevel();

    public Image getNewImIconWithLevel();

    public ImageOrBuilder getNewImIconWithLevelOrBuilder();

    public boolean hasNewLiveIcon();

    public Image getNewLiveIcon();

    public ImageOrBuilder getNewLiveIconOrBuilder();

    public long getUpgradeNeedConsume();

    public String getNextPrivileges();

    public ByteString getNextPrivilegesBytes();

    public boolean hasBackground();

    public Image getBackground();

    public ImageOrBuilder getBackgroundOrBuilder();

    public boolean hasBackgroundBack();

    public Image getBackgroundBack();

    public ImageOrBuilder getBackgroundBackOrBuilder();

    public long getScore();

    public boolean hasBuffInfo();

    public GradeBuffInfo getBuffInfo();

    public GradeBuffInfoOrBuilder getBuffInfoOrBuilder();

    public String getGradeBanner();

    public ByteString getGradeBannerBytes();

    public boolean hasProfileDialogBg();

    public Image getProfileDialogBg();

    public ImageOrBuilder getProfileDialogBgOrBuilder();

    public boolean hasProfileDialogBgBack();

    public Image getProfileDialogBgBack();

    public ImageOrBuilder getProfileDialogBgBackOrBuilder();
}


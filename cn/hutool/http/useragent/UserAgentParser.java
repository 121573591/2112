/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.Object
 *  java.lang.String
 */
package cn.hutool.http.useragent;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.useragent.Browser;
import cn.hutool.http.useragent.Engine;
import cn.hutool.http.useragent.OS;
import cn.hutool.http.useragent.Platform;
import cn.hutool.http.useragent.UserAgent;

public class UserAgentParser {
    public static UserAgent parse(String userAgentString) {
        if (StrUtil.isBlank(userAgentString)) {
            return null;
        }
        UserAgent userAgent = new UserAgent();
        Browser browser = UserAgentParser.parseBrowser(userAgentString);
        userAgent.setBrowser(browser);
        userAgent.setVersion(browser.getVersion(userAgentString));
        Engine engine = UserAgentParser.parseEngine(userAgentString);
        userAgent.setEngine(engine);
        userAgent.setEngineVersion(engine.getVersion(userAgentString));
        OS os = UserAgentParser.parseOS(userAgentString);
        userAgent.setOs(os);
        userAgent.setOsVersion(os.getVersion(userAgentString));
        Platform platform = UserAgentParser.parsePlatform(userAgentString);
        userAgent.setPlatform(platform);
        userAgent.setMobile(platform.isMobile() || browser.isMobile());
        return userAgent;
    }

    private static Browser parseBrowser(String userAgentString) {
        for (Browser browser : Browser.browers) {
            if (!browser.isMatch(userAgentString)) continue;
            return browser;
        }
        return Browser.Unknown;
    }

    private static Engine parseEngine(String userAgentString) {
        for (Engine engine : Engine.engines) {
            if (!engine.isMatch(userAgentString)) continue;
            return engine;
        }
        return Engine.Unknown;
    }

    private static OS parseOS(String userAgentString) {
        for (OS os : OS.oses) {
            if (!os.isMatch(userAgentString)) continue;
            return os;
        }
        return OS.Unknown;
    }

    private static Platform parsePlatform(String userAgentString) {
        for (Platform platform : Platform.platforms) {
            if (!platform.isMatch(userAgentString)) continue;
            return platform;
        }
        return Platform.Unknown;
    }
}


package com.xfi.liuliangjun.icon;

import com.joanzapata.iconify.Icon;
import com.joanzapata.iconify.IconFontDescriptor;

/**
 * Created by 陈小康 on 2017/9/3.
 */

public class WeChatIconModule implements IconFontDescriptor{

    @Override
    public String ttfFileName() {
        return "iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return WeChatIcons.values();
    }
}

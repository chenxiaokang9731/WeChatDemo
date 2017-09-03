package com.xfi.liuliangjun.icon;

import com.joanzapata.iconify.Icon;

@SuppressWarnings({"unused", "SpellCheckingInspection"})
enum WeChatIcons implements Icon{

    wechat_1('\ue6bb'),
    wechat_2('\ue615');

    char character;

    WeChatIcons(char character) {
        this.character = character;
    }

    public String key() {
        return this.name().replace('_', '-');
    }

    public char character() {
        return this.character;
    }
}

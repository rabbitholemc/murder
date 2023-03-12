package br.com.rabbithole.murder.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;

public class StringUtils {
    public static Component formatString(String input) {
        return MiniMessage.miniMessage().deserialize(input);
    }
}

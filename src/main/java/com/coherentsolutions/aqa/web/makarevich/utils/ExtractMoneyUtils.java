package com.coherentsolutions.aqa.web.makarevich.utils;

import lombok.SneakyThrows;

import java.text.DecimalFormat;
import java.util.Locale;

public class ExtractMoneyUtils {
    @SneakyThrows
    public static String extractMoneyValue(String text) {
        return DecimalFormat.getCurrencyInstance(Locale.US).parse(text).toString();
    }

    public static double extractDouble(String text) {
        return Double.parseDouble(extractMoneyValue(text));
    }
}

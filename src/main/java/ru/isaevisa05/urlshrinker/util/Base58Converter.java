package ru.isaevisa05.urlshrinker.util;

public class Base58Converter {

    private static final String ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
    private static final int BASE = ALPHABET.length(); // 58

    public static String fromLong(long value) {
        if (value == 0) return String.valueOf(ALPHABET.charAt(0));
        StringBuilder sb = new StringBuilder();
        while (value > 0) {
            int index = (int) (value % BASE);
            sb.append(ALPHABET.charAt(index));
            value /= BASE;
        }
        return sb.reverse().toString();
    }

    public static long toLong(String string) {
        long result = 0;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i); c = fixChar(c);
            int index = ALPHABET.indexOf(c);
            if (index == -1) return -1;
            result = result * BASE + index;
        }
        return result;
    }

    private static char fixChar(char c) {
        return switch (c) {
            case 'I', 'l' -> '1';
            case 'O', '0' -> 'o';
            default -> c;
        };
    }
}

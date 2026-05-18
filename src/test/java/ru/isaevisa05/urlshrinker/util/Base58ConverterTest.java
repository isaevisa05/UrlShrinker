package ru.isaevisa05.urlshrinker.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Base58ConverterTest {

    private static final String ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz";
    private static final int BASE = ALPHABET.length();

    @Test
    public void testALPHABET() {
        for (int i = 0; i < BASE; i++) {
            String c = ALPHABET.charAt(i) + "";
            long l = Base58Converter.toLong(c);
            String s = Base58Converter.fromLong(l);
            Assertions.assertEquals(c, s);
            Assertions.assertEquals(i, l);
        }
        String r = "21";
        long rl = 58;
        long l = Base58Converter.toLong(r);
        String s = Base58Converter.fromLong(l);
        Assertions.assertEquals(r, s);
        Assertions.assertEquals(rl, l);
    }

    @Test
    public void testFix() {
        HashMap<String, String[]> map = new HashMap<>();
        map.put("1", new String[]{"I", "l"});
        map.put("o", new String[]{"O", "0"});

        for (Map.Entry<String, String[]> entry : map.entrySet()) {
            for (String s : entry.getValue()) {
                long l = Base58Converter.toLong(s);
                String r = Base58Converter.fromLong(l);
                Assertions.assertEquals(entry.getKey(), r);
            }
        }
    }

}
package com.hanfei.test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author : HanFei
 * @date: 2017/9/8
 * @desc:生成随机数,随机序列,随机字符串
 */
public final class RandomUtil {


    /**
     * 产生随机字符串字符池
     */
    private static final String DIGITAL_STRING = "0123456789";

    private static final String LETTER_STRING = "abcdefghijklmnopqrstuvwxyz";

    private static final String RANDOM_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";


    private RandomUtil() {
    }

    /**
     * 返回startInclusive(包含)~endExclusive(不包含)范围内的随机整数
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static int nextInt(int startInclusive, int endExclusive) {
        return ThreadLocalRandom.current().nextInt(startInclusive, endExclusive);
    }

    /**
     * 返回startInclusive(包含)~endExclusive(不包含)范围内的随机整数
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static long nextLong(long startInclusive, long endExclusive) {
        return ThreadLocalRandom.current().nextLong(startInclusive, endExclusive);
    }


    /**
     * 返回startInclusive(包含)~endExclusive(不包含)范围内的随机单精度浮点数
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static float nextFloat(float startInclusive, float endExclusive) {
        return startInclusive + ThreadLocalRandom.current().nextFloat() * (endExclusive - startInclusive);
    }


    /**
     * 返回startInclusive(包含)~endExclusive(不包含)范围内的随机双精度浮点数
     *
     * @param startInclusive
     * @param endExclusive
     * @return
     */
    public static double nextDouble(double startInclusive, double endExclusive) {
        return ThreadLocalRandom.current().nextDouble(startInclusive, endExclusive);
    }


    /**
     * 返回随机布尔值
     *
     * @return
     */
    public static boolean nextBoolean() {
        return ThreadLocalRandom.current().nextBoolean();
    }


    /**
     * 从入参List里随机itemNum个随机元素组成新List并返回
     *
     * @param list
     * @param itemNum
     * @param <T>
     * @return
     */
    public static <T> List<T> randomList(List<T> list, int itemNum) {
        if (list == null || list.size() < itemNum) {
            throw new IllegalArgumentException("参数格式异常");
        }
        List<T> copyList = new ArrayList<>(list);
        if (list.size() == itemNum) {
            return copyList;
        }
        ThreadLocalRandom random = ThreadLocalRandom.current();
        List<T> randomList = new ArrayList<>();
        for (int i = 0; i < itemNum; i++) {
            randomList.add(copyList.remove(random.nextInt(copyList.size())));
        }
        return randomList;
    }

    /**
     * 指定范围内产生num个不相同的整数
     *
     * @param startInclusive
     * @param endExclusive
     * @param num
     * @return
     */
    public static List<Integer> randomInts(int startInclusive, int endExclusive, int num) {
        if (num > (endExclusive - startInclusive)) {
            throw new IllegalArgumentException("参数格式异常");
        }
        List<Integer> randomList = new ArrayList<>();
        if (num == (endExclusive - startInclusive)) {
            for (int i = startInclusive; i < endExclusive; i++) {
                randomList.add(i);
            }
            return randomList;
        } else {
            Set<Integer> randomSet = new HashSet<>();
            while (randomSet.size() != num) {
                randomSet.add(ThreadLocalRandom.current().nextInt(startInclusive, endExclusive));
            }
            randomList = new ArrayList<>(randomSet);
            Collections.sort(randomList);
            return randomList;
        }

    }

    /**
     * 返回长度为length的随机数字字符串
     *
     * @param length
     * @return
     */
    public static String getDigitalString(int length) {
        return randomString(DIGITAL_STRING, length);
    }

    /**
     * 返回长度为length的随机小写字母字符串
     *
     * @param length
     * @return
     */
    public static String getLetterString(int length) {
        return randomString(LETTER_STRING, length);
    }

    /**
     * 返回长度为length的随机小写、大写、数字字符串
     *
     * @param length
     * @return
     */
    public static String getRandomString(int length) {
        return randomString(RANDOM_STRING, length);
    }

    /**
     * 根据字符池返回长度为length的随机字符串
     *
     * @param charsPool
     * @param length
     * @return
     */
    public static String randomString(String charsPool, int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("参数格式异常");
        }
        int strsLen = charsPool.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(charsPool.charAt(nextInt(0, strsLen)));
        }
        return sb.toString();
    }


    public static void main(String[] args) {
    }

}

package com.mangopuree.support.security;

public class LoginUserHolder {

    private static final ThreadLocal<String> userIdHolder = new ThreadLocal<>();

    public static void set(String userId) {
        userIdHolder.set(userId);
    }

    public static String get() {
        return userIdHolder.get();
    }

    public static Long getAsLong() {
        String id = userIdHolder.get();
        return (id != null) ? Long.parseLong(id) : null;
    }

    public static void clear() {
        userIdHolder.remove();
    }
}

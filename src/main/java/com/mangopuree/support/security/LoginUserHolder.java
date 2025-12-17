package com.mangopuree.support.security;

/**
 * 쓰레드로컬에 로그인 정보 저장 저장은 Interceptor에서
 */
public class LoginUserHolder {

    private static final ThreadLocal<String> userIdHolder = new ThreadLocal<>();
    private static final ThreadLocal<String> userNameHolder = new ThreadLocal<>();

    public static void setUserId(String userId) {
        userIdHolder.set(userId);
    }

    public static String getUserId() {
        return userIdHolder.get();
    }

    public static Long getAsLong() {
        String id = userIdHolder.get();
        return (id != null) ? Long.parseLong(id) : null;
    }

    public static void setUsername(String username) {
        userNameHolder.set(username);
    }

    public static String getUsername() {
        return userNameHolder.get();
    }

    public static void clear() {
        userIdHolder.remove();
        userNameHolder.remove();
    }
}

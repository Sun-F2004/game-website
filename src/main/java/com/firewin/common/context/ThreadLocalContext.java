package com.firewin.common.context;

public class ThreadLocalContext {

    private static final ThreadLocal<Integer> threadLocal = new ThreadLocal<>();

    //设置当前的用户id
    public static void setCurrentId(Integer id) {
        threadLocal.set(id);
    }

    //获取当前的用户id
    public static Integer getCurrentId() {
        return threadLocal.get();
    }
}

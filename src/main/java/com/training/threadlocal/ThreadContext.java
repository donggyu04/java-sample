package com.training.threadlocal;

public class ThreadContext {

    private static ThreadLocal<Context> userContext = new ThreadLocal<>();

    public static Context getContext() {
        return userContext.get();
    }

    public static void setContext(Context context) {
        userContext.set(context);
    }

}

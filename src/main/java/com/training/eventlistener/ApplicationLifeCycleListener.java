package com.training.eventlistener;

import java.util.EventListener;

public interface ApplicationLifeCycleListener extends EventListener {

    void onStarted();

    void onFinished();
}

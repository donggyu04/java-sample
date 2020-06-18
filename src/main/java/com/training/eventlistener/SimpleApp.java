package com.training.eventlistener;

import static java.lang.Thread.sleep;

public class SimpleApp {

    private ListenerSupport<ApplicationLifeCycleListener> listenerSupport = new ListenerSupport<>();

    public SimpleApp() {
        listenerSupport.add(new ApplicationLifeCycleListener() {
            @Override
            public void onStarted() {
                System.out.println("Application is started!!");
            }

            @Override
            public void onFinished() {
                System.out.println("Application is finidhes!!");
            }
        });

        listenerSupport.add(new ApplicationLifeCycleListener() {
            @Override
            public void onStarted() {
                System.out.println("It is called when application is started");
            }

            @Override
            public void onFinished() {
                System.out.println("It is called when application is finished");
            }
        });
    }

    public void run() throws InterruptedException {
        fireApplicationStartEvent();

        System.out.println("Do something...");
        sleep(1000);
        System.out.println("Do something...");
        sleep(1000);
        System.out.println("Do something...");
        sleep(1000);
        System.out.println("Do something...");
        sleep(1000);

        fileApplicationFinishEvent();
    }

    private void fireApplicationStartEvent() {
        listenerSupport.apply(ApplicationLifeCycleListener::onStarted);
    }

    private void fileApplicationFinishEvent() {
        listenerSupport.apply(new ListenerSupport.Informer<ApplicationLifeCycleListener>() {
            @Override
            public void inform(ApplicationLifeCycleListener listener) {
                listener.onFinished();
            }
        });
    }
}

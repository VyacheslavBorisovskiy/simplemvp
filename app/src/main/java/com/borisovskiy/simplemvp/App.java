package com.borisovskiy.simplemvp;

import android.app.Activity;
import android.app.Application;

import com.borisovskiy.simplemvp.di.component.DaggerMyComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class App extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerMyComponent.builder()
                .application(this)
                .build()
                .inject(this);
    }

    //    @Override
//    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
//        return DaggerMyComponent.builder().application(this).build();
//    }
}

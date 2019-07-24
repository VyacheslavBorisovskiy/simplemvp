package com.borisovskiy.simplemvp;

import com.borisovskiy.simplemvp.di.component.DaggerMyComponent;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class App extends DaggerApplication {

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerMyComponent.builder().application(this).build();
    }
}

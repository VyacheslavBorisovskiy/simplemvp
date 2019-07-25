package com.borisovskiy.simplemvp.di.modules;

import com.borisovskiy.simplemvp.ui.MainActivity;
import com.borisovskiy.simplemvp.ui.MainFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public interface MainActivityModule {

    @ContributesAndroidInjector
    // Сгенерирует Android injector (шприц) для возвращаемого типа (MainActiv)
    // Дагер сможет заинжэктить все зависимости для MainActiv
    abstract MainActivity contributesMainActivity();

    @ContributesAndroidInjector
    abstract MainFragment contributeMainFragment();

}

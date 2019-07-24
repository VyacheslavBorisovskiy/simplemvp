package com.borisovskiy.simplemvp.di.component;

import android.app.Application;

import com.borisovskiy.simplemvp.App;
import com.borisovskiy.simplemvp.di.modules.MainActivityModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by anupamchugh on 06/11/17.
 */

@Singleton
// Компонент - это мостик между модулем и инъекцией. Здесь необх-о подключить модули, чтобы дагер сгенерировал
// класс где автоматически сгенерируется код, который все эти зависимости представит
@Component(modules = {
        AndroidSupportInjectionModule.class, // Встроенный модуль, необх-й чтобы заинжектить DispatchingAndroidInjector
        MainActivityModule.class})
public interface MyComponent extends AndroidInjector<DaggerApplication> {

    void inject(App app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        MyComponent build();
    }
}

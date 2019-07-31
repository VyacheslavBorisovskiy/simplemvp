package com.borisovskiy.simplemvp.di.modules;

import com.borisovskiy.simplemvp.ui.MainFragment;

import dagger.Module;
import dagger.Provides;

@Module
public class FragmentModule {

    @Provides
    public MainFragment getFragment() {
        return new MainFragment();
    }


}

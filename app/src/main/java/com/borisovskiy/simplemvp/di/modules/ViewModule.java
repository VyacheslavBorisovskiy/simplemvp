package com.borisovskiy.simplemvp.di.modules;

import com.borisovskiy.simplemvp.contract.Contract;
import com.borisovskiy.simplemvp.model.QuoteModel;
import com.borisovskiy.simplemvp.presenter.Presenter;
import com.borisovskiy.simplemvp.ui.MainFragment;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class ViewModule {

    @Provides
    public static Contract.IPresenter getPresenter(MainFragment mainFragment, QuoteModel quoteModel) {
        return new Presenter(mainFragment, quoteModel);
    }


}

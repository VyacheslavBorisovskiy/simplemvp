package com.borisovskiy.simplemvp.presenter;

import com.borisovskiy.simplemvp.contract.MainContract;
import com.borisovskiy.simplemvp.contract.MainContract.MainView;
import com.borisovskiy.simplemvp.contract.MainContract.Quote;

public class MainPresenterImpl implements MainContract.MainPresenter {

    private MainView mainView;
    private Quote quote;

    public MainPresenterImpl(MainView mainView, Quote quote) {
        this.mainView = mainView;
        this.quote = quote;
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }
}

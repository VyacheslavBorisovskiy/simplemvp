package com.borisovskiy.simplemvp.presenter;

import com.borisovskiy.simplemvp.contract.MainContract;
import com.borisovskiy.simplemvp.contract.MainContract.Quote;
import com.borisovskiy.simplemvp.contract.MainContract.MainView;

public class MainPresenterImpl implements MainContract.MainPresenter {

    private MainView mainView;
    private Quote quote;

    public MainPresenterImpl(MainView mainView, Quote quote) {
        this.mainView = mainView;
        this.quote = quote;
    }

    @Override
    public void onButtonClick() {
        if (mainView == null) return;
        mainView.setQuote(quote.getQuotes().get(0));
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }
}

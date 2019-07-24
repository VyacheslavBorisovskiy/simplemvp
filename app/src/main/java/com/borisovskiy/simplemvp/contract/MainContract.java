package com.borisovskiy.simplemvp.contract;

import java.util.List;

public interface MainContract {

    interface MainView {
        void setQuote(String string);
    }

    interface Quote {
        List<String> getQuotes();
    }

    interface MainPresenter {
        void onDestroy();
    }
}
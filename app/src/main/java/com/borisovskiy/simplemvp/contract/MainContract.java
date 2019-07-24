package com.borisovskiy.simplemvp.contract;

public interface MainContract {

    interface MainView {
        void setQuote(String string);
    }

    interface Quote {
        void getNextQuote(OnSetListener listener);

        interface OnSetListener {
            void onSet(String string);
        }
    }

    interface MainPresenter {
        void onButtonClick();

        void onDestroy();
    }
}
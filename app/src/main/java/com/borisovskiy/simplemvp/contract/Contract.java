package com.borisovskiy.simplemvp.contract;

import java.util.List;

public interface Contract {

    interface IView {
        void setData(List<String> items);
    }

    interface IQuoteModel {
        List<String> getItems();
    }

    interface IPresenter {
        void onAttachUI();

//        void onDetachUI();
    }
}
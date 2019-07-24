package com.borisovskiy.simplemvp.presenter;

import com.borisovskiy.simplemvp.contract.Contract;
import com.borisovskiy.simplemvp.contract.Contract.IQuoteModel;

public class Presenter implements Contract.IPresenter {

    private IQuoteModel model;
    private Contract.IView view;

    public Presenter(IQuoteModel model, Contract.IView view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onAttachUI() {
        view.setData(model.getItems());
    }
}

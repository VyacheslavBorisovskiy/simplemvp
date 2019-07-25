package com.borisovskiy.simplemvp.presenter;

import com.borisovskiy.simplemvp.contract.Contract;
import com.borisovskiy.simplemvp.contract.Contract.IQuoteModel;

public class Presenter implements Contract.IPresenter {

    private IQuoteModel model;
    private Contract.IView view;

    public Presenter(Contract.IView view, IQuoteModel model) {
        this.view = view;
        this.model = model;
    }

    @Override
    public void onAttachUI() {
        view.setData(model.getItems());
    }

    @Override
    public void onDetachUI() {
        view = null;
    }
}

package com.borisovskiy.simplemvp.presenter;

import com.borisovskiy.simplemvp.contract.Contract;
import com.borisovskiy.simplemvp.contract.Contract.IQuoteModel;

public class Presenter implements Contract.IPresenter {

    private IQuoteModel model;

    public Presenter(IQuoteModel model) {
        this.model = model;
    }

    @Override
    public void onAttachUI(Contract.IView view) {
        view.setData(model.getItems());
    }
}

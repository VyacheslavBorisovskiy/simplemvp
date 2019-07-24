package com.borisovskiy.simplemvp.presenter;

import com.borisovskiy.simplemvp.contract.Contract;
import com.borisovskiy.simplemvp.contract.Contract.IQuoteModel;
import com.borisovskiy.simplemvp.contract.Contract.IView;

public class Presenter implements Contract.IPresenter {

    private IView view;
    private IQuoteModel model;

    public Presenter(IView view, IQuoteModel model) {
        this.model = model;
        this.view = view;
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

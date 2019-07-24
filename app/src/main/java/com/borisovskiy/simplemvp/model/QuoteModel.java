package com.borisovskiy.simplemvp.model;

import com.borisovskiy.simplemvp.contract.Contract;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

public class QuoteModel implements Contract.IQuoteModel {

    private List<String> quotes = Arrays.asList(
            "Life is what happens when you’re busy making other plans.",
            "Get busy living or get busy dying.",
            "The only impossible journey is the one you never begin."
    );

    @Inject // Эта Аннотация - аналог создания модуля и провайдера
    public QuoteModel() {

    }

    @Override
    public List<String> getItems() {
        return quotes;
    }
}
package com.borisovskiy.simplemvp.model;

import com.borisovskiy.simplemvp.contract.MainContract;

import java.util.Arrays;
import java.util.List;

public class QuoteImpl implements MainContract.Quote {

    private List<String> quotes = Arrays.asList(
            "Life is what happens when you’re busy making other plans.",
            "Get busy living or get busy dying.",
            "The only impossible journey is the one you never begin."
    );

    @Override
    public List<String> getQuotes() {
        return quotes;
    }

    
}
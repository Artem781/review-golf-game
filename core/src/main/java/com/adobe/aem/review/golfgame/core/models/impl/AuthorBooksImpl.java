package com.adobe.aem.review.golfgame.core.models.impl;

import com.adobe.cq.sightly.WCMUsePojo;

import java.util.ArrayList;
import java.util.List;

public class AuthorBooksImpl extends WCMUsePojo {
    public String getHeadline1() {
        return headline1;
    }

    private String headline1;

    private List<String> books;



    public List<String> getBooks() {
        return books;
    }

    @Override
    public void activate() throws Exception {
        this.headline1 = "headline1 test";
        this.books = new ArrayList<String>();
        books.add("two");
        books.add("three");
    }
}

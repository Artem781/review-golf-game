package com.adobe.aem.review.golfgame.core.models;

import java.util.*;
import java.util.Iterator;

import com.day.cq.wcm.api.Page;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import javax.inject.Inject;


@Model(adaptables = SlingHttpServletRequest.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TopNav {
    final private String defaultValueThree = "3";

    @ValueMapValue
    @Default(values = defaultValueThree)
    private String deepLevel;

    private List<Page> items = new ArrayList<>();

    private Page rootPage;



    @Inject
    private Page currentPage;

    @PostConstruct
    protected void init() {
        if (currentPage == null) {
            return;
        }
        rootPage = currentPage.getAbsoluteParent(Integer.parseInt(deepLevel));
        if (rootPage == null) {
            rootPage = currentPage;
        }
        Iterator<Page> childPages = rootPage.listChildren();
        childPages.forEachRemaining((page) -> items.add(page));
    }

    public String getDeepLevel() {
        return deepLevel;
    }

    public Page getRootPage() {
        return rootPage;
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    // Returns the navigation items
    public List<Page> getItems() {
        return items;
    }

    // Returns the navigation root
    public Page getRoot() {
        return rootPage;
    }
}
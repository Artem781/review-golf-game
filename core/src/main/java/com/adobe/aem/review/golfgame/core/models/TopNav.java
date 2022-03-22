package com.adobe.aem.review.golfgame.core.models;

import java.util.*;
import java.util.Iterator;

import com.day.cq.wcm.api.Page;


import org.apache.commons.lang.StringUtils;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.eclipse.jetty.util.StringUtil;

import javax.annotation.PostConstruct;
import javax.inject.Inject;


@Model(adaptables = SlingHttpServletRequest.class,
        defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class TopNav {
    @ValueMapValue
    private String deepLevel = "3";

    private List<Page> items = new ArrayList<>();

    private Page rootPage;
    @Inject
    private Page currentPage;

    @ValueMapValue
    private String title;

    @ValueMapValue
    private String text;

    private String message;


    @PostConstruct
    protected void init() {

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

    public String getTitle() {

        return StringUtils.isNotBlank(title) ? title : "Default value here!";
    }

    public String getText() {
        return StringUtils.isNotBlank(text) ? text.toUpperCase() : null;
    }

    public String getMessage() {
        return message;
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
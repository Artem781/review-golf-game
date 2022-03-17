package com.adobe.aem.review.golfgame.core.models;

import java.util.*;
import java.util.Iterator;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageFilter;

import com.adobe.cq.sightly.WCMUsePojo;


import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.*;
import org.apache.sling.models.annotations.injectorspecific.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.*;


@Model(adaptables = SlingHttpServletRequest.class)
public class TopNav {

    private List<Page> items = new ArrayList<>();

    private Page rootPage;
    @Inject
    private Page currentPage;

    @PostConstruct
    protected void init() {
        rootPage = currentPage.getAbsoluteParent(3);
        if (rootPage == null) {
            rootPage = currentPage;
        }
        Iterator<Page> childPages = rootPage.listChildren();
        childPages.forEachRemaining((rootPage) -> items.add(rootPage));
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
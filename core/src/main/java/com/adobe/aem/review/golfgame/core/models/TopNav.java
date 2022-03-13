package com.adobe.aem.review.golfgame.core.models;

import java.util.*;
import java.util.Iterator;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageFilter;

import com.adobe.cq.sightly.WCMUsePojo;

public class TopNav extends WCMUsePojo {
    private List<Page> items = new ArrayList<Page>();
    private Page rootPage;

    // Initializes the navigation
    @Override
    public void activate() throws Exception {
        rootPage = getCurrentPage().getAbsoluteParent(3);
        if (rootPage == null) {
            rootPage = getCurrentPage();
        }
        Iterator<Page> childPages = rootPage.listChildren(new PageFilter(getRequest()));
        while (childPages.hasNext()) {
            items.add(childPages.next());
        }
        Page p = getCurrentPage();
        List<Page> pageChildren = getPageChildren(p, 2);
        pageChildren.clear();
    }

    public List<Page> getPageChildren(Page currentPage, int rootLevel) {

        List<Page> children = new ArrayList<>();
        Page rootPage = currentPage.getAbsoluteParent(rootLevel);
        if (rootPage != null) {
            Iterator<Page> iteratorChildren = rootPage.listChildren();
            while (iteratorChildren.hasNext()) {
                Page child = iteratorChildren.next();
                if (!child.isHideInNav()) {
                    children.add(child);
                }
            }
        }
        return children;
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
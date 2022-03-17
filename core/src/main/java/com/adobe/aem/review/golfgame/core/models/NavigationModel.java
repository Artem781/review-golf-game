package com.adobe.aem.review.golfgame.core.models;

import com.adobe.aem.review.golfgame.core.models.impl.SomeBean;
import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageFilter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NavigationModel extends WCMUsePojo {
    private String headline;
    private String description;
    private String otherDescription;

    private List<Page> items = new ArrayList<Page>();
    private Page rootPage;

    private List<String> listString;
    private ArrayList<SomeBean> someBeanList;
    private ArrayList<Integer> list;

    public List<String> getListString() {
        return listString;
    }

    public ArrayList<Integer> getList() {
        return list;
    }

    public List<Page> getItems() {
        return items;
    }

    public Page getRootPage() {
        return rootPage;
    }


    @Override
    public void activate() throws Exception {
        this.headline = "headline test hello";
        this.description = "description test hello";
        this.otherDescription = "otherDescription test hello";

        list = new ArrayList<>();
        list.add(51);
        list.add(136);
        list.add(387);

        listString = new ArrayList<>();
        listString.add("one");
        listString.add("two");
        listString.add("three");

        someBeanList = new ArrayList<>();
        someBeanList.add(new SomeBean("someBeanFirst"));
        someBeanList.add(new SomeBean("someBeanSecond"));




        rootPage = getCurrentPage().getAbsoluteParent(3);
        if (rootPage == null) {
            rootPage = getCurrentPage();
        }
        Iterator<Page> childPages = rootPage.listChildren(new PageFilter(getRequest()));
        while (childPages.hasNext()) {
            items.add(childPages.next());
        }


        childPages.forEachRemaining((rootPage) -> items.add(rootPage));



    }

    public List<Page> getPageChildren(Page currentPage, int rootLevel) {
 // (Type element : nameList)
 // items - list of pages
 // rootPage - root page



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



    public ArrayList<SomeBean> getSomeBeanList() {
        return someBeanList;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public String getHeadline() {
        return headline;
    }

    public String getDescription() {
        return description;
    }
}
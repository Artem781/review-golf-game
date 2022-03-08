package com.adobe.aem.review.golfgame.core.models;

import com.adobe.cq.sightly.WCMUsePojo;

public class NavigationModel extends WCMUsePojo {
    private String headline;
    private String description;

    @Override
    public void activate() throws Exception {
        this.headline = "headline test hello";
        this.description = "description test hello";
    }

    public String getHeadline() {
        return headline;
    }

    public String getDescription() {
        return description;
    }
}
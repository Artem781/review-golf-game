package apps.golfgame.components.golfgamehomepage;

import com.adobe.cq.sightly.WCMUsePojo;
import com.day.cq.wcm.api.Page;

import java.util.ArrayList;
import java.util.List;

public class GolfGameHomePage extends WCMUsePojo {
    private String lowerCaseTitle;
    private String lowerCaseDescription;
    private String reverseText;
    private List<Page> items = new ArrayList<Page>();
    private Page rootPage;

    @Override
    public void activate() throws Exception {


    }

    public List<Page> getItems() {
        return items;
    }

    public Page getRootPage() {
        return rootPage;
    }

    public String getLowerCaseTitle() {
        return lowerCaseTitle;
    }

    public String getLowerCaseDescription() {
        return lowerCaseDescription;
    }

    public String getReverseText() {
        return reverseText;
    }
}

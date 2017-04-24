package utils;

import org.fluentlenium.core.FluentPage;

import java.util.concurrent.TimeUnit;

public class NavigationHelper extends FluentPage {


    public void isAtHomePage() {
        System.out.println("Loading home page");
        await().atMost(30, TimeUnit.SECONDS).until("[id='logo']").isDisplayed();
    }

    public void isAtSearchResultsPage() {
        await().atMost(30, TimeUnit.SECONDS).until(".number-of-search-results-and-search-terms").isDisplayed();
    }

    public void isAtAdvanceSearchPage() {
        await().atMost(30, TimeUnit.SECONDS).until("[id='advanced-search']").isDisplayed();
    }

}



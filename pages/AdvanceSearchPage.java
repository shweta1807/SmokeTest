package pages;


import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import utils.NavigationHelper;

import java.util.concurrent.TimeUnit;

public class AdvanceSearchPage extends NavigationHelper {

    @FindBy(css = "button.pillow-btn.open-search-options")
    private FluentWebElement advanceSearchOption;

    @FindBy(css = "[id='advanced-search-link']")
    private FluentWebElement advanceSearchButton;

    @FindBy(css = "#submit-advanced-search")
    private FluentWebElement advanceSearchSubmit;

    @FindBy(css ="input[name='all-words']")
    private FluentWebElement allWords;

    @FindBy(css ="input[name='exact-phrase']")
    private FluentWebElement exactPhrase;

    @FindBy(css = "input[name='least-words']")
    private FluentWebElement leastWords;

    @FindBy(css = "input[name='without-words']")
    private FluentWebElement withoutWords;


    public void advanceSearch() {
        searchFromAdvanceSearch();
        isAtAdvanceSearchPage();
        System.out.println("looking for searnig now ....lets see ");
    }

    protected void searchFromAdvanceSearch() {
        advanceSearchOption.click();
        advanceSearchButton.click();
        System.out.println("Searching for ");
    }

    public void fillAdvanceSearch() {
        System.out.println("Filling Advance Search information");
        await().atMost(30, TimeUnit.SECONDS).until(advanceSearchSubmit).isDisplayed();
        fill(allWords).with("COMPUTER");
        fill(exactPhrase).with("ARTIFICAL INTELLIGENCE");
        fill(leastWords).with("INTELLIGENCE");
        fill(withoutWords).with("NUREAL NETWORKS");
        System.out.println("Filled Advance Search information");
        advanceSearchSubmit.click();
        System.out.println("clicked Advance Search Submit");
        isAtSearchResultsPage();
        System.out.println("on search result page");

    }


}
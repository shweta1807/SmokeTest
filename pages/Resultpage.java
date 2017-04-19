package pages;


import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.NavigationHelper;

import java.util.concurrent.TimeUnit;

public class Resultpage extends NavigationHelper {


    @FindBy(xpath = ".//*[@id='content-type-facet']/ol/li[5]/a/span[2]")
    private FluentWebElement searchByBook;

    @FindBy(css = "#sort-results")
    private FluentWebElement sortBy;

    @FindBy(css = "#no-results-message")
    private FluentWebElement noResultMessage;

    public void refineSearcResultBy() {
        System.out.println("Refining search results");
        searchByBook.click();
    }


    public void sortSearchBy() {
        System.out.println("Sorting search results");
        await().atMost(15, TimeUnit.SECONDS).until(sortBy).isDisplayed();
        Select state = new Select(sortBy.getElement());
        state.selectByVisibleText("Newest First");
    }

    public void validatMessage() {
        System.out.println("validating search result message");
        isAtSearchResultsPage();
        assert (noResultMessage.getText()).contains("Sorry");
    }
}
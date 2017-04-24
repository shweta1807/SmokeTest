package pages;


import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utils.NavigationHelper;

import java.util.concurrent.TimeUnit;

public class Resultpage extends NavigationHelper {


    @FindBy(xpath = ".//*[@id='content-type-facet']/ol/li[5]/a/span[2]")
    private FluentWebElement searchByContent;

    @FindBy(css = "#sort-results")
    private FluentWebElement sortBy;

    @FindBy(css = "#no-results-message")
    private FluentWebElement noResultMessage;

    @FindBy(css= ".facet-constraint-message")
    private FluentWebElement resultConstraintMessage;


    public void refineSearcResultBy() {
        System.out.println("Refining search results by Content");
        searchByContent.click();
    }

    public void sortSearchBy() {
        System.out.println("Sorting search results by oldest first");
        await().atMost(15, TimeUnit.SECONDS).until(sortBy).isDisplayed();
        Select state = new Select(sortBy.getElement());
        state.selectByVisibleText("Oldest First");
    }

    public void validatMessage() {
        System.out.println("validating search result message");
        isAtSearchResultsPage();
        assert (noResultMessage.getText()).contains("Sorry");
    }

    public void validateResult() {
        System.out.println("validating search result ");
        isAtSearchResultsPage();
        assert (resultConstraintMessage.getText()).contains("Book") ;
    }


}
package pages;

import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import utils.NavigationHelper;

@PageUrl("/")
public class HomePage extends NavigationHelper {

    private final long MODAL_MAX_WAIT = 8000;
    private final String GENERIC_MODAL_SELECTOR = "#generic-modal";
    private final String GENERIC_MODAL_IFRAME_SELECTOR = "#generic-modal iframe";

    @FindBy(css = "[data-qa-id='logo']")
    private FluentWebElement bannerLogo;

    @FindBy(css = "[id='query']")
    private FluentWebElement searchField;

    @FindBy(css = "[id='search']")
    private FluentWebElement searchButton;

    @FindBy(css = "#close-button")
    private FluentWebElement closeModalButton;

    public void openHomePage() {
        goTo("/");
        isAtHomePage();
    }

    public void goToSearch(String productCode) {
        search(productCode);
        isAtSearchResultsPage();
    }

    public void goToDiscipline() {
        searchDiscipline();
        isAtSearchResultsPage();
    }

    protected void search(String keyWord) {
        fill(searchField).with(keyWord);
        searchButton.click();
        System.out.println("Searching for " + keyWord);
    }

    protected void searchDiscipline() {
       // fill(searchField).with(keyWord);
        searchButton.click();
        System.out.println("Searching for " );
    }
}


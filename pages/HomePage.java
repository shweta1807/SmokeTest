package pages;

import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import utils.NavigationHelper;

@PageUrl("/")
public class HomePage extends NavigationHelper {

    @Page
    private AdvanceSearchPage advanceSearchPage;

    @FindBy(css = "[data-qa-id='logo']")
    private FluentWebElement bannerLogo;

    @FindBy(css = "[id='query']")
    private FluentWebElement searchField;

    @FindBy(css = "[id='search']")
    private FluentWebElement searchButton;

    @FindBy(css = "#close-button")
    private FluentWebElement closeModalButton;

    @FindBy(xpath= ".//a[contains(text(),'Astronomy')]")
    private FluentWebElement Discipline;


    public void openHomePage() {
        goTo("/");
        isAtHomePage();
    }

    public void goToSearch(String searchCode) {
        search(searchCode);
        isAtSearchResultsPage();
    }

    public void goToDiscipline() {
        searchByDiscipline();
        isAtSearchResultsPage();
    }

    protected void search(String keyWord) {
        fill(searchField).with(keyWord);
        searchButton.click();
        System.out.println("Searching for " + keyWord);
    }

    protected void searchByDiscipline() {
        Discipline.click();
        System.out.println("Searching by Discipline Astronomy " );
    }

    public AdvanceSearchPage getadvanceSearchPage() {
        return advanceSearchPage;
    }
}



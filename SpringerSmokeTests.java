import org.junit.Before;
import org.junit.Test;
import utils.Data;


public class SpringerSmokeTests extends PageInstances {

    @Before
    public void beforeTest() {
        maximizeWindow();
        homePage.openHomePage();
    }

    @Test
    public void searchFromHomePageSearchTextBox() {
        System.out.println("starting test");
        homePage.goToSearch(Data.REGULAR_SEARCH);
        resultPage.refineSearcResultBy();
        resultPage.sortSearchBy();
        resultPage.validateResult();

    }

   @Test
    public void noSearchResultForsearchFromHomePageSearchTextBox() {
        System.out.println("starting test");
        homePage.goToSearch(Data.INVALID_SEARCH);
        resultPage.validatMessage();
    }

   @Test
    public void searchFromHomePageByDiscipline() {
        System.out.println("starting test");
        homePage.goToDiscipline();
       resultPage.refineSearcResultBy();
       resultPage.sortSearchBy();

    }

    @Test
    public void advanceSearchFromHomePage() {
        System.out.println("starting test");
        homePage.getadvanceSearchPage();
        advanceSearchPage.advanceSearch();
        advanceSearchPage.fillAdvanceSearch();
        resultPage.isAtSearchResultsPage();
    }


}

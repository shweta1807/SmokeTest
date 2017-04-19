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
        ////div[@id='Discipline']/ol/li[2]/a
        homePage.goToSearch(Data.REGULAR_SEARCH);
        resultPage.refineSearcResultBy();
        resultPage.sortSearchBy();
    }


//    Readme files :-
//    Command to run .
//            Envirnment configurations


}

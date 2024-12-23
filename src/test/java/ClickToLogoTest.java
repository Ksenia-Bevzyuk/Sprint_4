import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.scooter.model.LandingPage;
import ru.yandex.scooter.model.WhoForForm;

import static org.junit.Assert.assertTrue;

//параметризованный тест клика логотипов
@RunWith(Parameterized.class)
public class ClickToLogoTest extends StartQuitBrowser {
    //необходимые параметры
    private final String logo;
    private final String finalPage;

    //конструктор с параметрами
    public ClickToLogoTest(String logo, String finalPage) {
        this.logo = logo;
        this.finalPage = finalPage;
    }

    //двумерный массив с параметрами для тестов
    @Parameterized.Parameters
    public static Object[][] getDataToClick() {
        return new Object[][]{
                {"Яндекс", "yaSearch"},
                {"Самокат", "scooterLanding"},
        };
    }

    @Test
    public void ClickToLogo() {
//создали объект страницы лендинга
        LandingPage objLandingPage = new LandingPage(driver);
//вызвали метод клика на лого
        objLandingPage.open();
        // objLandingPage.clickOrderButton(HEADER_ORDER_BUTTON);
//создали объект страницы с формой "Для кого самокат"
        WhoForForm objWhoForForm = new WhoForForm(driver);
//вызвали метод клика на лого
        objWhoForForm.clickToLogo(logo);
        assertTrue(objWhoForForm.transitionFinalPageIsDisplayed(finalPage));
    }
}

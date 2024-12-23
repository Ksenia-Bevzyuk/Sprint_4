import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.scooter.LandingPage;
import ru.yandex.scooter.model.order.WhoForForm;

import java.time.Duration;

import static org.junit.Assert.assertTrue;
import static ru.yandex.scooter.LandingPage.HEADER_ORDER_BUTTON;
import static ru.yandex.scooter.model.order.WhoForForm.SCOOTER_YA;
import static ru.yandex.scooter.model.order.WhoForForm.YA_RU;

//параметризованный тест клика логотипов
@RunWith(Parameterized.class)
public class ClickToLogoTest extends StartQuitBrowser {
    //необходимые параметры
    private final By logoToClick;
    private final By transitionCompleted;

    //конструктор с параметрами
    public ClickToLogoTest(By logo, By transitionCompleted) {
        this.logoToClick = logo;
        this.transitionCompleted = transitionCompleted;
    }

    //двумерный массив с параметрами для тестов
    @Parameterized.Parameters
    public static Object[][] getDataToClick() {
        return new Object[][]{
                {WhoForForm.getYaLogo(), YA_RU},
                {WhoForForm.getScooterLogo(), SCOOTER_YA},
        };
    }

    //выполняем перед каждым тестом
    @Before
    @Override
    public void start() {
        super.start();
    }

    @Test
    public void ClickToLogo() {
//создали объект страницы лендинга
        LandingPage objLandingPage = new LandingPage(driver);
//вызвали метод клика на лого
        objLandingPage.open();
        objLandingPage.clickOrderButton(HEADER_ORDER_BUTTON);
//создали объект страницы с формой "Для кого самокат"
        WhoForForm objWhoForForm = new WhoForForm(driver);
//вызвали метод клика на лого
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(logoToClick));

        objWhoForForm.clickToLogo(logoToClick);
        WebElement isTransition =
                new WebDriverWait(driver, Duration.ofSeconds(5))
                        .until(ExpectedConditions.visibilityOfElementLocated(transitionCompleted));

        assertTrue(isTransition.isDisplayed());
    }

    //закрываем браузер после каждого теста
    @After
    @Override
    public void quit() {

        super.quit();
    }
}

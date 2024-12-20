import model.Yandex_Scooter.LandingPage;
import model.Yandex_Scooter.OrderForm.WhoForForm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constanceTest.OrderButton.HEADER_ORDER_BUTTON;
import static model.Yandex_Scooter.constanceModel.WhoFor.SCOOTER_LOGO;
import static model.Yandex_Scooter.constanceModel.WhoFor.YA_LOGO;
import static org.junit.Assert.assertTrue;

//параметризованный тест клика логотипов
@RunWith(Parameterized.class)
public class ClickToLogoTest {
//локатор на странице Яндекс
    public static final By YA_RU = By.className("Header_Header__214zg");
//локатор картинки Самокат
    public static final By SCOOTER_YA = By.className("Home_Header__iJKdX");

    //необходимые параметры
    private final By logoToClick;
    private final By TransitionCompleted;

    private WebDriver driver;
//конструктор с параметрами
    public ClickToLogoTest(By logo, By TransitionCompleted) {
        this.logoToClick = logo;
        this.TransitionCompleted = TransitionCompleted;
    }
//двумерный массив с параметрами для тестов
    @Parameterized.Parameters
    public static Object [][] getDataToClick() {
        return new Object[][]{
                {YA_LOGO, YA_RU},
                {SCOOTER_LOGO, SCOOTER_YA},
        };
    }
//выполняем перед каждым тестом
    @Before
    public void start() {
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();
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
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(logoToClick));
        objWhoForForm.clickToLogo(logoToClick);
        WebElement isTransition = new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(TransitionCompleted));

        assertTrue(isTransition.isDisplayed());
    }
//закрываем браузер после каждого теста
    @After
    public void quit() {

        driver.quit();
    }
}

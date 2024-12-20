import model.Yandex_Scooter.LandingPage;
import model.Yandex_Scooter.OrderForm.AboutRentForm;
import model.Yandex_Scooter.OrderForm.WhoForForm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import static constanceTest.DataSetForPositiveOrder.*;
import static constanceTest.OrderButton.HEADER_ORDER_BUTTON;
import static constanceTest.OrderButton.MIDDLE_ORDER_BUTTON;
import static org.junit.Assert.assertEquals;

//параметризованный тест позитивного сценария заказа самоката
@RunWith(Parameterized.class)
public class OrderScooterPositiveTest {
//необходимые параметры
    private final By orderButtonLanding;
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String date;
    private final String comment;
    private final boolean isGoToPopupOrderSuccess;

    private WebDriver driver;
//конструктор с параметрами
    public OrderScooterPositiveTest(By orderButtonLanding, String name, String surname, String address, String phone, String date, String comment, boolean isGoToPopupOrderSuccess) {
        this.orderButtonLanding = orderButtonLanding;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.comment = comment;
        this.isGoToPopupOrderSuccess = isGoToPopupOrderSuccess;
    }
//двумерный массив с параметрами для тестов
    @Parameterized.Parameters
    public static Object [][] getSuccessOrder() {
        return new Object[][]{
                {HEADER_ORDER_BUTTON, NAME_SET_1, SURNAME_SET_1, ADDRESS_SET_1, PHONE_SET_1, DATE_SET_1, COMMENT_SET_1, true},
                {HEADER_ORDER_BUTTON, NAME_SET_2, SURNAME_SET_2, ADDRESS_SET_2, PHONE_SET_2, DATE_SET_2, COMMENT_SET_2, true},
                {MIDDLE_ORDER_BUTTON, NAME_SET_1, SURNAME_SET_1, ADDRESS_SET_1, PHONE_SET_1, DATE_SET_1, COMMENT_SET_1, true},
                {MIDDLE_ORDER_BUTTON, NAME_SET_2, SURNAME_SET_2, ADDRESS_SET_2, PHONE_SET_2, DATE_SET_2, COMMENT_SET_2, true},
        };
    }
//выполняем перед каждым тестом
    @Before
    public void start() {
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
    }

    @Test
    public void orderScooterPositiveTest() {
//создали объект страницы лендинга
        LandingPage objLandingPage = new LandingPage(driver);
//вызвали методы
        objLandingPage.open();
        objLandingPage.clickOrderButton(orderButtonLanding);
//создали объект страницы с формой "Для кого самокат"
        WhoForForm objWhoForFormForm = new WhoForForm(driver);
//вызвали методы
        objWhoForFormForm.waitForWhoForFormDisplayed();
        objWhoForFormForm.setWhoForForm(name, surname, address, phone);
//создали объект страницы с формой "Про аренду"
        AboutRentForm objAboutRentForm = new AboutRentForm(driver);
//вызвали методы
        objAboutRentForm.waitForAboutRentFormDisplayed();
        objAboutRentForm.setAboutRentForm(date, comment);
//сравнили ожидаемый результат теста с фактическим
        assertEquals(isGoToPopupOrderSuccess, objAboutRentForm.isVisiblePopupSuccessOrder());
    }
//закрываем браузер после каждого теста
    @After
    public void quit() {

        driver.quit();
    }
}
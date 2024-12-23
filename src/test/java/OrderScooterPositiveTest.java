import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.yandex.scooter.LandingPage;
import ru.yandex.scooter.model.order.AboutRentForm;
import ru.yandex.scooter.model.order.WhoForForm;

import static org.junit.Assert.assertEquals;
import static ru.yandex.scooter.LandingPage.HEADER_ORDER_BUTTON;
import static ru.yandex.scooter.LandingPage.MIDDLE_ORDER_BUTTON;
import static ru.yandex.scooter.model.order.AboutRentForm.*;
import static ru.yandex.scooter.model.order.WhoForForm.*;

//параметризованный тест позитивного сценария заказа самоката
@RunWith(Parameterized.class)
public class OrderScooterPositiveTest extends StartQuitBrowser {
    //необходимые параметры
    private final By orderButtonLanding;
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String date;
    private final By days;
    private final String comment;
    private final boolean isGoToPopupOrderSuccess;

    //конструктор с параметрами
    public OrderScooterPositiveTest(By orderButtonLanding, String name, String surname,
                                    String address, String phone, String date, By days,
                                    String comment, boolean isGoToPopupOrderSuccess) {
        this.orderButtonLanding = orderButtonLanding;
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.date = date;
        this.days = days;
        this.comment = comment;
        this.isGoToPopupOrderSuccess = isGoToPopupOrderSuccess;
    }

    //двумерный массив с параметрами для тестов
    @Parameterized.Parameters
    public static Object[][] getSuccessOrder() {
        return new Object[][]{
                {HEADER_ORDER_BUTTON, NAME_SET_FIRST, SURNAME_SET_FIRST, ADDRESS_SET_FIRST,
                        PHONE_SET_FIRST, DATE_SET_FIRST, DAYS_SET_FIRST, COMMENT_SET_FIRST, true},
                {HEADER_ORDER_BUTTON, NAME_SET_SECOND, SURNAME_SET_SECOND, ADDRESS_SET_SECOND,
                        PHONE_SET_SECOND, DATE_SET_SECOND, DAYS_SET_SECOND, COMMENT_SET_SECOND, true},
                {MIDDLE_ORDER_BUTTON, NAME_SET_FIRST, SURNAME_SET_FIRST, ADDRESS_SET_FIRST,
                        PHONE_SET_FIRST, DATE_SET_FIRST, DAYS_SET_FIRST, COMMENT_SET_FIRST, true},
                {MIDDLE_ORDER_BUTTON, NAME_SET_SECOND, SURNAME_SET_SECOND, ADDRESS_SET_SECOND,
                        PHONE_SET_SECOND, DATE_SET_SECOND, DAYS_SET_SECOND, COMMENT_SET_SECOND, true},
        };
    }

    //выполняем перед каждым тестом
    @Before
    @Override
    public void start() {
        super.start();
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
        objAboutRentForm.setAboutRentForm(date, days, comment);
//сравнили ожидаемый результат теста с фактическим
        assertEquals(isGoToPopupOrderSuccess, objAboutRentForm.isVisiblePopupSuccessOrder());
    }

    //закрываем браузер после каждого теста
    @After
    @Override
    public void quit() {

        super.quit();
    }
}
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.scooter.model.AboutRentForm;
import ru.yandex.scooter.model.LandingPage;
import ru.yandex.scooter.model.WhoForForm;

import static org.junit.Assert.assertEquals;

//параметризованный тест позитивного сценария заказа самоката
@RunWith(Parameterized.class)
public class OrderScooterPositiveTest extends StartQuitBrowser {
    //необходимые параметры
    private final String orderButton;
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String date;
    private final String comment;
    private final boolean isGoToPopupOrderSuccess;

    //конструктор с параметрами
    public OrderScooterPositiveTest(String orderButton, String name, String surname,
                                    String address, String phone, String date,
                                    String comment, boolean isGoToPopupOrderSuccess) {
        this.orderButton = orderButton;
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
    public static Object[][] getSuccessOrder() {
        return new Object[][]{
                {"Заголовок", "Ирина", "Александринтова", "Жуж 1", "89012345678", "30.12.2024", "Не звонить", true},
                {"Заголовок", "Иван Иван", "Ан", "площадь Абельмановская Застава, д. 1, к. 2, кв. 3",
                        "+71234567893", "25.02.2025", "", true},
                {"Тело", "Ирина", "Александринтова", "Жуж 1", "89012345678", "30.12.2024", "Не звонить", true},
                {"Тело", "Иван Иван", "Ан", "площадь Абельмановская Застава, д. 1, к. 2, кв. 3",
                        "+71234567893", "25.02.2025", "", true},
        };
    }

    @Test
    public void orderScooterPositiveTest() {
//создали объект страницы лендинга
        LandingPage objLandingPage = new LandingPage(driver);
//вызвали методы
        objLandingPage.open();
        objLandingPage.clickOrderButton(orderButton);
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
}
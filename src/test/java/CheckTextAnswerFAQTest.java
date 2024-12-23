import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.yandex.scooter.LandingPage;

import static org.junit.Assert.assertEquals;
import static ru.yandex.scooter.LandingPage.*;
import static ru.yandex.scooter.model.Constance_Answer_Text.*;

//параметризованный тест проверки ответов на вопросы
@RunWith(Parameterized.class)
public class CheckTextAnswerFAQTest extends StartQuitBrowser {
    //необходимые параметры
    private final By question;
    private final By answerToQuestion;
    private final String requiredAnswerText;

    //конструктор с параметрами
    public CheckTextAnswerFAQTest(By question, By answerToQuestion, String requiredAnswerText) {
        this.question = question;
        this.answerToQuestion = answerToQuestion;
        this.requiredAnswerText = requiredAnswerText;
    }

    //двумерный массив с параметрами для тестов
    @Parameterized.Parameters
    public static Object[][] getFAQ() {
        return new Object[][]{
                {HOW_MUCH_AND_HOW_TO_PAY,
                        DAY_400_PAYMENT_COURIER_CASH_OR_CARD,
                        REQUIRED_TEXT_DAY_400_PAYMENT_COURIER_CASH_OR_CARD},
                {WANT_SOME,
                        ONE_ORDER_ONE_SCOOTER_CAN_MAKE_SEVERAL_ORDERS,
                        REQUIRED_TEXT_ONE_ORDER_ONE_SCOOTER},
                {CALCULATION_RENTAL_TIME,
                        RENTAL_PERIOD_24_HOURS_FROM_PAYMENT,
                        REQUIRED_TEXT_24_HOURS_FROM_PAYMENT},
                {ORDER_FOR_TODAY,
                        ONLY_FROM_TOMORROW,
                        REQUIRED_TEXT_ONLY_FROM_TOMORROW},
                {RENEWAL_OR_RETURN_EARLIER,
                        NO_SUPPORT_SERVICE_1010,
                        REQUIRED_TEXT_NO_SUPPORT_SERVICE_1010},
                {CHARGER,
                        FULL_CHARGE,
                        REQUIRED_TEXT_FULL_CHARGE},
                {CANCELLATION,
                        YES_UNTIL_WAS_DELIVERED,
                        REQUIRED_TEXT_YES_UNTIL_WAS_DELIVERED},
                {DELIVERY_OUTSIDE_THE_MKAD,
                        YES,
                        REQUIRED_TEXT_YES},
        };
    }

    //выполняем перед каждым тестом
    @Before
    @Override
    public void start() {

        super.start();
    }

    @Test
    public void checkTextAnswerFAQTest() {
//создали объект страницы лендинга
        LandingPage objLandingPage = new LandingPage(driver);
//вызвали методы
        objLandingPage.open();

//сравнили текст ответа, полученного со страницы с текстом константы
        assertEquals(requiredAnswerText, objLandingPage.checkTextAnswerFAQ(question, answerToQuestion));
    }

    //после каждого теста закрыли браузер
    @After
    @Override
    public void quit() {

        super.quit();
    }
}
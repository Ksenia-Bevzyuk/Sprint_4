import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.scooter.model.LandingPage;

import static org.junit.Assert.assertEquals;
import static ru.yandex.scooter.model.Constance_FAQ_Text.*;

//параметризованный тест проверки ответов на вопросы
@RunWith(Parameterized.class)
public class CheckTextAnswerFAQTest extends StartQuitBrowser {
    //необходимые параметры
    private final String question;
    private final int index;
    private final String answerToQuestion;

    //конструктор с параметрами
    public CheckTextAnswerFAQTest(String question, int index, String answerToQuestion) {
        this.question = question;
        this.index = index;
        this.answerToQuestion = answerToQuestion;
    }

    //двумерный массив с параметрами для тестов
    @Parameterized.Parameters
    public static Object[][] getFAQ() {
        return new Object[][]{
                {HOW_MUCH_AND_HOW_TO_PAY_Q_TEXT, 0, REQUIRED_TEXT_DAY_400_PAYMENT_COURIER_CASH_OR_CARD},
                {WANT_SOME_Q_TEXT, 1, REQUIRED_TEXT_ONE_ORDER_ONE_SCOOTER},
                {CALCULATION_RENTAL_TIME_Q_TEXT, 2, REQUIRED_TEXT_24_HOURS_FROM_PAYMENT},
                {ORDER_FOR_TODAY_Q_TEXT, 3, REQUIRED_TEXT_ONLY_FROM_TOMORROW},
                {RENEWAL_OR_RETURN_EARLIER_Q_TEXT, 4, REQUIRED_TEXT_NO_SUPPORT_SERVICE_1010},
                {CHARGER_Q_TEXT, 5, REQUIRED_TEXT_FULL_CHARGE},
                {CANCELLATION_Q_TEXT, 6, REQUIRED_TEXT_YES_UNTIL_WAS_DELIVERED},
                {DELIVERY_OUTSIDE_THE_MKAD_Q_TEXT, 7, REQUIRED_TEXT_YES}
        };
    }

    @Test
    public void checkTextAnswerFAQTest() {
//создали объект страницы лендинга
        LandingPage objLandingPage = new LandingPage(driver);
//вызвали методы
        objLandingPage.open();

//сравнили текст ответа, полученного со страницы с текстом константы
        assertEquals(answerToQuestion, objLandingPage
                .getTextAnswerToQuestion(index));
        assertEquals(question, objLandingPage
                .getTextQuestion(index));
    }
}
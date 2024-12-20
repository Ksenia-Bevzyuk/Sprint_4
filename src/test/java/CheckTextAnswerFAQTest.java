import model.Yandex_Scooter.LandingPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import static constanceTest.DataForFAQ.*;
import static org.junit.Assert.assertEquals;

//параметризованный тест проверки ответов на вопросы
@RunWith(Parameterized.class)
public class CheckTextAnswerFAQTest {
//необходимые параметры
    private final By question;
    private final By answerToQuestion;
    private final String requiredAnswerText;

    private WebDriver driver;
//конструктор с параметрами
    public CheckTextAnswerFAQTest(By question, By answerToQuestion, String requiredAnswerText) {
        this.question = question;
        this.answerToQuestion = answerToQuestion;
        this.requiredAnswerText = requiredAnswerText;
    }
//двумерный массив с параметрами для тестов
    @Parameterized.Parameters
    public static Object [][] getFAQ() {
        return new Object[][]{
                {QUESTION_1, ANSWER_TO_QUESTION_1, REQUIRED_ANSWER_1_TEXT},
                {QUESTION_2, ANSWER_TO_QUESTION_2, REQUIRED_ANSWER_2_TEXT},
                {QUESTION_3, ANSWER_TO_QUESTION_3, REQUIRED_ANSWER_3_TEXT},
                {QUESTION_4, ANSWER_TO_QUESTION_4, REQUIRED_ANSWER_4_TEXT},
                {QUESTION_5, ANSWER_TO_QUESTION_5, REQUIRED_ANSWER_5_TEXT},
                {QUESTION_6, ANSWER_TO_QUESTION_6, REQUIRED_ANSWER_6_TEXT},
                {QUESTION_7, ANSWER_TO_QUESTION_7, REQUIRED_ANSWER_7_TEXT},
                {QUESTION_8, ANSWER_TO_QUESTION_8, REQUIRED_ANSWER_8_TEXT},
        };
    }
//выполняем перед каждым тестом
    @Before
    public void start() {
        //driver = new ChromeDriver();
        driver = new FirefoxDriver();
    }

    @Test
    public void checkTextAnswerFAQTest() {
//создали объект страницы лендинга
        LandingPage objLandingPage = new LandingPage(driver);
//вызвали методы
        objLandingPage.open();
        objLandingPage.clickFAQ(question);
        objLandingPage.getTextAnswerToQuestion(answerToQuestion);
//сравнили текст ответа, полученного со страницы с текстом константы
        assertEquals(requiredAnswerText, objLandingPage.getTextAnswerToQuestion(answerToQuestion));
    }
//после каждого теста закрыли браузер
    @After
    public void quit() {

        driver.quit();
    }
}
package constanceTest;

import org.openqa.selenium.By;

//класс с константами для FAQ
public class DataForFAQ {
//константы локаторов вопросов
    public static final By QUESTION_1 = By.id("accordion__heading-0");
    public static final By QUESTION_2 = By.id("accordion__heading-1");
    public static final By QUESTION_3 = By.id("accordion__heading-2");
    public static final By QUESTION_4 = By.id("accordion__heading-3");
    public static final By QUESTION_5 = By.id("accordion__heading-4");
    public static final By QUESTION_6 = By.id("accordion__heading-5");
    public static final By QUESTION_7 = By.id("accordion__heading-6");
    public static final By QUESTION_8 = By.id("accordion__heading-7");
//константы локаторов ответа на вопрос
    public static final By ANSWER_TO_QUESTION_1 = By.xpath(".//div[@id='accordion__panel-0']/p");
    public static final By ANSWER_TO_QUESTION_2 = By.xpath(".//div[@id='accordion__panel-1']/p");
    public static final By ANSWER_TO_QUESTION_3 = By.xpath(".//div[@id='accordion__panel-2']/p");
    public static final By ANSWER_TO_QUESTION_4 = By.xpath(".//div[@id='accordion__panel-3']/p");
    public static final By ANSWER_TO_QUESTION_5 = By.xpath(".//div[@id='accordion__panel-4']/p");
    public static final By ANSWER_TO_QUESTION_6 = By.xpath(".//div[@id='accordion__panel-5']/p");
    public static final By ANSWER_TO_QUESTION_7 = By.xpath(".//div[@id='accordion__panel-6']/p");
    public static final By ANSWER_TO_QUESTION_8 = By.xpath(".//div[@id='accordion__panel-7']/p");
//контанты текста ответов
    public static final String REQUIRED_ANSWER_1_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static final String REQUIRED_ANSWER_2_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static final String REQUIRED_ANSWER_3_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static final String REQUIRED_ANSWER_4_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static final String REQUIRED_ANSWER_5_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static final String REQUIRED_ANSWER_6_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static final String REQUIRED_ANSWER_7_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static final String REQUIRED_ANSWER_8_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
}

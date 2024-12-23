package ru.yandex.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//класс страницы лендинга
public class LandingPage {
    //URL учебного сервиса «Яндекс.Самокат»
    private static final String SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/";
    //локатор кнопки согласия использования куки
    private static final By COOKIE = By.id("rcc-confirm-button");
    //кнопка в заголовке
    public static final By HEADER_ORDER_BUTTON = By.className("Button_Button__ra12g");
    //кнопка в теле
    public static final By MIDDLE_ORDER_BUTTON =
            By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");

    //локаторы вопросов
    public static final By HOW_MUCH_AND_HOW_TO_PAY = By.id("accordion__heading-0");
    public static final By WANT_SOME = By.id("accordion__heading-1");
    public static final By CALCULATION_RENTAL_TIME = By.id("accordion__heading-2");
    public static final By ORDER_FOR_TODAY = By.id("accordion__heading-3");
    public static final By RENEWAL_OR_RETURN_EARLIER = By.id("accordion__heading-4");
    public static final By CHARGER = By.id("accordion__heading-5");
    public static final By CANCELLATION = By.id("accordion__heading-6");
    public static final By DELIVERY_OUTSIDE_THE_MKAD = By.id("accordion__heading-7");
    //локаторы ответа на вопрос
    public static final By DAY_400_PAYMENT_COURIER_CASH_OR_CARD =
            By.xpath(".//div[@id='accordion__panel-0']/p");
    public static final By ONE_ORDER_ONE_SCOOTER_CAN_MAKE_SEVERAL_ORDERS =
            By.xpath(".//div[@id='accordion__panel-1']/p");
    public static final By RENTAL_PERIOD_24_HOURS_FROM_PAYMENT =
            By.xpath(".//div[@id='accordion__panel-2']/p");
    public static final By ONLY_FROM_TOMORROW =
            By.xpath(".//div[@id='accordion__panel-3']/p");
    public static final By NO_SUPPORT_SERVICE_1010 =
            By.xpath(".//div[@id='accordion__panel-4']/p");
    public static final By FULL_CHARGE =
            By.xpath(".//div[@id='accordion__panel-5']/p");
    public static final By YES_UNTIL_WAS_DELIVERED =
            By.xpath(".//div[@id='accordion__panel-6']/p");
    public static final By YES =
            By.xpath(".//div[@id='accordion__panel-7']/p");


    private WebDriver driver;

    //передаем в конструктор класса driver
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    /*метод открывает страницу "Яндекс Самокат", ищет и соглашается с использованием куки,
    чтобы это окно не перекрывало в дальнейшем элементы страницы.*/
    public void open() {
        driver.get(SCOOTER_URL);
        driver.findElement(COOKIE).click();
    }


    //метод ищет одну из двух кнопок "Заказать" и кликает на неё, передаём в него локатор кнопки
    public void clickOrderButton(By orderButton) {
        WebElement orderButtonLanding = driver.findElement(orderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                orderButtonLanding);

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.
                elementToBeClickable(orderButtonLanding));
        orderButtonLanding.click();
    }

    /*метод ищет вопрос, прокручивает страницу до блока FAQ, ждет загрузки и кликает на него,
     передаем локатор вопроса*/
    public void clickFAQ(By question) {

        WebElement importantQuestion = driver.findElement(question);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                importantQuestion);

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.
                elementToBeClickable(importantQuestion));
        importantQuestion.click();
    }

    //метод ждет загрузки ответа, получает текст ответа на вопрос, передаем локатор ответа
    public String getTextAnswerToQuestion(By answerToQuestion) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.
                visibilityOfElementLocated(answerToQuestion));

        WebElement textAnswerToQuestion = driver.findElement(answerToQuestion);
        return textAnswerToQuestion.getText();
    }

    public String checkTextAnswerFAQ(By question, By answerToQuestion) {
        clickFAQ(question);
        return getTextAnswerToQuestion(answerToQuestion);
    }
}
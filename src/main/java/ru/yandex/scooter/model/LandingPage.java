package ru.yandex.scooter.model;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

//класс страницы лендинга
public class LandingPage {
    //URL учебного сервиса «Яндекс.Самокат»
    private static final String SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/";
    //локатор кнопки согласия использования куки
    private static final By COOKIE = By.id("rcc-confirm-button");
    //кнопка в заголовке
    private static final By HEADER_ORDER_BUTTON = By.className("Button_Button__ra12g");
    //кнопка в теле
    private static final By MIDDLE_ORDER_BUTTON =
            By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
    //локаторы вопросов
    private static final By FAQ_BUTTONS = By.className("accordion__button");
    //локаторы ответов на вопросы
    private static final By ANSWERS_TO_FAQ =
            By.xpath(".//div[@class='accordion__panel']/p");

    private final WebDriver driver;

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


    //метод ищет одну из двух кнопок "Заказать" и кликает на неё, передаём в него расположение кнопки
    public void clickOrderButton(String orderButton) {
        By orderButtonLocator;
        if (Objects.equals(orderButton, "Заголовок")) {
            orderButtonLocator = HEADER_ORDER_BUTTON;
        } else if (Objects.equals(orderButton, "Тело")) {
            orderButtonLocator = MIDDLE_ORDER_BUTTON;
        } else {
            orderButtonLocator = HEADER_ORDER_BUTTON;
            System.out.println("Выбрана кнопка по умолчанию");
        }
        WebElement orderButtonLanding = driver.findElement(orderButtonLocator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                orderButtonLanding);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.
                elementToBeClickable(orderButtonLanding));
        orderButtonLanding.click();
    }

    /*метод ищет вопрос, прокручивает страницу до блока FAQ, ждет загрузки и кликает на него,
     передаем индекс вопроса*/
    public void clickFAQ(int index) {

        WebElement importantQuestion = driver.findElements(FAQ_BUTTONS).get(index);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",
                importantQuestion);

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.
                elementToBeClickable(importantQuestion));
        importantQuestion.click();
    }

    //метод кликает на вопрос, получает текст ответа на вопрос, передаем индекс
    public String getTextAnswerToQuestion(int index) {
        clickFAQ(index);
        return driver.findElements(ANSWERS_TO_FAQ).get(index).getText();
    }

    //метод кликает на вопрос, получает текст вопроса на вопрос, передаем индекс
    public String getTextQuestion(int index) {
        clickFAQ(index);
        return driver.findElements(FAQ_BUTTONS).get(index).getText();
    }
}
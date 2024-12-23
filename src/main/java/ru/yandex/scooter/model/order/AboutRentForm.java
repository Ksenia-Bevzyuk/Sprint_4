package ru.yandex.scooter.model.order;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//класс страницы с формой "Про аренду"
public class AboutRentForm {
    //локатор формы
    private static final By ORDER_FORM_ABOUT_RENT =
            By.className("Order_Form__17u6u");
    //локатор поля "Когда привезти самокат"
    private static final By DATE_FIELD =
            By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //локатор поля с выпадающим списком "Срок аренды"
    private static final By DAY_RENT_FIELD = By.tagName("span");
    //локатор чек-бокса "Цвет самоката"
    private static final By COLOR_FIELD = By.id("black");
    //локатор поля "Комментарий"
    private static final By COMMENT_FIELD =
            By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    //локатор кнопки "Заказать", расположенной под формой
    private static final By ORDER_BUTTON =
            By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //локатор попапа "Хотите оформить заказ?"
    private static final By POPUP_SUCCESS_ORDER = By.className("Order_Modal__YZ-d3");
    //локатор кнопки "Да" на попапе "Хотите оформить заказ?"
    private static final By YES_BUTTON = By.xpath(".//button[text() = 'Да']");
    //локатор кнопки "Посмотреть статус" на попапе "Заказ оформлен"
    private static final By BUTTON_POPUP_SUCCESS_ORDER =
            By.xpath(".//button[text()='Посмотреть статус']");
    //два набора данных для заполнения полей формы
    public static final String DATE_SET_FIRST = "30.12.2024";
    public static final String DATE_SET_SECOND = "25.02.2025";
    public static final By DAYS_SET_FIRST = By.xpath(".//div[text()='сутки']");
    public static final By DAYS_SET_SECOND = By.xpath(".//div[text()='двое суток']");
    public static final String COMMENT_SET_FIRST = "Не звонить";
    public static final String COMMENT_SET_SECOND = "";

    private WebDriver driver;

    //передаем в конструктор класса driver
    public AboutRentForm(WebDriver driver) {

        this.driver = driver;
    }

    //метод для ожидания загрузки формы
    public void waitForAboutRentFormDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.
                visibilityOfElementLocated(ORDER_FORM_ABOUT_RENT));
    }

    //метод поиска и заполнения поля "Когда привезти самокат", передаем в него дату строкой
    public void setDateField(String date) {
        driver.findElement(DATE_FIELD).sendKeys(date);
    }

    //метод поиска, клика, ожидания выпадающего списка и заполнения кликом по элементу поля "Срок аренды"
    public void setDayRentField(By days) {
        driver.findElement(DAY_RENT_FIELD).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(days));
        driver.findElement(days).click();
    }

    //метод поиска и выбора кликом чек-бокса с цветом самоката
    public void setColorField() {
        driver.findElement(COLOR_FIELD).click();
    }

    //метод поиска и заполнения поля "Комментарий", передаем в него комментарий строкой
    public void setCommentField(String comment) {
        driver.findElement(COMMENT_FIELD).sendKeys(comment);
    }

    //метод, который ждёт, пока кнопка "Заказать" станет кликабельной и кликает на неё
    public void clickOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(ORDER_BUTTON));
        driver.findElement(ORDER_BUTTON).click();
    }

    //метод, который ждёт попап подтверждения заказа и кликает "Да"
    public void clickYesPopupCompletionOfTheOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions
                .visibilityOfElementLocated(POPUP_SUCCESS_ORDER));
        driver.findElement(YES_BUTTON).click();
    }

    /*метод, который ждет попап "Заказ оформлен", обнаруживает кнопку "Посмотреть статус" и
    возвращает boolean значение выполнения */
    public boolean isVisiblePopupSuccessOrder() {
        WebElement isVisiblePopupSuccessOrder = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(BUTTON_POPUP_SUCCESS_ORDER));
        return isVisiblePopupSuccessOrder.isDisplayed();
    }

    //объединяем методы заполнения полей формы и прокликивания кнопок в шаг
    public void setAboutRentForm(String date, By days, String comment) {
        setDateField(date);
        setDayRentField(days);
        setColorField();
        setCommentField(comment);
        clickOrderButton();
        clickYesPopupCompletionOfTheOrder();
    }
}
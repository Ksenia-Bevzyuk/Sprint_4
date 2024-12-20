package model.Yandex_Scooter.OrderForm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static model.Yandex_Scooter.constanceModel.AboutRent.*;

//класс страницы с формой "Про аренду"
public class AboutRentForm {
    private WebDriver driver;
//передаем в конструктор класса driver
    public AboutRentForm(WebDriver driver) {
        this.driver = driver;
    }
//метод для ожидания загрузки формы
    public void waitForAboutRentFormDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(ORDER_FORM_ABOUT_RENT));
    }
//метод поиска и заполнения поля "Когда привезти самокат", передаем в него дату строкой
    public void setDateField(String date) {
        driver.findElement(dateField).sendKeys(date);
    }
//метод поиска, клика, ожидания выпадающего списка и заполнения кликом по элементу поля "Срок аренды"
    public void setDayRentField() {
        driver.findElement(dayRentField).click();
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.xpath(".//div[text()='сутки']")));
        driver.findElement(By.xpath(".//div[text()='сутки']")).click();
    }
//метод поиска и выбора кликом чек-бокса с цветом самоката
    public void setColorField() {
        driver.findElement(colorField).click();
    }
//метод поиска и заполнения поля "Комментарий", передаем в него комментарий строкой
    public void setCommentField(String comment) {
        driver.findElement(commentField).sendKeys(comment);
    }
//метод, который ждёт, пока кнопка "Заказать" станет кликабельной и кликает на неё
    public void clickOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(orderButton));
        driver.findElement(orderButton).click();
    }
//метод, который ждёт попап подтверждения заказа и кликает "Да"
    public void clickYesPopupCompletionOfTheOrder() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(popupSuccessOrder));
        driver.findElement(yesButton).click();
    }
//метод, который ждет попап "Заказ оформлен", обнаруживает кнопку "Посмотреть статус" и возвращает boolean значение выполнения
    public boolean isVisiblePopupSuccessOrder() {
        WebElement isVisiblePopupSuccessOrder = new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(buttonPopupSuccessOrder));
        return isVisiblePopupSuccessOrder.isDisplayed();
    }
//объединяем методы заполнения полей формы и прокликивания кнопок в шаг
    public void setAboutRentForm(String date, String comment) {
        setDateField(date);
        setDayRentField();
        setColorField();
        setCommentField(comment);
        clickOrderButton();
        clickYesPopupCompletionOfTheOrder();
    }
}
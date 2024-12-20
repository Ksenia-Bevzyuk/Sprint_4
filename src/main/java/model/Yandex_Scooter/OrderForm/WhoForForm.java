package model.Yandex_Scooter.OrderForm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static model.Yandex_Scooter.constanceModel.WhoFor.*;

//класс страницы с формой "Для кого самокат"
public class WhoForForm {
    private WebDriver driver;
//передаем в конструктор класса driver
    public WhoForForm(WebDriver driver) {
        this.driver = driver;
    }
//метод для ожидания загрузки формы
    public void waitForWhoForFormDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(ORDER_FORM_WHO_FOR));
    }
//метод поиска и заполнения поля "Имя", передаем в него имя строкой
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
//метод поиска и заполнения поля "Фамилия", передаем в него фамилию строкой
    public void setSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
    }
//метод поиска и заполнения поля "Куда привезти самокат", передаем в него адрес строкой
    public void setAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
    }
//метод поиска и заполнения поля "Станция метро", кликаем на поле, ищем первый элемент в ненумерованном списке и кликаем на него
    public void setStationField() {
        driver.findElement(stationField).click();
        driver.findElement(By.xpath(".//li[1]")).click();
    }
//метод поиска и заполнения поля "Телефон", передаем в него телефон строкой
    public void setPhoneField(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
    }
//метод поиска и клика на кнопку "Далее"
    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }
//объединяем в шаг заполнение полей формы и клика "Далее" для перехода к форме "Про аренду"
    public void setWhoForForm(String name, String surname, String address, String phone) {
        setNameField(name);
        setSurnameField(surname);
        setAddressField(address);
        setStationField();
        setPhoneField(phone);
        clickNextButton();
    }
//метод кликает на логотип
    public void clickToLogo(By logo) {
        driver.findElement(logo).click();
    }
}
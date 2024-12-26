package ru.yandex.scooter.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

//класс страницы с формой "Для кого самокат"
public class WhoForForm {
    //локатор формы
    private static final By ORDER_FORM_WHO_FOR = By.className("Order_Content__bmtHS");
    //кнопка в заголовке
    private static final By HEADER_ORDER_BUTTON = By.className("Button_Button__ra12g");
    //локатор поля "Имя"
    private static final By NAME_FIELD = By.xpath(".//input[@placeholder = '* Имя']");
    //локатор поля "Фамилия"
    private static final By SURNAME_FIELD =
            By.xpath(".//input[@placeholder = '* Фамилия']");
    //локатор поля "Адрес"
    private static final By ADDRESS_FIELD =
            By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    //локатор поля "Станция метро"
    private static final By STATION_FIELD = By.className("select-search__input");
    //локатор поля "Телефон"
    private static final By PHONE_FIELD =
            By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    //локатор кнопки "Далее"
    private static final By NEXT_BUTTON = By.xpath(".//button[text() = 'Далее']");
    //локатор выбора станции метро
    private static final By STATION_BULVAR_ROKOSOVSKOGO = By.xpath(".//li[1]");

    //локатор логотипа Самокат
    private static final By SCOOTER_LOGO = By.xpath(".//img[@src='/assets/scooter.svg']");
    //локатор лендинга Самокат
    public static final By SCOOTER_YA = By.className("Home_Header__iJKdX");
    //локатор логотипа Яндекс
    private static final By YA_LOGO = By.xpath(".//img[@src='/assets/ya.svg']");
    //локатор на странице Яндекс
    private static final By YA_RU = By.className("Header_Header__214zg");

    private final WebDriver driver;

    //передаем в конструктор класса driver
    public WhoForForm(WebDriver driver) {

        this.driver = driver;
    }

    //метод для ожидания загрузки формы
    public void waitForWhoForFormDisplayed() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(ORDER_FORM_WHO_FOR));
    }

    //метод поиска и заполнения поля "Имя", передаем в него имя строкой
    public void setNameField(String name) {

        driver.findElement(NAME_FIELD).sendKeys(name);
    }

    //метод поиска и заполнения поля "Фамилия", передаем в него фамилию строкой
    public void setSurnameField(String surname) {

        driver.findElement(SURNAME_FIELD).sendKeys(surname);
    }

    //метод поиска и заполнения поля "Куда привезти самокат", передаем в него адрес строкой
    public void setAddressField(String address) {

        driver.findElement(ADDRESS_FIELD).sendKeys(address);
    }

    /* метод поиска и заполнения поля "Станция метро", кликаем на поле,
    ищем первый элемент в ненумерованном списке и кликаем на него */
    public void setStationField() {
        driver.findElement(STATION_FIELD).click();
        driver.findElement(STATION_BULVAR_ROKOSOVSKOGO).click();
    }

    //метод поиска и заполнения поля "Телефон", передаем в него телефон строкой
    public void setPhoneField(String phone) {

        driver.findElement(PHONE_FIELD).sendKeys(phone);
    }

    //метод поиска и клика на кнопку "Далее"
    public void clickNextButton() {

        driver.findElement(NEXT_BUTTON).click();
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
    public void clickToLogo(String logo) {
        if (Objects.equals(logo, "Яндекс")) {
            driver.findElement(YA_LOGO).click();
        } else if (Objects.equals(logo, "Самокат")) {
            driver.findElement(HEADER_ORDER_BUTTON).click();
            driver.findElement(SCOOTER_LOGO).click();
        } else {
            driver.findElement(SCOOTER_LOGO).click();
            System.out.println("Выбрано лого по умолчанию");
        }
    }

    public boolean transitionFinalPageIsDisplayed(String finalPage) {
        if (Objects.equals(finalPage, "yaSearch")) {
            return driver.findElement(YA_RU).isDisplayed();
        } else if (Objects.equals(finalPage, "scooterLanding")) {
            return driver.findElement(SCOOTER_YA).isDisplayed();
        } else {
            System.out.println("По умолчанию");
            return driver.findElement(SCOOTER_YA).isDisplayed();
        }
    }
}
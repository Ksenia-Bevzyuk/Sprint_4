package model.Yandex_Scooter.constanceModel;

import org.openqa.selenium.By;

//класс с константами формы "Для кого самокат"
public class WhoFor {
//локатор формы
    public static final By ORDER_FORM_WHO_FOR = By.className("Order_Content__bmtHS");
//локатор поля "Имя"
    public static final By nameField = By.xpath(".//input[@placeholder = '* Имя']");
//локатор поля "Фамилия"
    public static final By surnameField = By.xpath(".//input[@placeholder = '* Фамилия']");
//локатор поля "Адрес"
    public static final By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
//локатор поля "Станция метро"
    public static final By stationField = By.className("select-search__input");
//локатор поля "Телефон"
    public static final By phoneField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
//локатор кнопки "Далее"
    public static final By nextButton = By.xpath(".//button[text() = 'Далее']");

//локатор логотипа Самокат
    public static final By SCOOTER_LOGO = By.xpath(".//img[@src='/assets/scooter.svg']");
//локатор логотипа Яндекс
    public static final By YA_LOGO = By.xpath(".//img[@src='/assets/ya.svg']");
}

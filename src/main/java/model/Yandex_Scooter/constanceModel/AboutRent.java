package model.Yandex_Scooter.constanceModel;

import org.openqa.selenium.By;

//класс констант для формы "Об аренде"
public class AboutRent {
//локатор формы
    public static final By ORDER_FORM_ABOUT_RENT = By.className("Order_Form__17u6u");
//локатор поля "Когда привезти самокат"
    public static final By dateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
//локатор поля с выпадающим списком "Срок аренды"
    public static final By dayRentField = By.tagName("span");
//локатор чек-бокса "Цвет самоката"
    public static final By colorField = By.id("black");
//локатор поля "Комментарий"
    public static final By commentField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
//локатор кнопки "Заказать", расположенной под формой
    public static final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
//локатор попапа "Хотите оформить заказ?"
    public static final By popupSuccessOrder = By.className("Order_Modal__YZ-d3");
//локатор кнопки "Да" на попапе "Хотите оформить заказ?"
    public static final By yesButton = By.xpath(".//button[text() = 'Да']");
//локатор кнопки "Посмотреть статус" на попапе "Заказ оформлен"
    public static final By buttonPopupSuccessOrder = By.xpath(".//button[text()='Посмотреть статус']");
}

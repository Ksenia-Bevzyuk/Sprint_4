package constanceTest;

import org.openqa.selenium.By;

//класс с константами локаторов кнопок "Заказать"
public class OrderButton {
//кнопка в заголовке
    public static final By HEADER_ORDER_BUTTON = By.className("Button_Button__ra12g");
//кнопка в теле
    public static final By MIDDLE_ORDER_BUTTON = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[text()='Заказать']");
}

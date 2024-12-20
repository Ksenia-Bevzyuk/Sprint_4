package model.Yandex_Scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static model.Yandex_Scooter.constanceModel.Landing.COOKIE;
import static model.Yandex_Scooter.constanceModel.Landing.SCOOTER_URL;

//класс страницы лендинга
public class LandingPage {
    private WebDriver driver;
//передаем в конструктор класса driver
    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }
//метод открывает страницу "Яндекс Самокат", ищет и соглашается с использованием куки, чтобы это окно не перекрывало в дальнейшем элементы страницы
    public void open() {
        driver.get(SCOOTER_URL);
        driver.findElement(COOKIE).click();
    }
//метод ищет одну из двух кнопок "Заказать" и кликает на неё, передаём в него локатор кнопки
    public void clickOrderButton(By orderButton) {
        WebElement orderButtonLanding = driver.findElement(orderButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", orderButtonLanding);

       new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(orderButtonLanding));
        orderButtonLanding.click();
    }
//метод ищет вопрос, прокручивает страницу до блока FAQ, ждет загрузки и кликает на него, передаем локатор вопроса
    public void clickFAQ(By question) {
        WebElement importantQuestion = driver.findElement(question);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", importantQuestion);

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(importantQuestion));
        importantQuestion.click();
    }
//метод ждет загрузки ответа, получает текст ответа на вопрос, передаем локатор ответа
    public String getTextAnswerToQuestion(By answerToQuestion) {
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(answerToQuestion));

        WebElement textAnswerToQuestion = driver.findElement(answerToQuestion);
        return textAnswerToQuestion.getText();
    }
}
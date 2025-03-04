package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final By TITLE = By.cssSelector("[data-test=title]");
    private static final String ADD_TO_CART = "//div[text() = '%s']/ancestor::div[@class='inventory_item']//button";
    private static final By CART_BUTTON = By.id("shopping_cart_container");

    @Step("Страница ProductsPage открыта")
    public boolean isPageOpened() {
       return driver.findElement(TITLE).isDisplayed();
    }

    @Step("Добавление в корзину товара - {product}")
    public ProductsPage addToCart(String product) {
        driver.findElement(By.xpath(String.format(ADD_TO_CART, product))).click();
        return this;
    }

    @Step("Нажатие на кнопку корзина")
    public CartPage clickToCart() {
        driver.findElement(CART_BUTTON).click();
        return new CartPage(driver);
    }
}

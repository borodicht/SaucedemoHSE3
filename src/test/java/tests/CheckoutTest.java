package tests;

import dto.Customer;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    /*
    1. Открыть страницу логина
    2. Ввести данные пользователя (логин и пароль)
    3. Нажать кнопку add to cart для определенного товара
    4. Нажать кнопку Cart
    5. Нажать кнопку checkout
    6. Ввести данные покупателя (имя, фамилию, индекс)
    7. Нажать кнопку continue
    8. Нажать кнопку finish
    9. Проверить, что на экране присуисвует сообщение - Thank you for your order!
     */

    Customer customer = Customer.builder()
            .firstName("Ivan")
            .lastName("Ivanov")
            .zipCode("1223456")
            .build();

    @Test
    @Link("https://www.saucedemo.com/")
    @TmsLink("www.testrail.com/SD/SD-01")
    @Issue("www.jira.com/SD/BUG-01")
    @Flaky
    @Severity(SeverityLevel.CRITICAL)
    @Description("Сквозное тестирование приложения")
    @Epic("HSE-03")
    @Feature("HSE-03-01")
    @Story("HSE-03-01-01")
    @Owner("Бородич Тимофей")
    public void checkout() {
        loginPage.open()
                .login(user, password)
                .addToCart("Sauce Labs Bolt T-Shirt")
                .clickToCart()
                .clickToCheckout()
                .fillingForm(customer)
                .clickToContinue()
                .clickToFinish();
        assertEquals(completePage.getCompleteMessage(),
                "Thank you for your order!",
                "Сообщение о покупке не отобразилось"
        );
    }
}

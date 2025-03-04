package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Log4j2
public class LoginTest extends BaseTest {

    /*
    1.Открыть страницу https://www.saucedemo.com/
    2. Ввести в поле username значение standard_user
    3. Оставить поле password пустым (ввести пробел)
    4. Нажать кнопку Login
    5. Проверить, что мы видим сообщение об ошибке с текстом
       Epic sadface: Password is required
     */

    @Test
    public void checkNegativeLoginWithEmptyPassword() {
        loginPage.open()
                .loginForNegativeData("standard_user", "");
        assertEquals(loginPage.getErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void checkPositiveLogin() {
        loginPage.open()
                .login("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageOpened());
    }
}

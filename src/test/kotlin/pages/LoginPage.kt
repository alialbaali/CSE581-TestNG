package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait

/**
 * [LoginPage] represents the start destination of the website which contains the login form.
 * */
class LoginPage(private val driver: WebDriver) {

    /**
     * Login form inputs.
     * */
    private val userNameInput = driver.findElement(By.id("user-name"))
    private val passwordInput = driver.findElement(By.id("password"))
    private val loginButton = driver.findElement(By.id("login-button"))

    /**
     * Logs the user into the system using [userName] and [password].
     * @return [InventoryPage].
     * @throws [IllegalStateException].
     * */
    fun login(userName: String, password: String): InventoryPage {
        userNameInput.sendKeys(userName)
        passwordInput.sendKeys(password)
        loginButton.click()

        /**
         * check any login errors after 10 seconds from calling [login] function.
         * @throws [IllegalStateException].
         * */
        val error = runCatching {
            WebDriverWait(driver, 10)
                .until { driver.findElement(By.className("error-button")) }
        }.getOrNull()

        return if (error?.isDisplayed == true)
            error(error.text)
        else
            InventoryPage(driver)
    }

}
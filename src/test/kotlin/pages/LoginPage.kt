package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.WebDriverWait

class LoginPage(private val driver: WebDriver) {

    private val userNameInput = driver.findElement(By.id("user-name"))
    private val passwordInput = driver.findElement(By.id("password"))
    private val loginButton = driver.findElement(By.id("login-button"))

    fun login(userName: String, password: String): InventoryPage {
        userNameInput.sendKeys(userName)
        passwordInput.sendKeys(password)
        loginButton.click()
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
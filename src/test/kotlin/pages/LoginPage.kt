package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

private const val UserNameId = "user-name"
private const val PasswordId = "password"
private const val LoginButtonId = "login-button"

class LoginPage(private val driver: WebDriver) {

    private val userNameInput = driver.findElement(By.id(UserNameId))
    private val passwordInput = driver.findElement(By.id(PasswordId))
    private val loginButton = driver.findElement(By.id(LoginButtonId))

    fun login(userName: String, password: String): InventoryPage {
        userNameInput.sendKeys(userName)
        passwordInput.sendKeys(password)
        loginButton.click()
        return InventoryPage(driver)
    }

}
package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class Navbar(private val driver: WebDriver) {

    private val menuIcon = driver.findElement(By.className("bm-burger-button"))

    private val shoppingCartIcon = driver.findElement(By.className("shopping_cart_container"))

    fun navigateToMenuPage(): MenuPage {
        menuIcon.click()
        return MenuPage(driver)
    }

    fun navigateToShoppingCart(): ShoppingCartPage {
        shoppingCartIcon.click()
        return ShoppingCartPage(driver)
    }

}
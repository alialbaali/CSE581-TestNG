package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

/**
 * [Navbar] represents the navbar of all pages except [LoginPage],
 * it can be used to navigate to either [ShoppingCartPage] or [MenuPage].
 * */
class Navbar(private val driver: WebDriver) {

    /**
     * Navbar icons.
     * */
    private val menuIcon = driver.findElement(By.className("bm-burger-button"))
    private val shoppingCartIcon = driver.findElement(By.className("shopping_cart_container"))

    /**
     * Navigates to [MenuPage].
     * @return [MenuPage]
     * */
    fun navigateToMenuPage(): MenuPage {
        menuIcon.click()
        return MenuPage(driver)
    }

    /**
     * Navigates to [ShoppingCartPage].
     * @return [ShoppingCartPage]
     * */
    fun navigateToShoppingCart(): ShoppingCartPage {
        shoppingCartIcon.click()
        return ShoppingCartPage(driver)
    }

}
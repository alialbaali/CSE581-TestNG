package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class ShoppingCartPage(private val driver: WebDriver) {

    val navbar = Navbar(driver)

    private val continueShoppingButton = driver.findElement(By.linkText("CONTINUE SHOPPING"))
    private val checkoutButton = driver.findElement(By.linkText("CHECKOUT"))

    fun getCartItems(): List<WebElement> {
        return driver.findElements(By.className("cart_item"))
    }

    fun removeCartItem(index: Int): ShoppingCartPage {
        getCartItems()[index]
            .findElement(By.className("cart_button"))
            .click()
        return this
    }

    fun checkout(): CheckoutPage.CheckoutStep1 {
        checkoutButton.click()
        return CheckoutPage(driver).CheckoutStep1()
    }

    fun continueShopping(): InventoryPage {
        continueShoppingButton.click()
        return InventoryPage(driver)
    }

}
package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

/**
 * [ShoppingCartPage]] represents the shopping cart page containing shopping cart items.
 * */
class ShoppingCartPage(private val driver: WebDriver) {

    val navbar = Navbar(driver)

    /**
     * Shopping cart actions.
     * */
    private val continueShoppingButton = driver.findElement(By.linkText("CONTINUE SHOPPING"))
    private val checkoutButton = driver.findElement(By.linkText("CHECKOUT"))

    /**
     * Gets current shopping cart items as [WebElement].
     * @return [List][WebElement].
     * */
    fun getCartItems(): List<WebElement> {
        return driver.findElements(By.className("cart_item"))
    }

    /**
     * Removes shopping cart item based on the [index] of the item in the shopping cart page.
     * @return [ShoppingCartPage].
     * */
    fun removeCartItem(index: Int): ShoppingCartPage {
        getCartItems()[index]
            .findElement(By.className("cart_button"))
            .click()
        return this
    }

    /**
     * Navigates to [CheckoutPage].
     * @return [CheckoutPage].
     * */
    fun checkout(): CheckoutPage.CheckoutStep1 {
        checkoutButton.click()
        return CheckoutPage(driver).CheckoutStep1()
    }

    /**
     * Continues shopping and navigates back to [InventoryPage].
     * @return [InventoryPage].
     * */
    fun continueShopping(): InventoryPage {
        continueShoppingButton.click()
        return InventoryPage(driver)
    }

}
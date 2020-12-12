package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

/**
 * [InventoryItemPage] represents product item page with ability to:
 * Add the product to the cart @see [addToCart].
 * Remove the product from the cart @see [removeFromCart].
 * Navigate back to the [InventoryPage] @see [back].
 * */
class InventoryItemPage(private val driver: WebDriver) {

    /**
     * Product item actions.
     * */
    private val actionButton = driver.findElement(By.className("btn_inventory"))
    private val backButton = driver.findElement(By.className("inventory_details_back_button"))

    val navbar = Navbar(driver)

    /**
     * Adds the current product to the shopping cart.
     * @return [InventoryItemPage].
     * */
    fun addToCart(): InventoryItemPage {
        actionButton.click()
        return this
    }

    /**
     * Removes the current product from the shopping cart.
     * @return [InventoryItemPage].
     * */
    fun removeFromCart(): InventoryItemPage {
        actionButton.click()
        return this
    }

    /**
     * Navigates back to the [InventoryPage].
     * @return [InventoryPage].
     * */
    fun back(): InventoryPage {
        backButton.click()
        return InventoryPage(driver)
    }

}
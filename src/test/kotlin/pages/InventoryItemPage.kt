package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class InventoryItemPage(private val driver: WebDriver, private val itemIndex: Int) {

    private val actionButton = driver.findElement(By.className("btn_inventory"))
    private val backButton = driver.findElement(By.className("inventory_details_back_button"))

    val navbar = Navbar(driver)

    fun addToCart(): InventoryItemPage {
        actionButton.click()
        return this
    }

    fun removeFromCart(): InventoryItemPage {
        actionButton.click()
        return this
    }

    fun back(): InventoryPage {
        backButton.click()
        return InventoryPage(driver)
    }

}
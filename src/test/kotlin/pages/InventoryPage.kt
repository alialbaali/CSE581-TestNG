package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class InventoryPage(private val driver: WebDriver) {

    val navbar = Navbar(driver)

    fun getProducts(): List<WebElement> {
        return driver.findElements(By.className("inventory_item"))
    }

    fun addProductToCart(index: Int): InventoryPage {
        getProducts()[index]
            .findElement(By.className("btn_inventory"))
            .click()
        return this
    }

    fun removeProductFromCart(index: Int): InventoryPage {
        getProducts()[index]
            .findElement(By.className("btn_inventory"))
            .click()
        return this
    }

    fun openProduct(index: Int): InventoryItemPage {
        getProducts()[index]
            .findElement(By.className("inventory_item_img"))
            .click()
        return InventoryItemPage(driver, index)
    }

    fun sortProductsBy(sortType: SortType): InventoryPage {
        val elements = driver.findElements(By.tagName("option"))
        elements[sortType.ordinal].click()
        return this
    }

    enum class SortType {
        NAME_A_TO_Z, NAME_Z_TO_A,
        PRICE_HIGH_TO_LOW, PRICE_LOW_TO_HIGH
    }

}

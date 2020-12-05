package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class InventoryPage(private val driver: WebDriver) {

    val navbar = Navbar(driver)

    fun getProducts(): List<WebElement> {
        return driver.findElements(By.className("inventory_item"))
    }

    fun addProductToCart(index: Int) {
        getProducts()[index]
            .findElement(By.className("btn_inventory"))
            .click()
    }

    fun removeCartItem(index: Int) {
        getProducts()[index]
            .findElement(By.className("btn_inventory"))
            .click()
    }

    fun sortBy(sortType: SortType) {
        val elemnts = driver.findElements(By.tagName("option"))
        elemnts[sortType.ordinal].click()
    }


    enum class SortType {
        NAME_A_TO_Z, NAME_Z_TO_A,
        PRICE_HIGH_TO_LOW, PRICE_LOW_TO_HIGH
    }
}

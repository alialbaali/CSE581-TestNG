package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

/**
 * [InventoryPage] represents the products page which contains a collection of products.
 * */
class InventoryPage(private val driver: WebDriver) {

    val navbar = Navbar(driver)

    /**
     * Gets page products as [WebElement].
     * @return [List][WebElement].
     * */
    fun getProducts(): List<WebElement> {
        return driver.findElements(By.className("inventory_item"))
    }

    /**
     * Adds product to the shopping cart based on the [index] of the product in products page.
     * @return [InventoryPage].
     * */
    fun addProductToCart(index: Int): InventoryPage {
        getProducts()[index]
            .findElement(By.className("btn_inventory"))
            .click()
        return this
    }

    /**
     * Removes product from the shopping cart based on the [index] of the product in the products page.
     * @return [InventoryPage].
     * */
    fun removeProductFromCart(index: Int): InventoryPage {
        getProducts()[index]
            .findElement(By.className("btn_inventory"))
            .click()
        return this
    }


    /**
     * Navigates to the [InventoryItemPage] based on the [index] of the product in the products page.
     * @return [InventoryItemPage].
     * */
    fun openProduct(index: Int): InventoryItemPage {
        getProducts()[index]
            .findElement(By.className("inventory_item_img"))
            .click()
        return InventoryItemPage(driver)
    }


    /**
     * Sorts products based on [SortType].
     * @return [InventoryPage]
     * */
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

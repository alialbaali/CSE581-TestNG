package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

/**
 * [InventoryPage] represents the products page which contains a collection of products.
 * */
class MenuPage(private val driver: WebDriver) {

    /**
     * Menu items.
     * */
    private val getItemsMenuItem = driver.findElement(By.id("inventory_sidebar_link"))
    private val aboutMenuItem = driver.findElement(By.className("bm-cross-button"))
    private val closeButton = driver.findElement(By.className("bm-cross-button"))
    private val logoutButton = driver.findElement(By.linkText("Logout"))

    /**
     * Clicks [getItemsMenuItem] and navigates to [InventoryPage].
     * @return [InventoryPage].
     * */
    fun getProducts(): InventoryPage {
        getItemsMenuItem.click()
        return InventoryPage(driver)
    }

    /**
     * Clicks [closeButton] and navigates to [InventoryPage].
     * @return [InventoryPage].
     * */
    fun close(): InventoryPage {
        closeButton.click()
        return InventoryPage(driver)
    }

    /**
     * Clicks [getItemsMenuItem] and navigates to [SauceLabs][https://saucelabs.com/].
     * */
    fun about() {
        aboutMenuItem.click()
    }

    /**
     * Clicks [logoutButton] and navigates to [LoginPage].
     * @return [LoginPage].
     * */
    fun logout(): LoginPage {
        logoutButton.click()
        return LoginPage(driver)
    }

}
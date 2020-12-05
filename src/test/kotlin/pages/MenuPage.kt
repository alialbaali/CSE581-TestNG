package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class MenuPage(private val driver: WebDriver) {

    private val getItemsMenuItem = driver.findElement(By.id("inventory_sidebar_link"))
    private val aboutMenuItem = driver.findElement(By.className("bm-cross-button"))
    private val closeButton = driver.findElement(By.className("bm-cross-button"))
    private val logoutButton = driver.findElement(By.linkText("Logout"))

    fun getProducts(): InventoryPage {
        getItemsMenuItem.click()
        return InventoryPage(driver)
    }

    fun close(): InventoryPage {
        closeButton.click()
        return InventoryPage(driver)
    }

    fun about() {
        aboutMenuItem.click()
    }

    fun logout(): LoginPage {
        logoutButton.click()
        return LoginPage(driver)
    }

}
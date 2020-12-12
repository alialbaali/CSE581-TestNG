package scenarios

import DefaultPassword
import org.openqa.selenium.WebDriver
import org.testng.Assert
import org.testng.annotations.Test
import pages.InventoryPage
import pages.LoginPage

private const val StandardUserName = "standard_user"


class SuccessfulPathScenario(private val driver: WebDriver) {

    @Test
    fun `successful login and checkout with 2 items in the shopping cart`() {
        LoginPage(driver)
            .login(StandardUserName, DefaultPassword)
            .sortProductsBy(InventoryPage.SortType.PRICE_LOW_TO_HIGH)
            .addProductToCart(0)
            .navbar
            .navigateToShoppingCart()
            .also { shoppingCartPage ->
                val shoppingCartItemsCount = shoppingCartPage.getCartItems().count()
                Assert.assertEquals(shoppingCartItemsCount, 1)
            }
            .navbar
            .navigateToMenuPage()
            .getProducts()
            .sortProductsBy(InventoryPage.SortType.NAME_A_TO_Z)
            .addProductToCart(0)
            .navbar
            .navigateToShoppingCart()
            .also { shoppingCartPage ->
                val shoppingCartItemsCount = shoppingCartPage.getCartItems().count()
                Assert.assertEquals(shoppingCartItemsCount, 2)
            }
            .checkout()
            .continueToNextStep("Ali", "Albaali", "42042")
            .finish()
            .navbar
            .navigateToMenuPage()
            .logout()
            .also { Assert.assertTrue(driver.currentUrl.endsWith("index.html")) }
    }

}
package scenarios

import DefaultPassword
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.testng.Assert
import org.testng.annotations.Test
import org.testng.asserts.SoftAssert
import pages.InventoryPage
import pages.LoginPage

private const val ProblemUserName = "problem_user"

class ProblemUserScenario(private val driver: WebDriver) {

    private val softAssert = SoftAssert()

    @Test
    fun `image not clickable throws an exception`() {
        LoginPage(driver)
            .login(ProblemUserName, DefaultPassword)
            .sortProductsBy(InventoryPage.SortType.PRICE_HIGH_TO_LOW)
            .apply {
                val imageUrl = getProducts()[0]
                    .findElement(By.className("inventory_item_img"))
                    .findElement(By.className("inventory_item_img"))
                    .getAttribute("src")

                softAssert.assertFalse(imageUrl.endsWith(".jpg"))
            }
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
                Assert.assertEquals(shoppingCartItemsCount, 1)
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

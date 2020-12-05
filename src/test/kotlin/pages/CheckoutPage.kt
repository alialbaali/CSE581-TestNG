package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class CheckoutPage(private val driver: WebDriver) {

    inner class CheckoutStep1 {

        val navbar = Navbar(driver)

        private val firstNameInput = driver.findElement(By.id("first-name"))
        private val lastNameInput = driver.findElement(By.id("last-name"))
        private val postalCodeInput = driver.findElement(By.id("postal-code"))

        private val cancelButton = driver.findElement(By.className("cart_cancel_link"))
        private val checkoutButton = driver.findElement(By.className("cart_button"))

        fun continueToNextStep(firstName: String, lastName: String, postalCode: String): CheckoutStep2 {
            firstNameInput.sendKeys(firstName)
            lastNameInput.sendKeys(lastName)
            postalCodeInput.sendKeys(postalCode)
            checkoutButton.click()
            return CheckoutStep2()
        }

        fun cancel(): ShoppingCartPage {
            cancelButton.click()
            return ShoppingCartPage(driver)
        }

    }

    inner class CheckoutStep2 {

        val navbar = Navbar(driver)

        private val cancelButton = driver.findElement(By.className("cart_cancel_link"))
        private val finishButton = driver.findElement(By.className("cart_button"))

        fun finish(): CheckoutComplete {
            finishButton.click()
            return CheckoutComplete()
        }

        fun cancel(): InventoryPage {
            cancelButton.click()
            return InventoryPage(driver)
        }

    }

    inner class CheckoutComplete {
        val navbar = Navbar(driver)
    }

}
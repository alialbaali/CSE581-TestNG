package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

/**
 * [CheckoutPage] contains pages that represent the checkout process as steps.
 * */
class CheckoutPage(private val driver: WebDriver) {

    /**
     * Represents the first step of the [CheckoutPage].
     * In this step, the user can fill the form with checkout information.
     * */
    inner class CheckoutStep1 {

        val navbar = Navbar(driver)

        /**
         * Checkout form inputs.
         * */
        private val firstNameInput = driver.findElement(By.id("first-name"))
        private val lastNameInput = driver.findElement(By.id("last-name"))
        private val postalCodeInput = driver.findElement(By.id("postal-code"))

        /**
         * Checkout form actions.
         * */
        private val cancelButton = driver.findElement(By.className("cart_cancel_link"))
        private val checkoutButton = driver.findElement(By.className("cart_button"))


        /**
         * Fills checkout information inputs and proceed to the next step [CheckoutStep2].
         * @return [CheckoutStep2].
         * */
        fun continueToNextStep(firstName: String, lastName: String, postalCode: String): CheckoutStep2 {
            firstNameInput.sendKeys(firstName)
            lastNameInput.sendKeys(lastName)
            postalCodeInput.sendKeys(postalCode)
            checkoutButton.click()
            return CheckoutStep2()
        }

        /**
         * Cancels the current checkout operation and navigates back to the [ShoppingCartPage].
         * @return [ShoppingCartPage].
         * */
        fun cancel(): ShoppingCartPage {
            cancelButton.click()
            return ShoppingCartPage(driver)
        }

    }

    /**
     * Represents the second step of the [CheckoutPage].
     * In this step, the user is able to review the checkout information and
     * shopping cart items before fully checking out.
     * */
    inner class CheckoutStep2 {

        val navbar = Navbar(driver)

        /**
         * Checkout Information Actions.
         * */
        private val cancelButton = driver.findElement(By.className("cart_cancel_link"))
        private val finishButton = driver.findElement(By.className("cart_button"))

        /**
         * Finishes the current checkout and navigates to the [CheckoutComplete].
         * @return [CheckoutComplete].
         * */
        fun finish(): CheckoutComplete {
            finishButton.click()
            return CheckoutComplete()
        }

        /**
         * Cancels the current checkout and navigates back to the [InventoryPage].
         * @return [InventoryPage].
         * */
        fun cancel(): InventoryPage {
            cancelButton.click()
            return InventoryPage(driver)
        }

    }

    /**
     * Represents the final page after the checkout has finished.
     * Contains only the [Navbar].
     * */
    inner class CheckoutComplete {
        val navbar = Navbar(driver)
    }

}
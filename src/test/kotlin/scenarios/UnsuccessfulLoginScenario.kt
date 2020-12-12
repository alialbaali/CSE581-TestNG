package scenarios

import org.openqa.selenium.WebDriver
import org.testng.Assert
import org.testng.annotations.Test
import pages.LoginPage

class UnsuccessfulLoginScenario(private val driver: WebDriver) {

    @Test
    fun `wrong login info throws exception`() {

        Assert.assertThrows {
            LoginPage(driver)
                .login("UserName", "Password")
        }

    }

}
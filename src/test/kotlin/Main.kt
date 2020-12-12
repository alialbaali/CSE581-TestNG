import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver
import scenarios.ProblemUserScenario
import scenarios.SuccessfulPathScenario
import scenarios.UnsuccessfulLoginScenario
import java.util.concurrent.TimeUnit

const val DefaultPassword = "secret_sauce"
private const val DefaultUrl = "https://www.saucedemo.com/"

fun main() {

    val driver = setUpWebDriver().apply {
        manage()
            .window()
            .maximize()
        manage()
            .timeouts()
            .implicitlyWait(10, TimeUnit.SECONDS)
        get(DefaultUrl)
    }

    SuccessfulPathScenario(driver)
        .`successful login and checkout with 2 items in the shopping cart`()

    ProblemUserScenario(driver)
        .`image not clickable throws an exception`()

    UnsuccessfulLoginScenario(driver)
        .`wrong login info throws exception`()

}


private fun setUpWebDriver(): WebDriver {
    System.setProperty(
        "webdriver.gecko.driver",
        "[The Location of the Gecko(FireFox) Driver]\\geckodriver\\geckodriver.exe"
    )
    return FirefoxDriver()
}

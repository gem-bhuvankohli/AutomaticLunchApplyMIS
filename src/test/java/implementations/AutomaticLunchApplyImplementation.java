package implementations;

import locators.Locators;
import logger.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomaticLunchApplyImplementation {
    static WebDriver driver = new ChromeDriver();
    static boolean checkIfAdded = false;

    /**
     * Opens the application and logs in.
     */
    public static void openApplicationAndLogIn() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Locators.baseUrl);

        try {
            driver.manage().window().maximize();
            Thread.sleep(2500);

            WebElement loginViaSSO = driver.findElement(Locators.loginViaSSO);
            loginViaSSO.click();

            Log.info("Login Successful via SSO!\n\n\n");
            Thread.sleep(10000);
        } catch (Exception e) {
            Log.error("Error during login: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Selects the option to apply for lunch.
     */
    public static void selectToApplyForLunch() {
        try {
            WebElement applyDropdown = driver.findElement(Locators.applyDropdown);
            applyDropdown.click();

            WebElement lunchOption = driver.findElement(Locators.lunchOption);
            lunchOption.click();
        } catch (Exception e) {
            Log.error("Error while selecting lunch application: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Selects lunch dates and location for applying.
     */
    public static void selectLunchDatesAndLocation() {
        try {
            WebElement dateSelectDropdown = driver.findElement(Locators.dateSelectDropdown);
            dateSelectDropdown.click();

            WebElement selectAllOption = driver.findElement(Locators.selectAllOption);
            selectAllOption.click();

            WebElement locationDropdown = driver.findElement(Locators.locationDropdown);
            locationDropdown.click();

            // NOTE: Change location according to your own location
            WebElement cannanTowerOption = driver.findElement(Locators.cannanTowerOption);
            cannanTowerOption.click();
        } catch (Exception e) {
            Log.error("Error while selecting lunch dates and location: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Clicks the "Add" button for applying lunch.
     */
    public static void clickAddButton() {
        try {
            WebElement addButton = driver.findElement(Locators.addButton);
            addButton.click();
        } catch (Exception e) {
            Log.error("Error while clicking Add button: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    /**
     * Verifies if lunch has been applied successfully.
     */
    public static void verifyLunchAppliedSuccessfully() {
        try {
            WebElement okButton = driver.findElement(Locators.okButton);
            okButton.click();

            WebElement closeApplyWindow = driver.findElement(Locators.closeApplyWindow);
            closeApplyWindow.click();

            Log.info("Lunch Applied for all dates successfully!");
            checkIfAdded = true;
        } catch (Exception e) {
            WebElement closeApplyWindow = driver.findElement(By.xpath("//button[@id='btnCloseLunch']"));
            closeApplyWindow.click();

            if (checkIfAdded) {
                Log.info("Lunch has already been applied for all dates!");
            } else {
                Log.error("""
                        Script Encountered An Issue!

                        Kindly Re-run the script!

                        *Possible Reasons:
                        1. Slow compilation of script
                        2. Slow internet connection
                        Kindly check your system for the same and then re-run the script*""");
            }
        } finally {
            driver.close();
        }
    }
}

package org.gemini;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomaticLunchApply {
    public static void main(String[] args) {

//      Change web driver according to your browser. Here Chrome browser has been used.
        WebDriver driver = new ChromeDriver();

//      Accounting for delay in opening of webpages
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(Locators.baseUrl);

//      Checks whether lunch dates have been applied successfully
        boolean checkIfAdded = false;

        try {
//      Maximize window size
            driver.manage().window().maximize();


//      Static delay
            Thread.sleep(2500);

//      Selecting necessary elements and performing required actions on them

            WebElement loginViaSSO = driver.findElement(Locators.loginViaSSO);
            loginViaSSO.click();


            Log.info("Login Successful via SSO!\n\n\n");

//      Static delay
            Thread.sleep(10000);


            WebElement applyDropdown = driver.findElement(Locators.applyDropdown);
            applyDropdown.click();


            WebElement lunchOption = driver.findElement(Locators.lunchOption);
            lunchOption.click();


            WebElement dateSelectDropdown = driver.findElement(Locators.dateSelectDropdown);
            dateSelectDropdown.click();

            WebElement selectAllOption = driver.findElement(Locators.selectAllOption);

            selectAllOption.click();

            WebElement locationDropdown = driver.findElement(Locators.locationDropdown);
            locationDropdown.click();

//      NOTE: Change location according to your own location. Just change the XPath to that location option

            WebElement cannanTowerOption = driver.findElement(Locators.cannanTowerOption);
            cannanTowerOption.click();

            WebElement addButton = driver.findElement(Locators.addButton);
            addButton.click();
            checkIfAdded = true;

            WebElement okButton = driver.findElement(Locators.okButton);
            okButton.click();

            WebElement closeApplyWindow = driver.findElement(Locators.closeApplyWindow);
            closeApplyWindow.click();

//        **********************LUNCH APPLIED SUCCESSFULLY**********************

            Log.info("Lunch Applied for all dates successfully!");

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
                        1.Slow compilation of script
                        2.Slow internet connection
                        Kindly check your system for the same and then re-run the script*""");
            }
        }
        driver.close();
    }
}


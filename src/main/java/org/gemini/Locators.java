package org.gemini;

import org.openqa.selenium.By;

public class Locators {
    public static final String baseUrl = "https://mis.geminisolutions.com/";
    public static final By loginViaSSO = By.xpath("//button[@class='btn btn-rounded ssobtn']");
    public static final By applyDropdown = By.xpath("//span[@class='lbl']");
    public static final By lunchOption = By.xpath("//a[@id='applyForlunch']");

    public static final By dateSelectDropdown = By.xpath("//span[@class='multiselect-selected-text']");

    public static final By selectAllOption = By.xpath("//input[@value='multiselect-all']");

    public static final By locationDropdown = By.xpath("//span[@id='select2-location-container']");

    public static final By cannanTowerOption = By.xpath("(//li[@class='select2-results__option'])[2]");

    public static final By addButton = By.xpath("//button[@id='BtnsaveDateforLunch']");

    public static final By okButton = By.xpath("//button[@class='confirm btn btn-lg btn-primary']");

    public static final By closeApplyWindow = By.xpath("//button[@id='btnCloseLunch']");
}

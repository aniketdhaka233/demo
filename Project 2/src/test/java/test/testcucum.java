package test;

import helper.initialiser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class testcucum extends initialiser {
    WebDriver driver;
    public Properties prop = new Properties();

    {
        try {
            FileInputStream fs = new FileInputStream("/Users/aniketdhaka/IdeaProjects/Project 2/src/config/config.properties");
            prop.load(fs);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    Findproperties fp = new Findproperties();
    @Given("^Open Chrome and start Application$")
    public void openChromeAndStartApplication() {
        System.setProperty("webdriver.chrome.driver", "//Users//aniketdhaka//Downloads//chromedriver");
        driver = get().getDriver();
        driver.get("https://ems-qa-master.awsqa-gridpoint.com/login");
        //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MICROSECONDS);
    }

    @Then("I verify the login page")
    public void iVerifyTheLoginPage() {
        Boolean b1 = fp.getwebelement(prop.getProperty("GpLogo"),driver).isDisplayed();
        Assert.assertTrue(b1);
    }

    @When("^I enter a username and password$")
    public void iEnterAUsernameAndPassword() throws InterruptedException {
        fp.getwebelement(prop.getProperty("user_name"),driver).sendKeys("demoTestRpUser");
        driver.findElement(By.xpath("//*[@id=\"login\"]/div[3]/div[2]/div/form/div[4]")).click();
        Thread.sleep(4000);
        fp.getwebelement(prop.getProperty("password"),driver).sendKeys("P@ssword1!");
        driver.findElement(By.xpath("//*[@id=\"loginBtn\"]")).click();
    }

    @Then("I verify the we have succesfully logged in")
    public void iVerifyTheWeHaveSuccesfullyLoggedIn() throws InterruptedException {
        Thread.sleep(5000);
        Boolean b2 = fp.getwebelement(prop.getProperty("check_sites"),driver).isDisplayed() ;
        Assert.assertTrue(b2);

    }


    @Then("go to Configuration tab and verify template is visible")
    public void goToConfigurationTabAndVerifyTemplateIsVisible() throws InterruptedException{
       // driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MICROSECONDS);
        driver = get().getDriver();
        Thread.sleep(10000);
        fp.getwebelement(prop.getProperty("comm"),driver).click();
        Thread.sleep(5000);
        Assert.assertTrue(fp.getwebelement(prop.getProperty("temp"),driver).isDisplayed());
    }

    @Then("enter the site and select the site")
    public void enterTheSiteAndSelectTheSite() throws InterruptedException {
        Thread.sleep(10000);
        driver.findElement(By.id("siteSearchField")).sendKeys("TestRpSite");
        Thread.sleep(5000);
        fp.getwebelement(prop.getProperty("site_select"),driver).click();
        Thread.sleep(5000);
        fp.getwebelement(prop.getProperty("ec100"),driver).click();
        fp.getwebelement(prop.getProperty("select_button"),driver).click();
    }

    @Then("click on configuration module and click on use control config")
    public void clickOnConfigurationModuleAndClickOnUseControlConfig() throws InterruptedException{
        Thread.sleep(5000);
        fp.getwebelement(prop.getProperty("config_button"),driver).click();
        Thread.sleep(5000);
        driver.findElement(By.id("newButton")).click();
        Thread.sleep(5000);
    }

    @Then("Verify the Page by checking General Tab")
    public void verifyThePageByCheckingGeneralTab() {
        Assert.assertTrue(fp.getwebelement(prop.getProperty("general_tab"),driver).isDisplayed());
        driver.close();

    }
}



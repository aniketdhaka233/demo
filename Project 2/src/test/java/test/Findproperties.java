package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Findproperties {
    WebElement element;

    public WebElement getwebelement(String loc, WebDriver driver) {
        String[] strg= loc.split("===");
        if(strg[0].equals("xpath"))
        {
            element = driver.findElement(By.xpath(strg[1]));
        }
        else if(strg[0].equals("id")) {
            element = driver.findElement(By.id(strg[1]));
        }
        return element;
    }
}

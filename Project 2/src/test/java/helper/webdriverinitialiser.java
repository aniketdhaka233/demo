package helper;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;

public class webdriverinitialiser {
    private static WebDriver driver;
    private static webdriverinitialiser instance;

    private webdriverinitialiser()
    {
        if(driver == null)
            driver = initializeWebdriver();
    }

    WebDriver initializeWebdriver()
    {
        System.setProperty("webdriver.chrome.driver","//Users//aniketdhaka//Downloads//chromedriver");
        driver= new ChromeDriver();
        return driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static webdriverinitialiser getInstance(){
        if( null == instance)
        {
            return new webdriverinitialiser();
        }
        else
        {
            return instance;
        }

    }
}

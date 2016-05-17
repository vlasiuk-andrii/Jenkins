
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ParallelTest{

    public WebDriver driver;
    public String Node;
    protected ThreadLocal<RemoteWebDriver> threadDriver = null;
    String URL = "http://google.com";

    @Parameters("browser")
    @BeforeTest
    public void launchapp(String browser) throws MalformedURLException
    {

        if (browser.equalsIgnoreCase("firefox"))
        {
            System.out.println(" Executing on FireFox");
            Node = "http://10.17.178.179:5555/wd/hub";
            DesiredCapabilities cap = DesiredCapabilities.firefox();
            cap.setBrowserName("firefox");

            driver = new RemoteWebDriver(new URL(Node), cap);
        }
        else if (browser.equalsIgnoreCase("chrome"))
        {
            System.out.println(" Executing on CHROME");
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setBrowserName("chrome");
            Node = "http://10.17.178.179:5555/wd/hub";
            driver = new RemoteWebDriver(new URL(Node), cap);
        }
        else if (browser.equalsIgnoreCase("internet explorer"))
        {
            System.out.println(" Executing on IE");
            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setBrowserName("internet explorer");
            cap.setVersion("11");
            Node = "http://10.17.178.179:5555/wd/hub";
            driver = new RemoteWebDriver(new URL(Node), cap);
        }
        else
        {
            throw new IllegalArgumentException("The Browser Type is Undefined");
        }
    }

    @Test
    public void goToGoogle()
    {
        driver.navigate().to(URL);
    }
//m;jmml
    @AfterTest
    public void closeBrowser()
    {
        driver.quit();
    }
}
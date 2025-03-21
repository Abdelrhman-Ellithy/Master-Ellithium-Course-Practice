package Base;

import Ellithium.core.driver.DriverFactory;
import Ellithium.core.driver.HeadlessMode;
import Ellithium.core.driver.LocalDriverType;
import Ellithium.core.driver.PrivateMode;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTests{
    protected WebDriver driver;
    @BeforeClass
    public void setDriver(){
        driver= DriverFactory.getNewLocalDriver(LocalDriverType.Chrome, HeadlessMode.False, PrivateMode.False);
    }
    @AfterClass
    public void tareDown(){
        DriverFactory.quitDriver();
    }
}

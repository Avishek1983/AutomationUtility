package roy.java.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Properties;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Selenium {

    public static void main(String[] args) {

        FileUtility fileUtility = new FileUtility();
        System.out.println(fileUtility.getDataFiles());
        Properties prop = fileUtility.getProperties("global.properties");
        System.out.println(prop.getProperty("st_env"));
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(prop.getProperty("st_env"));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
        Actions actions = new Actions(webDriver);
        try {
            getScreenshot(webDriver,"/Users/avishek/Desktop/01_Selenium.png");
           // WebElement webDriverWait = new WebDriverWait(webDriver,Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.className("test")));
        }catch (Exception ex){

        }

        /*Wait<WebDriver> wait = new FluentWait<WebDriver>(webDriver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("foo"));
            }
        });*/



        webDriver.close();

    }

    public static void getScreenshot(WebDriver webDriver,String strPath) throws Exception{
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        File orgFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(orgFile,new File(strPath));
    }



}
class FileUtility {

    public Properties getProperties(String FileName){
        Properties properties = new Properties();
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String value = classLoader.getResource("").getPath();

        try{
            InputStream inputStream = classLoader.getResourceAsStream(FileName);
            properties.load(inputStream);
        }catch (Exception ex){
            ex.printStackTrace();
        }

        return properties;
    }
    public String getDataFiles(){
        String value = "";

        try(Stream<String> sString = Files.lines(Paths.get("/Users/avishek/Desktop/JavaCode/src/main/resources/SampleTextFiles.txt"))){
            value = sString.collect(Collectors.joining("\n"));

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return value ;
    }

}

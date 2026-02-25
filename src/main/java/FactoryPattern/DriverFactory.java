package FactoryPattern;

public class DriverFactory {

    public static BrowserDriver getDriver(String browserType){
        switch(browserType.toLowerCase()){
            case "chrome":
                return new ChromeDriverManager();
            case "firefox":
                return new FirefoxDriverManager();
            case "edge":
                return new EdgeDriverManager();
            case "safari":
                return new SafariDriverManager();
            default:
                throw new IllegalArgumentException("Invalid browser passed" + browserType);
        }

    }

    //Ι can do this also with a HashMap
    /*
     Map<String, Supplier<WebDriver>> driverMap = null;
     WebDriverFactory(){
     driverMap = new HashMap<>();
     driverMap.put("chrome",this::createChromeDriver());

     }
     private Supplier<WebDriver> createChromeDriver(){
        return new ChromeDriver();
     }
'





    */
}

// Script shows how to use selenium webdriver with chrome in SoapUI
/*
Pre-requisites:
•	SoapUI version 5+ 
•	Chrome and chromedriver latest version
•	https://www.seleniumhq.org/download  - download Selenium server and client and place it in your SoapUI home bin/ext folder (usually you find it in Program files/Smartbear/),
also download Selenium http runner and place it in SoapUI lib folder
•	https://jar-download.com/explore-java-source-code.php?a=selenium-chrome-driver&g=org.seleniumhq.selenium&v=3.4.0&downloadable=1 download and place this jar files in SoapUi home lib folder
•	https://jar-download.com/explore-java-source-code.php?a=guava&g=com.google.guava&v=23.0&downloadable=1
download and place this jar files in SoapUi home lib folder (remove previous version of guava 21)
*/
// Import necessary classes
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait
import java.net.Proxy
import java.net.ProxySelector

// It is neccessary to have these proxy settings
def selectDirectProxy(URI uri) {
  final List<Proxy> proxy = new ArrayList<Proxy>()
  proxy.add(Proxy.NO_PROXY)
  return proxy
}
// create a ProxySelector
ProxySelector proxySelector = [ select : { uri->selectDirectProxy(uri) } ] as ProxySelector
// set as default to avoid null pointer
ProxySelector.setDefault(proxySelector);

// Get the new driver
WebDriver driver=new ChromeDriver();
// Go to page
driver.get("http://google.com")

WebElement searchField = driver.findElement(By.name("q")); 
searchField.sendKeys("tesena");
searchField.submit();
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.Select;

public class CadastrarTipoAnuncioWebDriverJava {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080/WebMVCClassificadosWEB/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCadastrarTipoAnuncioWebDriverJava() throws Exception {
    driver.get(baseUrl + "/WebMVCClassificadosWEB/index.html");
    driver.findElement(By.xpath("//a[contains(text(),'Tipo \n      de Anúncio')]")).click();
    driver.findElement(By.id("idtipoanuncio")).clear();
    driver.findElement(By.id("idtipoanuncio")).sendKeys("324");
    driver.findElement(By.id("nometipoanuncio")).clear();
    driver.findElement(By.id("nometipoanuncio")).sendKeys("Filmes do NetFlix");
    driver.findElement(By.id("qtdpalavra")).clear();
    driver.findElement(By.id("qtdpalavra")).sendKeys("393");
    driver.findElement(By.name("Submit")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

package es.uniovi.asw;

import org.junit.*;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class SeleniumTest {


  private WebDriver driver;
  private String baseUrl;
  

  @Before
  public void run() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:8080";
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testIndex() throws Exception {
    driver.get(baseUrl + "/index.xhtml");
    //Compruebo que existe el boton "Entrar".
    assertFalse(driver.findElement(By.id("j_idt6:entrar"))==null);
    //Hago click en el botón.
    driver.findElement(By.id("j_idt6:entrar")).click();
    //Compruebo que se ha producido la navegación correctamente.
    assertTrue(textoPresentePagina(driver, "Opciones disponibles"));
  }
  
  @Test
  public void testResultadosReferendum() throws Exception {
    driver.get(baseUrl + "/referendum.xhtml");
    //Compruebo que esto en la página que le indico.
    assertTrue(textoPresentePagina(driver, "Resultados del Referendum"));
    assertTrue(textoPresentePagina(driver, "Opciones disponibles"));
  }
  
  public boolean textoPresentePagina(WebDriver driver, String texto)
	{
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + texto + "')]"));		
		return (list.size() > 0);
	}

  @After
  public void tearDown() throws Exception {
    driver.quit();
 
  }


}
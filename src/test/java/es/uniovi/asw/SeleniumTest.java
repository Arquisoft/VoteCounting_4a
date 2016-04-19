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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cucumber.api.cli.Main;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { Main.class })
public class SeleniumTest {

	private WebDriver driver;
	private String baseUrl;

	/**
	 * Metodo que se ejecuta antes de cada test, estableciendo el driver y url
	 * base adecuados.
	 * 
	 * @throws Exception
	 */
	@Before
	public void run() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "http://vote-counting-4a.herokuapp.com/";
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * Metodo para comprobar que la pagina de incio se carga adecuadamente y su
	 * boton actua de la misma manera.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testIndex() throws Exception {
		driver.get(baseUrl + "index.xhtml");
		esperar();
		// Compruebo que existe el boton "Entrar".
		assertFalse(driver.findElement(By.id("j_idt6:entrar")) == null);
		// Hago click en el botón.
		driver.findElement(By.id("j_idt6:entrar")).click();
		esperar();
		// Compruebo que se ha producido la navegación correctamente.
		assertTrue(textoPresentePagina(driver, "Opciones disponibles"));
	}

	/**
	 * Metodo para comprobar que la pagina principal se carga adecuadamente.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testResultadosReferendum() throws Exception {
		driver.get(baseUrl + "referendum.xhtml");
		esperar();
		// Compruebo que esto en la página que le indico.
		assertTrue(textoPresentePagina(driver, "Resultados del Referendum"));
		assertTrue(textoPresentePagina(driver, "Opciones disponibles"));
	}

	/**
	 * Metodo auxiliar que comprueba si una cadena de texto esta presente en la
	 * pagina o no.
	 * 
	 * @param driver
	 * @param texto
	 * @return True si encuentra la cadena de texto en la pagina, False en caso
	 *         contrario.
	 */
	public boolean textoPresentePagina(WebDriver driver, String texto) {
		List<WebElement> list = driver.findElements(By.xpath("//*[contains(text(),'" + texto + "')]"));
		return (list.size() > 0);
	}

	/**
	 * Metodo que se ejecuta siempre al finalizar un test, el cual cierra la
	 * ventana.
	 * 
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	/**
	 * Metodo auxiliar para dormir o parar la ejecucion 3 segundos.
	 * 
	 * @throws InterruptedException
	 */
	public void esperar() throws InterruptedException {
		Thread.sleep(3000);
	}
}
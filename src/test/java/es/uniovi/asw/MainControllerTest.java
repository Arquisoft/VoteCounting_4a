package es.uniovi.asw;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class MainControllerTest {

	@Autowired
	private WebApplicationContext context;

	private MockMvc mvc;

	/**
	 * Metodo que se ejecuta antes de cada test para incializar el objeto
	 * "imitador".
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	/**
	 * Metodo que comprueba el correcto lanzamiento y funcionamiento de la
	 * pagina index.xhtml.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testLanding() throws Exception {
		mvc.perform(get("/index.xhtml")).andExpect(status().isOk())
				.andExpect(content().string(containsString("Sistema de Conteo")));
	}

	/**
	 * Metodo que comprueba el correcto lanzamiento y funcionamiento de la
	 * pagina referendum.xhtml.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testReferendum() throws Exception {
		mvc.perform(get("/referendum.xhtml")).andExpect(status().isOk())
				.andExpect(content().string(containsString("Resultados del Referendum")));
	}

}
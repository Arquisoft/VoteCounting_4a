package es.uniovi.asw;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import es.uniovi.asw.model.Voto;

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

import es.uniovi.asw.persistence.repository.VotosRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class MainControllerTest {

  @Autowired
  private WebApplicationContext context;
  
  @Autowired
  private VotosRepository votoRepo;

  private MockMvc mvc;
  @Before
  public void setUp() throws Exception {
    mvc = MockMvcBuilders.webAppContextSetup(context).build();
  }

  @Test
  public void testLanding() throws Exception {
	  mvc.perform(get("/index.xhtml")).andExpect(status().isOk()).andExpect(content().string(containsString("Sistema de Conteo")));
  }
  @Test
  public void testReferendum() throws Exception {
	  mvc.perform(get("/referendum.xhtml")).andExpect(status().isOk()).andExpect(content().string(containsString("Resultados del Referendum")));
  }
  @Test
  public void testServicios() throws Exception {
	 List<Voto> votos = (List<Voto>) votoRepo.findAll();
	 assertEquals(85,votos.size());
  }

}
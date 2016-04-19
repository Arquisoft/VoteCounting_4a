package es.uniovi.asw;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.model.ColegioElectoral;
import es.uniovi.asw.model.Opcion;
import es.uniovi.asw.model.Votacion;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.persistence.repository.ColegiosElectoralesRepository;
import es.uniovi.asw.persistence.repository.OpcionesRepository;
import es.uniovi.asw.persistence.repository.VotacionesRepository;
import es.uniovi.asw.persistence.repository.VotosRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class RepoTest {

	@Autowired
	private VotosRepository votoRepo;
	@Autowired
	private VotacionesRepository votacionRepo;
	@Autowired
	private ColegiosElectoralesRepository colegioElectoralRepo;
	@Autowired
	private OpcionesRepository opcionRepo;

	@Test
	public void testVotos() throws Exception {
		List<Voto> votos = (List<Voto>) votoRepo.findAll();
		assertEquals(85, votos.size());
		List<Voto> votosNoLeidos = votoRepo.findByLeido(false);
		assertEquals(85, votosNoLeidos.size());
		List<Voto> votosLeidos = votoRepo.findByLeido(true);
		assertEquals(0, votosLeidos.size());
		List<Voto> votosColegio1 = votoRepo.findByColegioElectoral(colegioElectoralRepo.findById(1));
		assertEquals(7, votosColegio1.size());
		List<Voto> votosColegio2 = votoRepo.findByColegioElectoral(colegioElectoralRepo.findById(2));
		assertEquals(78, votosColegio2.size());
	}

	@Test
	public void testVotacion() throws Exception {
		Votacion votacion = votacionRepo.findByActiva(true);
		assertNotNull(votacion);
		votacion = votacionRepo.findByActiva(false);
		assertNull(votacion);
		List<Votacion> votaciones = (List<Votacion>) votacionRepo.findAll();
		assertEquals(1, votaciones.size());
		votacion = votacionRepo.findOne((long) 1);
		assertNotNull(votacion);
	}

	@Test
	public void testColegioElectoral() throws Exception {
		List<ColegioElectoral> colegios = (List<ColegioElectoral>) colegioElectoralRepo.findAll();
		assertEquals(2,colegios.size());
		ColegioElectoral colegio = colegioElectoralRepo.findById(1);
		assertEquals("Colegio electoral 1",colegio.getNombre());
		colegio = colegioElectoralRepo.findById(2);
		assertEquals("Colegio electoral 2",colegio.getNombre());
		colegio = colegioElectoralRepo.findOne((long) 1);
		assertNotNull(colegio);
	}

	@Test
	public void testOpcion() throws Exception {
		List<Opcion> opciones = (List<Opcion>) opcionRepo.findAll();
		assertEquals(3,opciones.size());
		opciones = opcionRepo.findByVotacion(votacionRepo.findByActiva(true));
		assertEquals(3,opciones.size());
		opciones = opcionRepo.findByVotacion(votacionRepo.findByActiva(false));
		assertEquals(0,opciones.size());
	}

}
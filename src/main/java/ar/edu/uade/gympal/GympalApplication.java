package ar.edu.uade.gympal;

import ar.edu.uade.gympal.model.trofeo.TrofeoConstancia;
import ar.edu.uade.gympal.repository.TrofeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = "ar.edu.uade.gympal")
@EntityScan(basePackages = "ar.edu.uade.gympal.model")
public class GympalApplication implements CommandLineRunner {

	@Autowired
	private TrofeoRepository trofeoRepository;

	public static void main(String[] args) {
		SpringApplication.run(GympalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Inserta un trofeo de prueba para verificar la conexión y creación de tablas
        TrofeoConstancia trofeo = new TrofeoConstancia();
        trofeo.setNombre("Trofeo Test");
		trofeoRepository.save(trofeo);

		// Imprime los datos guardados para confirmar que funciona
		System.out.println("Trofeo guardado: " + trofeoRepository.findAll());
	}
}

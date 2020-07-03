package ar.com.possumus.gestionempleado;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionEmpleadoApplication  implements CommandLineRunner {


	
	public static void main(String[] args) {
		SpringApplication.run(GestionEmpleadoApplication.class, args);
//		  SpringApplication.run(AccessingDataMysqlApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {}
	
}

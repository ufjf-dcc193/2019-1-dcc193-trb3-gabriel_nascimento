package br.dcc.trab3.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.dcc.trab3.demo.dao.UsuarioRepository;
import br.dcc.trab3.demo.model.Usuario;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	UsuarioRepository usuarios;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			usuarios.save(new Usuario(null, "Gabriel Nascimento", "DCC193", "Estudante de TI", "gabriel.nascimento@ice.ufjf.br"));
		};}

}

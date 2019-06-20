package br.dcc.trab3.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.dcc.trab3.demo.dao.EtiquetaRepository;
import br.dcc.trab3.demo.dao.UsuarioRepository;
import br.dcc.trab3.demo.dao.VinculosRepository;
import br.dcc.trab3.demo.model.Usuario;
import br.dcc.trab3.demo.model.Vinculo;
import br.dcc.trab3.demo.model.Etiqueta;


@SpringBootApplication
public class DemoApplication {

	@Autowired
	UsuarioRepository usuarios;

	@Autowired
	EtiquetaRepository etiquetas;

	@Autowired
	VinculosRepository vinculos;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			vinculos.save(new Vinculo());
			etiquetas.save(new Etiqueta(null, "Fisica 1", "Mecânica 1", "www.ufjf.br", vinculos.findAll().get(0)));
			usuarios.save(new Usuario(null, "Gabriel Nascimento", "DCC193", "Estudante de TI", "gabriel.nascimento@ice.ufjf.br"));
		};}

}

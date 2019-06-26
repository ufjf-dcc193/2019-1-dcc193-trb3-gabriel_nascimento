package br.dcc.trab3.demo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.dcc.trab3.demo.dao.EtiquetaRepository;
import br.dcc.trab3.demo.dao.ItemRepository;
import br.dcc.trab3.demo.dao.UsuarioRepository;
import br.dcc.trab3.demo.dao.VinculoRepository;
import br.dcc.trab3.demo.model.Usuario;
import br.dcc.trab3.demo.model.Vinculo;
import br.dcc.trab3.demo.model.Etiqueta;
import br.dcc.trab3.demo.model.Item;


@SpringBootApplication
public class DemoApplication {

	@Autowired
	UsuarioRepository usuarios;

	@Autowired
	EtiquetaRepository etiquetas;

	@Autowired
	VinculoRepository vinculos;

	@Autowired
	ItemRepository itens;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			itens.save(new Item("Item 1"));
			itens.save(new Item("Item 2"));
			vinculos.save(new Vinculo(itens.findById(1L).get(), itens.findById(2L).get()));
			etiquetas.save(new Etiqueta(null, "Fisica 1", "Mecânica 1", "www.ufjf.br"));
			usuarios.save(new Usuario(null, "admin", "admin","administrator", "admin@admin.com"));
			usuarios.save(new Usuario(null, "Gabriel Nascimento", "DCC193", "Estudante de TI", "gabriel.nascimento@ice.ufjf.br"));
		};}

}

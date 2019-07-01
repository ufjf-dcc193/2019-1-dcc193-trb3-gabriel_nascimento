package br.dcc.trab3.demo;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.dcc.trab3.demo.dao.AnotacaoRepository;
import br.dcc.trab3.demo.dao.EtiquetaRepository;
import br.dcc.trab3.demo.dao.ItemRepository;
import br.dcc.trab3.demo.dao.UsuarioRepository;
import br.dcc.trab3.demo.dao.VinculoRepository;
import br.dcc.trab3.demo.model.Usuario;
import br.dcc.trab3.demo.model.Vinculo;
import br.dcc.trab3.demo.model.Anotacao;
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

	@Autowired
	AnotacaoRepository anotacoes;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	InitializingBean sendDatabase() {
		return () -> {
			etiquetas.save(new Etiqueta(null, "Fisica 1", "Mecânica 1", "www.ufjf.br"));
			etiquetas.save(new Etiqueta(null, "Matematica", "Prob 1", "www.ufjf.br"));
			itens.save(new Item(null, "Item 1", etiquetas.findAll()));
			itens.save(new Item(null, "Item 2"));
			usuarios.save(new Usuario(null, "admin", "admin","administrador", "admin@admin.com"));
			usuarios.save(new Usuario(null, "Gabriel Nascimento", "DCC193", "Estudante de TI", "gabriel.nascimento@ice.ufjf.br"));
			anotacoes.save(new Anotacao(null, "resenha", "descricao", "google.com", "02/03/2018", "02/03/2019",  usuarios.findById(1L).get(), itens.findById(1L).get()));
			anotacoes.save(new Anotacao(null, "teste", "resumo", "dcc193.com", "02/03/2018", "12/03/2019",  usuarios.findById(2L).get(), itens.findById(2L).get()));			
			vinculos.save(new Vinculo(null, itens.findById(1L).get(), itens.findById(2L).get(), etiquetas.findAll()));
		};
	}

}

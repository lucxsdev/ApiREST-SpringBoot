package com.lucas.pdv.backend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackEndApplication implements CommandLineRunner{
	
	//@Autowired
	//private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		//Produto p1 = new Produto(null, "Lapizeira", 1.2, 70, 100, 50, "Unidade");
		//produtoRepository.saveAll(Arrays.asList(p1));
		
	}

}

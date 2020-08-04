package br.com.study.elasticsearch;

import br.com.study.elasticsearch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "br.com.study.elasticsearch.repository")
public class ElasticsearchApplication {

	@Autowired
	private PersonService personService;


	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchApplication.class, args);
	}

}

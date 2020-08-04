package br.com.study.elasticsearch.repository;

import br.com.study.elasticsearch.model.Person;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends ElasticsearchRepository<Person, String> {
    List<Person> findByName(String name);

    @Query("{\"bool\": {\n" +
            "            \"must\": [\n" +
            "                {\n" +
            "                    \"match\": {\n" +
            "                        \"name\": \"?0\"\n" +
            "                    }\n" +
            "                }\n" +
            "            ]\n" +
            "        }\n" +
            "    }")
    List<Person> findByNameCustomQuery(String name);
}

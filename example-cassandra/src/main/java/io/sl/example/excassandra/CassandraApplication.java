package io.sl.example.excassandra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class CassandraApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger(CassandraApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CassandraApplication.class, args);
		LOGGER.info("@@@@ DONE @@@@");
	}
}

/**
public class CassandraApplication {
	  private static final Logger LOGGER = LoggerFactory.getLogger(CassandraApplication.class);

	  protected static Person newPerson(String name, int age) {
	    return newPerson(UUID.randomUUID().toString(), name, age);
	  }

	  protected static Person newPerson(String id, String name, int age) {
	    return new Person(id, name, age);
	  }

	  public static void main(String[] args) {

//		    Cluster cluster = Cluster.builder().addContactPoints("176.34.157.212").withPort(9042).build();
	    Cluster cluster = Cluster.builder().addContactPoints("176.34.157.212").withPort(9042).build();
	    Session session = cluster.connect("example");

	    CassandraOperations template = new CassandraTemplate(session);

//	    Person jonDoe = template.insert(newPerson("Jon Doe", 40));
//
//	    LOGGER.info(template.selectOne(Query.query(Criteria.where("id").is(jonDoe.getId())), Person.class).getId());
//
//	    template.truncate(Person.class);
	    session.close();
	    cluster.close();
	  }
}
*/

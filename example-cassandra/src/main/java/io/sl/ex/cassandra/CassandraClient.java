package io.sl.ex.cassandra;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.driver.core.Session;

import io.sl.ex.cassandra.repository.KeyspaceRepository;

public class CassandraClient {

	private static final Logger LOG = LoggerFactory.getLogger(CassandraClient.class);
	private static final String SERVER_IP = "176.34.157.212";
	private static final String LIBRARY_KS = "library";

    public static void main(String args[]) {
        CassandraConnector connector = new CassandraConnector();
        connector.connect(SERVER_IP, null);
        Session session = connector.getSession();

        KeyspaceRepository sr = new KeyspaceRepository(session);
        sr.createKeyspace(LIBRARY_KS, "SimpleStrategy", 1);
        sr.useKeyspace(LIBRARY_KS);
        
        LOG.info("Keyspace '{}' was created", LIBRARY_KS);
//
//        BookRepository br = new BookRepository(session);
//        br.createTable();
//        br.alterTablebooks("publisher", "text");
//
//        br.createTableBooksByTitle();
//
//        Book book = new Book(UUIDs.timeBased(), "Effective Java", "Joshua Bloch", "Programming");
//        br.insertBookBatch(book);
//
//        br.selectAll().forEach(o -> LOG.info("Title in books: " + o.getTitle()));
//        br.selectAllBookByTitle().forEach(o -> LOG.info("Title in booksByTitle: " + o.getTitle()));
//
//        br.deletebookByTitle("Effective Java");
//        br.deleteTable("books");
//        br.deleteTable("booksByTitle");
//
        sr.deleteKeyspace(LIBRARY_KS);
        LOG.info("Keyspace '{}' was deleted", LIBRARY_KS);

        connector.close();
    }

}

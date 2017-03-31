/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConnectionTest;

import org.neo4j.driver.v1.*;
/**
 *
 * @author nikolai
 */
public class MainNeo4j {
        public static void main(String[] args) {
        Driver driver = GraphDatabase.driver( 
                "bolt://localhost:7687", 
                AuthTokens.basic( "neo4j", "class" ) );
        Session session = driver.session();

        // Run a query matching all nodes
        StatementResult result = session.run( 
                "MATCH (s)" +
                "RETURN s.name AS name, s.job AS job");

        while ( result.hasNext() ) {
            Record record = result.next();
            System.out.println( record.get("name").asString() );
        }

        session.close();
        driver.close();
    }
}

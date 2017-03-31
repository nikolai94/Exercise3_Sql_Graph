/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise_3_db;

import org.neo4j.driver.v1.*;
import static org.neo4j.driver.v1.Values.parameters;

public class QueriesCypher {

    private Driver driver;
    private Session session;

    public QueriesCypher() {
        driver = GraphDatabase.driver(
                "bolt://localhost:7687",
                AuthTokens.basic("neo4j", "class"));
        session = driver.session();

    }

    public Double findPersonEndorsesTaskA(String name) {
        StatementResult result = session.run("MATCH (a:Person)-[:ENDORSES]->(b:Person) WHERE a.name = {name} "
                + "RETURN  b.name as name",
                parameters("name", name));
        while ( result.hasNext() ) {
            Record record = result.next();
            System.out.println(record.get("name").asString());
        }
        
        return 0.0;
    }

    public Double findPersonEndorsesTaskB(String name) {
        StatementResult result = session.run("MATCH (a:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(b:Person) WHERE a.name = {name} "
                    + "RETURN DISTINCT b.name as name",
                parameters("name", name));
        while ( result.hasNext() ) {
            Record record = result.next();
            System.out.println(record.get("name").asString());
        }   
        return 0.0;
    }

    public Double findPersonEndorsesTaskC(String name) {
        StatementResult result = session.run("MATCH (a:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(b:Person) WHERE a.name = {name} "
                + "RETURN DISTINCT b.name as name",
                parameters("name", name));
        while ( result.hasNext() ) {
            Record record = result.next();
            System.out.println(record.get("name").asString());
        }   
        return 0.0;
    }
    
    public Double findPersonEndorsesTaskD(String name) {
        StatementResult result = session.run("MATCH (a:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(:Person)-[:ENDORSES]->(b:Person) WHERE a.name = {name} "
                + "RETURN DISTINCT b.name as name",
                parameters("name", name));
         while ( result.hasNext() ) {
            Record record = result.next();
            System.out.println(record.get("name").asString());
        }   
        return 0.0;
    }

    public void closeConnection() {
        session.close();
        driver.close();
    }
}

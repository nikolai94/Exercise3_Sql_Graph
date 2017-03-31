/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise_3_db;

import org.neo4j.driver.v1.*;

import java.util.ArrayList;
import java.util.List;

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

    public long findPersonEndorsesTaskA(String name) {
        StatementResult result = session.run("MATCH (a:Person)-[:ENDORSES]->(b:Person) WHERE a.name = {name} "
                        + "RETURN  b.name as name",
                parameters("name", name));

        long before = System.currentTimeMillis();
        while (result.hasNext()) {
            Record record = result.next();
            record.get("name").asString();
        }
        long after = System.currentTimeMillis();
        return (after - before);
    }

    public long findPersonEndorsesTaskB(String name) {
        StatementResult result = session.run("MATCH (a:Person)-[:ENDORSES*..2]->(b:Person) WHERE a.name = {name} "
                        + "RETURN DISTINCT b.name as name",
                parameters("name", name));

        long before = System.currentTimeMillis();
        while (result.hasNext()) {
            Record record = result.next();
            record.get("name").asString();
        }
        long after = System.currentTimeMillis();
        return (after - before);
    }

    public long findPersonEndorsesTaskC(String name) {
        StatementResult result = session.run("MATCH (a:Person)-[:ENDORSES*..3]->(b:Person) WHERE a.name = {name} "
                        + "RETURN DISTINCT b.name as name",
                parameters("name", name));

        long before = System.currentTimeMillis();
        while (result.hasNext()) {
            Record record = result.next();
            record.get("name").asString();
        }
        long after = System.currentTimeMillis();
        return (after - before);
    }

    public long findPersonEndorsesTaskD(String name) {
        long startTime = System.nanoTime();
        StatementResult result = session.run("MATCH (a:Person)-[:ENDORSES*..4]->(b:Person) WHERE a.name = {name} "
                        + "RETURN DISTINCT b.name as name",
                parameters("name", name));

        long before = System.currentTimeMillis();
        while (result.hasNext()) {
            Record record = result.next();
            record.get("name").asString();
        }
        long after = System.currentTimeMillis();
        return (after - before);
    }

    public void closeConnection() {
        session.close();
        driver.close();
    }
}
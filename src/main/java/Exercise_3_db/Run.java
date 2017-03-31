/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise_3_db;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.StatementResult;

/**
 *
 * @author nikolai
 */
public class Run {
    public static void main(String[] args) {
        QueriesCypher queriesNeo = new QueriesCypher();
        
        //A
        //StatementResult endorsesTask = queriesNeo.findPersonEndorsesTaskA("Gayla Brase");
        
        //B
        //StatementResult endorsesTask = queriesNeo.findPersonEndorsesTaskB("Gayla Brase");
        
        //C
        //StatementResult endorsesTask = queriesNeo.findPersonEndorsesTaskC("Gayla Brase");
        
        //D
        /*StatementResult endorsesTask = queriesNeo.findPersonEndorsesTaskD("Gayla Brase");
        
        while ( endorsesTask.hasNext() ) {
            Record record = endorsesTask.next();
            System.out.println(record.get("name").asString());
        }
        
        queriesNeo.closeConnection();
        */
        
        //MYSQL
        
        QueriesMysql queriesMysql = new QueriesMysql();
        
        try {
            queriesMysql.findPersonEndorsesTaskA("Gayla Brase");
        } catch (SQLException ex) {
            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}

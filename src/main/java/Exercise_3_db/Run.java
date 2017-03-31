/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise_3_db;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.StatementResult;

/**
 *
 * @author nikolai
 */
public class Run {

    public static void main(String[] args) throws SQLException {

        //MYSQL
       /* QueriesMysql queriesMysql = new QueriesMysql();
        
        ArrayList<String> arr = queriesMysql.get20RandomUsersName();
        double time = 0;
        int count = 0;
        double result =0;
        for (String row : arr) {
            result = queriesMysql.findPersonEndorsesTaskE(row);
            System.out.println(result);
            time += result;
            if(count == 9)
                System.out.println("Median: "+result);
            count++;
        }
        
        System.out.println("Average: "+ (time/arr.size()+1) );
        */
       
       QueriesMysql queriesMysql = new QueriesMysql();
        QueriesCypher queriesNeo = new QueriesCypher();

        ArrayList<String> names = queriesMysql.get20RandomUsersName();

        ArrayList<Long> times = new ArrayList();

        for (String name: names) {
            times.add(queriesNeo.findPersonEndorsesTaskD(name));
        }

        for (long time: times) {
            System.out.println(time);
        }

        averageResult(times);


//        //A
//        Double personEndorsesTaskA = queriesNeo.findPersonEndorsesTaskA("Gayla Brase");
//        System.out.println("personEndorsesTaskA " + personEndorsesTaskA);
//
////      //B
//        Double personEndorsesTaskB = queriesNeo.findPersonEndorsesTaskB("Gayla Brase");
//        System.out.println("personEndorsesTaskB " + personEndorsesTaskB);
//
////        //C
//        Double personEndorsesTaskC = queriesNeo.findPersonEndorsesTaskC("Gayla Brase");
//        System.out.println("personEndorsesTaskC " + personEndorsesTaskC);
//
////        //D
//        Double personEndorsesTaskD = queriesNeo.findPersonEndorsesTaskD("Gayla Brase");
//        System.out.println("personEndorsesTaskD " + personEndorsesTaskD);

        queriesNeo.closeConnection();


        //MYSQL

//        QueriesMysql queriesMysql = new QueriesMysql();
//
//        try {
//            queriesMysql.findPersonEndorsesTaskA("Gayla Brase");
//        } catch (SQLException ex) {
//            Logger.getLogger(Run.class.getName()).log(Level.SEVERE, null, ex);
//        }
   
    }
    private static void averageResult(List<Long> times) {
        long sum = 0;
        for (Long time : times) {sum += time;}
        long avg = sum / times.size();
        System.out.println("Avg:" + avg);
    }
}

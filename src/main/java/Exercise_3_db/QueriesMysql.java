/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise_3_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueriesMysql {

    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    private String url;
    private String user;
    private String password;
    long startTime, stopTime;
    double elapsedTime;

    public QueriesMysql() {
        con = null;
        st = null;
        rs = null;

        url = "jdbc:mysql://localhost:3306/social_network_db?autoReconnect=true&useSSL=false";
        user = "root";
        password = "pwd";
    }

    public double findPersonEndorsesTaskA(String name) throws SQLException {

        String query = "SELECT DISTINCT testb.name FROM social_network_db.t_user"
                + "  LEFT JOIN t_endorses AS testa ON testa.source_node_id = t_user.id"
                + "  LEFT JOIN t_user AS testb ON testa.target_node_id = testb.id"
                + "  WHERE t_user.name = ?";

        startTime = System.currentTimeMillis();
        ResultSet rsFromQ = getQuery(query, name, true);

        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        /* while (rsFromQ.next()) {
            System.out.println(rsFromQ.getString(1));
        }*/
        closeConnection();
        return elapsedTime;
    }

    public double findPersonEndorsesTaskB(String name) throws SQLException {
        String query = "SELECT DISTINCT t_user_2.name FROM social_network_db.t_user\n"
                + "LEFT JOIN t_endorses AS t_endorses_1 ON t_endorses_1.source_node_id = t_user.id\n"
                + "LEFT JOIN t_user AS t_user_1 ON t_endorses_1.target_node_id = t_user_1.id\n"
                + "LEFT JOIN t_endorses AS t_endorses_2 ON t_endorses_2.source_node_id = t_user_1.id\n"
                + "LEFT JOIN t_user AS t_user_2 ON t_endorses_2.target_node_id = t_user_2.id\n"
                + "WHERE t_user.name = ?";
        startTime = System.currentTimeMillis();
        ResultSet rsFromQ = getQuery(query, name, true);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;
        /*while (rsFromQ.next()) {
            System.out.println(rsFromQ.getString(1));
        }*/
        closeConnection();
        return elapsedTime;
    }

    public double findPersonEndorsesTaskC(String name) throws SQLException {
        String query = "SELECT DISTINCT t_user_3.name FROM social_network_db.t_user\n"
                + "LEFT JOIN t_endorses AS t_endorses_1 ON t_endorses_1.source_node_id = t_user.id\n"
                + "LEFT JOIN t_user AS t_user_1 ON t_endorses_1.target_node_id = t_user_1.id\n"
                + "LEFT JOIN t_endorses AS t_endorses_2 ON t_endorses_2.source_node_id = t_user_1.id\n"
                + "LEFT JOIN t_user AS t_user_2 ON t_endorses_2.target_node_id = t_user_2.id\n"
                + "LEFT JOIN t_endorses AS t_endorses_3 ON t_endorses_3.source_node_id = t_user_2.id\n"
                + "LEFT JOIN t_user AS t_user_3 ON t_endorses_3.target_node_id = t_user_3.id\n"
                + "WHERE t_user.name = ?";
        startTime = System.currentTimeMillis();
        ResultSet rsFromQ = getQuery(query, name, true);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;

        /*while (rsFromQ.next()) {
            System.out.println(rsFromQ.getString(1));
        }*/
        closeConnection();
        return elapsedTime;
    }

    public double findPersonEndorsesTaskD(String name) throws SQLException {
        String query = "SELECT DISTINCT t_user_4.name FROM social_network_db.t_user\n"
                + "LEFT JOIN t_endorses AS t_endorses_1 ON t_endorses_1.source_node_id = t_user.id\n"
                + "LEFT JOIN t_user AS t_user_1 ON t_endorses_1.target_node_id = t_user_1.id\n"
                + "LEFT JOIN t_endorses AS t_endorses_2 ON t_endorses_2.source_node_id = t_user_1.id\n"
                + "LEFT JOIN t_user AS t_user_2 ON t_endorses_2.target_node_id = t_user_2.id\n"
                + "LEFT JOIN t_endorses AS t_endorses_3 ON t_endorses_3.source_node_id = t_user_2.id\n"
                + "LEFT JOIN t_user AS t_user_3 ON t_endorses_3.target_node_id = t_user_3.id\n"
                + "LEFT JOIN t_endorses AS t_endorses_4 ON t_endorses_4.source_node_id = t_user_3.id\n"
                + "LEFT JOIN t_user AS t_user_4 ON t_endorses_4.target_node_id = t_user_4.id\n"
                + "WHERE t_user.name = ?";
        startTime = System.currentTimeMillis();
        ResultSet rsFromQ = getQuery(query, name, true);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;


        /*  while (rsFromQ.next()) {
            System.out.println(rsFromQ.getString(1));
        }*/
        closeConnection();
        return elapsedTime;
    }

    public double findPersonEndorsesTaskE(String name) throws SQLException {
        String query = "SELECT DISTINCT t_user_5.name FROM social_network_db.t_user\n"
                + "LEFT JOIN t_endorses AS t_endorses_1 ON t_endorses_1.source_node_id = t_user.id\n"
                + "LEFT JOIN t_user AS t_user_1 ON t_endorses_1.target_node_id = t_user_1.id\n"
                + "LEFT JOIN t_endorses AS t_endorses_2 ON t_endorses_2.source_node_id = t_user_1.id\n"
                + "LEFT JOIN t_user AS t_user_2 ON t_endorses_2.target_node_id = t_user_2.id\n"
                + "LEFT JOIN t_endorses AS t_endorses_3 ON t_endorses_3.source_node_id = t_user_2.id\n"
                + "LEFT JOIN t_user AS t_user_3 ON t_endorses_3.target_node_id = t_user_3.id\n"
                + "LEFT JOIN t_endorses AS t_endorses_4 ON t_endorses_4.source_node_id = t_user_3.id\n"
                + "LEFT JOIN t_user AS t_user_4 ON t_endorses_4.target_node_id = t_user_4.id\n"
                + "LEFT JOIN t_endorses AS t_endorses_5 ON t_endorses_5.source_node_id = t_user_4.id\n"
                + "LEFT JOIN t_user AS t_user_5 ON t_endorses_5.target_node_id = t_user_5.id\n"
                + "WHERE t_user.name = ?";
        startTime = System.currentTimeMillis();
        ResultSet rsFromQ = getQuery(query, name, true);
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;

        /* while (rsFromQ.next()) {
            System.out.println(rsFromQ.getString(1));
        }*/
        closeConnection();
        return elapsedTime;
    }
    
    public ArrayList<String> get20RandomUsersName(){
        String query = "SELECT name FROM t_user ORDER BY RAND() LIMIT 20";
        ResultSet rsFromQ = getQuery(query, null, false);
        ArrayList<String> arrNames = new ArrayList<String>();
        try {
            while (rsFromQ.next()) {
                arrNames.add(rsFromQ.getString(1));
                //System.out.println(rsFromQ.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(QueriesMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        closeConnection();
        return arrNames;
    }

    private ResultSet getQuery(String query, String parmName, boolean isFindEndorses) {

        try {
            con = DriverManager.getConnection(url, user, password);
            
            st = con.prepareStatement(query);
            if(isFindEndorses)
                st.setString(1, parmName);
            rs = st.executeQuery();

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
            return null;
        }
        return rs;
    }

    private void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            System.err.println(ex);
        }
    }
}

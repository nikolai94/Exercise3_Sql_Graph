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

public class QueriesMysql {

    private Connection con;
    private PreparedStatement st;
    private ResultSet rs;

    private String url;
    private String user;
    private String password;

    public QueriesMysql() {
        con = null;
        st = null;
        rs = null;

        url = "jdbc:mysql://localhost:3306/social_network_db";
        user = "root";
        password = "pwd";
    }

    public double findPersonEndorsesTaskA(String name) throws SQLException {
        /*String query = "SELECT name FROM social_network_db.t_endorses "
                + "INNER JOIN t_user ON t_endorses.target_node_id = t_user.id"
                + "WHERE t_user.name";*/
 /*String query = "SELECT t_user.name FROM social_network_db.t_endorses "
                + "INNER JOIN t_user ON t_endorses.target_node_id = t_user.id"
                + "WHERE t_user.name = ?";*/
 /*String query = "SELECT t_user.name FROM social_network_db.t_user"
                + "INNER JOIN t_endorses ON t_endorses.target_node_id = t_user.id"
                + "WHERE t_user.name = ?";*/
        String query = "SELECT DISTINCT testb.name FROM social_network_db.t_user"
                + "  LEFT JOIN t_endorses AS testa ON testa.source_node_id = t_user.id"
                + "  LEFT JOIN t_user AS testb ON testa.target_node_id = testb.id"
                + "  WHERE t_user.name = ?";
        ResultSet rsFromQ = getQuery(query, name);


        while (rsFromQ.next()) {
            System.out.println(rsFromQ.getString(1));
        }
        closeConnection();
        return 0;
    }

    private ResultSet getQuery(String query, String parmName) {

        try {

            con = DriverManager.getConnection(url, user, password);

            //st = con.createStatement();
            st = con.prepareStatement(query);
            st.setString(1, parmName);
            rs = st.executeQuery(query);

//            if (rs.next()) {
//                System.out.println(rs.getInt(1));
//            }
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

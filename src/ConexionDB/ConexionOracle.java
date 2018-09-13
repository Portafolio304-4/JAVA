/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexionDB;

import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleResultSet;

/**
 *
 * @author Bena
 */
public class ConexionOracle {
    private String driver = "oracle.jdbc.OracleDriver";
    private String url = "jdbc:oracle:thin:@localhost:1521:XE";
    private String user = "admin";
    private String pwd = "12345";
    Connection conn = null;
    
    public Connection connect() {
        try {
            Class.forName(driver).newInstance();
            this.conn = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            e.printStackTrace();
        }
        return this.conn;
    }
    
    public OracleResultSet execute_query(String query) throws SQLException{
        this.connect();
        
        OraclePreparedStatement pst = null;
        OracleResultSet rs = null;
        System.out.println(query);
        pst = (OraclePreparedStatement) this.conn.prepareStatement(query);
        rs = (OracleResultSet) pst.executeQuery();
        System.out.println(rs);
        return rs;
 
    }
}

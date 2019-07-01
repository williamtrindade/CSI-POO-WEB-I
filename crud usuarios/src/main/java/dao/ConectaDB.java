/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mathe
 */
public class ConectaDB {
    
    public static Connection getConexao() throws ClassNotFoundException {
	Connection conexao = null;
        try {
                Class.forName("org.postgresql.Driver");
                String url ="jdbc:postgresql://localhost:5432/db_programacao_web";
                String user="postgres";
                String password = "";
                conexao = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conexao;
    }
    
}

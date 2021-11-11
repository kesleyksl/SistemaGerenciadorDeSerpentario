package models.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Rodrigo
 */
public class Conexao {

    public static Connection conectar() {
        Connection con = null;
        String url = "postgres://qilvwikuphbqeq:13134288709e017e18a5b46e5a546081d2371ee46c67f2ec3252e749b4d7abb5@ec2-50-19-176-236.compute-1.amazonaws.com:5432/da8sasln08evl6";
        String user = "qilvwikuphbqeq";
        String password = "13134288709e017e18a5b46e5a546081d2371ee46c67f2ec3252e749b4d7abb5";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Erro ao conectar con o banco");
        }
        return con;
    }
}

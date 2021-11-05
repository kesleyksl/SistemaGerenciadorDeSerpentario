/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Pessoa {

    private Integer id;
    private String nomeCompleto;
    private String usuario;
    private String senha;
    private int tipoUser;

    public Pessoa() {
    }

    public Pessoa(String nomeCompleto, String usuario, String senha, int tipoUser) {
        this.nomeCompleto = nomeCompleto;
        this.usuario = usuario;
        this.senha = senha;
        this.tipoUser = tipoUser;
    }

    public Pessoa(Integer id, String nomeCompleto, String usuario, String senha, int tipoUser) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.usuario = usuario;
        this.senha = senha;
        this.tipoUser = tipoUser;
    }

    public Pessoa consultarById(int id) {
        ResultSet rs = null;
        Pessoa pessoa = null;
        try {
            String sql = "select * from Funcionario where id = ? ";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                pessoa = new Pessoa(
                        rs.getString("nomeCompleto"),
                        rs.getString("usuario"),
                        rs.getString("senha"),
                        rs.getInt("tipoUser"));
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return pessoa;
    }
    
       public boolean salvar() {
        try {
            Connection con = Conexao.conectar();
            String sql;
            if (this.id == null) {
     
               sql = "INSERT INTO funcionario(nomecompleto, usuario, senha, tipouser) VALUES (?, ?, ?, ?)";
                
                PreparedStatement stm = con.prepareStatement(sql);
                stm.setString(1, this.nomeCompleto);
                stm.setString(2, this.usuario);
                stm.setString(3, this.senha);
                stm.setInt(4, this.tipoUser);
                stm.execute();
                return true;
            } else {
                sql = "UPDATE Funcionario SET nomeCompleto = '" + this.nomeCompleto
                        + "', usuario = '" + this.usuario
                        + "', senha = " + this.senha
                        + ", tipouser = " + this.tipoUser;

                PreparedStatement stm = con.prepareStatement(sql);
                stm.execute();
                return true;
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(int tipoUser) {
        this.tipoUser = tipoUser;
    }
    
       
       
}

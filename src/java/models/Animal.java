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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class Animal {

    private Integer idSerpente;
    private String codigo;
    private double peso;
    private double comprimento;
    private String especie;
    private boolean alimentacao;
    private double pesoAlimento;
    private int fkFuncionario;

    public Animal() {
    }

    public Animal(String codigo, double peso, double comprimento, String especie, boolean alimentacao, double pesoAlimento, int fkFuncionario) {
        this.codigo = codigo;
        this.peso = peso;
        this.comprimento = comprimento;
        this.especie = especie;
        this.alimentacao = alimentacao;
        this.pesoAlimento = pesoAlimento;
        this.fkFuncionario = fkFuncionario;
    }

    public Animal consultarById(int id) {
        ResultSet rs = null;
        Animal cobra = null;
        try {
            String sql = "select * from serpentes where id = ?";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                cobra = new Animal(
                        rs.getString("codigo"),
                        rs.getDouble("peso"),
                        rs.getInt("comprimento"),
                        rs.getString("especie"),
                        rs.getBoolean("alimentacao"),
                        rs.getDouble("pesoAlimento"),
                        rs.getInt("fkFuncionario"));
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return cobra;
    }

    public boolean salvar() {
        try {
            Connection con = Conexao.conectar();
            String sql;

            sql = "INSERT INTO serpentes(codigo, peso, comprimento, especie, pesoalimento, alimentacao, idfuncionario)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.codigo);
            stm.setDouble(2, this.peso);
            stm.setDouble(3, this.comprimento);
            stm.setString(4, this.especie);
            stm.setDouble(5, this.pesoAlimento);
            stm.setBoolean(6, this.alimentacao);
            stm.setInt(7, this.fkFuncionario);
            stm.execute();
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public boolean excluir() {
        try {
            Connection con = Conexao.conectar();
            String sql = "DELETE FROM serpentes WHERE id = " + this.idSerpente;
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public List<Animal> consultar(String filtro) {

        ResultSet rs = null;
        List<Animal> lista = new ArrayList<>();

        try {
            String sql;

            sql = "select * from serpentes where especie like '%" + filtro + "%'";

            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                lista.add(new Animal(
                        rs.getString("codigo"),
                        rs.getDouble("peso"),
                        rs.getInt("comprimento"),
                        rs.getString("especie"),
                        rs.getBoolean("alimentacao"),
                        rs.getDouble("pesoalimento"),
                        rs.getInt("idfuncionario")
                ));
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return lista;
    }

    public boolean editar() {
        try {

            Connection con = Conexao.conectar();
            String sql;

            sql = "UPDATE serpentes SET codigo= '" + this.codigo + "', peso= " + this.peso + ", comprimento= " + this.comprimento + ", especie= '" + this.especie
                    + "', pesoalimento= " + this.pesoAlimento + ", alimentacao= " + this.alimentacao + ", idfuncionario= " + this.fkFuncionario + "  WHERE id = " + this.idSerpente;

            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public Integer getIdSerpente() {
        return idSerpente;
    }

    public void setIdSerpente(Integer idSerpente) {
        this.idSerpente = idSerpente;
    }

    public int getFkFuncionario() {
        return fkFuncionario;
    }

    public void setFkFuncionario(int fkFuncionario) {
        this.fkFuncionario = fkFuncionario;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public boolean isAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(boolean alimentacao) {
        this.alimentacao = alimentacao;
    }

    public double getPesoAlimento() {
        return pesoAlimento;
    }

    public void setPesoAlimento(double pesoAlimento) {
        this.pesoAlimento = pesoAlimento;
    }

}

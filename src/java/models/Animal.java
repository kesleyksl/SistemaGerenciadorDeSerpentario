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

/**
 *
 * @author Rodrigo
 */
public class Animal {

    private Integer idSerpente;
    private int fkFuncionario;
    private String codigo;
    private double peso;
    private double comprimento;
    private String especie;
    private boolean alimentacao;
    private double pesoAlimento;

    public Animal() {
    }

    public Animal(int fkFuncionario, String codigo, double peso, double comprimento, String especie, boolean alimentacao, double pesoAlimento) {
        this.fkFuncionario = fkFuncionario;
        this.codigo = codigo;
        this.peso = peso;
        this.comprimento = comprimento;
        this.especie = especie;
        this.alimentacao = alimentacao;
        this.pesoAlimento = pesoAlimento;
    }

    public Animal(int idSerpente, int fkFuncionario, String codigo, double peso, double comprimento, String especie, boolean alimentacao, double pesoAlimento) {
        this.idSerpente = idSerpente;
        this.fkFuncionario = fkFuncionario;
        this.codigo = codigo;
        this.peso = peso;
        this.comprimento = comprimento;
        this.especie = especie;
        this.alimentacao = alimentacao;
        this.pesoAlimento = pesoAlimento;
    }

    public Animal consultarById(int id) {
        ResultSet rs = null;
        Animal cobra = null;
        try {
            String sql = "select * from serpentes"
                    + " where id = ? ";
            Connection con = Conexao.conectar();
            PreparedStatement stm = con.prepareStatement(sql);
            stm.setInt(1, id);
            rs = stm.executeQuery();
            if (rs.next()) {
                cobra = new Animal(
                        rs.getInt("codigo"),
                        rs.getInt("fkFuncionario"),
                        rs.getString("codigo"),
                        rs.getDouble("peso"),
                        rs.getInt("comprimento"),
                        rs.getString("especie"),
                        rs.getBoolean("alimentacao"),
                        rs.getDouble("pesoAlimento"));
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
            if (this.idSerpente == null) {
                                
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
            } else {
                sql = "UPDATE serpentes SET codigo = '" + this.codigo
                        + "', peso = '" + this.peso
                        + "', comprimento = " + this.comprimento
                        + ", especie = " + this.especie
                        + ", alimentacao = " + this.alimentacao
                        + ", pesoalimento = " + this.pesoAlimento
                        + ", idfuncionario = " + this.fkFuncionario
                        + " where id = " + this.idSerpente;

                PreparedStatement stm = con.prepareStatement(sql);
                stm.execute();
                return true;
            }

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

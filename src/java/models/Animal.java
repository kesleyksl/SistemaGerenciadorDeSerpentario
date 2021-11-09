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

    private int idSerpente;
    private int fkFuncionario;
    private String codigo;
    private double peso;
    private Double comprimento;
    private String especie;
    private String alimentacao;
    private double pesoAlimento;
    private String sexo;
    private String ecdise;
    private String observacao;

    private List<Animal> lista = new ArrayList<>();
    private String filtro = "";

    public Animal() {
    }

    public Animal(int fkFuncionario, String codigo, double peso, Double comprimento, String especie, String alimentacao, double pesoAlimento, String sexo, String ecdise, String observacao) {
        this.fkFuncionario = fkFuncionario;
        this.codigo = codigo;
        this.peso = peso;
        this.comprimento = comprimento;
        this.especie = especie;
        this.alimentacao = alimentacao;
        this.pesoAlimento = pesoAlimento;
        this.sexo = sexo;
        this.ecdise = ecdise;
        this.observacao = observacao;
    }

    public Animal(int idSerpente, int fkFuncionario, String codigo, double peso, Double comprimento, String especie, String alimentacao, double pesoAlimento, String sext, String ecdise, String observacao) {
        this.idSerpente = idSerpente;
        this.fkFuncionario = fkFuncionario;
        this.codigo = codigo;
        this.peso = peso;
        this.comprimento = comprimento;
        this.especie = especie;
        this.alimentacao = alimentacao;
        this.pesoAlimento = pesoAlimento;
        this.sexo = sext;
        this.ecdise = ecdise;
        this.observacao = observacao;
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
                        rs.getInt("idfuncionario"),
                        rs.getString("codigo"),
                        rs.getDouble("peso"),
                        rs.getDouble("comprimento"),
                        rs.getString("especie"),
                        rs.getString("alimentacao"),
                        rs.getDouble("pesoalimento"),
                        rs.getString("sexo"),
                        rs.getString("ecdise"),
                        rs.getString("observacvao"));
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

            sql = "INSERT INTO serpentes(codigo, peso, comprimento, especie, pesoalimento, alimentacao, sexo, ecdise, observacao, idfuncionario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, this.codigo);
            stm.setDouble(2, this.peso);
            stm.setDouble(3, this.comprimento);
            stm.setString(4, this.especie);
            stm.setDouble(5, this.pesoAlimento);
            stm.setString(6, this.alimentacao);
            stm.setString(7, this.sexo);
            stm.setString(8, this.ecdise);
            stm.setString(9, this.observacao);
            stm.setInt(10, this.fkFuncionario);
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
                        rs.getInt("idfuncionario"),
                        rs.getString("codigo"),
                        rs.getDouble("peso"),
                        rs.getDouble("comprimento"),
                        rs.getString("especie"),
                        rs.getString("alimentacao"),
                        rs.getDouble("pesoalimento"),
                        rs.getString("sexo"),
                        rs.getString("ecdise"),
                        rs.getString("observacvao")
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
                    + "', pesoalimento= " + this.pesoAlimento + ", alimentacao= " + this.alimentacao + ", sexo= '"+this.sexo+"', ecdise='"+this.ecdise+
                    "', observacao='"+this.observacao+"', idfuncionario= " + this.fkFuncionario + "  WHERE id = " + this.idSerpente;
            
            PreparedStatement stm = con.prepareStatement(sql);
            stm.execute();
            return true;
        } catch (SQLException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }

    public int getIdSerpente() {
        return idSerpente;
    }

    public void setIdSerpente(int idSerpente) {
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

    public String getAlimentacao() {
        return alimentacao;
    }

    public void setAlimentacao(String alimentacao) {
        this.alimentacao = alimentacao;
    }

    public double getPesoAlimento() {
        return pesoAlimento;
    }

    public void setPesoAlimento(double pesoAlimento) {
        this.pesoAlimento = pesoAlimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sext) {
        this.sexo = sext;
    }

    public String getEcdise() {
        return ecdise;
    }

    public void setEcdise(String ecdise) {
        this.ecdise = ecdise;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public List<Animal> getLista() {
        return lista;
    }

    public void setLista(List<Animal> lista) {
        this.lista = lista;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

}

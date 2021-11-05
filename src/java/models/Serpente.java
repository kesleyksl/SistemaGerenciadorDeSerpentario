package models;

import java.io.Serializable;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;


public class Serpente implements Serializable {

    private static final long serialVersionUID = 1L;

    private long codigo;
    private double peso;
    private double comprimento;
    private String especie;
    private boolean alimentacao;
    private double pesoAlimento;
    private DateTime data;

    public Serpente() {
    }

    public Serpente(double peso, double comprimento, String especie, boolean alimentacao, double pesoAlimento, DateTime data) {
        this.peso = peso;
        this.comprimento = comprimento;
        this.especie = especie;
        this.alimentacao = alimentacao;
        this.pesoAlimento = pesoAlimento;
        this.data = data;
    }
    
    public Serpente(int codigo, double peso, double comprimento, String especie, boolean alimentacao, double pesoAlimento) {
        this.codigo = codigo;
        this.peso = peso;
        this.comprimento = comprimento;
        this.especie = especie;
        this.alimentacao = alimentacao;
        this.pesoAlimento = pesoAlimento;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getComprimento() {
        return comprimento;
    }

    public void setComprimento(double comprimento) {
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

    public DateTime getData() {
        return data;
    }

    public void setData(DateTime data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Serpente{" + "codigo=" + codigo + ", peso=" + peso + ", comprimento=" + comprimento + ", especie=" + especie + ", alimentacao=" + alimentacao + ", pesoAlimento=" + pesoAlimento + ", data=" + data + '}';
    }

}

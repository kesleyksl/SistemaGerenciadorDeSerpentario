package beans;

import models.Animal;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Rodrigo
 */
@ManagedBean
@SessionScoped
public class BeanSerpente {

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

    private Animal animal = new Animal();

    // Metodos aqui
    public void consultarById(int id) {
        Animal cobra = new Animal();
        cobra = cobra.consultarById(id);
        idSerpente = cobra.getIdSerpente();
        fkFuncionario = cobra.getFkFuncionario();
        codigo = cobra.getCodigo();
        peso = cobra.getPeso();
        comprimento = cobra.getComprimento();
        especie = cobra.getEspecie();
        alimentacao = cobra.getAlimentacao();
        pesoAlimento = cobra.getPesoAlimento();
    }

    public void salvar() {
        FacesContext view = FacesContext.getCurrentInstance();
        FacesMessage msg = null;

        if (animal.getCodigo() == null) {
            msg = new FacesMessage("Informe o codigo da serpente!");
            view.addMessage(null, msg);
        }

        if (animal.getFkFuncionario() == 0) {
            msg = new FacesMessage("Informe o funcionario que realizou o cadastro!");
            view.addMessage(null, msg);
        }

        if (animal.getEspecie() == null) {
            msg = new FacesMessage("Informe a espécie da serpente!");
            view.addMessage(null, msg);
        }

        if (msg == null) {
            if (animal.salvar()) {
                try {
                    animal = new Animal();
                    msg = new FacesMessage("Serpente salva com sucesso");
                    view.addMessage(null, msg);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("menu.jsf");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void Excluir(Animal animal) {
        try {
            if (animal.excluir()) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("menu.jsf");
                lista = null;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void Editar(Animal animal) {
        try {
            this.animal = animal;
            FacesContext.getCurrentInstance().getExternalContext().redirect("EditarSerpente.jsf");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void editarSerp() {

        FacesContext view = FacesContext.getCurrentInstance();
        FacesMessage msg = null;

        if (animal.editar()) {
            try {
                animal = new Animal();
                msg = new FacesMessage("Serpente editada com sucesso");
                view.addMessage(null, msg);
                FacesContext.getCurrentInstance().getExternalContext().redirect("menu.jsf");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void consultar() {
        lista = new Animal().consultar(especie);
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

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

}

package beans;

import models.Pessoa;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import models.Funcionario;

@ManagedBean
@SessionScoped

public class BeanFuncionario {

    private String nomeCompleto;
    private String usuario;
    private String senha;
    private int tipoUser;
    private List<Pessoa> lista = new ArrayList<>();
    private String filtro = "";

    private Pessoa pessoa = new Pessoa();
    private Funcionario funcionario = new Funcionario();

    // Metodos aqui
    public void consultarById(int id) {
        Pessoa person = new Pessoa();
        person = person.consultarById(id);
        nomeCompleto = person.getNomeCompleto();
        usuario = person.getUsuario();
        senha = person.getSenha();
        tipoUser = person.getTipoUser();
    }

    public void salvar() {
        FacesContext view = FacesContext.getCurrentInstance();
        FacesMessage msg = null;

        if (pessoa.getNomeCompleto() == null) {
            msg = new FacesMessage("Informe o nome completo!");
            view.addMessage(null, msg);
        }

        if (pessoa.getUsuario() == null) {
            msg = new FacesMessage("Informe o usuario!");
            view.addMessage(null, msg);
        }

        if (msg == null) {
            if (pessoa.salvar()) {
                try {
                    pessoa = new Pessoa();
                    msg = new FacesMessage("Funcionario salvo com sucesso");
                    view.addMessage(null, msg);
                    FacesContext.getCurrentInstance().getExternalContext().redirect("menu.jsf");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public void editaFunc() {

        FacesContext view = FacesContext.getCurrentInstance();
        FacesMessage msg = null;

        if (pessoa.editar()) {
            try {
                pessoa = new Pessoa();
                msg = new FacesMessage("Funcionario editado com sucesso");
                view.addMessage(null, msg);
                FacesContext.getCurrentInstance().getExternalContext().redirect("menu.jsf");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void Editar(Pessoa pessoa) {
        try {
            this.pessoa = pessoa;
            FacesContext.getCurrentInstance().getExternalContext().redirect("EditarFuncionario.jsf");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void Excluir(Pessoa pessoa) {
        try {
            if (pessoa.excluir()) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("menu.jsf");
                lista = null;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void consultar() {
        lista = new Pessoa().consultar(nomeCompleto);
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

    public List<Pessoa> getLista() {
        return lista;
    }

    public void setLista(List<Pessoa> lista) {
        this.lista = lista;
    }

    public String getFiltro() {
        return filtro;
    }

    public void setFiltro(String filtro) {
        this.filtro = filtro;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

}

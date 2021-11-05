package models;

import java.io.Serializable;

public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String nomeCompleto;
    private String usuario;
    private String senha;
    private int tipoUser; 

    public Funcionario() {
    }

    public Funcionario(String nomeCompleto, String usuario, String senha, int tipoUser) {
        this.nomeCompleto = nomeCompleto;
        this.usuario = usuario;
        this.senha = senha;
        this.tipoUser = tipoUser;
    }

    public Funcionario(long id, String nomeCompleto, String usuario, String senha, int tipoUser) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.usuario = usuario;
        this.senha = senha;
        this.tipoUser = tipoUser;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Funcionario{id=").append(id);
        sb.append(", nomeCompleto=").append(nomeCompleto);
        sb.append(", usuario=").append(usuario);
        sb.append(", senha=").append(senha);
        sb.append(", tipoUser=").append(tipoUser);
        sb.append('}');
        return sb.toString();
    }
 
    
    
}

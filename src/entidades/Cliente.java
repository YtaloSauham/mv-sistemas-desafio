package entidades;

import java.io.Serializable;

public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idCliente;
    private String nome;
    private String sobrenome;
    private String razaoSocial;
    private String nomeFantasia;

    private String telefone;
    private Integer tipoCliente;


    public Cliente() {
    }

    public Cliente(Integer idCliente, String nome, String sobrenome, String razaoSocial, String nomeFantasia,  String telefone, Integer tipoCliente) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.razaoSocial = razaoSocial;
        this.nomeFantasia = nomeFantasia;

        this.telefone = telefone;
        this.tipoCliente = tipoCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Integer getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(Integer tipoCliente) {
        if (tipoCliente != null) {
            this.tipoCliente = tipoCliente;
        }
    }


}

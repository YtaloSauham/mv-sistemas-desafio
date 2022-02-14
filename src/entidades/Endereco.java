package entidades;

import java.io.Serializable;

public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idEndereco ;
    private String cep;
    private String bairro;
    private String uf;
    private String cidade;
    private Integer casa;

    public Endereco(Integer idEndereco, String cep, String bairro, String uf, String cidade, Integer casa) {
        this.idEndereco = idEndereco;
        this.cep = cep;
        this.bairro = bairro;
        this.uf = uf;
        this.cidade = cidade;
        this.casa = casa;
    }

    public Endereco() {

    }

    public Integer getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(Integer idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Integer getCasa() {
        return casa;
    }

    public void setCasa(Integer casa) {
        this.casa = casa;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cep == null) ? 0 : cep.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Endereco other = (Endereco) obj;
        if (cep == null) {
            if (other.cep != null)
                return false;
        } else if (!cep.equals(other.cep))
            return false;
        return true;
    }
}

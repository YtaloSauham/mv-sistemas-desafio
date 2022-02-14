package entidades;

import java.io.Serializable;

public class Movimentacao implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer idMovimentacao;
    private Double valor;
    private String descricao;
    private Conta conta;

    public Movimentacao(Integer idMovimentacao, Double valor, String descricao, Conta conta) {
        this.idMovimentacao = idMovimentacao;
        this.valor = valor;
        this.descricao = descricao;
        this.conta = conta;
    }


    public Integer getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idMovimentacao == null) ? 0 : idMovimentacao.hashCode());
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
         Movimentacao other = (Movimentacao) obj;
        if (idMovimentacao== null) {
            if (other.idMovimentacao != null)
                return false;
        } else if (!idMovimentacao.equals(other.idMovimentacao))
            return false;
        return true;
    }



}

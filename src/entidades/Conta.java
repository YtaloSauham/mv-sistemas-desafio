package entidades;

import java.io.Serializable;

public class Conta implements Serializable{
    private static final long serialVersionUID = 1L;

    private Integer numeroConta;
    private Double saldoAtual;
    private Cliente cliente;
    private String tipoConta;

    public Conta() {
    }

    public Conta(Integer numeroConta, Double saldoAtual, Cliente cliente, String tipoConta) {
        this.numeroConta = numeroConta;
        this.saldoAtual = saldoAtual;
        this.cliente = cliente;
        this.tipoConta = tipoConta;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Double getSaldoAtual() {
        return saldoAtual;
    }

    public void setSaldoAtual(Double saldoAtual) {
        this.saldoAtual = saldoAtual;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numeroConta == null) ? 0 : numeroConta.hashCode());
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
        Conta other = (Conta) obj;
        if (numeroConta == null) {
            if (other.numeroConta != null)
                return false;
        } else if (!numeroConta.equals(other.numeroConta))
            return false;
        return true;
    }
}

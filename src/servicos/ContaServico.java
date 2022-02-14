package servicos;

import persistencia.pkConta;
import entidades.Conta;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaServico {
    private pkConta conta = new pkConta();

    public Conta buscarConta(Integer numeroConta) {
        try {
            return setarObjeto(conta.buscarConta(numeroConta));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void cadastrarConta(Conta c) {

        conta.cadastrarConta(c);

    }

    public Boolean transacao(Conta c, Double valor, String tipo_movimento) {
        return conta.operacao(c, valor, tipo_movimento);
    }

    private Conta setarObjeto(ResultSet rs) throws SQLException {
        Conta conta = new Conta();
        while (rs.next()) {
            conta.setNumeroConta(rs.getInt("numero"));
            conta.setSaldoAtual(rs.getDouble("saldo_atual"));
            conta.setCliente((new ClienteServico()).buscarCliente(rs.getInt("cliente")));
        }
        return conta;
    }

}

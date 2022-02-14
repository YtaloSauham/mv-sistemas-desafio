package persistencia;

import entidades.Conta;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;

public class pkConta {

    OracleCallableStatement pr = null;
    Connection conn = new Conexao().getConnection();


    public ResultSet buscarConta(Integer numeroConta) {

        try {
            pr = (OracleCallableStatement) conn.prepareCall("BEGIN DEV.PCK_CONTA.BUSCARCONTA(:1, :2); END;");

            pr.registerOutParameter(2, OracleTypes.CURSOR);

            pr.setInt(1, numeroConta);

            pr.execute();

            return pr.getCursor(2);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar conta: " + e.getMessage());
        }
    }

    public Boolean cadastrarConta(Conta conta) {

        try {
            pr = (OracleCallableStatement) conn
                    .prepareCall("BEGIN DEV.PCK_CONTA.ADICIONARCONTA(:1, :2, :3, :4); END;");

            pr.setInt(1, conta.getNumeroConta());
            pr.setBigDecimal(2, new BigDecimal(conta.getSaldoAtual()));
            pr.setBigDecimal(3, new BigDecimal(conta.getCliente().getIdCliente()));
            pr.setString(4, conta.getTipoConta());

            return pr.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar conta: " + e.getMessage());
        }

    }

    public Boolean operacao(Conta conta, Double valor, String tipo_operacao) {

        try {
            pr = (OracleCallableStatement) conn.prepareCall("BEGIN DEV.PCK_CONTA.OPERACAO(:1, :2, :3); END;");

            pr.setInt(1, conta.getNumeroConta());
            pr.setBigDecimal(2, new BigDecimal(valor));
            pr.setString(3,tipo_operacao);

            return pr.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao fazer operacao: " + e.getMessage());
        }

    }

}

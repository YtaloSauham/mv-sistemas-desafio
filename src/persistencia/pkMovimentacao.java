package persistencia;

import entidades.Movimentacao;
import java.sql.Connection;


import oracle.jdbc.OracleCallableStatement;

public class pkMovimentacao {

    public Boolean salvarMovimentacao(Movimentacao movimentacao) {

        OracleCallableStatement pr = null;
        Connection conn = new Conexao().getConnection();

        try {
            pr = (OracleCallableStatement) conn
                    .prepareCall("BEGIN DEV.PCK_MOVIMENTACAO.SALVARMOVIMENTACAO(:1, :2, :3,:4); END;");

            pr.setInt(1, movimentacao.getIdMovimentacao());
            pr.setDouble(2, movimentacao.getValor());
            pr.setString(3, movimentacao.getDescricao());
            pr.setInt(4, movimentacao.getConta().getNumeroConta());

            return pr.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar: " + e.getMessage());
        }

    }
}

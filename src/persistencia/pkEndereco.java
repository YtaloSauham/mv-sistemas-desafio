package persistencia;

import entidades.Endereco;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class pkEndereco {

    public boolean cadastrarEndereco(Endereco endereco) {

        OracleCallableStatement pr = null;
        Connection conn = new Conexao().getConnection();

        try {
            pr = (OracleCallableStatement) conn
                    .prepareCall("BEGIN DEV.PCK_ENDERECO.ADICIONARENDERECO(:1, :2, :3, :4, :5, :6); END;");


            pr.setInt(1, endereco.getIdEndereco());
            pr.setString(2, endereco.getCep());
            pr.setString(3, endereco.getBairro());
            pr.setString(4, endereco.getUf());
            pr.setString(5, endereco.getCidade());
            pr.setInt(6, endereco.getCasa());

            return  pr.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar: " + e.getMessage());
        }

    }
    public boolean atualizarEndereco(Endereco endereco) {

        OracleCallableStatement pr = null;
        Connection conn = new Conexao().getConnection();

        try {
            pr = (OracleCallableStatement) conn
                    .prepareCall("BEGIN DEV.PCK_ENDERECO.ATUALIZARENDERECO(:1, :2, :3, :4, :5, :6); END;");


            pr.setInt(1, endereco.getIdEndereco());
            pr.setString(2, endereco.getCep());
            pr.setString(3, endereco.getBairro());
            pr.setString(4, endereco.getUf());
            pr.setString(5, endereco.getCidade());
            pr.setInt(6, endereco.getCasa());

            return  pr.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar endereco: " + e.getMessage());
        }

    }

    public Endereco buscarEndereco(Integer id_endereco) {
        OracleCallableStatement params = null;
        Connection conn = new Conexao().getConnection();

        try {
            params = (OracleCallableStatement) conn.prepareCall("BEGIN DEV.PCK_ENDERECO.BUSCARENDERECO(:1, :2); END;");

            params.registerOutParameter(2, OracleTypes.CURSOR);

            params.setInt(1, id_endereco);

            params.execute();

            return setarObjeto(params.getCursor(2));

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar endereco: " + e.getMessage());
        }
    }

    private Endereco setarObjeto(ResultSet rs) throws SQLException {
        Endereco endereco = new Endereco();
        while (rs.next()) {
            endereco.setIdEndereco(rs.getInt("id_endereco"));
            endereco.setCep(rs.getString("cep"));
            endereco.setBairro(rs.getString("bairro"));
            endereco.setUf(rs.getString("uf"));
            endereco.setCidade(rs.getString("cidade"));
            endereco.setCasa(rs.getInt("casa"));

        }
        return endereco;
    }
}

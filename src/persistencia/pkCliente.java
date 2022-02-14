package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;

import groovy.transform.Internal;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import entidades.Cliente;

public class pkCliente {

    OracleCallableStatement pr = null;
    Connection conn = new Conexao().getConnection();

    public ResultSet buscarCliente(Integer id) {

        try {
            pr= (OracleCallableStatement) conn
                    .prepareCall("BEGIN DEV.PCK_CLIENTE.BUSCARCLIENTE(:1, :2) END;");
            pr.registerOutParameter(2, OracleTypes.CURSOR);
            pr.setInt(1, id);
            pr.execute();
            return pr.getCursor(2);

        } catch (Exception e) {
            throw new RuntimeException("Erro ao Deletar: " + e.getMessage());
        }
    }

    public Boolean cadastrarCliente(Cliente cliente) {
        try {
            pr= (OracleCallableStatement) conn
                    .prepareCall("BEGIN DEV.PCK_CLIENTE.SALVARCLIENTE(:1, :2, :3, :4, :5); END;");

            pr.setInt(1, cliente.getIdCliente());
            pr.setString(2,
                    (cliente.getTipoCliente() == 1 ? cliente.getNome() : cliente.getRazaoSocial()));
            pr.setString(3,
                    (cliente.getTipoCliente() == 1 ? cliente.getSobrenome() : cliente.getNomeFantasia()));
            pr.setString(4, cliente.getTelefone());
            pr.setInt(5, cliente.getTipoCliente());

            return pr.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar: " + e.getMessage());
        }
    }

    public Boolean deletarCliente(Cliente cliente) {
        try {
            pr= (OracleCallableStatement) conn
                    .prepareCall("BEGIN DEV.PCK_CLIENTE.DELETECLIENTE(:1); END;");
            pr.setInt(1, cliente.getIdCliente());
            return pr.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao Deletar: " + e.getMessage());
        }
    }


    public Boolean atualizarCliente(Cliente cliente) {
        try {
            pr= (OracleCallableStatement) conn
                    .prepareCall("BEGIN DEV.PCK_CLIENTE.ATUALIZARCLIENTE(:1,:2,:3,:4,:5); END;");

            pr.setInt(1, cliente.getIdCliente());
            pr.setString(2,
                    (cliente.getTipoCliente() == 1 ? cliente.getNome() : cliente.getRazaoSocial()));
            pr.setString(3,
                    (cliente.getTipoCliente() == 1 ? cliente.getSobrenome() : cliente.getNomeFantasia()));
            pr.setString(4, cliente.getTelefone());
            pr.setInt(5, cliente.getTipoCliente());
            return pr.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao Deletar: " + e.getMessage());
        }
    }






}

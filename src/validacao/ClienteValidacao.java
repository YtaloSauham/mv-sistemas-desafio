package validacao;
import entidades.Cliente;

import java.sql.SQLException;

public class ClienteValidacao {

    public Boolean validacao(Cliente cliente) {
        try {
            if (cliente.getIdCliente() == null || cliente.getIdCliente() == 0) {
                throw new RuntimeException("Informe um CPF ou um CNPJ para cadastrar!");
            }

            if (!cliente.getTelefone().isEmpty() && (cliente.getTelefone().length() < 8 || cliente.getTelefone().length() > 9)) {
                throw new RuntimeException("Informe um número de telefone entre 8 e 9 dígitos");
            }

            return true;

        } catch (Error e) {
            throw new RuntimeException("Erro" + e.getMessage());


        }

    }




    }

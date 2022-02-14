package servicos;


import entidades.Endereco;
import persistencia.pkCliente;
import validacao.ClienteValidacao;
import entidades.Cliente;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteServico {

    private pkCliente PKcliente = new pkCliente();

    private Endereco endereco;

    private ClienteValidacao val= new ClienteValidacao();

    public void cadastrarCliente(Cliente c)
    {
        if(val.validacao(c) == true){
            PKcliente.cadastrarCliente(c);
            System.out.println("Cadastro com sucesso!");
        }
        else {
            System.out.println("Erro no cadastro!");

        }

    }

    public Cliente buscarCliente(Integer id) {
        ResultSet rs = PKcliente.buscarCliente(id);
        try {
            Cliente cliente = new Cliente();
            while (rs.next()) {
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setTipoCliente(rs.getInt("tipo_cliente"));
                cliente.setTelefone(rs.getString("telefone"));

                if (cliente.getTipoCliente() == 1) {
                    cliente.setNome(rs.getString("razaoSocial"));
                    cliente.setSobrenome(rs.getString("nomeFantasia"));
                } else {
                    cliente.setRazaoSocial(rs.getString("nomeRazao"));
                    cliente.setNomeFantasia(rs.getString("nomeFantasia"));
                }
            }

            return cliente;
        } catch (SQLException e) {
            throw new RuntimeException("Erro: " + e.getMessage());
        }
    }

    public void deletarCliente(Cliente d)
    {
        PKcliente.deletarCliente(d);
    }

    public void atualizarCLiente(Cliente a)
    {
        PKcliente.atualizarCliente(a);
    }




}



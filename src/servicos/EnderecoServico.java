package servicos;
import entidades.Endereco;
import groovy.transform.Internal;
import persistencia.pkEndereco;

public class EnderecoServico {
    private pkEndereco PKendereco = new pkEndereco();

    public Endereco buscarEndereco(Integer id_endereco)
    {
        return PKendereco.buscarEndereco(id_endereco);
    }

    public boolean cadastrarEndereco( Endereco endereco)
    {
        return PKendereco.cadastrarEndereco(endereco);
    }

    public boolean atualizarEndereco (Endereco endereco)
    {
        return PKendereco.atualizarEndereco(endereco);
    }



}

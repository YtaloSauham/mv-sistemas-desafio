import controle.RelatorioControle;
import entidades.Cliente;
import entidades.Conta;
import entidades.Endereco;
import entidades.Movimentacao;
import servicos.ClienteServico;
import servicos.ContaServico;
import servicos.EnderecoServico;
import servicos.MovimentacaoServico;
import controle.RelatorioControle;
public class AppTest {

    public static void main(String[] args) {

        RelatorioControle relatorioControle = new RelatorioControle();
        EnderecoServico enderecoServico = new EnderecoServico();
        ClienteServico clienteServico = new ClienteServico();
        ContaServico contaServico = new ContaServico();
        MovimentacaoServico movimentacaoServico = new MovimentacaoServico();

        Endereco endereco = new Endereco(2,"5555","COHATRAC","MA","SAO LUIS",8);

        enderecoServico.cadastrarEndereco(endereco);

        Cliente cliente1 = new Cliente(2,"Ytalo","Sauham"," "," ","9999",1);

        clienteServico.cadastrarCliente(cliente1);

        Conta conta1 = new Conta(2,80.00,cliente1,"Deposito");

        contaServico.cadastrarConta(conta1);

        Movimentacao movimentacao1 = new Movimentacao(1,80.00,"DEPOSITO",conta1);

        movimentacaoServico.salvarMovimentacao(movimentacao1);

        relatorioControle.gerarRelatorio(cliente1);

    }

}

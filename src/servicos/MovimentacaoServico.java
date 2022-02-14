package servicos;

import entidades.Movimentacao;
import persistencia.pkConta;
import persistencia.pkMovimentacao;

public class MovimentacaoServico {

    private pkMovimentacao PKmovimentacao = new pkMovimentacao();

    public boolean salvarMovimentacao(Movimentacao movimentacao){
        return PKmovimentacao.salvarMovimentacao(movimentacao);
    }
}

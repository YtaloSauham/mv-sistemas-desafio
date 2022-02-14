create or replace package dev.pck_movimentacao is

procedure salvarMovimentacao(p_id in int,
                            p_valor in int,
                            p_descricao in varchar2,
                            p_conta in int)

end;

create or replace package body dev.pck_movimentacao is

procedure salvarMovimentacao(p_id in int,
                             p_valor in int,
                      p_descricao in varchar2,
                      p_conta in int) is

  begin
    insert into MOVIMENTACAO
      (id,valor, descricao, conta)
    values
      (p_id,p_valor, p_descricao, p_conta);
  end;

end;
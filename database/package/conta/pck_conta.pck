create or replace package dev.pck_conta is

 type tCursor is ref cursor;

 procedure buscarConta(p_numero in int, p_result out tCursor);

  procedure adicionarConta(p_numero in int, p_saldo_atual in int,
                            p_cliente in int, p_tipo in varchar2);


   procedure operacao(p_numero in int,p_valor in int,
                                        p_operacao in int);
  end;


  create or replace package body dev.pck_conta is

    procedure buscarConta(p_numero in int,
                          p_result out tCursor) is
      begin
        open p_result for
         select en.numero ,
                en.saldo_atual ,
                en.cliente,
                en.tipo_conta
                from conta en
                where en.numero = p_numero;

      end;


      procedure adicionarConta(p_numero in int, p_saldo_atual in int,
                                                  p_cliente in int,
                                                  p_tipo in varchar2)
        is

        begin

              insert into CONTA(numero,saldo_atual,cliente,tipo_conta)
              values (p_numero, p_saldo_atual, p_cliente,p_tipo ) ;

              end;



             procedure operacao(p_numero in int,p_valor in int,
                                  p_operacao in int)
                is

                 v_saldo_atual    number(10, 2);
                  v_saldo_anterior number(10, 2);

                  begin

                   begin
                    select c.saldo_atual
                      into v_saldo_atual
                      from conta c
                     where c.numero = p_numero;
                  end;

                   if (p_operacao = 1) then
                    v_saldo_anterior := v_saldo_atual;
                    v_saldo_atual    := v_saldo_atual + p_valor;
                  else
                    v_saldo_anterior := v_saldo_atual;
                    v_saldo_atual    := v_saldo_atual - p_valor;
                  end if;

                  begin
                    update conta en
                    set en.saldo_atual = v_saldo_atual
                    where en.numero = p_numero;
                  end;

                  commit;


                      end;

      end;

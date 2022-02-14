create or replace package dev.pck_cliente is

type tCursor is ref cursor;

procedure buscarCliente(p_id_cliente in int,p_result  out tCursor) ;


procedure salvarCliente(p_id                 in int,
                          p_nomeRazao         in varchar2,
                          p_sobrenomeFantasia in varchar2,
                          p_telefone          in varchar2,
                          p_tipoCliente       in int);

  procedure atualizarCliente(p_id   in int, p_nomeRazao         in varchar2,
                            p_sobrenomeFantasia in varchar2,
                            p_telefone          in varchar2,
                            p_tipoCliente       in int) ;


   PROCEDURE deleteCliente(p_id_cliente in int) ;


   end;

   create or replace package body dev.pck_cliente is


    procedure buscarCliente(p_id_cliente in int,resposta out tCursor) is
        v_id                int;
        v_nomeRazao         varchar2(100);
        v_sobrenomeFantasia varchar2(100);
        v_telefone          varchar2(9);
        v_tipo_cliente       int;


    begin
        begin
            select tipo_cliente into v_tipo_cliente from cliente where id_cliente = p_id_cliente;
            end;
        begin
          if (v_tipo_cliente = 1) then
            select p.nome, p.sobrenome
              into v_nomeRazao, v_sobrenomeFantasia
              from cliente_pf p
             where p.cpf = p_id_cliente;

          else
            select p.razaosocial, p.nomefantasia
              into v_nomeRazao, v_sobrenomeFantasia
              from cliente_pj p
             where p.cnpj = p_id_cliente;
          end if;
        end;
           open resposta for
          select v_id_cliente        as id_cliente,
                 v_nomeRazao         as razaoSocial,
                 v_sobrenomeFantasia as nomeFantasia,
                 v_telefone          as telefone,
                 v_tipoCliente       as tipo_cliente
            from dual;

      end;


    procedure salvarCliente(p_id                 in int,
                              p_nomeRazao         in varchar2,
                              p_sobrenomeFantasia in varchar2,
                              p_telefone          in varchar2,
                              p_tipoCliente       in int) is

      begin
        insert into cliente
          (id_cliente,telefone, tipo_cliente)
        values
          (p_id,p_telefone, p_tipoCliente);

        begin
          if (p_tipoCliente = 1) then
            insert into cliente_pf
              (cpf, nome, sobrenome)
            values
              (p_id, p_nomeRazao, p_sobrenomeFantasia);
          else
            insert into cliente_pj
              (cnpj, razaosocial, nomefantasia)
            values
              (p_id, p_nomeRazao, p_sobrenomeFantasia);
          end if;
        end;

      end;


      PROCEDURE deleteCliente(p_id_cliente in int) is

          v_id                int;
          v_nomeRazao         varchar2(100);
          v_sobrenomeFantasia varchar2(100);
          v_telefone          varchar2(9);
          v_tipo_cliente       int;

      begin
          begin
              select tipo_cliente into v_tipo_cliente from cliente where id_cliente = p_id_cliente;
              end;
          begin
            if (v_tipo_cliente = 1) then
              DELETE from cliente_pf p
               where p.cpf = p_id_cliente;

            else
              DELETE from cliente_pj p
               where p.cnpj = p_id_cliente;
            end if;
          end;

      end;


      procedure atualizarCliente(p_id   in int,
                                p_nomeRazao         in varchar2,
                                p_sobrenomeFantasia in varchar2,
                                p_telefone          in varchar2,
                                p_tipoCliente       in int) is


        begin
          update CLIENTE EN
          set en.id_cliente = p_id,
           en.telefone = telefone,
           en.tipo_cliente = p_tipoCliente
           where en.id_cliente = p_id;
          begin
            if (p_tipoCliente = 1) then
              update cliente_pf pf
                set pf.cpf=p_id,
                pf.nome=p_nomeRazao, pf.sobrenome = p_sobrenomeFantasia;
            else
              update cliente_pj pj
                set pj.cnpj=p_id,
                pj.razaosocial=p_nomeRazao, pj.nomefantasia = p_sobrenomeFantasia;
            end if;
          end;

        end;


        end;






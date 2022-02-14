create or replace package dev.pck_endereco is

type tCursor is ref cursor;

 procedure adicionarEndereco(p_id_endereco IN INT,
                            p_cep in VARCHAR2,
                            p_bairro in  VARCHAR2,
                            p_uf in  VARCHAR2,
                            p_cidade in VARCHAR2,
                            p_casa in VARCHAR2);


  procedure buscarEndereco(p_id_endreco in int,
                     resultado out tCursor);



 procedure atualizarEndereco(p_id_endereco IN INT,
                             p_cep in VARCHAR2,
                             p_bairro in  VARCHAR2,
                             p_uf in  VARCHAR2,
                             p_cidade in VARCHAR2,
                             p_casa in VARCHAR2);


     end;


  create or replace package body dev.pck_endereco is

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



       procedure adicionarEndereco(p_id_endereco IN INT,
                                   p_cep in VARCHAR2,
                                   p_bairro in  VARCHAR2,
                                   p_uf in  VARCHAR2,
                                   p_cidade in VARCHAR2,
                                   p_casa in VARCHAR2) IS

               begin

               insert into ENDERECO (id_endereco,cep,bairro,uf,cidade,casa) VALUES (p_id_endereco,p_cep,p_bairro,p_uf,p_cidade,p_casa);
               end;





       procedure atualizarEndereco(p_id_endereco IN INT,
                                   p_cep in VARCHAR2,
                                   p_bairro in  VARCHAR2,
                                   p_uf in  VARCHAR2,
                                   p_cidade in VARCHAR2,
                                   p_casa in VARCHAR2) IS

               BEGIN

               update ENDERECO EN
               set en.id_endereco = p_id_endereco,
               en.cep = p_cep,
               en.bairro = p_bairro,
               en.uf = p_uf,
               en.cidade = p_cidade,
               en.casa = p_casa
               where en.id_endereco = p_id_endereco;

               end;



               end;





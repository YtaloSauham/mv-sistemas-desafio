# mv-sistemas-desafio
 
Repositório com o projeto desafio Célula Financeira MV.

Esse projeto foi criado usando oracle, jasper e java.

﻿# Iniciando o Projeto
 
1- Fazer o download ou colne do projeto e realizar sua abertura na ua IDE.

2.Executar os scripts de criação de tabela localizados na pasta https://github.com/YtaloSauham/mv-sistemas-desafio/tree/main/database/table . É necessario,para bom funcionamento, que os parametros setados sejam (user = dev ,password = 1234).

3- Compilar os packages no banco de dados.Estes se encontram em https://github.com/YtaloSauham/mv-sistemas-desafio/tree/main/database/package . Neste arquivo se encontram todas as procedures e triggers utilizados no projeto.


﻿# Fluxo do Programa
 
 Após chamar as funções de criação de Cliente,Endereco e Movimentacao, é gerado um relatorio em formato pdf pelo jasper como a imagem abaixo.
 
 ![image](https://user-images.githubusercontent.com/85992772/153830742-13dac62d-d734-40c7-bdd1-aa5897dc7898.png)

 

# Observações do Programa

1- O programa apenas cria um Cliente,Endereco,Conta e Movimentacao e gera um relatorio.

2- Para chamar todas as demais funções, é necessario fazer uma chamada na main.

3- O calculo para movimentações financeiras são feitas de 2 formas: 

  3.1-Chamando a função operacao().
		
  3.2-.Após uma nova movimentação, através do trigger localizado em https://github.com/YtaloSauham/mv-sistemas-desafio/blob/main/database/table/movimentacao.sql
  
 4-Não foram criadas o calculo da receita de empresa por movimentação.Logo,o programa não está toltalmente completo.
 
 5-Para testar,iniciar a classe AppTest.
 
 
 
  # Funções Disponiveis 
  1-Criar,Atualizar, Deletar e Buscar Cliente.
		
  2-Atualizar e Buscar Endereço.
		
  3-Criar e Buscar Conta.
		
  4-Fazer movimentação.
		
  5-Validação na criação de Clientes.
		
  6-Relatorio
  
  # Boas Práticas
  1-POO: Programação Orientada a Objetos.
		
  2-Utilização do padrão MVC
  
   # Padrão de Projeto
  Nesse projeto foi utilizado o padrão Singleton.
  
  

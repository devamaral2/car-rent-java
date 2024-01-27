# Documentação da API Car Rent

## Configuração Inicial

Para executar esta aplicação você irá precisar do java jdk, do gerenciador de pacotes Maven e do gerenciador de
conteiners Docker.

1. **Ative o Docker Compose**

   Execute o seguinte comando para iniciar o container Docker que está rodando o PostgreSQL:

   ```bash
   docker-compose up -d
   ```

2. **Instale as Dependências**

   Após iniciar o container Docker, instale as dependências necessárias para a aplicação.

3. **Execute a Aplicação**

   Agora você pode executar a aplicação e começar a testá-la.

## Tabelas

A aplicação contém três tabelas:

1. **Cars**: Esta tabela armazena informações sobre os carros disponíveis para aluguel.

2. **Clients**: Esta tabela armazena informações sobre os clientes que alugam os carros.

3. **Rents**: Esta tabela registra as informações de aluguel de carros pelos clientes. Ela registra a entrada e saída de
   aluguéis de veículos realizados pelos usuários.

## Funcionalidades

1. **Visualizar Carros Disponíveis**

   A aplicação permite que os usuários vejam todos os carros que não estão atualmente alugados.

2. **Registro de Aluguel**

   A aplicação registra a entrada e saída de aluguéis de veículos realizados pelos usuários.

3. **Registro de checkout com notificação**

   A aplicação notifica o usuário se o checkout de um aluguel foi feito após a data esperada.

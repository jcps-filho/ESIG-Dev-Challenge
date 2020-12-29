## To do APP

Aplicação feita utilizando Spring Framework e Angular que tem como intenção criar uma e gerenciar uma lista de atividades. Utiliza conceitos de API Rest, 
persistência e mapeamento com Hibernate e componentes do Angular Material no frontend.

## Requirements

Node.js na versão 12.18.3 ou superior;

Angular CLI na versão 10.0.8 ou superior;

PostgreSQL na versão 13.1 ou superior;

Schema criado no banco com o nome "to_do_list".

## Getting started

Para executar a aplicação num ambiente de testes localmente é necessário executar os seguintes passos: 

1. Baixar a aplicação utilizando o Git com o seguinte comando: ```git clone https://github.com/jcps-filho/To-do-list```

2. Navegue até a pasta baixada

3. Acesse a pasta "compiled" via terminal, está pasta possui o JAR gerado pelo Maven para executar a API e também a pasta "dist" gerada pelo Angular.

4. Execute o JAR com o seguinte comando: ```java -jar esig-challenge-0.0.1-SNAPSHOT.jar```

5. Para o frontend será necessário um web server, então instale o live-server utilizando o comando ```npm install -g live-server```

6. Após isso execute o frontend com o commando ```lite-server --baseDir="dist/to-do-list"```

Observação: O JAR foi compilado utilizando o usuário padrão do PostgreSQL, "postgre", e a senha "root", caso seja necessário utilizar um usuário diferente o backend deverá ser compilar novamente alterando no arquivo de propriedades o nome de usuário e senha do banco a ser utilizado. Para realizar tal procedimento execute os seguintes passos:

1. Navegue até a pasta "backend/src/main/resources"

2. Edite o arquivo "application.properties", alterando as propriedades "username" e "password" para o usuário e senha do banco a ser utilizado

3. No terminal, retorne a pasta "backend"

4. Execute o comando ```mvn package```

5. Navegue até a pasta "backend/target"

6. Execute o JAR com o seguinte comando: ```java -jar esig-challenge-0.0.1-SNAPSHOT.jar```

Então prossiga com o passo 5 e 6 do tópico anterior.

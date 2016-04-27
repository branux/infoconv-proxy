# infoconv-proxy

Este projeto é um exemplo de como criar um Servidor para consumir o webservice do InfoConv e transforma-lo em uma API REST.

Esta abordagem permite que diversas aplicações de uma organização possam compartilhar este acesso de forma centralizada.  Cada organização poderá implementar seus critérios de authentição e controle de consumo.

## Requisitos
- JDK versão 6 ou superior
- Apache Maven versão 2.2 ou superior
- JBoss EAP 6.x 
- [Certificado do tipo e-equipamento](https://github.com/infoconv/docs/wiki/Certificado-Digital)

## Como instalar
 - Faça o clone do projeto.
```sh
$ git clone git@github.com:infoconv/infoconv-proxy.git
``` 
- Entrar no projeto e compila-lo.
```sh
$ cd infoconv-proxy
$ mvn install
``` 
- Copiar o war gerado na pasta target para a pasta de deploy do jboss
- Iniciar o servidor e acessar a url http://localhost:8080/infoconv-proxy

## Serviços

Este projeto disponibiliza dois resources Rest para consumo: [CpfResource](https://github.com/infoconv/infoconv-proxy/blob/master/src/main/java/br/gov/serpro/infoconv/proxy/rest/CpfResource.java) e [CnpjResource](https://github.com/infoconv/infoconv-proxy/blob/master/src/main/java/br/gov/serpro/infoconv/proxy/rest/CnpjResource.java)

Os erros previstos estão tratados nas classes: [ConsultaCpfBC](https://github.com/infoconv/infoconv-proxy/blob/master/src/main/java/br/gov/serpro/infoconv/proxy/businesscontroller/ConsultaCpfBC.java) e [ConsultaCNPJBC](https://github.com/infoconv/infoconv-proxy/blob/master/src/main/java/br/gov/serpro/infoconv/proxy/businesscontroller/ConsultaCNPJBC.java) e cada exceção lançada nestas classes possuem um ExceptionHandler para converter em código http. Exemplo: 404 para CPF não encontrado.

## Segurança

Nesta aplicação de exemplo a segurança não foi abordada pois cada organização possue seu mecanismo.


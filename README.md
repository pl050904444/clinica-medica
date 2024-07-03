# Clinica Médica

## Descrição
Clínica Médica, desenvolvida em acordo com instruções do Prof. Everton Hipólito, IMEPAC - Araguari || Curso de Análise e Desenvolvimento de Sistemas, 

## Index
- [Instalação](#instalação)
- [Uso](#uso)

## Instalação
1. Configurar os arquivos 'application.properties' localizados dentro de:
- clinica-commons/src/main/resources/application.properties
- clinica-administrativo/src/main/resources/application.properties
- clinica-agendamento/src/main/resources/application.properties
- clinica-atendimento/src/main/resources/application.properties

```
# Configuração de portas
server.port=8080    /* A Aplicação necessita de 4 portas diferentes e livres, uma em cada módulo*/

# Database
spring.datasource.url=jdbc:mysql://localhost:3306/clinicamedica /* Caminho do banco de dados */
spring.datasource.username=root  /* Usuário do Banco de Dados */
spring.datasource.password=1234  /* Senha do Banco de Dados */
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

2. Executar todos os módulos

3. Acesso ao localhost:8080, confirmando o ativamento dos módulos pela mensagem de sucesso:

 ![Screenshot_165](https://github.com/pl050904444/clinica-medica/assets/130000947/4ae622a5-87b8-4adf-b19a-2a2d5dd803b6)

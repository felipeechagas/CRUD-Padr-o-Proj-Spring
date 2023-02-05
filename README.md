# CRUD com Padrões de Projetos Spring
Api Rest explorando padrões de projetos com Spring e integrações Spring Data Jpa e ViaCep

Singleton: @Bean e @Autowired;
Strategy: @Service e @Repository;
Facade: abstratir a complexidade das integrações: Spring Data JPA e Viacep(Feigh)
Em memória (Usando o "H2").

Utilizando as dependências pelo Spring Initializr:
* Spring Web: provedor de ApiRest;
* Spring Data Jpa: módulo de abstração de persistência de bancos relacionais;
* H2 Database: Banco de dados em memória;
* OpenFeigh: Client rest declarativopara consumir APIs externas;
* Lombok: biblioteca Java focada em produtividade e redução de código boilerplate;

Package: model, controller, Repository, service e impl.



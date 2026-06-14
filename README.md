# Projeto Integrado Engenharia de Software

Projeto desenvolvido para o curso de Análise e Desenvolvimento de Sistemas da UNIFEOB.



## Autores

- Pedro Paulo Batista Alves - RA: 24001197



Este projeto integrado tem como objetivo otimizar a gestão de agendamentos do salão de beleza "Neula Araújo Studio de Beleza", atualmente realizados de forma manual. A solução proposta é uma aplicação web interativa e baseada em dados.
O protótipo atualiza a estrutura lógica do sistema em Java e implementa o banco de dados em MySQL, representando as camadas **Model** e **Controller** da arquitetura MVC.
Para a gestão do projeto, foi utilizada a metodologia ágil **Kanban**, focando na visualização do fluxo de trabalho e na limitação do trabalho em progresso (WIP).

## Arquitetura e Estrutura do Projeto

O projeto adota o padrão **Cliente-Servidor** e o padrão de projeto **MVC (Model-View-Controller)** para separar a lógica da aplicação em três camadas.

### Descrição dos Componentes (Camada Model)

**Cliente.java**: Contém a classe modelo que representa o cliente do salão.

**Servico.java**: Contém a classe modelo que define os serviços oferecidos.

**Agendamento.java**: Representa o modelo de agendamento, com atributos como data, horário, profissional e cliente associado.

**App.java**: Responsável pela instância e criação dos objetos e a execução dos métodos.

**Protótipo Web (View)**: Interface desenvolvida com HTML, CSS, JavaScript e Bootstrap, permitindo a seleção de serviços, profissionais e horários.

## Funcionalidades Implementadas (Protótipo Parcial)

Os resultados parciais obtidos demonstram o fluxo principal do sistema:

**Modelagem de Entidades**: Definição clara das entidades (Clientes, Serviços, Profissionais e Agendamentos).

**Estrutura de Banco de Dados**: Criação e implementação da estrutura do banco de dados relacional em **MySQL**.

**Interface de Agendamento**: Protótipo web que permite a seleção de serviços.

**Lógica de Negócio**: Desenvolvimento da lógica do sistema utilizando conceitos de Orientação a Objetos em **Java**.

*Observação: A integração entre o Front-end (View) e o Back-end (Model/MySQL) não foi implementado durante o projeto.*

## Tecnologias Utilizadas

| Componente      | Versão | Finalidade                                           |
|-----------------|--------|------------------------------------------------------|
| **Java JDK**    | 11+    | Lógica do sistema e camada Controller/Model          |
| **MySQL**       | 8.0+   | Banco de dados relacional e persistência de dados    |
| **HTML/CSS/JS** | -      | Desenvolvimento do Front-end (View) e interatividade |
| **Bootstrap**   | -      | Framework para design da interface (Front-end)       |
| **VS Code**     | Latest | Editor de código                                     |
| **GitHub**      | -      | Controle de versão do código                         |

## Estrutura do Projeto

Projeto-Integrado-Engenharia-de-Software/

├── frontend/                     # Código da interface do usuário (HTML, CSS, JS)


├── index.html                # Protótipo da página de agendamento


│   └── css/js/img/               # Arquivos de estilo e interatividade


├── java/                         # Código Java (Lógica do sistema - Model/Controller)
  

│   ├── Cliente.java              # Modelo de Cliente


│   ├── Servico.java              # Modelo de Serviço


│   ├── Agendamento.java          # Modelo de Agendamento


│   └── App.java                  # Instância e execução de métodos

├── sql/                          # Scripts de banco de dados

│   └── schema.sql                # Script de criação do BD MySQL

└── README.md                     # Este arquivo

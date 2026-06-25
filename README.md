# Projeto Integrado: Computação em Nuvem

Projeto desenvolvido para o curso de Análise e Desenvolvimento de Sistemas da UNIFEOB. Este projeto integrado tem como objetivo otimizar a gestão de agendamentos do salão de beleza "Neula Araújo Studio de Beleza". 

A solução atualiza a estrutura do projeto anterior, substituindo o armazenamento local por uma arquitetura Full-Stack com persistência de dados relacional em nuvem, cumprindo o desafio de criar um ambiente em nuvem capaz de hospedar uma aplicação web funcional. Para a gestão do projeto e organização das entregas, foi utilizada a metodologia ágil Kanban, focando na visualização do fluxo de trabalho.

## Autores

* Pedro Paulo Batista Alves - RA: 24001197

---

## Arquitetura e Estrutura do Projeto

O projeto adota o padrão Cliente-Servidor e a arquitetura MVC (Model-View-Controller), aliada ao padrão DAO (Data Access Object) para garantir a segurança e a separação das responsabilidades. 

### Descrição dos Componentes

*   **Camada Model:** 
    *   `Cliente.java`, `Servico.java`, `Agendamento.java`: Classes que representam as entidades e regras de negócio do salão.
*   **Camada de Persistência (DAO):** 
    *   `ClienteDAO.java`: Padrão de projeto utilizado para isolar as operações de banco de dados (SQL).
    *   `ConexaoDB.java`: Gerenciador seguro das instâncias de conexão com o MySQL.
*   **Camada Controller (Servidor):**
    *   `ServidorWeb.java`: Servidor HTTP nativo em Java responsável por expor a API RESTful, lidar com as requisições assíncronas e gerenciar as permissões de CORS.
    *   `App.java`: Classe principal responsável pela inicialização do servidor.
*   **Camada View (Front-end):** 
    *   Interface desenvolvida com HTML, CSS, JavaScript e Bootstrap, permitindo o consumo da API via requisições `fetch`.

---

## Funcionalidades Implementadas (Integração Full-Stack)

Diferente das etapas anteriores do curso, onde o banco de dados e a interface operavam separadamente, os resultados finais deste módulo demonstram o fluxo completo e integrado do sistema:

1.  **Interface Interativa:** Protótipo web responsivo para cadastro de clientes e visualização de serviços.
2.  **Comunicação Assíncrona:** Integração real entre o Front-end e o Back-end através de API RESTful.
3.  **Persistência em Nuvem:** Os dados inseridos na interface são processados pelo servidor Java e armazenados de forma persistente e remota no banco de dados MySQL (via IaaS).

---

## Tecnologias Utilizadas

| Componente | Versão | Finalidade |
| :--- | :--- | :--- |
| **Java JDK** | 11+ | Servidor Web nativo, integração de API e lógica de acesso a dados (DAO) |
| **MySQL** | 8.0+ | Banco de dados relacional hospedado em nuvem (FreeDB) |
| **HTML/CSS/JS** | - | Desenvolvimento do Front-end (View) e comunicação via Fetch API |
| **Bootstrap** | 5 | Framework para design responsivo da interface |
| **VS Code** | Latest | Editor de código principal |
| **Git/GitHub** | - | Controle de versão de código e versionamento do repositório |

---

## Estrutura de Diretórios

pi_computacao_em_nuvem/
├── Frontend/                    # Código da interface do usuário (HTML, CSS, JS)
│   ├── index.html               # Página principal do sistema
│   ├── cadastro.html            # Interface de cadastro de clientes
│   ├── servicos.html            # Interface de apresentação de serviços
│   ├── css/                     # Arquivos de estilo e customizações
│   ├── js/                      # Lógica assíncrona (Fetch API para consumo do Back-end)
│   └── assets/images/           # Ícones e recursos visuais do salão
│
├── Backend/                     # Código Java (Servidor, DAO, Modelos)
│   └── Java POO/lib/pisalao/src/
│       ├── ServidorWeb.java     # Servidor HTTP nativo e gerenciamento de rotas/CORS
│       ├── ConexaoDB.java       # Gerenciador de conexão com MySQL
│       ├── ClienteDAO.java      # Manipulação de dados no banco (Padrão DAO)
│       ├── Cliente.java         # Entidade Cliente
│       ├── Servico.java         # Entidade Serviço
│       ├── Agendamento.java     # Entidade Agendamento
│       └── App.java             # Inicialização do sistema
│
├── config.properties            # Arquivo de variáveis de ambiente e credenciais (Ignorado no Git)
├── .gitignore                   # Blindagem de arquivos sensíveis e binários
└── README.md                    # Este arquivo de documentação

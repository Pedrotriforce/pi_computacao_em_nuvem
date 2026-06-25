# Projeto Integrado Computação em Nuvem

Projeto desenvolvido para o curso de Análise e Desenvolvimento de Sistemas da UNIFEOB. O sistema moderniza a gestão de agendamentos do Neula Araújo Studio de Beleza, substituindo o armazenamento local por uma arquitetura Full-Stack com persistência de dados relacional em nuvem.

## Autores

* Pedro Paulo Batista Alves - RA: 24001197

## Tecnologias Utilizadas

| Componente      | Versão | Finalidade                                                              |
| :---            | :---   | :---                                                                    |
| **Java JDK**    | 11+    | Servidor Web nativo, integração de API e lógica de acesso a dados (DAO) |
| **MySQL**       | 8.0+   | Banco de dados relacional hospedado em nuvem (FreeDB)                   |
| **HTML/CSS/JS** | -      | Desenvolvimento do Front-end (View) e comunicação via Fetch API         |
| **Bootstrap**   | 5      | Framework para design responsivo da interface (Front-end)               |
| **VS Code**     | Latest | Editor de código principal                                              |
| **Git/GitHub**  | -      | Controle de versão de código e versionamento do repositório             |

## Estrutura do Projeto

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
│       ├── ConexaoDB.java       # Gerenciador de instâncias de conexão com MySQL em nuvem
│       ├── ClienteDAO.java      # Padrão Data Access Object para manipulação de dados
│       ├── Cliente.java         # Entidade/Modelo de Cliente
│       ├── Servico.java         # Entidade/Modelo de Serviço
│       ├── Agendamento.java     # Entidade/Modelo de Agendamento
│       └── App.java             # Classe principal para inicialização de testes locais
│
├── config.properties            # Arquivo de variáveis de ambiente e credenciais do banco
├── .gitignore                   # Blindagem de arquivos sensíveis (.properties, binários)
└── README.md                    # Este arquivo de documentação

│   └── css/js/img/               # Arquivos de estilo e interatividade


├── java/                         # Código Java (Lógica do sistema - Model/Controller)
  

│   ├── Cliente.java              # Modelo de Cliente


│   ├── Servico.java              # Modelo de Serviço


│   ├── Agendamento.java          # Modelo de Agendamento


│   └── App.java                  # Instância e execução de métodos

├── sql/                          # Scripts de banco de dados

│   └── schema.sql                # Script de criação do BD MySQL

└── README.md                     # Este arquivo

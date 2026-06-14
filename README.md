# Projeto Integrado Computação em Nuvem
Projeto desenvolvido para o curso de Análise e Desenvolvimento de Sistemas da UNIFEOB.



## Autores

- Pedro Paulo Batista Alves - RA: 24001197




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

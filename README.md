# Lembrete de aniversário 🎂

Um app web que vai te ajudar você a nunca mais esquecer o aniversário de ninguem!

### Sobre o Projeto

  É um aplicativo simples e intuitivo criado para ajudar você a nunca mais esquecer o aniversário de alguém especial.

  Inspirado na ideia dos tradicionais post-its colados na parede, o projeto permite que você crie lembretes visuais para aniversários e os adicione na tela como se fossem pequenos blocos de anotações. Cada lembrete contém informações básicas, como o nome da pessoa e a data do aniversário.

  A interface foi pensada para ser leve, organizada e fácil de usar, proporcionando uma experiência rápida tanto na criação quanto na visualização dos lembretes. O objetivo principal do projeto é oferecer uma maneira prática e visual de gerenciar aniversários, ideal para quem prefere algo simples, sem a complexidade de agendas ou calendários cheios de funcionalidades.

![Exemplo de imagem](caminho/para/sua/imagem.png)
_Uma breve legenda descrevendo a imagem._

---

## Funcionalidades

Liste as principais funcionalidades ou características do seu projeto. Use bullet points para facilitar a leitura.

* Funcionalidade 1: Descrição detalhada.
* Funcionalidade 2: Descrição detalhada.
* Funcionalidade 3: Descrição detalhada.
* ...

---

## Tecnologias Utilizadas

Este projeto foi desenvolvido utilizando as seguintes tecnologias principais:

### Backend

* **Java**: Versão [sua versão de Java, ex: 17]
* **Spring Boot**: Versão [sua versão de Spring Boot, ex: 3.x.x]
    * **Spring Data JPA**: Para persistência de dados e interação com o banco.
    * **Spring Web**: Para construção de APIs RESTful.
    * **Spring Security**: (Opcional, se estiver usando) Para autenticação e autorização.
* **Maven** ou **Gradle**: Para gerenciamento de dependências e construção do projeto.

### Frontend

* **Angular**: Versão [sua versão de Angular, ex: 17.x.x]
* **TypeScript**: Linguagem base do Angular.
* **npm** ou **Yarn**: Para gerenciamento de pacotes do frontend.

### Banco de Dados

* **PostgreSQL**: Versão [sua versão de PostgreSQL, ex: 14.x]
* **Docker** e **Docker Compose**: Utilizados para orquestrar e gerenciar o contêiner do banco de dados PostgreSQL.

---

## Arquitetura

O projeto segue uma arquitetura **Model-View-Controller (MVC)**, com uma clara separação de responsabilidades:

* **Frontend (Angular)**: Desenvolvido em Angular, é responsável pela interface do usuário e por consumir os serviços RESTful expostos pelo backend. Ele lida com a apresentação dos dados e a interação do usuário.
* **Backend (Spring Boot)**: Desenvolvido com Spring Boot em Java, este módulo contém a lógica de negócios da aplicação. Ele expõe uma API RESTful que o frontend consome e gerencia a persistência dos dados no banco de dados.
* **Banco de Dados (PostgreSQL no Docker)**: O PostgreSQL é utilizado para armazenar os dados da aplicação, sendo executado em um contêiner Docker, facilitando a configuração e o ambiente de desenvolvimento.

---

## Pré-requisitos

Certifique-se de ter os seguintes softwares instalados em sua máquina antes de iniciar:

* **Java Development Kit (JDK)**: Versão [sua versão de Java, ex: 17] ou superior.
* **Maven** (recomendado para o backend) ou **Gradle**.
* **Node.js**: Versão [sua versão de Node.js, ex: 18.x] ou superior (inclui `npm`).
* **Angular CLI**: Versão [sua versão de Angular CLI, ex: 17.x.x] ou superior.
    * Para instalar globalmente: `npm install -g @angular/cli`
* **Docker Desktop**: Para Windows/macOS, ou **Docker Engine** e **Docker Compose** para Linux.

---

## Instalação

Siga os passos abaixo para configurar e rodar o projeto em sua máquina local:

### 1. Clonar o Repositório

```bash
git clone [https://github.com/seu-usuario/nome-do-seu-projeto.git](https://github.com/seu-usuario/nome-do-seu-projeto.git)
cd nome-do-seu-projeto

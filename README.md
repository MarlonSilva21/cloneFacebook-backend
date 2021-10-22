<h1 align="center">
    <br>
    Facebook Clone 
</h1>

<h4 align="center">
Project developed for student purposes
</h4>
<p align="center">
  <img alt="GitHub top language" src="https://img.shields.io/github/languages/top/marlonsilva21/cloneFacebook-backend.svg">

  <img alt="GitHub language count" src="https://img.shields.io/github/languages/count/marlonsilva21/cloneFacebook-backend.svg">

  <a href="https://www.codacy.com/app/marlonsilva21/cloneFacebook-backend?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=marlonsilva21/cloneFacebook-backend&amp;utm_campaign=Badge_Grade">
    <img alt="Codacy grade" src="https://api.codacy.com/project/badge/Grade/691b85e51bf240b997ae6ff82ea41590">
  </a>

  <img alt="Repository size" src="https://img.shields.io/github/repo-size/marlonsilva21/cloneFacebook-backend.svg">
  <a href="https://github.com/marlonsilva21/cloneFacebook-backend/commits/master">
    <img alt="GitHub last commit" src="https://img.shields.io/github/last-commit/marlonsilva21/cloneFacebook-backend.svg">
  </a>

  <a href="https://github.com/marlonsilva21/rest-api-nodejs/issues">
    <img alt="Repository issues" src="https://img.shields.io/github/issues/marlonsilva21/cloneFacebook-backend.svg">
  </a>

  <img alt="GitHub" src="https://img.shields.io/github/license/marlonsilva21/cloneFacebook-backend.svg">
</p>

<p align="center">
  <a href="#rocket-technologies">Tecnologias </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="#install">Como instalar </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="#features">Recursos </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="#structure">Estrutura do projeto </a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
</p>

## :rocket: Tecnologias

<p id="rocket-technologies">Este projeto foi desenvolvido com as principais tecnologias::</p>

- [Java](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [PostgreeSQL](https://www.postgresql.org/)


<h2 id="install"> Como instalar </h2>

### Usando git (recomendado)

1.  Clone the project from github. 

```bash
git clone https://github.com/MarlonSilva21/cloneFacebook-backend.git
```

### Usando o ZIP de download manual

1.  Faça download do repositório
2.  Descompacte para o diretório desejado


<h2 id="features"> Recursos </h2>

- Autenticação básica (registrar / fazer login com senha em hash)
- Tokens JWT, faça solicitações com um token após o login com o cabeçalho `Authorization` com o valor `seuToken` onde o `seuToken` será retornado na resposta de Login.
- Estruturas de resposta predefinidas com códigos de status adequados.
- Validações adicionadas.
- Documentação com swagger

<h2 id="structure"> Estrutura do projeto </h2>

```sh
.
├── pom.xml
├── documentation
│    └── API - Clone do Facebook (documentação swagger em PDF)
└── src
    ├── main
        ├── java
            ├── abr.com.marlon.cloneFacebook
                ├── configuration
                │  └── SwaggerConfig
                │
                ├── controllers
                │   ├── PostagemController
                │   └── UsuarioController
                │    
                ├── models 
                │   ├── PostagemModel
                │   ├── UsuarioLogin
                │   └── UsuarioModel
                │
                ├── repository
                │    ├── PostagemRepository
                │    └── UsuarioRepository
                │
                ├── security
                │    ├── BasicSecurityConfig
                │    ├── UserDetailsImpl
                │    └── UserDetailsServiceImpl
                │
                ├── service
                │    └── UsuarioService
                │    
                └── CloneFacebookApplication (Classe principal)
    
```

### Ao rodar a api localmente acesse:

```bash
http://localhost:8080/swagger-ui/ 
```

<p>Para poder conferir todos os endpoints e o auxiliar no consumo da API</p>

### Ou se preferir acesse ela remotamente em: (user e senha default: root)
```
https://apiclonefb.herokuapp.com/swagger-ui/

```

##

Feito por Marlon Silva :wave: [Get in touch!](https://www.linkedin.com/in/marlon-silva-43075a184/)




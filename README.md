# Spotifei 🎵

Bem-vindo ao Spotifei, um sistema feito para gerenciar musicas e playlists.

## 🔧 Tecnologias usadas

- Java (Swing) para interface grafica
- PostgreSQL para banco de dados
- NetBeans como IDE
- JDBC para conexao com o banco

## 💡 Funcionalidades

- Criar playlists com nome personalizado
- Adicionar musicas em playlists
- Curtir ou descurtir musicas
- Ver detalhes da musica com clique duplo
- Filtrar musicas por nome, artista ou genero
- Excluir playlists
- Ver historico de interacoes do usuario

---

## ▶️ Como rodar o projeto

### 1. Clone o repositorio:

```bash
git clone https://github.com/SeuUsuario/spotifei.git
```

### 2. Abra o projeto no NetBeans.

### 3. Configure seu banco PostgreSQL com os seguintes dados:

```sql
----Comandos para criar as tabelas no banco de dados----

---Criando banco de dados------
CREATE database db_spotifei;

---- Criando tabela de usuarios ------
create table cd_usuarios(
  cod_user serial primary key,
  nome_user varchar(50),
  senha_user varchar(50),
  nome_comp_user varchar(120)
);

------ Criando tabela de musicas -----
create table cd_musicas(
  cod_musica serial primary key,
  nome_musica varchar(50),
  artista varchar(50),
  genero varchar(40),
  tempo_total_musica varchar(20),
  data_lancamento date
);

--------- Criando tabela de musicas curtidas ---------
create table cd_musicas_curtidas(
  cod_musica serial primary key,
  nome_musica varchar(120),
  artista varchar(40),
  genero varchar(40),
  tempo_total_musica varchar(20),
  data_lancamento varchar(19)
);

-------- Criando tabela de playlists --------
create table playlists(
  id serial primary key,
  nome varchar(100)
);

---- Criando tabela para vincular musicas e playlists ----
create table playlist_musicas(
  id serial primary key,
  nome_musica varchar(120),
  nome_playlist varchar(120)
);

---------- Criando tabela de historico --------
create table historico(
  id serial primary key,
  data_mudanca date,
  acao varchar(255)
);
```

### 4. Ajuste os dados de conexao no arquivo `ConectarDB.java`:

```java
private static final String URL = "jdbc:postgresql://localhost:5432/db_spotifei";
private static final String USUARIO = "seu_usuario";
private static final String SENHA = "sua_senha";
```

---

## 🚀 Execucao completa do projeto

1. Com o banco de dados criado e as tabelas prontas, abra o projeto no NetBeans.
2. Certifique-se de que o driver JDBC do PostgreSQL esta adicionado em Libraries.
3. Clique com o botao direito no projeto e selecione "Run".
4. A tela de login sera exibida:
   - Se nao houver usuarios, crie um novo usuario usando a tela de cadastro.
5. Apos o login, voce podera:
   - Visualizar todas as musicas cadastradas
   - Filtrar musicas por nome, artista ou genero
   - Clicar duas vezes para ver os detalhes de uma musica
   - Criar novas playlists com nomes personalizados
   - Adicionar musicas a uma playlist
   - Remover playlists
   - Visualizar todas as playlists existentes
   - Consultar o historico de acoes, como exclusoes e curtidas
6. Todas as informacoes sao persistidas no banco de dados PostgreSQL.

---

## 💻 Telas do sistema

- Tela inicial
- Tela de login e cadastro
- Tela de listagem de musicas
- Tela de filtro e pesquisa
- Tela de detalhes da musica
- Tela para criacao e listagem de playlists
- Tela de historico do usuario

---

## 👨‍💻 Autor

Projeto desenvolvido por Igor Botini.

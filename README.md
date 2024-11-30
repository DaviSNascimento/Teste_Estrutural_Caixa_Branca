## README: Análise dos Erros no Código

**Objetivo:**

Este documento tem como objetivo identificar e explicar os principais erros presentes no código fornecido, com o propósito de auxiliar na sua correção e compreensão. 

**Análise:**

O código apresentado para análise apresenta diversas falhas que podem comprometer sua funcionalidade e segurança. A seguir, foi detalhado cada um dos erros encontrados, referenciando as linhas em que ocorrem e apresentando trechos do código para melhor visualização.

**1. Conexão com o Banco de Dados (Linha 4):**
* **Erro:** O nome da classe do driver MySQL está incorreto.
* **Correção:** Substituir `com.mysql.Driver.Manager` por `com.mysql.jdbc.Driver`.

```java
Class.forName("com.mysql.jdbc.Driver").newInstance();
```

**2. Construção da Query SQL (Linhas 10-12):**
* **Erro:** O código estava construindo consultas SQL de forma insegura, permitindo que usuarios maliciosos manipulassem o banco de dados.
* **Correção:** Utilizar Prepared Statements para parametrizar a query e evitar a injeção de código.

```java
sql += "where login= " + "'" + login + "'";
```

**3. Ordem de Execução (Linha 14):**
* **Erro:** O `ResultSet rs` é declarado antes de `Statement st`, o que causará um erro em tempo de execução.
* **Correção:** Inverter a ordem de declaração das variáveis.

```java
Statement st = conn.createStatement();
ResultSet rs = st.executeQuery(sql);
```

**4. Variável Não Declarada (Linha 16):**
* **Erro:** A variável `nomers` não foi declarada, causando um erro de compilação.
* **Correção:** Declarar a variável `nomers` com o tipo de dado correto (provavelmente uma String) antes de usá-la.

```java
nomers.getString("nome");
```

**5. Tratamento de Exceções (Linhas 17-18):**
* **Erro:** O bloco `try-catch` captura todas as exceções, mas não as trata adequadamente. Isso pode ocultar erros importantes e dificultar a depuração.
* **Correção:** Capturar exceções específicas e fornecer mensagens de erro mais informativas.

```java
} catch (Exception e) { }
```

**6. Fechamento de Conexão:**
* **Erro:** A conexão com o banco de dados não é fechada, o que pode levar a vazamentos de recursos e problemas de desempenho.
* **Correção:** Utilizar um bloco `finally` para garantir que a conexão seja fechada, mesmo que ocorram exceções.

**Considerações Adicionais:**

* **Falta de comentários:** A ausência de comentários dificulta a compreensão do código e a manutenção.
* **Indentação:** A indentação inconsistente prejudica a legibilidade do código.
***
### Complexidade Ciclomática
 A imagem a seguir representa o nivel de complexidade ciclomática analisado no código. Como há de se observar, ela possue os seguintes resultados:
 * **N = 14**
 * **E = 16**
 * **M = 4**
 * **NUMERO DE CAMINHOS: 4**

![Teste Caixa Branca - Grafo de Fluxo(atualizado)](https://github.com/user-attachments/assets/bdab0bf5-3c08-4e03-9df6-644de965901c)

### Quantidade de Caminhos:

* **Caminho 1:** (N1) - (N2) - (N3) - `(N4)` - (N6) - (N7) - (N8) - (N9) - (N10) - (N11) - `(N12)` - (N14)
* **Caminho 2:** (N1) - (N2) - (N3) - `(N5)` - (N6) - (N7) - (N8) - (N9) - (N10) - (N11) - `(N12)` - (N14)
* **Caminho 3:** (N1) - (N2) - (N3) - `(N4)` - (N6) - (N7) - (N8) - (N9) - (N10) - (N11) - `(N13)` - (N14)
* **Caminho 4:** (N1) - (N2) - (N3) - `(N5)` - (N6) - (N7) - (N8) - (N9) - (N10) - (N11) - `(N13)` - (N14)

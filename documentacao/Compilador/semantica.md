# Análise Semântica
A análise semantica foi feita através da classe `Codigo` criada pelos próprios integrantes do grupo. A classe `Codigo` é responsável por uma série de verificações.

## Funções da classe Codigo

### Adição de tokens a uma lista de tokens
- Descrição: adiciona os tokens encontrados pelo analisador sintático à uma lista de tokens.
- Utilização: utilizado a todos os tokens encontrados pelo analisador sintático com exceção da importação, a qual é adicionada os tokens do arquivo importado no lugar da impórtação.
- Função: `void add(Token t)`

### Adição de variáveis a uma lista de variáveis
- Descrição: adiciona um identificador no momento de sua declaração à uma lista de variaveis.
- Utilização: utilizado a todos os identificadores encontrados na declaração de variáveis e criação de funções.
- Função: `Variable addDVarList(String id, int type, Token t)`
- Erro: lança `ParseException` em caso da variável ja tenha sido declarada.

### Verifica se uma variável foi declarada
- Descrição: verifica se uma indentificador faz parte da lista de variáveis. Também verifica se este identificador é ou não um vetor.
- Utilização: utilizado a todos os identificadores encontrados fora da declaração de variáveis, excluindo funções.
- Função: `Variable verifyVarList(Token t)` e `void Variable.checkVet(boolean vet, Token t, String file)`.
- Erro: lança `ParseException` em caso da variável não tenha sido declarada.

### Verifica se uma função foi declarada
- Descrição: verifica se uma função faz parte da lista de variáveis.
- Utilização: utilizado a todos os identificadores encontrados na chamada de funções.
- Função: `Variable verifyVarList(Token t, boolean isFunc)`
- Erro: lança `ParseException` em caso da variável ser uma função declarada porem não ser chamada como função, ou em caso da variável não ser uma função declarada e ser chamada como função. Recursivamente lança erros de `verifyVarList(Token t)` da classe Codigo.

### Verifica os parâmetros de uma função fornecida
- Descrição: verifica se o parâmetro fornecido pelo usuário está na ordem correta na lista de parâmetros de uma função. Verifica se os tipos funcionam similar.
- Utilização: utilizado na chamada de todos os parâmetros de uma chamada de função.
- Função: `void openChamaFunc(Token t)`, `int getNextParam(Token name)`,  e `void checkParameters(Token name)`.
- Erro: lança `ParseException` recursivamente das funções `verifyVarList` da classe Codigo e `getNextParam` da classe Variable.

### Verifica se a função principal ja foi chamada
- Descrição: verifica se uma função principal ja foi chamado antes, evitando dois first no mesmo programa.
- Utilização: utilizado na chamada de todos os tokens first.
- Função: `void verificaFirst(Token t)`
- Erro: lança `ParseException` caso a função principal ja tenha sido chamada.

### Verifica se uma expressão é do tipo esperado
- Descrição: verifica o tipo que uma expressão se forma e verificia se este tipo era o esperado para o momento. Essa verificação é feito em pilha de pilha, sendo a primeira pilha para o caso de recursão de expressões, como por exemplo a expressão de um parâmetro de uma função não faz parte da expressão que a chamada de função se encontra. A segunda pilha é para trabalhar com pareênteses, adicionando espressões com parenteses em pilhas e calculando as expressões de mais baixo nível primeiro.
- Utilização: utilizado na chamada de todas as expressão, com exceção das chamadas recursivamente pela própria expressão.
- Função: `void openExpressao(int kind)`, `void addToExp(Token t)`, `void addToExp(int type)`, `void openParExp(Token t)`, `void closeParExp(Token t)`, `void addOpToExp(Token t)`, `void closeExpressao(Token t)`.
- Erro: lança `ParseException` em caso de um operador esteja sendo utilizado com os tipos errados, em caso de uma expressão que chama uma função do tipo void e em caso da expressão não ser do tipo esperado.

### Verifica se uma variável foi inicializada
- Descrição: verifica na lista de variáveis se um identificador chamado pelo usuário foi inicializado. Vetores são considerados inicializados por padrão.
- Utilização: utilizado na chamada de todas as variáveis. Também é utilizado quando uma variavel recebe uma atribuição, inicializando a mesma.
- Função: `void initializeVar(Token a)` e `void checkInitVar(Token a)`.
- Erro: lança `ParseException` em caso da variavel não ter sido inicializada. Também lança recursivamente erros de `verifyVarList`.

### Verifica está utilizando um container no foreach
- Descrição: verifica na lista de variáveis se a variável do foreach foi declara e é um container.
- Utilização: utilizado na chamada de todos os foreach.
- Função: `void checkForeach(Token input,  Token container)`.
- Erro: lança `ParseException` em caso da variável não ser um container. Também lança recursivamente erros de `verifyVarList`.

### Verifica se uma função possui um return
- Descrição: verifica se uma função não void tenha um return com uma expressão que se comporte como o tipo da função. Verifica se funções void não possuem return com alguma expressão.
- Utilização: utilizado na criação de todas as funções.
- Função: `void openFunc()`, `void setHasReturn(boolean hasReturn)`, `void closeFunc(Token t)`.
- Erro: lança `ParseException` em caso da função não ter um return quando esperado um. Também lança recursivamente erros ao verificar o tipo de return.

### Abre a possibilidade de variaveis locais
- Descrição: conta o numero de variáveis locais declaradas em um escopo para depois remove-las da lista. Essa contagem é feita em pilha para casos de escopos dentro de escopos.
- Utilização: utilizado no começo e no fim de um escopo.
- Função: `void openBloco()` e `void closeBloco()`.

## As classes Variable e ExpressionOp
A classe Variable guarda informações de variaveis como seu identificador, seu tipo, se é vetor, se é uma função, se tem parâmetros, quais os parâmetros e se foi inicializada. Possui métodos que verificam os parâmetros de uma função e se uma variavel é um vetor ou não.

A classe ExpressionOp guarda informações de expressões como as tabelas da sessão <a href="../Linguagem/var.md/#tabelaTipo">Variáveis</a>, que mostram quais os tipos que se comportam iguais, e qual o retorno de cada operador para cada tipo de operando fornecido. Possui métodos que verificam qual o tipo de uma expressão e se dois tipos se comportam parecidos.
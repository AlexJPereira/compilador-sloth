# Variáveis

As variáveis podem ser dos seguintes tipos:
- Inteiro (`int`)
- Real (`double`)
- Caractere (`caractere`)
- Frase (`string`)
- Booleana (`boolean`)
- Porcentagem (`double`)

Elas também podem ser vetores.

As porcentagem são numeros seguidos de `%` e representam um numero 100x menor. As porcentagens são consideradas reais.

## Iniciação de variáveis
Para declarar uma variável basta colocar seu tipo em seguida de seu nome, também é possivel inicializar uma variável, vale dizer que não é possivel utilizar uma variável que não foi inicializada. Não é possivel inicializar vetores na declaração.

```
int a=1, b, c;
double d[3], e = 3.0, f = 3*9/4+a;
```

## Manipulação de variáveis
Para atribuir a uma variável basta utilizar o sinal de igual `=`, uma variável de um tipo específico só pode receber expressões que se comportem igual ao tipo da variável de acordo com a tabela a seguir:

<a id="tabelaTipo"></a>

| expressão\variável 	| int 	| double 	| char 	| string 	| boolean 	|
|:------------------:	|:---:	|:------:	|:----:	|:------:	|:-------:	|
|         int        	| sim 	|   sim  	|  não 	|   não  	|   não   	|
|       double       	| não 	|   sim  	|  não 	|   não  	|   não   	|
|        char        	| sim 	|   sim  	|  sim 	|   não  	|   não   	|
|       string       	| não 	|   não  	|  não 	|   sim  	|   não   	|
|       boolean      	| não 	|   não  	|  não 	|   não  	|   sim   	|

Essa tabela indica se um valor pode receber outro, também funciona para o `return` das funções.

## Expressões
Expressões possuem operações em prioridade. Da maior prioridade para a menor:

1. not (`!`), a primeira prioridade e só podem ser feitas com tipos booleanos.
```
boolean a = !(true);
```

2. potencia (`^`), a segunda maior prioridade, essas contas devem ser as segundas a serem feitas. Potencias recebem dois numeros reais e retornam também um numero real, portanto não é possivel colocar uma operação de potenciação em um int de acordo com a tabela acima, porem é possivel colocar um int em uma potência.
```
double a = 1^2;
```

3. subtração (`-`), multiplicação (`*`), divisão (`/`), resto (`//`). Repare que o resto não é `%`, o simbolo de porcentagem como visto antes é uma porcentagem realmente, retornando um numero real 100x menor.
```
int a = 1-2/3*4//5;
```

4. adição (`+`), essa vem depois das outras operações porque strings somandas a qualquer coisa retornarão strings concatenadas.
```
string a = 1+"oi";
```

5. operações relacionais, igual (`==`), diferente (`=!`), maior (`>`), menor (`<`), menor ou igual (`=<`), maior ou igual (`=>`). Repare que em algumas operações os simbolos são ao contrario das principais linguagens, como por exemplo em c++ que possui o símbolo `>=`. Cuidado ao utilizar atribuição com simbolo not. Por exemplo:
```
boolean a = 2>3==false;
boolean b =!(true); # errado #
boolean c = !(true); # certo #
```

6. operações lógicas, And (`&&`), Or (`||`).
```
boolean a = false || true;
```

## Retorno de expressões
As expressões retornam de acordo com as tabelas a seguir. Caso caia em uma situação de erro, a compilação falha.

Primeiro serão resolvidos o que estão dentro de parenteses recursivamente procurando pelo parenteses de menor nível.

### Not
Not possuem um único operadando, e este deve ser boolean, retornando um boolean. Qualquer outro retorna Erro.

### Potência
| operando1\operando2 	|   int  	| double 	|  char  	| string 	| boolean 	|
|:-------------------:	|:------:	|:------:	|:------:	|:------:	|:-------:	|
|         int         	| double 	| double 	| double 	|  erro  	|   erro  	|
|        double       	| double 	| double 	| double 	|  erro  	|   erro  	|
|         char        	| double 	| double 	| double 	|  erro  	|   erro  	|
|        string       	|  erro  	|  erro  	|  erro  	|  erro  	|   erro  	|
|       boolean       	|  erro  	|  erro  	|  erro  	|  erro  	|   erro  	|

### Operações aritiméricas, sem adição
| operando1\operando2 	|   int  	| double 	|  char  	| string 	| boolean 	|
|:-------------------:	|:------:	|:------:	|:------:	|:------:	|:-------:	|
|         int         	|   int  	| double 	|   int  	|  erro  	|   erro  	|
|        double       	| double 	| double 	| double 	|  erro  	|   erro  	|
|         char        	|   int  	| double 	|  char  	|  erro  	|   erro  	|
|        string       	|  erro  	|  erro  	|  erro  	|  erro  	|   erro  	|
|       boolean       	|  erro  	|  erro  	|  erro  	|  erro  	|   erro  	|

### Adição
| operando1\operando2 	|   int  	| double 	|  char  	| string 	| boolean 	|
|:-------------------:	|:------:	|:------:	|:------:	|:------:	|:-------:	|
|         int         	|   int  	| double 	|   int  	| string 	|   erro  	|
|        double       	| double 	| double 	| double 	| string 	|   erro  	|
|         char        	|   int  	| double 	|  char  	| string 	|   erro  	|
|        string       	| string 	| string 	| string 	| string 	|  string 	|
|       boolean       	|  erro  	|  erro  	|  erro  	| string 	|   erro  	|

### Relacionais
| operando1\operando2 	|   int   	|  double 	|   char  	| string 	| boolean 	|
|:-------------------:	|:-------:	|:-------:	|:-------:	|:------:	|:-------:	|
|         int         	| boolean 	| boolean 	| boolean 	|  erro  	|   erro  	|
|        double       	| boolean 	| boolean 	| boolean 	|  erro  	|   erro  	|
|         char        	| boolean 	| boolean 	| boolean 	|  erro  	|   erro  	|
|        string       	|   erro  	|   erro  	|   erro  	|  erro  	|   erro  	|
|       boolean       	|   erro  	|   erro  	|   erro  	|  erro  	| boolean 	|

### Lógicos
| operando1\operando2 	|  int 	| double 	| char 	| string 	| boolean 	|
|:-------------------:	|:----:	|:------:	|:----:	|:------:	|:-------:	|
|         int         	| erro 	|  erro  	| erro 	|  erro  	|   erro  	|
|        double       	| erro 	|  erro  	| erro 	|  erro  	|   erro  	|
|         char        	| erro 	|  erro  	| erro 	|  erro  	|   erro  	|
|        string       	| erro 	|  erro  	| erro 	|  erro  	|   erro  	|
|       boolean       	| erro 	|  erro  	| erro 	|  erro  	| boolean 	|

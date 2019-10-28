# Autômatos
Nesse tópico será retratado os autômatos da linguagem Sloth. Os autômatoss são simbolos não-terminais da liguagem.

### Programa
Autômato raiz chamado primeiro pelo analisador sintático.

<img src="./Automatos/Programa.png"/>

Expressão formal:

```
(Importacao()|<COMENT>|Funcao())*
[Execucao()]
(<COMENT>)*
<EOF>
```

### Funcao

Autômato para criação de funções.

<img src="./Automatos/Funcao.png"/>

Expressão formal:

```
(<TIPOVOID>|TipoVar())
<NOMEVAR>
<ABREPAR>
[FuncPar()]
<FECHAPAR>
Bloco()
```

### FuncPar
Autômato para criar parâmetros para as funções.

<img src="./Automatos/FuncPar.png"/>

Expressão formal:

```
TipoVar()
DeclaraVarFunc()
[(<SEPFUN>)FuncPar()]
```

### DeclaraVarFunc
Autômato para criar variáveis dos parâmetros das funções, vetores não podem ter valor nas chaves.

<img src="./Automatos/DeclaraVarFunc.png"/>

Expressão formal:

```
(<NOMEVAR>)
[(<ABREVET>)(<FECHAVET>)]

```

### Retorno
Autômato para criar o retorno das funções.

<img src="./Automatos/Retorno.png"/>

Expressão formal:

```
(<RETORNO>)
[Expressao()]
```

### ChamaFuncao
Autômato para chamar funções.

<img src="./Automatos/ChamaFuncao.png"/>

Expressão formal:

```
(<NOMEVAR>)
(<ABREPAR>)
[ChamaFuncPar()]
(<FECHAPAR>)
```

### ChamaFuncPar
Autômato para chamar parâmetros para funções.

<img src="./Automatos/ChamaFuncPar.png"/>

Expressão formal:

```
(Expressao())
[(<SEPFUN>)ChamaFuncPar()]
```

### Importacao
Autômato para criar importações.

<img src="./Automatos/Importacao.png"/>

Expressão formal:

```
(<IMPORT>)
(<STRING>)
```

### Execucao
Autômato da classe principal.

<img src="./Automatos/Execucao.png"/>

Expressão formal:

```
(<FIRST>)
(Linha()|(<COMENT>))*
(<LAST>)
```

### Linha
Autômato que faz a maior parte funcional da linguagem.

<img src="./Automatos/Linha.png"/>

Expressão formal:

```
((Write()|ManVar()|Retorno())(<EOL>))
| FluxoDados()
```

### Write
Autômato para escrita no terminal.

<img src="./Automatos/Write.png"/>

Expressão formal:

```
(<WRITE>)
(<ABREPAR>)
(Expressao())
(<FECHAPAR>)	
```

### ManVar
Autômato para criação e/ou atribuição de variável.

<img src="./Automatos/ManVar.png"/>

Expressão formal:

```
(TipoVar()ManVarSeq())
| (NomeVar()Atribuica())
| ChamaFuncao()
```

### ManVarSeq
Autômato para declarar várias variáveis na mesma linha.

<img src="./Automatos/ManVarSeq.png"/>

Expressão formal:

```
DeclaraVar()
[(<SEPFUN>)ManVarSeq(b)]
```

### TipoVar
Autômato para tipos de variáveis.

<img src="./Automatos/TipoVar.png"/>

Expressão formal:

```
<TIPOBOOLEAN>
| <TIPOCHAR>
| <TIPODOUBLE>
| <TIPOINT>
| <TIPOSTRING>
```

### DeclaraVar
Autômato para declarar variáveis.

<img src="./Automatos/DeclaraVar.png"/>

Expressão formal:

```
(<NOMEVAR>)
[((<ABREVET>)
(Expressao())
(<FECHAVET>))
| (Atribuicao())]
```

### NomeVar
Autômato para nome de variáveis.

<img src="./Automatos/NomeVar.png"/>

Expressão formal:

```
(<NOMEVAR>)
[(<ABREVET>)
(Expressao())
(<FECHAVET>)]
```

### Atribuicao
Autômato para atribuição.

<img src="./Automatos/Atribuicao.png"/>

Expressão formal:

```
(<IGUALDADE>)
(Read()|Expressao())
```

### Read
Autômato para leitura do terminal.

<img src="./Automatos/Read.png"/>

Expressão formal:

```
(<GET>) 
(<ABREPAR>) 
[TipoVar()]
(<FECHAPAR>)
```

### Expressao
Autômato para criação de expressões, podendo ter numero negativo no começo.

<img src="./Automatos/Expressao.png"/>

Expressão formal:

```
[<SUB>]ExpressaoNoNeg()
```

### ExpressaoNoNeg
Autômato para criação de expressões, não podendo ter numero negativo no começo.

<img src="./Automatos/ExpressaoNoNeg.png"/>

Expressão formal:

```
(((<ABREPAR>)(Expressao())+(<FECHAPAR>))
| (<NOT>)ExpressaoNoNeg()
| ValorVar()
| ChamaFuncao()
| NomeVar())
[Operador()Expressao()]
```

### Operador
Autômato para chamar operadores.

<img src="./Automatos/Operador.png"/>

Expressão formal:

```
OpArit()|OpRelac()
```

### OpAtir
Autômato para chamar as operações aritméticas.

<img src="./Automatos/OpAtir.png"/>

Expressão formal:

```
(<ADD>)
| (<SUB>)
| (<MOD>)
| (<DIV>)
| (<POW>)
| (<MULT>)
```

### OpRelac
Autômato para chamar as operações relacionais.

<img src="./Automatos/OpRelac.png"/>

Expressão formal:

```
(<AND>)
| (<OR>)
| (<IGUAL>)
| (<DIF>)
| (<MAIGUAL>)
| (<MEIGUAL>)
| (<MAIOR>)
| (<MENOR>)
```

### ValorVar
Autômato para valores literais.

<img src="./Automatos/ValorVar.png"/>

Expressão formal:

```
(<INTEIRO>)
| (<REAL>)
| (<CARACTER>)
| (Booleano())
| (<PORCENTAGEM>)
| (<STRING>)
```

### Booleano
Autômato para tipos booleanos literais.

<img src="./Automatos/Booleando.png"/>

Expressão formal:

```
(<TRUE>)
| (<FALSE>)
```

### FluxoDados
Autômato para fluxo de dados.

<img src="./Automatos/FluxoDados.png"/>

Expressão formal:

```
While()
| For()
| Foreach()
| If()

```

### While
Autômato para o fluxo de dados while.

<img src="./Automatos/While.png"/>

Expressão formal:

```
(<WHILE>)
(<ABREPAR>)
Expressao()
(<FECHAPAR>)
Bloco()
```

### For
Autômato para o fluxo de dados for.

<img src="./Automatos/For.png"/>

Expressão formal:

```
(<FOR>)
(<ABREPAR>)
(<TIPOINT>)
(<NOMEVAR>)
Atribuicao()
(<SEPFOR>)
Expressao()
(<SEPFOR>)
Expressao()
(<FECHAPAR>)
Bloco()
```

### Foreach
Autômato para o fluxo de dados foreach.

<img src="./Automatos/ForEach.png"/>

Expressão formal:

```
(<FOREACH>)
(<ABREPAR>)
(<NOMEVAR>)
(<SEPFOR>)
(<NOMEVAR>)
(<FECHAPAR>)
Bloco()
```

### If
Autômato para o fluxo de dados if.

<img src="./Automatos/If.png"/>

Expressão formal:

```
(<IF>)
(<ABREPAR>)
Expressao()
(<FECHAPAR>)
Bloco()
[(<ELSE>)Bloco()]
```

### Bloco
Autômato para abertura de blocos.

<img src="./Automatos/Bloco.png"/>

Expressão formal:

```
(<BEGIN>)
(Linha()|(<COMENT>))*
(<END>)
```
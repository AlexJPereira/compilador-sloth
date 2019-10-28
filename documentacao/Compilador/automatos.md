# Autômatos
Nesse tópico será retratado os autômatos da linguagem Sloth. Os autômatoss são simbolos não-terminais da liguagem.

### Programa
Autômato raiz chamado primeiro pelo analisador sintático.
```
(Importacao()|<COMENT>|Funcao())*
[Execucao()]
(<COMENT>)*
<EOF>
```

### Funcao
Autômato para criação de funções.
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
```
TipoVar()
DeclaraVarFunc()
[(<SEPFUN>)FuncPar()]
```

### DeclaraVarFunc
Autômato para criar variáveis dos parâmetros das funções, vetores não podem ter valor nas chaves.
```
(<NOMEVAR>)
[(<ABREVET>)(<FECHAVET>)]

```

### Retorno
Autômato para criar o retorno das funções.
```
(<RETORNO>)
[Expressao()]
```

### ChamaFuncao
Autômato para chamar funções.
```
(<NOMEVAR>)
(<ABREPAR>)
[ChamaFuncPar()]
(<FECHAPAR>)
```

### ChamaFuncPar
Autômato para chamar parâmetros para funções.
```
(Expressao())
[(<SEPFUN>)ChamaFuncPar()]
```

### Importacao
Autômato para criar importações.
```
(<IMPORT>)
(<STRING>)
```

### Execucao
Autômato da classe principal.
```
(<FIRST>)
(Linha()|(<COMENT>))*
(<LAST>)
```

### Linha
Autômato que faz a maior parte funcional da linguagem.
```
((Write()|ManVar()|Retorno())(<EOL>))
| FluxoDados()
```

### Write
Autômato para escrita no terminal.
```
(<WRITE>)
(<ABREPAR>)
(Expressao())
(<FECHAPAR>)	
```

### ManVar
Autômato para criação e/ou atribuição de variável.
```
(TipoVar()ManVarSeq())
| (NomeVar()Atribuica())
| ChamaFuncao()
```

### ManVarSeq
Autômato para declarar várias variáveis na mesma linha.
```
DeclaraVar()
[(<SEPFUN>)ManVarSeq(b)]
```

### TipoVar
Autômato para tipos de variáveis.
```
<TIPOBOOLEAN>
| <TIPOCHAR>
| <TIPODOUBLE>
| <TIPOINT>
| <TIPOSTRING>
```

### DeclaraVar
Autômato para declarar variáveis.
```
(<NOMEVAR>)
[((<ABREVET>)
(Expressao())
(<FECHAVET>))
| (Atribuicao())]
```

### NomeVar
Autômato para nome de variáveis.
```
(<NOMEVAR>)
[(<ABREVET>)
(Expressao())
(<FECHAVET>)]
```

### Atribuicao
Autômato para atribuição.
```
(<IGUALDADE>)
(Read()|Expressao())
```

### Read
Autômato para leitura do terminal.
```
(<GET>) 
(<ABREPAR>) 
[TipoVar()]
(<FECHAPAR>)
```

### Expressao
Autômato para criação de expressões, podendo ter numero negativo no começo.
```
[<SUB>]ExpressaoNoNeg()
```

### ExpressaoNoNeg
Autômato para criação de expressões, não podendo ter numero negativo no começo.
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
```
OpArit()|OpRelac()
```

### OpAtir
Autômato para chamar as operações aritméticas.
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
```
(<TRUE>)
| (<FALSE>)
```

### FluxoDados
Autômato para fluxo de dados.
```
While()
| For()
| Foreach()
| If()

```

### While
Autômato para o fluxo de dados while.
```
(<WHILE>)
(<ABREPAR>)
Expressao()
(<FECHAPAR>)
Bloco()
```

### For
Autômato para o fluxo de dados for.
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
```
(<BEGIN>)
(Linha()|(<COMENT>))*
(<END>)
```
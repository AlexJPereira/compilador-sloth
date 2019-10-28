# Autômatos
Nesse tópico será retratado os autômatos da linguagem Sloth. Os autômatoss são simbolos não-terminais da liguagem. **Clique no campo "Autômato" para exibir o autômato referente a cada expressão formal.**

### Programa
Autômato raiz chamado primeiro pelo analisador sintático.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/Programa.png"/>
</p>
</details>

Expressão formal:

```
(Importacao()|<COMENT>|Funcao())*
[Execucao()]
(<COMENT>)*
<EOF>
```

### Funcao

Autômato para criação de funções.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/Funcao.png"/>
</p>
</details>

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


<details><summary>Autômato</summary>
<p>
<img src="./Automatos/FuncPar.png"/>
</p>
</details>

Expressão formal:

```
TipoVar()
DeclaraVarFunc()
[(<SEPFUN>)FuncPar()]
```

### DeclaraVarFunc
Autômato para criar variáveis dos parâmetros das funções, vetores não podem ter valor nas chaves.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/DeclaraVarFunc.png"/>
</p>
</details>

Expressão formal:

```
(<NOMEVAR>)
[(<ABREVET>)(<FECHAVET>)]

```

### Retorno
Autômato para criar o retorno das funções.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/Retorno.png"/>
</p>
</details>

Expressão formal:

```
(<RETORNO>)
[Expressao()]
```

### ChamaFuncao
Autômato para chamar funções.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/ChamaFuncao.png"/>
</p>
</details>

Expressão formal:

```
(<NOMEVAR>)
(<ABREPAR>)
[ChamaFuncPar()]
(<FECHAPAR>)
```

### ChamaFuncPar
Autômato para chamar parâmetros para funções.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/ChamaFuncPar.png"/>
</p>
</details>

Expressão formal:

```
(Expressao())
[(<SEPFUN>)ChamaFuncPar()]
```

### Importacao
Autômato para criar importações.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/Importacao.png"/>
</p>
</details>

Expressão formal:

```
(<IMPORT>)
(<STRING>)
```

### Execucao
Autômato da classe principal.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/Execucao.png"/>
</p>
</details>

Expressão formal:

```
(<FIRST>)
(Linha()|(<COMENT>))*
(<LAST>)
```

### Linha
Autômato que faz a maior parte funcional da linguagem.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/Linha.png"/>
</p>
</details>

Expressão formal:

```
((Write()|ManVar()|Retorno())(<EOL>))
| FluxoDados()
```

### Write
Autômato para escrita no terminal.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/Write.png"/>
</p>
</details>

Expressão formal:

```
(<WRITE>)
(<ABREPAR>)
(Expressao())
(<FECHAPAR>)	
```

### ManVar
Autômato para criação e/ou atribuição de variável.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/ManVar.png"/>
</p>
</details>

Expressão formal:

```
(TipoVar()ManVarSeq())
| (NomeVar()Atribuica())
| ChamaFuncao()
```

### ManVarSeq
Autômato para declarar várias variáveis na mesma linha.


<details><summary>Autômato</summary>
<p>
<img src="./Automatos/ManVarSeq.png"/>
</p>
</details>

Expressão formal:

```
DeclaraVar()
[(<SEPFUN>)ManVarSeq(b)]
```

### TipoVar
Autômato para tipos de variáveis.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/TipoVar.png"/>
</p>
</details>

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

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/DeclaraVar.png"/>
</p>
</details>

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

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/NomeVar.png"/>
</p>
</details>


Expressão formal:

```
(<NOMEVAR>)
[(<ABREVET>)
(Expressao())
(<FECHAVET>)]
```

### Atribuicao
Autômato para atribuição.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/Atribuicao.png"/>
</p>
</details>


Expressão formal:

```
(<IGUALDADE>)
(Read()|Expressao())
```

### Read
Autômato para leitura do terminal.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/Read.png"/>
</p>
</details>

Expressão formal:

```
(<GET>) 
(<ABREPAR>) 
[TipoVar()]
(<FECHAPAR>)
```

### Expressao
Autômato para criação de expressões, podendo ter numero negativo no começo.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/Expressao.png"/>
</p>
</details>

Expressão formal:

```
((<ABREPAR>)((Expressao())+(<FECHAPAR>))
|(<NOT>)ExpressaoNoNeg()
|ValorVal()
|ChamaFuncao()
|NomeVar()
[Operador()Expressao()]
```

### ExpressaoNoNeg
Autômato para criação de expressões, não podendo ter numero negativo no começo.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/ExpressaoNoNeg.png"/>
</p>
</details>

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




Expressão formal:

```
OpArit()|OpRelac()
```

### OpAtir
Autômato para chamar as operações aritméticas.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/OpAtir.png"/>
</p>
</details>


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

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/OpRelac.png"/>
</p>
</details>

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

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/ValorVar.png"/>
</p>
</details>

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

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/Booleando.png"/>
</p>
</details>

Expressão formal:

```
(<TRUE>)
| (<FALSE>)
```

### FluxoDados
Autômato para fluxo de dados.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/FluxoDados.png"/>
</p>
</details>

Expressão formal:

```
While()
| For()
| Foreach()
| If()

```

### While
Autômato para o fluxo de dados while.

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/While.png"/>
</p>
</details>

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

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/For.png"/>
</p>
</details>

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

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/ForEach.png"/>
</p>
</details>

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

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/If.png"/>
</p>
</details>

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

<details><summary>Autômato</summary>
<p>
<img src="./Automatos/Bloco.png"/>
</p>
</details>

Expressão formal:

```
(<BEGIN>)
(Linha()|(<COMENT>))*
(<END>)
```
# Tokens
Nesse tópico será retratado os tokens da linguagem Sloth. Os tokens são simbolos terminais da liguagem, a maioria considerados palavras reservadas. Nas expressões regulares `\` é um caractere especial do JavaCC para utilizar caracteres como `"`.

<a id="indice"></a>
## Indice
* [1. Caracteres](#caracteres)
* [2. Tipos de Variáveis](#tipvar)
    * [2.1 Booleanos](#bool)
    * [2.2 Números](#num)
    * [2.3 Caracteres](#char)
    * [2.4 Containers](#vet)
* [3. Operadores Aritiméticos](#oparit)
* [4. Operadores Relacionais](#oprel)
* [5. Operadores Lógicos](#oplog)
* [6. Condicionais](#cond)
* [7. Laços](#lac)
* [8. Blocos](#bloc)
* [9. Extras](#ex)

<a id="caracteres" href="#indice">top</a>
## 1. Caracteres 

#### Digito
- Descrição: numeros da linguagem.
- Expressão regular: `["0" - "9"]`
- Token JavaCC: `<#DIGITO>`

#### Letra
- Descrição: letras da linguagem.
- Expressão regular: `["a"-"z","A"-"Z"]`
- Token JavaCC: `<#LETRA>`

#### Caractere
- Descrição: letras e numeros da linguagem.
- Expressão regular: `<LETRA>|<DIGITO>`
- Token JavaCC: `<#CARACTERE>`

#### Asc
- Descrição: tabela asc sem `"`, `'` e `#`.
- Expressão regular: `["\0"-"!","$"-"&","("-"~"]`
- Token JavaCC: <#ASC>

#### Nome de variáveis
- Descrição: nome de variáveis. Deve-se utilizar esse token no final para não ter conflito com outros tokens.
- Expressão regular: `<LETRA>(<CARACTERE>)*`
- Token JavaCC: `<NOMEVAR>`

<a id="tipvar" href="#indice">top</a>
## 2. Tipos de variáveis

#### Inteiro
- Descrição: declaração inteira.
- Expressão regular: `"int"`
- Token JavaCC: `<TIPOINT>`

#### Real
- Descrição: declaração real.
- Expressão regular: `"double"`
- Token JavaCC: `<TIPODOUBLE>`

#### Caractere
- Descrição: declaração de caractere.
- Expressão regular: `"char"`
- Token JavaCC: `<TIPOCHAR>`

#### Texto
- Descrição: declaração de texto.
- Expressão regular: `"string"`
- Token JavaCC: `<TIPOSTRING>`

#### Lógico
- Descrição: declaração lógico.
- Expressão regular: `"boolean"`
- Token JavaCC: `<TIPOBOOLEAN>`

#### Void
- Descrição: void das funções.
- Expressão regular: `"void"`
- Token JavaCC: `<TIPOVOID>`

<a id="bool" href="#indice">top</a>
### 2.1 Booleanos

#### Verdadeiro
- Descrição: tipo verdadeiro.
- Expressão regular: `"true"`
- Token JavaCC: `<TRUE>`

#### Falso
- Descrição: tipo false.
- Expressão regular: `"false"`
- Token JavaCC: `<FALSE>`

<a id="num" href="#indice">top</a>
### 2.2 Números

#### Numero inteiro
- Descrição: numero inteiro literal.
- Expressão regular: `(<DIGITO>)+`
- Token JavaCC: `<INTEIRO>`

#### Numero real
- Descrição: numero real literal.
- Expressão regular: `<INTEIRO><PONTO><INTEIRO>`
- Token JavaCC: `<REAL>`

#### Porcentagem
- Descrição: numero real em porcentagem literal.
- Expressão regular: `(<REAL>|<INTEIRO>)<PORCE>`
- Token JavaCC: `<PORCENTAGEM>`

#### Separador inteiro-decimal
- Descrição: separa decimal de fracionário.
- Expressão regular: `"."` 
- Token JavaCC: `<PONTO>`

#### 

<a id="char" href="#indice">top</a>
### 2.3 Caracteres

#### Caractere
- Descrição: caractere literal, não confundir com `<CARACTERE>`.
- Expressão regular: `"'"<ASC>"'"`
- Token JavaCC: `<CARACTER>`

#### Texto
- Descrição: texto literal.
- Expressão regular: `"\""(<ASC>)*"\""`
- Token JavaCC: `<STRING>`

#### Quebra de linha
- Descrição: quebra de linha.
- Expressão regular: `"\\n"`
- Token JavaCC: `<ENDL>`

#### Terminador de linha
- Descrição: fim de uma linha
- Expressão regular: `";"`
- Token JavaCC: `<EOL>`

<a id="vet" href="#indice">top</a>
### 2.4 Containers

#### Abertura de índice
- Descrição: abre para uma expressão de indice.
- Expressão regular: `"["`
- Token JavaCC: `<ABREVET>`

#### Fechamento de índice
- Descrição: fecha o indice do vetor.
- Expressão regular: `"]"`
- Token JavaCC: `<FECHAVET>`

<a id="oparit" href="#indice">top</a>
## 3. Operadores Aritiméticos

#### Adição
- Descrição: operador de adição.
- Expressão regular: `"+"`
- Token JavaCC: `<ADD>`

#### Subtração
- Descrição: operador de subtração.
- Expressão regular: `"-"`
- Token JavaCC: `<SUB>`

#### Multiplicação
- Descrição: operador de multiplicação.
- Expressão regular: `"*"`
- Token JavaCC: `<MULT>`

#### Divisão
- Descrição: operador de divisão.
- Expressão regular: `"/"`
- Token JavaCC: `<DIV>`

#### Resto da divisão
- Descrição: operador de resto da divisão.
- Expressão regular: `"//"`
- Token JavaCC: `<MOD>`

#### Potência
- Descrição: operador de potenciação.
- Expressão regular: `"^"`
- Token JavaCC: `<POW>`

#### Porcentagem
- Descrição: transforma um numero em porcentagem.
- Expressão regular: `"%"`
- Token JavaCC: `<PORCE>`

#### Inicio do separador
- Descrição: abertura de parênteses de uma expressão.
- Expressão regular: `"("`
- Token JavaCC: `<ABREPAR>`

#### Término do separador
- Descrição: fechamento de parênteses de uma expressão.
- Expressão regular: `")"`
- Token JavaCC: `<FECHAPAR>`

<a id="oprel" href="#indice">top</a>
## 4. Operadores Relacionais

#### Igual
- Descrição: operador de igualdade.
- Expressão regular: `"=="`
- Token JavaCC: `<IGUAL>`

#### Diferente
- Descrição: operador de diferente.
- Expressão regular: `"=!"`
- Token JavaCC: `<DIF>`

#### Maior
- Descrição: operador de maior.
- Expressão regular: `">"`
- Token JavaCC: `<MAIOR>`

#### Menor
- Descrição: operador de menor.
- Expressão regular: `"<"`
- Token JavaCC: `<MENOR>`

#### Maior ou igual
- Descrição: operador de maior ou igual.
- Expressão regular: `"=>"`
- Token JavaCC: `<MAIGUAL>`

#### Menor ou igual
- Descrição: operador de menor ou igual.
- Expressão regular: `"=<"`
- Token JavaCC: `<MEIGUAL>`

<a id="oplog" href="#indice">top</a>
## 5. Operadores Lógicos

#### And
- Descrição: operador lógico And
- Expressão regular: `"&&"`
- Token JavaCC: `<AND>`

#### Or
- Descrição: operador lógico Or
- Expressão regular: `"||"`
- Token JavaCC: `<OR>`

#### Not
- Descrição: operador lógico Not
- Expressão regular: `"!"`
- Token JavaCC: `<NOT>`

<a id="cond" href="#indice">top</a>
## 6. Condicionais

#### Condicional
- Descrição: caso seja verdade.
- Expressão regular: `"when"`
- Token JavaCC: `<IF>`

#### Caso oposto
- Descrição: caso contrario.
- Expressão regular: `"otherwise"`
- Token JavaCC: `<ELSE>`

<a id="lac" href="#indice">top</a>
## 7. Laços

#### Enquanto for verdade
- Descrição: enquanto for verdade.
- Expressão regular: `"while"`
- Token JavaCC: `<WHILE>`

#### Para tanto
- Descrição: para tanto.
- Expressão regular: `"for"`
- Token JavaCC: `<FOR>`

#### Para cada
- Descrição: para cada valor de uma array.
- Expressão regular: `"foreach"`
- Token JavaCC: `<FOREACH>`

<a id="bloc" href="#indice">top</a>
## 8. Blocos

#### Início do programa
- Descrição: inicio do programa principal.
- Expressão regular: `"first"`
- Token JavaCC: `<FIRST>`

#### Final do programa
- Descrição: final do programa principal.
- Expressão regular: `"last"`
- Token JavaCC: `<LAST>`

#### Início do Bloco
- Descrição: incio de um bloco.
- Expressão regular: `"begin"`
- Token JavaCC: `<BEGIN>`

#### Final do Bloco
- Descrição: final de um bloco.
- Expressão regular: `"end"`
- Token JavaCC: `<END>`

<a id="ex" href="#indice">top</a>
## 9. Extras

#### Comentário
- Descrição: coméntario do usuário, não ignorado na compilação do Sloth, mas ignorado pelo Java.
- Expressão regular: `"#"(<ASC>|"\""|"\'")*"#"`
- Token JavaCC: `<COMENT>`

#### Importação
- Descrição: importação de arquivos.
- Expressão regular: `"import"`
- Token JavaCC: `<IMPORT>`

#### Leitura
- Descrição: operação de leitura do terminal.
- Expressão regular: `"get"`
- Token JavaCC: `<GET>`

#### Escrita
- Descrição: operação de escrita no terminal.
- Expressão regular: `"write"`
- Token JavaCC: `<WRITE>`

#### Retorno
- Descrição: retorno das funções.
- Expressão regular: `"return"`
- Token JavaCC: `<RETORNO>`
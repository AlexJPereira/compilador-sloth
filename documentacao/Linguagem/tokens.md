# Tokens
Nesse tópico será retratado os tokens da linguagem Sloth. Os tokens são simbolos terminais da liguagem, podendo ser considerados palavras reservadas.

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
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>DIGITO>

#### Letra
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>LETRA>

#### Caractere
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>CARACTERE>

<a id="tipvar" href="#indice">top</a>
## 2. Tipos de variáveis

#### Inteiro
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>INT>

#### Real
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>DOUBLE>

#### Caractere
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>CHAR>

#### Frase
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>STRING>

#### Lógico
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>BOOLEAN>

<a id="bool" href="#indice">top</a>
### 2.1 Booleanos

#### Verdadeiro
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>TRUE>

#### Falso
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>FALSE>

<a id="num" href="#indice">top</a>
### 2.2 Números

#### Separador inteiro-decimal
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>PONTO>

#### Negativo
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>NEG>

<a id="char" href="#indice">top</a>
### 2.3 Caracteres

#### Quebra de linha
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>ENDL>

#### Terminador de linha
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>EOL>

<a id="vet" href="#indice">top</a>
### 2.4 Containers

#### Abertura de índice
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>ABREVET>

#### Fechamento de índice
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>FECHAVET>

<a id="oparit" href="#indice">top</a>
## 3. Operadores Aritiméticos

#### Adição
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>ADD>

#### Subtração
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>SUB>

#### Multiplicação
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>MULT>

#### Divisão
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>DIV>

#### Resto da divisão
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>MOD>

#### Potência
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>POW>

#### Porcentagem
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>PORCE>

#### Inicio do separador
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>ABREPAR>

#### Término do separador
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>FECHAPAR>

<a id="oprel" href="#indice">top</a>
## 4. Operadores Relacionais

#### Igual
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>IGUAL>

#### Diferente
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>DIF>

#### Maior
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>MAIOR>

#### Menor
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>MENOR>

#### Maior ou igual
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>MAIGUAL>

#### Menor ou igual
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>MEIGUAL>

<a id="oplog" href="#indice">top</a>
## 5. Operadores Lógicos

#### And
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>AND>

#### Or
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>OR>

#### Not
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>NOT>

#### Xor
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>XOR>

<a id="cond" href="#indice">top</a>
## 6. Condicionais

#### Condicional
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>IF>

#### Caso oposto
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>ELSE>

<a id="lac" href="#indice">top</a>
## 7. Laços

#### Enquanto for verdade
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>WHILE>

#### Para tanto
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>FOR>

#### Para cada
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>FOREACH>

<a id="bloc" href="#indice">top</a>
## 8. Blocos

#### Início do programa
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>FIRST>

#### Final do programa
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>LAST>

#### Início do Bloco
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>BEGIN>

#### Final do Bloco
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>END>

<a id="ex" href="#indice">top</a>
## 9. Extras

#### Comentário
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>COMENT>

#### Importação
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>IMPORT>

#### Leitura
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>GET>

#### Escrita
- Descrição: 
- Expressão regular: 
- Token JavaCC: <</a>WRITE>
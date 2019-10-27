# Tokens
Nesse tópico será retratado os tokens da linguagem Sloth. Os tokens são simbolos terminais da liguagem, a maioria considerados palavras reservadas.

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
- Token JavaCC: <#DIGITO>

#### Letra
- Descrição: 
- Expressão regular: 
- Token JavaCC: <#LETRA>

#### Caractere
- Descrição: 
- Expressão regular: 
- Token JavaCC: <#CARACTERE>

<a id="tipvar" href="#indice">top</a>
## 2. Tipos de variáveis

#### Inteiro
- Descrição: 
- Expressão regular: 
- Token JavaCC: <INT>

#### Real
- Descrição: 
- Expressão regular: 
- Token JavaCC: <DOUBLE>

#### Caractere
- Descrição: 
- Expressão regular: 
- Token JavaCC: <CHAR>

#### Frase
- Descrição: 
- Expressão regular: 
- Token JavaCC: <STRING>

#### Lógico
- Descrição: 
- Expressão regular: 
- Token JavaCC: <BOOLEAN>

<a id="bool" href="#indice">top</a>
### 2.1 Booleanos

#### Verdadeiro
- Descrição: 
- Expressão regular: 
- Token JavaCC: <TRUE>

#### Falso
- Descrição: 
- Expressão regular: 
- Token JavaCC: <FALSE>

<a id="num" href="#indice">top</a>
### 2.2 Números

#### Separador inteiro-decimal
- Descrição: 
- Expressão regular: 
- Token JavaCC: <PONTO>

#### Negativo
- Descrição: 
- Expressão regular: 
- Token JavaCC: <NEG>

<a id="char" href="#indice">top</a>
### 2.3 Caracteres

#### Quebra de linha
- Descrição: 
- Expressão regular: 
- Token JavaCC: <ENDL>

#### Terminador de linha
- Descrição: 
- Expressão regular: 
- Token JavaCC: <EOL>

<a id="vet" href="#indice">top</a>
### 2.4 Containers

#### Abertura de índice
- Descrição: 
- Expressão regular: 
- Token JavaCC: <ABREVET>

#### Fechamento de índice
- Descrição: 
- Expressão regular: 
- Token JavaCC: <FECHAVET>

<a id="oparit" href="#indice">top</a>
## 3. Operadores Aritiméticos

#### Adição
- Descrição: 
- Expressão regular: 
- Token JavaCC: <ADD>

#### Subtração
- Descrição: 
- Expressão regular: 
- Token JavaCC: <SUB>

#### Multiplicação
- Descrição: 
- Expressão regular: 
- Token JavaCC: <MULT>

#### Divisão
- Descrição: 
- Expressão regular: 
- Token JavaCC: <DIV>

#### Resto da divisão
- Descrição: 
- Expressão regular: 
- Token JavaCC: <MOD>

#### Potência
- Descrição: 
- Expressão regular: 
- Token JavaCC: <POW>

#### Porcentagem
- Descrição: 
- Expressão regular: 
- Token JavaCC: <PORCE>

#### Inicio do separador
- Descrição: 
- Expressão regular: 
- Token JavaCC: <ABREPAR>

#### Término do separador
- Descrição: 
- Expressão regular: 
- Token JavaCC: <FECHAPAR>

<a id="oprel" href="#indice">top</a>
## 4. Operadores Relacionais

#### Igual
- Descrição: 
- Expressão regular: 
- Token JavaCC: <IGUAL>

#### Diferente
- Descrição: 
- Expressão regular: 
- Token JavaCC: <DIF>

#### Maior
- Descrição: 
- Expressão regular: 
- Token JavaCC: <MAIOR>

#### Menor
- Descrição: 
- Expressão regular: 
- Token JavaCC: <MENOR>

#### Maior ou igual
- Descrição: 
- Expressão regular: 
- Token JavaCC: <MAIGUAL>

#### Menor ou igual
- Descrição: 
- Expressão regular: 
- Token JavaCC: <MEIGUAL>

<a id="oplog" href="#indice">top</a>
## 5. Operadores Lógicos

#### And
- Descrição: 
- Expressão regular: 
- Token JavaCC: <AND>

#### Or
- Descrição: 
- Expressão regular: 
- Token JavaCC: <OR>

#### Not
- Descrição: 
- Expressão regular: 
- Token JavaCC: <NOT>

<a id="cond" href="#indice">top</a>
## 6. Condicionais

#### Condicional
- Descrição: 
- Expressão regular: 
- Token JavaCC: <IF>

#### Caso oposto
- Descrição: 
- Expressão regular: 
- Token JavaCC: <ELSE>

<a id="lac" href="#indice">top</a>
## 7. Laços

#### Enquanto for verdade
- Descrição: 
- Expressão regular: 
- Token JavaCC: <WHILE>

#### Para tanto
- Descrição: 
- Expressão regular: 
- Token JavaCC: <FOR>

#### Para cada
- Descrição: 
- Expressão regular: 
- Token JavaCC: <FOREACH>

<a id="bloc" href="#indice">top</a>
## 8. Blocos

#### Início do programa
- Descrição: 
- Expressão regular: 
- Token JavaCC: <FIRST>

#### Final do programa
- Descrição: 
- Expressão regular: 
- Token JavaCC: <LAST>

#### Início do Bloco
- Descrição: 
- Expressão regular: 
- Token JavaCC: <BEGIN>

#### Final do Bloco
- Descrição: 
- Expressão regular: 
- Token JavaCC: <END>

<a id="ex" href="#indice">top</a>
## 9. Extras

#### Comentário
- Descrição: 
- Expressão regular: 
- Token JavaCC: <COMENT>

#### Importação
- Descrição: 
- Expressão regular: 
- Token JavaCC: <IMPORT>

#### Leitura
- Descrição: 
- Expressão regular: 
- Token JavaCC: <GET>

#### Escrita
- Descrição: 
- Expressão regular: 
- Token JavaCC: <WRITE>
# Análise sintática
A análise sintática foi feita através da linguagem de programação do JavaCC. Através da classe `CompiladorSloth` criada pelo próprio JavaCC ele vai descobrindo se a sequência de tokens está correta. Os autômatos da análise sintática podem ser vistos na seção [Autômatos](../Automatos/README.md).

Características do analisador sintático:

|     característica     	|       tipo      	|                                    descrição                                    	|
|:----------------------:	|:---------------:	|:-------------------------------------------------------------------------------:	|
| estratégia de análise  	| descendente     	| leitura da base para as folha na árvore de autômatos                            	|
| símbolos terminais     	| tokens          	| tokens gerados pela análise léxica                                              	|
| simbolos não terminais 	| autômatos       	| funções do analisador sintático                                                 	|
| simbolo inicial        	| Programa()      	| autômato inicial que desencadeia a árvore                                       	|
| tipo de derivação      	| mais a esquerda 	| os primeiros símbolos a serem derivados são os da esquerda da expressão regular 	|


Na linguagem do JavaCC os autômatos são declarados da segunte maneira:

```
tipo nome(parâmetros)
{variáveis locais}
{
    expressãoRegular{funçõesOpcionais}
}
```
- tipo: indentifica o retorno da função do autômato, é util quando um autômato de nivel acima precisa saber qual caminho esse autômato pegou.
- nome: representa o nome do autômato.
- parâmetros: o autômato pode receber parâmetros que são em geral utilizado pelas `funçõesOpcionais`.
- variáveis locais: igual os parâmetros são utilizadas em geral pelas `funçõesOpcionais`, também é utilizado para guardar os Token em uma lista. Infelizmente essa lista é nescessária, visto que o analisador léxico não a possui, ele vai lendo e já descartando.
- expressãoRegular: é a expressão regular que representa o autômato. Existe uma função chamada `LOOKAHEAD(valor)` que ajuda a contornar redundâncias.
- LOOKAHEAD(valor): essa função ajuda a trabalhar com redundâncias. Quando temos dois caminhos que um autômato pode percorrer e ambos os caminhos começam com o mesmo token, temos uma redundância. O lookahead diz para o analisador léxico analisar tantos autômatos à frente antes de chegar a uma conclusão de qu   al caminho o autômato deve seguir. O numero de autômatos que devem ser analisados á frente é o `valor`.
- funçõesOpicionais: servem para fazer alguma coisa quando algo acontecer. Alguns exemplos de usos, adicionar um token a uma lista sempre que aparecer um token, pedir para o analisador semântico verificar se uma variável já foi declarada.

## Redundâncias
Redundâncias no JavaCC são fáceis de serem tratadas mas aumentam o tempo de compilação. No final o que deve ser decidido é a preferência entre otimização e organização. Se a preferência for otimização o compilador pode ficar mais rápido quando se trata de programas muito grandes, porem para programas pequenos essa otimização é inpersepitível. Se a prefeência for organização, o código do compilador fica mais organizado e de mais fácil manutençao. No final escolhemos tratar as redundâncias com `LOOKAHEAD` para manter o código organizado e de fácil manutenção. Caso a escolha tivesse sido a oposta, teríamos que separar os aumômatos redundântes em outros autômatos ou tokens seguidos de autômatos, isso acaba sendo uma opção em aberta de upgrade para esse trabalho.
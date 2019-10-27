# Criação do compilador

O compilador foi feito em Java e criado com o auxílio do compilador JavaCC, que criou a maior parte do código Java do programa.

As etapas da compilação são:
- Análise Léxica
- Análise Sintática
- Análise Semântica
- Geração de código

As etapas de análise léxica, sintática e semântica são feitas simultâneamente, essa é uma característica do próprio JavaCC.

A função principal do compilador cria um analisador semântico estático, que possibilita que todos os compiladores gerados recursivamente através de importações feitas pelo usuário tenham o mesmo analisador semântico, assim adicionando o código do usuário na mesma lista de tokens. Além disso a função principal recebe dois parâmetros, um arquivo para compilação, e um nome de arquivo que será gerado da compilação. Após criar os objetos nescessários para a compilação, a função principal chama o analisador sintático que por sua vez vai chamando o analisador léxico e semântico enquanto vai analisando o cógigo, depois a função principal chama o gerador de código alvo para traduzir o código do usuário para Java (`.java`) e uma lista de tokens (`.txt`).
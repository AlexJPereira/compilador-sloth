# Criação do compilador

O compilador foi feito em Java e criado com o auxílio do compilador JavaCC, que criou a maior parte do código Java do programa.

As etapas da compilação são:
- Análise Léxica
- Análise Sintática
- Análise Semântica
- Geração de código

As etapas de análise léxica, sintática e semântica são feitas simultâneamente, essa é uma característica do próprio JavaCC.
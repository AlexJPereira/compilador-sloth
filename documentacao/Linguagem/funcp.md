# Função principal

A função principal pode ser seguida de várias funções, comentários e importações e só pode existir apenas uma função principal em um programa.

## Comentários
Os comentarios podem ser colocados em qualquer parte do código que não atrapalhe a sintaxe, não podem ser utilizados no meio de expressões por exemplo. para escrever um comentário basta utilizar hash.
```
# esse é um comentário #
```

## Importações
As importações devem possuir arquivos com o diretório relativo ao arquivo principal, além disso a linguagem NÃO trata importação ciclica, então cuidado.

```
import "umaImportacao.sloth"
```

## Funções
As funções podem ser do tipo void e possuirem ou não um retorno sem nada, ou podem ser de algum tipo específico, assim devem possuir um retorno com uma expressão de um tipo que possa se comportar como ao do tipo da função.

```
int fibonacci(int n) begin
    when (n < 2) begin
        return n;
    end otherwise begin
        return fibonacci(n - 1) + fibonacci(n - 2);
    end
end
```

## Função principal
Dentro da função principal pode ter manipulações de variáveis, funções de I/O e chamadas de funções do usuário definidas anteriormente. A função principal é opcional em um arquivo porem deve-se ter no maximo 1 em um programa, assim não se deve importar um arquivo com uma função principal se o próprio arquivo já possui.

```
first
    # aqui pode ir o seu programa OwO #
last
```
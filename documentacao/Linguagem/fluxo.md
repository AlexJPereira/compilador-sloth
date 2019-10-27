# Fluxo de Dados

Os fluxos de dados são:
- for (`for`)
- while (`while`)
- foreach (`foreach`)
- if (`when`)
- else (`otherwise`)

Todas as variáveis declaradas dentro de um fluxo de dados só ficarão visíveis até o termino do fluxo de dados.

## for
Inspirado no `for` do matlab, a primeira parte da sintaxe é a declaração de uma variável exclusivamente inteira, a segunda parte fala até quanto essa variável deve chegar para finalizar o `for` e a terceira parte fala em que passo essa variavel vai. Repare no código a seguir, o separador do `for` são doi pontos (`:`) e não ponto e vírgula (`;`).

```
for (int i = 0 : 5+2 : 1*1) begin
    # codigo #
end
```
Todas as expressões devem funcionar em números inteiros, conforme a <a href="./var.md/#tabelaTipo">tabela</a> da seção de variáveis.

O código exemplo acima gera em Java:
```
for(int i=0;i<5+2;i=i+1*1){
    /* codigo */
}
```

## while
Similar a outras linguagens, possui uma expressão do tipo booleana que enquanto ela for verdade ele fará o loop. Diferentemente de algumas linguagem, ele não aceita outros tipos de expressão a não ser booleano, como visto na <a href="./var.md/#tabelaTipo">tabela</a> da seção de variáveis.

```
while(a>3) begin
    # codigo #
end
```

## foreach
Similar ao foreach do próprio Java. A primeira parte da sintaxe é a variável a qual será mudada a cada loop, e a segunda parte deve ser obrigatóriamente um container. Diferentemente do Java não é necessário colocar o tipo da primeira parte, ele busca o tipo da segunda parte.

```
double lista[3];

foreach(num : lista) begin
    # codigo #
end
```

O código exemplo acima gera em Java:
```
double lista[] = new double[3];

for(double num : lista){
    /* codigo */
}
```

## if
Similar ao de outras linguagens e igual ao while só aceita expressões do tipo boolean.

```
when(a>3) begin
    # se for verdade #
end otherwise begin
    # se nao for #
end
```

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
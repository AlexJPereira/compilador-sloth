# Geração de Código
A geração de código foi feita através da classe `CodeTranslator` criada pelos próprios integrantes do grupo. Ela traduz a lista de tokens da classe `Codigo` para Java e para um arquivo de texto com os nomes dos tokens.

Utilizando duas StringBuilder's, uma para cada código alvo, foi traduzido o código.

## Código Java
Diferentes tokens foram tratados de forma diferentes. Tokens que mudam a palavra do token foram criados métodos privados para cada um deles. Token que não mudam a palavra, foi criado um método padrão para todos eles.

### EOF
O fim do arquivo compilado, finalizando a tradução. Este não é colocado no código alvo.

### ABREVET
A declaração de um vetor deve ser traduzida para a criação de um objeto novo.

Sloth:
```
int a[3], b;
```
Java:
```
int a[] = new int[3], b;
```

### TIPOSTRING
A letra `s` da palavra `string` na linguagem Sloth é minuscula, enquanto na linguagem Java é maiúscula.

Sloth:
```
string a = "hello";
```
Java:
```
String a = "hello";
```

### MOD, DIF, MAIGUAL, MEIGUAL, IF, ELSE, WRITE
Estes tokens são difetentes em java.

Sloth:
```
when(true) begin
    boolean a = (2//3=>3)=!(2=<3);
end otherwise begin
    write("hello");
end
```
Java:
```
if(true){
    boolean a = (2%3>=3)!=(2<=3);
} else{
    System.out.print("hello");
}
```

### POW
A potenciação em java é uma método da classe Math chamado Pow. Assim o código traduzido é um pouco mais complexo.

Sloth:
```
double a = 3+2^3;
double b = (4*5)/(2*(3-1)/2)^(2+4);
```
Java:
```
double a = 3+Math.Pow(2,3);
double b = (4*5)/Math.Pow((2*(3-1)/2),(2+4));
```

### FOR
O for do sloth foi baseado no matlab, então a sua sintaxe é diferente.

Sloth:
```
for(int i=0: 2+2 : 3*3)
```
Java:
```
for(int i=0; i<2+2; i=i+3*3)
```

### FOREACH
O foreach do java é o próprio for, mas a sintaxe é parecida. A diferença é a linguagem sloth não precisa dizer o tipo da primeira variável, ele ja identifica.

Sloth:
```
double b[2];
foreach(a : b) begin
    # codigo #
end
```
Java:
```
double b[] = new double[2];
for(double a : b){
    /* codigo */
}
```

### FIRST, LAST, BEGIN, END, EOL
Todos esses tokens devem ter uma quebra de linha depois de traduzir, além disso inicio e final de blocos devem arrumar o numero de tabs que devem ter para deixar o programa estéticamente bonito.

Sloth:
```
first when(true) begin int a; end last
```
Java:
```
public static void main(String[] args){
    if(true){
        int a;
    }
}
```

### COMENT
Comentarios possuem símbolos diferentes para abertura e fechamento.

Sloth:
```
# comentario #
```
Java:
```
/* comentario */
```

### PORCENTAGEM
Porcentagem são nada mais que numeros reais divididos por 100.

Sloth:
```
double a = 125%;
```
Java:
```
double a = 1.25;
```
### GET e WRITE
A função get é diferente para cada tipo de variável, além disso ela deve importar a biblioteca de `Scanner`, apenas se encontrar a função get, e apenas uma unica vez.

Sloth:
```
first
    int a = get(int);
    double b = get(double);
    char c = get(char);
    string d = get(string);
    string e = get();
    boolean f = get(boolean);
last
```
Java:
```
import java.util.Scanner;
public class App{
    private static Scanner get = new Scanner(System.in);
    public static void main(String[] args){
        int a = get.nextInt();
        double b = get.nextDouble();
        char c = get.next().charAt(0);
        string d = get.nextLine();
        string e = get.nextLine();
        boolean f = get.nextBoolean();
    }
}
```

### Funções
Funções são declarados antes do main do Java, assim elas devem ser estáticas para poderem ser utilizadas dentro do main.

Sloth:
```
void a() begin
    # funcao #
end

first
    # codigo #
last
```
Java:
```
public class App{
    private static void a(){
        /* funcao */
    }
    public static void main(String[] args){
        /* codigo */
    }
}
```

### RETORNO e TIPOVAR
As palavras `return` e qualquer tipo de variável devem ser seguidas de espaço, se não podem se juntar com algum nome de variável.

Sloth:
```
int a() begin
    return 2;
    # em vez de return2 #
end
```
Java:
```
private static int a(){
    return 2;
    /* em vez de return2 */
}
```
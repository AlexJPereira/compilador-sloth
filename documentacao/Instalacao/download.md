# Download

A linguagem sloth foi produzida utilizando JavaCC, sua instalação é necessária para a criação da linguagem.
Os passos para a instalação da ferramenta em linux e em windows são apresentados a seguir.

## Windows

O download pode ser feito acessando o site oficial da ferramenta:
[JavaCC](https://javacc.org/download)

É recomendado utilizar a versão 5.0, pois esta foi testada durante a realização do projeto e se apresenta estável.
Após o download da ferramenta é necessário realizar a extração dos arquivos contidos na pasta zip. Recomenda-se armazenar a pasta do Javacc no meus documentos.
Para que seja possível a utilização do javacc através de linha de comando no cmd do windows é necessário adicionar o local da pasta do JavaCC no path do sistema seguindo os seguintes passos:

1. Abra o painel de controle
2. Clique em "Sistema e Segurança"
3. Em seguida selecione a opção "Sistema"
4. No campo a esquerda procure por "Configurações avançadas do sistema"
5. Na aba "Avançado", clique em "Variaveis de Ambiente"
6. No campo "Variveis do sistema", procure pela variável PATH.
7. Clique no botão "editar". (OBSERVAÇÂO: DE MANEIRA ALGUMA CLIQUE NO BOTAO EXCLUIR!!!)
8. Copie ou digite o endereço da pasta \bin contida no diretório do JAVACC, clique em aplicar/ok. 
9. Teste a execução correta dos comandos abrindo o cmd e digitando a linha "javacc"

Para a compilação dos arquivos gerados é necessario também a instalação do Java.
Instalando o jdk em windows:
Faça o download do arquivo através do [site](https://www.oracle.com/technetwork/pt/java/javase/downloads/jdk-netbeans-jsp-3413153-ptb.html), é necessário realizar o cadastro ou se identificar utilizando uma conta da Oracle.
Também é necessario adcionar o caminho da pasta bin do jdk no path do sistema para que seja possível compilar os arquivos através do prompt de comando. 

## Linux
Para fazer a instalação do javacc em linux basta utilizar as seguintes linhas de comando. 
sudo apt-get update
sudo apt-get install javacc

## Download dos arquivos referentes ao compilador Sloth

Para fazer o download do projeto do compilador da Linguagem SLOTH acesse o respostirório do GitHub:
https://github.com/wykke/TrabalhoECOM06E 

Para fazer dowload do arquivo selecione o botão "Clone/Download".
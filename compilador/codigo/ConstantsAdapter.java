public class ConstantsAdapter implements CompiladorSlothConstants{

    private String[] tokenImage;

    public ConstantsAdapter(String[] ti){
        this.tokenImage = ti;
        this.tokenImage[EOF] = "<EOF>";
        this.tokenImage[LETRA] = "<LETRA>";
        this.tokenImage[DIGITO] = "<DIGITO>";
        this.tokenImage[CARACTERE] = "<CARACTERE>";
        this.tokenImage[ASC] = "<ASC>";
        this.tokenImage[TIPOINT] = "<TIPOINT>";
        this.tokenImage[TIPODOUBLE] = "<TIPODOUBLE>";
        this.tokenImage[TIPOCHAR] = "<TIPOCHAR>";
        this.tokenImage[TIPOSTRING] = "<TIPOSTRING>";
        this.tokenImage[TIPOBOOLEAN] = "<TIPOBOOLEAN>";
        this.tokenImage[TIPOVOID] = "<TIPOVOID>";
        this.tokenImage[RETORNO] = "<RETORNO>";
        this.tokenImage[TRUE] = "<TRUE>";
        this.tokenImage[FALSE] = "<FALSE>";
        this.tokenImage[ENDL] = "<ENDL>";
        this.tokenImage[EOL] = "<EOL>";
        this.tokenImage[ABREVET] = "<ABREVET>";
        this.tokenImage[FECHAVET] = "<FECHAVET>";
        this.tokenImage[ADD] = "<ADD>";
        this.tokenImage[SUB] = "<SUB>";
        this.tokenImage[MULT] = "<MULT>";
        this.tokenImage[MOD] = "<MOD>";
        this.tokenImage[DIV] = "<DIV>";
        this.tokenImage[POW] = "<POW>";
        this.tokenImage[PORCE] = "<PORCE>";
        this.tokenImage[ABREPAR] = "<ABREPAR>";
        this.tokenImage[FECHAPAR] = "<FECHAPAR>";
        this.tokenImage[PONTO] = "<PONTO>";
        this.tokenImage[IGUAL] = "<IGUAL>";
        this.tokenImage[DIF] = "<DIF>";
        this.tokenImage[MAIOR] = "<MAIOR>";
        this.tokenImage[MENOR] = "<MENOR>";
        this.tokenImage[MAIGUAL] = "<MAIOROUIGUAL>";
        this.tokenImage[MEIGUAL] = "<MENOROUIGUAL>";
        this.tokenImage[IGUALDADE] = "<IGUALDADE> \"=\"";
        this.tokenImage[AND] = "<AND>";
        this.tokenImage[OR] = "<>";
        this.tokenImage[NOT] = "<>";
        this.tokenImage[XOR] = "<>";
        this.tokenImage[IF] = "<>";
        this.tokenImage[ELSE] = "<>";
        this.tokenImage[FOR] = "<>";
        this.tokenImage[SEPFOR] = "<>";
        this.tokenImage[WHILE] = "<>";
        this.tokenImage[FOREACH] = "<>";
        this.tokenImage[FIRST] = "<>";
        this.tokenImage[LAST] = "<>";
        this.tokenImage[BEGIN] = "<>";
        this.tokenImage[END] = "<>";
        this.tokenImage[IMPORT] = "<>";
        this.tokenImage[GET] = "<>";
        this.tokenImage[WRITE] = "<>";
        this.tokenImage[COMENT] = "<>";
        this.tokenImage[SEPFUN] = "<>";
        this.tokenImage[NOMEVAR] = "<>";
        this.tokenImage[STRING] = "<>";
        this.tokenImage[INTEIRO] = "<>";
        this.tokenImage[CARACTER] = "<>";
        this.tokenImage[REAL] = "<>";
        this.tokenImage[PORCENTAGEM] = "<>";
        this.tokenImage[UNKNOWMTOKEN] = "<>";
    }

    public String[] getTokenImage(){
        return tokenImage;
    }
}
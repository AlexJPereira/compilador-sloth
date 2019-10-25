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
        this.tokenImage[OR] = "<OR>";
        this.tokenImage[NOT] = "<NOT>";
        this.tokenImage[IF] = "<IF>";
        this.tokenImage[ELSE] = "<ELSE>";
        this.tokenImage[FOR] = "<FOR>";
        this.tokenImage[SEPFOR] = "<SEPFOR>";
        this.tokenImage[WHILE] = "<WHILE>";
        this.tokenImage[FOREACH] = "<FOREACH>";
        this.tokenImage[FIRST] = "<FIRST>";
        this.tokenImage[LAST] = "<LAST>";
        this.tokenImage[BEGIN] = "<BEGIN>";
        this.tokenImage[END] = "<END>";
        this.tokenImage[IMPORT] = "<IMPORT>";
        this.tokenImage[GET] = "<GET>";
        this.tokenImage[WRITE] = "<WRITE>";
        this.tokenImage[COMENT] = "<COMENT>";
        this.tokenImage[SEPFUN] = "<SEPFUN>";
        this.tokenImage[NOMEVAR] = "<NOMEVAR>";
        this.tokenImage[STRING] = "<STRING>";
        this.tokenImage[INTEIRO] = "<INTEIRO>";
        this.tokenImage[CARACTER] = "<CARACTER>";
        this.tokenImage[REAL] = "<REAL>";
        this.tokenImage[PORCENTAGEM] = "<PORCENTAGEM>";
        this.tokenImage[UNKNOWMTOKEN] = "<UNKNOWMTOKEN>";
    }

    public String[] getTokenImage(){
        return tokenImage;
    }
}
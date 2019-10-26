public class ConstantsAdapter implements CompiladorSlothConstants{

    private String originalTokenImage[];

    public ConstantsAdapter(){
        originalTokenImage = new String[tokenImage.length];
        for(int i=0;i<tokenImage.length;i++){
            originalTokenImage[i] = tokenImage[i];
        }
        buildTokenImage();
    }

    private static void buildTokenImage(){
        tokenImage[EOF] = "<EOF>";
        tokenImage[LETRA] = "<LETRA>";
        tokenImage[DIGITO] = "<DIGITO>";
        tokenImage[CARACTERE] = "<CARACTERE>";
        tokenImage[ASC] = "<ASC>";
        tokenImage[TIPOINT] = "<TIPOINT>";
        tokenImage[TIPODOUBLE] = "<TIPODOUBLE>";
        tokenImage[TIPOCHAR] = "<TIPOCHAR>";
        tokenImage[TIPOSTRING] = "<TIPOSTRING>";
        tokenImage[TIPOBOOLEAN] = "<TIPOBOOLEAN>";
        tokenImage[TIPOVOID] = "<TIPOVOID>";
        tokenImage[RETORNO] = "<RETORNO>";
        tokenImage[TRUE] = "<TRUE>";
        tokenImage[FALSE] = "<FALSE>";
        tokenImage[ENDL] = "<ENDL>";
        tokenImage[EOL] = "<EOL>";
        tokenImage[ABREVET] = "<ABREVET>";
        tokenImage[FECHAVET] = "<FECHAVET>";
        tokenImage[ADD] = "<ADD>";
        tokenImage[SUB] = "<SUB>";
        tokenImage[MULT] = "<MULT>";
        tokenImage[MOD] = "<MOD>";
        tokenImage[DIV] = "<DIV>";
        tokenImage[POW] = "<POW>";
        tokenImage[PORCE] = "<PORCE>";
        tokenImage[ABREPAR] = "<ABREPAR>";
        tokenImage[FECHAPAR] = "<FECHAPAR>";
        tokenImage[PONTO] = "<PONTO>";
        tokenImage[IGUAL] = "<IGUAL>";
        tokenImage[DIF] = "<DIF>";
        tokenImage[MAIOR] = "<MAIOR>";
        tokenImage[MENOR] = "<MENOR>";
        tokenImage[MAIGUAL] = "<MAIOROUIGUAL>";
        tokenImage[MEIGUAL] = "<MENOROUIGUAL>";
        tokenImage[IGUALDADE] = "<IGUALDADE> \"=\"";
        tokenImage[AND] = "<AND>";
        tokenImage[OR] = "<OR>";
        tokenImage[NOT] = "<NOT>";
        tokenImage[IF] = "<IF>";
        tokenImage[ELSE] = "<ELSE>";
        tokenImage[FOR] = "<FOR>";
        tokenImage[SEPFOR] = "<SEPFOR>";
        tokenImage[WHILE] = "<WHILE>";
        tokenImage[FOREACH] = "<FOREACH>";
        tokenImage[FIRST] = "<FIRST>";
        tokenImage[LAST] = "<LAST>";
        tokenImage[BEGIN] = "<BEGIN>";
        tokenImage[END] = "<END>";
        tokenImage[IMPORT] = "<IMPORT>";
        tokenImage[GET] = "<GET>";
        tokenImage[WRITE] = "<WRITE>";
        tokenImage[COMENT] = "<COMENT>";
        tokenImage[SEPFUN] = "<SEPFUN>";
        tokenImage[NOMEVAR] = "<NOMEVAR>";
        tokenImage[STRING] = "<STRING>";
        tokenImage[INTEIRO] = "<INTEIRO>";
        tokenImage[CARACTER] = "<CARACTER>";
        tokenImage[REAL] = "<REAL>";
        tokenImage[PORCENTAGEM] = "<PORCENTAGEM>";
        tokenImage[UNKNOWMTOKEN] = "<UNKNOWMTOKEN>";
    }

    public String[] getTokenImage(){
        return originalTokenImage;
    }

}
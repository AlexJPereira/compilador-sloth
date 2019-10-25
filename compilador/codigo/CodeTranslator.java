import java.util.List;

public class CodeTranslator implements CompiladorSlothConstants{
    private Codigo cod = null;
    private StringBuilder sb = new StringBuilder();
    private List<Token> code = null;
    private int tabs = 0;
    private boolean sepfor = false;
    private boolean callfor = false;
    private String nomevar = "";

    public CodeTranslator(Codigo cod){
        this.cod = cod;
        this.code = cod.getTokenList();
    }

    public void build(){
        Token t;

        while(!code.isEmpty()){
            t = code.get(0);
            switch(t.kind){
                case EOF:
                    break;
                case MOD:
                    codeJavaMOD();
                    break;
                case POW:
                    codeJavaPOW();
                    break;
                case EOL:
                    codeJavaEOL();
                    break;
                case DIF:
                    codJavaDIF();
                    break;
                case MAIGUAL:
                    codJavaMAIGUAL();
                    break;
                case MEIGUAL:
                    codJavaMEIGUAL();
                    break;
                case IF:
                    codJavaIF();
                    break;
                case ELSE:
                    codJavaELSE();
                    break;
                case FOR:
                    codJavaFOR();
                    break;
                case SEPFOR:
                    codJavaSEPFOR();
                    break;
                case FOREACH:
                    codJAVAFOREACH();
                    break;
                default:
                    codeJavaDefault(t);
            }
            code.remove(0);
        }
        
    }

    private void codeJavaMOD(){
        sb.append("%");
    }

    private void codeJavaPOW(){
        int parenteses = 0;
        int index = sb.length()-1;
        sb.append(",");
        if(sb.charAt(index)==')'){parenteses = 1;}
        while(parenteses>0){
            index--;
            if(sb.charAt(index)==')') parenteses++;
            if(sb.charAt(index)=='(') parenteses--;
        }
        sb.insert(index, "Math.pow(");

        parenteses = 0;
        index = 1;
        if(code.get(1).image=="("){parenteses=1;}
        while(parenteses>0){
            index++;
            if(code.get(index).image==")") parenteses--;
            if(code.get(index).image=="(") parenteses++;
        }
        code.add(index, new Token(FECHAPAR, ")"));
    }

    private void codeJavaEOL(){
        sb.append(";\n");
        insertTabs();
    }

    private void codeJavaDefault(Token t){
        if(
        (t.kind >= TIPOINT && t.kind <= RETORNO)
        || t.kind == ELSE)
        {
            sb.append(t.image+" ");
            return;
        }

        if
        (t.kind == IGUALDADE
        ||t.kind == AND
        ||t.kind == OR
        ){
            sb.append(" "+t.image+" ");
            return;
        }

        sb.append(t.image);
    }

    private void codJavaDIF(){
        sb.append("!=");
    }

    private void codJavaMAIGUAL(){
        sb.append(">=");
    }

    private void codJavaMEIGUAL(){
        sb.append("<=");
    }

    private void codJavaIF(){
        sb.append("if");
    }

    private void codJavaELSE(){
        sb.append("else");
    }

    private void codJavaFOR(){
        callfor = true;
        //<FOR><ABREPAR><TIPOINT>
        sb.append("for(int ");
        code.remove(0);code.remove(0);code.remove(0);
        //<NOMEVAR><IGUALDADE>
        sb.append(code.get(0).image + " = ");
        nomevar = code.get(0).image;
        code.remove(0);
    }

    private void codJavaSEPFOR(){
        if(callfor){
            if(sepfor){
                sb.append("; "+nomevar+"="+nomevar+"+");
                sepfor=false;
                callfor=false;
            }else{
                sb.append("; "+nomevar+"<");
                sepfor=true;
            }
            return;
        }else{ //foreach
            int vartype = cod.getVarType(code.get(1))+TIPOINT;
            int index = sb.length()-1;
            while(sb.charAt(index)!='('){
                index--;
            }
            sb.insert(index+1, tokenImage[vartype].substring(1,tokenImage[vartype].length()-1) +" ");
            sb.append(" : ");
        }
    }

    private void codJAVAFOREACH(){
        sb.append("for");
    }

    private void insertTabs(){
        for(int i=0;i<tabs;i++){
            sb.append("\t");
        }
    }

    public void printCodeGen(){
        System.out.println(sb.toString());
    }
}
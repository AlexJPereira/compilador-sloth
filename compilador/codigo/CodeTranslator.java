import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CodeTranslator implements CompiladorSlothConstants{
    private Codigo cod = null;
    private StringBuilder sb = null;
    private StringBuilder sbToken = null;
    private List<Token> code = null;
    private List<String> varArray = new ArrayList<String>();
    private List<String> varFunc = new ArrayList<String>();
    private int tabs = 0;
    private int ultimoTipoLido = -1;
    private String ultimaVarLida = null;
    private boolean sepfor = false;
    private boolean callfor = false;
    private boolean hasGet = false;
    private String nomevar = "";
    private String outName = "";
    private String className = "";

    public CodeTranslator(Codigo cod,  String outName){
        this.cod = cod;
        this.code = cod.getTokenList();
        if(outName.lastIndexOf(".java")==-1)
            this.outName = outName;
        else
            this.outName = outName.substring(0, outName.lastIndexOf(".java"));
        this.className = this.outName.substring(this.outName.lastIndexOf("/")+1,this.outName.length());
    }

    public void build() throws IOException{
        sb = new StringBuilder();
        sbToken = new StringBuilder();
        Token t;
        buildToken();
        tabs = 0;

        sb.append("public class "+className+"{\n");
        tabs++;
        insertTabs(sb);

        while(!code.isEmpty()){
            t = code.get(0);
            switch(t.kind){
                case EOF:
                    break;
                case ABREVET:
                    codeJavaABREVET();
                    break;
                case TIPOSTRING:
                    codeJavaTIPOSTRING();
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
                    codJavaFOREACH();
                    break;
                case FIRST:
                    codJavaFIRST();
                    break;
                case LAST:
                    codJavaLAST();
                    break;
                case BEGIN:
                    codJavaBEGIN();
                    break;
                case END:
                    codJavaEND();
                    break;
                case COMENT:
                    codJavaCOMENT();
                    break;
                case PORCENTAGEM:
                    codJavaPORCENTAGEM();
                    break;
                case WRITE:
                    codJavaWrite();
                    break;
                case GET:
                    codJavaGet();
                    break;
                default:
                    codeJavaDefault(t);
            }
            code.remove(0);
        }
        codJavaLAST();
        writeToFile(outName);
        
    }

    public void buildToken(){
        for(Token t : code){
            switch(t.kind){
                case EOL:
                    sbToken.append(tokenImage[t.kind]+"\n");
                    insertTabs(sbToken);
                    break;
                case FIRST:
                    tabs++;
                    sbToken.append(tokenImage[t.kind]+"\n");
                    insertTabs(sbToken);
                    break;
                case LAST:
                    tabs--;
                    if(sbToken.charAt(sbToken.length()-1)=='\t')
                        sbToken.delete(sbToken.length()-1,sbToken.length());
                    sbToken.append(tokenImage[t.kind]+"\n");
                    insertTabs(sbToken);
                    break;
                case BEGIN:
                    tabs++;
                    sbToken.append(tokenImage[t.kind]+"\n");
                    insertTabs(sbToken);
                    break;
                case END:
                    tabs--;
                    if(sbToken.charAt(sbToken.length()-1)=='\t')
                        sbToken.delete(sbToken.length()-1,sbToken.length());
                    sbToken.append(tokenImage[t.kind]+"\n");
                    insertTabs(sbToken);
                    break;
                default:
                    sbToken.append(tokenImage[t.kind]);
            }
        }
    }

    private void codeJavaABREVET(){
        if(!varArray.contains(ultimaVarLida)){
            sb.append("[] = new "+cod.getTokenImage()[ultimoTipoLido].substring(1,cod.getTokenImage()[ultimoTipoLido].length()-1)+"[");
            varArray.add(ultimaVarLida);
        } 
        else sb.append("[");
    }

    private void codeJavaTIPOSTRING(){
        sb.append("String ");
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
        if(code.get(index).kind==ABREPAR){parenteses=1;}
        while(parenteses>0){
            index++;
            if(code.get(index).kind==FECHAPAR) parenteses--;
            if(code.get(index).kind==ABREPAR) parenteses++;
        }
        code.add(index+1, new Token(FECHAPAR, ")"));
    }

    private void codeJavaEOL(){
        sb.append(";\n");
        insertTabs(sb);
    }

    private void codeJavaDefault(Token t){
        if(t.kind >= TIPOINT && t.kind < RETORNO) ultimoTipoLido = t.kind;
        if(t.kind == NOMEVAR) ultimaVarLida = t.image;
        if(
        (t.kind >= TIPOINT && t.kind < RETORNO)
        || t.kind == ELSE)
        {
            try{
                if(code.get(2).kind==ABREPAR && !varFunc.contains(code.get(1).image)){
                    sb.append("private static "+t.image+" ");
                    varFunc.add(code.get(1).image);
                }else{
                    sb.append(t.image+" ");
                }
            }catch(Exception e){
                sb.append(t.image+" ");
            }
            return;
        }

        if(t.kind==RETORNO){
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
            sb.insert(index+1, cod.getTokenImage()[vartype].substring(1,cod.getTokenImage()[vartype].length()-1) +" ");
            sb.append(" : ");
        }
    }

    private void codJavaFOREACH(){
        sb.append("for");
    }

    private void codJavaFIRST(){
        sb.append("public static void main(String[] args){\n");
        tabs++;
        insertTabs(sb);
    }

    private void codJavaLAST(){
        if(sb.charAt(sb.length()-1)=='\t') sb.delete(sb.length()-1,sb.length());
        sb.append("}\n");
        tabs=tabs-1;
        insertTabs(sb);
    }

    private void codJavaBEGIN(){
        sb.append("{\n");
        tabs++;
        insertTabs(sb);
    }

    private void codJavaEND(){
        codJavaLAST();
    }

    private void codJavaCOMENT(){
        sb.append("/* "+code.get(0).image.substring(1, code.get(0).image.length()-1)+" */\n");
        insertTabs(sb);
    }
    
    private void codJavaPORCENTAGEM(){
        double valor = Double.parseDouble(code.get(0).image.substring(0, code.get(0).image.length()-1))/100;
        sb.append(valor);
    }

    private void codJavaWrite(){
        sb.append("System.out.print");
    }

    private void codJavaGet(){
        if(!hasGet){
            sb.insert(sb.indexOf(className+"{\n")+className.length()+2, "\tprivate static Scanner get = new Scanner(System.in);\n");
            sb.insert(0, "import java.util.Scanner;\n\n");
            hasGet = true;
        }
        code.remove(0);code.remove(0);
        int type = code.get(0).kind;
        switch(type){
            case FECHAPAR:
                sb.append("get.nextLine()");
                break;
            case TIPOSTRING:
                sb.append("get.nextLine()");
                break;
            case TIPOBOOLEAN:
                sb.append("get.nextBoolean()");
                break;
            case TIPOCHAR:
                sb.append("get.nextLine().charAt(0)");
                break;
            case TIPODOUBLE:
                sb.append("get.nextDouble()");
                break;
            case TIPOINT:
                sb.append("get.nextInt()");
                break;
        }
        if(type!=FECHAPAR) code.remove(0);
    }

    private void insertTabs(StringBuilder sb){
        for(int i=0;i<tabs;i++){
            sb.append("\t");
        }
    }

    public void printCodeGen(){
        System.out.println(sb.toString());
    }

    public void printTokenCodeGen(){
        System.out.println(sbToken.toString());
    }

    public void writeToFile(String filename) throws IOException{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename+".java"));
            writer.write(sb.toString());
            writer.close();

            writer = new BufferedWriter(new FileWriter(filename+".txt"));
            writer.write(sbToken.toString());
            writer.close();
    }
}
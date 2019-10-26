import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CodeTranslator implements CompiladorSlothConstants{
    private Codigo cod = null;
    private StringBuilder sb = null;
    private List<Token> code = null;
    private int tabs = 0;
    private boolean sepfor = false;
    private boolean callfor = false;
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

    public void buildJava() throws IOException{
        sb = new StringBuilder();
        Token t;

        sb.append("public class "+className+"{\n");
        tabs++;
        insertTabs();

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
        writeToFile(outName+".java");
        
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
        (t.kind >= TIPOINT && t.kind < RETORNO)
        || t.kind == ELSE)
        {
            Variable var = null;
            try{
                var = cod.verifyVarList(code.get(1));
                if(var.getIsFunc()){
                    sb.append("private static "+t.image+" ");
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
        insertTabs();
    }

    private void codJavaLAST(){
        if(sb.charAt(sb.length()-1)=='\t') sb.delete(sb.length()-1,sb.length());
        sb.append("}\n");
        tabs=tabs-1;
        insertTabs();
    }

    private void codJavaBEGIN(){
        sb.append("{\n");
        tabs++;
        insertTabs();
    }

    private void codJavaEND(){
        codJavaLAST();
    }

    private void codJavaCOMENT(){
        sb.append("/* "+code.get(0).image.substring(1, code.get(0).image.length()-1)+" */\n");
        insertTabs();
    }
    
    private void codJavaPORCENTAGEM(){
        double valor = Double.parseDouble(code.get(0).image.substring(0, code.get(0).image.length()-1))/100;
        sb.append(valor);
    }

    private void codJavaWrite(){
        sb.append("System.out.println");
    }

    private void codJavaGet(){
        sb.insert(sb.indexOf(className+"{\n")+className.length()+2, "\tprivate static Scanner get = new Scanner(System.in);\n");
        sb.insert(0, "import java.util.Scanner;\n\n");
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
                sb.append("get.next().charAt(0)");
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

    private void insertTabs(){
        for(int i=0;i<tabs;i++){
            sb.append("\t");
        }
    }

    public void printCodeGen(){
        System.out.println(sb.toString());
    }

    public void writeToFile(String filename) throws IOException{
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(sb.toString());
            writer.close();
    }
}
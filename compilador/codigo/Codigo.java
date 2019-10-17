
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Codigo
{
    private List<Token> tokenList = new ArrayList<Token>();
	private List<Variable> dVariableList = new ArrayList<Variable>();
	private Stack<Integer> numLocalVar = new Stack<Integer>();
	private boolean mainDefinition = false;
	private boolean localVar = false;
	private int expectedReturn = 0;
	private int scope = 0;
	private String[] tokenImage;

	public Codigo(String[] ti){
		this.tokenImage = ti;
	}

	public void openBloco(){
		localVar = true;
		numLocalVar.push(0);
	}

	public void closeBloco(){
		for(int i=numLocalVar.pop(); i>0; i--){
			dVariableList.remove(dVariableList.size() - 1);
		}
		if(numLocalVar.empty()) localVar = false;
	}

	public void setScope(int kind){
		scope = kind;
	}

	public int getScope(){
		return scope;
	}

	public void openExpressao(int kind){
		expectedReturn = kind;
	}

	public void checkVarExpressao(Token var) throws ParseException{
		boolean canContinue = false;
		int id = 0;

		if(var.kind==58) {
			id = getVarType(var);
		}
		else {
			id = getValueType(var);
		}


		switch (id){
			case 9:
				canContinue = checkVarExpressaoInt();
				break;
			case 10:
				canContinue = checkVarExpressaoDouble();
				break;
			case 11:
				canContinue = checkVarExpressaoChar();
				break;
			case 12:
				canContinue = checkVarExpressaoString();
				break;
			case 13:
				canContinue = checkVarExpressaoBoolean();
				break;
			case 14:
				canContinue = checkVarExpressaoVoid();
				break;
		}
		if(!canContinue){
			throw new ParseException("esperava "+tokenImage[expectedReturn]+" recebeu "+tokenImage[id]);
		}
	}

	public boolean checkVarExpressaoInt(){
		//				 int   dou   char  str    bool   void
		boolean ret[] = {true, true, true, false, false, false};
		return ret[expectedReturn-9];
	}

	public boolean checkVarExpressaoDouble(){
		//				 int    dou   char   str    bool   void
		boolean ret[] = {false, true, false, false, false, false};
		return ret[expectedReturn-9];
	}

	public boolean checkVarExpressaoChar(){
		//				 int   dou   char  str    bool   void
		boolean ret[] = {true, true, true, false, false, false};
		return ret[expectedReturn-9];
	}

	public boolean checkVarExpressaoString(){
		//				 int    dou    char   str   bool   void
		boolean ret[] = {false, false, false, true, false, false};
		return ret[expectedReturn-9];
	}

	public boolean checkVarExpressaoBoolean(){
		//				 int    dou    char   str    bool  void
		boolean ret[] = {false, false, false, false, true, false};
		return ret[expectedReturn-9];
	}

	public boolean checkVarExpressaoVoid(){
		//				 int    dou    char   str    bool   void
		boolean ret[] = {false, false, false, false, false, false};
		return ret[expectedReturn-9];
	}

	public int getVarType(Token t){
		for(Variable var : dVariableList){
			if(var.getId().equals(t.image)){
				return var.getType();
			}
		}
		return 0;
	}

	public int getValueType(Token t){
		switch(t.kind){
			case 16:
				return 13;
			case 17:
				return 13;
			case 59:
				return 12;
			case 60:
				return 9;
			case 61:
				return 11;
			case 62:
				return 10;
			case 63:
				return 10;
		}
		return 0;
	}

	public void add(Token t){
		tokenList.add(t);
	}
	
	public void addDVarList(String id, int type){
		if(localVar) numLocalVar.push(numLocalVar.pop()+1);
		Variable var = new Variable(id, type);
		dVariableList.add(var);
	}

	public List<Token> getTokenList(){
		return tokenList;
	}

	public void _printVar(){
		for(Variable var : dVariableList){
			System.out.println(var.getId()+" "+var.getType());
		}
	}
	
	public void verifyVarList(Token t) throws ParseException{
		boolean encontrou = false;
		String a = t.image;

		//try{
			for(Variable var : dVariableList){
				if(var.getId().equals(a)){
					encontrou = true;
					break;
				}
			}
			if(!encontrou){
				//_printVar();
				String msg = "Variable " + t.image + " at line " +
					t.beginLine + ", column " + t.beginColumn + " was not declared.";
				throw new ParseException(msg);
			}
		//}
		//catch(Exception e){
		//		System.out.println("Variavel nao declarada "+ a +"!\n");
		//}
	}
	
	public void testaMetodo(String[] aux){
		for(int i = 0; i < tokenList.size(); i++){
			Token elem = tokenList.get(i);
			String aux1 = new String();
			String aux2 = new String();
			try{
				if(aux[elem.kind] == "\"-\""|
				aux[elem.kind] == "\"*\""|
				aux[elem.kind] == "\"//\""|
				aux[elem.kind] == "\"/\""|
				aux[elem.kind] == "\"^\""|
				aux[elem.kind] == "\"%\""){
					int k = 1;
					int j = 1;
					do{
						aux1 = aux[tokenList.get(i-k).kind];
						aux2 = aux[tokenList.get(i+j).kind];
						if(aux1 == "\")\"") k+=1;
						if(aux2 == "\"(\"") j+=1;
					}while(aux1 == "\")\"" || aux2 == "\"(\"");
					
					if(aux1 == "<STRING>" || aux2 == "<STRING>") throw new Exception();
				}
			}
			catch(Exception e){
				System.out.println("Operacao invalida com String = " +
				aux1 + aux[elem.kind] + aux2+"\n");
			}
		}
	}
	
	public void verificaFirst(){
		
		try{
			if(!mainDefinition) mainDefinition = true;
			else throw new Exception();
		}
		catch(Exception e){
			System.out.println("Programa principal definido 2x!");
		}
		
	}

	public void printTokens(String[] tokenImage){
		System.out.println("\n--- Tokens Encontrados ---\n");
		for(Token nome : tokenList){
            System.out.println(
				"Token: " + tokenImage[nome.kind] + " -> " + nome.toString());
        }
	}
}

class Variable{
	private String id;
	private int type;

	public Variable(String id, int type){
		this.id = id; 
		this.type= type; 
	}
	
	public String getId(){
		return id;
	}
	
	public int getType(){
		return type; 
	}
}

/*
- expressoes com string so podem fazer soma
- verificar se a funcao ja foi declarada e se o numero de 
parametros e o mesmo e se os parametros sao do mesmo tipo
- fazer os imports 
- verificar se tem string recebendo nao string
- verificar os casts corretos
- verificar se nao tem 2 funcoes main
- for,while e foreach nao pode ser de string
- checar os tipos do foreach

*/
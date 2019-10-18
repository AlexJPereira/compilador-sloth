import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Codigo
{
	private String[] tokenImage;
    private List<Token> tokenList = new ArrayList<Token>();
	private List<Variable> dVariableList = new ArrayList<Variable>();
	private Stack<Integer> numLocalVar = new Stack<Integer>();
	private Stack<List<Integer>> expression = null;
	private boolean mainDefinition = false;
	private boolean localVar = false;
	private int expectedReturn = 0;
	private int scope = 0;

	public Codigo(String[] ti){
		this.tokenImage = ti;
	}

	public void add(Token t){
		tokenList.add(t);
	}
	
	public void addDVarList(String id, int type){
		if(localVar) numLocalVar.push(numLocalVar.pop()+1);
		Variable var = new Variable(id, type);
		dVariableList.add(var);
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

	public void verificaFirst(){
		
		try{
			if(!mainDefinition) mainDefinition = true;
			else throw new Exception();
		}
		catch(Exception e){
			System.out.println("Programa principal definido 2x!");
		}
		
	}

	public void openExpressao(int kind){
		expectedReturn = kind;
		expression = new Stack<List<Integer>>();
	}

	public void addToExp(Token t) throws ParseException{
		int id = 0;
		if(var.kind==58) {id = getVarType(var);}
		else {id = getValueType(var);}

	}

	public void openParExp(Token t){

	}

	public void addNotToExp(Token t){
		
	}

	public void checkOpExpressao(Token op) throws ParseException{
		if(expectedReturn==12 && op.kind!=22){
			String msg = "Expected + from "+ op.image + " at line " +
					op.beginLine + ", column " + op.beginColumn+".";
			throw new ParseException(msg);
		}
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

	public int getVarType(Token t){
		for(Variable var : dVariableList){
			if(var.getId().equals(t.image)){
				return var.getType()-9;
			}
		}
		return -1;
	}

	public int getValueType(Token t){
		switch(t.kind){
			case 16:
				return 13-9;
			case 17:
				return 13-9;
			case 59:
				return 12-9;
			case 60:
				return 9-9;
			case 61:
				return 11-9;
			case 62:
				return 10-9;
			case 63:
				return 10-9;
		}
		return -1;
	}

	public void printTokens(String[] tokenImage){
		System.out.println("\n--- Tokens Encontrados ---\n");
		for(Token nome : tokenList){
            System.out.println(
				"Token: " + tokenImage[nome.kind] + " -> " + nome.toString());
        }
	}

	public void printVars(){
		for(Variable var : dVariableList){
			System.out.println(var.getId()+" "+var.getType());
		}
	}

	public List<Token> getTokenList(){
		return tokenList;
	}

	public void setScope(int kind){
		scope = kind;
	}

	public int getScope(){
		return scope;
	}
}




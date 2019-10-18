import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Codigo
{
	private String[] tokenImage;
    private List<Token> tokenList = new ArrayList<Token>();
	private List<Variable> dVariableList = new ArrayList<Variable>();
	private Stack<Integer> numLocalVar = new Stack<Integer>();
	private Stack<List<Integer>> expressions = null;
	private ExpressionOp expChecker = new ExpressionOp();
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
		expectedReturn = kind-9;
		expressions = new Stack<List<Integer>>();
		expressions.add(new ArrayList<Integer>());
	}

	public void closeExpressao() throws ParseException{
		int value = expChecker.expressionReturn(expressions.pop());
		if(expChecker.canReceive(value,expectedReturn)){
			throw new ParseException("tipo errado"+value+" "+expectedReturn);
		}
	}

	public void addToExp(Token t){
		int id = 0;
		if(t.kind==58) {id = getVarType(t);}
		else {id = getValueType(t);}
		List<Integer> ls = expressions.pop();
		ls.add(id);
		expressions.push(ls);
	}

	public void openParExp(Token t){
		expressions.push(new ArrayList<Integer>());
	}

	public void closeParExp(Token t) throws ParseException{
		int value = expChecker.expressionReturn(expressions.pop());
		if(value==-1){
			throw new ParseException("exp errada apos par");
		}
		List<Integer> ls = expressions.pop();
		ls.add(value);
		expressions.push(ls);
	}

	public void addOpToExp(Token t){
		List<Integer> ls = expressions.pop();
		ls.add(t.kind);
		expressions.push(ls);
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




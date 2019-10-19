import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Codigo
{
    private List<Token> tokenList = new ArrayList<Token>();
	private List<Variable> dVariableList = new ArrayList<Variable>();
	private Stack<Integer> numLocalVar = new Stack<Integer>();
	private Stack<List<Integer>> expressions = null;
	private ExpressionOp expChecker = new ExpressionOp();
	private ConstantsAdapter constAdp = null;
	private boolean mainDefinition = false;
	private boolean localVar = false;
	private int expectedReturn = 0;
	private int scope = 0;
	private boolean hasReturn = false;

	public Codigo(String[] ti){
		constAdp = new ConstantsAdapter(ti);
	}

	public void add(Token t){
		tokenList.add(t);
	}
	
	public Variable addDVarList(String id, int type) throws ParseException{
		if(localVar) numLocalVar.push(numLocalVar.pop()+1);
		for(Variable var : dVariableList){
			if(var.getId().equals(id)){
				throw new ParseException("variavel ja declarada");
			}
		}
		Variable var = new Variable(id, type, this);
		dVariableList.add(var);
		return var;
	}

	public Variable verifyVarList(Token t) throws ParseException{
		String a = t.image;

		//try{
			for(Variable var : dVariableList){
				if(var.getId().equals(a)){
					return var;
				}
			}
			String msg = "Variable " + t.image + " at line " +
				t.beginLine + ", column " + t.beginColumn + " was not declared.";
			throw new ParseException(msg);
	}

	public void verifyParameters(Token name, Token param) throws ParseException{
		verifyVarList(name).checkParam(name,param);
	}

	public void checkParameters(Token name) throws ParseException{
		if(!verifyVarList(name).isAllParamsChecked())
			throw new ParseException("parametros errados para "+name.image);
	}

	public void verificaFirst() throws ParseException{
		if(!mainDefinition) mainDefinition = true;
		else throw new ParseException("Programa principal definido 2x");
	}

	public void openExpressao(int kind) throws ParseException{
		expectedReturn = kind-9;
		expressions = new Stack<List<Integer>>();
		expressions.add(new ArrayList<Integer>());
		if(expectedReturn==5){
			List<Integer> ls = expressions.pop();
			ls.add(5);
			expressions.push(ls);
		}
	}

	public void closeExpressao() throws ParseException{
		int value = expChecker.expressionReturn(expressions.pop());
		if(value==-1){
			throw new ParseException("operacao invalida");
		}
		if(value==5)
			if(expectedReturn!=5){
				throw new ParseException("operacao com void");
			} else return;
		if(!expChecker.canReceive(value,expectedReturn)){
			throw new ParseException("tipo errado"+value+" "+expectedReturn);
		}
	}

	public void addToExp(Token t){
		int id = 0;
		if(t.kind==58) {id = getVarType(t);}
		else if(t.kind==54) id=3;
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
		if(value==5&&expectedReturn!=5){
			throw new ParseException("operacao com void");
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

	public void checkForeach(Token input,  Token container) throws ParseException{
		Variable cont = verifyVarList(container);
		if(!cont.getIsVet())
			throw new ParseException("variavel nao e vetor");
		else
			addDVarList(input.image, cont.getType());
	}

	public void checkFor(Token input) throws ParseException{
		Variable inp = verifyVarList(input);
		if(inp.getIsVet())
			throw new ParseException("variavel e vetor");
		if(inp.getType()!=9)
			throw new ParseException("variavel nao e inteiro");
	}

	public void openFunc(){
		hasReturn = false;
	}

	public void setHasReturn(boolean hasReturn){
		this.hasReturn = hasReturn;
	}

	public void closeFunc() throws ParseException{
		if(!hasReturn){
			throw new ParseException("expressao sem retorno");
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

	public void printTokens(){
		System.out.println("\n--- Tokens Encontrados ---\n");
		for(Token nome : tokenList){
            System.out.println(
				"Token: " + constAdp.getTokenImage()[nome.kind] + " -> " + nome.toString());
        }
	}

	public void printVars(){
		for(Variable var : dVariableList){
			System.out.println("varID: "+var.getId()+" // varType:"+var.getType());
			var.printParameters();
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

	public ExpressionOp getExpChecker(){
		return expChecker;
	}
}




import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Codigo
{
    private List<Token> tokenList = new ArrayList<Token>();
	private List<Variable> dVariableList = new ArrayList<Variable>();
	private Stack<Integer> expectedReturn = new Stack<Integer>();
	private Stack<Integer> numLocalVar = new Stack<Integer>();
	private Stack<Stack<List<Integer>>> expressions = new Stack<Stack<List<Integer>>>();
	private Stack<String> file = new Stack<String>();
	private ExpressionOp expChecker = new ExpressionOp();
	private ConstantsAdapter constAdp = null;
	private boolean mainDefinition = false;
	private boolean localVar = false;
	private int scope = 0;
	private boolean hasReturn = false;

	public Codigo(String[] ti, String fname){
		constAdp = new ConstantsAdapter(ti);
		this.file.push(fname);
	}

	public void add(Token t){
		tokenList.add(t);
	}
	
	public Variable addDVarList(String id, int type, Token t) throws ParseException{
		if(localVar) numLocalVar.push(numLocalVar.pop()+1);
		for(Variable var : dVariableList){
			if(var.getId().equals(id)){
				new ErrorCreator(file.peek()).throwPE(t, "Variable "+t.image+" is already defined.");
			}
		}
		Variable var = new Variable(id, type);
		dVariableList.add(var);
		return var;
	}

	public Variable verifyVarList(Token t) throws ParseException{
		String a = t.image;
		for(Variable var : dVariableList){
			if(var.getId().equals(a)){
				return var;
			}
		}
		new ErrorCreator(file.peek()).throwPE(t, "Variable "+t.image+" was not defined.");
		return null;
	}

	public int getNextParam(Token name) throws ParseException{
		return verifyVarList(name).getNextParam(name, file.peek());
	}

	public void openChamaFunc(Token t) throws ParseException{
		verifyVarList(t).openParamChecker();
	}

	public void checkParameters(Token name) throws ParseException{
		if(!verifyVarList(name).isAllParamsChecked())
			new ErrorCreator(file.peek()).throwPE(name, "Function "+name.image+" does not have all the parameters.");
	}

	public void verificaFirst(Token t) throws ParseException{
		if(!mainDefinition) mainDefinition = true;
		else new ErrorCreator(file.peek()).throwPE(t, "A second main function was found.");
	}

	public void openExpressao(int kind){
		expectedReturn.push(kind-9);
		expressions.push(new Stack<List<Integer>>());
		expressions.peek().add(new ArrayList<Integer>());
		if(expectedReturn.peek()==5){
			List<Integer> ls = expressions.peek().pop();
			ls.add(5);
			expressions.peek().push(ls);
		}
	}

	public void closeExpressao(Token t) throws ParseException{
		int value = expChecker.expressionReturn(expressions.peek().pop());
		if(value==-1)
			new ErrorCreator(file.peek()).throwPE(t, "Invalid operator use in the expression.");

		if(value==5)
			if(expectedReturn.peek()!=5)
				new ErrorCreator(file.peek()).throwPE(t, "Expression with void.");
			else return;

		if(!expChecker.canReceive(value,expectedReturn.peek()))
			new ErrorCreator(file.peek()).throwPE(t, "Expression type is "+constAdp.getTokenImage()[value+9]+", expected: "+constAdp.getTokenImage()[expectedReturn.peek()+9]+".");
		
		expectedReturn.pop();
		expressions.pop();
	}

	public void addToExp(Token t){
		int id = 0;
		if(t.kind==58) {id = getVarType(t);}
		else if(t.kind==54) id=3;
		else {id = getValueType(t);}

		List<Integer> ls = expressions.peek().pop();
		ls.add(id);
		expressions.peek().push(ls);
	}

	public void openParExp(Token t){
		expressions.peek().push(new ArrayList<Integer>());
	}

	public void closeParExp(Token t) throws ParseException{
		int value = expChecker.expressionReturn(expressions.peek().pop());
		if(value==-1){
			new ErrorCreator(file.peek()).throwPE(t, "Invalid operator use inside parenteses.");
		}
		if(value==5&&expectedReturn.peek()!=5){
			new ErrorCreator(file.peek()).throwPE(t, "Expression with void.");
		}
		List<Integer> ls = expressions.peek().pop();
		ls.add(value);
		expressions.peek().push(ls);
	}

	public void addOpToExp(Token t){
		List<Integer> ls = expressions.peek().pop();
		ls.add(t.kind);
		expressions.peek().push(ls);
	}

	public void initializeVar(Token a) throws ParseException{
		verifyVarList(a).init();
	}

	public void checkInitVar(Token a) throws ParseException{
		if(!verifyVarList(a).getInit())
			new ErrorCreator(file.peek()).throwPE(a, "The variable "+a.image+" was not initialized.");
	}

	public void checkForeach(Token input,  Token container) throws ParseException{
		Variable cont = verifyVarList(container);
		if(!cont.getIsVet())
			new ErrorCreator(file.peek()).throwPE(container, "The variable must be an array.");
		else
			addDVarList(input.image, cont.getType(), input);
	}

	public void openFunc(){
		hasReturn = false;
	}

	public void setHasReturn(boolean hasReturn){
		this.hasReturn = hasReturn;
	}

	public void closeFunc(Token t) throws ParseException{
		if(!hasReturn)
			new ErrorCreator(file.peek()).throwPE(t, "The function must have a return.");
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

	public void addFile(String nome){
		file.push(nome);
	}

	public void removeFile(){
		file.pop();
	}

	public String getFile(){
		return file.peek();
	}
}




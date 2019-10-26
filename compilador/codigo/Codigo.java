import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Codigo implements CompiladorSlothConstants
{
    private List<Token> tokenList = new ArrayList<Token>();
	private List<Variable> dVariableList = new ArrayList<Variable>();
	private Stack<Integer> expectedReturn = new Stack<Integer>();
	private Stack<Integer> numLocalVar = new Stack<Integer>();
	private Stack<Stack<List<Integer>>> expressions = new Stack<Stack<List<Integer>>>();
	private Stack<String> file = new Stack<String>();
	private ExpressionOp expChecker = new ExpressionOp();
	private ConstantsAdapter constAdp = new ConstantsAdapter();
	private boolean mainDefinition = false;
	private boolean localVar = false;
	private int scope = 0;
	private int ERROTYPE = -1;
	private boolean hasReturn = false;

	public Codigo(String fname){
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

	public Variable verifyVarList(Token t, boolean isFunc) throws ParseException{
		Variable var = verifyVarList(t);
		if(var.getIsFunc()!=isFunc){
			if(isFunc){
				new ErrorCreator(file.peek()).throwPE(t, "Variable "+t.image+" is not a function.");
			}else{
				new ErrorCreator(file.peek()).throwPE(t, "Variable "+t.image+" is a function.");
			}
		}
		return var;
	}

	public int getNextParam(Token name) throws ParseException{
		return verifyVarList(name).getNextParam(name, file.peek());
	}

	public void openChamaFunc(Token t) throws ParseException{
		verifyVarList(t, true).openParamChecker();
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
		expectedReturn.push(kind-TIPOINT);
		expressions.push(new Stack<List<Integer>>());
		expressions.peek().add(new ArrayList<Integer>());
		if(expectedReturn.peek()==(TIPOVOID-TIPOINT)){
			List<Integer> ls = expressions.peek().pop();
			ls.add(TIPOVOID-TIPOINT);
			expressions.peek().push(ls);
		}
	}

	public void closeExpressao(Token t) throws ParseException{
		int value = expChecker.expressionReturn(expressions.peek().pop());
		if(value==ERROTYPE)
			new ErrorCreator(file.peek()).throwPE(t, "Invalid operator use in the expression.");

		if(value==(TIPOVOID-TIPOINT))
			if(expectedReturn.peek()!=(TIPOVOID-TIPOINT))
				new ErrorCreator(file.peek()).throwPE(t, "Expression with void.");
			else return;

		if(!expChecker.canReceive(value,expectedReturn.peek()))
			new ErrorCreator(file.peek()).throwPE(t, "Expression type is "+tokenImage[value+TIPOINT]+", expected: "+tokenImage[expectedReturn.peek()+TIPOINT]+".");
		
		expectedReturn.pop();
		expressions.pop();
	}

	public void addToExp(Token t){
		int id = ERROTYPE;
		if(t.kind==NOMEVAR) {id = getVarType(t);}
		else if(t.kind==GET) id = TIPOSTRING-TIPOINT;
		else {id = getValueType(t);}

		List<Integer> ls = expressions.peek().pop();
		ls.add(id);
		expressions.peek().push(ls);
	}

	public void addToExp(int type){
		List<Integer> ls = expressions.peek().pop();
		ls.add(type-TIPOINT);
		expressions.peek().push(ls);
	}

	public void openParExp(Token t){
		expressions.peek().push(new ArrayList<Integer>());
	}

	public void closeParExp(Token t) throws ParseException{
		int value = expChecker.expressionReturn(expressions.peek().pop());
		if(value==ERROTYPE){
			new ErrorCreator(file.peek()).throwPE(t, "Invalid operator use inside parenteses.");
		}
		if(value==(TIPOVOID-TIPOINT)&&expectedReturn.peek()!=(TIPOVOID-TIPOINT)){
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
			addDVarList(input.image, cont.getType(), input).init();
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
				return var.getType()-TIPOINT;
			}
		}
		return ERROTYPE;
	}

	public int getValueType(Token t){
		switch(t.kind){
			case TRUE:
				return TIPOBOOLEAN-TIPOINT;
			case FALSE:
				return TIPOBOOLEAN-TIPOINT;
			case STRING:
				return TIPOSTRING-TIPOINT;
			case INTEIRO:
				return TIPOINT-TIPOINT;
			case CARACTER:
				return TIPOCHAR-TIPOINT;
			case REAL:
				return TIPODOUBLE-TIPOINT;
			case PORCENTAGEM:
				return TIPODOUBLE-TIPOINT;
		}
		return ERROTYPE;
	}

	public void printTokens(){
		System.out.println("\n--- Tokens Encontrados ---\n");
		for(Token nome : tokenList){
            System.out.println(
				"Token: " + tokenImage[nome.kind] + " -> " + nome.toString());
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

	public String[] getTokenImage(){
		return constAdp.getTokenImage();
	}
}




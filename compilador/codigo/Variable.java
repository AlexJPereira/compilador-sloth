import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Variable{
	private String id;
	private int type;
	private List<Integer> parameters = null;
	private Stack<Integer> checkedParam = new Stack<Integer>();
	private boolean isVet=false;

	public Variable(String id, int type){
		this.id = id; 
		this.type = type;
	}

	public void openParamChecker(){
		checkedParam.push(0);
	}
	
	public int getNextParam(Token name) throws ParseException{
		int aux = checkedParam.peek();
		checkedParam.push(checkedParam.pop()+1);
		if(aux<parameters.size())
			return parameters.get(aux);
		throw new ParseException("parametro nao encontrado "+name.image);
	}

	public boolean isAllParamsChecked(){
		int aux = checkedParam.peek();
		checkedParam.pop();
		if(parameters==null) return true;
		else return (parameters.size()==aux);
	}

	public void checkVet(boolean vet) throws ParseException{
		if(vet!=isVet)
			if(vet) throw new ParseException("a variavel nao e vetor");
			else throw new ParseException("a variavel e um vetor, faltou [");
	}

	public String getId(){
		return id;
	}
	
	public int getType(){
		return type; 
	}

	public void addParameter(int type){
		if(parameters==null) parameters = new ArrayList<Integer>();
		parameters.add(type-9);
	}

	public List<Integer> getParameters(){
		return parameters;
	}

	public void printParameters(){
		if(parameters!=null){
			System.out.print("parametersType: ");
			for(int param : parameters){
				System.out.print(param+9+" ");
			}
			System.out.println();
		}
		
	}

	public void setIsVet(boolean v){
		isVet = v;
	}

	public boolean getIsVet(){
		return isVet;
	}
}
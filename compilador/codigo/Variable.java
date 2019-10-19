import java.util.ArrayList;
import java.util.List;

public class Variable{
	private String id;
	private int type;
	private List<Integer> parameters = null;
	private int checkedParam=0;
	private Codigo cod;

	public Variable(String id, int type, Codigo cod){
		this.id = id; 
		this.type = type;
		this.cod = cod;
	}

	public void checkParam(Token name, Token param) throws ParseException{
		if(parameters==null)
			throw new ParseException("funcao nao tem parametros");

		int id = 0;
		if(param.kind==58) {id = cod.getVarType(param);}
		else {id = cod.getValueType(param);}

		if(parameters.get(checkedParam)!=id)
			throw new ParseException("parametro nao encontrado "+param.image);
		else
			checkedParam++;
	}
	
	public boolean isAllParamsChecked(){
		if(parameters==null) return true;
		else return (parameters.size()==checkedParam);
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
}
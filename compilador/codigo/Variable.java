import java.util.ArrayList;
import java.util.List;

public class Variable{
	private String id;
	private int type;
	private List<Integer> parameters = null;

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

	public void addParameter(int type){
		if(parameters==null) parameters = new ArrayList<Integer>();
		parameters.add(type);
	}
}
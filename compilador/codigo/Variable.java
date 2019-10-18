public class Variable{
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
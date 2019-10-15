import java.util.ArrayList;
import java.util.List;

public class Codigo
{
    private List<Token> tokenList = new ArrayList<Token>();
	private List<String> dVariableList = new ArrayList<String>();

	public void add(Token t){
		tokenList.add(t);
	}
	
	public void addDVarList(String t){
		dVariableList.add(t);
	}

	public List<Token> getTokenList(){
		return tokenList;
	}

	public void startVirtualToken(){
		Token a = new Token(999);
		a.image = "<INICIODAEXP>";
		tokenList.add(a);
	}

	public void finishVirtualToken(){
		Token a = new Token(998);
		a.image = "<FIMDAEXP>";
		tokenList.add(a);
	}
	
	public void verifyVarList(String a){
		try{
			if(!dVariableList.contains(a)){
				throw new Exception();
			}
		}
		catch(Exception e){
				System.out.println("Variavel nao declarada "+ a +"!\n");
		}
	}
}
/*
- expressoes com string so podem fazer soma
- verificar se variavel ja foi declarada
- verificar se a funcao ja foi declarada e se o numero de 
parametros e o mesmo e se os parametros sao do mesmo tipo
- fazer os imports 
- verificar se tem string recebendo nao string
- verificar os casts corretos
- verificar se nao tem 2 funcoes main
- for,while e foreach nao pode ser de string
- checar os tipos do foreach

*/
import java.util.ArrayList;
import java.util.List;
import java.util.stack;

public class Codigo
{
    private List<Token> tokenList = new ArrayList<Token>();
	private List<Token> variableList = new ArrayList<Token>();

	public void add(Token t){
		tokenList.add(t);
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
	
	public void declareVariable(){
		int mutex = 0; 
		for(Token elem:tokenList){
			if(tokenImage[elem.kind] == "int" |
			   tokenImage[elem.kind] == "double"|
			   tokenImage[elem.kind] == "char"|
			   tokenImage[elem.kind] == "string"|
			   tokenImage[elem.kind] == "boolean"){
				mutex = 1; 
			}
			if(mutex){
				if(tokenImage[elem.kind] == ';'){
					mutex = 0; 
				}
				else if(tokenImage[elem.kind] == "<NOMEVAR>"){
					variableList.add(elem); 
				}
			}
			
		}
	}
	
	public void verifyVariable(){
		for(Token elem:tokenList){
			try{
				if(tokenImage[elem.kind] == "<NOMEVAR>" && !(variableList.contains(elem){
					throw new Exception(); 
				}
			}
			catch(Exception e){
				System.out.println("Variavel nao declarada: " + tokenImage[elem.kind] + "\n"); 
			}
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
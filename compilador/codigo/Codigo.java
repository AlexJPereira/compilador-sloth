
import java.util.ArrayList;
import java.util.List;


public class Codigo
{
    private List<Token> tokenList = new ArrayList<Token>();
	private List<String> dVariableList = new ArrayList<String>();
	private boolean mainDefinition = false;

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
	
	public void testaMetodo(String[] aux){
		for(int i = 0; i < tokenList.size(); i++){
			Token elem = tokenList.get(i);
			String aux1 = new String();
			String aux2 = new String();
			try{
				if(aux[elem.kind] == "\"-\""|
				aux[elem.kind] == "\"*\""|
				aux[elem.kind] == "\"//\""|
				aux[elem.kind] == "\"/\""|
				aux[elem.kind] == "\"^\""|
				aux[elem.kind] == "\"%\""){
					int k = 1;
					int j = 1;
					do{
						aux1 = aux[tokenList.get(i-k).kind];
						aux2 = aux[tokenList.get(i+j).kind];
						 
						if(aux1 == "\")\"") k+=1;
						if(aux2 == "\"(\"") j+=1;
						System.out.println(aux1);
						System.out.println(aux2);
					}while(aux1 == "\")\"" || aux2 == "\"(\"");
					
					if(aux1 == "<STRING>" || aux2 == "<STRING>") throw new Exception();
				}
			}
			catch(Exception e){
				System.out.println("Operacao invalida com String = " +
				aux1 + aux[elem.kind] + aux2+"\n");
			}
		}
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
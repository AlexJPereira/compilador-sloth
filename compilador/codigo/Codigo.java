import java.util.ArrayList;
import java.util.List;

public class Codigo
{
    private List<Token> tokenList = new ArrayList<Token>();

	public void add(Token t){
		tokenList.add(t);
	}

	public List<Token> getTokenList(){
		return tokenList;
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


*/
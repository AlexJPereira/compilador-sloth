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
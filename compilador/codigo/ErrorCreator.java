import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class ErrorCreator{
    private String file = null;

    public ErrorCreator(String file){
        this.file=file;
    }


    public String getFileLine(int line){
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			for(int i=0;i<line-1;i++){
				br.readLine();
			}
			String ret = br.readLine();
			br.close();
			return ret;
		}
		catch(IOException e){
			return null;
		}
	}

	public String removeTabs(String str){
		while(str.charAt(0)==' '||str.charAt(0)=='\t')
			str = str.substring(1);
		return str;
	}

	public String addTabs(String str, int c){
		int j=0;
		while(str.charAt(j)==' '||str.charAt(j)=='\t'){
			c--;j++;
		}
		String ret = "";
		for(int i=0;i<c-1;i++){
			ret = ret + " ";
		}
		return ret+"^";
	}

	public void throwPE(Token t, String msg)throws ParseException{
		throw new ParseException(
			"File:\t\t"+file+
			"\nLine "+t.beginLine+":\t\t"+removeTabs(getFileLine(t.beginLine))+
			"\nColumn "+t.beginColumn+":\t"+addTabs(getFileLine(t.beginLine), t.beginColumn)+
			"\n"+msg);
	}
}
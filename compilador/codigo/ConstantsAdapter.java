public class ConstantsAdapter{

    private String[] tokenImage;

    public ConstantsAdapter(String[] ti){
        this.tokenImage = ti;
        tokenImage[19]="<EOL> (EndOfLine)";
    }

    public String[] getTokenImage(){
        return tokenImage;
    }
}
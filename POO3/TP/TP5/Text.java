
public class Text extends Node{
    private String text;
    public Text(String t){
        this.text=t;
    }
    public String toXML(int indent){
        return tabs(indent)+text+"\n";
    }
}

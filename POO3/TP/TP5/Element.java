import java.util.ArrayList;

public class Element extends Node {
    private String tag;
    private ArrayList<Node> childs;

    public Element(String t) {
        this.tag = t;
    }

    public Element(String t, Node... c) {
        this(t);
        this.add(c);
    }

    public ArrayList<Node> childs() {
        return this.childs;
    }

    public void add(Node... c) {
        for (Node node : c)
            this.childs.add(node);
    }

    public String toXML(int indent){
        String res =tabs(indent)+"<"+this.tag+">"+"\n";
        for (Node node : this.childs) 
            res+=node.toXML(indent+1);
        res+=tabs(indent)+"</"+this.tag+">"+"\n";
        return res;
    }


}

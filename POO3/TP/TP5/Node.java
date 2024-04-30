import java.util.ArrayList;

public class Node {
    private static ArrayList<Node> childs;
    static int tab = 4;

    public static String tabs(int indent) {
        String res = "";
        for (int i = 0; i < indent * tab; i++)
            res += " ";
        return res;
    }

    public ArrayList<Node> childs() {
        return childs;
    }

    public String toXML(int indent) {
        return null;
    }

    public int size(){
        if(childs==null)
            return 0;
        int res=childs.size();
        for (Node node : childs) 
            res+=node.size();
        return res;
    }

    public int depth(){
        if(childs==null)
            return 0;
        int res=0;
        //for (Node node : childs)

    }
}
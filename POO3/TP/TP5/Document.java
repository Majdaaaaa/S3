public class Document {
    private Node root;
    public Document(Node r){
        this.root=r;
    }
    public String toString(){
        if(root==null){
            return "";
        }else{
            return root.toXML(0);
        }
    }
    
    public int size(){
        if(root==null)
            return 0;
        else
            return root.size();
    }



}

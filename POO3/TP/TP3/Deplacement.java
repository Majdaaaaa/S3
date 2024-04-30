public class Deplacement {
    public int x0,y0,x1,y1;
    public char typeDeplacement(){
        if(this.y0!=this.y1){
            return 'v';
        }else if(this.x0!=this.x1){
            return 'h';
        }else if(this.x1-this.x0==this.y1-this.y0) {
            return 'd';
        }else if((Math.abs(this.x1-this.x0)==2 && Math.abs(this.y1-this.y0)==1) || ((Math.abs(this.x1-this.x0)==1 &&Math.abs(this.y1-this.y0)==2))){
            return 'd';
        }else{
            return 'x';
        }
    }
    public int dist(){
        if(typeDeplacement()=='x'|| typeDeplacement()=='c') return -1;
        else return Math.max(Math.abs(this.x1-this.x0),Math.abs(this.y1-this.y0));
    }
    


}

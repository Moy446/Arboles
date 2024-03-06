package arbol;


public class Arbol {

    int value;
    Arbol left;
    Arbol rigth;
    
    String levels[];
    
    public Arbol(int value) {
        this.value = value;
        left = rigth = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Arbol getLeft() {
        return left;
    }

    public void setLeft(Arbol left) {
        this.left = left;
    }

    public Arbol getRigth() {
        return rigth;
    }

    public void setRigth(Arbol rigth) {
        this.rigth = rigth;
    }
    
    public void push (int _value){
        Arbol newBranch = new Arbol(_value);
        if (_value < value) {
            if (left == null) {
                left = newBranch;
            } else {
                left.push(_value);
            }
        } else {
            if (rigth == null) {
                rigth = newBranch;
            } else {
                rigth.push(_value);
            }
        }
    }    
    
    public void imprimirArbol(Arbol tree){
        levels = new String[6];
        imprimirArbol(tree, 0);
        for (int i = 0; i <levels.length; i++) {
            System.out.println(levels[i]+" NIVEL:"+i);
        }
    }
    public void imprimirArbol(Arbol node, int level){
        if(node != null){
            levels[level] = node.getValue() + "  " + ((levels[level]!= null) ? levels[level] :"");
            imprimirArbol(node.left, level + 1);
            imprimirArbol(node.rigth, level + 1);
        }

    }
    public void preorder(Arbol node){
        if(node != null){
            System.out.println(node.getValue());
            preorder(node.left);
            preorder(node.rigth);
        }

    }
    public void postorder(Arbol node){
        if(node != null){
            postorder(node.left);
            postorder(node.rigth);
            System.out.println(node.getValue());
        }
    }
    public void inorder(Arbol node){
        if(node != null){
            inorder(node.left);
            System.out.println(node.getValue());
            inorder(node.rigth);
        }
    }
    
}

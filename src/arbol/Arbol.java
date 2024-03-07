package arbol;


public class Arbol {

    int value;
    Arbol left;
    Arbol right;
    int color ; //1 = red, 0 = black
    
    public Arbol(int value, int color) {
        this.value = value;
        this.color = color;
        left = right = null;
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

    public Arbol getRight() {
        return right;
    }

    public void setRight(Arbol rigth) {
        this.right = rigth;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
    
    public void push (Arbol tree, int _value){
        Arbol newBranch = new Arbol(_value, 1);
        if (_value < value) {
            if (left == null) {
                left = newBranch;
            } else {
                left.push(tree, _value);
            }
        } else if (_value > value){
            if (right == null) {
                right = newBranch;
            } else {
                right.push(tree, _value);
            }
        }
        //balanceTree(tree);
    }    
    //imprimir forma del arbol
    public int getAltura(Arbol node){
        if (node == null) {
            return 0;
        }
        int leftlevel = getAltura(node.left);
        int rightlevel = getAltura(node.right);
        if (leftlevel>rightlevel) {
            return leftlevel+1;
        }else{
            return rightlevel+1;
        }
    }
    
    public void imprimirArbol(Arbol node){
        int altura = getAltura(node);
        String[] levels = new String[altura];
        imprimirArbol(node, 0, levels);
        for (int i = 0; i <levels.length; i++) {
            System.out.println(levels[i]+" NIVEL:"+i);
        }
    }
    public void imprimirArbol(Arbol node, int level, String[] levels){
        if(node != null){
            levels[level] = node.getValue() + "  " + ((levels[level]!= null) ? levels[level] :"");
            imprimirArbol(node.right, level + 1, levels);
            imprimirArbol(node.left, level + 1, levels);
        }

    }
    //imprimir ordenes
    public void preorder(Arbol node){
        if(node != null){
            System.out.println(node.getValue());
            preorder(node.left);
            preorder(node.right);
        }

    }
    public void postorder(Arbol node){
        if(node != null){
            postorder(node.left);
            postorder(node.right);
            System.out.println(node.getValue());
        }
    }
    public void inorder(Arbol node){
        if(node != null){
            inorder(node.left);
            System.out.println(node.getValue());
            inorder(node.right);
        }
    }
    
    public void balanceTree(Arbol node){
        if (isRed(right)&& !isRed(left)) {
            node = node.leftRotate(node);
        }
        if (isRed(left)&& !isRed(left.left)) {
            node = node.rightRotate(node);
        }
        if (isRed(left)&& !isRed(right)) {
            colorFlip(node);
        }
    }
    
    public Arbol leftRotate(Arbol node){
        Arbol newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        node = newRoot;
        return node;
    }
    public Arbol rightRotate(Arbol node){
        Arbol newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        node = newRoot;
        return node;
    }
    public boolean isRed(Arbol node){
        if(node.color == 1 || node == null ){
            return true;
        }else{
            return false;
        }
    }
    public void colorFlip(Arbol node){
        node.color = 1;
        node.left.color = 0;
        node.right.color = 0;
    }
}

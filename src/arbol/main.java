package arbol;

public class main {
    public static void main(String[] args) {
        Arbol tree = new Arbol(15);
        tree.push(5);
        tree.push(2);
        tree.push(3);
        tree.push(7);
        tree.push(24);
        tree.push(48);
        tree.push(16);
        tree.push(84);
        System.out.println("Forma del arbol");
        tree.imprimirArbol(tree);
        System.out.println("Preorder----------------------------");
        tree.preorder(tree);
        System.out.println("PostOrder----------------------------");
        tree.postorder(tree);
        System.out.println("Inorder----------------------------");
        tree.inorder(tree);
    }
}

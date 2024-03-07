package arbol;

public class main {
    public static void main(String[] args) {
        Arbol tree = new Arbol(15, 0);
        tree.push(tree, 5);
        tree.push(tree,3);
        tree.push(tree,24);
        tree.push(tree,18);
        tree.push(tree,47);
        tree.push(tree,6);
        tree.push(tree,48);
        tree.push(tree,13);
        tree.push(tree,84);
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

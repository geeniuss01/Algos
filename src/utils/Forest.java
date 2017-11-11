package utils;

public class Forest {
    public static Node buildBinaryTree() {
        Node root1 = new Node(1);
        Node root2 = new Node(2);
        Node root3 = new Node(3);
        Node root4 = new Node(4);
        Node root5 = new Node(5);
        Node root6 = new Node(6);
        Node root7 = new Node(7);


        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root2.right = root5;
        root3.connect(root7, root6);
        return root1;
    }

    public static Node buildBinaryTree2() {
        Node root1 = new Node(1);
        Node root2 = new Node(2);
        Node root3 = new Node(3);
        Node root4 = new Node(4);
        Node root5 = new Node(5);
        Node root6 = new Node(6);
        Node root7 = new Node(7);

        Node root = root4;
        root4.connect(root5, root2);
        root2.connect(root3, root1);
        root3.connect(root6, root7);

        return root;
    }

    public static Node buildChildrenSumTree() {

        Node n0 = new Node(10);
        Node n11 = new Node(8);
        Node n12 = new Node(2);
        Node n21 = new Node(5);
        Node n22 = new Node(3);
        Node n23 = new Node(2);

        n0.connect(n11, n12);
        n11.connect(n21, n22);
        n12.connect(n23, null);
        return n0;
    }

    public static Node buildBinaryTree3() {
        Node n20 = new Node(20);
        Node n8 = new Node(8);
        Node n22 = new Node(22);
        Node n5 = new Node(5);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n25 = new Node(25);
        Node n10 = new Node(10);
        Node n14 = new Node(14);
        n20.connect(n8, n22);
        n8.connect(n5, n3);
        n22.connect(n4, n25);
        n3.connect(n10, n14);
        return n20;
    }

    public static Node buildBinaryTree4() {
        Node n20 = new Node(20);
        Node n8 = new Node(8);
        Node n22 = new Node(22);
        Node n5 = new Node(5);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n25 = new Node(25);
        Node n10 = new Node(10);
        Node n100 = new Node(100);
        Node n101 = new Node(101);
        Node n14 = new Node(14);

        n20.connect(n8, n22);
        n8.connect(n5, n3);
        n22.connect(n4, n25);
        n3.connect(n10, n14);
        n14.connect(null, n100);
        n100.connect(null, n101);
        return n20;
    }

    public static Node buildTallTree() {
        Node root = new Node(5);
        root.left = new Node(10);
        root.right = new Node(15);
        root.left.left = new Node(20);
        root.left.right = new Node(25);
        root.left.left.left =new Node(30);
        root.left.right.left = new Node(35);
        root.left.right.left.left = new Node(40);
        root.left.right.left.left.right = new Node(45);
        root.left.right.left.left.right.left = new Node(50);
        return root;
    }
}

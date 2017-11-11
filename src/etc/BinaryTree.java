package etc;

import java.util.Arrays;

/* Java program to find maximum difference between node
   and its ancestor */
//  I wonder how to solve it in a functional language like clojure
// A binary tree node has key, pointer to left 
// and right child 
class Node 
{
    int key;
    Node left, right;
  
    public Node(int key) 
    {
        this.key = key;
        left = right = null;
    }
}
  
/* Class etc.Res created to implement pass by reference
   of 'res' variable */
class Res 
{
    int r = Integer.MIN_VALUE;
}
  
public class BinaryTree{
    Node root;
  
    /* Recursive function to calculate maximum ancestor-node
       difference in  binary tree. It updates value at 'res'
       to store the result.  The returned value of this function
       is minimum value in subtree rooted with 't' */
    int maxDiffUtil(Node t, Res res) 
    {
        /* Returning Maximum int value if node is not
           there (one child case)  */
        if (t == null)
            return Integer.MAX_VALUE;
          
        /* If leaf node then just return node's value  */
        if (t.left == null && t.right == null)
            return t.key;
  
        /* Recursively calling left and right subtree
           for minimum value  */
        int leftDiff = maxDiffUtil(t.left, res);
        int rightDiff = maxDiffUtil(t.right, res);
        int val = Math.min(leftDiff, rightDiff);
        System.out.println(String.format("%d-> %d, %d : %d", t.key, leftDiff,rightDiff, res.r));
  
        /* Updating res if (node value - minimum value
           from subtree) is bigger than res  */
        res.r = Math.max(res.r, t.key - val);
  
        /* Returning minimum value got so far */
        return Math.min(val, t.key);
    }

    // my impl without mutation of etc.Res param
    int[] maxDiffUtil1(Node t)
    {
        /* Returning Maximum int value if node is not
           there (one child case)  */
        if (t == null)
            return arrayOf(Integer.MAX_VALUE, Integer.MIN_VALUE);

        /* If leaf node then just return node's value  */
        if (t.left == null && t.right == null)
            return arrayOf(t.key, Integer.MIN_VALUE);

        /* Recursively calling left and right subtree
           for minimum value  */
        int[] leftDiff = maxDiffUtil1(t.left);
        int[] rightDiff = maxDiffUtil1(t.right);
        int p1 = min(leftDiff[0], rightDiff[0], t.key);
        int p2 = max(leftDiff[1], rightDiff[1], t.key - Math.min(leftDiff[0], rightDiff[0]));
        System.out.println(String.format("%s : %s, %s -> %s", t.key, Arrays.toString(leftDiff), Arrays.toString(rightDiff), Arrays.toString(arrayOf(p1,p2))));
        return arrayOf(p1, p2);
    }

    /* This function mainly calls maxDiffUtil() */
    int maxDiff(Node root) 
    {
        // Initialising result with minimum int value
        Res res = new Res();
        maxDiffUtil(root, res);
  
        return res.r;
    }
  
    /* Helper function to print inorder traversal of
       binary tree   */
    void inorder(Node root) 
    {
        if (root != null) 
        {
            inorder(root.left);
            System.out.print(root.key + "");
            inorder(root.right);
        }
    }
  
    // Driver program to test the above functions
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
  
        // Making above given diagram's binary tree
        tree.root = new Node(8);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(4);
        tree.root.left.right.right = new Node(7);
  
        tree.root.right = new Node(10);
        tree.root.right.right = new Node(14);
        tree.root.right.right.left = new Node(13);
  
        System.out.println("Maximum difference between a node and"
                + " its ancestor is : " + tree.maxDiffUtil1(tree.root)[1]);
    }

    private static int[] arrayOf(int a, int b) {
        return new int[] {a, b};
    }

    private static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    private static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
  
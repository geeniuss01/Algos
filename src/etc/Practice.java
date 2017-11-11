package etc;

import utils.Forest;
import utils.ListNode;

import java.util.*;
import utils.Node;

/**
 * http://www.geeksforgeeks.org/amazons-asked-interview-questions/
 *
 */
public class Practice {


    public static void main(String [] args) {

        //HashMap<Integer, Integer> map = new HashMap<>();
        //inOrderVerticalSum(buildBinaryTree(), map, 0);
        //System.out.println("answer "+map);

        //System.out.println(Arrays.toString(largestElements(2, new int[]{2,1, 3, 5}, 2)));

        //System.out.println(maxDepth(buildBinaryTree()));


//        ArrayList<Integer> leftNodes = new ArrayList<>();
//        leftviewMutate(buildBinaryTree2(), 0, new int[]{-1}, leftNodes);
//        System.out.println(leftNodes);
//        System.out.println(levelOrderTraversal(buildBinaryTree2()));

//        testDLL();

//        System.out.println(checkChildrenSumProp(buildChildrenSumTree()));

//        System.out.println(buildUpInorder(Forest.buildBinaryTree3()));

        //System.out.println(levelOrderRightview(Forest.buildBinaryTree3()));

//        System.out.println(height(Forest.buildTallTree()));
//        etc.Node tal = Forest.buildTallTree();
//        int maxThruRoot = height(tal.left) + 1 + height(tal.right);


        //testReverseLL();

        System.out.println(path(Forest.buildBinaryTree2(), 7));
    }

    private static void testReverseLL() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.nxt = n2;
        n2.nxt = n3;
        ListNode cur = n1, prev = null;
        while (cur != null) {
            ListNode nxt = cur.nxt;
            cur.nxt = prev;
            prev = cur;
            cur = nxt;
         }
         cur = prev;
        while (cur != null) {
            System.out.printf("->"+cur.n);
            cur = cur.nxt;
        }
    }

    /**
     * http://algorithms.tutorialhorizon.com/diameter-of-a-binary-tree/
     * @param n
     */
    public static void diameter(Node n) {
    }

    /**
     * http://algorithms.tutorialhorizon.com/find-the-maximum-depth-or-height-of-a-binary-tree/
     *
     * @return max(leftH, rightH) + 1
     */
    private static int height(Node n) {
        if(n==null) return 0;
        int leftH = n.left != null ? height(n.left) : 0;
        int rightH = n.right != null ? height(n.right) : 0;
        return 1 + Math.max(leftH, rightH);
    }

    private static ArrayList<Node> buildUpInorder(Node n) {
        ArrayList<Node> leftNodes = n.left!=null?buildUpInorder(n.left):new ArrayList<>();
        ArrayList<Node> rightNodes = n.right!=null?buildUpInorder(n.right):new ArrayList<>();

        ArrayList<Node> objects = new ArrayList<>();
        objects.addAll(leftNodes);
        objects.add(n);
        objects.addAll(rightNodes);
        return objects;
    }

    private static ArrayList<Node> levelOrderTopview(Node n){
        ArrayList<Node> l = new ArrayList<>();
        HashMap<Integer, Node> hdsToNodes = new HashMap<>();
        l.add(n);
        while (!l.isEmpty()) {
            Node rn = l.remove(0);
            if(!hdsToNodes.containsKey(rn.hd))
                hdsToNodes.put(rn.hd, rn);

            if(rn.left!=null) {
                rn.left.level = rn.level+1;
                rn.left.hd = rn.hd -1;
                l.add(rn.left);
            }
            if(rn.right!=null) {
                rn.right.level = rn.level+1;
                rn.right.hd = rn.hd + 1;
                l.add(rn.right);
            }
        }
        ArrayList<Node> nodes = new ArrayList<>(hdsToNodes.values());
        nodes.sort(Comparator.comparingInt(node -> node.hd));
        return nodes;
    }

    private static ArrayList<Node> levelOrderLeftview(Node n){
        ArrayList<Node> l = new ArrayList<>();
        HashMap<Integer, Node> hdsToNodes = new HashMap<>();
        l.add(n);
        while (!l.isEmpty()) {
            Node rn = l.remove(0);
            if(!hdsToNodes.containsKey(rn.level))
                hdsToNodes.put(rn.level, rn);

            if(rn.left!=null) {
                rn.left.level = rn.level+1;
                rn.left.hd = rn.hd -1;
                l.add(rn.left);
            }
            if(rn.right!=null) {
                rn.right.level = rn.level+1;
                rn.right.hd = rn.hd + 1;
                l.add(rn.right);
            }
        }
        ArrayList<Node> nodes = new ArrayList<>(hdsToNodes.values());
        nodes.sort(Comparator.comparingInt(node -> node.level));
        return nodes;
    }


    private static ArrayList<Node> levelOrderRightview(Node n){
        ArrayList<Node> l = new ArrayList<>();
        HashMap<Integer, Node> hdsToNodes = new HashMap<>();
        l.add(n);
        while (!l.isEmpty()) {
            Node rn = l.remove(0);
            hdsToNodes.put(rn.level, rn);

            if(rn.left!=null) {
                rn.left.level = rn.level+1;
                rn.left.hd = rn.hd -1;
                l.add(rn.left);
            }
            if(rn.right!=null) {
                rn.right.level = rn.level+1;
                rn.right.hd = rn.hd + 1;
                l.add(rn.right);
            }
        }
        ArrayList<Node> nodes = new ArrayList<>(hdsToNodes.values());
        nodes.sort(Comparator.comparingInt(node -> node.level));
        return nodes;
    }

    private static ArrayList<Node> levelOrderBottomview(Node n){
        ArrayList<Node> l = new ArrayList<>();
        HashMap<Integer, Node> hdsToNodes = new HashMap<>();
        l.add(n);
        while (!l.isEmpty()) {
            Node rn = l.remove(0);
            hdsToNodes.put(rn.hd, rn);

            if(rn.left!=null) {
                rn.left.level = rn.level+1;
                rn.left.hd = rn.hd -1;
                l.add(rn.left);
            }
            if(rn.right!=null) {
                rn.right.level = rn.level+1;
                rn.right.hd = rn.hd + 1;
                l.add(rn.right);
            }
        }
        ArrayList<Node> nodes = new ArrayList<>(hdsToNodes.values());
        nodes.sort(Comparator.comparingInt(node -> node.hd));
        return nodes;
    }


    private static void testDLL() {
        ArrayList<Integer> leftNodes = new ArrayList<>();
        System.out.println(convertToLL(Forest.buildBinaryTree2(), leftNodes));
        ListNode rn = new ListNode(leftNodes.get(0));
        ListNode prv = rn;
        for (int i = 0; i < leftNodes.size(); i++) {
            ListNode tmp = new ListNode(leftNodes.get(i));
            prv.nxt = tmp;
            tmp.prv = prv;
            prv = tmp;
        }
        ListNode t = rn;
        while (t.nxt != null) {
            System.out.println(t.n);
            t = t.nxt;
        }


        ListNode t1 = convertToLLB(Forest.buildBinaryTree2(), null);
        while (t1.prv != null) {
            System.out.println(t1.n);
            t1=t1.prv;
        }
        while (t1.nxt != null) {
            System.out.println(t1.n);
            t1 = t1.nxt;
        }
    }


    public static boolean checkChildrenSumProp(Node n) {
        int l = 0, r=0;
        boolean lr = true, rr= true;
        if (n.left != null) {
            l=n.left.num;
            lr = checkChildrenSumProp(n.left);
        }

        if (n.right != null) {
            r=n.right.num;
            rr = checkChildrenSumProp(n.right);
        }
        System.out.println(String.format("%d : %d %d %s %s",n.num,  l, r, lr, rr));
        boolean fine = l == 0 && r == 0 || n.num == l + r;
        return fine && lr && rr;
    }




    private static ListNode convertToLLB(Node n, ListNode ar) {
        if(n.left != null)
            ar = convertToLLB(n.left, ar);
        ListNode tmp = new ListNode(n.num);
        if(ar!=null) {ar.nxt = tmp;
            tmp.prv = ar;}
        ar = tmp;
        if(n.right!=null)
            ar = convertToLLB(n.right, ar);
        return ar;
    }

    private static void leftviewMutate(Node n, int lvl, int[] maxL, ArrayList<Integer> leftNodes){
        if(n == null) return;
        System.out.println(String.format("%d, %d, %d, %s", n.num, lvl, maxL[0], leftNodes));
        if (lvl > maxL[0]) {
            maxL[0]=lvl;
            leftNodes.add(n.num);
        }
        leftviewMutate(n.left, lvl+1, maxL, leftNodes);
        leftviewMutate(n.right, lvl + 1, maxL, leftNodes);
    }

    private static ArrayList<Integer> levelOrderTraversal(Node n){
        ArrayList<Node> l = new ArrayList<>();
        ArrayList<Integer> o = new ArrayList<>();
        l.add(n);
        while (!l.isEmpty()) {
            System.out.println(l);
            Node rn = l.remove(0);
            o.add(rn.num);
            if(rn.left!=null) l.add(rn.left);
            if(rn.right!=null) l.add(rn.right);
        }
        return o;
    }
    private static int maxDepth(Node n) {
        if(n == null) return 0;
        return Math.max(maxDepth(n.left), maxDepth(n.right))+1;
    }

    private static ArrayList convertToLL(Node n, ArrayList ar) {
        if(n.left != null) convertToLL(n.left, ar);
        ar.add(n.num);
        if(n.right!=null) convertToLL(n.right, ar);
        return ar;
    }



    static Integer[] largestElements(int k, int[] ar, int MAX_SIZE) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i< ar.length;i++) {
            int ele = ar[i];
            if (set.isEmpty() || ele > set.first()) {
                set.add(ele);
            }
            if(set.size()> MAX_SIZE) set.remove(set.first());
       }
       return set.toArray(new Integer[set.size()]);
    }

    static void inOrderVerticalSum(Node n, HashMap<Integer, Integer> map, int cur) {
        if(n.left != null) inOrderVerticalSum(n.left, map, cur - 1);
        //System.out.println(n.num+"," + map);
        Integer val = map.getOrDefault(cur, 0);
        map.put(cur, val + n.num);
        if(n.right!=null) inOrderVerticalSum(n.right, map, cur + 1);
        // 4 2 5 1 7 3 6
    }


    static ArrayList<Integer> path(Node n, int target) {
        ArrayList<Integer> l = new ArrayList<>();
        if (n != null) {
            if(n.num == target) l.add(n.num);
            if(n.left != null) {
                ArrayList<Integer> lf = path(n.left, target);
                if (!lf.isEmpty()) {
                    l.add(n.num);
                    l.addAll(lf);
                }
            }
            if (n.right != null) {
                ArrayList<Integer> rh = path(n.right, target);
                if (!rh.isEmpty()) {
                    l.add(n.num);
                    l.addAll(rh);
                }
            }
        }
        System.out.println(n.num+ " return "+l);
        return l;
    }
}

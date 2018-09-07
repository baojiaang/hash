package pat;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeTravel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] postorder = new int[n];
        int[] inorder = new int[n];
        for (int i = 0; i < n; i++)
            postorder[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            inorder[i] = sc.nextInt();

        Node root = rebuild(postorder, 0, n - 1, inorder, 0, n - 1);
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            res.add(node.value);
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
        System.out.print(res.get(0));
        for (int i = 1; i < res.size(); i++) {
            System.out.print(" " + res.get(i));
        }
        sc.close();

    }

    private static Node rebuild(int[] postorder, int postLeft, int postRight, int[] inorder, int inLeft, int inRight) {
//        System.out.println("hhhhhhhhhhh:"+postLeft+" "+postRight+" "+inLeft+" "+inRight);
        if (postLeft > postRight)
            return null;
        Node root = new Node(postorder[postRight]);
        int index = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == postorder[postRight])
                index = i;
        }
        int leftNum = index - inLeft;

        root.left = rebuild(postorder, postLeft, postLeft + leftNum - 1, inorder, inLeft, index - 1);
        root.right = rebuild(postorder, postLeft + leftNum, postRight - 1, inorder, index + 1, inRight);
        return root;
    }

    /*
     * 构造树节点类
     */
    static class Node {
        public Node(int value) {
            this.value = value;
        }

        int value;
        Node left;
        Node right;
    }
}

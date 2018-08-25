package pat;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IsItABinarySearchTree {
    private static class BinaryNode{
        Integer element;
        BinaryNode left;
        BinaryNode right;
        BinaryNode(Integer theElement){
            this(theElement,null,null);
        }
        BinaryNode(Integer theElement,BinaryNode lt,BinaryNode rt){
                element=theElement;
                left=lt;
                right=rt;
        }
    }
    private BinaryNode root =null;
    private BinaryNode insert(Integer x,BinaryNode t){
        if(t == null){
          return  new BinaryNode(x,null,null);
        }
        int compare=x.compareTo(t.element);


        if(compare<0)
         t.left=insert(x,t.left);

        if(compare>=0)
            t.right=insert(x,t.right);

        return t;

    }
    public void insert(Integer x){
        root=insert(x,root);
    }
    private BinaryNode insert2(Integer x,BinaryNode t){
        if(t == null){
            return  new BinaryNode(x,null,null);
        }
        int compare=x.compareTo(t.element);


        if(compare>=0)
            t.left=insert2(x,t.left);

        if(compare<0)
            t.right=insert2(x,t.right);

        return t;

    }
    public void insert2(Integer x){
        root=insert2(x,root);
    }
    public ArrayList<Integer> pre(){
        return  preTrael(root);
    }
    ArrayList<Integer> l=new ArrayList<>();
    ArrayList<Integer> r=new ArrayList<>();
    public ArrayList<Integer> preTrael(BinaryNode root){
        l.add(root.element);
        if(root.left!=null){
            preTrael(root.left);
        }
        if(root.right!=null){
            preTrael(root.right);
        }
        return  l;
    }
    public ArrayList<Integer> post(){
        return  postTrael(root);
    }
    public ArrayList<Integer> postTrael(BinaryNode root){


        if(root.left!=null){
            postTrael(root.left);
        }
        if(root.right!=null){
            postTrael(root.right);
        }
        r.add(root.element);
        return  r;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int arr[]=new int[n];
        boolean flag=true;
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        boolean isMirror=false;
        if(arr[0]<arr[1])
            isMirror=true;
        IsItABinarySearchTree is=new IsItABinarySearchTree();
        if(isMirror){
            for(int i=0;i<arr.length;i++){
                is.insert2(arr[i]);
            }
        }
        else{
            for(int i=0;i<arr.length;i++){
                is.insert(arr[i]);
            }
        }
        ArrayList<Integer> a=  is.pre();
        for(int i=0;i<a.size();i++){
            if(a.get(i)!=arr[i])
            {flag=false;
                System.out.println(a.get(i));
                System.out.println(arr[i]);
                break;
            }
        }
        if(flag==true) {
            ArrayList<Integer> b = is.post();
            System.out.println("YES");
            System.out.print(b.get(0));
            for(int i=1;i<b.size();i++){
                System.out.print(" "+b.get(i));
            }
        }
        else {
            System.out.println("NO");
        }




    }




}

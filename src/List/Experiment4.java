package List;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 *多项式 相关 运算
 */
public class Experiment4 {

    public static void main(String[] args) {

        List<Node> listA = init();//初始化第一个多项式
        List<Node> listB = init();//初始化第二个多项式
        long startTime=System.currentTimeMillis();
        //    System.out.println(polynomialMulti(listA,listB));
        System.out.println(polynomialPlus(listA,listB));
        long endTime=System.currentTimeMillis();
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");

    }


    private static List<Node> init() {//初始化链表
        List<Node> poly = new LinkedList<Node>();
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入 系数和参数(例如  a,b 表示 aX^b,输入 0,0 结束。)：");
        while (true) {
            String line = sc.nextLine();
            if ( vaildate(line) ){
                String[] split = line.split(",");

                int coefficient = Integer.parseInt(split[0]);//将String转化为int
                int exponential = Integer.parseInt(split[1]); //将String转化为int
                if(coefficient == 0 && exponential == 0){//如果等于0 跳出循环
                    break;
                }

                poly.add(new Node(coefficient, exponential));
            } else {
                System.out.println("[" + line + "]输入有误");
            }
        }
        System.out.println(poly);
        return poly;
    }



    /**
     * 多项式加法
     * @param listA
     * @param listB
     * @return
     */
    public static List<Node> polynomialPlus(List<Node> listA,List<Node> listB){
        List<Node> listC = new LinkedList<>();
        int sizeA = listA.size(),sizeB=listB.size(),ia=0,ib=0; //初始化size  ia，和ib作为index
        while( ia < sizeA && ib < sizeB ){//跑完listA和listB中共同的项数
            //获取指数
            if ( listA.get(ia).getExponential()< listB.get(ib).getExponential()){//如果A的第ia个的指数比B的ia个指数小
                listC.add(listA.get(ia));//将A的第ia个指数和系数添加到Listc中 作为保存
                ia ++ ;
            } else if( listA.get(ia).getExponential() == listB.get(ib).getExponential() ){  //如果指数相同
                int coefficient = listA.get(ia).getCoefficient() + listB.get(ib).getCoefficient();//就把listAde第ia个和listB中的第ib个的系数相加
                if( coefficient != 0 ){
                    listC.add(new Node(coefficient,listA.get(ia).getExponential()));//添加指数相同的listA和listB中的数据
                }
                ia ++ ;
                ib ++;

            } else {
                listC.add(listB.get(ib));
                ib ++;
            }
        }
        while (ia < sizeA) {//跑完A中剩余的
            listC.add( listA.get(ia++) );
        }
        while (ib < sizeB) {//跑完B中剩余的
            listC.add( listB.get(ib++) );
        }

        return listC ;

    }

    /**
     * 多项式乘法
     * @param listA
     * @param listB
     * @return
     */
    public static List<Node> polynomialMulti(List<Node> listA,List<Node> listB){
        List<Node> listC = new LinkedList<>();//listC作为保存的链表
        int sizeA = listA.size(),sizeB=listB.size(),ia=0,ib=0;   //初始化size  ia，和ib作为index
        while( ia < sizeA ){
            ib = 0;
            Node Na = listA.get(ia);//获取listA中ia位置的Node

            while (ib < sizeB) {
                Node nodeB = listB.get(ib); //获取listB中ib位置的Node
                int exp = nodeB.getExponential() + Na.getExponential();//指数相加
                int coe = nodeB.getCoefficient() * Na.getCoefficient();//系数相乘
                Node nodeByExp = getNodeByExp( listC, exp);//通过指数来获取Node
                if (nodeByExp != null) {//判断是否为空
                    if (coe + nodeByExp.getCoefficient() == 0) {//如果指数为0则排除
                        listC.remove(nodeByExp);
                    } else{
                        nodeByExp.setCoefficient( coe+ nodeByExp.getCoefficient() );//将系数相加
                    }
                } else {
                    listC.add(new Node(coe,exp));
                }
                ib ++ ;
            }

            ia ++;
        }
        return listC ;

    }




    /**
     * 根据指数 寻找对应的项，没有则返回null
     * @param p
     * @param exp
     * @return
     */
    public static Node getNodeByExp(List<Node> p,Integer exp){//根据指数数来找队形的项
        if (exp == null || p == null ){
            return null;
        }
        for (Node node : p) {//遍历List 直到找到当前Node
            if (node.exponential == exp) {
                return node;
            }
        }
        return null;

    }



    public static boolean vaildate(String s){//验证字符串的合法
        return s.matches("[-]{0,1}[0-9]+[,]{1}[0-9]+");
    }
}


class Node {//定义Node类 含有系数和指数两个属性

    Integer coefficient =0; //系数
    Integer exponential  =0; //指数

    public Node(Integer coefficient,Integer exponential){//构造器
        this.coefficient = coefficient;
        this.exponential = exponential;
    }

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    public Integer getExponential() {
        return exponential;
    }

    public void setExponential(Integer exponential) {
        this.exponential = exponential;
    }


    @Override
    public String toString() {
        return this.coefficient.toString() + "X^" + this.exponential.toString() ; //返回多项式的格式
    }
}

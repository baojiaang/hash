package assignment1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/*
BaoJiaang 18031228
it contains creatMaze(), getMaze(), showMaze()

 */
public class GenerateMaze {
    private  class Cell{
        private boolean north;
        private boolean south;
        private boolean west;
        private boolean east;
        private boolean visited;
        private ArrayList<Cell> adj;// every cell has it's own adj cell list,so that the it would not go out the border
        private int x;
        private int y;
        private int name;// the number of cell

        private Cell(){
            north=false;
            south=false;
            west=false;
            east=false;
            visited=false;
            adj=new ArrayList<>();
        }

    }

    private Cell[][] cells;
    private Queue<Cell> q;
    /*
    initialize the cells
     */
    public void init(){
        int count=0;//the number of cell
        for(int i=0;i<cells.length;i++){
            for(int j=0;j<cells[0].length;j++){
                cells[i][j]=new Cell();
                cells[i][j].x=j;// x axis
                cells[i][j].y=i;//y axis
                cells[i][j].name=++count;
            }
        }
    }
    public void addAdj(){
        for(int i=0;i<cells.length;i++){
            for(int j=0;j<cells[0].length;j++){
                if(i+1<cells[0].length){// if the x axis value is smaller than x right most
                    cells[i][j].adj.add(cells[i+1][j]);
                }
                if(j+1<cells.length){ // y value is smaller than y south most
                    cells[i][j].adj.add(cells[i][j+1]);
                }
                if(i-1>=0){// x value is bigger than x left most
                    cells[i][j].adj.add(cells[i-1][j]);
                }
                if(j-1>=0){ // y value is bigger than y north most
                    cells[i][j].adj.add(cells[i][j-1]);
                }

            }
        }
    }
    public void createMaze(int rows,int cols){
        cells=new Cell[rows][cols];
        init(); // initialize the cells first
        addAdj(); // add each cell's adj cells
        q=new LinkedList<>(); // the queue for create maze algorithm
        create(cells[0][0]); //start from the first cell
    }
    public void breakWall(Cell x,Cell y){
        if(x.x+1==y.x){
            breakWallEast(x,y);
        }
        else if(x.x-1==y.x){
            breakWallWest(x,y);
        }
        else if(x.y+1==y.y){
            breakWallSouth(x,y);
        }
        else if(x.y-1==y.y){
            breakWallNorth(x,y);
        }
    }
    public void breakWallEast(Cell x,Cell y){

        x.east=true;
        y.west=true;
    }
    public void breakWallWest(Cell x,Cell y){

        x.west=true;
        y.east=true;
    }
    public void breakWallNorth(Cell x,Cell y){

        x.north=true;
        y.south=true;
    }
    public void breakWallSouth(Cell x,Cell y){

        x.south=true;
        y.north=true;
    }
    public void create(Cell n){
        ArrayList<Cell> canVisitList=new ArrayList<>(n.adj);// get the cell can visit list ,at first is is the cell's adj cells list
        if(n.visited==false){
        q.offer(n);// add the cell to queue
        n.visited=true;
        }
        Random r=new Random();
      //  System.out.println(n.x+" "+n.y);
        while(canVisitList.size()>0){
            int random=r.nextInt(canVisitList.size());// randomly get a cell that precell can visit
            Cell a=canVisitList.get(random);// randomly get a cell that precell can visit
            if(a.visited==false)// if the cell is not visited
            {
                breakWall(n,a);
                create(a);
            }
            else {
                canVisitList.remove(a); //if the cell is visited ,remove this cell form
            }
        }

        //if it cannot find a cell that not visited ,then pop out a cell from the queue
        while(q.size()>0){
            Cell popCell=q.poll();
            create(popCell);
        }
    }
    public Digraph getMaze(){
        Digraph d=new Digraph();
        for(int i=0;i<cells.length;i++){//init
            for(int j=0;j<cells[0].length;j++){
                Cell cell=cells[i][j];
                d.add(cell.name);
            }
        }
        //use for loop to add edges
        for(int i=0;i<cells.length;i++){
            for(int j=0;j<cells[0].length;j++){
                Cell cell=cells[i][j];
                if(cell.north==true){//if the wall is borken
                    d.addEdge(cell.name,cells[i-1][j].name);
                }
                if(cell.south==true){
                    d.addEdge(cell.name,cells[i+1][j].name);
                }
                if(cell.east==true){
                    d.addEdge(cell.name,cells[i][j+1].name);
                }
                if(cell.west==true){
                    d.addEdge(cell.name,cells[i][j-1].name);
                }
            }
        }
        return d;
    }


    public void showMaze(){
        JFrame jFrame=new JFrame();

        JPanel jPanel=new JPanel(){
            @Override
            public void paint(Graphics graphics) {
                super.paint(graphics);
                for(int i=0,y=30;i<cells.length;i++,y+=30){
                    for(int j=0,x=30;j<cells[0].length;j++,x+=30){
                        graphics.drawRect(x,y,30,30);
                        if(cells[i][j].north==true){// if this walls is broken ,then break the wall in japnel
                            graphics.setColor(Color.gray);
                            graphics.clearRect(x,y,30,1);
                        }
                        if(cells[i][j].south==true){// if this walls is broken ,then break the wall in japnel
                            graphics.clearRect(x,y+30,30,1);
                        }
                        if(cells[i][j].east==true){// if this walls is broken ,then break the wall in japnel
                            graphics.clearRect(x+30,y,1,30);
                        }
                        if(cells[i][j].west==true){// if this walls is broken ,then break the wall in japnel
                            graphics.clearRect(x,y,1,30);
                        }
                    }
                }

            }
        };
        jFrame.add(jPanel);
        jFrame.setSize(350,350);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        GenerateMaze maze=new GenerateMaze();
        maze.createMaze(5,5);
        Digraph d=maze.getMaze();
        maze.showMaze();// In picture,the black line is wall
    }


}

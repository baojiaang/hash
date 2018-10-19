package assignment1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.util.*;
import java.util.List;

/*
BaoJiaang 18031228
public boolean isBipartite();
public void dfs_colouring(int node);
 */
public class Digraph extends JPanel implements MouseMotionListener, MouseListener, ActionListener {

	private int barb; //size of an arrow edge
	private double phi; //angle of an arrow edge
	private Integer moveNode; //the node the user is moving on the GUI
	private Integer selectedNode; // the node selected
	private Stack<Integer> stack;
	private ArrayList<Integer> needPrint;

    public final static int CIRCLEDIAMETER = 40; //Diameter of the nodes


	// This is the adjacency list representation of the digraph
	// The nodes are denoted here as Integers
	// Each node is associated with a list of Integers, which indicates its out-neighbours
	private HashMap<Integer, List<Integer>> data;

	//
	private HashMap<Integer, Node> nodeList;

	private HashMap<Integer, Boolean> visited;
	private HashMap<Integer,Integer> colour;
	private boolean flag;

	// The collection of node in the graph
	// This set is the key set of data
	private Set<Integer> nodeSet;


	// The textfield used for user to specify commands
	private JTextField tf;


	// The Constructor
	public Digraph(){
		data = new HashMap<Integer, List<Integer>>();
		nodeList = new HashMap<Integer, Node>();
		nodeSet=data.keySet();
		stack=new Stack<>();
        JPanel panel = new JPanel();
        barb = 20;                   // barb length
        phi = Math.PI / 12;             // 30 degrees barb angle
        setBackground(Color.white);
        addMouseMotionListener(this);
        addMouseListener(this);
        tf = new JTextField();
        tf.addActionListener(this);
        setLayout(new BorderLayout());
		add(panel, BorderLayout.NORTH);
		add(tf, BorderLayout.SOUTH);
        moveNode = -1; 				// Initial values of moveNode is -1
		selectedNode=-1;			// Initial values of moveNode is -1


		visited = new HashMap<Integer,Boolean>();
		colour=new HashMap<>();
		flag=true;

	}


	/**
	  * The method adds a node to the digraph, labeled by the int value node
	  *
	  */
	public void add(int node){
		// If the label node is already in the digraph, do nothing and return
		if(data.containsKey((Integer)node)) return;
		// Create a new linked list
		List<Integer> list = new LinkedList<Integer>();
		// Add a new entry to the adjacency list
		data.put((Integer)node, list);

		// Create a new node in the GUI
		// Set a random initial position
		// Link the new node with the corresponding node in the GUI
		Node nodeVisual = new Node(node);
        nodeVisual.xpos = 50 +(int) (Math.random() * 320);
        nodeVisual.ypos = 50 +(int) (Math.random() * 320);
		nodeList.put((Integer)node, nodeVisual);

	}
	public void add2(int node,List<Integer> list){
		// If the label node is already in the digraph, do nothing and return
		if(data.containsKey((Integer)node)) return;
		// Create a new linked list
		// Add a new entry to the adjacency list
		data.put((Integer)node, list);

		// Create a new node in the GUI
		// Set a random initial position
		// Link the new node with the corresponding node in the GUI
		Node nodeVisual = new Node(node);
		nodeVisual.xpos = 50 +(int) (Math.random() * 320);
		nodeVisual.ypos = 50 +(int) (Math.random() * 320);
		nodeList.put((Integer)node, nodeVisual);

	}


	/**
	  * The method adds an edge to the digraph
	  * The source of the edge is labeled node1
	  * The target of the edge is labeled node2
	  *
	  */
	public void addEdge( int node1, int node2){
		if (node1==node2) return;
		if (!data.containsKey((Integer)node1) || !data.containsKey((Integer)node2))
			return;
		List<Integer> list = data.get((Integer)node1);
		if(!list.contains((Integer)node2))
			list.add((Integer)node2);
	}

	/**
	  * The method removes an edge from the digraph
	  * The source of the edge is labeled node1
	  * The target of the edge is labeled node2
	  *
	  */
	public void removeEdge(int node1, int node2){
		if (!data.containsKey((Integer)node1) || !data.containsKey((Integer)node2))
			return;
		List<Integer> list = data.get((Integer)node1);
		if(list.contains((Integer)node2))
			list.remove((Integer)node2);
	}


	/**
	  * The method removes a node from the digraph
	  * You need to complete this method
	  * It should do nothing if the node is not contained in the digraph
	  */
	public void remove(int node){
		/////////////////////////////////////////
		//Insert your code here
		/////////////////////////////////////////
		if (!data.containsKey((Integer)node))
			return;
		List<Integer> list;
		for (Integer i: nodeSet){
			list = data.get((Integer)i);
			if(list.contains((Integer)node))
				list.remove((Integer)node);
		}
		data.remove((Integer)node);
		nodeList.remove((Integer)node);

	}




	/**
	  * This method computes and returns the indegree of a given node in the digraph
	  *
	  * You need to complete this method
	  *
	  */
	public int indegree(int node){
		/////////////////////////////////////////
		//Insert your code here
		/////////////////////////////////////////

		if (!data.containsKey((Integer)node)) return -1;
		List<Integer> list;
		int indeg=0;
		for (Integer j: nodeSet){
			list = data.get((Integer)j);
			if(list.contains((Integer)node))
				indeg++;
		}
		return indeg;
	}

	/**
	  * This method computes and returns the outdegree of the given node in the digraph
	  *
	  */
	public int outdegree(int node){
		if (!data.containsKey((Integer)node)) return -1;
		return data.get((Integer)node).size();
	}


	/**
	  * This method computes and returns the size (number of edges) of the graph
	  *
	  */
	public int graphSize(){
		List<Integer> list;
		int s=0;
		for (Integer j: nodeSet){
			list = data.get((Integer)j);
			s=s+list.size();
		}
		return s;
	}

	/**
	  * This method computes and returns the order (number of nodes) of the graph
	  *
	  */
	public int graphOrder(){
		return data.size();
	}


	/**
	  * This method returns true if and only if the given node i
	  * is a universal source in the graph
	  *
	  */
	public boolean isUniversalSource(int node){
		if (!data.containsKey((Integer)node)) return false;
		return (indegree(node)==0 && outdegree(node)==(graphOrder()-1));
	}

	/**
	  * This method returns true if and only if the given node i
	  * is a universal sink in the graph
	  *
	  */
	public boolean isUniversalSink(int node){
		if (!data.containsKey((Integer)node)) return false;
		return (outdegree(node)==0 && indegree(node)==(graphOrder()-1));
	}


	/**
	  * This method prints out the adjacency list of the graph
	  *
	  */
	public void printList(){
		int n=graphOrder();
		List<Integer> list;
		for (int i=0;i<n;i++){
				System.out.print("---");
		}
		System.out.print('\n');

		for (Integer i: nodeSet){
			list = data.get(i);
			System.out.print(""+i+": ");
			for (Integer j: list){
				System.out.print(" "+j);
			}
			System.out.print('\n');
		}
		for (int i=0;i<n;i++){
				System.out.print("---");
		}
		System.out.print('\n');

	}

	/**
	  * This method prints out the adjacency matrix of the graph
	  * You need to complete this method
	  *
	  * The method computes the following data structure:
	  * 1. a HashMap labels which associates each number between 0 and n-1 a unique node label
	  * 2. a boolean nxn matrix adjMatrix storing the adjacency matrix where:
	  *		 the ith row/column  corresponds to the node with label labels.get(i)
	  *
	  * The method then prints out the adjacency matrix
	  * To the left and on top of the matrix, the method also prints out
	  * the node label which corresponds to each row and column
	  */
	public void printMatrix(){
		// n is the order of the graph
		int n=graphOrder();

		// the HashMap associates an index in [0..n-1] with a node label
		HashMap<Integer,Integer> labels = new HashMap<Integer,Integer>();

		// the adjacency matrix of the digraph, where the node indices in
		// the matrix are indicated by the labels HashMap
		boolean[][] adjMatrix = new boolean[n][n];

		/////////////////////////////////////////
		//Insert your code here
		/////////////////////////////////////////

		List<Integer> list;
		int row=0;
		int column=0;
		int index=0;

		for (Integer i: nodeSet){
			labels.put((Integer) index, (Integer)i);
			index++;
		}
		for (int i=0;i<n;i++){
			list = data.get(labels.get((Integer)i));
			for (int j=0; j<n; j++){
				adjMatrix[i][j]=(list.contains(labels.get((Integer)j)));
			}
		}

		for (int i=0;i<=8*n;i++){
				System.out.print("-");
		}
		System.out.print('\n');

		System.out.print(""+'\t');
		for (int i=0;i<n;i++){
			System.out.print(""+labels.get((Integer)i)+'\t');
		}
		System.out.print(""+'\n');


		for (int i=0; i<n;i++){
			System.out.print(""+labels.get((Integer)i));
			for (int j=0; j<n;j++){
				if (adjMatrix[i][j])
					System.out.print('\t'+"1");
				else
					System.out.print('\t'+"0");
			}
			System.out.print(""+'\n');
		}
		for (int i=0;i<=8*n;i++){
				System.out.print("-");
		}
		System.out.print('\n');

	}


	/**
	  * Clear the digraph
	  *
	  */
	public void clear(){
		data.clear();
		nodeList.clear();
	}


	/**
	  * Compute the transpose of the current digraph
	  * which is defined as the graph with the same nodes
	  * while the direction of all edges are reversed
	  */
	public void transpose(){
		/////////////////////////////////////////
		//Insert your code here
		/////////////////////////////////////////
		int tranadjMatrix[][]=new int[data.size()][data.size()];
		Iterator<Map.Entry<Integer, List<Integer>>> it=data.entrySet().iterator();
		int i=0;
		while(it.hasNext()){
			Map.Entry<Integer,List<Integer>> entry=it.next();
			List<Integer> nodes=entry.getValue();
			for(int j=0;j<nodes.size();j++){
				tranadjMatrix[nodes.get(j)][i]=1; // change to the transpose matrix directly
			}
			i++;
		}

		clear();
		for(int j=0;j<tranadjMatrix.length;j++){
			add(j); //add node first
		}
		for(int j=0;j<tranadjMatrix.length;j++){
			for(int k=0;k<tranadjMatrix[0].length;k++){
				int value=tranadjMatrix[j][k];
				if(value==1)
				{
					addEdge(j,k);
				}
			}

		}
	}


	/**
	  * Converts the current digraph to its underlying graph
	  * which is defined as the undirected graph obtained by "removing the direction" from all directed edges
	  */
	public void underlying(){


		int n=graphOrder();
		boolean[][] adjMatrix = new boolean[n][n];
		List<Integer> list;
		int row=0;
		int column=0;
		HashMap<Integer,Integer> labels = new HashMap<Integer,Integer>();
		int index=0;

		for (Integer i: nodeSet){
			labels.put((Integer) index, (Integer)i);
			index++;
		}
		for (int i=0;i<n;i++){
			list = data.get(labels.get((Integer)i));
			for (int j=0; j<n; j++){
				adjMatrix[i][j]=(list.contains(labels.get((Integer)j)));
			}
		}

		for (int i=0; i<n;i++){
			list = data.get(labels.get(i));
			list.clear();
			for(int j=0; j<n; j++){
				if(adjMatrix[j][i] || adjMatrix[i][j])
					addEdge(i,j);
			}
		}
	}

	public void contract(int node1, int node2){
		if (!data.containsKey(node1) || !data.containsKey(node2) || node1==node2) return;

		int small,big;
		if(node1<node2) {
			small = node1;
			big=node2;
		}
		else{
			small=node2;
			big=node1;
		}

		List<Integer> list1 = data.get((Integer)small);
		List<Integer> list2 = data.get((Integer)big);

		for (Integer i: list2){
			if (i!=small && !list1.contains((Integer)i)){
				list1.add((Integer)i);
			}
		}
		List<Integer> list;

		if (list1.contains(big))
			list1.remove((Integer)big);

		for (Integer i: nodeSet){
			if(i!=big && i!=small){
				list = data.get((Integer)i);
				if (list.contains(big)){
					list.remove((Integer)big);
					if(!list.contains(small))
						list.add((Integer)small);
				}
			}
		}


		data.remove((Integer)big);
		nodeList.remove((Integer)big);
	}

	/**
	  * This method specifies how the digraph may be controled by the user
	  * by inputing commands in the TextField
	  *
	  */
	public void actionPerformed(ActionEvent evt) {
	    String command = tf.getText();

		StringTokenizer st = new StringTokenizer(command);

		String token,opt;
		Integer node1, node2;
		if(st.hasMoreTokens()) {
			token = st.nextToken();
			token=token.toLowerCase();
			switch(token){
				case "add":
							try{
								opt=st.nextToken();
								opt=opt.toLowerCase();
								if(opt.equals("edge")){
									node1 = Integer.parseInt(st.nextToken());
									node2 = Integer.parseInt(st.nextToken());
									if(st.hasMoreTokens()) break;
									addEdge(node1,node2);
								}
								else if(opt.equals("node")){
									node1 = Integer.parseInt(st.nextToken());
									if(st.hasMoreTokens()) break;
									add(node1);
								}
							}catch(Exception e){
								System.out.println("Invalid command");
							}
							break;
				case "remove":
							try{
								opt=st.nextToken();
								opt=opt.toLowerCase();
								if(opt.equals("edge")){
									node1 = Integer.parseInt(st.nextToken());
									node2 = Integer.parseInt(st.nextToken());
									if(st.hasMoreTokens()) break;
									removeEdge(node1,node2);
								}
								else if(opt.equals("node")){
									node1 = Integer.parseInt(st.nextToken());
									if(st.hasMoreTokens()) break;
									remove(node1);
								}
							}catch(Exception e){System.out.println("Invalid command");}
							break;
				case "print":
							try{
								opt=st.nextToken();
								opt=opt.toLowerCase();
								if(st.hasMoreTokens()){
									System.out.println("Invalid command");
									break;
								}
								switch(opt){
									case "degrees":
										if (opt.equals("degrees")){
											for (Integer i: nodeSet)
												System.out.println("Node "+i+" indegree: "+ indegree(i) + " outdegree: "+outdegree(i));
										}
										break;
									case "size":
										System.out.println("Size of the digraph: "+graphSize());
										break;
									case "order":
										System.out.println("Order of the digraph: "+graphOrder());
										break;
									case "matrix":
										printMatrix();
										break;
									case "list":
										printList();
										break;
									default:
										System.out.println("Invalid command");
										break;
								}
							}catch(Exception e){System.out.println("Invalid command");}
							break;
				case "transpose":
							if (!st.hasMoreTokens())
								transpose();
							else
								System.out.println("Invalid command");
							break;
				case "underlying":
							try{
								if(st.nextToken().toLowerCase().equals("graph") && !st.hasMoreTokens())
									underlying();
							} catch(Exception e){System.out.println("Invalid command");}
							break;
				case "find":
							try{
								if (!st.nextToken().equals("universal")){
									System.out.println("Invalid command");
									break;
								}
								opt=st.nextToken();
								opt=opt.toLowerCase();
								boolean found=false;
								if(st.hasMoreTokens()) break;
								switch(opt){
									case "source":
										for (Integer i: nodeSet){
											if (isUniversalSource(i)){
												selectedNode = i;
												System.out.println("Universal Source found: "+i);
												found=true;
												break;
											}
										}
										if (!found)
											System.out.println("There is no universal source in the graph");
										break;
									case "sink":
										for (Integer i: nodeSet){
											if (isUniversalSink(i)){
												selectedNode = i;
												System.out.println("Universal Sink found: "+i);
												found=true;
												break;
											}
										}
										if (!found)
											System.out.println("There is no universal sink in the graph");
										break;
									default:
										System.out.println("Invalid command");
										break;
								}
							} catch(Exception e){System.out.println("Invalid command");}
							break;
				case "contract":
							try{
									node1 = Integer.parseInt(st.nextToken());
									node2 = Integer.parseInt(st.nextToken());
									if(st.hasMoreTokens()) break;
									contract(node1,node2);
							} catch (Exception e){System.out.println("Invalid command");}
							break;
				case "clear":
							if (!st.hasMoreTokens())
								clear();
							else
								System.out.println("Invalid command");
							break;
				default:
						System.out.println("Invalid command");
						break;
			}

     	}
     	repaint();

	}



	/**
	  * Paint the digraph to the panel
	  *
	  */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        //clear the previous screen
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, 1500, 1500);
        g2d.setColor(Color.BLACK);

		List<Integer> outNeighbours;

		for (Integer i : nodeSet){
			if(selectedNode==i)
				nodeList.get(i).draw(g, Color.RED);
			else
				nodeList.get(i).draw(g, Color.BLACK);
			outNeighbours = data.get(i);
			for(int j=0; j<outNeighbours.size(); j++){
				drawEdge(i,outNeighbours.get(j),g, Color.BLACK, Color.BLUE);
			}
		}

    }


   /**
    * Draw a directed edge between 2 nodes with the specific color for the line and the arrow.
    */
    public void drawEdge(Integer node1, Integer node2, Graphics g, Color colorLine, Color colorArrow) {

        Graphics2D g2 = (Graphics2D) g;

        int startX = nodeList.get(node1).getEdgeX(nodeList.get(node2));
        int startY = nodeList.get(node1).getEdgeY(nodeList.get(node2));

        int destX = nodeList.get(node2).getEdgeX(nodeList.get(node1));
        int destY = nodeList.get(node2).getEdgeY(nodeList.get(node1));

        g2.setStroke(new BasicStroke(2));
        g2.setColor(colorLine);

        g2.drawLine(startX, startY, destX, destY);

        double theta, x, y;
        g2.setPaint(colorArrow);
        theta = Math.atan2(destY - startY, destX - startX);
        drawArrow(g2, theta, destX, destY);

    }

    //draws the arrows on the edges
    private void drawArrow(Graphics2D g2, double theta, double x0, double y0) {
        g2.setStroke(new BasicStroke(3));
        double x = x0 - barb * Math.cos(theta + phi);
        double y = y0 - barb * Math.sin(theta + phi);
        g2.draw(new Line2D.Double(x0, y0, x, y));
        x = x0 - barb * Math.cos(theta - phi);
        y = y0 - barb * Math.sin(theta - phi);
        g2.draw(new Line2D.Double(x0, y0, x, y));
    }




    // Mouse Actions:
    // Moving a node: The user may drag and drop a node to any position
    // Add a node: The user may add a node by clicking a white area of the frame
    //				The newly added node will be automatically selected
    // Selecting a node: The user may select a node by click on a node
    // Add an edge: Once a node is selected, the user may add an outgoing edge
    //				to the selected node by clicking another node
    @Override
    public void mouseDragged(MouseEvent e) {
        if (moveNode >= 0) {
            Node node = nodeList.get(moveNode);
            node.xpos = e.getPoint().x;
            node.ypos = e.getPoint().y;
            repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
		Node node;
		boolean onNode=false;
        Integer clicked=-1;
        for (Integer i: nodeSet) {
			node=nodeList.get(i);
            //Calculate the distance to the center of a node
            double distance=Math.sqrt(Math.pow((e.getX()-node.xpos), 2)+Math.pow((e.getY()-node.ypos), 2));
            if (distance<=(1.0*CIRCLEDIAMETER/2)) {
                onNode=true;
                clicked = i;
            }
        }
        if (onNode){
			if (selectedNode==-1)
				selectedNode=clicked;
			else{
				if (clicked.equals(selectedNode)){
					selectedNode=-1;
				}
				else{
					addEdge(selectedNode,clicked);
					selectedNode=-1;
				}
			}
		}
        if (!onNode) {
        	int newNode =0;
        	while(nodeSet.contains((Integer)newNode))
        		newNode++;
        	add((Integer)newNode);
        	selectedNode=newNode;
		}
      	repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
		Node node;
        for (Integer i: nodeSet) {
            node=nodeList.get(i);
            //Calculate the distance to the center of a node
            double distance=Math.sqrt(Math.pow((e.getX()-node.xpos), 2)+Math.pow((e.getY()-node.ypos), 2));
            if (distance<=(1.0*CIRCLEDIAMETER/2)) {
                moveNode = i;
            }
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        moveNode = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }



	// An inner class storing information regarding the visualisation of a node
    private class Node {

        public int xpos;
        public int ypos;
        public int nodeNum;
        public int inEdges, arraySpot;

		int dirX, dirY;

        public Node(int num) {
            xpos = 0;
            ypos = 0;
            nodeNum = num;
            inEdges = 0;
            arraySpot = 0;

			double rand = Math.random();

			if(rand<0.25){
				dirX=1;
				dirY=1;
			} else if(rand<0.5){
				dirX=-1;
				dirY=1;
			} else if(rand<0.75){
				dirX=1;
				dirY=-1;
			} else{
				dirX=-1;
				dirY=-1;
			}

        }

		// returns the label of the node
        public int label(){
			return nodeNum;
		}

		// compute the x coordinate of the source of the edge from this to the specified node
        public int getEdgeX(Node node) {
            double direction = 1.0;
            if (node.xpos < xpos) {
                direction = -1.0;
            }
            double x2subx1sqr = Math.pow((node.xpos - xpos), 2);
            double y2suby1sqr = Math.pow((node.ypos - ypos), 2);
            double rsqr = Math.pow(CIRCLEDIAMETER*1.0/2, 2);
            double x = Math.sqrt((x2subx1sqr * rsqr / (x2subx1sqr + y2suby1sqr))) * direction + xpos;
            return (int) Math.round(x);
        }

		// compute the y coordinate of the source of the edge from this to the specified node
        public int getEdgeY(Node node) {
            double direction = 1.0;
            if (node.ypos < ypos) {
                direction = -1.0;
            }
            double x2subx1sqr = Math.pow((node.xpos - xpos), 2);
            double y2suby1sqr = Math.pow((node.ypos - ypos), 2);
            double rsqr = Math.pow(CIRCLEDIAMETER*1.0/2, 2);//Square root of radius
            double y = Math.sqrt((y2suby1sqr * rsqr / (x2subx1sqr + y2suby1sqr))) * direction + ypos;
            return (int) Math.round(y);
        }

		// draw the node
        public void draw(Graphics g, Color color) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setStroke(new BasicStroke(2));
            g2d.setColor(color);
            g2d.drawOval(xpos-(CIRCLEDIAMETER / 2), ypos-(CIRCLEDIAMETER / 2), CIRCLEDIAMETER, CIRCLEDIAMETER);
            g2d.setColor(Color.BLUE);
            g2d.drawString("" + nodeNum, xpos-3, ypos+4 );
            g2d.setColor(Color.BLACK);
        }

        public void move(){

			xpos = xpos -2*dirX;
			ypos = ypos -2*dirY;

			if (xpos<50 || xpos>360) dirX=(-1)*dirX;
			if (ypos<50 || ypos>360) dirY=(-1)*dirY;


		}
    }

    //insert your implementation
	public void printSCC(){
		stack=new Stack<>();
		dfs();
		transpose();
		visited.clear();
		int size=stack.size();
		for(int i=0;i<size;i++){
			int node=stack.pop();
			boolean isvisit=false;
			needPrint=new ArrayList<>();
			if(visited.containsKey(node))
			{
				isvisit=visited.get(node);

			}
			if(isvisit==false) {
				dfs_explore(node);
				System.out.println(needPrint);
			}
		}
	}
	
	public void dfs(){
		//Insert your implementation
		Iterator<Map.Entry<Integer,List<Integer>>> it=data.entrySet().iterator();
		while (it.hasNext()){
			Map.Entry<Integer,List<Integer>> entry=it.next();
			Integer node=entry.getKey();

			boolean isvisit;
			if(visited.containsKey(node))
			{isvisit=visited.get(node);
			}
			else {
				isvisit=false;
			}
			if(isvisit==false)
				explore(node);
		}
	}

	public void explore(int i){
		//Insert your implementation
		List<Integer> list=data.get(i);
		visited.put(i,true);
		for(int j=0;j<list.size();j++){
			int node=list.get(j);

			boolean isvisit;
			if (visited.containsKey(node)) {
				isvisit=visited.get(node);
			}
			else {
				isvisit=false;
			}
			if(isvisit==false)
				explore(node);
		}
		stack.push(i); // this line is for the question 5

	}

	public void dfs_explore(int node){
			visited.put(node,true);
			needPrint.add(node);
			List<Integer> list = data.get(node);
			for (int j = 0; j < list.size(); j++) {
				int now = list.get(j);
				boolean isvisit;
				if (visited.containsKey(now)) {
					isvisit = visited.get(now);
				} else {
					isvisit = false;
				}
				if (isvisit == false) {
					dfs_explore(now);
				} else {
					//System.out.println();
				}
			}

	}
	public boolean isBipartite(){
		flag=true;
		Iterator<Map.Entry<Integer, List<Integer>>> it=data.entrySet().iterator();
		Map.Entry<Integer, List<Integer>> map=it.next();
		int node=map.getKey();
		colour.put(node,1);// initialize the first node
		dfs_colouring(0);//use dfs to check whether it is a bipartite graph
		return flag;
	}
	/*
	* use dfs
	*
	* we use two colour to colouring the node,if all two adjacent node's have different colour,it is a bipartite graph
	* */
	public void dfs_colouring(int node){
		List<Integer> adjList=data.get(node);
		visited.put(node,true);
		int thiscolour=colour.get(node);// get the colour of the now node,if it is coloured . otherwise it will get the default value 0
		int printcolour;
		if(thiscolour==1)
			printcolour=0;
		else
			printcolour=1;
		for(int i=0;i<adjList.size();i++){
			int nowNode=adjList.get(i);
			boolean visit;
			if(visited.containsKey(nowNode)) //if it is in the visited map
				visit=visited.get(nowNode);
			else
				visit=false;
			if(visit==false) {
				colour.put(nowNode, printcolour);
				dfs_colouring(nowNode);
			}
			else {
				int adjColour=colour.get(nowNode);
				if(adjColour==thiscolour)// if the adjacent colour is same to current node's colour, so the digraph is not a Bipartite
				{
					flag=false;
					break;

				}
			}
		}
	}


	// A demo program that performs several graph updates and queries for testing the data structure
	public void demo(){

		for (Integer i: nodeSet)
			System.out.println("Node "+i+" indegree: "+ indegree(i) + " outdegree: "+outdegree(i));
		System.out.println("Size of the digraph: "+graphSize());
		System.out.println("Order of the digraph: "+graphOrder());

		boolean found=false;

		printMatrix();
		printList();

		try{
			Thread.sleep(2000);
			for (Integer i: nodeSet){
				if (isUniversalSource(i)){
					selectedNode = i;
					System.out.println("Universal Source found: "+i);
					found=true;
					break;
				}
			}
			repaint();

		    Thread.sleep(1500);

			found=false;
			for (Integer i: nodeSet){
				if (isUniversalSink(i)){
					selectedNode = i;
					System.out.println("Universal Sink found: "+i);
					found=true;
					break;
				}
			}
			repaint();

		    Thread.sleep(1500);
			selectedNode=-1;


			System.out.println("Transpose");
			transpose();
			repaint();
			printMatrix();

		    Thread.sleep(1500);

			System.out.println("Underlying Graph");
			underlying();
			repaint();
			printMatrix();

		    Thread.sleep(1500);

			clear();
			System.out.println("Create a directed star");
			add(0);
			for (int i=1;i<11;i++){
				add(i);
				addEdge(0,i);
			}
			repaint();

			for (int i=0;i<500;i++){
			    Thread.sleep(30);
			    for(Integer node: nodeSet){
					nodeList.get(node).move();
				}
				if(i>50) remove((i+1)/50);
				repaint();
			}

			Thread.sleep(500);

			clear();

			System.out.println("Create a directed cycle");

			for (int i=0;i<10;i++){
				add(i);
				if (i>0)
					addEdge(i,i-1);
			}
			addEdge(0,9);

			repaint();

			for (int i=0;i<500;i++){
			    Thread.sleep(30);
			    for(Integer node: nodeSet){
					nodeList.get(node).move();
				}
				if(i>50) contract((i+1)%500/50,0);
				repaint();
			}

			Thread.sleep(500);

			System.out.println("Create a complete graph");
			for (int i=0;i<10;i++){
				add(i);
			}
			for (Integer i: nodeSet){
				for(Integer j: nodeSet){
					if (i!=j){
						addEdge(i,j);
						addEdge(j,i);
					}
				}
			}
			repaint();


			for (int i=0;i<500;i++){
				Thread.sleep(30);
				for(Integer node: nodeSet){
					nodeList.get(node).move();
				}
				if(i>50) remove((i+1)%500/50);
					repaint();
			}

		}catch(Exception e)	{System.out.println("Exception caught");}



	}



	// The main method builds a digraph and add three initial nodes to the digraph labeled 0,1,2
	// and adds some edges among these nodes
	//
    public static void main(String[] args) {
//		GenerateMaze maze=new GenerateMaze();
//		maze.createMaze(3,3);
//
//        Digraph g =maze.getMaze();;
        Digraph g=new Digraph();
        g.add(0);
		g.add(1);
		g.add(2);
		g.add(3);
		g.addEdge(0,1);
		g.addEdge(1,2);
		g.addEdge(2,3);
		g.addEdge(3,0);
		System.out.println(g.isBipartite());
		//g.dfs();
  // g.transpose();
//		g.printSCC();


        JFrame frame = new JFrame("Directed Graph Implementation");
        frame.setSize(450, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(0, 0);
        frame.getContentPane().add(g);
        frame.setVisible(true);

		//g.demo(); // Do a little play with the graph

		// Expected Print Output:
		/**
		 * Node 0 indegree: 0 outdegree: 2
		 * Node 1 indegree: 1 outdegree: 1
		 * Node 2 indegree: 2 outdegree: 0
		 * Size of the digraph: 3
		 * Order of the digraph: 3
		 * -------------------------
		 *         0       1       2
		 * 0       0       1       1
		 * 1       0       0       1
		 * 2       0       0       0
		 * -------------------------
		 * ---------
		 * 0:  1 2
		 * 1:  2
		 * 2:
		 * ---------
		 * Universal Source found: 0
		 * Universal Sink found: 2
		 * Transpose
		 * -------------------------
		 *         0       1       2
		 * 0       0       0       0
		 * 1       1       0       0
		 * 2       1       1       0
		 * -------------------------
		 * Underlying Graph
		 * -------------------------
		 *         0       1       2
		 * 0       0       1       1
		 * 1       1       0       1
		 * 2       1       1       0
		 * -------------------------
		 */

    }



}

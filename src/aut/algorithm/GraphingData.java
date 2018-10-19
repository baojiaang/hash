package aut.algorithm;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;


/** This class implements a JPanel drawing a single variable function
  * To use this class, you need to create a GraphingData object specifying the x and y values of the points
  * as two long arrays
  * Author: Jiamou Liu
  *
*/

public class GraphingData extends JPanel {

	long[] xValues;
	long[] yValues;
	String caption;

    final int PAD = 40;

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        // Draw ordinate.
        g2.draw(new Line2D.Double(PAD, PAD, PAD, h-PAD));
        // Draw abcissa.
        g2.draw(new Line2D.Double(PAD, h-PAD, w-PAD, h-PAD));
        double xInc = (double)(w - 2*PAD)/getXMax();
        double scale = (double)(h - 2*PAD)/getYMax();
        // Mark data points.
        g2.setPaint(Color.red);
        double px=PAD;
        double py=h-PAD;
        double x=0;
        double y=0;
        g2.drawString(caption, PAD, PAD/2);
        for(int i = 0; i < xValues.length; i++) {
            x = PAD + xValues[i]*xInc;
            y = h - PAD - scale*yValues[i];
            g2.fill(new Ellipse2D.Double(x-2, y-2, 4, 4));
            g2.draw(new Line2D.Double(px,py,x,y));
            g2.drawString(xValues[i]+"",(int)x,h-PAD+15);
            g2.drawString(yValues[i]+"".toString(),0,(int)y);
            px=x;
            py=y;
        }
    }

	private void setValues(long[] x, long[] y){
		xValues = x;
		yValues = y;
	}

    private long getXMax() {
        long max = -Long.MAX_VALUE;
        for(int i = 0; i < xValues.length; i++) {
            if(xValues[i] > max)
                max = xValues[i];
        }
        return max;
    }

    private long getYMax() {
        long max = -Long.MAX_VALUE;
        for(int i = 0; i < yValues.length; i++) {
            if(yValues[i] > max)
                max = yValues[i];
        }
        return max;
    }
	public GraphingData(String cap, long[] x, long[] y){
		super();
		caption = cap;
		setValues(x,y);
		JFrame f = new JFrame(cap);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(this);
		f.setSize(800,600);
		f.setLocation(200,200);
		f.setVisible(true);
    }




    public static void main(String[] args) {
		//*****************************
		//INPUT THE X AND Y VALUES HERE
        Fibonacci fib=new Fibonacci();

		long[] x=new long[10001];
        long[] y = new long[10001];
        long all=0;
		for(int i=0;i<=10000;i++){
            x[i]=i;
            long start=System.currentTimeMillis();
            fib.fib4(i);
            long end=System.currentTimeMillis();
            long time=end-start;
            all+=time;

                y[i] = time;

        }
        System.out.println(all/100000);


		//*****************************
		GraphingData data = new GraphingData("Plot of Running Times v.s. Problem Sizes",x,y);

	}
}



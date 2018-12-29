import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import ptolemy.plot.Plot;
import java.util.Scanner;
public class PtPlot{

   public static void main(String[] args) {
      JFrame jf = new JFrame();
      Plot leftPlot = new Plot();
      Scanner scnr = new Scanner(System.in);
      // Set the size of the toplevel window.
      jf.setSize(1600, 1600);
   
      leftPlot.setButtons(true);
      leftPlot.setTitle("Linear Equation #1");
      leftPlot.setYRange(-3, 3);
      leftPlot.setXRange(-3, 3);
      leftPlot.setXLabel("x");
      leftPlot.setYLabel("y");
      
      leftPlot.setMarksStyle("dots");
      //leftPlot.setImpulses(true);
   
      // Call setConnected before reading in data.
      leftPlot.setConnected(true);
      
      System.out.println("Enter time.");
      double time = scnr.nextDouble();
      
      //Enter ordered pairs here
      leftPlot.addPoint(0, 0, 0, true);
      leftPlot.addPoint(0, time, 0.125 * time, true);
   
      
      leftPlot.addPoint(1, 6, 0, true);
      leftPlot.addPoint(1, time, 0.5 * (time - 6), true);
      leftPlot.fillPlot();
      
      leftPlot.setSize(450, 450);
      GridBagLayout gridbag = new GridBagLayout();
      GridBagConstraints c = new GridBagConstraints();
      jf.getContentPane().setLayout(gridbag);
   
      // Handle the leftPlot
      c.gridx = 1;
      c.gridy = 1;
      c.gridwidth = 2;
      gridbag.setConstraints(leftPlot, c);
      jf.getContentPane().add(leftPlot);
      jf.setVisible(true);
   }
		
}


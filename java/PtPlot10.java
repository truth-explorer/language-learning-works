import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import ptolemy.plot.Plot;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PtPlot10 {

   public static void main(String[] args) throws IOException {
      JFrame jf = new JFrame();
      Plot dataplot = new Plot();
   
        // Set the size of the toplevel window.
      jf.setSize(1600, 1600);
   
      dataplot.setButtons(true);
      dataplot.setTitle("Training Data");
      dataplot.setYRange(-1, 130);
      dataplot.setXRange(-1, 15);
      dataplot.setXLabel("x");
      dataplot.setYLabel("y");
        
      dataplot.setMarksStyle("dots");
           
      // Call setConnected before reading in data.
      dataplot.setConnected(true);
       
      // create and initialize array of DataSet objects
      DataSet[] datas = new DataSet[4];
      for (int i = 0; i < datas.length; i++) {
         datas[i] = new DataSet(200);
      }
      
      double x, y;
      int category;
      
      // read input from train.txt (plain text file)
      // first value is x coord, second value is y coord, third is classification == dataset
      Scanner infile = new Scanner(new FileReader("train.txt"));
      while (infile.hasNext()) {
         x = infile.nextDouble();
         y = infile.nextDouble();
         category = infile.nextInt();
         datas[category].add(x, y);
      }
   
      // read and store data from newdata.txt, reading until end of input
      // save into the other two datasets   
      infile = new Scanner(new FileReader("newdata.txt"));
      while (infile.hasNext()) {
         x = infile.nextDouble();
         y = infile.nextDouble();
         category = infile.nextInt();
         datas[category+2].add(x, y);
      }
      
      for (int i = 0; i < datas.length; i++) {
         System.out.println("ID" + datas[i].getID() + "  size: " + datas[i].size());
         datas[i].plot(dataplot);
      }
   
   
      // finish display set-up     
      dataplot.setSize(450, 450);
      GridBagLayout gridbag = new GridBagLayout();
      GridBagConstraints c = new GridBagConstraints();
      jf.getContentPane().setLayout(gridbag);
   
      // Handle the dataplot
      c.gridx = 1;
      c.gridy = 1;
      c.gridwidth = 2;
      gridbag.setConstraints(dataplot, c);
      jf.getContentPane().add(dataplot);
      jf.setVisible(true);
   }
		
}


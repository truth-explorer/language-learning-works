import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;

import ptolemy.plot.Plot;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class PtPlot2 {

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
       
       
   // TODO A: read input from train.txt (plain text file)
   // first value is x coord, second value is y coord, third is classification == dataset
   // store into parallel arrays, one for x values, one for y values, one for classification
   // plot each point using the classification as the dataset, but do not connect points
       
      Scanner infile = new Scanner(new FileReader("train.txt"));
       
      double trainx[] = new double[200];
      double trainy[] = new double[200];
      int trainc[] = new int[200];
      int i = 0;
      while (infile.hasNext()) {
         trainx[i] = infile.nextDouble();
         trainy[i] = infile.nextDouble();
         trainc[i] = infile.nextInt();
         dataplot.addPoint(trainc[i], trainx[i], trainy[i], false);
         ++i;
      }    
      dataplot.addPoint(4, 0, 10, true);
      dataplot.addPoint(4, 15, 160, true); 
   // TODO A: determine your linear equation to separate the datasets and plot the line
   // reminder use: dataplot.addPoint(category, xcoord, ycoord, true/false)
   
   
   // end of PART A
       
   // TODO B: read and store data from test.txt, determine & store category
   // based on linear equation
       
      infile = new Scanner(new FileReader("test.txt"));
      double testx[] = new double[200];
      double testy[] = new double[200];
      int testc[] = new int[200];
      int j = 0;
      while (infile.hasNext()) {
         testx[j] = infile.nextDouble();
         testy[j] = infile.nextDouble();
         testc[j] = (10 * testx[j] > testy[j]) ? 2 : 3;
         dataplot.addPoint(testc[j], testx[j], testy[j], false);
         ++j;   
      }
       
       
   // end of PART B
   
   // TODO C: for each test point find nearest training point,
   // see if classifications match (0=2, 1=3), count mismatches & print percentage 
      int count = 0;
      int mini = 0; 
      for (int k = 0; k < testx.length; k++) {
         double dist1 = Math.sqrt((testx[k] - trainx[0]) * (testx[k] - trainx[0]) + 
                   (testy[k] - trainy[0]) * (testy[k] - trainy[0]));
         double dist2 = 0.0;
         for(int l = 0; l < trainx.length; l++) {
            dist2 = Math.sqrt((testx[k] - trainx[l]) * (testx[k] - trainx[l]) + 
                   (testy[k] - trainy[l]) * (testy[k] - trainy[l]));
            if (dist2 < dist1) {
               dist1 = dist2;
               mini = l;
            }
         }
         if ((trainc[mini] == 0 && testc[k] == 2) || (trainc[mini] == 1 && testc[k] == 3)) {
            ++count;
         }
      }
      System.out.print(count / testc.length * 100 + "% of the points agree");    
       
       
       
   // end of PART C   
       
           
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


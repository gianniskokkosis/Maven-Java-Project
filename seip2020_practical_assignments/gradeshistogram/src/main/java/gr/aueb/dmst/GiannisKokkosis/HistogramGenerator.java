package gr.aueb.dmst.GiannisKokkosis;

import java.io.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class HistogramGenerator{

	public int [] createArray(File file){

		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedReader br = new BufferedReader(new FileReader(file));

		int lines = 0;

		while (reader.readLine() != null) lines++;

        int [] arrayOfGrades = new int[lines];
        String st; 
        int grade;
        int j = 0;
        while ((st = br.readLine()) != null){
          grade = Integer.parseInt(st);
          arrayOfGrades[j] = grade;
          j++;
        }

		return arrayOfGrades;

	}

    public void generateChart(int [] gradesValues) {

    	/*
    	 *javadoc goes here
    	 *
    	 */
    	XYSeriesCollection dataset = new XYSeriesCollection();

    	XYSeries data = new XYSeries("file");


    	for(int i = 0; i < gradesValues.length; i++){
    		data.add(i, gradesValues[i]);
    	}

    	dataset.addSeries(data);


    	boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls

		JFreeChart chart = ChartFactory.createXYLineChart("Chart title", "x_axis title", "y_axis_title", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);

		ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();

		frame.setVisible(true);
    }

    public static void main(String args[]){

    	HistogramGenerator hist = new HistogramGenerator();
    	File file = new File(args[0]);

    	int [] grades = hist.createArray(file);

    	hist.generateChart(grades);
    }
}
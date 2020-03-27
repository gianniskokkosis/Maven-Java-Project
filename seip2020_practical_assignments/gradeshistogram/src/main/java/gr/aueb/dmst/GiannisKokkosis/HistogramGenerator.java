package gradeshistogram;

import java.io.*;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/***
 * 
 * @author gianniskokkosis The purpose of this class is to demonstrate a simple
 *         scenario of a JFreeChart XYLine chart.
 */
public class HistogramGenerator{

    /***
     * Receives a single dimensional array, created by 
     * createArray mehtod. It returns an ArraList of 
     * Integers that contains the all the values of 
     * the array without its duplicates.
     * 
     * @param array1 Single dimension integer array
     */
    public ArrayList<Integer> dropDup(int[] array1){

        // Initialize an Arralist of Integers
        ArrayList<Integer> array = new ArrayList<Integer>();
        
        // Loop through the values of the array
        for(int i = 0; i < array1.length; i++){

            /*
             * If the current value of the array isn' t in the 
             * values of the Arralist the add it in the ArrayList.
             * Otherwise procced.
             */
            if (!array.contains(array1[i])){
                array.add(array1[i]);
            }
        }

        return array; // Return the ArrayList
    }

    /***
     * Receives a single dimensional array, created by
     * the createArray method. It returns an ArrayList
     * that contains the frequency of the values of the array.
     * 
     * @param array2 Single dimensional array
     */
    public ArrayList<Integer> countFreq(int[] array2) { 

        // Initialize two ArrayLists. One Boolean and one Integer
        ArrayList<Boolean> visited = new ArrayList<Boolean>(); 
        ArrayList<Integer> list = new ArrayList<Integer>();

        // Loop thtough the array and fill all the Boolean ArrayList with false
        for(int k = 0; k < array2.length; k++){
            visited.add(false);
        }
     

        /*
         * Traverse through array elements and 
         * count frequencies
         */  
        for (int i = 0; i < array2.length; i++) { 

            // Skip this element if already processed 
            if (visited.get(i) == true) 
                continue; 

            // Count frequency 
            int count = 1; 
            for (int j = i + 1; j < array2.length; j++) { 
                if (array2[i] == array2[j]){ 
                    visited.add(j, true); 
                    count++; 
                } 
            }
            list.add(count); // Add the frequency of the element in the Integer ArrayList 
        }

        return list; // Return the ArrayList 
    }


    /***
     * Receives a File object and creates a single dimensional
     * array with the contens of the file as values of the array.
     * Then it returns this array.
     *
     * @param file a File object
     */
	public int [] createArray(File file) throws Exception{

        // Read the file and store it to two BufferReader variables
		BufferedReader reader = new BufferedReader(new FileReader(file));
		BufferedReader br = new BufferedReader(new FileReader(file));

        // Assign an int variable to zero. This variable will be used as a size for the array
		int lines = 0;

        // Loop through the contents of the file and count how many lines the file has
		while (reader.readLine() != null) lines++;

        // Create an integer array with size equal to the lines of the file
        int [] arrayOfGrades = new int[lines];

        // Declare necessary variables in order to fill the array
        String st; // The grade as String
        int grade; // Integer variable to cast variable st
        int j = 0; // A counter

        // Loop through the lines of the file in order to fill the array
        while ((st = br.readLine()) != null){
          grade = Integer.parseInt(st); // Casting variable st(String) to Integer
          arrayOfGrades[j] = grade; // Assign the grade to the jth position of the array
          j++; // Increase the counter 
        }

		return arrayOfGrades; // return the created array

	}

    /***
     * Receives a single dimension Integer array. From this array the dataset
     * that will be used for the visualization is generated. Finally, The chart
     * is generated with the use of the aforementioned dataset and then
     * presented in the screen.
     * 
     * @param gradesValues Single dimension integer array
     */
    public void generateChart(ArrayList<Integer> uniqe_values, ArrayList<Integer> freq_values) throws Exception {

        /*
         * The XYSeriesCollection object is a set XYSeries series (dataset) that
         * can be visualized in the same chart
         */
    	XYSeriesCollection dataset = new XYSeriesCollection();

        /*
         * The XYSeries that are loaded in the dataset. There might be many
         * series in one dataset.
         */
    	XYSeries data = new XYSeries("file");

        /*
         * Populating the XYSeries data object from the input Integer ArrayLists
         * values.
         */
    	for(int i = 0; i < uniqe_values.size(); i++){
    		data.add(uniqe_values.get(i), freq_values.get(i));
    	}

        // add the series to the dataset
    	dataset.addSeries(data);

    	boolean legend = false; // do not visualize a legend
		boolean tooltips = false; // do not visualize tooltips
		boolean urls = false; // do not visualize urls
        
        // Declare and initialize a createXYLineChart JFreeChart
		JFreeChart chart = ChartFactory.createXYLineChart("Chart title", "x_axis title", "y_axis_title", dataset,
				PlotOrientation.VERTICAL, legend, tooltips, urls);
      

        /*
         * Initialize a frame for visualizing the chart and attach the
         * previously created chart.
         */
        ChartFrame frame = new ChartFrame("First", chart);
		frame.pack();

        // makes the previously created frame visible
		frame.setVisible(true);
    }

    public static void main(String args[]) throws Exception{

        // Initialize a HistogramGenerator Object
    	HistogramGenerator hist = new HistogramGenerator();

        // Initialize a File object, args[0] is the file path
    	File file = new File(args[0]);

        // Initialize an Integer array with the createArray method of the class
    	int [] grades = hist.createArray(file);

        /*
         * Initialize two Integer ArrayLists
         * x_values contains the unique values of the array
         * y_values contains the frequencies of the values of the array
         */
        ArrayList<Integer> x_values = hist.dropDup(grades);
        ArrayList<Integer> y_values = hist.countFreq(grades);

        // Call generateChart method of the class in order to plot the cart
    	hist.generateChart(x_values, y_values);
    }
}
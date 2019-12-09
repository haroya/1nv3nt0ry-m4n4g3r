package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.statistics.HistogramDataset;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class JChart extends JFrame {

	private JPanel contentPane;
	private SimpleDateFormat sdf = new SimpleDateFormat("MMM-dd-yyyy");
	private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * Create the frame.
	 */
	public JChart(int prodID, Calendar start, Calendar end) {
		
		String startStr = df.format(start.getTime());
		String endStr = df.format(end.getTime());
		
		long diff =  ChronoUnit.MONTHS.between(
				LocalDate.parse(startStr).withDayOfMonth(1),
				LocalDate.parse(endStr).withDayOfMonth(1));
//				TimeUnit.MILLISECONDS.toDays(end.getTimeInMillis() - start.getTimeInMillis());
		int buckets = (int) Math.toIntExact(diff) + 1;
		System.out.println("Buckets: " + buckets + "\ndiff: " + diff);
		Calendar temp = new GregorianCalendar(start.get(Calendar.YEAR), start.get(Calendar.MONTH), start.get(Calendar.DATE));
		
		double[] yvals = new double[buckets];
		DefaultCategoryDataset data = new DefaultCategoryDataset();
		int originalVal =  (int) Math.random() * 250 + 200;
		int maxShipment = (int) Math.round(originalVal * 0.50);
		int maxSales = (int) Math.round(originalVal * 0.35);
		
		yvals[0] = originalVal;
		String xval = sdf.format(temp.getTime()).substring(0, 3);
		data.addValue(Math.round(yvals[0]), "Units of Product " + prodID, xval);
		
		for (int i = 1; i < buckets; i++) {
			yvals[i] = yvals[i-1] + Math.random()*maxShipment - Math.random()*maxSales;
			temp.add(Calendar.MONTH, 1);
			xval = sdf.format(temp.getTime()).substring(0, 3);
			data.addValue(Math.round(yvals[i]), "Units of Product " + prodID , xval);
		}
		
        JFreeChart barChart = ChartFactory.createBarChart("Inventory for Product " + prodID + " from " + sdf.format(start.getTime()) + " to " + sdf.format(end.getTime()),
        		"Month", "Units in Stock", data);

        ChartPanel cp = new ChartPanel(barChart);
        cp.setMouseWheelEnabled(true);
        add(cp);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
		
	}

}

package com.coder.exal;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xddf.usermodel.chart.AxisCrosses;
import org.apache.poi.xddf.usermodel.chart.AxisPosition;
import org.apache.poi.xddf.usermodel.chart.BarDirection;
import org.apache.poi.xddf.usermodel.chart.BarGrouping;
import org.apache.poi.xddf.usermodel.chart.ChartTypes;
import org.apache.poi.xddf.usermodel.chart.LegendPosition;
import org.apache.poi.xddf.usermodel.chart.XDDFBarChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFCategoryAxis;
import org.apache.poi.xddf.usermodel.chart.XDDFChartData;
import org.apache.poi.xddf.usermodel.chart.XDDFChartLegend;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFDataSourcesFactory;
import org.apache.poi.xddf.usermodel.chart.XDDFNumericalDataSource;
import org.apache.poi.xddf.usermodel.chart.XDDFValueAxis;
import org.apache.poi.xssf.usermodel.XSSFChart;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.coder.form.ExalForm;
import com.coder.form.ShortestJobFirstForm;
import com.coder.form.ShowAppointmentForm;
import com.coder.util.PrjSubFunction;

public class ExalToBarByCompareAppSchedule{

	public static void stackedBarChart(List<ShowAppointmentForm> showAppointmentForms) throws FileNotFoundException, IOException {
		try (XSSFWorkbook wb = new XSSFWorkbook()) {
			String sheetName = "CompersionOfAppointmentByDoctoeSchedule";// "CountryStackedColumnChart";
			XSSFSheet sheet = wb.createSheet(sheetName);
			Row row = sheet.createRow((short) 0);
			Cell cell=null;
       
         for(int i=0;i<showAppointmentForms.size();i++){
			 cell = row.createCell((short)i);
			 cell.setCellValue("scheduleId-"+showAppointmentForms.get(i).getDoctorScheduleId()+"");
			 
         }
         System.out.println("///////////////////");
			row = sheet.createRow((short) 1);
		 for(int i=0;i<showAppointmentForms.size();i++){
			cell = row.createCell((short)i);
			cell.setCellValue(showAppointmentForms.get(i).getNoTurnAvg());
			
		 }
		 System.out.println("///////////////////");
			// Country Population
			row = sheet.createRow((short) 2);
            for(int i=0;i<showAppointmentForms.size();i++){
			cell = row.createCell((short) i);
			cell.setCellValue(showAppointmentForms.get(i).getWatingAvg());
		
            }
			

			XSSFDrawing drawing = sheet.createDrawingPatriarch();
			XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 4, 7, 26);

			XSSFChart chart = drawing.createChart(anchor);
			chart.setTitleText("Comparison of CompletionTime Sjf & NoSjf");
			chart.setTitleOverlay(false);

			XDDFChartLegend legend = chart.getOrAddLegend();
			legend.setPosition(LegendPosition.TOP_RIGHT);

			XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
			bottomAxis.setTitle("ScheduleId");
			XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
			leftAxis.setTitle("Compare Appointment Average By Schedule Sjf & NoSjf");

			XDDFDataSource<String> countries = XDDFDataSourcesFactory.fromStringCellRange(sheet,
					new CellRangeAddress(0, 0, 0,showAppointmentForms.size()-1));

			XDDFNumericalDataSource<Double> area = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
					new CellRangeAddress(1, 1, 0,showAppointmentForms.size()- 1));

			XDDFNumericalDataSource<Double> population = XDDFDataSourcesFactory.fromNumericCellRange(sheet,
					new CellRangeAddress(2, 2, 0,showAppointmentForms.size()-1));

			XDDFChartData data = chart.createData(ChartTypes.BAR, bottomAxis, leftAxis);
			XDDFChartData.Series series1 = data.addSeries(countries, area);
			series1.setTitle("No Sjf", null);
			XDDFChartData.Series series2 = data.addSeries(countries, population);
			series2.setTitle("Sjf", null);
			data.setVaryColors(true);
			chart.plot(data);

			// correcting the overlap so bars really are stacked and not side by side
			chart.getCTChart().getPlotArea().getBarChartArray(0).addNewOverlap().setVal((byte) 100);

			// in order to transform a bar chart into a column chart, you just need to
			// change the bar direction
			XDDFBarChartData bar = (XDDFBarChartData) data;
			bar.setBarGrouping(BarGrouping.STACKED);
			//bar.setBarDirection(BarDirection.BAR);
			 bar.setBarDirection(BarDirection.COL);

			// Write output to an excel file
			String filename = "D:\\dgl\\CompersionOfAppointmentByDoctoeSchedule.xlsx";// "column-chart-top-seven-countries.xlsx";
			try (FileOutputStream fileOut = new FileOutputStream(filename)) {
				wb.write(fileOut);
			}
		}
	}

	
	}


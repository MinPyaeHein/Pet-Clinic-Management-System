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

public class ExalToBarByOwnerSJF{

	

	public static void barColumnChart( ShowAppointmentForm showAppointmentForm,XSSFWorkbook wb) throws FileNotFoundException, IOException {
			String sheetName = "Show Owner By SJF";
			
			XSSFSheet sheet1= wb.createSheet(sheetName);
			Row row = sheet1.createRow((short) 0);
			List<ShortestJobFirstForm> firstForms=showAppointmentForm.getShortestJobFirstForms();
			firstForms=PrjSubFunction.sortByIdSJF(firstForms);
			Cell cell=null;
            for(int i=0;i<firstForms.size();i++){
			 cell = row.createCell((short) i);
			 ShortestJobFirstForm firstForm=firstForms.get(i);
			cell.setCellValue("OwnerId-"+firstForm.getOwnerId());
            }
			row = sheet1.createRow((short) 1);
            for(int i=0;i<firstForms.size();i++){
			cell = row.createCell((short) i);
			 ShortestJobFirstForm firstForm=firstForms.get(i);
			cell.setCellValue(Integer.parseInt(firstForm.getWaitingTime()));
            }
			XSSFDrawing drawing = sheet1.createDrawingPatriarch();
			XSSFClientAnchor anchor = drawing.createAnchor(0, 0, 0, 0, 0, 4, 7, 20);

			XSSFChart chart = drawing.createChart(anchor);
			chart.setTitleText(" Use Shortest Job First Algorithms");
			chart.setTitleOverlay(false);

			XDDFChartLegend legend = chart.getOrAddLegend();
			legend.setPosition(LegendPosition.TOP_RIGHT);
			
			XDDFCategoryAxis bottomAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
            bottomAxis.setTitle("Owner Id   "+"WtTotal="+showAppointmentForm.getWatingAvg());
            XDDFValueAxis leftAxis = chart.createValueAxis(AxisPosition.LEFT);
            leftAxis.setTitle("Waiting Time");
            leftAxis.setCrosses(AxisCrosses.AUTO_ZERO);

			XDDFDataSource<String> countries = XDDFDataSourcesFactory.fromStringCellRange(sheet1,
					new CellRangeAddress(0, 0, 0, firstForms.size()-1));

			XDDFNumericalDataSource<Double> values = XDDFDataSourcesFactory.fromNumericCellRange(sheet1,
					new CellRangeAddress(1, 1, 0, firstForms.size()-1));
			
			XDDFChartData data = chart.createData(ChartTypes.BAR, bottomAxis, leftAxis);
            XDDFChartData.Series series1 = data.addSeries(countries, values);
            series1.setTitle("Owner Id", null);
			data.setVaryColors(true);
			chart.plot(data);
			
			// in order to transform a bar chart into a column chart, you just need to change the bar direction
            XDDFBarChartData bar = (XDDFBarChartData) data;
            bar.setBarDirection(BarDirection.BAR);
            bar.setBarDirection(BarDirection.COL);

			// Write output to an excel file
            String filename = "D:\\dgl\\ExalToBarByOwner.xlsx";//"column-chart-top-seven-countries.xlsx";
			try (FileOutputStream fileOut = new FileOutputStream(filename)) {
				wb.write(fileOut);
			}
		}
	}


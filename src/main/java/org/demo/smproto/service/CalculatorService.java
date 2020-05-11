package org.demo.smproto.service;

import java.util.List;

import org.demo.smproto.model.DataPoint;
import org.demo.smproto.model.SummaryAverage;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
	
	public int sumAllPoints(List<DataPoint> dataList) {
		
		int sumData = 0;

		for (DataPoint dp : dataList) {
			float rowTotal = dp.getPointA() + dp.getPointB() + dp.getPointC();
			sumData += rowTotal;
		}
		
		return sumData;
	}
	
	public int sumPointA(List<DataPoint> dataList) {
		
		int sumData = 0;

		for (DataPoint dp : dataList) {
			float rowTotal = dp.getPointA();
			sumData += rowTotal;
		}
		
		return sumData;
	}
	
	public float averagePointA(List<DataPoint> dataList) {
		
		int countLabels = dataList.size();
		
		float sumData = 0;
		
		for (DataPoint dp : dataList) {
			float count = dp.getPointA();
			sumData += count;
		}
		
		return sumData/countLabels;
	}

	public SummaryAverage applicationsOnboardedAverage(List<DataPoint> dataList) {
		
		int countLabels = dataList.size();
		int sumData = 0;
		
		for (DataPoint dp : dataList) {
			float count = dp.getPointA();
			sumData += count;
		}
		
		// latest time_period_start
		int numberOfApplications = (int) dataList.get(dataList.size() - 1).getPointA();
		
		int dataAverage = sumData/countLabels;
			
		return new SummaryAverage(numberOfApplications, dataAverage);
		
	}
	
	public SummaryAverage sumAndAveragePointA(List<DataPoint> dataList) {
		
		int countLabels = dataList.size();
		int sumData = 0;
		
		for (DataPoint dp : dataList) {
			int count = (int) dp.getPointA();
			sumData += count;
		}
		
		return new SummaryAverage(sumData, sumData/countLabels);
	}
	
	public String AddWhereClause(String sql, String time_period_start, String group_by ) {
		return sql + " where time_period_start = '" + time_period_start + "' group by " + group_by;
	}

}
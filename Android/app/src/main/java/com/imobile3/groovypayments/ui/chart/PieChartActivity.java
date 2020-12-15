package com.imobile3.groovypayments.ui.chart;

import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.imobile3.groovypayments.R;
import com.imobile3.groovypayments.data.Result;
import com.imobile3.groovypayments.data.TestDataRepository;
import com.imobile3.groovypayments.data.entities.CartEntity;
import com.imobile3.groovypayments.data.entities.CartProductEntity;
import com.imobile3.groovypayments.data.model.Product;
import com.imobile3.groovypayments.ui.BaseActivity;
import com.imobile3.groovypayments.ui.dialog.ProgressDialog;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import org.w3c.dom.Entity;

import java.util.ArrayList;
import java.util.List;

public class PieChartActivity extends BaseActivity {

    private ProgressDialog mProgressDialog;
    private PieChartViewModel mViewModel;
    private TestDataRepository mTestDataRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart_common);
        setUpMainNavBar();
        mProgressDialog = new ProgressDialog(this);
      //  mViewModel.getProductList().observe(this, PieChartActivity.this::setPieChart);
        setPieChart();
    }

    // TODO: Update list parameterized type to chart library data wrapper
    private void setPieChart() {
        PieChart pieChart = findViewById(R.id.groovy_pie_chart);
        ArrayList NoOfEmp = new ArrayList();

        NoOfEmp.add(new Entry(945f, 0));
        NoOfEmp.add(new Entry(1040f, 1));
        NoOfEmp.add(new Entry(1133f, 2));
        NoOfEmp.add(new Entry(1240f, 3));
        NoOfEmp.add(new Entry(1369f, 4));
        NoOfEmp.add(new Entry(1487f, 5));
        NoOfEmp.add(new Entry(1501f, 6));
        NoOfEmp.add(new Entry(1645f, 7));
        NoOfEmp.add(new Entry(1578f, 8));
        NoOfEmp.add(new Entry(1695f, 9));


        PieDataSet dataSet = new PieDataSet(NoOfEmp, "Number Of Employees");

        ArrayList year = new ArrayList();

        year.add("2008");
        year.add("2009");
        year.add("2010");
        year.add("2011");
        year.add("2012");
        year.add("2013");
        year.add("2014");
        year.add("2015");
        year.add("2016");
        year.add("2017");

        PieData piedata = new PieData(year, dataSet);
        pieChart.setData(piedata);
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.animateXY(2000, 3000);    }

    @Override
    protected void initViewModel() {
        mViewModel = ViewModelProviders.of(this, new PieChartViewModelFactory())
                .get(PieChartViewModel.class);
    }

    public  void setData( List<CartEntity> data ){

        ArrayList<CartEntity> arrlistofOptions = new ArrayList<CartEntity>(data);

    }

    private void loadProducts() {
        mViewModel.getProductList().observe(this,data -> setData(data));

    }

    @Override
    protected void setUpMainNavBar() {
        super.setUpMainNavBar();
        mMainNavBar.showBackButton();
        mMainNavBar.showLogo();
        mMainNavBar.showSubtitle(getString(R.string.daily_report_subtitle));
    }
}

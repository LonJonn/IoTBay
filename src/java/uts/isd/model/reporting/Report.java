package uts.isd.model.reporting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

import uts.isd.model.dao.ReportingDAO;

public class Report implements Serializable {
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private final ArrayList<OrderLineItem> saleRecords = new ArrayList<>();
    private final ArrayList<ProductSummary> productSummaries = new ArrayList<>();
    private final ArrayList<String> categories = new ArrayList<>();
    private final SalesAnalyser salesAnalyser = new SalesAnalyser();
    private ProductSummary topProduct;


    /*
    private double totalRevenue;
    private String topCategory;
    private double topCategoryRevenue;
    private ProductSummary topItem;
    */
    

    public Report (String reportName, String reportDescription, String startDate, String endDate, 
        ArrayList<OrderLineItem> saleRecords, ArrayList<ProductSummary> summaries, ArrayList<String> categories) {
        this.name = reportName;
        this.description = reportDescription;
        this.startDate = startDate;
        this.endDate = endDate;
        
        if (saleRecords.size() > 0 && saleRecords != null) {
            this.saleRecords.addAll(saleRecords);
            this.productSummaries.addAll(summaries);
            this.categories.addAll(categories);
            this.topProduct = salesAnalyser.getTopProduct(summaries);
        }

        

        
        /*
        this.totalRevenue = salesAnalyser.getTotalSalesValue(saleRecords);
        this.topCategory = salesAnalyser.getTopCategory(saleRecords);
        this.topCategoryRevenue = salesAnalyser.getTopCategoryRevenue(topCategory, saleRecords);
        this.topItem = salesAnalyser.getTopProduct(summaries);
        */
    }

    public String getName() {
        return name;
    }

    public void setReportName(String reportName) {
        this.name = reportName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String reportDescription) {
        this.description = reportDescription;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setReportStartDate(String reportStartDate) {
        this.startDate = reportStartDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setReportEndDate(String reportEndDate) {
        this.endDate = reportEndDate;
    }

    public final Double getTotalRevenue() {
        return salesAnalyser.getTotalSalesValue(saleRecords);
    }

    public final String getTopCategory() {
        return salesAnalyser.getTopCategory(saleRecords);
    }

    public final Double getTopCategoryRevenue() {
        return salesAnalyser.getTopCategoryRevenue(getTopCategory(), saleRecords);
    }

    public final ProductSummary getTopSellingItem() {
        return topProduct;
        //return salesAnalyser.getTopProduct(productSummaries);
    }

    public final Hashtable<String, Double> getSalesByState() {
        return salesAnalyser.getSalesBySate(saleRecords);
    }

    public final Hashtable<String, Double> getSalesByCategory() {
        return salesAnalyser.getSalesByCategory(saleRecords);
    }

    public HashMap<String, ArrayList<ProductSummary>> getSalesBreakdown() {
        return salesAnalyser.getSalesByCategoryByProduct(productSummaries, categories);
    }

}
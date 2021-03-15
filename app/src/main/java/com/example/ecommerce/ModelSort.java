package com.example.ecommerce;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ModelSort {
    private String category;
    private String title;
    private String brand;
    private String productName;
    private double price;
    private String detail;
    private Date addDate;

    public ModelSort() {
    }

    public ModelSort(String category, String title, String brand, String productName, double price, String detail, Date addDate) {
        this.category = category;
        this.title = title;
        this.brand = brand;
        this.productName = productName;
        this.price = price;
        this.detail = detail;
        this.addDate = addDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public void sortByPriceDescending(){

    }
    public ModelSort modelPostToModelSort(ModelPost modelPost) throws ParseException {
        ModelSort modelSort = new ModelSort();
        modelSort.setCategory(modelPost.getCategory());
        modelSort.setPrice(stringToDouble(modelPost.getPrice()));
        modelSort.setAddDate(stringToDate(modelPost.getAddDate()));
        modelSort.setBrand(modelPost.getBrand());
        modelPost.setDetail(modelPost.getDetail());
        modelPost.setProductName(modelPost.getProductName());
        modelPost.setTitle(modelPost.getTitle());
        return modelSort;
    }

    public double stringToDouble(String string){
        String afterFirstSplit = "";
        String afterSecondSplit = "";
        Double d;
        for(int i = 0; i < string.length(); i++){
            String [] firstSplit = string.split("T");
            afterFirstSplit = firstSplit[0];
            String [] afterSeondSplitArray = afterFirstSplit.split("\\.");
            afterSecondSplit = afterSeondSplitArray[0] + afterSeondSplitArray[1];

        }
        d = Double.parseDouble(afterSecondSplit);
        return d;
    }
    public Date stringToDate(String string) throws ParseException {
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(string);
        System.out.println(string+"\t"+date1);
        return date1;
    }

}

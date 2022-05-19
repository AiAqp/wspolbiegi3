package com.wspolbiegi;

public class WspolbiegiApp {

    public static void main(String[] args) {

        CsvFile hw_csv = new CsvFile();
        hw_csv.loadNewList("hw_500000.csv",1,500000);
        hw_csv.printFile();


        CsvFileParallel hw_csv_p = new CsvFileParallel();
        hw_csv_p.loadNewList("hw_500000.csv",1,500000);
        hw_csv_p.printFile();



    }
}

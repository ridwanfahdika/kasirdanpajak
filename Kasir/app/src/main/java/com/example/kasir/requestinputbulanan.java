package com.example.kasir;

public class requestinputbulanan {
    private String bulan;
    private String tahun;
    private String pengbulanan;

    public requestinputbulanan(String bulan, String tahun, String pengbulanan){
        this.bulan = bulan;
        this.tahun = tahun;
        this.pengbulanan = pengbulanan;
    }

    public String getbulan() {return bulan;}
    public void setbulan(String bulan) {this.bulan = bulan;}

    public String gettahun() {return tahun;}
    public void settahun(String tahun) {this.tahun = tahun;}

    public String getpengbulanan() {return pengbulanan;}
    public void setpengbulanan(String pengbulanan) {this.pengbulanan = pengbulanan;}
}

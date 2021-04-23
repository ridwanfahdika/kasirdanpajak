package com.example.kasir;

public class requestinputharian {
    private String hari;
    private String tanggal;
    private String pengharian;

    public requestinputharian(String hari, String tanggal, String pengharian){
        this.hari = hari;
        this.tanggal = tanggal;
        this.pengharian = pengharian;
    }

    public String gethari() {return hari;}
    public void sethari(String hari) {this.hari = hari;}

    public String gettanggal() {return tanggal;}
    public void settanggal(String tanggal) {this.tanggal = tanggal;}

    public String getpengharian() {return pengharian;}
    public void setpengharian(String pengharian) {this.pengharian = pengharian;}
}

package com.example.kasir;

public class requestinputtransaksi {
    private String trnamabarang;
    private String trhargabarang;
    private String trtotalharga;

    public requestinputtransaksi(String trnamabarang, String trhargabarang, String trtotalharga){
        this.trnamabarang = trnamabarang;
        this.trhargabarang = trhargabarang;
        this.trtotalharga = trtotalharga;
    }

    public String gettrnamabarang() {return trnamabarang;}
    public void settrnamabarang(String trnamabarang) {this.trnamabarang = trnamabarang;}

    public String gettrhargabarang() {return trhargabarang;}
    public void settrhargabarang(String trhargabarang) {this.trhargabarang = trhargabarang;}

    public String gettrtotalharga() {return trtotalharga;}
    public void settrtotalharga(String trtotalharga) {this.trtotalharga = trtotalharga;}
}

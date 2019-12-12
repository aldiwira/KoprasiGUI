/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Aldi Wirawan
 */
public class Anggota{
    private String nama;
    private String alamat;
    private String no;
    private int totalSimpanan;
    private int uangSimpanan;
    private int uangPinjaman;
    private int bulan;

    public int getTotalSimpanan() {
        return totalSimpanan;
    }

    public void setTotalSimpanan(int totalSimpanan) {
        this.totalSimpanan = totalSimpanan;
    }

    public int getUangSimpanan() {
        return uangSimpanan;
    }

    public void setUangSimpanan(int uangSimpanan) {
        this.uangSimpanan = uangSimpanan;
    }

    
    public int getUangTabungan() {
        return uangSimpanan;
    }

    public void setUangTabungan(int uangTabungan) {
        this.uangSimpanan = uangTabungan;
    }

    public int getUangPinjaman() {
        return uangPinjaman;
    }

    public void setUangPinjaman(int uangPinjaman) {
        this.uangPinjaman = uangPinjaman;
    }

    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }
    public int getBulan() {
        return bulan;
    }

    public void setBulan(int bulan) {
        this.bulan = bulan;
    }
    
    public void showTa(){
        System.out.println("Nama :" +this.nama);
        System.out.println("Alamat :" +this.alamat);
        System.out.println("No :" +this.no);
        System.out.println("Tabungan : "+this.totalSimpanan);
    }
}

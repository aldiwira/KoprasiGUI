/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;
import controller.*;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Aldi Wirawan
 */
public class pinjamanDb {
    private int id_pinjaman;
    private int id_nasabah;
    private int jumlah_pinjaman;
    private int bulan_pinjaman;
    private int total_angsuran;
    private int progress_angsuran;

    public int getId_pinjaman() {
        return id_pinjaman;
    }

    public void setId_pinjaman(int id_pinjaman) {
        this.id_pinjaman = id_pinjaman;
    }

    public int getId_nasabah() {
        return id_nasabah;
    }

    public void setId_nasabah(int id_nasabah) {
        this.id_nasabah = id_nasabah;
    }

    public int getJumlah_pinjaman() {
        return jumlah_pinjaman;
    }

    public void setJumlah_pinjaman(int jumlah_pinjaman) {
        this.jumlah_pinjaman = jumlah_pinjaman;
    }

    public int getBulan_pinjaman() {
        return bulan_pinjaman;
    }

    public void setBulan_pinjaman(int bulan_pinjaman) {
        this.bulan_pinjaman = bulan_pinjaman;
    }

    public int getTotal_angsuran() {
        return total_angsuran;
    }

    public void setTotal_angsuran(int total_angsuran) {
        this.total_angsuran = total_angsuran;
    }

    public int getProgress_angsuran() {
        return progress_angsuran;
    }

    public void setProgress_angsuran(int progress_angsuran) {
        this.progress_angsuran = progress_angsuran;
    }
    
    
    
    public void insertDataPinjaman(Anggota ag, int id){
        String queryInsert = "INSERT INTO `pinjaman` "
                + "(`id_pinjaman`, `id_nasabah`, `jumlah_pinjaman`, `bulan_pinjaman`, `total_angsuran`, `progess_angsuran`) "
                + "VALUES ('"+id+"', '"+ag.getId()+"', '"+ag.getUangPinjaman()+"', '"+ag.getBulan()+"', "
                + "'"+ag.getUangAngsuran()+"', '0')";
        AnggotaService.insertQueryGetId(queryInsert);
        System.out.println("Inserted");
    }
    public ArrayList<pinjamanDb> getAll(){
        pinjamanDb pDb = new pinjamanDb();
        ArrayList<pinjamanDb> listPinjaman = new ArrayList();
        String query = "SELECT * FROM `pinjaman`";
        ResultSet rs = AnggotaService.selectQuery(query);
        try {
            while (rs.next()) {                
                pDb.setId_pinjaman(rs.getInt("id_pinjaman"));
                pDb.setId_nasabah(rs.getInt("id_nasabah"));
                pDb.setJumlah_pinjaman(rs.getInt("jumlah_pinjaman"));
                pDb.setBulan_pinjaman(rs.getInt("bulan_pinjaman"));
                pDb.setTotal_angsuran(rs.getInt("total_angsuran"));
                pDb.setProgress_angsuran(rs.getInt("progess_angsuran"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPinjaman;
    }
}

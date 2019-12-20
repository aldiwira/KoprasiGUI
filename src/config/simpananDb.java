/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import controller.Anggota;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Aldi Wirawan
 */
public class simpananDb {
    private int id_simpan;
    private int id_nasabah;
    private int uang_simpan;
    private int jumlah_simpan;

    public int getId_simpan() {
        return id_simpan;
    }

    public void setId_simpan(int id_simpan) {
        this.id_simpan = id_simpan;
    }

    public int getId_nasabah() {
        return id_nasabah;
    }

    public void setId_nasabah(int id_nasabah) {
        this.id_nasabah = id_nasabah;
    }

    public int getUang_simpan() {
        return uang_simpan;
    }

    public void setUang_simpan(int uang_simpan) {
        this.uang_simpan = uang_simpan;
    }

    public int getJumlah_simpan() {
        return jumlah_simpan;
    }

    public void setJumlah_simpan(int jumlah_simpan) {
        this.jumlah_simpan = jumlah_simpan;
    }
    
    public void insertDataPinjaman(Anggota ag, int id){
        String queryInsert = "INSERT INTO `simpanan` "
                + "(`id_simpanan`, `id_simpanan`, `jumlah_simpanan`, `uang_simpanan`"
                + "VALUES ('"+id+"', '"+ag.getId()+"', '"+ag.getTotalSimpanan()+"', '"+ag.getUangSimpanan()+"', "
                +"', '0')";
        AnggotaService.insertQueryGetId(queryInsert);
        System.out.println("Inserted");
    }
    public ArrayList<simpananDb> getAll(){
        simpananDb sDb = new simpananDb();
        ArrayList<simpananDb> listPinjaman = new ArrayList();
        String query = "SELECT * FROM `simpanan`";
        ResultSet rs = AnggotaService.selectQuery(query);
        try {
            while (rs.next()) {                
                sDb.setId_simpan(rs.getInt("id_pinjaman"));
                sDb.setId_nasabah(rs.getInt("id_nasabah"));
                sDb.setJumlah_simpan(rs.getInt("simpanan"));
                sDb.setUang_simpan(rs.getInt("total_simpanan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPinjaman;
    }
    
    public void insertDataSimpanan(Anggota ag, int id){
        String queryInsert = "INSERT INTO `simpanan` (`id_simpanan`, `id_nasabah`, `simpanan`, `total_simpanan`) "
                + "VALUES ('"+id+"', '"+ag.getId()+"', '"+ag.getUangSimpanan()+"', '"+ag.getTotalSimpanan()+"')";
        AnggotaService.insertQueryGetId(queryInsert);
        System.out.println("Inserted");
    }
     public Anggota getBy(String where, String value){
        Anggota ag = new Anggota();
//        select sum(simpanan) from simpanan WHERE id_nasabah = 12
        String query = "SELECT sum(simpanan) as sumsum FROM `simpanan` WHERE `"+where+"` = '"+value+"'";
        ResultSet rs = AnggotaService.selectQuery(query);
        try {
            while (rs.next()) {                
                ag = new Anggota();
                ag.setTotalSimpanan(rs.getInt("sumsum"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ag;
    }
}


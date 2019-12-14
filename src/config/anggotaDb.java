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
public class anggotaDb {
    public ArrayList<Anggota> getAll(){
        ArrayList<Anggota> listAnggota = new ArrayList();
        String query = "SELECT * FROM `nasabah`";
        ResultSet rs = AnggotaService.selectQuery(query);
        try {
            while (rs.next()) {                
                Anggota ag = new Anggota();
                ag.setNama(rs.getString("nama"));
                ag.setAlamat(rs.getString("alamat"));
                ag.setNo(rs.getString("no_telp"));
                ag.setType(rs.getString("jenis_anggota"));
                ag.setId(rs.getInt("id_nasabah"));
                listAnggota.add(ag);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAnggota;
    }
    public Anggota getBy(String where, String value){
        Anggota ag = new Anggota();
        String query = "SELECT * FROM `nasabah` WHERE `"+where+"` = '"+value+"'";
        ResultSet rs = AnggotaService.selectQuery(query);
        try {
            while (rs.next()) {                
                ag = new Anggota();
                ag.setNama(rs.getString("nama"));
                ag.setAlamat(rs.getString("alamat"));
                ag.setNo(rs.getString("no_telp"));
                ag.setType(rs.getString("jenis_anggota"));
                ag.setId(rs.getInt("id_nasabah"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ag;
    }
    public void insertDataPinjaman(Anggota ag){
        String queryInsert = "INSERT INTO `pinjaman` "
                + "(`id_pinjaman`, `id_nasabah`, `jumlah_pinjaman`, `bulan_pinjaman`, `total_angsuran`, `progess_angsuran`) "
                + "VALUES (NULL, '"+ag.getId()+"', '"+ag.getUangPinjaman()+"', '"+ag.getBulan()+"', "
                + "'"+ag.getUangAngsuran()+"', '0')";
        AnggotaService.insertQueryGetId(queryInsert);
        System.out.println(queryInsert);
    }
    
}

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
public class AnggotaLama extends Anggota implements Koperasi{

    @Override
    public int bunga() {
        int percent = 5;
        return percent;
    }

    
    public int angsuran() {
        int u = 0;
        u = super.getUangPinjaman() / super.getBulan();
        return u;
    }
    
}

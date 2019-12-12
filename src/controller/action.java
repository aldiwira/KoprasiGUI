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
public class action {
    public int angsuran(Koperasi ke){
        int harga = 0;
        int b = 0;
        if (ke instanceof AnggotaBaru) {
            b = ke.angsuran() * ke.bunga() / 100;
            harga = ke.angsuran() + b;
        } else if (ke instanceof AnggotaLama){
            b = ke.angsuran() * ke.bunga() / 100;
            harga = ke.angsuran() + b;
        } else {
            harga = 0;
        }
        return harga;
    }
    public int simpanan(Koperasi ke){
        int harga = 0;
        if (ke instanceof AnggotaBaru) {
            harga = ((AnggotaBaru) ke).getTotalSimpanan();
            harga += ((AnggotaBaru) ke).getUangSimpanan();
            ((AnggotaBaru) ke).setTotalSimpanan(harga);
        } else if (ke instanceof AnggotaLama) {
            harga = ((AnggotaLama) ke).getTotalSimpanan();
            harga += ((AnggotaLama) ke).getUangSimpanan();
            ((AnggotaLama) ke).setTotalSimpanan(harga);
        } else {
            harga = 0;
        }
        return harga;
    }
}


import controller.AnggotaBaru;
import controller.Koperasi;
import controller.action;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aldi Wirawan
 */
public class main {
    public static void main(String[] args) {
        action ac = new action();
        AnggotaBaru ab = new AnggotaBaru();
        ab.setNama("aldi");
        ab.setAlamat("kediri");
        ab.setNo("0000000");
        ab.setUangPinjaman(1000000);
        ab.setBulan(12);
        ab.setUangSimpanan(1000);
        
        
        System.out.println("angsuran " +ac.angsuran(ab));
        System.out.println("tabungan " +ac.simpanan(ab));
        ab.setUangSimpanan(1000);
        
        System.out.println("tabungan 2 " +ac.simpanan(ab));
        ab.setUangSimpanan(1000);
        System.out.println("tabungan 2 " +ac.simpanan(ab));
    }
}

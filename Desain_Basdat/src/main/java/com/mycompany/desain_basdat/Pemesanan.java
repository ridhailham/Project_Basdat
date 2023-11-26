/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.desain_basdat;

import java.awt.Frame;

/**
 *
 * @author LENOVO
 */
class Pemesanan {
    private int sno;
    private String nama_pelanggan, nomor, frame, lensa, total_harga;
    
    public Pemesanan(int sno, String nama_pelanggan, String nomor, String frame, String lensa, String total_harga){
        this.sno = sno;
        this.nama_pelanggan = nama_pelanggan;
        this.nomor = nomor;
        this.frame = frame;
        this.lensa = lensa;
        this.total_harga = total_harga;
    }
    
    public int getsno() {
        return sno;
    }
    public String getnama_pelanggan() {
        return nama_pelanggan;
    }
    public String getnomor() {
        return nomor;
    }
    public String getframe() {
        return frame;
    }
    public String getlensa() {
        return lensa;
    }
    public String gettotal_harga() {
        return total_harga;
    }
}

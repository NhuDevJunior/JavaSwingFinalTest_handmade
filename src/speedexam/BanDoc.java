/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package speedexam;

import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class BanDoc implements Serializable{
    private int maBanDoc;
    private String hoTen,diaChi,dienThoai;

    public BanDoc(int maBanDoc, String hoTen, String diaChi, String dienThoai) {
        this.maBanDoc = maBanDoc;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.dienThoai = dienThoai;
    }

    public int getMaBanDoc() {
        return maBanDoc;
    }

    public String getHoTen() {
        return hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getDienThoai() {
        return dienThoai;
    }
    
    
}

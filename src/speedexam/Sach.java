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
public class Sach implements Serializable{
    private int maSach;
    private String tenSach,tacGia,chuyenNganh;
    private int namSanXuat,soLuong;

    public Sach(int maSach, String tenSach, String tacGia, String chuyenNganh, int namSanXuat, int soLuong) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.tacGia = tacGia;
        this.chuyenNganh = chuyenNganh;
        this.namSanXuat = namSanXuat;
        this.soLuong = soLuong;
    }

    public int getMaSach() {
        return maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public String getTacGia() {
        return tacGia;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public int getNamSanXuat() {
        return namSanXuat;
    }

    public int getSoLuong() {
        return soLuong;
    }
    
    
}

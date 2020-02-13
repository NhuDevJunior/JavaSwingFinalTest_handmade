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
public class QLMS implements Serializable{
    BanDoc a;
    Sach b;
    private int soLuong;

    public QLMS(BanDoc a, Sach b, int soLuong) {
        this.a = a;
        this.b = b;
        this.soLuong = soLuong;
    }

    public int getMaBanDoc() {
        return a.getMaBanDoc();
    }

    public int getMaSach() {
        return b.getMaSach();
    }
    public String getHoten(){
        return a.getHoTen();
    }
 public String getTenSach(){
        return b.getTenSach();
    }
    public int getSoLuong() {
        return soLuong;
    }
    public Object[] toObject(){
        return new Object[]{
            getMaBanDoc(),getHoten(),getMaSach(),getTenSach(),soLuong
        };
    }
    
}

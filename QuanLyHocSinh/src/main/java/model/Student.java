/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author lequo
 */
    public class Student implements Serializable{
    private String MHS;
    private String TenHS;
    private double Diem;
    private String HinhAnh;
    private String DiaChi;
    private String GhiChu;

    public Student(String MHS, String TenHS, double Diem, String HinhAnh, String DiaChi, String GhiChu) {
        this.MHS = MHS;
        this.TenHS = TenHS;
        this.Diem = Diem;
        this.HinhAnh = HinhAnh;
        this.DiaChi = DiaChi;
        this.GhiChu = GhiChu;
    }
    
    

    public String getMHS() {
        return MHS;
    }

    public String getTenHS() {
        return TenHS;
    }

    public double getDiem() {
        return Diem;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setMHS(String MHS) {
        this.MHS = MHS;
    }

    public void setTenHS(String TenHS) {
        this.TenHS = TenHS;
    }

    public void setDiem(double Diem) {
        this.Diem = Diem;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

/**
 *
 * @author Lab Informatika
 */
public class data {
    private String nama;
    private String  alat;
    private Double  nomor;
    private Double  sewa;
    private Double  biaya;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlat() {
        return alat;
    }

    public void setAlat(String alat) {
        this.alat = alat;
    }

    public Double getNomor() {
        return nomor;
    }

    public void setNomor(Double nomor) {
        this.nomor = nomor;
    }

    public Double getSewa() {
        return sewa;
    }

    public void setSewa(Double sewa) {
        this.sewa = sewa;
    }

    public Double getBiaya() {
        return biaya;
    }

    public void setNilai(Double biaya) {
        this.biaya = biaya;
    }

    public void setBiaya(double aDouble) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    
}

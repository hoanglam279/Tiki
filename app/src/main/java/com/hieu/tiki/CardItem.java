package com.hieu.tiki;

public class CardItem {
    int image;
    String ten,mota;

    public CardItem(int image, String ten, String mota){
        this.image=image;
        this.ten=ten;
        this.mota=mota;
    }
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }



}

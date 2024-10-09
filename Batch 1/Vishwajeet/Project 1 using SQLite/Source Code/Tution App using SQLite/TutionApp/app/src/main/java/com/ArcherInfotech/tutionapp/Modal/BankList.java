package com.ArcherInfotech.tutionapp.Modal;

public class BankList {

    String bankName;
    int bankImg;

    public BankList(String bankName, int img){
        this.bankName = bankName;
        this.bankImg = img;

    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getBankImg(){
        return bankImg;
    }

    public void setImg(int bankImg) {
        this.bankImg = bankImg;
    }
}

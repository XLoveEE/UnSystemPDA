package com.jxx.unsystempda.Bean;

public   class   SystemConfig {
    String OutIP = "";
    String InIP = "172.19.4.97:28080";
    //FD0AC27D8AC3
    byte[] MifareCardKey = new byte[]{(byte)0xFD,(byte)0x0A,(byte)0xC2,(byte)0x7D,(byte)0x8A,(byte)0xC3};

    public String getOutIP() {
        return OutIP;
    }

    public void setOutIP(String outIP) {
        OutIP = outIP;
    }

    public String getInIP() {
        return InIP;
    }

    public void setInIP(String inIP) {
        InIP = inIP;
    }

    public byte[] getMifareCardKey() {
        return MifareCardKey;
    }

    public void setMifareCardKey(byte[] mifareCardKey) {
        MifareCardKey = mifareCardKey;
    }
}

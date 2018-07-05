package com.ciweek.demo.ViewPager_Tablayout.javaBean;


import java.util.List;

public class Film {


    private List<String> detatil;
    private String infoPwd;
    private String bdyUrl;
    private String infoName;
    private List<String> filmName;
    public void setDetatil(List<String> detatil) {
        this.detatil = detatil;
    }
    public List<String> getDetatil() {
        return detatil;
    }

    public void setInfoPwd(String infoPwd) {
        this.infoPwd = infoPwd;
    }
    public String getInfoPwd() {
        return infoPwd;
    }

    public void setBdyUrl(String bdyUrl) {
        this.bdyUrl = bdyUrl;
    }
    public String getBdyUrl() {
        return bdyUrl;
    }

    public void setInfoName(String infoName) {
        this.infoName = infoName;
    }
    public String getInfoName() {
        return infoName;
    }

    public void setFilmName(List<String> filmName) {
        this.filmName = filmName;
    }
    public List<String> getFilmName() {
        return filmName;
    }

}
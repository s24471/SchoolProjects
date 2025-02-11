package zad1;

import javax.swing.*;

public class Country {
    private String country;
    private String capital;
    private Integer population;
    private ImageIcon flag;
    private static int nr =0;
    public Country(String country, String capital, Integer population, String flag) {
        this.country = country;
        this.capital = capital;
        this.population = population;
        this.flag = new ImageIcon("data/flags/" + flag + ".png");
        nr++;
    }
    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }

    public Integer getPopulation() {
        return population;
    }

    public ImageIcon getFlag() {
        return flag;
    }
}

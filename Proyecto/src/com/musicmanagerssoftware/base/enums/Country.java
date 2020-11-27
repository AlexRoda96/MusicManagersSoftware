package com.musicmanagerssoftware.base.enums;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

 public class Country implements Comparable<Country> {
    private String code;
    private String name;

    public Country(String code, String name) {
        super();
        this.code = code;
        this.name = name;
    }

     public Country() {

     }

    public List<Country> getCountries(){

        String[] countryCodes = Locale.getISOCountries();
        List<Country> list = new ArrayList<Country>(countryCodes.length);

        for (String cc : countryCodes) {
            list.add(new Country(cc.toUpperCase(), new Locale("", cc).getDisplayCountry()));
        }

        Collections.sort(list);

        return list;
    }

    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Country o) {
        return this.name.compareTo(o.name);
    }
}

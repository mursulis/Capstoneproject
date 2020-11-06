package com.example.project;

public class MainModel {
    Integer treeLogo;
    String treeName;

    public MainModel(Integer treeLogo, String treeName){
        this.treeLogo = treeLogo;
        this.treeName = treeName;
    }

    public Integer getTreeLogo(){
        return treeLogo;
    }

    public String getTreeName(){
        return treeName;
    }

}

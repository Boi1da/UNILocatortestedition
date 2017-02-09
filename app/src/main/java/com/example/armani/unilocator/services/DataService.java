package com.example.armani.unilocator.services;

import com.example.armani.unilocator.model.Unilocator;

import java.util.ArrayList;

/**
 * Created by Armani on 05/02/2017.
 */
public class DataService {
    private static DataService instance = new DataService();

    public static DataService getInstance() {
        return instance;
    }

    private DataService() {
    }

    //This says miles but i cba to change the actual name so yh boi
    public ArrayList<Unilocator> getCampusLocationsWithin10milesofEnteredSite(String campusName) {
        //Pretend to get data from a server for now cuz im lazy af

        ArrayList<Unilocator> list = new ArrayList<>(); //51.532918, -0.472879
        list.add(new Unilocator(51.533488f, -0.468603f,"Eastern Gateway","Lecture Hall","esgw"));
        list.add(new Unilocator(51.533376f, -0.470200f,"Brunel University Sports Centre","Sports related","sportshall"));
        list.add(new Unilocator(51.532494f, -0.469597f,"Indoor Athletics Centre","Sports related","sportshall"));
        list.add(new Unilocator(51.532918f, -0.472879f,"Lecture Centre","Lecture Hall","lechall"));
        list.add(new Unilocator(51.534503f, -0.469494f, "St Johns","Lab Building","stjohns"));

        return list;
    }

    public ArrayList<Unilocator> getUserDataForLocations(String campusName) {
         ArrayList<Unilocator> userData = new ArrayList<>();
        userData.add(new Unilocator(51.585f, -0.362f,"Connor ","Hey, i'm looking for a nice chat with someone ","connor"));
        userData.add(new Unilocator(51.586f, -0.361f,"Sundeep","Yo, anyone around to talk too?","deep"));
        userData.add(new Unilocator(51.587f, -0.362f,"Denis","Really really bored","denis"));


        return userData;
    }




}

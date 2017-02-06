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

        ArrayList<Unilocator> list = new ArrayList<>();
        list.add(new Unilocator(51.533f, -0.468f,"Eastern Gateway","Lecture Hall","esgw"));
        list.add(new Unilocator(51.533f, -0.470f,"Brunel University Sports Centre","Sports related","sportshall"));
        list.add(new Unilocator(51.533f, -0.470f,"Indoor Athletics Centre","Sports related","sportshall"));
        list.add(new Unilocator(51.532f, -0.472f,"Lecture Centre","Lecture Hall","lechall"));
        list.add(new Unilocator(51.534f, -0.469f,"St Johns","Lab Building","stjohns"));

        return list;
    }

    public ArrayList<Unilocator> getUserDataForLocations(String campusName) {
         ArrayList<Unilocator> userData = new ArrayList<>();
        userData.add(new Unilocator(51.585f, -0.362f,"Connor ","Hey, i'm looking for a nice chat with someone ","connor"));
        userData.add(new Unilocator(51.586f, -0.361f,"GYM","Fitness Related","deep"));
        userData.add(new Unilocator(51.587f, -0.362f,"St Johns","STEM Lab Building","stjohns"));


        return userData;
    }




}

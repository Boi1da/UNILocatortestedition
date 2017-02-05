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
        list.add(new Unilocator(51.533f, -0.468f,"Eastern Gateway","Business Centre + Lecture Hall","esgw"));
        list.add(new Unilocator(51.533f, -0.470f,"Brunel University Sports Centre","Sports related","sportshall"));
        list.add(new Unilocator(51.534f, -0.469f,"St Johns","STEM Lab Building","stjohns"));
        return list;
    }
}

package com.leapfrog.aii.dao;

import com.leapfrog.aii.entity.Persons;
import java.util.ArrayList;

public interface PersonsDAO {

    void insert(Persons p);

    boolean delete(int id);

    boolean update(int id);

    Persons getById(int id);

    void getByAny(String s);

    ArrayList<Persons> getAll();

    boolean doesEmailExists(String email);

    int getID();

}

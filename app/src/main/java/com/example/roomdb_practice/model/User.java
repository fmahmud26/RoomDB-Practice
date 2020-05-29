package com.example.roomdb_practice.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "user_table", indices = {@Index(value = {"number"}, unique = true)})
public class User {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "first_name")
    private String firstName;

    @ColumnInfo(name = "last_name")
    private String lastName;

    @ColumnInfo(name = "address")
    private String address;

    @ColumnInfo(name = "age")
    private int age;

    @ColumnInfo(name = "number")
    private String number;

    public User(long id, String firstName, String lastName, String address, int age, String number) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.number = number;
    }

    @Ignore
    public User(String firstName, String lastName, String address, int age, String number) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.age = age;
        this.number = number;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

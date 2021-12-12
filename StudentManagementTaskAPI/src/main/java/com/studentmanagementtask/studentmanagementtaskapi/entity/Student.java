package com.studentmanagementtask.studentmanagementtaskapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.zip.DataFormatException;

@Entity
@Table(name = "student")
public class Student {

    //private int No;

    @Column(name = "Name")
    private String name;

    @Column(name = "Department")
    private String department;

    @Id
    @Column(name = "NationalID")
    private String nationalID;

    @Column(name = "mobile_number")
    private String mobileNumber;


    private static int NationalIdSize = 14;
    private static int MobileNumberSize = 11;
    private static String MobileNumberStart = "01";

    public Student() {

    }

    public Student(String name, String department, String nationalID, String mobileNumber) throws DataFormatException {
        setName(name);
        setDepartment(department);
        setNationalID(nationalID);
        setMobileNumber(mobileNumber);
    }

    /*public int getNo() {
        return No;
    }

    public void setNo(int no) {
        No = no;
    }*/

    public String getName() {
        return name;
    }

    public static boolean validateName(String name){
        name = name.trim();
        if(name.isEmpty()) return false;
        for(int i = 0; i < name.length(); ++i){
            if(name.charAt(i) == ' ') continue;
            if(!Character.isAlphabetic(name.charAt(i))) return false;
        }
        return true;
    }

    public void setName(String name) throws DataFormatException {
        if(!validateName(name)) throw new DataFormatException("Name should consist of Alphabetic characters only");
        this.name = name.trim();
    }

    public String getDepartment() {
        return department;
    }

    boolean validateDepartment(String department){
        return department != null && !department.isEmpty();
    }
    public void setDepartment(String department) throws DataFormatException {
        if(!validateDepartment(department)){
            throw new DataFormatException("You must choose a department");
        }
        this.department = department;
    }

    public String getNationalID() {
        return nationalID;
    }

    public static boolean validateNationalID(String nationalID){
        nationalID = nationalID.trim();
        if(nationalID.length() != NationalIdSize) return false;

        for(int i = 0; i < nationalID.length(); ++i){
            if(!Character.isDigit(nationalID.charAt(i))) return false;
        }

        return true;
    }

    public void setNationalID(String nationalID) throws DataFormatException {
        if(!validateNationalID(nationalID)) throw new DataFormatException("National ID should consist of 14 numerical digits");

        this.nationalID = nationalID.trim();
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public static boolean validateMobileNumber(String mobileNumber){
        mobileNumber = mobileNumber.trim();
        if(mobileNumber.length() != MobileNumberSize) return false;
        if(!mobileNumber.startsWith(MobileNumberStart)) return false;
        for(int i = 0; i < mobileNumber.length(); ++i){
            if(!Character.isDigit(mobileNumber.charAt(i))) return false;
        }
        return true;
    }

    public void setMobileNumber(String mobileNumber) throws DataFormatException {
        if(!validateMobileNumber(mobileNumber)) throw new DataFormatException("Mobile Number should consist of 11 numerical digits starting with 01");

        this.mobileNumber = mobileNumber.trim();
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", nationalID='" + nationalID + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }

    public boolean equals(Student s){
        return name.equals(s.name) &&
                department.equals(s.department) &&
                nationalID.equals(s.nationalID) &&
                mobileNumber.equals(s.mobileNumber);
    }
}

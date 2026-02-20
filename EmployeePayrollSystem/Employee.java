import java.io.*;

class Employee {

    int id;
    String empName;
    double basePay;
    double hra, da, total;

    // constructor
    Employee(int i, String n, double sal){
        id = i;
        empName = n;
        basePay = sal;
        calcSal();
    }

    void calcSal(){
        hra = basePay * 0.2;
        da = basePay * 0.1;
        total = basePay + hra + da;
    }

    void show(){
        System.out.println(id+" | "+empName+" | "+total);
    }

    void show(int searchId){
        if(id == searchId){
            System.out.println("Employee Found");
            System.out.println("Name : "+empName);
            System.out.println("Salary : "+total);
        }
    }

    String fileData(){
        return id+","+empName+","+basePay;
    }
}
new FileWriter("empdata.txt")

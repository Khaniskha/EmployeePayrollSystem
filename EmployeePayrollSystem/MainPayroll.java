import java.util.*;
import java.io.*;

public class MainPayroll {

    static ArrayList<Employee> empList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addEmp(){

        System.out.print("Enter id : ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter name : ");
        String name = sc.nextLine();

        System.out.print("Basic salary : ");
        double sal = sc.nextDouble();

        Employee e1 = new Employee(id,name,sal);
        empList.add(e1);

        System.out.println("added...");
    }

    static void displayAll(){
        for(Employee e : empList){
            e.show();
        }
    }

    static void findEmp(){

        System.out.print("Search id : ");
        int sid = sc.nextInt();

        boolean flag=false;

        for(Employee e:empList){
            if(e.id==sid){
                e.show(sid);
                flag=true;
            }
        }

        if(!flag)
            System.out.println("not found");
    }

    static void saveFile(){

        try{
            BufferedWriter bw =
              new BufferedWriter(new FileWriter("empdata.txt"));

            for(Employee e:empList){
                bw.write(e.fileData());
                bw.newLine();
            }

            bw.close();
            System.out.println("saved");

        }catch(Exception ex){
            System.out.println("file issue");
        }
    }

    static void readFile(){

        try{
            BufferedReader br =
             new BufferedReader(new FileReader("empdata.txt"));

            String line;

            System.out.println("Stored Employees:");

            while((line=br.readLine())!=null){

                String arr[] = line.split(",");

                Employee temp =
                  new Employee(
                    Integer.parseInt(arr[0]),
                    arr[1],
                    Double.parseDouble(arr[2])
                  );

                temp.show();
            }

            br.close();

        }catch(Exception e){
            System.out.println("cannot read file");
        }
    }

    public static void main(String args[]){

        int ch;

        do{

            System.out.println("\n*** Staff Salary Manager ***");
            System.out.println("1.Add");
            System.out.println("2.Display");
            System.out.println("3.Search");
            System.out.println("4.Save");
            System.out.println("5.Read");
            System.out.println("6.Exit");

            System.out.print("choice : ");
            ch = sc.nextInt();

            switch(ch){

                case 1: addEmp(); break;
                case 2: displayAll(); break;
                case 3: findEmp(); break;
                case 4: saveFile(); break;
                case 5: readFile(); break;
            }

        }while(ch!=6);

        System.out.println("program ended");
    }
}

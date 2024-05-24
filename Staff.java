package HotelManagement;

public class Staff extends Person {

    private String staffRole;
    private double salary;

    Staff(){
        super();
    }

    Staff(String n, int a,String sRole, double sal){
        super(n,a);
        this.staffRole = sRole;
        this.salary = sal;
    }

    public void setsName(String n){
        super.setName(n);
    }

    public void setsAge(int a){
        super.setAge(a);
    }

    public String getsName(){
        return super.getName();
    }

    public int getsAge(){
        return super.getAge();
    }

    public void setsRole(String sRole){
        this.staffRole = sRole;
    }

    public void setsalary(double sal){
        this.salary = sal;
    }
    public String getsRole(){
        return staffRole;
    }

    public double getSalary(){
        return salary;
    }

    public String displayStaff(){
       return "Staff Name: "+getsName()+
              "  Age: "+getsAge()+
              "  Role: "+getsRole()+
              "  Salary: "+getSalary();

    }

}

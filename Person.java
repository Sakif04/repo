package HotelManagement;

public class Person {
    String name;
    int age;
    Person(){

    }

    Person(String n,int a){
        this.name = n;
        this.age = a;
    }

    public void setName(String n){
        this.name = n;
    }

    public void setAge(int a){
        this.age = a;
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age; 
    }

}

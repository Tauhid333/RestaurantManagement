
package restaurantmanagement;


  class Employee {
    private int EmployeeId;
    private  String Employee_Name,Employee_Address;
    private String Employee_Phone;
    private float Salary;
    
    public Employee(int EmployeeId,String Employee_Name,String Employee_Address, String Employee_Phone,float Salary)
    {
        this.EmployeeId=EmployeeId;
        this.Employee_Name=Employee_Name;
        this.Employee_Address=Employee_Address;
        this.Employee_Phone=Employee_Phone;
        this.Salary=Salary;
    }
    public int getEmployeeId(){
        return EmployeeId;
    }
    public String getEmployee_Name(){
        return Employee_Name;
    }
    public String getEmployee_Address(){
        return Employee_Address;
    }
    public String getEmployee_Phone(){
        return Employee_Phone;
    }
    public float getSalary(){
        return Salary;
    }
    
    
}
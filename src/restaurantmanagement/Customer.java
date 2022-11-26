
package restaurantmanagement;

class Customer {
    
    private int CustomerId;
    private  String Customer_Name,Customer_Address;
    private String Customer_Phone;
 
    public Customer(int CustomerId,String Customer_Name,String Customer_Address, String Customer_Phone)
    {
        this.CustomerId=CustomerId;
        this.Customer_Name=Customer_Name;
        this.Customer_Address=Customer_Address;
        this.Customer_Phone=Customer_Phone;
        
    } 
    
     public int getCustomerId(){
        return CustomerId;
    }
    public String getEmployee_Name(){
        return Customer_Name;
    }
    public String getCustomer_Address(){
        return Customer_Address;
    }
    public String Customer_Phone(){
        return Customer_Phone;
    }
 
}

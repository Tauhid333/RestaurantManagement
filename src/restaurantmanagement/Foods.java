
package restaurantmanagement;


class Foods {
    private String Item_Id, Item_Description,Price;
    

    public Foods(String Item_Id, String Item_Description, String Price) {
        this.Item_Id = Item_Id;
        this.Item_Description = Item_Description;
        this.Price = Price;
    }

    public String getItem_Id() {
        return Item_Id;
    }

    public String getItem_Description() {
        return Item_Description;
    }

    public String getPrice() {
        return Price;
    }
    
    
    
}
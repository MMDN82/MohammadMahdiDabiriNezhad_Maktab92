package shop.domain;

import shop.base.User;

public class Customer extends User {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String province;
    private String city;
    private String address;
    private String postalCode;
    private int addressCounter=1;
    private String[][] addresses = new String[10][4];

    public void show(){

    }


    public Customer(int id, String username, String password, String firstName,
                    String lastName, String phoneNumber, String emailAddress,
                    String province, String city, String address, String postalCode) {
        super(id, username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.province = province;
        this.city = city;
        this.address=address;
        this.postalCode = postalCode;
        this.addresses[addressCounter-1][0]=province;
        this.addresses[addressCounter-1][1]=city;
        this.addresses[addressCounter-1][2]=address;
        this.addresses[addressCounter-1][3]=postalCode;
        addressCounter++;
    }
    public void addAddress(String province, String city, String address, String postalCode){
        this.addresses[addressCounter-1][0]=province;
        this.addresses[addressCounter-1][1]=city;
        this.addresses[addressCounter-1][2]=address;
        this.addresses[addressCounter-1][3]=postalCode;
        addressCounter++;
    }

    public void printAddresses(){
        for (int i = 0 ; i < addressCounter-1 ; i++){
            for (int j = 0 ; j < 4; j++){
                System.out.print(addresses[i][j]);
                if (j != 3){
                    System.out.print(" ,");
                }
            }
            System.out.println();
        }
    }
}

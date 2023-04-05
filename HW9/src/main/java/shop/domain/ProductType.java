package shop.domain;

import shop.base.Entity;
import shop.domain.enums.ItemsCategory;
import shop.domain.enums.ShopCategory;

import java.util.ArrayList;

public class ProductType extends Entity {
    private ShopCategory shopCategory;
    private ItemsCategory itemsCategory;
    private String BrandName;
    private Long price;
    private String[][] product = new String[100][6];
    private int productCounter = 0;
    private int number;


    public ProductType() {
    }
    public void addProduct(int id, ShopCategory shopCategory , ItemsCategory itemsCategory ,String brandName , Long price,int number){
        product[productCounter][0]= String.valueOf(id);
        product[productCounter][1]= String.valueOf(shopCategory);
        product[productCounter][2]= String.valueOf(itemsCategory);
        product[productCounter][3]=brandName;
        product[productCounter][4]= String.valueOf(price);
        product[productCounter][5]= String.valueOf(number);
        productCounter++;
    }
    public void showEA(){
        for (int i = 0 ; i < productCounter ; i++){
            if (product[i][1].equals("ELECTRICAL_APPLIANCES")){
                for (int j = 0 ; j < 6 ; j ++){
                    System.out.print(product[i][j]);
                    if (j != 5)
                        System.out.print(" ,");
                }
            }
            System.out.println();
        }
    }
    public void showList(){
        for (int i = 0 ; i < productCounter; i++){
                for (int j = 0 ; j < 6 ; j ++){
                    System.out.print(product[i][j]);
                    if (j != 5)
                        System.out.print(" ,");
                }
            System.out.println();
        }

    }


    public ShopCategory getShopCategory() {
        return shopCategory;
    }

    public void setShopCategory(ShopCategory shopCategory) {
        this.shopCategory = shopCategory;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String[][] getProduct() {
        return product;
    }

    public void setProduct(String[][] product) {
        this.product = product;
    }
    public void addProduct(String[][] product) {
        this.product = product;
    }

}

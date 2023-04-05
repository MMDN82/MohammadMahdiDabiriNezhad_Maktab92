package shop;

import shop.domain.Customer;
import shop.domain.ProductType;
import shop.domain.enums.ItemsCategory;
import shop.domain.enums.ShopCategory;

public class Shop {
    public static void main(String[] args) {
        Customer customer = new Customer(1,"mmdn","1234","mahdi","dabiri","0987654212","mahsdy@gmai.com"
        ,"tehran","tehran","asdsfd asd asd asd","123243421321");
        customer.addAddress("mashhad","mashhad","djbsib jdbcn jkdbv3","12635798907");

        /***************************************/
        ProductType productType = new ProductType();
        productType.addProduct(1, ShopCategory.SHOE , ItemsCategory.FORMAL,"sdads",1221309L,12);
        productType.addProduct(2, ShopCategory.THINGS_TO_READ, ItemsCategory.FORMAL,"sdads",1221309L,12);
        productType.addProduct(3, ShopCategory.ELECTRICAL_APPLIANCES, ItemsCategory.FORMAL,"sdads",1221309L,12);

        customer.show();







    }

}

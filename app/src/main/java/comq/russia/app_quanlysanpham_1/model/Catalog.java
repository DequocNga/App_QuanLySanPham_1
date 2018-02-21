package comq.russia.app_quanlysanpham_1.model;

import java.util.ArrayList;

/**
 * Created by VLADIMIR PUTIN on 2/21/2018.
 */

public class Catalog extends Goods {
    ArrayList<Product> danhSachSP = new ArrayList<>();

    public Catalog() {
    }

    public Catalog(String id, String name) {
        super(id, name);
    }

    public Catalog(String id, String name, ArrayList<Product> danhSachSP) {
        super(id, name);
        this.danhSachSP = danhSachSP;
    }

    public Catalog(ArrayList<Product> danhSachSP) {
        super();
        this.danhSachSP = danhSachSP;
    }

    /*check san pham da ton tai trong danh muc hay chua*/

    public boolean isDuplicate(Product product) {
        for (Product p1 : danhSachSP) {
            if (p1.getId().trim().equalsIgnoreCase(product.getId().trim())) {
                return true;
            }
        }
        return false;
    }

    public boolean addProduct(Product product) {
        boolean isDup = isDuplicate(product);
        if (!isDup) {
            product.setDanhMuc(this);
            return danhSachSP.add(product);
        }
        return !isDup;
    }

    public ArrayList<Product> getDanhSachSP() {
        return this.danhSachSP;
    }

    public int size(){
        return this.danhSachSP.size();
    }

    public Product get(int i){
        return this.danhSachSP.get(i);
    }
}

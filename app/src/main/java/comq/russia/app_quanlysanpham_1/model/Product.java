package comq.russia.app_quanlysanpham_1.model;

/**
 * Created by VLADIMIR PUTIN on 2/21/2018.
 */

public class Product extends Goods {
    Catalog danhMuc;

    public Product(String id, String name, Catalog danhMuc) {
        super(id, name);
        this.danhMuc = danhMuc;
    }

    public Product(String id, String name) {
        super(id, name);
    }

    public Catalog getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(Catalog danhMuc) {
        this.danhMuc = danhMuc;
    }

    public Product() {
    }
}

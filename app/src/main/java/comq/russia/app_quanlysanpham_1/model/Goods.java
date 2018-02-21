package comq.russia.app_quanlysanpham_1.model;

/**
 * Created by VLADIMIR PUTIN on 2/21/2018.
 */

public class Goods {
    String id;
    String name;

    public Goods() {
    }

    public Goods(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getId() + " - " + this.getName();
    }
}

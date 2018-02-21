package comq.russia.app_quanlysanpham_1.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;

import comq.russia.app_quanlysanpham_1.R;
import comq.russia.app_quanlysanpham_1.model.Catalog;
import comq.russia.app_quanlysanpham_1.model.Product;

public class MainActivity extends AppCompatActivity {

    Spinner spCatalog;
    EditText editMaSP;
    EditText editTenSP;
    Button btnNhapSP;
    ListView lvShowList;
    ArrayList<Product> productArrayList = new ArrayList<>();
    ArrayAdapter<Product> productArrayAdapter;
    ArrayList<Catalog> catalogArrayList = new ArrayList<>();
    ArrayAdapter<Catalog> catalogArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        connectView();
        takeFakeDataList();
        addEventWidgets();
    }

    private void addEventWidgets() {
        btnNhapSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addProduct();
            }
        });
        spCatalog.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                reloadListProduct(catalogArrayList.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void addProduct() {
        Product product = new Product();
        product.setId(editMaSP.getText().toString());
        product.setName(editTenSP.getText().toString());
        Catalog c = new Catalog();
        c.addProduct(product);
        reloadListProduct(c);
        editMaSP.setText("");
        editTenSP.setText("");
    }

    private void reloadListProduct(Catalog c) {
        /*xoa toan bo danh sach cu*/
//        productArrayList.clear();
        /*add moi lai toan bo danh sach*/
        productArrayList.addAll(c.getDanhSachSP());
        /*update*/
        productArrayAdapter.notifyDataSetChanged();
    }

    private void takeFakeDataList() {
        Catalog catalog = new Catalog("1", "Sam Sung");
        Catalog catalog1 = new Catalog("2", "Iphone");
        Catalog catalog2 = new Catalog("3", "Sony");
        catalogArrayList.add(catalog);
        catalogArrayList.add(catalog1);
        catalogArrayList.add(catalog2);
        catalogArrayAdapter.notifyDataSetChanged();
    }

    private void connectView() {
        spCatalog = findViewById(R.id.spDanhMuc);
        editMaSP = findViewById(R.id.edt_maSP);
        editTenSP = findViewById(R.id.edt_tenSP);
        btnNhapSP = findViewById(R.id.btn_nhapSP);
        lvShowList = findViewById(R.id.lv_showSP);
        catalogArrayAdapter = new ArrayAdapter<Catalog>(this, android.R.layout.simple_spinner_dropdown_item, catalogArrayList);
        catalogArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCatalog.setAdapter(catalogArrayAdapter);
        productArrayAdapter = new ArrayAdapter<Product>(this, android.R.layout.simple_list_item_1, productArrayList);
        lvShowList.setAdapter(productArrayAdapter);
    }
}

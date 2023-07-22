package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private String[][] packages =
            {
                    {"Uprise-D3 1000IU Capsule", "", "", "", "50"},
                    {"HealthVit Chromium Picolinate 200mcg Capsule", "", "", "", "305"},
                    {"Vitamin B Complex Capsules", "", "", "", "448"},
                    {"Inlife Vitamin E wheat Germ oil capsule", "", "", "", "539"},
                    {"Dolo 650", "", "", "", "30"},
                    {"Crocin 650 tablet", "", "", "", "50"},
                    {"Strepsils Medicated Lozenges for sore Throat", "", "", "", "40"},
                    {"Tata 1mg Calcium + Vitamin D3", "", "", "", "30"},
                    {"Feronia -XT Tablet", "", "", "", "130"}
            };
    private String[] package_details = {
            "Building and keeping the bones and teeth strong\n" + "Reducing fatigue and muscular pain\n" + "Boosting immunity and increasing resistance against infection",
            "Chromium an essential trace mineral that plays a vital role in various bodily functions\n"+"helps regulate blood sugar levels\n"+"help reduce cravings, suppress appetite, and support healthy metabolism\n"+"improve insulin sensitivity, allowing cells to effectively utilize glucose for energy",
            "Healthy functioning of the nervous system\n"+"necessary for the production of red blood cells\n"+"help combat fatigue, improve overall energy levels, and enhance vitality",
            "Powerful antioxidant that helps protect cells from damage caused by free radicals\n"+"Supports skin health by promoting moisturization\n"+"Reducing the signs of aging\n"+"Enhance immune function and promotes the production of immune cells",
            "Alleviate mild to moderate pain caused by conditions such as headaches, toothaches, menstrual cramps\n" + "Reducing fever associated with various infections, including colds, flu, and other viral or bacterial illnesses",
            "Reducing fever associated with common viral or bacterial infections, such as colds, flu\n"+"quickly absorbed into the bloodstream, allowing it to provide prompt relief from pain and fever\n",
            "Soothing a sore throat\n"+"possess antimicrobial properties, which can help to target and combat the bacteria responsible for causing throat infections\n"+"non-drowsy",
            "Reduces risk of calcium deficiency,Rickets and Osteoporisis\n"+"Promotes flexibility of joints\n",
            "Helps to reduce iron deficiency due to chronic blood loss or low iintake of iron"
    };

    ArrayList list;
    HashMap<String, String> item;
    SimpleAdapter sa;
    Button btnBack,btnGoToCart;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);
        btnBack = (Button) findViewById(R.id.buttonBMBack);
        btnGoToCart = (Button) findViewById(R.id.buttonBMAddToCart);
        lst = findViewById(R.id.editTextTextBMDMultiline);

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class));
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost: " + packages[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this,list,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it =new Intent(BuyMedicineActivity.this,BuyMedicineDetailsActivity.class);
                it.putExtra("text1",packages[i][0]);
                it.putExtra("text2",package_details[i]);
                it.putExtra("text3",packages[i][4]);
                startActivity(it);
            }
        });
    }
}
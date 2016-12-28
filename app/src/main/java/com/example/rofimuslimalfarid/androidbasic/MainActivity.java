package com.example.rofimuslimalfarid.androidbasic;


import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.text.StringCharacterIterator;

public class MainActivity extends AppCompatActivity {

    int quantity = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increment (View view){
        if (quantity == 100){
            Toast.makeText(this,"Tong loba Teuing Atuh ai sia " + getNama(),Toast.LENGTH_SHORT).show();
        }
        quantity=quantity +1;

        Display (quantity);
       // displayPrice(quantity * 5);
    }
    public void decrement (View view){
        quantity=quantity -1;
        if (quantity == 1){
            Toast.makeText(this,"Teu bisa teu mesen didieu mah",Toast.LENGTH_SHORT).show();
            return;
        }
        Display (quantity);
       // displayPrice(quantity *5);
    }

    public void Display (int number){
        TextView quantityTextview = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextview.setText("" + number);
    }

    public void orderPlis (View view){


        String pricemsg = getString(R.string.reserved) + " Rofi Muslim Alfarid" ;
        pricemsg = pricemsg + "\n" + getString(R.string.your_Q) + quantity;
        int price = toppings(quantity);
        pricemsg = pricemsg + "\n" + getString(R.string.your_B) + price + "\n" + getString(R.string.ty);

       // String Nama = getNama();
        pricemsg = pricemsg + "\n" + getNama();

        // displayPrice(quantity * 5);


        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "Rofi.alfarid@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Smalakutaks" + getNama());
        intent.putExtra(Intent.EXTRA_TEXT, pricemsg);
        intent.putExtra(Intent.EXTRA_CC, "tia@gmail.com");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        displayMsg(pricemsg);
    }

    public int toppings (int coffee){
        int price = 0;
        CheckBox Granule = (CheckBox) findViewById(R.id.checkBox);
        Boolean granuled = Granule.isChecked();
        if(granuled == true){
            price = (coffee * 3) + (coffee * 4);
        }

        price = coffee *3;

        return price;

    }

    public String summaryOrder (String sums){
        return sums;
    }

    public int calculateOrder (int coffee){
        coffee = coffee * 3;
        return coffee;
    }


    private void displayPrice (int number){
        TextView Pricetextview = (TextView) findViewById(R.id.price_text_view);
        Pricetextview.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    public void displayMsg(String message){
        TextView priceTextview = (TextView) findViewById(R.id.price_text_view);
        priceTextview.setText(message);
    }

    public String getNama (){
        EditText Nama = (EditText) findViewById(R.id.nama);
        String nama = Nama.getText().toString();
        return nama;
    }


}

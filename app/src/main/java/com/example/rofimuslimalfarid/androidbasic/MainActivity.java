package com.example.rofimuslimalfarid.androidbasic;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
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
        quantity=quantity +1;
        Display (quantity);
       // displayPrice(quantity * 5);
    }
    public void decrement (View view){
        quantity=quantity -1;
        Display (quantity);
       // displayPrice(quantity *5);
    }

    public void Display (int number){
        TextView quantityTextview = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextview.setText("" + number);
    }

    public void orderPlis (View view){
        String pricemsg = "Reserved by Rofi Muslim Alfarid" ;
        pricemsg = pricemsg + "\nYour Quantity is : " + quantity;
        int price = calculateOrder(quantity);
        pricemsg = pricemsg + "\nyour bill is : $" + price + "\nThank you !!";

        // displayPrice(quantity * 5);
        displayMsg(pricemsg);
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


}

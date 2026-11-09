package com.example.pizzaorder;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgSize;
    RadioGroup rgCrust;
    int price;
    String size;
    String crust;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });



        Button btnOrder = findViewById(R.id.btnOrder);
        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rgSize = findViewById(R.id.rgSize);
                rgCrust = findViewById(R.id.rgCrust);
                price = 0;
                size  = RG.RGtext(MainActivity.this, R.id.rgSize);
                crust = RG.RGtext(MainActivity.this, R.id.rgCrust);


                switch (size) {
                    case "small":
                        price = 25;
                        break;
                    case "medium":
                        price = 50;
                        break;
                    case "large":
                        price = 100;
                        break;
                    default:
                        price = 0;
                        break;
                }
                switch (crust) {
                    case "thin":
                        price += 0;
                        break;
                    case "thick":
                        price += 15;
                        break;
                    default:
                        price = 0;
                        break;
                }


                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("confirm order");
                builder.setMessage("order pizza? " + size + " with crust " + crust + "\nPrice: " + price + "₪");

                builder.setPositiveButton("אשר", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "order received!", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(MainActivity.this, SummaryActivity.class);
                        intent.putExtra("size", size);
                        intent.putExtra("crust", crust);
                        intent.putExtra("price", price);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("cancel", null);
                builder.show();
            }
        });
    }
}
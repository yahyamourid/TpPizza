package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizza.classes.Pizza;
import com.example.pizza.services.PizzaService;

public class DetailsActivity extends AppCompatActivity {
    private PizzaService ps;
    private ImageView image;
    private TextView nom;
    private TextView description;
    private TextView ingrediants;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();
        int id = Integer.parseInt(intent.getStringExtra("id"));
        ps = PizzaService.getInstance();
        Pizza p = ps.findById(id);
        System.out.println(p);

        image = findViewById(R.id.image);
        nom = findViewById(R.id.nom);
        description = findViewById(R.id.description);
        ingrediants = findViewById(R.id.ingrediants);

        image.setImageResource(p.getPhoto());
        nom.setText(p.getNom());
        description.setText(p.getDescription());
        ingrediants.setText(p.getDetailsIngred());
    }
}
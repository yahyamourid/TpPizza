package com.example.pizza.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizza.R;
import com.example.pizza.classes.Pizza;

import java.util.List;

public class PizzaAdapter extends BaseAdapter {
    private List<Pizza> pizzas;
    private LayoutInflater inflater;

    public PizzaAdapter(List<Pizza> pizzas, Activity activity) {
        this.pizzas = pizzas;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public int getCount() {
        return pizzas.size();
    }

    @Override
    public Object getItem(int position) {
        return pizzas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return pizzas.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = inflater.inflate(R.layout.ligne, null);
        ImageView image = convertView.findViewById(R.id.image);
        ImageView man = convertView.findViewById(R.id.man);
        ImageView clock = convertView.findViewById(R.id.clock);
        TextView nom = convertView.findViewById(R.id.nom);
        TextView nbrIngred = convertView.findViewById(R.id.nbrIngred);
        TextView duree = convertView.findViewById(R.id.duree);
        TextView id = convertView.findViewById(R.id.id);

        image.setImageResource(pizzas.get(position).getPhoto());
        man.setImageResource(R.mipmap.pizza);
        clock.setImageResource(R.mipmap.clock);

        nom.setText(pizzas.get(position).getNom());
        nbrIngred.setText(pizzas.get(position).getNbrIngredients()+"");
        duree.setText(pizzas.get(position).getDuree()+"");

        id.setText(pizzas.get(position).getId()+"");
        return convertView;
    }
}

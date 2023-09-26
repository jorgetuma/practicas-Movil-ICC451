package com.jorgetuma.listartareas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TareaAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<String> tareas;

    public TareaAdapter(Context context, int layout, ArrayList<String> tareas) {
        this.context = context;
        this.layout = layout;
        this.tareas = tareas;
    }

    @Override
    public int getCount() {
        return this.tareas.size();
    }

    @Override
    public Object getItem(int position) {
        return this.tareas.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    public void add(String object) {
        tareas.add(object);
    }
    
    public void remove(int index) {
        tareas.remove(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {

        View v = convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        v = layoutInflater.inflate(R.layout.list_view, null);

        String currentName = tareas.get(position);

        TextView textView = (TextView) v.findViewById(R.id.textView);
        textView.setText(currentName);

        return v;
    }
}

package com.example.employes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdapterEmployee extends BaseAdapter {
    Context context;
    List<Employee> lst;

    public AdapterEmployee(Context context, List<Employee> lst) {
        this.context = context;
        this.lst = lst;
    }

    @Override
    public int getCount() {
        return lst.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView tvFName;
        TextView tvLName;
        TextView tvEmail;
        TextView tvAge;
        TextView tvPost;
        TextView tvSalary;

        Employee e = lst.get(position);

        if (convertView==null){
            convertView = LayoutInflater.from(context).inflate(R.layout.list_employe,null);

            tvFName = convertView.findViewById(R.id.tvFirstName);
            tvLName = convertView.findViewById(R.id.tvLastName);
            tvEmail = convertView.findViewById(R.id.tvEmail);
            tvAge = convertView.findViewById(R.id.tvAge);
            tvPost = convertView.findViewById(R.id.tvPost);
            tvSalary = convertView.findViewById(R.id.tvSalary);

            tvFName.setText(e.getFirstName());
            tvLName.setText(e.getLastName());
            tvEmail.setText(e.getEmail());
            tvAge.setText(Integer.toString(e.getAge()));
            tvPost.setText(e.getPost());
            tvSalary.setText(Integer.toString(e.getSalary()));


        }

        return convertView;
    }
}

package com.ucas.android.parsejson;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ucas.android.parsejson.model.UserExam;

import java.util.List;


public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.MyViewHolder> {

    List<UserExam> users;
    Context context;

    public CustomAdapter2(Context context, List<UserExam> users) {
        this.context = context;
        this.users = users;
    }

    public CustomAdapter2(Activity activity) {
        this.context = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        // set the data in items
        UserExam user = users.get(position);

        holder.name.setText(user.getFirstName()+" "+user.getLastName());
        holder.email.setText(user.getEmail());

    }


    @Override
    public int getItemCount() {
        return users != null ? users.size() : 0;
    }

    public void setData(List<UserExam> userList) {
        this.users = userList;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, email;// init the item view's

        public MyViewHolder(View itemView) {
            super(itemView);

            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            email = (TextView) itemView.findViewById(R.id.email);
        }
    }
}

package nyc.c4q.midterm.controller;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import nyc.c4q.midterm.R;
import nyc.c4q.midterm.view.ListViewHolder;

/**
 * Created by Jose Vila on 12/7/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListViewHolder> {

    ArrayList<Integer> integerArrayList;
    Context context;

    public ListAdapter(ArrayList<Integer> integerArrayList) {
        this.integerArrayList = integerArrayList;
        this.context = context;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview, parent, false);
        return new ListViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        Integer integer = integerArrayList.get(position);
        holder.onBind(integer);
    }

    @Override
    public int getItemCount() {
        return integerArrayList.size();
    }
}

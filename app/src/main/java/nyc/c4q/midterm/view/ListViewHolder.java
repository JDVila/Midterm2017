package nyc.c4q.midterm.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.midterm.ListActivity;
import nyc.c4q.midterm.R;
import nyc.c4q.midterm.view.fragments.MyNumberFragment;

public class ListViewHolder extends ViewHolder{

    TextView textView;
    public ListViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.itemview_textview);
    }

    public void onBind(final Integer integer) {
        textView.setText(Integer.toString(integer));
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyNumberFragment myNumberFragment = new MyNumberFragment();
                FragmentManager fragmentManager = ((ListActivity) itemView.getContext()).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("integer", Integer.toString(integer));
                myNumberFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, myNumberFragment);
                fragmentTransaction.addToBackStack("number");
                fragmentTransaction.commit();
            }
        });
    }
}

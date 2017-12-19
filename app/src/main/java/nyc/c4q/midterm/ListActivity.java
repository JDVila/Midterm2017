package nyc.c4q.midterm;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nyc.c4q.midterm.view.fragments.MyListFragment;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        MyListFragment listFragment = new MyListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("username", username);
        listFragment.setArguments(bundle);

        fragmentTransaction.add(R.id.fragment_container, listFragment);
        fragmentTransaction.commit();
    }
}

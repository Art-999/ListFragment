package com.example.arturmusayelyan.listfragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListAdapterClick {
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        addFragment();
    }

    @Override
    public void click(View view, int position) {
        Toast.makeText(this, "Clicked at position " + (position + 1), Toast.LENGTH_SHORT).show();
    }

    public void addFragment() {
        FragmentTransaction transaction = manager.beginTransaction();
        MyListFragment listFragment = MyListFragment.newInstance();
        transaction.add(R.id.frame_container, listFragment, "addFragment");
        transaction.commit();
    }
}

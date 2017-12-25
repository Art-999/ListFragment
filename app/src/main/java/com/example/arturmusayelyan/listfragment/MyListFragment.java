package com.example.arturmusayelyan.listfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

/**
 * Created by artur.musayelyan on 25/12/2017.
 */

public class MyListFragment extends ListFragment implements AdapterView.OnItemClickListener {
    private ListAdapterClick click;
    public MyListFragment() {

    }

    public static MyListFragment newInstance() {
        Bundle args = new Bundle();
        MyListFragment fragment = new MyListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.my_list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        click=(ListAdapterClick) getActivity();
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(), R.array.heroes, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(getActivity(),"Clicked at position "+(position+1),Toast.LENGTH_SHORT).show();
        click.click(view,position);
    }
}

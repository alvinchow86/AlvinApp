package com.example.sandbox;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


public class ItemsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    Callbacks mListener;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        String[] items = {"Dispatch","Merchant","Consumer","Driver"};

        ListView listView = (ListView) getView().findViewById(R.id.list);
        ArrayAdapter listAdapter = new ArrayAdapter<String>(getActivity(),
                     android.R.layout.simple_list_item_activated_1, items);
        listView.setAdapter(listAdapter);


        //setListAdapter(new ArrayAdapter<String>(getActivity(),
         //       android.R.layout.simple_list_item_activated_1, items));



    }

    public interface Callbacks{
        public void onItemSelected(long id);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (Callbacks) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + "must implement Callbacks");
        }
    }

    /*
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //string stringId = Long.toString(id);
        //ListAdapter adapter;
        System.out.println(id);

        //adapter = getListAdapter();


        mListener.onItemSelected(id);
    }
    */


}

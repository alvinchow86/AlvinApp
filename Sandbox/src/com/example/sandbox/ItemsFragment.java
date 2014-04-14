package com.example.sandbox;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;


public class ItemsFragment extends Fragment {

    Button b1;
    Callbacks mListener;
    EditText editText;
    //String[] items = {"Dispatch","Merchant","Consumer","Driver"};
    ArrayList<String> items = new ArrayList<String>();
    ListView listView;
    ArrayAdapter listAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_list, container, false);

        b1 = (Button) view.findViewById(R.id.button);
        b1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
               System.out.println("CLICKED");
               addNewItem(v);
            }
        });
        editText = (EditText) view.findViewById(R.id.edit_text);

        items.add("Dispatch");
        items.add("Merchant");
        items.add("Consumer");
        items.add("Driver");

        return view;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //String[] items = {"Dispatch","Merchant","Consumer","Driver"};

        listView = (ListView) getView().findViewById(R.id.list);
        listAdapter = new ArrayAdapter<String>(getActivity(),
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

    public void addNewItem(View view) {
        //EditText editText = (EditText) getView().findViewById(R.id.edit_text);
        String theText = editText.getText().toString();
        Log.d("Sandbox", theText);
        items.add(theText);
        listAdapter.notifyDataSetChanged();

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

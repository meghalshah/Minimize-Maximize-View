package com.meghal.shah.playfragments;

import com.example.playfragments.R;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CustomListFragment extends ListFragment {

	public static final String ARG_SECTION_NUMBER = "section_number";

    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_one,
                container, false);
        listView = (ListView) rootView.findViewById(android.R.id.list);

        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String[] str = new String[100];
        for(int i=0;i<100;i++) str[i] = ""+i;
        
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, str);
        listView.setAdapter(mAdapter);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				SecondFragment newFragment = new SecondFragment();

				((MainActivity)getActivity()).setSecondFragment(newFragment);
				FragmentTransaction transaction = getFragmentManager().beginTransaction();

				// Replace whatever is in the fragment_container view with this fragment,
				// and add the transaction to the back stack so the user can navigate back
				transaction.replace(R.id.fragment_container2, newFragment);
				transaction.addToBackStack(null);

				// Commit the transaction
				transaction.commit();
				
				Toast.makeText(getActivity(), "Fragment Added", Toast.LENGTH_SHORT).show();

				
			}
		});
    }
    
}

package com.hexabyte.demo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DatabaseError;

import com.hexabyte.demo.signUpFragment.OnFragmentInteractionListener;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link loginFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link loginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class loginFragment extends Fragment implements OnFragmentInteractionListener,View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public loginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment loginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static loginFragment newInstance(String param1, String param2) {
        loginFragment fragment = new loginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public DatabaseReference ref;
    TextView demoValue;
    public Button lBtn;
    public EditText idTxt,passTxt;
    public TextView suTxtClick;

    //Attempted Retrieval of previous Sign Up Fragment; Unsuccessful
    /*
    //From Sign Up Fragment
    public EditText nameTxt,addTxt,ageTxt;
    public Button sBtn;
    public TextView lgnTxtClick;
    */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_login, container, false);
        idTxt=view.findViewById(R.id.idTxt);
        passTxt=view.findViewById(R.id.passTxt);
        lBtn=view.findViewById(R.id.loginBtn);
        suTxtClick=view.findViewById(R.id.signupTextClick);

        /*
        sBtn=view.findViewById(R.id.signupBtn);
        nameTxt=view.findViewById(R.id.signupNameTxt);
        ageTxt=view.findViewById(R.id.signupAgeTxt);
        addTxt=view.findViewById(R.id.signupAddTxt);
        lgnTxtClick=view.findViewById(R.id.loginTextClick);
        */

        /*
        demoValue=view.findViewById(R.id.textView2);
        lBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ref.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String value = dataSnapshot.getValue(String.class);
                        demoValue.setText(value);
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        });
        */

        suTxtClick.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                idTxt.setVisibility(View.INVISIBLE);
                passTxt.setVisibility(View.INVISIBLE);
                lBtn.setVisibility(View.INVISIBLE);
                suTxtClick.setVisibility(View.INVISIBLE);

                /*
                sBtn.setVisibility(View.VISIBLE);
                nameTxt.setVisibility(View.VISIBLE);
                ageTxt.setVisibility(View.VISIBLE);
                addTxt.setVisibility(View.VISIBLE);
                lgnTxtClick.setVisibility(View.VISIBLE);
                */

                //Error
                /*
                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right).replace(R.id.signupLayout,new signUpFragment());
                t.commit();
                */
            }
        });

        return view;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View view) {
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}

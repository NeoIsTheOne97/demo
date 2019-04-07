package com.hexabyte.demo;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.support.v4.app.FragmentTransaction;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link signUpFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link signUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class signUpFragment extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public signUpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment signUpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static signUpFragment newInstance(String param1, String param2) {
        signUpFragment fragment = new signUpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    public void onClick(View view) {

    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public User user;
    public Button sBtn;
    public DatabaseReference ref;
    public EditText nameTxt,addTxt,ageTxt;
    public TextView lgnTxtClick;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_sign_up, container, false);
        sBtn=view.findViewById(R.id.signupBtn);
        nameTxt=view.findViewById(R.id.signupNameTxt);
        ageTxt=view.findViewById(R.id.signupAgeTxt);
        addTxt=view.findViewById(R.id.signupAddTxt);
        lgnTxtClick=view.findViewById(R.id.loginTextClick);

        ref= FirebaseDatabase.getInstance().getReference().child("Users");

        sBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String nt=nameTxt.getText().toString();
                int at=Integer.parseInt(ageTxt.getText().toString());
                String adt=addTxt.getText().toString();
                user=new User(nt,at,adt);

                ref.push().setValue(user);

                Toast toast=Toast.makeText(getActivity(),"Clicked",Toast.LENGTH_LONG);
                toast.show();

                nameTxt.setText("");
                ageTxt.setText("");
                addTxt.setText("");

            }
        });

        lgnTxtClick.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //MUST change this in the future
                sBtn.setVisibility(View.INVISIBLE);
                nameTxt.setVisibility(View.INVISIBLE);
                ageTxt.setVisibility(View.INVISIBLE);
                addTxt.setVisibility(View.INVISIBLE);
                lgnTxtClick.setVisibility(View.INVISIBLE);

                FragmentTransaction t = getFragmentManager().beginTransaction();
                t.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right).replace(R.id.signupLayout,new loginFragment());
                t.commit();
            }
        });
        return view;
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

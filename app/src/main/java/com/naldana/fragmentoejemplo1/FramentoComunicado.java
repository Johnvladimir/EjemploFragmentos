package com.naldana.fragmentoejemplo1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FramentoComunicado.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FramentoComunicado#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FramentoComunicado extends Fragment {
    private static final String ARG_TEXTO = "mensaje";

    private String message;

    private OnFragmentInteractionListener mListener;

    public FramentoComunicado() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param message Parameter 1
     * @return A new instance of fragment FramentoComunicado.
     */
    public static FramentoComunicado newInstance(String message) {
        FramentoComunicado fragment = new FramentoComunicado();
        Bundle args = new Bundle();
        args.putString(ARG_TEXTO, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            message = getArguments().getString(ARG_TEXTO);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_framento_comunicado, container, false);

        ((TextView) view.findViewById(R.id.text_message)).setText(message);
        ((Button) view.findViewById(R.id.btn_close)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed();
            }
        });
        return view;
    }


    public void onButtonPressed() {
        if (mListener != null) {
            mListener.onTouchClose();
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
        void onTouchClose();
    }
}

package renderper.api.dmantial.com.mapas;

import android.app.Dialog;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;


public class lugarFragment extends DialogFragment {
    public static  final  String ARGUMENTO_TITLE ="TITLE";
    public static  final  String ARGUMENTO_FULL_SNIPPET ="TITLE";
    private String title;
    private String fullSnipper;

    public  static  lugarFragment newInstance(String title,String fullSnipper){
        lugarFragment fragment = new lugarFragment();
        Bundle b =  new Bundle();
        b.putString(ARGUMENTO_TITLE,title);
        b.putString(ARGUMENTO_FULL_SNIPPET,fullSnipper);
        fragment.setArguments(b);
        return fragment;

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog= new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setMessage(fullSnipper)
                .create();
        return dialog;
    }
}

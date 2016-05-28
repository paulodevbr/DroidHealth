package app.com.bugdroidbuilder.paulo.droidhealth.view.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import app.com.bugdroidbuilder.paulo.droidhealth.R;
import app.com.bugdroidbuilder.paulo.droidhealth.controller.HealthController;
import app.com.bugdroidbuilder.paulo.droidhealth.view.SettingsActivity;

public class ProfileFragment extends Fragment {
    HealthController healthController = new HealthController();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.profile_fragment, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        defineConfigButton();

    }

    /**
     * create a listener to a "insert data" button, that goes directly to SettingsActivity
     */
    private void defineConfigButton(){
        Button btConfig = (Button) getActivity().findViewById(R.id.bt_go_settings);

        btConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SettingsActivity.class));
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        healthController.showReview(getActivity());
    }



}

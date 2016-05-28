package app.com.bugdroidbuilder.paulo.droidhealth.view.advices;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import app.com.bugdroidbuilder.paulo.droidhealth.R;

public class AdvicesFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.advices_fragment, container, false);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        startSleepAdviceListener();
        startEatingAdviceListener();

    }
    private void startSleepAdviceListener(){
        LinearLayout slepnesscard = (LinearLayout) getActivity().findViewById(R.id.card_sleep_advices);
        slepnesscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SlepnessAdvicesActivity.class));
            }
        });
    }

    private void startEatingAdviceListener(){
        LinearLayout eatingCard = (LinearLayout) getActivity().findViewById(R.id.card_eating_advices);
        eatingCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EatingAdvicesActivity.class));
            }
        });
    }
}
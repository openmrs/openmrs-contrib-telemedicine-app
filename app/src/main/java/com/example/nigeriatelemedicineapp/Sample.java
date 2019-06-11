package com.example.nigeriatelemedicineapp;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import com.example.nigeriatelemedicineapp.dashboard.DashBoardViewModel;


public class Sample extends AppCompatActivity {

    private DashBoardViewModel DashBoardActivityViewModel = null;

//    String action = "{ \"identifiers\": [{ \"identifier\":\"" + patientId + "\", "
//            + "\"identifierType\":\"05a29f94-c0ed-11e2-94be-8c13b969e334\", "
//            + "\"location\":\"aff27d58-a15c-49a6-9beb-d30dcfc0c66e\", " + "\"preferred\": true }], " + "\"person\": { "
//            + "\"gender\": \"M\", " + "\"age\": 49, " + "\"birthdate\": \"1970-01-01T00:00:00.000+0100\", "
//            + "\"birthdateEstimated\": false, " + "\"dead\": false, " + "\"deathDate\": null, "
//            + "\"causeOfDeath\": null, " + "\"names\": [{\"givenName\": \"Thomas\", \"familyName\": \"Smith12\"}] " + "}}"
//
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DashBoardActivityViewModel = ViewModelProviders.of(this).get(DashBoardViewModel.class);
    }
}
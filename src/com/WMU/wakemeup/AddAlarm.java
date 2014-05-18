package com.WMU.wakemeup;
//empty for now
//this will setup alarm service, hopefully i will be able to make
//edit funcionality here aswell, and of course... this will call up and open
//alarm adding/editing view.

//this is not working yet, view and it's actitity must be called.
import android.app.Activity;
import android.os.Bundle;

public class AddAlarm extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
        this.setContentView(R.layout.fragment_main);
    }
}

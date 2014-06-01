package com.trigg.alarmclock;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

public class AlarmListActivity extends ListActivity {

	private AlarmListAdapter mAdapter;
	private AlarmDBHelper dbHelper = new AlarmDBHelper(this);
	private Context mContext;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mContext = this;
		
		requestWindowFeature(Window.FEATURE_ACTION_BAR);
		
		//setContentView(R.layout.activity_alarm_list);

		mAdapter = new AlarmListAdapter(this, dbHelper.getAlarms());
		
		setListAdapter(mAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.alarm_list, menu);
		return true;
	}//creates buttons in action bar
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
			case R.id.action_add_new_alarm: {
				startAlarmDetailsActivity(-1);
				break;
			}
		}

		return super.onOptionsItemSelected(item);
	}//works with buttons in action bar, 
	//calls those functions or views, whatever i need
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		if (resultCode == RESULT_OK) {
	        mAdapter.setAlarms(dbHelper.getAlarms());
	        mAdapter.notifyDataSetChanged();
	    }
	}
	
	public void setAlarmEnabled(long id, boolean isEnabled) {
		AlarmManagerHelper.cancelAlarms(this);
		
		AlarmModel model = dbHelper.getAlarm(id);
		model.isEnabled = isEnabled;
		dbHelper.updateAlarm(model);
		
		AlarmManagerHelper.setAlarms(this);
	}

	public void startAlarmDetailsActivity(long id) {
		Intent intent = new Intent(this, AlarmDetailsActivity.class);
		intent.putExtra("id", id);
		startActivityForResult(intent, 0);
	}
	
	public void deleteAlarm(long id) {
		 		final long alarmId = id;
		 		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		 		builder.setMessage("Please confirm")
		 		.setTitle("Delete set?")
		 		.setCancelable(true)
		 		.setNegativeButton("Cancel", null)
		 		.setPositiveButton("Ok", new OnClickListener() {
		 			@Override
		 			public void onClick(DialogInterface dialog, int which) {
		 				//Cancel Alarms
		 				
		 				AlarmManagerHelper.cancelAlarms(mContext);
		 				//Delete alarm from database by its id
		 				dbHelper.deleteAlarm(alarmId);
		 				//Showing the new list of alarms
		 				mAdapter.setAlarms(dbHelper.getAlarms());
		 				//and here the alarm dissapears from view:
		 				mAdapter.notifyDataSetChanged();
		 			
		 			}
		 		}).show();
		 	}
	
}

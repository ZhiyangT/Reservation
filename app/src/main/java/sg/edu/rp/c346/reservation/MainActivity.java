package sg.edu.rp.c346.reservation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

        EditText etName;
        EditText etPNo;
        EditText etSize;
        CheckBox cbSmoking;
        DatePicker dp;
        TimePicker tp;
        Button bConfirm;
        Button bReset;
        TextView tvDisplay;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.Name);
        etPNo = findViewById(R.id.PNo);
        etSize = findViewById(R.id.Size);
        cbSmoking = findViewById(R.id.Smoking);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        bConfirm = findViewById(R.id.Confirm);
        bReset = findViewById(R.id.Reset);
        tvDisplay = findViewById(R.id.display);








        bConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String smoking = "";

                if(cbSmoking.isChecked()){
                    smoking = "Smoking Area";
                }else{
                    smoking = "Non Smoking Area";
                }

                int year=0;
                int month=0;
                int day=0;

                year = dp.getYear();
                month = dp.getMonth()+1;
                day = dp.getDayOfMonth();

                String date =String.valueOf(day)+ "/"+ String.valueOf(month)+"/"+ String.valueOf(year);

                int hour = 0;
                int minute =0;
                hour = tp.getCurrentHour();
                minute = tp.getCurrentMinute();

                String time = String.valueOf(hour)+":"+String.valueOf(minute);

                String overview = String.format("Reservation: \nName: %s, Pax: %s, Mobile: %s, Area: %s, Date: %s, Time: %s",etName.getText().toString().trim(), etSize.getText().toString().trim(),etPNo.getText().toString().trim(), smoking.trim(), date.trim(),time.trim());

                Toast.makeText(MainActivity.this, overview, Toast.LENGTH_SHORT).show();

            }
        });


        bReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearFields();
                setDefaultTime();

            }
        });


    }

    public void setDefaultTime(){
        tp.setCurrentHour(19);
        tp.setCurrentMinute(30);
        dp.updateDate(2019,5,01);

    }

    public void clearFields(){
        etName.setText("");
        etPNo.setText("");
        etSize.setText("");
        cbSmoking.setChecked(false);
    }
}

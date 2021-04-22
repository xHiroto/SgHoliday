package sg.edu.rp.c346.id19045784.sgholiday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lv;
    TextView tv;
    ArrayList<Holiday> al;
    ArrayAdapter<Holiday> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv = (TextView) findViewById(R.id.textView2);
        lv = (ListView) findViewById(R.id.lvday);

        Intent i = getIntent();
        String title = i.getStringExtra("type");
        tv.setText(title);

        al = new ArrayList<Holiday>();

        if (title.equals("Secular")){
            al.add(new Holiday("New Year's Day", "new_year", "1 Jan 2021"));
            al.add(new Holiday("Labour Day", "labour_day", "1 May 2021"));
            al.add(new Holiday("National Day", "national_day", "9 August 2021"));
            al.add(new Holiday("Christmas", "christmas", "25 December 2021"));
        }
        else if (title.equals("Ethnic & Religion")){
            al.add(new Holiday("Christmas", "christmas", "25 December 2021"));
        }

        aa = new HolidayAdapter(this, R.layout.row2, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SecondActivity.this, al.get(position).getName() + " Date: " + al.get(position).getDate(), Toast.LENGTH_LONG).show();
            }
        });

    }

}

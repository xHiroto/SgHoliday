package sg.edu.rp.c346.id19045784.sgholiday;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {

    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvHolidayName, date;
    private ImageView icon;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holiday = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row2, parent, false);

        // Get the TextView object
        tvHolidayName = (TextView) rowView.findViewById(R.id.holidayText);
        date = (TextView) rowView.findViewById(R.id.dateText);
        // Get the ImageView object
        icon = (ImageView) rowView.findViewById(R.id.imageView);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holiday currentHoliday = holiday.get(position);

        // Set the TextView to show the day
        tvHolidayName.setText(currentHoliday.getName());

        //set the TextView to show the date
        date.setText(currentHoliday.getDate());

        //set the image
        if (currentHoliday.getImage() == "labour_day"){
            icon.setImageResource(R.drawable.labour_day);
        }
        else if (currentHoliday.getImage() == "new_year"){
            icon.setImageResource(R.drawable.new_year);
        }
        else if (currentHoliday.getImage() == "christmas"){
            icon.setImageResource(R.drawable.christmas);
        }
        else if (currentHoliday.getImage() == "national_day"){
            icon.setImageResource(R.drawable.national_day);
        }


        // Return the nicely done up View to the ListView
        return rowView;
    }

}

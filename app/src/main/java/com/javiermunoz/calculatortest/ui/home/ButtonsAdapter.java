package com.javiermunoz.calculatortest.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.javiermunoz.calculatortest.R;

/**
 * Created by javier.munoz on 23/12/14.
 */
public class ButtonsAdapter extends BaseAdapter {

    private LayoutInflater inflater;

    public ButtonsAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return AppConstants.numbers.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView button;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            button = (TextView) inflater.inflate(R.layout.view_button_item, parent, false);
        } else {
            button = (TextView) convertView;
        }
        button.setText(AppConstants.numbers[position]);
        return button;
    }
}

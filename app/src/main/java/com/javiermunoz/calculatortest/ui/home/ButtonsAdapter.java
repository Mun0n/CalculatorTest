package com.javiermunoz.calculatortest.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.javiermunoz.calculatortest.R;

/**
 * Created by javier.munoz on 23/12/14.
 */
public class ButtonsAdapter extends BaseAdapter {

  private Context context;
  private LayoutInflater inflater;

  static final String[] numbers = new String[] {
      "7", "8", "9", "/", "4", "5", "6", "X", "1", "2", "3", "-", ",", "0", "=", "+"
  };

  public ButtonsAdapter(Context context) {
    this.context = context;
    inflater = LayoutInflater.from(context);
  }

  @Override public int getCount() {
    return numbers.length;
  }

  @Override public Object getItem(int position) {
    return null;
  }

  @Override public long getItemId(int position) {
    return 0;
  }

  @Override public View getView(int position, View convertView, ViewGroup parent) {
    TextView button;
    if (convertView == null) {  // if it's not recycled, initialize some attributes
      button = (TextView) newView(inflater, position, parent);
    } else {
      button = (TextView) convertView;
    }
    button.setText(numbers[position]);
    return button;
  }

  private View newView(LayoutInflater inflater, int position, ViewGroup parent) {
    return inflater.inflate(R.layout.view_button_item, parent, false);
  }

}

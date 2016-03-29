package me.zaicheng.example.myspinner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vmlinz on 3/29/16.
 */
public class MySpinnerAdapter extends BaseAdapter {
    private List<String> mItems = new ArrayList<>();

    public void addItem(String item) {
        mItems.add(item);
    }

    public void addItems(List<String> items) {
        mItems.addAll(items);
    }

    public void clear() {
        mItems.clear();
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public String getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null || !view.getTag().toString().equals("ITEM"))  {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            view = inflater.inflate(R.layout.spinner_item, viewGroup, false);
            view.setTag("ITEM");
        }

        TextView textView = (TextView) view.findViewById(android.R.id.text1);
        textView.setText(getTitle(i));

        return view;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        if (convertView == null || !convertView.getTag().toString().equals("DROPDOWN_ITEM"))  {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            convertView = inflater.inflate(R.layout.spinner_dropdown_item, parent, false);
            convertView.setTag("DROPDOWN_ITEM");
        }

        TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
        textView.setText(getTitle(position));

        return convertView;
    }

    private String getTitle(int i) {
        return i >= 0 && i < mItems.size() ? mItems.get(i) : "";
    }
}

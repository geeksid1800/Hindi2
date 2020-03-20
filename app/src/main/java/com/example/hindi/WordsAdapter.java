package com.example.hindi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WordsAdapter extends ArrayAdapter {

    //Check out Custom Adapters on here to understand the code better
    // https://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView#using-a-basic-arrayadapter

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param  pWords A List of 'Words' objects to display in a list
     */

    public WordsAdapter(Context context, ArrayList<Words> pWords) {
        super(context,0, pWords);
    }

    // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
    // the second argument is used when the ArrayAdapter is populating a single TextView.
    // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
    // going to use this second argument, so it can be any value. Here, we used 0.


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        /**
         * Provides a view for an AdapterView (ListView, GridView, etc.)
         *
         * @param position The position in the list of data that should be displayed in the
         *                 list item view.
         * @param convertView The recycled view to populate.
         * @param parent The parent ViewGroup that is used for inflation.
         * @return The View for the position in the AdapterView.
         */

        View listItemView = convertView;

        // Check if the existing view is being reused, otherwise inflate the view
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Words} object located at this position in the list
        Words my_word= (Words)getItem(position);
        TextView hindiTextView = (TextView) listItemView.findViewById(R.id.HindiTextView);
        hindiTextView.setText(my_word.getHindiTranslation());
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.DefaultTextView);
        defaultTextView.setText(my_word.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID IconImageView
        ImageView iconView = (ImageView) listItemView.findViewById(R.id.IconImageView);
        // Get the image resource ID from the current 'Words' object and
        // set the image to iconView
        if(my_word.hasImage()==false){                  //calling hasImage fn on my_word. Returns true if it does
            iconView.setVisibility(View.GONE);
        } else {
            iconView.setImageResource(my_word.getImageResourceID());
        }

        return listItemView;
    }
}

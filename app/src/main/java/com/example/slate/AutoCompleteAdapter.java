package com.example.slate;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteAdapter extends ArrayAdapter<DictionaryItem> {

    //Copy og Dictionary List
    private List<DictionaryItem> dictionaryItemsFull;

    public AutoCompleteAdapter(@NonNull Context context , @NonNull List<DictionaryItem> dictionaryList) {
        super(context, 0, dictionaryList);

        dictionaryItemsFull = new ArrayList<>(dictionaryList);

    }

    public Filter getFilter() {
        return wordsFilter;
    }


    @NonNull
    @Override
    //GET THE CUSTOM VIEW
    public View getView(int position, @Nullable View convertView,  @NonNull ViewGroup parent) {

        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.suggestion,parent,false
            );

            TextView textViewName = convertView.findViewById(R.id.text);
            ImageView imageViewImage = convertView.findViewById(R.id.image);

            //Create Reference
            DictionaryItem dictionaryItem = getItem(position);

            if (dictionaryItem != null) {
                textViewName.setText(dictionaryItem.getWordName());
            }
        }


        return convertView;
    }

    //FILTER LOGIC STARS HERE
    private Filter wordsFilter = new Filter() {
        @Override
        //PUT FILTERING LOGIC
        protected FilterResults performFiltering(CharSequence constraint)
        {
            //RETURN FILTER RWSULTS OBJECT
            FilterResults results  = new FilterResults(); //It implies that it keeps continuing filter results
            List<DictionaryItem> suggestions = new ArrayList<>();

            //Validation for when nothing was typed in
            if (constraint == null || constraint.length() == 0)
            {
                suggestions.addAll(dictionaryItemsFull);
            }
            else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                //check the whole dictionary list and check what fits to the String filterPattern
                for (DictionaryItem item : dictionaryItemsFull)
                {
                    if (item.getWordName().toLowerCase().contains(filterPattern))
                    {
                        suggestions.add(item); //Here add sign conversion logic
                    }
                }
            }

            results.values = suggestions;
            results.count = suggestions.size();

            return results;
        }

        //GET FILTER ITEM IN ARRAY LIST
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            clear();
            addAll((List)results.values);  //Need Signs to publish
            notifyDataSetChanged();
        }

        @Override
        public CharSequence convertResultToString(Object resultValue) {

            //When item is clicked put into the input box
            return ((DictionaryItem)resultValue).getWordName(); //This will take input of the item that is clicked and put it in input box
            //Validation for put signs in Linear Layout...
        }
    };

}

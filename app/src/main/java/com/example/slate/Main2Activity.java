package com.example.slate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    private static final String TAG = "Main2Activity";

    private ArrayList<Integer> mSigns = new ArrayList<Integer>();
    ImageView[] image;

    private ArrayList<Integer>  imagesArray = new ArrayList<Integer>();

    ImageButton sendBtn;
    EditText message;
    LinearLayout convert;

    String input;
    int myIndex = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sendBtn = (ImageButton) findViewById(R.id.send_message_btn);
        message = (EditText)findViewById(R.id.message);
        convert = (LinearLayout)findViewById(R.id.convert_linear_layout);




        fillAlphabets();

//        stringCheck();

        initSigns();

        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
               // myIndex++;

                getImages();
            }
        });

    }


    private void initSigns(){
        mSigns.add(R.drawable.s_a);
        mSigns.add(R.drawable.s_b);
        mSigns.add(R.drawable.s_c);
        mSigns.add(R.drawable.s_d);
        mSigns.add(R.drawable.s_e);
        mSigns.add(R.drawable.s_f);
        mSigns.add(R.drawable.s_g);
        mSigns.add(R.drawable.s_h);
        mSigns.add(R.drawable.s_i);
        mSigns.add(R.drawable.s_j);
        mSigns.add(R.drawable.s_k);
        mSigns.add(R.drawable.s_l);
        mSigns.add(R.drawable.s_m);
        mSigns.add(R.drawable.s_n);
        mSigns.add(R.drawable.s_o);
        mSigns.add(R.drawable.s_p);
        mSigns.add(R.drawable.s_q);
        mSigns.add(R.drawable.s_r);
        mSigns.add(R.drawable.s_s);
        mSigns.add(R.drawable.s_t);
        mSigns.add(R.drawable.s_u);
        mSigns.add(R.drawable.s_v);
        mSigns.add(R.drawable.s_w);
        mSigns.add(R.drawable.s_x);
        mSigns.add(R.drawable.s_y);
        mSigns.add(R.drawable.s_z);

        initRecyclerView();
    }



    private void initRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mSigns );
        recyclerView.setAdapter(adapter);
    }


 /*   private void initImages(){
        image = new ImageView[input.length()];

        for (int i = 0; i < input.length(); i++) {

            image[i] = new ImageView(this);
            image[i].setImageResource(R.drawable.s_o);
            LinearLayout.LayoutParams layoutParams90 = new LinearLayout.LayoutParams(
                    225, 250);
            layoutParams90.leftMargin = 25;
            image[i].setLayoutParams(layoutParams90);


        }
    }*/


    private void initEmptyRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(linearLayoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mSigns );
        recyclerView.setAdapter(adapter);
    }



    private void fillAlphabets()
    {
       /* alphabets = new ArrayList<>();
        alphabets.add(new Alphabets(0,R.drawable.s_a));
        alphabets.add(new Alphabets(1,R.drawable.s_b));
        alphabets.add(new Alphabets(2,R.drawable.s_c));
        alphabets.add(new Alphabets(3,R.drawable.s_d));
        alphabets.add(new Alphabets(4,R.drawable.s_e));
        alphabets.add(new Alphabets(5,R.drawable.s_f));
        alphabets.add(new Alphabets(6,R.drawable.s_g));
        alphabets.add(new Alphabets(7,R.drawable.s_h));
        alphabets.add(new Alphabets(8,R.drawable.s_i));
        alphabets.add(new Alphabets(9,R.drawable.s_j));
        alphabets.add(new Alphabets(10,R.drawable.s_k));
        alphabets.add(new Alphabets(11,R.drawable.s_l));
        alphabets.add(new Alphabets(12,R.drawable.s_m));
        alphabets.add(new Alphabets(13,R.drawable.s_n));
        alphabets.add(new Alphabets(14,R.drawable.s_o));
        alphabets.add(new Alphabets(15,R.drawable.s_p));
        alphabets.add(new Alphabets(16,R.drawable.s_q));
        alphabets.add(new Alphabets(17,R.drawable.s_r));
        alphabets.add(new Alphabets(18,R.drawable.s_s));
        alphabets.add(new Alphabets(19,R.drawable.s_t));
        alphabets.add(new Alphabets(20,R.drawable.s_u));
        alphabets.add(new Alphabets(21,R.drawable.s_v));
        alphabets.add(new Alphabets(22,R.drawable.s_w));
        alphabets.add(new Alphabets(23,R.drawable.s_x));
        alphabets.add(new Alphabets(24,R.drawable.s_y));
        alphabets.add(new Alphabets(25,R.drawable.s_z));*/
        imagesArray.add(0,R.drawable.s_a);
        imagesArray.add(1,R.drawable.s_b);
        imagesArray.add(2,R.drawable.s_c);

    }


    public void stringCheck()
    {

        input = message.getText().toString();

        int l =0;


        for (int i = 0; i <input.length() ; i++)
        {
         if (input.toCharArray()[i]=='a')
         {
             myIndex=0;
         }
         else if (input.toCharArray()[i]=='b')
         {
             myIndex=1;
         }
        }




    }

    private void getImages ()
    {

       LinearLayout layout = (LinearLayout)findViewById(R.id.convert_linear_layout);

            input = message.getText().toString();



            for (int i = 0; i <input.length() ; i++)
            {
                if (input.toCharArray()[i] == 'a') {
                    myIndex = 0;
                } else if (input.toCharArray()[i] == 'b') {
                    myIndex = 1;
                }else if (input.toCharArray()[i] == 'c') {
                    myIndex = 2;
                }
                ImageView imageView = new ImageView(this);
                imageView.setMaxHeight(20);
                imageView.setMaxWidth(20);
                imageView.setImageResource(imagesArray.get(myIndex));

                // Adds the view to the layout
                layout.addView(imageView);


            }



           // View view = inflater.inflate(R.layout.item, convert, false);
           // ImageView image = view.findViewById(R.id.message_item);


            Log.d(TAG, "Index: " + myIndex);
               // image.setImageResource(imagesArray.get(myIndex));

               // convert.addView(view);

           // convert.removeView(view);
            message.append(imagesArray.toString());


    }


  /*   private void converter (String input){



        int l= 0;

         while (l==input.length())
         {
             for (int i=0;i<26;i++){



                if (input.charAt(l) ==  alphabets.toString().charAt(i))
                {
                    LayoutInflater inflater = LayoutInflater.from(Main2Activity.this);

                    View view = inflater.inflate(R.layout.item, convert, false);
                    ImageView image = view.findViewById(R.id.message_item);
                    image.setImageResource(R.drawable.s_0);

                    convert.addView(view);

                    i=0;
                    l++;
                }


             }
         }

    } */

}

package com.example.slate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   //INITIALIZING LOST OF DICTIONARY ITEM
    private List<DictionaryItem> dictionaryList;

    //ARRAY LIST TO STORE WORDS AGAINST THE IMAGES
    private ArrayList<String> words = new ArrayList<String>();

    ImageButton sendBtn,btn_numbers, btn_alpabets;
    TextView displayWords,sendText;

    AutoCompleteTextView correspondingText;

    //Image buttons for numeric keyboard
    ImageButton bt0, bt1,bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9, bt10,space,back;
    ImageButton bta, btb,btc, btd, bte, btf, btg, bth, bti, btj, btk, btl, btm, btn, bto,btp,btq,btr,bts,btt,btu,btv,btw,btx,bty,btz,spaceAlph, backAlph;

    LinearLayout sendImage;
    LinearLayout linearLayout;

    int tab=0, index =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendBtn = (ImageButton) findViewById(R.id.send_message_btn);
        sendImage = (LinearLayout) findViewById(R.id.input_message);
        displayWords = (TextView)findViewById(R.id.display_words);
        sendText = (TextView)findViewById(R.id.send_text);
        correspondingText = (AutoCompleteTextView)findViewById(R.id.corresponding_text);

        InitializeScrollView();


        fillDictionaryListA();

        //CREATE INSTANCE OF ADAPTER
        AutoCompleteAdapter adapter = new AutoCompleteAdapter(this,dictionaryList);
        correspondingText.setAdapter(adapter);

        btn_numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this,"Numbers are selected",Toast.LENGTH_SHORT).show();
                if (tab ==2)
                {
                    linearLayout.removeAllViews();
                }

                InitializeNumbersKeyboard();
            }
        });



        btn_alpabets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(MainActivity.this,"Alphabets are selected",Toast.LENGTH_SHORT).show();

                if (tab ==1)
                {
                    linearLayout.removeAllViews();
                }

                InitializeAplhabetsKeyboard();

            }
        });


        //Adding Typed words in Text Field

        final CharSequence[] charSequenceItems = words.toArray(new CharSequence[words.size()]);
        for(int i=0;i<words.size();i++)
        {
            displayWords.append(charSequenceItems[i]);
        }



        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                tab = 0;
                index=0;
                //onDelete(mainView);
                sendImage.removeAllViews();
                linearLayout.removeAllViews();

                correspondingText.getText().clear();
            }
        });



    }



    private void InitializeScrollView()
    {
        //GET custom_chat_bar LAYOUT
        LayoutInflater inflater = getLayoutInflater();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.chat_linear_layout);
        final View view = inflater.inflate(R.layout.horizontal_scrollview,null);

        btn_numbers = (ImageButton)findViewById(R.id.btn_numbers);
        btn_alpabets = (ImageButton)findViewById(R.id.btn_alphabets);

    }



    private void InitializeNumbersKeyboard()
    {
        tab = 1;
        final LayoutInflater inflater = getLayoutInflater();
        linearLayout = (LinearLayout) findViewById(R.id.keyboard_linear_layout);
        //linearLayout.setVisibility(View.VISIBLE);
        final View view = inflater.inflate(R.layout.sample,null);
        linearLayout.addView(view);



        bt0 = (ImageButton)findViewById(R.id.btn_0);
        bt1 = (ImageButton)findViewById(R.id.btn_1);
        bt2 = (ImageButton)findViewById(R.id.btn_2);
        bt3 = (ImageButton)findViewById(R.id.btn_3);
        bt4 = (ImageButton)findViewById(R.id.btn_4);
        bt5 = (ImageButton)findViewById(R.id.btn_5);
        bt6 = (ImageButton)findViewById(R.id.btn_6);
        bt7 = (ImageButton)findViewById(R.id.btn_7);
        bt8 = (ImageButton)findViewById(R.id.btn_8);
        bt9 = (ImageButton)findViewById(R.id.btn_9);
        bt10 = (ImageButton)findViewById(R.id.btn_10);
        space = (ImageButton)findViewById(R.id.btn_space);
        back = (ImageButton)findViewById(R.id.btn_remove);

        bt0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;

                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_0);

                words.add("0");

               // String i = String.valueOf(index);
               // sendText.setText(i +words.get(index));

                correspondingText.append("0");

                sendImage.addView(view);

                Toast.makeText(MainActivity.this,"TAPPED!",Toast.LENGTH_SHORT).show();
            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;

                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_1);

                words.add("1");

                correspondingText.append("1");

                sendImage.addView(view);


            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_2);

                words.add("2");

                correspondingText.append("2");

                sendImage.addView(view);

            }
        });


        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_3);

                words.add("3");
                displayWords.append("3");

                correspondingText.append("3");

                sendImage.addView(view);

            }
        });

        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_4);

                words.add("4");

                displayWords.append("4");

                correspondingText.append("4");

                sendImage.addView(view);

            }
        });

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_5);

                words.add("5");

                displayWords.append("4");

                correspondingText.append("5");

                sendImage.addView(view);

            }
        });


        bt6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_6);

                words.add("6");

                displayWords.append("4");

                correspondingText.append("6");

                sendImage.addView(view);

            }
        });


        bt7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_7);

                words.add("7");

                displayWords.append("7");

                correspondingText.append("7");

                sendImage.addView(view);

            }
        });

        bt8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_8);

                words.add("8");

                displayWords.append("8");

                correspondingText.append("8");

                sendImage.addView(view);

            }
        });


        bt9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_9);

                words.add("9");

                displayWords.append("9");

                correspondingText.append("9");

                sendImage.addView(view);

            }
        });

        bt10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_10);

                words.add("10");

                displayWords.append("10");

                correspondingText.append("10");

                sendImage.addView(view);

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);

                if (index >0) {
                    sendImage.removeViewAt(index - 1);
                    index--;

                    int length = correspondingText.getText().length();
                    if (length > 0) {
                        correspondingText.getText().delete(length - 1, length);
                    }
                }


            }
        });

        space.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);



            }
        });


    }



    private void InitializeAplhabetsKeyboard()
    {
        tab =2;
        LayoutInflater inflater = getLayoutInflater();
        linearLayout = (LinearLayout) findViewById(R.id.keyboard_linear_layout);
        //linearLayout.setVisibility(View.VISIBLE);
        final View view = inflater.inflate(R.layout.alphabets,null);
        linearLayout.addView(view);



        bta = (ImageButton)findViewById(R.id.btn_a);
        btb = (ImageButton)findViewById(R.id.btn_b);
        btc = (ImageButton)findViewById(R.id.btn_c);
        btd = (ImageButton)findViewById(R.id.btn_d);
        bte = (ImageButton)findViewById(R.id.btn_e);
        btf = (ImageButton)findViewById(R.id.btn_f);
        btg = (ImageButton)findViewById(R.id.btn_g);
        bth = (ImageButton)findViewById(R.id.btn_h);
        bti = (ImageButton)findViewById(R.id.btn_i);
        btj = (ImageButton)findViewById(R.id.btn_j);
        btk = (ImageButton)findViewById(R.id.btn_k);
        btl = (ImageButton)findViewById(R.id.btn_l);
        btm = (ImageButton)findViewById(R.id.btn_m);
        btn = (ImageButton)findViewById(R.id.btn_n);
        bto = (ImageButton)findViewById(R.id.btn_o);
        btp = (ImageButton)findViewById(R.id.btn_p);
        btq = (ImageButton)findViewById(R.id.btn_q);
        btr = (ImageButton)findViewById(R.id.btn_r);
        bts = (ImageButton)findViewById(R.id.btn_s);
        btt = (ImageButton)findViewById(R.id.btn_t);
        btu = (ImageButton)findViewById(R.id.btn_u);
        btv = (ImageButton)findViewById(R.id.btn_v);
        btw = (ImageButton)findViewById(R.id.btn_w);
        btx = (ImageButton)findViewById(R.id.btn_x);
        bty = (ImageButton)findViewById(R.id.btn_y);
        btz = (ImageButton)findViewById(R.id.btn_z);
        spaceAlph = (ImageButton)findViewById(R.id.btn_spaceA);
        backAlph = (ImageButton)findViewById(R.id.btn_removeA);

        bta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;

                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_a);

                words.add("a");

                correspondingText.append("a");

                sendImage.addView(view);

                Toast.makeText(MainActivity.this,"TAPPED!",Toast.LENGTH_SHORT).show();
            }
        });

        btb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index++;

                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_b);

                words.add("b");

                correspondingText.append("b");

                sendImage.addView(view);


            }
        });

        btc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_c);

                words.add("c");

                correspondingText.append("c");

                sendImage.addView(view);

            }
        });


        btd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_d);

                words.add("d");

                correspondingText.append("d");

                sendImage.addView(view);

            }
        });

        bte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_e);

                words.add("e");

                correspondingText.append("e");

                sendImage.addView(view);

            }
        });

        btf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_f);

                words.add("f");

                correspondingText.append("f");

                sendImage.addView(view);

            }
        });


        btg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_g);

                words.add("h");

                correspondingText.append("g");

                sendImage.addView(view);

            }
        });


        bth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_h);

                words.add("h");

                correspondingText.append("h");

                sendImage.addView(view);

            }
        });

        bti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_i);

                words.add("i");

                correspondingText.append("i");

                sendImage.addView(view);

            }
        });


        btj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_j);

                words.add("j");

                correspondingText.append("j");

                sendImage.addView(view);

            }
        });

        btk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_k);

                words.add("k");

                correspondingText.append("k");

                sendImage.addView(view);

            }
        });

        btl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_l);

                words.add("l");

                correspondingText.append("l");

                sendImage.addView(view);

            }
        });

        btm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_m);

                words.add("m");

                correspondingText.append("m");

                sendImage.addView(view);

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_n);

                words.add("n");

                correspondingText.append("n");

                sendImage.addView(view);

            }
        });

        bto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_o);

                words.add("o");

                correspondingText.append("o");

                sendImage.addView(view);

            }
        });

        btp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_p);

                words.add("p");

                correspondingText.append("p");

                sendImage.addView(view);

            }
        });

        btq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_q);

                words.add("q");

                correspondingText.append("q");

                sendImage.addView(view);

            }
        });


        btr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_r);

                words.add("s");

                correspondingText.append("r");

                sendImage.addView(view);

            }
        });

        bts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_s);

                words.add("s");

                correspondingText.append("s");

                sendImage.addView(view);

            }
        });

        btt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_t);

                words.add("t");

                correspondingText.append("t");

                sendImage.addView(view);

            }
        });

        btu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_u);

                words.add("u");

                correspondingText.append("u");

                sendImage.addView(view);

            }
        });

        btv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_v);

                words.add("v");

                correspondingText.append("v");

                sendImage.addView(view);

            }
        });

        btw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_w);

                words.add("w");

                correspondingText.append("w");

                sendImage.addView(view);

            }
        });

        btx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_x);

                words.add("x");

                correspondingText.append("x");

                sendImage.addView(view);

            }
        });

        bty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_y);

                words.add("y");

                correspondingText.append("y");

                sendImage.addView(view);

            }
        });

        btz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                index++;
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);
                image.setImageResource(R.drawable.s_z);

                words.add("z");

                correspondingText.append("z");

                sendImage.addView(view);

            }
        });

        backAlph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);

                if (index >0) {
                    sendImage.removeViewAt(index - 1);
                    index--;

                    int length = correspondingText.getText().length();
                    if (length > 0) {
                        correspondingText.getText().delete(length - 1, length);
                    }
                    else {
                        correspondingText.getText().clear();
                    }
                }


            }
        });

        spaceAlph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sendImage = (LinearLayout)findViewById(R.id.input_message);
                LayoutInflater inflater = LayoutInflater.from(MainActivity.this);

                View view = inflater.inflate(R.layout.item,sendImage,false);
                ImageView image = view.findViewById(R.id.message_item);



            }
        });


    }


 private void fillDictionaryListA()
 {
     dictionaryList = new ArrayList<>();
     dictionaryList.add(new DictionaryItem("Ask"));
     dictionaryList.add(new DictionaryItem("Arm"));
     dictionaryList.add(new DictionaryItem("All"));
     dictionaryList.add(new DictionaryItem("Ankle"));
     dictionaryList.add(new DictionaryItem("Art"));
     dictionaryList.add(new DictionaryItem("Artist"));
     dictionaryList.add(new DictionaryItem("Amazing"));
     dictionaryList.add(new DictionaryItem("Account"));
     dictionaryList.add(new DictionaryItem("Abnormal"));
     dictionaryList.add(new DictionaryItem("Afraid"));
     dictionaryList.add(new DictionaryItem("Available"));
     dictionaryList.add(new DictionaryItem("Accept"));
     dictionaryList.add(new DictionaryItem("Ahead"));
     dictionaryList.add(new DictionaryItem("Apple"));
     dictionaryList.add(new DictionaryItem("According"));
     dictionaryList.add(new DictionaryItem("Abnormal"));
     dictionaryList.add(new DictionaryItem("Accent"));
     dictionaryList.add(new DictionaryItem("Age"));
     dictionaryList.add(new DictionaryItem("Abs"));
     dictionaryList.add(new DictionaryItem("Apps"));
     dictionaryList.add(new DictionaryItem("Application"));
     dictionaryList.add(new DictionaryItem("Apart"));
     dictionaryList.add(new DictionaryItem("Among"));
     dictionaryList.add(new DictionaryItem("Atleast"));
     dictionaryList.add(new DictionaryItem("Attain"));
     dictionaryList.add(new DictionaryItem("Attempt"));
     dictionaryList.add(new DictionaryItem("Assure"));
     dictionaryList.add(new DictionaryItem("Accident"));
     dictionaryList.add(new DictionaryItem("Ant"));
     dictionaryList.add(new DictionaryItem("Aunt"));
     dictionaryList.add(new DictionaryItem("Alive"));
     dictionaryList.add(new DictionaryItem("At"));
     dictionaryList.add(new DictionaryItem("Absent"));
     dictionaryList.add(new DictionaryItem("Assume"));
 }


}

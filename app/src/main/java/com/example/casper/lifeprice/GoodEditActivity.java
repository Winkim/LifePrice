package com.example.casper.lifeprice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GoodEditActivity extends AppCompatActivity {

    private EditText editTextGoodName,editTextGoodPrice;
    private Button buttonOk,buttonCancel;
    private int editPosition;
//    public Intent backIntent;
//    public static GoodEditActivity backTemp = null;

    //public static final int KEYCODE_BACK = 903;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_edit);

        editPosition=getIntent().getIntExtra("edit_position",0);

        editTextGoodName=(EditText)findViewById(R.id.edit_text_good_name);
        editTextGoodPrice=(EditText)findViewById(R.id.edit_text_good_price);
        buttonCancel=(Button)findViewById(R.id.button_cancel);
        buttonOk=(Button)findViewById(R.id.button_ok);

        double goodPrice=getIntent().getDoubleExtra("good_price",-1);
        String goodName= getIntent().getStringExtra("good_name");
        if(goodName!=null) {
            editTextGoodName.setText(goodName);
            editTextGoodPrice.setText(goodPrice+"");
        }


        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("edit_position", editPosition);
                intent.putExtra("good_name", editTextGoodName.getText().toString().trim());
                intent.putExtra("good_price",Double.parseDouble( editTextGoodPrice.getText().toString()));
                setResult(RESULT_OK, intent);
                GoodEditActivity.this.finish();
            }
        });
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoodEditActivity.this.finish();
            }
        });



    }

    @Override
    public void onBackPressed(){
        Intent backIntent = new Intent();
        backIntent.putExtra("edit_position",editPosition);
        backIntent.putExtra("good_name",editTextGoodName.getText().toString());
        backIntent.putExtra("good_price",Double.parseDouble(editTextGoodPrice.getText().toString()));
        setResult(RESULT_OK,backIntent);
        GoodEditActivity.this.finish();
    }

//    @Override
    //重载intent
//    protected void onNewIntent(Intent backIntent){
//        super.onNewIntent(backIntent);
//        setIntent(backIntent);
//    }

//    @Override
    //重载物理返回键
//    public boolean onKeyDown(int keyCode, KeyEvent event)
//    {
//        if(keyCode == KeyEvent.KEYCODE_BACK){
//            String back_name=((EditText)findViewById(R.id.edit_text_good_name)).getText().toString();
//            String back_price=((EditText)findViewById(R.id.edit_text_good_price)).getText().toString();
//
//            backIntent = new Intent(GoodEditActivity.this,LifePriceMainActivity.class);
//            onNewIntent(backIntent);
//            Bundle back_bundle = new Bundle();
//            back_bundle.putCharSequence("back_name",back_name);
//            back_bundle.putCharSequence("back_price",back_price);
//            backIntent.putExtras(back_bundle);
//            startActivity(backIntent);
//
//        }
//        return super.onKeyDown(keyCode,event);
//    }
}

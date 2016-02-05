package com.example.yannie.calorieconverter2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText calorieEdit;
    EditText pushUpEdit;
    EditText sitUpEdit;
    EditText jackEdit;
    EditText jogEdit;
    TextView pushUpView;
    TextView sitUpView;
    TextView jackView;
    TextView jogView;
    TextView calorie;

    String enterField;
    Double enterCount;
    Double pushUpCalPerUnit;
    Double sitUpCalPerUnit;
    Double jackCalPerUnit;
    Double jogCalPerUnit;
    Double calorieCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pushUpCalPerUnit = 0.285;
        sitUpCalPerUnit = 0.50;
        jackCalPerUnit = 10.00;
        jogCalPerUnit = 8.30;

        calorie = (TextView) findViewById(R.id.calorie);
        calorie.setVisibility(View.GONE);
        enterField = "none";
        enterCount = 0.0;
        calorieCount = 0.0;

        calorieEdit = (EditText) findViewById(R.id.calorieEdit);
        pushUpEdit = (EditText) findViewById(R.id.pushUpEdit);
        sitUpEdit = (EditText) findViewById(R.id.sitUpEdit);
        jackEdit = (EditText) findViewById(R.id.jackEdit);
        jogEdit = (EditText) findViewById(R.id.jogEdit);

        pushUpView = (TextView) findViewById(R.id.pushUpView);
        sitUpView = (TextView) findViewById(R.id.sitUpView);
        jackView = (TextView) findViewById(R.id.jackView);
        jogView = (TextView) findViewById(R.id.jogView);

        pushUpView.setVisibility(View.GONE);
        sitUpView.setVisibility(View.GONE);
        jackView.setVisibility(View.GONE);
        jogView.setVisibility(View.GONE);
    }

    /** Convert all fields when enter button is clicked **/
    public void convertFields(View view) {
        System.out.println("ENTER BUTTON CLICKED");
        if (!enterField.equals("none")) {
            convertCalories();
            hideEditTexts();
            showTextView();
        }
    }

    /** Clear and reset all fields when clear button is clicked **/
    public void clearFields(View view) {
        System.out.println("CLEAR BUTTON CLICKED");
        showEditTexts();
        hideTextView();
        resetFields();
        enterField = "none";
    }

    public void convertCalories() {
        System.out.print("CALCULATING CALORIES");
        if (enterField.equals("pushUpEdit")) {
            convertFromPushUp();
        } else if (enterField.equals("sitUpEdit")) {
            convertFromSitUp();
        } else if (enterField.equals("jackEdit")) {
            convertFromJack();
        } else if (enterField.equals("jogEdit")) {
            convertFromJog();
        } else if (enterField.equals("calorieEdit")) {
            convertFromCalorie();
        }
        Integer calorieInt = calorieCount.intValue();
        calorie.setText(String.format("%d", calorieInt));

    }

    public void convertFromCalorie() {
        String count = calorieEdit.getText().toString();
        calorieCount = Double.parseDouble(count);
        convertPushUp();
        convertSitUp();
        convertJack();
        convertJog();
    }

    public void convertFromPushUp() {
        String count = pushUpEdit.getText().toString();
        enterCount = Double.parseDouble(count);
        calorieCount = enterCount * pushUpCalPerUnit;
        pushUpView.setText(count);
        convertSitUp();
        convertJack();
        convertJog();
    }

    public void convertFromSitUp() {
        String count = sitUpEdit.getText().toString();
        enterCount = Double.parseDouble(count);
        calorieCount = enterCount * sitUpCalPerUnit;
        sitUpView.setText(count);
        convertPushUp();
        convertJack();
        convertJog();
    }

    public void convertFromJack() {
        String count = jackEdit.getText().toString();
        enterCount = Double.parseDouble(count);
        calorieCount = enterCount * jackCalPerUnit;
        jackView.setText(count);
        convertPushUp();
        convertSitUp();
        convertJog();
    }

    public void convertFromJog() {
        String count = jogEdit.getText().toString();
        enterCount = Double.parseDouble(count);
        calorieCount = enterCount * jogCalPerUnit;
        jogView.setText(count);
        convertPushUp();
        convertSitUp();
        convertJack();
    }

    public void convertPushUp() {
        Double pushUpCount = (calorieCount / pushUpCalPerUnit);
        Integer pushUpInt = pushUpCount.intValue();
        pushUpView.setText(String.format("%d", pushUpInt));
    }

    public void convertSitUp() {
        Double sitUpCount = (calorieCount / sitUpCalPerUnit);
        Integer sitUpInt = sitUpCount.intValue();
        sitUpView.setText(String.format("%d", sitUpInt));
    }

    public void convertJack() {
        Double jackCount = (calorieCount / jackCalPerUnit);
        Integer jackInt = jackCount.intValue();
        jackView.setText(String.format("%d", jackInt));
    }

    public void convertJog() {
        Double jogCount = (calorieCount / jogCalPerUnit);
        Integer jogInt = jogCount.intValue();
        jogView.setText(String.format("%d", jogInt));
    }

    public void hideEditTexts() {
        System.out.println("HIDING EDIT TEXTS");
        calorieEdit.setVisibility(View.GONE);
        pushUpEdit.setVisibility(View.GONE);
        sitUpEdit.setVisibility(View.GONE);
        jackEdit.setVisibility(View.GONE);
        jogEdit.setVisibility(View.GONE);
    }

    public void showEditTexts() {
        System.out.println("SHOWING EDIT TEXTS");
        calorieEdit.setVisibility(View.VISIBLE);
        pushUpEdit.setVisibility(View.VISIBLE);
        sitUpEdit.setVisibility(View.VISIBLE);
        jackEdit.setVisibility(View.VISIBLE);
        jogEdit.setVisibility(View.VISIBLE);
    }

    public void showTextView() {
        System.out.println("SHOWING TEXT VIEW");
        calorie.setVisibility(View.VISIBLE);
        pushUpView.setVisibility(View.VISIBLE);
        sitUpView.setVisibility(View.VISIBLE);
        jackView.setVisibility(View.VISIBLE);
        jogView.setVisibility(View.VISIBLE);
    }

    public void hideTextView() {
        System.out.println("HIDING TEXT VIEW");
        calorie.setVisibility(View.GONE);
        pushUpView.setVisibility(View.GONE);
        sitUpView.setVisibility(View.GONE);
        jackView.setVisibility(View.GONE);
        jogView.setVisibility(View.GONE);
    }

    public void resetFields() {
        calorie.setText("0");
        calorieEdit.setText("");
        pushUpEdit.setText("");
        sitUpEdit.setText("");
        jackEdit.setText("");
        jogEdit.setText("");
    }

    public void calorieActive(View view) {
        System.out.println("calorieEditActive");
        enterField = "calorieEdit";
    }

    public void pushUpActive(View view) {
        System.out.println("pushUpActive");
        enterField = "pushUpEdit";
    }

    public void sitUpActive(View view) {
        System.out.println("sitUpActive");
        enterField = "sitUpEdit";
    }

    public void jackActive(View view) {
        System.out.println("jackActive");
        enterField = "jackEdit";
    }

    public void jogActive(View view) {
        System.out.println("jogActive");
        enterField = "jogEdit";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

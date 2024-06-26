package com.example.ex15;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etGrade1, etGrade2, etGrade3, etGrade4, etGrade5;
    int gradeLang=-1, gradeLitr=-1, gradeHist=-1, gradeCitz=-1, gradeBible=-1, mathGrade=-1, mathLevel=-1, englishGrade=-1, englishLevel=-1, grade1=-1, grade2=-1, grade3=-1, selectedOption=-1;
    String grade1Text,grade2Text,grade3Text,grade4Text,grade5Text, gradeOpt1Text, gradeOpt2Text, gradeOpt3Text;
    Intent intentSecondActivity;
    static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etGrade1 = findViewById(R.id.etGrade1);
        etGrade2 = findViewById(R.id.etGrade2);
        etGrade3 = findViewById(R.id.etGrade3);
        etGrade4 = findViewById(R.id.etGrade4);
        etGrade5 = findViewById(R.id.etGrade5);
        intentSecondActivity = new Intent(MainActivity.this, second_activity.class);
    }

    public boolean isValidGrade(String grade)
    {
        return !grade.isEmpty() && !(Integer.parseInt(grade) > 100);
    }

    public void clickedNext(View view)
    {
        grade1Text = etGrade1.getText().toString();
        grade2Text = etGrade2.getText().toString();
        grade3Text = etGrade3.getText().toString();
        grade4Text = etGrade4.getText().toString();
        grade5Text = etGrade5.getText().toString();

        if (isValidGrade(grade1Text) &&
                isValidGrade(grade2Text) &&
                isValidGrade(grade3Text) &&
                isValidGrade(grade4Text) &&
                isValidGrade(grade5Text))
        {
            Intent intentSecondActivity = new Intent(MainActivity.this, second_activity.class);
            intentSecondActivity.putExtra("gradeLang", gradeLang);
            intentSecondActivity.putExtra("gradeLitr", gradeLitr);
            intentSecondActivity.putExtra("gradeHist", gradeHist);
            intentSecondActivity.putExtra("gradeCitz", gradeCitz);
            intentSecondActivity.putExtra("gradeBible", gradeBible);
            intentSecondActivity.putExtra("mathGrade", mathGrade);
            intentSecondActivity.putExtra("mathLevel", mathLevel);
            intentSecondActivity.putExtra("englishGrade", englishGrade);
            intentSecondActivity.putExtra("englishLevel", englishLevel);
            intentSecondActivity.putExtra("selectedOption", selectedOption);
            intentSecondActivity.putExtra("agbara1", gradeOpt1Text);
            intentSecondActivity.putExtra("grade1", grade1);
            intentSecondActivity.putExtra("agbara2", gradeOpt2Text);
            intentSecondActivity.putExtra("grade2", grade2);
            intentSecondActivity.putExtra("agbara3", gradeOpt3Text);
            intentSecondActivity.putExtra("grade3", grade3);

            startActivityForResult(intentSecondActivity, REQUEST_CODE);
        }

        else
            Toast.makeText(this, "Invalid grade input. Please enter grades between 0 and 100.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE)
        {
            if (resultCode == RESULT_OK)
            {
                if (data != null)
                {
                    int agbaraGrade1 = data.getIntExtra("agbaraGrade1", -1);
                    int agbaraGrade2 = data.getIntExtra("agbaraGrade2", -1);
                    mathGrade = data.getIntExtra("mathGrade", -1);
                    mathLevel = data.getIntExtra("mathLevel", -1);
                    englishGrade = data.getIntExtra("englishGrade", -1);
                    englishLevel = data.getIntExtra("englishLevel", -1);
                    selectedOption = data.getIntExtra("selectedOption", 0);
                    grade1 = data.getIntExtra("agbaraGrade1", -1);
                    grade2 = data.getIntExtra("agbaraGrade2", -1);
                    grade3 = data.getIntExtra("agbaraGrade3", -1);
                    gradeOpt1Text = data.getStringExtra("agbaraName1");
                    gradeOpt2Text = data.getStringExtra("agbaraName2");
                    gradeOpt3Text = data.getStringExtra("agbaraName3");
                }
            }

            else if (resultCode == RESULT_CANCELED)
                Toast.makeText(this, "Canceled", Toast.LENGTH_SHORT).show();
        }
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textView4, textView5, textView6, textView8;
    private EditText editTextText;
    private Button button;
    private RadioGroup radioGroup;
    private int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bonus question for task3
        setSupportActionBar(findViewById(R.id.my_toolbar));
        // Initialize views
        textView4 = findViewById(R.id.textView4);
        textView5 = findViewById(R.id.textView5);
        textView6 = findViewById(R.id.textView6);
        textView8 = findViewById(R.id.textView8);
        editTextText = findViewById(R.id.editTextText);
        button = findViewById(R.id.button);
        radioGroup = findViewById(R.id.radioGroup);

        // Set a listener for the Check button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });

        // Set RadioGroup to handle level selection
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                updateQuestion();
            }
        });

        // update some question
        updateQuestion();
    }


    // Updated after dipslay the question method by the selected level
    private void updateQuestion() {
        int selectedLevelId = radioGroup.getCheckedRadioButtonId();
        RadioButton selectedLevelRadioButton = findViewById(selectedLevelId);

        // Put the maximum digits by selected level
        int maxDigits;
        if (selectedLevelRadioButton != null) {
            String selectedLevel = selectedLevelRadioButton.getText().toString();
            switch (selectedLevel) {
                case "i3":
                    maxDigits = 1;
                    break;
                case "i5":
                    maxDigits = 2;
                    break;
                case "i7":
                    maxDigits = 3;
                    break;
                default:
                    maxDigits = 1;
            }

            // Generate random numbers
            Random random = new Random();
            int firstNumber = random.nextInt((int) Math.pow(10, maxDigits));
            int secondNumber = random.nextInt((int) Math.pow(10, maxDigits));

            // TextViews will display the random number
            textView4.setText(String.valueOf(firstNumber));
            textView6.setText(String.valueOf(secondNumber));

            // Generate a random operator (0 to 3)
            int operator = random.nextInt(4);

            // operator based on the random number
            switch (operator) {
                case 0:
                    textView5.setText("+");
                    break;
                case 1:
                    textView5.setText("-");
                    break;
                case 2:
                    textView5.setText("*");
                    break;
                case 3:
                    textView5.setText("/");
                    break;
            }

            // Clear the EditText
            editTextText.getText().clear();
        }
    }

    // Method to check the answer and update points
    private void checkAnswer() {
        // Get the correct answer based on the displayed question
        int firstNumber = Integer.parseInt(textView4.getText().toString());
        int secondNumber = Integer.parseInt(textView6.getText().toString());
        int operator = getOperator(textView5.getText().toString());
        int correctAnswer = calculateAnswer(firstNumber, secondNumber, operator);

        // EditText will get the users answers
        String userAnswerString = editTextText.getText().toString();

        // Check for the modify the answer
        if (!userAnswerString.isEmpty()) {
            int userAnswer = Integer.parseInt(userAnswerString);
            if (userAnswer == correctAnswer) { // for the correct answer
                points++;
            } else { //for the wrong answer
                points--;
            }
        }

        // update TextView
        textView8.setText(String.valueOf(points));

        // Update the question for the next round
        updateQuestion();
    }

    // convert operator string to corresponding integer
    private int getOperator(String operatorString) {
        switch (operatorString) {
            case "+":
                return 0;
            case "-":
                return 1;
            case "*":
                return 2;
            case "/":
                return 3;
            default:
                return 0;
        }
    }

    // calculate the answer by the operator
    private int calculateAnswer(int firstNumber, int secondNumber, int operator) {
        switch (operator) {
            case 0:
                return firstNumber + secondNumber;
            case 1:
                return firstNumber - secondNumber;
            case 2:
                return firstNumber * secondNumber;
            case 3:
                return (secondNumber != 0) ? firstNumber / secondNumber : 0;
            default:
                return 0;
        }
    }
}
package com.example.caculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView textViewResult;
    private String currentNumber = "";
    private String currentOperator = "";
    private double result = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.textViewResult);

        // Set click listeners for digit buttons (0-9)
        for (int i = 0; i <= 9; i++) {
            int id = getResources().getIdentifier("button" + i, "id", getPackageName());
            Button button = findViewById(id);
            button.setText(""+i);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentNumber += button.getText();
                    updateResultTextView();
                }
            });
        }

        // Set click listeners for operation buttons (+, -, *, /, =, Clear)
        // Add click listeners for operation buttons here





        textViewResult = findViewById(R.id.textViewResult);

        // Set click listeners for digit buttons (0-9)
        // ... (previous code)

        // Set click listeners for operation buttons (+, -, *, /, =, Clear)
        setOperationButtonClickListener(R.id.buttonAdd, "+");
        setOperationButtonClickListener(R.id.buttonSubtract, "-");
        setOperationButtonClickListener(R.id.buttonMultiply, "*");
        setOperationButtonClickListener(R.id.buttonDivide, "/");
        setEqualButtonClickListener();
        setClearButtonClickListener();
    }

    private void updateResultTextView() {
        textViewResult.setText(currentNumber);
    }
    private void setOperationButtonClickListener(int buttonId, final String operator) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (!currentNumber.isEmpty()) {
                    if (!currentOperator.isEmpty()) {
                        performCalculation();
                        updateResultTextView();
                    }
                    currentOperator = operator;
                    result = Double.parseDouble(currentNumber);
                    currentNumber = "";
                }*/
                if(button.getText().toString().equals('=')){
                    performCalculation();
                }else{
                    currentOperator = button.getText().toString();
                    currentNumber += button.getText();
                    updateResultTextView();
                }

            }
        });
    }

    private void setEqualButtonClickListener() {
        Button button = findViewById(R.id.buttonEqual);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*if (!currentNumber.isEmpty() && !currentOperator.isEmpty()) {
                    performCalculation();
                    currentOperator = "";
                    updateResultTextView();
                }*/

                performCalculation();
            }
        });
    }

    private void setClearButtonClickListener() {
        Button button = findViewById(R.id.buttonClear);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber = "";
                currentOperator = "";
                result = 0;
                updateResultTextView();
            }
        });
    }

    private void performCalculation() {
        String[] numbers = {};
        if(currentNumber.contains("+")){
            numbers = currentNumber.split("\\+");
        }else if(currentNumber.contains("-")){
            numbers = currentNumber.split("-");
        }else if(currentNumber.contains("*")){
            numbers = currentNumber.split("\\*");
        }else if(currentNumber.contains("/")){
            numbers = currentNumber.split("\\/");
        }

        //double number = Double.parseDouble(currentNumber);
        switch (currentOperator) {
            case "+":
                result += Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                break;
            case "-":
                result -= Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                break;
            case "*":
                result *= Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                break;
            case "/":
                if (Double.parseDouble(numbers[1]) != 0) {
                    result /= Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                } else {
                    // Handle division by zero error
                    result = 0;
                }
                break;
        }
        textViewResult.setText(""+result);
    }

    // ... (the rest of the code)
}
    // Implement the operation button click listeners and calculation logic here
    // For example, for the "=" button, calculate the result and display it
    // Add the calculation logic for all other buttons

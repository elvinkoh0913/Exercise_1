package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(){
            val carPrice:Double = editTextCarPrice.text.toString().toDouble()
            val downPayment:Double = editTextDownPayment.text.toString().toDouble()
            val loanPeriod:Double = editTextLoanPeriod.text.toString().toDouble()
            val interestRate:Double = editTextInterestRate.text.toString().toDouble()


            val carLoan:Double = carPrice - downPayment
            val interest:Double = carLoan * (interestRate / 100) * loanPeriod
            var monthlyRepayment:Double = (carLoan + interest) / loanPeriod / 12

            textViewLoan.text = "Car Loan : RM %.2f".format(carLoan)
            textViewInterest.text = "Interest: RM%.2f".format(interest)
            textViewMonthlyRepayment.text = "Monthly Repayment: RM%.2f".format(monthlyRepayment)
        }

        buttonReset.setOnClickListener(){
            editTextCarPrice.text = null
            editTextDownPayment.text = null
            editTextLoanPeriod.text = null
            editTextInterestRate.text = null
        }
    }
}

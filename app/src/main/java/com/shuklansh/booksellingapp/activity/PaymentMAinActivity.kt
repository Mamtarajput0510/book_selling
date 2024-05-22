package com.shuklansh.booksellingapp.activity

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import com.razorpay.Checkout
import com.razorpay.PaymentResultListener
import com.shuklansh.booksellingapp.R
import com.shuklansh.booksellingapp.fragments.AboutFragment
import com.shuklansh.booksellingapp.fragments.FavouritesFragment
import com.shuklansh.booksellingapp.fragments.ProfileFragment
import org.json.JSONObject

class PaymentMAinActivity : AppCompatActivity(), PaymentResultListener {
    lateinit var txtPaymentStatus: TextView
    lateinit var editAmount: EditText
    lateinit var btnPayNow: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.payment_main)

        txtPaymentStatus = findViewById(R.id.paymentStatus)
        editAmount = findViewById(R.id.edit_amount)
        btnPayNow = findViewById(R.id.btnBuyNow)


        btnPayNow.setOnClickListener {
            // Implement your payment logic here
            val amount = editAmount.text.toString().toInt()
            // Call a function to handle payment with the specified amount
            handlePayment(amount)
        }


        // Payment success callback

    }


    private fun handlePayment(amount: Int) {

        val checkout = Checkout()
        checkout.setKeyID("rzp_test_4sXZYJ5c5Jkcgd")



        try {
            // Set up payment options
            val options = JSONObject()
            options.put("amount", amount * 100) // Amount in paisa
            options.put("currency", "INR")
            options.put("receipt", "order_receipt")

            // Open Razorpay checkout activity with payment options
            checkout.open(this, options)

        } catch (e: Exception) {
            // Handle error if initialization or payment request fails
            Toast.makeText(
                this,
                "Error in Payment : " + e.message,
                Toast.LENGTH_LONG
            ).show()
            e.printStackTrace()
        }
    }

        override fun onPaymentSuccess(p0: String?) {
            // Handle payment success
            txtPaymentStatus.text = "Payment Successful"
            txtPaymentStatus.setTextColor(Color.GREEN)
        }

        // Payment error callback
        override fun onPaymentError(p0: Int, p1: String?) {
            // Handle payment error
            txtPaymentStatus.text = "Payment Failed: $p1"
            txtPaymentStatus.setTextColor(Color.RED)
        }

}
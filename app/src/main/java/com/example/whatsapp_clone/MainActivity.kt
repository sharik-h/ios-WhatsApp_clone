package com.example.whatsapp_clone

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.example.whatsapp_clone.Navigation.BottombarScreen
import com.example.whatsapp_clone.ui.theme.WhatsAppcloneTheme
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit


class MainActivity : ComponentActivity() {

    val mAuth = FirebaseAuth.getInstance()
    var verificationOtp = ""
    var loggedStatus = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WhatsAppcloneTheme {
                verifyPhone()
            }
        }
    }

    val turnOfPhoneVerify = FirebaseAuth.getInstance().firebaseAuthSettings
        .setAppVerificationDisabledForTesting(false)

    private fun send(mobileNum: String) {
        val option = PhoneAuthOptions.newBuilder(mAuth)
            .setPhoneNumber(mobileNum)
            .setTimeout(60, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(
                object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                        Toast.makeText(
                            applicationContext,
                            "verification Succesfll",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onVerificationFailed(p0: FirebaseException) {
                        Toast.makeText(
                            applicationContext,
                            "verification Failed",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    override fun onCodeSent(
                        otp: String,
                        resendToken: PhoneAuthProvider.ForceResendingToken
                    ) {
                        super.onCodeSent(otp, resendToken)
                        verificationOtp = otp
                        Toast.makeText(
                            applicationContext,
                            "Otp send successfully",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }).build()
        PhoneAuthProvider.verifyPhoneNumber(option)
    }


    private fun otpVerification(otp: String) {

        val credential = PhoneAuthProvider.getCredential(verificationOtp, otp)
        FirebaseAuth.getInstance().signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(applicationContext, "Verification Successful", Toast.LENGTH_SHORT).show()
                    this.startActivity(Intent(this, secondActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(applicationContext, "Verification Failed", Toast.LENGTH_SHORT).show()
                }
            }

    }



    //  8129697750
    @Composable
    fun verifyPhone() {
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val navController = rememberNavController()
            var Phone by remember { mutableStateOf("") }
            var otp by remember { mutableStateOf("") }

            Text(text = "Sign in", fontSize = 30.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = Phone,
                onValueChange = { nmbr ->
                    Phone = nmbr
                })
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedTextField(
                value = otp,
                onValueChange = { nmbr ->
                    otp = nmbr
                })
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { send("+91$Phone") }) {
                Text(text = "Send OTP")
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                otpVerification( otp)
            })
            {
                Text(text = "Verify OTP")
            }
        }
    }


}


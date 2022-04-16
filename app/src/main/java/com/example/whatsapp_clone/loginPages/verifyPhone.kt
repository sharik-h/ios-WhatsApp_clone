package com.example.whatsapp_clone.loginPages

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit


class verifyPhone: ComponentActivity() {

    val mAuth = FirebaseAuth.getInstance()
    var verificationOtp = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VerifyNumber()
        }
    }

    private fun send(mobileNum: String) {

        Log.d("mobilenum",mobileNum)

        val option = PhoneAuthOptions.newBuilder(mAuth)
            .setPhoneNumber(mobileNum)
            .setTimeout(60, TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(
                object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                        Toast.makeText(
                            applicationContext,
                            "verification Succesfull",
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
                        startActivity(Intent(applicationContext, verifyActivity::class.java).putExtra("otp",verificationOtp))
                    }
                }).build()
        PhoneAuthProvider.verifyPhoneNumber(option)
    }


    @Composable
    fun VerifyNumber() {
        Column(Modifier.fillMaxSize()) {

            val context = LocalContext.current

            var msg by remember { mutableStateOf("") }
            val number = msg
            TopAppBar(backgroundColor = Color.White, modifier = Modifier.fillMaxWidth(),) {
                TextButton(
                    onClick = { send("+91$number") }
                ) {
                    Text(
                        text = "Done",
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp),
                        textAlign = TextAlign.Right,
                        color = Color(0xFF1786ff)
                    )
                }
            }
            Text(
                text = "Please confirm your county code and enter your phone number",
                fontSize = 20.sp,
                // fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(20.dp)
            )
            Divider(thickness = 1.dp, color = Color.LightGray)
            var dropdownstate = remember { mutableStateOf(false) }
            val items = listOf("India", "Oman", "Norway", "Mexico", "Uzbekistan")
            val numcode = listOf("+91", "+968", "+47", "+52", "+998")
            val disabledvalue = "Select Item"
            var selectedIndex = remember { mutableStateOf(0) }

            Button(
                onClick = { dropdownstate.value = true },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                content = {
                    Text(
                        items[selectedIndex.value],
                        fontSize = 20.sp,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.fillMaxWidth(),
                        color = Color(0xFF1786ff)
                    )
                },
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
            )
            DropdownMenu(
                expanded = dropdownstate.value,
                onDismissRequest = { dropdownstate.value = false },
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize(),

                ) {
                items.forEachIndexed { index, s
                    ->
                    DropdownMenuItem(onClick = {
                        selectedIndex.value = index
                        dropdownstate.value = false
                    }) {
                        Text(text = s)
                    }
                }
            }

            Divider(thickness = 1.dp, color = Color.LightGray)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
//                .padding(start = 20.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = numcode[selectedIndex.value],
                    fontSize = 30.sp,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Column(modifier = Modifier.padding(top = 5.dp)) {
                    BasicTextField(
                        value = msg,
                        onValueChange = { newmsg -> msg = newmsg },
                        modifier = Modifier
                            .background(Color.White)
                            .fillMaxSize()
                            .padding(start = 10.dp),
                        singleLine = true,
                        textStyle = LocalTextStyle.current.copy(fontSize = 30.sp),
                    )

                }
            }
            Divider(thickness = 1.dp, color = Color.LightGray)

        }
    }

}
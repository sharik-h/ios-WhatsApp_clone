package com.example.whatsapp_clone.loginPages

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusOrder
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp_clone.ui.theme.WhatsAppcloneTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider


class verifyActivity : ComponentActivity() {

    var verificationOtp = ""

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            WhatsAppcloneTheme {
                VerifyOtp()
            }
        }
    }


    private fun otpVerification(otp: String) {
        val sendedOtp = intent.getStringExtra("otp") ?: return
        val credential = PhoneAuthProvider.getCredential(sendedOtp, otp)
        FirebaseAuth.getInstance().signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    startActivity(Intent(applicationContext, userActivity::class.java))
                } else {
                    Toast.makeText(applicationContext, "Verification Failed", Toast.LENGTH_SHORT).show()
                }
            }
    }




//-----------------------------------------------------New Page-------------------------------------------------------------------------

    @Composable
    fun VerifyOtp() {
        var otp by remember { mutableStateOf("") }

        verificationOtp = otp

        Column(
            Modifier
                .fillMaxSize()
//            .padding(20.dp)
        ) {
            TopAppBar(backgroundColor = Color.White, modifier = Modifier.fillMaxWidth(),) {
                TextButton(onClick = {
                    otpVerification(otp)
                }) {
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
                text = "We have sent you an SMS with a code to number above",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = "To complete your phone number verification, please enter the 6-digit activation code",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(10.dp)
            )


            otpField() { getotp ->
                otp = getotp
            }


            Text(
                text = "Resend otp in 1:00",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.dp),
                textAlign = TextAlign.Center,
                fontSize = 15.sp
            )


        }
    }

    //-----------------------------------------otp field details---------------------------------------------------------------------------
    @Composable
    fun otpField(
        onFilled: (code: String) -> Unit
    ) {
        var otp: List<Char> by remember { mutableStateOf(listOf()) }
        val focusRequesters: List<FocusRequester> = remember {
            val temp = mutableListOf<FocusRequester>()
            repeat(6) {
                temp.add(FocusRequester())
            }
            temp
        }
        Row(
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .padding(top = 10.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            (0 until 6).forEach { index ->
                OutlinedTextField(
                    modifier = Modifier
                        .height(60.dp)
                        .width(40.dp)
                        .focusOrder(focusRequester = focusRequesters[index]) {
                            focusRequesters[index + 1].requestFocus()
                        },
                    singleLine = true,
                    textStyle = MaterialTheme.typography.body2.copy(
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontSize = 20.sp
                    ),
                    value = otp.getOrNull(index = index)?.takeIf {
                        it.isDigit()
                    }?.toString() ?: "",
                    onValueChange = { value: String ->
                        if (focusRequesters[index].freeFocus()) {
                            val temp = otp.toMutableList()
                            if (value == "") {
                                if (temp.size > index) {
                                    temp.removeAt(index = index)
                                    otp = temp
                                    focusRequesters.getOrNull(index - 1)?.requestFocus()
                                }
                            } else {
                                if (otp.size > index) {
                                    temp[index] = value.getOrNull(0) ?: ' '
                                } else {
                                    temp.add(value.getOrNull(0) ?: ' ')
                                    otp = temp
                                    focusRequesters.getOrNull(index + 1)?.requestFocus()
                                        ?: onFilled(
                                            otp.joinToString(separator = "")
                                        )
                                }
                            }
                        }
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    visualTransformation = PasswordVisualTransformation(),
                )
                Spacer(modifier = Modifier.width(15.dp))
            }
        }
    }



//-----------The Universal closing--------------------
}



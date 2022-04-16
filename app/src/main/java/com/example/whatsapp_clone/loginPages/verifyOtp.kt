package com.example.whatsapp_clone.loginPages

//
//@Composable
//fun VerifyOtp(navController: NavController, num: String) {
//    Column(
//        Modifier
//            .fillMaxSize()
////            .padding(20.dp)
//    ) {
//        TopAppBar(backgroundColor = Color.White, modifier = Modifier.fillMaxWidth(), ) {
//            TextButton(onClick = {navController.navigate(loginPageScreen.userProfile.route)}){
//                Text(
//                    text = "Confirm",
//                    fontSize = 20.sp,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(start = 10.dp),
//                    textAlign = TextAlign.Right,
//                    color = Color(0xFF1786ff)
//                )
//            }
//        }
//        Text(
//            text = "We have sent you an SMS with a code to number above",
//            fontSize = 18.sp,
//            textAlign = TextAlign.Center,
//            modifier = Modifier.padding(10.dp)
//        )
//        Text(
//            text = "To complete your phone number verification, please enter the 6-digit activation code",
//            fontSize = 18.sp,
//            textAlign = TextAlign.Center,
//            modifier = Modifier.padding(10.dp)
//        )
//
//        var otpval: String? = ""
//        otpField(){
//                getotp -> otpval
//        }
//
//        Text(
//            text = "Resend otp in 1:00",
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(top = 30.dp),
//            textAlign = TextAlign.Center,
//            fontSize = 15.sp )
//
//
//    }
//}
//
//@Composable
//fun otpField(modifier: Modifier = Modifier,
//             onFilled: (code: String) -> Unit) {
//    var otp: List<Char> by remember { mutableStateOf(listOf()) }
//    val focusRequesters: List<FocusRequester> = remember {
//        val temp = mutableListOf<FocusRequester>()
//        repeat(6) {
//            temp.add(FocusRequester())
//        }
//        temp
//    }
//    Row(
//        modifier = Modifier
//            .height(50.dp)
//            .fillMaxWidth()
//            .padding(top = 10.dp),
//        horizontalArrangement = Arrangement.Center
//    ) {
//        (0 until 6).forEach { index ->
//            OutlinedTextField(
//                modifier = Modifier
//                    .height(40.dp)
//                    .width(40.dp)
//                    .focusOrder(focusRequester = focusRequesters[index]) {
//                        focusRequesters[index + 1].requestFocus()
//                    },
//                singleLine = true,
//                textStyle = MaterialTheme.typography.body2.copy(
//                    textAlign = TextAlign.Center,
//                    color = Color.Black
//                ),
//                value = otp.getOrNull(index = index)?.takeIf {
//                    it.isDigit()
//                }?.toString() ?: "",
//                onValueChange = {value: String ->
//                    if (focusRequesters[index].freeFocus()) {
//                        val temp = otp.toMutableList()
//                        if (value == "" ) {
//                            if (temp.size > index) {
//                                temp.removeAt(index = index)
//                                otp = temp
//                                focusRequesters.getOrNull(index - 1)?.requestFocus()
//                            }
//                        }else{
//                            if (otp.size > index){
//                                temp[index] = value.getOrNull(0)?: ' '
//                            }else{
//                                temp.add(value.getOrNull(0) ?: ' ')
//                                otp =temp
//                                focusRequesters.getOrNull(index + 1)?.requestFocus() ?: onFilled(
//                                    otp.joinToString ( separator= "" )
//                                )
//                            }
//                        }
//                    }
//                },
//                keyboardOptions =  KeyboardOptions.Default.copy(
//                    keyboardType = KeyboardType.Number,
//                    imeAction = ImeAction.Next
//                ),
//                visualTransformation = PasswordVisualTransformation()
//            )
//            Spacer(modifier = Modifier.width(15.dp))
//        }
//    }
//}
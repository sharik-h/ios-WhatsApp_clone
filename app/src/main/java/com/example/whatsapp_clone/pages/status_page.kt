package com.example.whatsapp_clone.pages

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.launch
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.whatsapp_clone.R
import com.example.whatsapp_clone.ui.theme.lblue
import kotlinx.coroutines.launch

@SuppressLint("CheckResult")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun Statuspage() {

    var isCameraSelected = false
    var imageUri: Uri? = null
    var bitmap: Bitmap? = null

    val context = LocalContext.current
    val bottomSheetModalState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    val galleryLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        imageUri = uri
        bitmap = null
    }

    val cameraLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.TakePicturePreview()
    ) { btm: Bitmap? ->
        bitmap = btm
        imageUri = null
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            if (isCameraSelected) {
                cameraLauncher.launch()
            } else {
                galleryLauncher.launch("image/*")
            }
            coroutineScope.launch {
                bottomSheetModalState.hide()
            }
        } else {
            Toast.makeText(context, "Permission Denied!", Toast.LENGTH_SHORT).show()
        }
    }
    ModalBottomSheetLayout(
        sheetContent = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(Color.White)
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Take Photo",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                when (PackageManager.PERMISSION_GRANTED) {
                                    ContextCompat.checkSelfPermission(
                                        context, Manifest.permission.CAMERA
                                    ) -> {
                                        cameraLauncher.launch()
                                        Toast.makeText(context, "Sorry for your inconvenience, but this feature is still in progress the whole feature may not be there.", Toast.LENGTH_SHORT).show()
                                        coroutineScope.launch {
                                            bottomSheetModalState.hide()
                                        }
                                    }
                                    else -> {
                                        isCameraSelected = true
                                        permissionLauncher.launch(Manifest.permission.CAMERA)
                                    }
                                }
                            }
                            .padding(15.dp),
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    Divider(thickness = 1.dp)
                    Text(
                        text = "Choose from Gallery",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                when (PackageManager.PERMISSION_GRANTED) {
                                    ContextCompat.checkSelfPermission(
                                        context, Manifest.permission.READ_EXTERNAL_STORAGE
                                    ) -> {
                                        galleryLauncher.launch("image/*")
                                        coroutineScope.launch {
                                            bottomSheetModalState.hide()
                                        }
                                    }
                                    else -> {
                                        isCameraSelected = false
                                        permissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
                                    }
                                }
                            }
                            .padding(15.dp),
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    Spacer(Modifier.height(55.dp))
                }
            }
        },
        sheetState = bottomSheetModalState,
//        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        modifier = Modifier
            .background(MaterialTheme.colors.background)
    ) {
        Column() {
            //AppBar
            TopAppBar(
                backgroundColor = Color(0xFFF2F2F7),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Privacy",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 14.dp),
                    color = lblue
                )
            }



            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFF2F2F7))
            )
            {
                val helvetica = FontFamily(Font(R.font.helvetica))
                Text(
                    text = "Status",
                    fontFamily = helvetica,
                    fontSize = 40.sp,
                    modifier = Modifier.padding(start = 15.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp)
                        .height(90.dp)
                        .clickable {
                            coroutineScope.launch {
                                if (!bottomSheetModalState.isVisible) {
                                    bottomSheetModalState.show()
                                } else {
                                    bottomSheetModalState.hide()
                                }
                            }
                        }
                ) {
                    Column()
                    {
                        Divider(thickness = 2.dp, color = Color.LightGray)
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                                .padding(13.dp)
                        ) {
                            val myimage: Painter = painterResource(id = R.drawable.img_0922)
                            Image(
                                painter = myimage,
                                contentDescription = "my Profile pic",
                                modifier = Modifier
                                    .size(67.dp)
                                    .clip(RoundedCornerShape(50))
                            )

                            Column(
                                modifier = Modifier.padding(
                                    horizontal = 10.dp,
                                    vertical = 8.dp
                                )
                            ) {
                                Text(
                                    text = "My Status",
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    text = "Add to my status",
                                    fontSize = 15.sp,
                                    color = Color(0xFF9E9E9E)
                                )
                            }

                            val camera: Painter =
                                painterResource(id = R.drawable.ic_baseline_photo_camera_24)
                            val edit: Painter = painterResource(id = R.drawable.ic_baseline_edit_24)

                            Box(
                                modifier = Modifier.fillMaxSize(),
                                contentAlignment = Alignment.CenterEnd,
                            ) {
                                Row() {
                                    Box(
                                        modifier = Modifier
                                            .padding(10.dp)
                                            .height(45.dp)
                                            .width(45.dp)
                                            .clip(RoundedCornerShape(50))
                                            .background(Color.LightGray),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(painter = camera, contentDescription = "")
                                    }
                                    Box(
                                        modifier = Modifier
                                            .padding(10.dp)
                                            .height(45.dp)
                                            .width(45.dp)
                                            .clip(RoundedCornerShape(50))
                                            .background(Color.LightGray),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Image(painter = edit, contentDescription = "")
                                    }
                                }
                            }
                        }
                    }
                }
                Divider(thickness = 1.dp, color = Color.LightGray)
                Text(
                    text = "RECENT UPDATES",
                    fontSize = 16.sp,
                    modifier = Modifier.padding(top = 45.dp, start = 10.dp),
                    color = Color.DarkGray
                )
                Divider(thickness = 1.dp, color = Color.LightGray)
                bitmap?.let { btm ->
                }
            }

        }


    }
}


@Preview(showBackground = true)
@Composable
fun Previewstatuspage() {
    Statuspage()
}
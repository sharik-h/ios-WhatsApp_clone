package com.example.whatsapp_clone.pages


import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.provider.MediaStore
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import kotlinx.coroutines.launch

@SuppressLint("PermissionLaunchedDuringComposition")
@OptIn(ExperimentalPermissionsApi::class, ExperimentalMaterialApi::class)
@Composable
fun TakePicture()
{
    var isCameraSelected = false
    var bitmap: Bitmap? = null
    var imageUri: Uri? = null
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
                    .background(MaterialTheme.colors.primary.copy(0.08f))
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceEvenly,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Add Photo!",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(15.dp),
                        color = MaterialTheme.colors.primary,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily.SansSerif
                    )
                    Divider(
                        modifier = Modifier
                            .height(1.dp)
                            .background(MaterialTheme.colors.primary)
                    )
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
                    Divider(
                        modifier = Modifier
                            .height(0.5.dp)
                            .fillMaxWidth()
                            .background(Color.LightGray)
                    )
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
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                    Divider(
                        modifier = Modifier
                            .height(0.5.dp)
                            .fillMaxWidth()
                            .background(Color.LightGray)
                    )
                    Text(
                        text = "Cancel",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                coroutineScope.launch {
                                    bottomSheetModalState.hide()
                                }
                            }
                            .padding(15.dp),
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontFamily = FontFamily.SansSerif
                    )
                }
            }
        },
        sheetState = bottomSheetModalState,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        modifier = Modifier
            .background(MaterialTheme.colors.background)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            Toast.makeText(context, "This page is in development. Some feature may not be working as it is supposed to be", Toast.LENGTH_SHORT).show()
            
            Button(
                onClick = {
                    coroutineScope.launch {
                        if (!bottomSheetModalState.isVisible) {
                            bottomSheetModalState.show()
                        } else {
                            bottomSheetModalState.hide()
                        }
                    }
                },
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            ) {
                Text(
                    text = "Take Picture",
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Center,
                    color = Color.White
                )
            }
        }
    }

        imageUri?.let {
            if (!isCameraSelected) {
                bitmap = if (Build.VERSION.SDK_INT < 28) {
                    MediaStore.Images.Media.getBitmap(context.contentResolver, it)
                } else {
                    val source = ImageDecoder.createSource(context.contentResolver, it)
                    ImageDecoder.decodeBitmap(source)
                }
            }

            bitmap?.let { btm ->
                Image(
                    bitmap = btm.asImageBitmap(),
                    contentDescription = "Image",
                    alignment = Alignment.TopCenter,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.45f)
                        .padding(top = 10.dp),
                    contentScale = ContentScale.Fit
                )
            }
        }

    bitmap?.let { btm ->
        Image(
            bitmap = btm.asImageBitmap(),
            contentDescription = "Image",
            alignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.45f)
                .padding(top = 10.dp),
            contentScale = ContentScale.Fit
        )
    }
}
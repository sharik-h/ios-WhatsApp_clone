package com.example.whatsapp_clone.pages.newGroupActivity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.whatsapp_clone.pages.ChatActivity
import com.google.firebase.auth.FirebaseAuth
import io.getstream.chat.android.client.ChatClient
import io.getstream.chat.android.client.api.models.QueryUsersRequest
import io.getstream.chat.android.client.models.Filters
import io.getstream.chat.android.client.models.User
import kotlinx.coroutines.launch

const val admin = "shawhatsapp"

@ExperimentalMaterialApi
class startNewGroupAcitivity: ComponentActivity() {

    val UsersList = mutableListOf<String>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         val currentuser = FirebaseAuth.getInstance().currentUser ?: return

        val request = QueryUsersRequest(
            filter = Filters.ne("id", currentuser.uid),
            offset = 0,
            limit = 100 )
        ChatClient.instance().queryUsers(request).enqueue{ result ->
            if (result.isSuccess){
                setContent {
                    AllUsers(result.data(), currentuser.uid)
                }
            }else{
                Log.d("list","failure")
                return@enqueue
            }
        }
    }

    @Composable
    fun AllUsers(data: List<User>, uid: String) {

        UsersList.add(uid)
        val context = LocalContext.current
        val fontsize: TextUnit = MaterialTheme.typography.h6.fontSize
        val fontColor = Color(0xFF1786FF)

        Column {
            TopAppBar(
                backgroundColor = Color.White,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Cancel",
                        modifier = Modifier
                            .weight(0.75f)
                            .clickable(onClick = {finish()}),
                        textAlign = TextAlign.Start,
                        fontSize = fontsize,
                        color = fontColor
                    )
                    Text(
                        text = "Add Participants",
                        modifier = Modifier.weight(1f),
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start,
                        fontSize = fontsize
                    )
                    Text(
                        text = "Next",
                        modifier = Modifier
                            .weight(0.5f)
                            .clickable(onClick = {
                                ChatClient.instance().createChannel(channelType = "messaging", members = UsersList)
                                    .enqueue {
                                        if (it.isSuccess) {
                                            context.startActivity(Intent(context, ChatActivity::class.java).putExtra("cid", it.data().cid))
                                            finish()
                                        } else  Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show()
                                    }
                            }),
                        textAlign = TextAlign.End,
                        fontSize = fontsize,
                        color = Color(0xFF1786FF)
                    )
                }
            }


            LazyColumn() {
                items(items = data) { user ->
                    var selected by remember { mutableStateOf(false)}
                    SelectableItem(
                        selected = selected,
                        data = user,
                        onClick = {
                            selected = !selected
                            if (selected) UsersList.add(user.id)
                            else UsersList.remove(user.id)
                        }
                    )
                }
            }
        }
    }


    @Composable
    fun SelectableItem(
        modifier: Modifier = Modifier,
        selected: Boolean,
        data: User,
        titleSize: TextUnit = MaterialTheme.typography.h6.fontSize,
        titleWeight: FontWeight = FontWeight.Medium,
        icon: ImageVector = Icons.Default.CheckCircle,
        iconColor: Color =
            if (selected) MaterialTheme.colors.primary
            else MaterialTheme.colors.onSurface.copy(alpha = 0.2f),
        onClick: () -> Unit
    ) {
        val scaleA = remember { Animatable(initialValue = 1f) }
        val scaleB = remember { Animatable(initialValue = 1f) }

        val clickEnabled = remember { mutableStateOf(true) }

        LaunchedEffect(key1 = selected) {
            if (selected) {
                clickEnabled.value = false

                val jobA = launch {
                    scaleA.animateTo(
                        targetValue = 0.9f,
                        animationSpec = tween(
                            durationMillis = 50
                        )
                    )
                    scaleA.animateTo(
                        targetValue = 1f,
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioLowBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                }
                val jobB = launch {
                    scaleB.animateTo(
                        targetValue = 0.9f,
                        animationSpec = tween(
                            durationMillis = 50
                        )
                    )
                    scaleB.animateTo(
                        targetValue = 1f,
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioLowBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                }
                jobA.join()
                jobB.join()
                clickEnabled.value = true
            }
        }

        Column(
            modifier = modifier
                .scale(scale = scaleB.value)
                .clickable(enabled = clickEnabled.value) {
                    onClick()
                }
        ) {
            Row(
                modifier = Modifier.padding(start = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                val image = rememberImagePainter(data = data.image, builder = { })
                Image(
                    painter = image,
                    contentDescription = "sample image",
                    modifier = Modifier
                        .height(40.dp)
                        .width(40.dp)
                        .clip(RoundedCornerShape(50))
                        .border(1.dp, color = Color.LightGray, shape = RoundedCornerShape(50))
                )
                Text(
                    modifier = Modifier
                        .weight(8f)
                        .padding(start = 10.dp),
                    text = data.name,
                    style = TextStyle(
                        fontSize = titleSize,
                        fontWeight = titleWeight
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                IconButton(
                    modifier = Modifier
                        .weight(2f)
                        .scale(scale = scaleA.value),
                    onClick = {
                        if (clickEnabled.value) {
                            onClick()
                        }
                    }
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Selectable Item Icon",
                        tint = iconColor
                    )
                }
            }
            Divider(thickness = 1.dp, modifier = Modifier.padding(start = 65.dp))
        }
    }

}


@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.practiceandroid

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practiceandroid.ui.theme.PracticeAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyAppContent()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyAppContent(){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        var username by remember { mutableStateOf("") }
        var password by remember {mutableStateOf("")}
        Text(text = "Login", style = MaterialTheme.typography.headlineLarge.copy(color = Color(0xFF476810)))
        Spacer(modifier = Modifier.height(36.dp))
        OutlinedTextField(
            label = { Text("Enter Email") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done),
            value = username,
            onValueChange = { newUsername -> username = newUsername },
            leadingIcon = {
                Image(
                    painter = painterResource(id = android.R.drawable.star_big_on),
                    contentDescription = "Star Icon"
                )
            },
        )
        OutlinedTextField(
            label = { Text("Enter Password") },
            value = password,
            onValueChange = { newPassword -> password = newPassword},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done),
            leadingIcon = {
                Image(
                    painter = painterResource(id = android.R.drawable.star_big_on),
                    contentDescription = "Star Icon"
                )
            },
        )
//        Button(onClick = {
//            val intent = Intent(Intent.ACTION_VIEW)
//            intent.data= Uri.parse("https://youtube.com");
//            if (intent.resolveActivity(LocalContext.current.packageManager)!=null){
//                LocalContext.current.startActivity(intent)
//            }
//        },
//            modifier = Modifier.padding(all = 10.dp)) {
//            Text(text = "Sign In")
        }
    }



@Preview(showBackground = true)
@Composable
fun MainPreview() {
    MyAppContent()
}

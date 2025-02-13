package com.example.login1.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login1.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ForgetPassword(navController:NavController? = null){

    var email by remember { mutableStateOf("") }

    Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("") },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController?.popBackStack()
                        }) {
                            Icon(painter = painterResource(id = R.drawable.arrow_back) ,
                                contentDescription ="Back Button" )
                        }
                    }
                )
            }

        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 90.dp, start = 30.dp, end = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(text = "Forget Password",
                    fontSize = 24.sp,
                    modifier = Modifier.padding(bottom = 20.dp),
                    style = TextStyle(color = Color(0xFF3461FD), fontWeight = FontWeight.Bold)
                )
                Text(text = "It was popularised in the 1960s with the release of Letraset sheetscontaining Lorem Ipsum.",
                    textAlign = TextAlign.Center,)
                TextField(value = email,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp)
                        .wrapContentHeight(),
                    shape = RoundedCornerShape(10.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = Color.Black,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    onValueChange = {
                        email = it
                    },
                    label = {
                        Text(text = "")
                    })
                Button(onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 30.dp)
                        .height(50.dp),
                    shape = RoundedCornerShape(5.dp),
                    elevation = ButtonDefaults.buttonElevation(defaultElevation = 3.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF3461FD)
                    )


                ) {
                    Text(text = "Continue",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 15.sp
                        )
                    )
                }
            }
        }
}
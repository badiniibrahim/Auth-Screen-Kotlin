package com.example.login1.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.login1.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun LoginScreen(navController: NavController? = null) {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPassword by rememberSaveable { mutableStateOf(false) }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 90.dp, start = 30.dp, end = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sign In",
            fontSize = 24.sp,
            modifier = Modifier.padding(bottom = 10.dp),
            style = TextStyle(color = Color(0xFF3461FD), fontWeight = FontWeight.Bold)
        )
        Text(text = "It was popularised in the 1960s with the release of Letraset sheetscontaining Lorem Ipsum.",
            textAlign = TextAlign.Center,)

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(top = 15.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { /*TODO*/ },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.light_blue_background)
                )

            ) {
               Row(
                   verticalAlignment = Alignment.CenterVertically,
                   horizontalArrangement = Arrangement.SpaceBetween
               ) {
                   Image(painter = painterResource(id = R.drawable.facebook),
                       contentDescription = "Facebook button",
                       modifier = Modifier.size(20.dp)
                   )
                   Spacer(modifier = Modifier.width(10.dp))
                   Text(text = "Facebook", color = Color.Black)
               }
            }

            Button(onClick = { /*TODO*/ },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.light_blue_background)
                )) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(painter = painterResource(id = R.drawable.google),
                        contentDescription = "Google button",
                        modifier = Modifier.size(20.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = "Google", color = Color.Black)
                }

            }
        }

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
        TextField(value = password,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            shape = RoundedCornerShape(10.dp),
            visualTransformation = if (showPassword) VisualTransformation.Companion.None
                    else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            trailingIcon = {
                val imageId = if (showPassword)
                    R.drawable.heroicons_eye
                else
                    R.drawable.heroicons_eye_slash

                IconButton(onClick = {
                    showPassword = !showPassword
                }) {
                    Image(painter = painterResource(id = imageId),
                        contentDescription = "password"
                    )
                }
            },
            onValueChange = { password = it},
            label = {
                Text(text = "")
            })
        Text(text = "Forget Password?",
            modifier = Modifier
                .align(Alignment.End)
                .padding(top = 20.dp)
                .clickable {
                    navController?.navigate("forgot_password")
                }
        )
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
            Text(text = "Sign In",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            )
        }

        Row (
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(top = 20.dp).fillMaxWidth()){
            Text(text = "Don’t have account?")
            Spacer(modifier = Modifier.width(3.dp))
            Text(text = "Sign Up", modifier = Modifier.clickable {
                navController?.navigate("sign_up")
            },
                style = TextStyle( color = Color(0xFF3461FD),
                    fontWeight = FontWeight.Bold)
                )
        }



    }
}
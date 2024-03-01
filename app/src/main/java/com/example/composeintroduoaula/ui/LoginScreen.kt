package com.example.composeintroduoaula.ui

import android.provider.ContactsContract.Intents.Insert
import android.text.InputType
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composeintroduoaula.R
import com.example.composeintroduoaula.ui.theme.ComposeIntroduçãoAulaTheme
import com.example.composeintroduoaula.viewmodel.AuthViewModel

@Composable
fun LoginScreen(
    navController: NavController
) {
    var authViewModel = hiltViewModel<AuthViewModel>()
    var usuario by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = Color.LightGray

    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp, Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.ifro_campus_vertical),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .size(150.dp)
            )
            if (error.isNotBlank()){
                Text(error)
            }
            OutlinedTextField(
                value = usuario,
                onValueChange = {usuario = it},
                label = {Text ("Usuário")},
                modifier = Modifier.fillMaxWidth(),

            )

            OutlinedTextField(
                value = senha,
                onValueChange = {senha = it},
                label = {Text ("Senha")},
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                modifier = Modifier.fillMaxWidth(),

                )
            Button(
                onClick = {
                          authViewModel.login(
                              usuario,
                              senha,
                              onSucess = {
                                         navController.navigate("Minha conta")
                              },
                              onError = {messagem ->
                                  error = messagem
                              }
                          )

                },
                modifier = Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth()
            ){
                Text(
                    "Entrar",
                    modifier = Modifier
                        .padding(10.dp))
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ComposeIntroduçãoAulaTheme {
        LoginScreen(rememberNavController())
    }
}
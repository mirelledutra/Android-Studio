package com.example.composeintroduoaula.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class AuthViewModel: ViewModel(){
    val autenticado = mutableStateOf(false)

    fun login(
        usuario: String,
        senha: String,
        onSucess: () -> Unit,
        onError:(String) -> Unit
    ) {
        if (usuario.isEmpty()){
            onError("Informe o Usuário")
            return
        }

        if (senha.isEmpty()){
            onError("Informe a senha")
            return
        }

        viewModelScope.launch {
            appDataStore.putBoolean()
        }
    }

    fun logout (){

    }

}
package com.example.agendamc.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agendamc.rest.Loginservice
import com.example.agendamc.rest.RetrofitClient
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject
import android.content.Intent
import com.example.agendamc.R
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call

class LoginActivity : AppCompatActivity() {
    @Inject
    lateinit var Loginservice: Loginservice
    private var compositeDisposable = CompositeDisposable()


    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val retrofit = RetrofitClient.getInstance()
        Loginservice = retrofit.create(com.example.agendamc.rest.Loginservice::class.java)

        btnEntrar.setOnClickListener {
            loginUser(editUsuario.text.toString(), editPassword.text.toString())

        }

        editUsuario.setText(Prefs.getString("lembrarUsuario"))
        editPassword.setText(Prefs.getString("LembrarSenha"))
        checkBoxLembrar.isChecked = Prefs.getBoollean("checkLembrar")

    }


    private fun loginUser(email: String, password: String) {

        Prefs.setBoolean("checkLembrar", checkBoxLembrar.isChecked)

        if (checkBoxLembrar.isChecked){
            Prefs.setString("lembrarUsuario",editUsuario.text.toString())
            Prefs.setString("LembrarSenha", editPassword.text.toString())

        }else{
            Prefs.setString("lembrarUsuario","")
            Prefs.setString("LembrarSenha","")
        }

        if (email == "aluno" && password == "impacta"){
            compositeDisposable.add(Loginservice.loginUser(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result: String ->
                    Toast.makeText(this@LoginActivity, "Logado", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }

            )
        }else{
            Toast.makeText(this@LoginActivity, "Usuario ou senha incorretos", Toast.LENGTH_SHORT).show()
        }

    }
}

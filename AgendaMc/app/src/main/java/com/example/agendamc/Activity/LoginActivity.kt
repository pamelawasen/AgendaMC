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
            loginUser(editEndereço.text.toString(), editPassword.text.toString())

        }

    }


    private fun loginUser(email: String, password: String) {

        if (email != "aluno" && password != "impacta") {
            Toast.makeText(this@LoginActivity, "Usuario ou senha incorretos", Toast.LENGTH_SHORT).show()

        } else {
            compositeDisposable.add(Loginservice.loginUser(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { result: String ->
                    Toast.makeText(this@LoginActivity, "Logado", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                }

            )
        }

    }
}

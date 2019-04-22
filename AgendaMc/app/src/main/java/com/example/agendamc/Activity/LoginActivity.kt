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

class LoginActivity : AppCompatActivity() {
    @Inject
    lateinit var Loginservice:Loginservice
    private var compositeDisposable = CompositeDisposable()


    override fun onStop() {
        compositeDisposable.clear()
        super.onStop()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val retrofit= RetrofitClient.getInstance()
        Loginservice = retrofit.create(com.example.agendamc.rest.Loginservice::class.java)

        btnEntrar.setOnClickListener {
            loginUser(editEmail.text.toString(), editPassword.text.toString())

        }

    }

    override fun onResume() {
        super.onResume()
    }
    private fun loginUser(email:String, password:String) {

       /* if (TextUtils.isEmpty(email)){
            Toast.makeText(this@LoginActivity,"Email incorreto", Toast.LENGTH_SHORT).show()
            return
        }

        if (TextUtils.isEmpty(password)){
            Toast.makeText(this@LoginActivity,"Senha incorreta", Toast.LENGTH_SHORT).show()
            return
        }*/
        if(email == "aluno" && password == "impacta") {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this@LoginActivity,"Usuario ou senha incorretos",Toast. LENGTH_SHORT).show()
        }
        /*compositeDisposable.add(Loginservice.loginUser(email,password)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { result ->
                Toast.makeText(this@LoginActivity,""+result, Toast.LENGTH_SHORT).show()
            }
        )*/
    }
}

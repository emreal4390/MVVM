package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
   private lateinit var binding: ActivityMainBinding
   private val viewModel:MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.mainActivityNesnesi=this
        viewModel.sonuc.observe(this){
            binding.hesaplamaSonucu=it
        }




        }

    fun buttonCarpmaTiklama(alinanSayi1:String,alinanSayi2:String){


        val sayi1=alinanSayi1.toInt()
        val sayi2=alinanSayi2.toInt()
        val carpma=sayi1*sayi2

        viewModel.carpmaYap(alinanSayi1,alinanSayi2)

    }

    fun buttonToplamaTiklama(alinanSayi1:String,alinanSayi2:String){

        viewModel.toplamaYap(alinanSayi1,alinanSayi2)

    }
}

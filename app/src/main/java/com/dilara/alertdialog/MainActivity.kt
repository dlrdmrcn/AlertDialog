package com.dilara.alertdialog

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dilara.alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.logout.setOnClickListener {
            showPopUp("Çıkış yapılsın mı?", "Hesaptan çıkış yapmak istediğinize emin misiniz?","Evet",{
                Toast.makeText(this@MainActivity, "Çıkış yapıldı.", Toast.LENGTH_LONG).show()
            },"Hayır", {
                Toast.makeText(this@MainActivity, "Çıkış yapılmadı.", Toast.LENGTH_LONG).show()

            },"Vazgeç", {
                Toast.makeText(this@MainActivity, "Çıkış yapılmadı.", Toast.LENGTH_LONG).show()

            })
        }

    }

    fun showPopUp(
        title: String,
        message: String,
        positiveButtonName: String,
        positiveButtonCallBack: (() -> Unit)? = null,
        negativeButtonName: String? = null,
        negativeButtonCallBack: (() -> Unit)? = null,
        neutralButtonName: String? = null,
        neutralButtonCallBack: (() -> Unit)? = null
    ) {
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setTitle(title)

        builder.setIcon(R.drawable.baseline_exit_to_app_24)
        builder.setMessage(message)
        builder.setPositiveButton(positiveButtonName) { dialog, _ ->
            positiveButtonCallBack?.invoke()
            dialog.cancel()
        }


        if (!negativeButtonName.isNullOrEmpty()) {
            builder.setNegativeButton(negativeButtonName) { dialog, _ ->
                negativeButtonCallBack?.invoke()
                dialog.cancel()
            }
        }


        if (!neutralButtonName.isNullOrEmpty()) {
            builder.setNeutralButton(neutralButtonName) { dialog, _ ->
                neutralButtonCallBack?.invoke()
                dialog.cancel()
            }
        }

        builder.create().show()
    }
}
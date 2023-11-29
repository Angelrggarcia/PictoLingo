package com.example.pictolingo.components

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pictolingo.R
import java.io.File
import java.io.FileOutputStream

class SaveImage : AppCompatActivity() {

    private val PICK_IMAGE_REQUEST = 1

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.drawable.suma)

        val pickImageButton: Button = findViewById(R.drawable.gato)
        pickImageButton.setOnClickListener {
            seleccionarImagenDesdeGaleria()
        }
    }

    fun seleccionarImagenDesdeGaleria() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, PICK_IMAGE_REQUEST)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            val selectedImageUri = data.data
            selectedImageUri?.let {
                guardarImagenLocalmente(selectedImageUri)
            }
        }
    }

    fun guardarImagenLocalmente(uri: Uri, name:String = "a.png") {
        val inputStream = contentResolver.openInputStream(uri)
        val outputDirectory = File(filesDir, "res/drawable")
        outputDirectory.mkdirs()

        val outputFile = File(outputDirectory, name)

        val outputStream = FileOutputStream(outputFile)
        inputStream?.copyTo(outputStream)
        inputStream?.close()
        outputStream.close()

        Toast.makeText(this, "Imagen guardada localmente", Toast.LENGTH_SHORT).show()
    }
}
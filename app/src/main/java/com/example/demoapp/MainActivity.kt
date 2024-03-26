package com.example.demoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.demoapp.model.Product
import com.example.demoapp.ui.theme.DemoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DemoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProductList()
                }
            }
        }
    }
}

//un composable es una funcion que retorna un objeto de tipo UI,
//este objeto puede ser un texto, un boton, un contenedor, etc.
//puede ser llamado por otro composable

//composable que muestra una lista de productos
@Composable
fun ProductList(modifier: Modifier = Modifier) {
    val products = listOf(
        Product(1, "Smartphone", 59.9),
        Product(2, "Laptop", 1299.9),
        Product(3, "Headphones", 99.99)
    )

    //permite mostrar un listado dinamico
    LazyColumn {
        items(products) { product ->
            ProductItem(product = product)
        }
    }
}

//composable que muestra un item de la lista de productos
@Composable
fun ProductItem(product: Product) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.fillMaxWidth().padding(4.dp)) {
            Text(text = product.name, fontWeight = FontWeight.Bold)
            Text(text = "${product.price}")
        }
    }
}

//se pueden crear varios preview para ver los composables
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DemoAppTheme {
        ProductList()
    }
}
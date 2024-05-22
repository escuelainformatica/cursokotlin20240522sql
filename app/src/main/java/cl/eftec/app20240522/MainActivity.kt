package cl.eftec.app20240522

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.Room
import cl.eftec.app20240522.dao.AppDatabase
import cl.eftec.app20240522.entidad.User
import cl.eftec.app20240522.entidad.UserMutable
import cl.eftec.app20240522.ui.theme.App20240522Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App20240522Theme {
                var usuarioeditable= remember {
                    UserMutable()
                }
                val db = Room.databaseBuilder(
                    applicationContext,
                    AppDatabase::class.java, "database-name3"
                ).allowMainThreadQueries()
                    .build() // allowMainThreadQueries corra sincronicamente
                
                var usuarios=db.userDao().getAll()
                
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column {
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                        for(us in usuarios) {
                            Text(text = "${us.firstName} ${us.lastName}")
                        }
                        TextField(value = usuarioeditable.firstName.value!!, onValueChange = {
                            usuarioeditable.firstName.value=it
                    })
                        TextField(value = usuarioeditable.lastName.value!!, onValueChange = {
                            usuarioeditable.lastName.value=it
                        })
                        Button(onClick = {
                            db.userDao().insertAll(usuarioeditable.obtenerUser())

                        }) {
                            Text("agregar")

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    App20240522Theme {
        Greeting("Android")
    }
}
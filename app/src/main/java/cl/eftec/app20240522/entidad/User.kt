package cl.eftec.app20240522.entidad

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) var uid: Int?,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
)
class UserMutable {
    var uid= mutableStateOf<Int?>(null);
    var firstName= mutableStateOf<String?>("")
    var lastName= mutableStateOf<String?>("")

    fun obtenerUser():User {
        var datos=User(uid.value,firstName.value,lastName.value);
        return datos
    }
}
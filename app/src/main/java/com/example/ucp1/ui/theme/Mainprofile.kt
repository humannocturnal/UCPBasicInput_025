package com.example.composablelayout2

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {
    // State untuk menyimpan data input dari pengguna
    var Origin by remember { mutableStateOf("") }
    var Departure by remember { mutableStateOf("") }
    var Arrival by remember { mutableStateOf("") }
    var jenis by remember { mutableStateOf("") }
    var submitted by remember { mutableStateOf(false) } // Menyimpan status apakah form sudah di-submit

    // Daftar pilihan transportasi
    val listJk = listOf("Bus", "Ship", "Train", "Plane")

    Column(
        modifier = Modifier
            .fillMaxSize() // Mengisi seluruh ukuran layar
            .padding(16.dp), // Memberikan padding di sekeliling komponen
        horizontalAlignment = Alignment.CenterHorizontally // Menyusun elemen ke tengah secara horizontal
    ) {
        // Menampilkan judul "Biodata" dengan font tebal dan ukuran besar
        Text(text = "Plant Your Adventure", fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Text(text = "Let's plan an exquisite adventure", fontSize = 15.sp, fontWeight = FontWeight.Light)

        // Input untuk Nama
        TextField(
            modifier = Modifier
                .fillMaxWidth() // Mengisi lebar penuh
                .padding(vertical = 8.dp), // Memberikan jarak vertikal
            value = Origin, // Nilai yang ditampilkan
            onValueChange = { Origin = it }, // Mengubah nilai state 'nama' saat input berubah
            label = { Text("Origin") }, // Label yang muncul di atas TextField
            placeholder = { Text("Masukkan Origin Anda") } // Placeholder saat tidak ada input
        )



        // Input untuk departure
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            value = Departure,
            onValueChange = { Departure = it },
            label = { Text("Departure") },
            placeholder = { Text("Masukkan Departure Anda") }
        )

        // Input untuk arrival
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            value = Arrival,
            onValueChange = { Arrival = it },
            label = { Text("Arrival") },
            placeholder = { Text("Masukkan Arrival Anda") }
        )

        // Label untuk pilihan jenis transportasi
        Text(text = "Choose Transportation", fontSize = 16.sp, fontWeight = FontWeight.Medium)

        // Row untuk menampung RadioButton pilihan jenis transportasi
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp), // Jarak vertikal antara elemen
            verticalAlignment = Alignment.CenterVertically // Menyusun elemen di tengah secara vertikal
        ) {
            listJk.forEach { jk ->
                // Row untuk setiap pilihan RadioButton dan labelnya
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(end = 13.dp) // Memberikan jarak di akhir
                ) {
                    // RadioButton untuk setiap pilihan jenis transportasi
                    RadioButton(
                        selected = (jenis == jk), // Mengecek apakah pilihan saat ini terpilih
                        onClick = { jenis = jk } // Mengubah nilai 'jenis' saat dipilih
                    )
                    Text(text = jk) // Menampilkan teks pilihan jenis transportasi
                }
            }
        }



        // Spacer untuk memberikan jarak antara input terakhir dan tombol submit
        Spacer(modifier = Modifier.height(16.dp))

        // Tombol Submit untuk menyimpan data yang diisi
        Button(
            onClick = { submitted = true }, // Mengubah status 'submitted' menjadi true saat tombol diklik
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Submit") // Label pada tombol
        }

        // Spacer untuk memberikan jarak antara tombol submit dan hasil yang di-submit
        Spacer(modifier = Modifier.height(16.dp))

        // Menampilkan hasil input pengguna jika tombol submit sudah diklik
        if (submitted) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                // Teks untuk menunjukkan data yang telah diisi
                Text(text = "Data yang telah diisi:", fontSize = 16.sp, fontWeight = FontWeight.Medium)
                Text(text = "Origin: $Origin") // Menampilkan origin yang diisi
                Text(text = "Choose Transportarion: $jenis") // Menampilkan jenis transportasi yang dipilih
                Text(text = "Departure: $Departure") // Menampilkan departure yang diisi
                Text(text = "Arrival: $Arrival") // Menampilkan arrival yang diisi
            }
        }
    }
}

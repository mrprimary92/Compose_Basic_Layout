package com.wewe.happybirthday

import android.os.Bundle
import android.telephony.PhoneNumberUtils
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.wewe.happybirthday.ui.theme.DeepBlue
import com.wewe.happybirthday.ui.theme.Green
import com.wewe.happybirthday.ui.theme.HappyBirthdayTheme
import java.util.*

class DIYActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = DeepBlue
//                    color = MaterialTheme.colors.background
                ) {
                    val bI1 = BiometricInfo(
                        painterResource(id = R.drawable.baseline_android_24),
                        "Jennifer Doe",
                        "Android Developer Extraordinaire"
                    )
                    val cI1 = ContactInfo("14699999934", "foseja", "fosejaektzja@gmail.com")
                    val pI1 = PersonInfo(bI1, cI1)
                    BusinessCard(pI1)
                }
            }
        }
    }
}

@Composable
fun BusinessCard(pI: PersonInfo) {
    Column() {
        Spacer(Modifier.weight(1f))
        BiometricProfile(pI.bI)
        Spacer(Modifier.weight(1f))
        ContactProfile(pI.cI)
        Spacer(Modifier.weight(0.3f))
    }
}

@Composable
fun BiometricProfile(bI: BiometricInfo) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            painter = bI.imgRs ?: painterResource(id = R.drawable.android_3384009),
            contentDescription = "User Photo",
            modifier = Modifier
                .padding(8.dp)
                .size(200.dp),
            colorFilter = ColorFilter.tint(color = Green)
        )
        Text(
            text = bI.name,
            fontSize = 44.sp,
            modifier = Modifier.padding(8.dp),
            color = Color.White
        )
        Text(
            text = bI.title, fontWeight = FontWeight.Bold,
            fontSize = 12.sp, modifier = Modifier.padding(8.dp), color = Green
        )
    }
}

@Composable
fun ContactProfile(cI: ContactInfo) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        val formattedNumber = PhoneNumberUtils.formatNumber(cI.contact, Locale.getDefault().country)
        ContactFormat(formattedNumber, painterResource(R.drawable.baseline_contact_mail_24))
        ContactFormat(cI.socialMedia, painterResource(R.drawable.baseline_perm_media_24))
        ContactFormat(cI.email, painterResource(R.drawable.baseline_email_24))
    }
}

@Composable
fun ContactFormat(text: String, iconRes: Painter) {
    Column() {

        Divider(color = Color.Gray, thickness = 1.dp)

        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(Modifier.weight(0.2f))
            Row(Modifier.weight(0.8f)) {


                Icon(
                    painter = iconRes,
                    contentDescription = null,
                    modifier = Modifier.padding(8.dp),
                    tint = Green

                )
                Text(
                    text = text,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(8.dp),
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    HappyBirthdayTheme {
        val bI1 = BiometricInfo(painterResource(id = R.drawable.grey_kitten), "kitten", "manager")
        val cI1 = ContactInfo("14699999934", "foseja", "fosejaektzja@gmail.com")
        val pI1 = PersonInfo(bI1, cI1)
        BusinessCard(pI1)
    }
}

data class BiometricInfo(
    val imgRs: Painter?,
    val name: String,
    val title: String
)

data class ContactInfo(
    val contact: String,
    val socialMedia: String,
    val email: String
)

data class PersonInfo(
    val bI: BiometricInfo,
    val cI: ContactInfo
)
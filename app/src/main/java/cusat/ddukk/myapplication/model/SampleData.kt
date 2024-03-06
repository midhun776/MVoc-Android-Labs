import cusat.ddukk.myapplication.R
import cusat.ddukk.myapplication.model.ItemsViewModel
/**
 * SampleData for Jetpack Compose Tutorial
 */
object SampleData {
    // Sample conversation data
    val conversationSample = listOf(
        ItemsViewModel(
            R.drawable.img1,
            "Anu",
            "Test...Test...Test..."
        ),
        ItemsViewModel(
            R.drawable.img2,
            "Anu",
            """List of Android versions:
            |Android KitKat (API 19)
            |Android Lollipop (API 21)
            |Android Marshmallow (API 23)
            |Android Nougat (API 24)
            |Android Oreo (API 26)
            |Android Pie (API 28)
            |Android 10 (API 29)
            |Android 11 (API 30)
            |Android 12 (API 31)""".trim()
        ),
        ItemsViewModel(
            R.drawable.img2,
            "Anu",
            """I think Kotlin is my favorite programming language.
            |It's so much fun!""".trim()
        ),
        ItemsViewModel(
            R.drawable.img1,
            "Anu",
            "Searching for alternatives to XML layouts..."
        ),
        ItemsViewModel(
            R.drawable.img3,
            "Binu",
            """Hey, take a look at Jetpack Compose, it's great!
            |It's the Android's modern toolkit for building native UI.
            |It simplifies and accelerates UI development on Android.
            |Less code, powerful tools, and intuitive Kotlin APIs :)""".trim()
        ),
        ItemsViewModel(
            R.drawable.img1,
            "Binu",
            "It's available from API 21+ :)"
        ),
        ItemsViewModel(
            R.drawable.img2,
            "Binu",
            "Writing Kotlin for UI seems so natural, Compose where have you been all my life?"
        ),
        ItemsViewModel(
            R.drawable.img3,
            "Binu",
            "Android Studio next version's name is Arctic Fox"
        ),
        ItemsViewModel(
            R.drawable.img2,
            "Binu",
            "Android Studio Arctic Fox tooling for Compose is top notch ^_^"
        ),
        ItemsViewModel(
            R.drawable.img2,
            "Sinu",
            "I didn't know you can now run the emulator directly from Android Studio"
        ),
        ItemsViewModel(
            R.drawable.img3,
            "Sinu",
            "Compose Previews are great to check quickly how a composable layout looks like"
        ),
        ItemsViewModel(
            R.drawable.img1,
            "Sinu",
            "Previews are also interactive after enabling the experimental setting"
        ),
        ItemsViewModel(
            R.drawable.img2,
            "Sinu",
            "Have you tried writing build.gradle with KTS?"
        ),
    )
}

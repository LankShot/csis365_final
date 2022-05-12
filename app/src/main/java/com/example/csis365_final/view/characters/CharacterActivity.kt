package com.example.csis365_final.view.characters

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources.Theme
import android.net.Uri
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.*
import androidx.core.content.ContextCompat
import com.example.csis365_final.R


class CharacterActivity : AppCompatActivity() {

    lateinit var GFG_URI : String
    private var package_name = "com.android.chrome"

    lateinit var button :Button
    lateinit var characterName: TextView
    lateinit var characterHeight: TextView
    lateinit var characterRace: TextView
    lateinit var characterGender: TextView
    lateinit var characterBirth: TextView
    lateinit var characterSpouse: TextView
    lateinit var characterDeath: TextView
    lateinit var characterRealm: TextView
    lateinit var characterHair: TextView

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character)
        bindViews()
        setTexts()

        val bundle = intent.extras?.getBundle("bundle")
        GFG_URI = bundle?.getString("wikiUrl").toString()

        button.setOnClickListener {

            val builder = CustomTabsIntent.Builder()

            val params = CustomTabColorSchemeParams.Builder()
            params.setToolbarColor(R.color.purple_500)
            builder.setDefaultColorSchemeParams(params.build())

            builder.setShowTitle(true)

            builder.setShareState(CustomTabsIntent.SHARE_STATE_ON)

            builder.setInstantAppsEnabled(true)

            val customBuilder = builder.build()

            customBuilder.intent.setPackage(package_name)
            customBuilder.launchUrl(this, Uri.parse(GFG_URI))
        }
    }

    fun bindViews(){
        button = findViewById(R.id.character_button)
        characterBirth = findViewById(R.id.character_birth)
        characterDeath = findViewById(R.id.character_death)
        characterGender = findViewById(R.id.character_gender)
        characterHair = findViewById(R.id.character_hair)
        characterHeight = findViewById(R.id.character_height)
        characterName = findViewById(R.id.character_name)
        characterRace = findViewById(R.id.character_race)
        characterRealm = findViewById(R.id.character_realm)
        characterSpouse = findViewById(R.id.character_spouse)
    }

    fun setTexts(){
        val bundle = intent.extras?.getBundle("bundle")
        characterSpouse.text = bundle?.getString("spouse")
        characterRealm.text = bundle?.getString("realm")
        characterRace.text = bundle?.getString("race")
        characterName.text = bundle?.getString("name")
        characterHeight.text = bundle?.getString("height")
        characterHair.text = bundle?.getString("hair")
        characterGender.text = bundle?.getString("gender")
        characterDeath.text = bundle?.getString("death")
        characterBirth.text = bundle?.getString("birth")
    }
}

package com.sabo.dominik.animalsoundboard

import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mSoundPool: SoundPool
    private var mLoaded: Boolean = false
    var mSoundMap: HashMap<Int, Int> = HashMap()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setUpUi()
        this.loadSounds()
    }

    private fun setUpUi() {
        this.ibDog.setOnClickListener(this)
        this.ibCat.setOnClickListener(this)
        this.ibMouse.setOnClickListener(this)
        this.ibHorse.setOnClickListener(this)
        this.ibLion.setOnClickListener(this)
        this.ibElephant.setOnClickListener(this)
        this.ibChimpanzee.setOnClickListener(this)
        this.ibKookaburra.setOnClickListener(this)
        this.ibCow.setOnClickListener(this)
        this.ibSheep.setOnClickListener(this)
        this.ibChicken.setOnClickListener(this)
        this.ibPig.setOnClickListener(this)
    }

    private fun loadSounds() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.mSoundPool = SoundPool.Builder().setMaxStreams(12).build()
        } else {
            this.mSoundPool = SoundPool(12, AudioManager.STREAM_MUSIC, 0)
        }

        this.mSoundPool.setOnLoadCompleteListener { _, _, _ -> mLoaded = true }
        this.mSoundMap[R.raw.dog] = this.mSoundPool.load(this, R.raw.dog, 1)
        this.mSoundMap[R.raw.cat] = this.mSoundPool.load(this, R.raw.cat, 1)
        this.mSoundMap[R.raw.mouse] = this.mSoundPool.load(this, R.raw.mouse, 1)
        this.mSoundMap[R.raw.horse] = this.mSoundPool.load(this, R.raw.horse, 1)
        this.mSoundMap[R.raw.lion] = this.mSoundPool.load(this, R.raw.lion, 1)
        this.mSoundMap[R.raw.elephant] = this.mSoundPool.load(this, R.raw.elephant, 1)
        this.mSoundMap[R.raw.chimpanzee] = this.mSoundPool.load(this, R.raw.chimpanzee, 1)
        this.mSoundMap[R.raw.kookaburra] = this.mSoundPool.load(this, R.raw.kookaburra, 1)
        this.mSoundMap[R.raw.cow] = this.mSoundPool.load(this, R.raw.cow, 1)
        this.mSoundMap[R.raw.sheep] = this.mSoundPool.load(this, R.raw.sheep, 1)
        this.mSoundMap[R.raw.chicken] = this.mSoundPool.load(this, R.raw.chicken, 1)
        this.mSoundMap[R.raw.pig] = this.mSoundPool.load(this, R.raw.pig, 1)
    }

    override fun onClick(v: View) {
        if (!this.mLoaded) return
        when (v.id) {
            R.id.ibDog -> playSound(R.raw.dog)
            R.id.ibCat -> playSound(R.raw.cat)
            R.id.ibMouse -> playSound(R.raw.mouse)
            R.id.ibHorse -> playSound(R.raw.horse)
            R.id.ibLion -> playSound(R.raw.lion)
            R.id.ibElephant -> playSound(R.raw.elephant)
            R.id.ibChimpanzee -> playSound(R.raw.chimpanzee)
            R.id.ibKookaburra -> playSound(R.raw.kookaburra)
            R.id.ibCow -> playSound(R.raw.cow)
            R.id.ibSheep -> playSound(R.raw.sheep)
            R.id.ibChicken -> playSound(R.raw.chicken)
            R.id.ibPig -> playSound(R.raw.pig)
        }
    }

    fun playSound(selectedSound: Int) {
        val soundID = this.mSoundMap[selectedSound] ?: 0
        this.mSoundPool.play(soundID, 1f, 1f, 1, 0, 1f)
    }
}
package com.github.theapache64.dexdiff.ui.splash

import com.github.theapache64.dexdiff.app.App
import com.github.theapache64.dexdiff.ui.home.HomeActivity
import com.theapache64.cyclone.core.Activity
import com.theapache64.cyclone.core.Intent
import javax.inject.Inject

class SplashActivity : Activity() {
    companion object {
        fun getStartIntent(): Intent {
            return Intent(SplashActivity::class).apply {
            }
        }
    }

    @Inject
    lateinit var viewModel: SplashViewModel


    override fun onCreate() {
        super.onCreate()
        App.di.inject(this)

        with(viewModel) {
            welcomeMsg.observe {
                println(it)
            }

            goToHome.observe { splashMsg ->
                startActivity(
                    intent = HomeActivity.getStartIntent(splashMsg)
                )
            }
        }

    }
}
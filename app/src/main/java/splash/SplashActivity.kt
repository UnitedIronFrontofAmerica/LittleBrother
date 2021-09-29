package splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.example.littlebrother_copwatch.MainActivity
import com.example.littlebrother_copwatch.R
import kotlinx.coroutines.delay

class SplashActivity : AppCompatActivity() {
    private var icEyeLogo: ImageView? = null
    private var icRevolvingCircle: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        supportActionBar?.hide()

        icRevolvingCircle = findViewById(R.id.rev_splash_circle)
        icRevolvingCircle?.animate()?.apply {
            startDelay = 100
            rotation(360f)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }?.duration = 2400

        icEyeLogo = findViewById(R.id.ic_splash_eye)
        Handler().postDelayed({
            icEyeLogo?.animate()?.setDuration(1500)?.alpha(1f)?.withEndAction {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                finish()
            }
        }, 1500)
    }
}

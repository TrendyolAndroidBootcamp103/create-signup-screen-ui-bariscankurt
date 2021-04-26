package school.cactus.succulentshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import school.cactus.succulentshop.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}
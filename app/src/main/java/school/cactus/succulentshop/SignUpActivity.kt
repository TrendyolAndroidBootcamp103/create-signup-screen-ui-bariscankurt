package school.cactus.succulentshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    val emailValidator = EmailValidator()
    val passwordValidator = PasswordValidator()
    val usernameValidator = UsernameValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.apply {
            signUpButton.setOnClickListener{
                val email = binding.emailInputLayout.editText!!.text
                val password = binding.passwordInputLayout.editText!!.text
                val username = binding.usernameInputLayout.editText!!.text
                validateEmail()
                when {
                    password.isEmpty() -> {
                        binding.passwordInputLayout.error = "Bu alan boş olamaz"
                    }
                    else -> {
                        binding.passwordInputLayout.error = null
                        binding.emailInputLayout.isErrorEnabled = false
                    }
                }

                validateUserName()
            }
        }
    }

    private fun validate(textInputLayout: TextInputLayout, validator: Validator) = textInputLayout.let{
        val errorMessage = validator.validateSingIn(it.editText!!.text.toString())
        it.error = errorMessage?.resolveAsString()
        it.isErrorEnabled = errorMessage != null
    }



    private fun validateEmail() = validate(binding.emailInputLayout, emailValidator)

    private fun validateUserName() = validate(binding.usernameInputLayout, usernameValidator)

    private fun validatePassword(){
        binding.passwordInputLayout.let{
            val errorMessage = passwordValidator.validate(it.editText!!.text.toString())
            it.error = errorMessage?.resolveAsString()
            it.isErrorEnabled = errorMessage != null
        }
    }

    private fun Int.resolveAsString() = getString(this)

    
}
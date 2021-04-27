package school.cactus.succulentshop

import java.util.regex.Pattern

class UsernameValidator : Validator {
    override fun validate(field: String): Int? {
        TODO("Not yet implemented")
    }

    override fun validateLogin(field: String): Int? = when{
        field.isEmpty() -> R.string.username_is_required
        else -> null
    }

    override fun validateSingIn(field: String): Int? = when{
        field.isEmpty() -> R.string.username_is_required
        field.isContainSpecialChar().not() -> R.string.username_can_only_include
        field.length <= 2 -> R.string.username_is_too_short
        field.length >= 20 -> R.string.username_is_too_long
        else -> null
    }
}
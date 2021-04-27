package school.cactus.succulentshop

class PasswordValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.this_field_is_required

        else -> null
    }

    override fun validateLogin(field: String): Int? {
        TODO("Not yet implemented")
    }

    override fun validateSingIn(field: String): Int? {
        TODO("Not yet implemented")
    }
}
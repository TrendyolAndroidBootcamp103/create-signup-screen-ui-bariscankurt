package school.cactus.succulentshop

class EmailValidator: Validator {
    override fun validate(field: String): Int? {
        TODO("Not yet implemented")
    }

    override fun validateLogin(field: String): Int? = when{
        field.isEmpty() -> R.string.this_field_is_required
        field.length < 5 -> R.string.identifier_is_too_short
        else -> null
    }

    override fun validateSingIn(field: String): Int? = when{
        field.isEmpty() -> R.string.email_is_required
        field.length < 5 || field.length > 20 -> R.string.email_is_invalid
        field.contains("@",ignoreCase = true).not() -> R.string.email_is_invalid
        else -> null
    }
}
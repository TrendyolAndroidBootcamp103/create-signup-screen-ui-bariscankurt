package school.cactus.succulentshop


class IdentifierValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.this_field_is_required
        field.length < 5 -> R.string.identifier_is_too_short
        else -> null
    }

    override fun validateLogin(field: String): Int? {
        TODO("Not yet implemented")
    }

    override fun validateSingIn(field: String): Int? {
        TODO("Not yet implemented")
    }
}
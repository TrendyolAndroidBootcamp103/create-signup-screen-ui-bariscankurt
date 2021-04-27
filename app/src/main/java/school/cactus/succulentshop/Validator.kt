package school.cactus.succulentshop

interface Validator {
    fun validate(field: String): Int?
    fun validateLogin(field: String): Int?
    fun validateSingIn(field: String): Int?
}
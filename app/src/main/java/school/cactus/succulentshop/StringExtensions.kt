package school.cactus.succulentshop

fun String.isContainSpecialChar(): Boolean{

    for(char in this){
        if(char.isLetterOrDigit() || char == '_')
            continue
        else
            return false
    }
    return true
}
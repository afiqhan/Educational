package com.afiq.conditionalstatements.task1.KotlinFundamentalsPractice

open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff() {
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}
class FoldablePhone (var isFoldablePhone: Boolean = false):
    Phone(){
    override fun switchOn() {
        if(!isFoldablePhone) {
            isScreenLightOn = false
            println("Phone is unfolded")
        }else{
            isScreenLightOn = true
        }

    }
    fun fold(){
        isFoldablePhone = false
    }
    fun unfold(){
        isFoldablePhone = true
    }
}
fun main() {
    var myPhone = FoldablePhone()
    myPhone.switchOn()
    myPhone.checkPhoneScreenLight()
    myPhone.unfold()
    myPhone.switchOn()
    myPhone.checkPhoneScreenLight()
    myPhone.fold()
    myPhone.switchOn()
    myPhone.checkPhoneScreenLight()
}
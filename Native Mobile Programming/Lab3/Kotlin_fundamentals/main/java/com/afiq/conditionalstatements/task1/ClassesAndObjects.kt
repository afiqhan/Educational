package com.afiq.conditionalstatements.task1

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor
import kotlin.reflect.full.superclasses

//1: Define a class
//5: Define Primary constructor
open class SmartDevice (val name: String, val category: String) {
    //4:Define class properties, //7: Visibility modifiers
    var deviceStatus = "off"
        protected set

    //Override superclass properties from subclasses
    open val deviceType = "unknown"

    //5: Define Secondary constructor
    constructor(name: String, category: String, statusCode: Int) : this(name, category) {
        deviceStatus = when (statusCode) {
            0 -> "offline"
            1 -> "online"
            else -> "unknown"
        }
    }
    //3: Define class methods
    //Override superclass methods from subclasses
    open fun turnOn() {
        deviceStatus = "on"
    }
    open fun turnOff() {
        deviceStatus = "off"
    }
    // 10: Try this challenge: toString to view all the attributes for this class
    fun printDeviceInfo():String{
        return  "Device name: $name, category: $category, type: $deviceType";
    }
}

// 6: Use classes and objects in Kotlin
class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    //Override superclass properties from subclasses
    override val deviceType = "Smart TV"

    //8: Define property delegates
    private var speakerVolume by RangeRegulator(initialValue = 2, minValue = 0, maxValue = 100)
    private var channelNumber by RangeRegulator(initialValue = 1, minValue = 0, maxValue = 200)

    //7: Visibility modifiers
//    private var speakerVolume = 2
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }
//
//    private var channelNumber = 1
//        set(value) {
//            if (value in 0..200) {
//                field = value
//            }
//        }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Speaker volume increased to $speakerVolume.")
    }
    // 10: Try this challenge:
    fun decreaseVolume() {
        speakerVolume--
        println("Speaker volume decreased to $speakerVolume.")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel number increased to $channelNumber.")
    }
    // 10: Try this challenge:
    fun previousChannel() {
        channelNumber--
        println("Channel number decreased to $channelNumber.")
    }
    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}
// 6: Use classes and objects in Kotlin
class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    //Override superclass properties from subclasses
    override val deviceType = "Smart Light"

    //8: Define property delegates
    private var brightnessLevel by RangeRegulator(initialValue = 0, minValue = 0, maxValue = 100)

    //7: Visibility modifiers
//    private var brightnessLevel = 0
//        set(value) {
//            if (value in 0..100) {
//                field = value
//            }
//        }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness increased to $brightnessLevel.")
    }
    // 10: Try this challenge:
    fun decreaseBrightness() {
        brightnessLevel--
        println("Brightness decreased to $brightnessLevel.")
    }
    //Override superclass methods from subclasses
    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}
// 6: Use classes and objects in Kotlin
class SmartHome(
    val smartTvDevice: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    // to get the number of devices in the smart home
    private var numberOfClasses: Int? = this::class.primaryConstructor?.parameters?.size

    //7: Visibility modifiers
    private var deviceTurnOnCount by RangeRegulator(initialValue = 0, minValue = 0, maxValue = numberOfClasses!!)

    fun numberOfDevicesOn():Int{
        return deviceTurnOnCount
    }
    // 10: Try this challenge: it will only update the deviceTurnOnCount when the device status is 'on'
    fun turnOnTv() {
        if(smartTvDevice.deviceStatus == "off"){
            deviceTurnOnCount++
            smartTvDevice.turnOn()
        }

    }
    // 10: Try this challenge: it will only update the deviceTurnOnCount when the device status is 'off'
    fun turnOffTv() {
        if(smartTvDevice.deviceStatus == "on"){
            deviceTurnOnCount--
            smartTvDevice.turnOff()
        }
    }
    fun increaseTvVolume() {
        smartTvDevice.deviceStatus.takeIf { it == "on" }?.run {
            smartTvDevice.increaseSpeakerVolume()
        } ?: println("${smartTvDevice.name} is Off, turn it on first")
    }
    // 10: Try this challenge:
    fun decreaseTvVolume() {
        smartTvDevice.deviceStatus.takeIf { it == "on" }?.run {
            smartTvDevice.decreaseVolume()
        } ?: println("${smartTvDevice.name} is Off, turn it on first")
    }

    fun changeTvChannelToNext() {
        smartTvDevice.deviceStatus.takeIf { it == "on" }?.run {
            smartTvDevice.nextChannel()
        } ?: println("${smartTvDevice.name} is Off, turn it on first")
    }
    fun changeTvChannelToPrevious() {
        smartTvDevice.deviceStatus.takeIf { it == "on" }?.run {
            smartTvDevice.previousChannel()
        } ?: println("${smartTvDevice.name} is Off, turn it on first")

    }
    fun turnOnLight() {
        if(smartLightDevice.deviceStatus == "off") {
            deviceTurnOnCount++
            smartLightDevice.turnOn()
        }
    }
    fun turnOffLight() {
        if(smartLightDevice.deviceStatus == "on") {
            deviceTurnOnCount--
            smartLightDevice.turnOff()
        }
    }

//    fun increaseLightBrightness() {
//        if(deviceTurnOnCount == 1)
//            smartLightDevice.increaseBrightness()
//        else
//            println("Device is Off, turn it on first")
//    }
    fun increaseLightBrightness() {
        smartLightDevice.deviceStatus.takeIf { it == "on" }?.run {
            smartLightDevice.increaseBrightness()
        } ?: println("${smartLightDevice.name} is Off, turn it on first")
    }
    // 10: Try this challenge:
//    fun decreaseLightBrightness() {
//        smartLightDevice.decreaseBrightness()
//    }
    fun decreaseLightBrightness() {
        smartLightDevice.deviceStatus.takeIf { it == "on" }?.run {
            smartLightDevice.decreaseBrightness()
        } ?: println("${smartLightDevice.name} is Off, turn it on first")
    }
    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
    fun printSmartTvInfo(){
        println(smartTvDevice.printDeviceInfo())
    }
    fun printSmartLightInfo(){
        println(smartLightDevice.printDeviceInfo())
    }
}

// Class: 8: Define property delegates
class RangeRegulator(
    initialValue: Int,
    private val minValue: Int,
    private val maxValue: Int
) : ReadWriteProperty<Any?, Int> {

    var fieldData = initialValue

    override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return fieldData
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        if (value in minValue..maxValue) {
            fieldData = value
        }
    }
}
//Main function
fun main() {
    //2:Create an instance of a class
//    val smartTvDevice = SmartDevice(name = "Android TV", category = "Entertainment", statusCode = 0)
//    println("Device name is: ${smartTvDevice.name}")
//    println(smartTvDevice.toString())
//    smartTvDevice.turnOn()
//    smartTvDevice.turnOff()

    //Final output
    var smartDevice: SmartHome = SmartHome(
        SmartTvDevice("Android TV", "Entertainment"),
        SmartLightDevice("Google Light", "Utility"))
    smartDevice.turnOnLight()
//    smartDevice.turnOnTv()
    smartDevice.decreaseTvVolume()
    smartDevice.changeTvChannelToPrevious()
    smartDevice.decreaseLightBrightness()
    println("Number of devices on: ${smartDevice.numberOfDevicesOn()}")
    println("\nDevices information\n--------------------")
    smartDevice.printSmartTvInfo()
    smartDevice.printSmartLightInfo()

}
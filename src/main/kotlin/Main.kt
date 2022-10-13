class Box(){
    var side1:Double = 0.0
    var side2:Double = 0.0
    var side3:Double = 0.0
    var isOk:Boolean = false

    fun calcVolume(): Double {
        return side1 * side2 * side3
    }

    fun checkIfDouble(stringToCheck: String):Double{
        val retValue = stringToCheck.toDoubleOrNull()
        if (retValue != null && retValue > 0.0) {
            return retValue
        } else {
            println("Parameter $stringToCheck is incorrect")
        }
        return 0.0
    }
    fun input(){
        for (i in 0..2)
            println(i)
        println("Введите длину или сразу 3 значения (длину, ширину и высоту), разделённые пробелом")
        var inputString: String = readln()
        var userInputArray = inputString.split(" ").toTypedArray()
        when (userInputArray.size){
            1 -> {
                if (this.checkIfDouble(userInputArray[0])>0.0) {
                    this.side1 = this.checkIfDouble(userInputArray[0])
                    println("Side 1 is ${this.side1}. Please, input size 2")
                    inputString = readln()
                    if (this.checkIfDouble(inputString)>0.0) {
                        this.side2 = this.checkIfDouble(inputString)
                        println("Side 1 is ${this.side1}, side 2 is ${this.side2}. Pleade, input side 3")
                        inputString = readln()
                        if (this.checkIfDouble(inputString) > 0.0) {
                            this.side3 = this.checkIfDouble(inputString)
                            this.isOk = true
                        }
                    } else
                    {
                        println("The value ${inputString} is incorrect")
                    }
                } else {
                    println("The value ${userInputArray[0]} is incorrect")
                }
            }
            3 -> {
                if (this.checkIfDouble(userInputArray[0])>0.0)
                    this.side1 = userInputArray[0].toDouble()
                if (this.checkIfDouble(userInputArray[1])>0.0)
                    this.side2 = userInputArray[1].toDouble()
                if (this.checkIfDouble(userInputArray[2])>0.0)
                    this.side3 = userInputArray[2].toDouble()
                this.checkIsOk()
            }
        }
    }

    fun checkIsOk() :Boolean{
        this.isOk=(this.side1 > 0.0 && this.side2 > 0.0 && this.side3 > 0.0)
        return this.isOk
    }
}

fun main(args: Array<String>) {
    val boxObj =  Box()
    var counter = 0
    if(args.size==3) {
        args.asList().filter { it -> it.length > 0 }.forEach {
            if (counter==0 && boxObj.checkIfDouble(it) > 0.0) boxObj.side1 = it.toDouble()
            if (counter==1 && boxObj.checkIfDouble(it) > 0.0) boxObj.side2 = it.toDouble()
            if (counter==2 && boxObj.checkIfDouble(it) > 0.0) boxObj.side3 = it.toDouble()
            counter ++
        }
        boxObj.checkIsOk()
    } else {

        boxObj.input()
    }
    if (boxObj.isOk) {
      print("The box volume is "+boxObj.calcVolume())
    } else {
        "Someghing wrong with the parameters"
    }
}

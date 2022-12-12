fun calsTax(a: Int = 1000): Double {
    val tax_rati = 0.13
    return a * tax_rati.toDouble()
}

fun calcChair(bugs: Int): Int {
    return bugs + (bugs / 2).toInt()
}

fun calcBugMoneyValue(dayNumber: Int, bugRank: Int, cashAmount: Int): Int {
    return (dayNumber * bugRank + 42) * cashAmount
    //enter your function implementation here

}

fun getYearEra(year: Int): String {
    var str: String = "Forever Unix"
    when {
        year < 1970 -> str = "before"
        year == 1970 -> str = "equals"
        year < 2000 -> str = "after (XX century)"
        year < 2100 -> str = "after (XXI century)"
        else -> str = "distant future"
    }
    return str
    //enter your function implementation here
}

fun calculateEvenDigits(input: String): Int {
    // enter your function code here
    var sum1: Int = 0
    for (c in input) {
        if (c.toString().toInt() % 2 == 0) sum1 += c.toString().toInt()
    }
    return sum1
}

fun calculateBugMentions(input: List<String>): Int {
    // enter your function code here
    var bug: Int = 0
    for (word in input) {
        if (word == "BUG") bug += 1
    }
    return bug
}

class NibirunianClass {
    public var namePlate: String = ""
    fun createNamePlate(name: String) {
        //"Live long and prosper, ${name}".also { namePlate = it }
        this.namePlate = "Live long and prosper, ${name}"
    }
}

class rectangle(h: Int, w: Int) {
    public var h: Int = 0
    public var w: Int = 0

    init {
        this.h = h
        this.w = w
    }
}

open class rectangle1(var h: Int, var w: Int) {
    open fun sq() = h * w
}

class magicRect(h: Int, w: Int):rectangle1(h, w), Magic {
    final override fun sq(): Int {
        return super<Magic>.Magic() * super<rectangle1>.sq()
    }
}

interface Magic {
    fun Magic() = 42
}

class Player(
    var str: Int = 0, var dex: Int = 0, var XP: Int = 0, var lvl: Int = 1,
    var nextLvXP: Int = 10
) {
    fun recieveXP(xp: Int) {
        XP += xp
        if (XP >= nextLvXP) lvlUP()
        println("Debug(recieveXP) => str= ${str} dex=${dex} lvl=${lvl}")
    }

    private fun lvlUP() {
        lvl += 1
        str += if (lvl % 2 == 0) 1 else 0
        dex += if (lvl % 2 == 1) 1 else 0

        nextLvXP += 100
    }
}

open class Item(var lvl: Int, var weight: Double)

open class Weapon(lvl: Int, weight: Double):Item(lvl, weight) {
    open fun calcDamage(): Int {
        return 42
    }
}

class MagicWeapon(lvl: Int, weight: Double): Weapon(lvl, weight) {
    override fun calcDamage(): Int {
        return super.calcDamage() * 2
    }
}

class SugarStorage(public var volume: Int = 0){
    fun decreaseSugar(v: Int) {
        if (v > 0) {
            volume -= v
            if (volume < 0) volume = 0
        }
    }

    fun increaseSugar(v: Int) {
        if (v > 0) {
            volume += v
            if (volume < 0) volume = 0
        }
    }
}

open class Bug(val rank: Int, val name:String) {
    open fun getSugarLimit(): Int{
        return rank
    }

    fun getId(): String{
        return "${rank}.${name}"
    }
}

class BugCivilian(rank: Int, name: String):Bug(rank, name) {
    override fun getSugarLimit(): Int {
        return super.getSugarLimit()/2
    }
}
fun showAllYourSugar(bug: Bug) {
    println("Bug ${bug.getId()} has ${bug.getSugarLimit()} sugar")
}

fun getCubeList(n:Int): List<Int>{
    var cube_n: MutableList<Int> = MutableList<Int> (n, {i -> i*i*i})
    return cube_n
}

fun calculateWordStat(input:String): String{
    var list: List<String> = input.split(" ")
    var smax: Int = 0
    var wmax: String = ""
    var wrd: String = ""
    var cnt: Int = 1
    for (word in list.sorted()) {
        if (word == wrd) {
            cnt += 1
            wrd = word
        }
        else {
            if (cnt > smax) {
                smax = cnt
                wmax = wrd
            }
            cnt = 1
            wrd = word
        }
    }
    if (cnt > smax) {
        wmax = wrd
    }
    return wmax
}

// fun calculateWordStat(input:String): String = input.split(" ").groupingBy { it }.eachCount().maxBy { it.value }!!.key

//fun calculateWordStat(input:String) =
//    input.split(" ")          // разделяем строку на список слов
//        .groupBy { it }                // создаём map'у типа {dfdf=[dfdf, dfdf, dfdf], rhgrehr=[rhgrehr]}
//        .maxByOrNull { it.value.size } // находим максимальный элемент map'ы, по длинне списка значения
//        ?.key                          // пробрасываем(?) NullPointerException
//                                       // и выводим ключ максимального по значению элемента map'ы

//fun calculateWordStat(input:String): String{
//    return input.split(" ").groupBy({ it }).map({ it.value }).maxBy({ it.size }).orEmpty().first()
//}

// fun calculateWordStat(input:String) = input.split(' ').groupBy{it}.maxBy { it.value.size }?.key

fun  exceptionExample() {
    throw Exception("Exception")
}

class DogException() : Exception()
class CatException() : Exception()
fun checkClient(client : String) {
    if (client == "dog") throw DogException()
    if (client == "cat") throw CatException()
}

class SphinxesException() : Exception()

fun rawEngineStatus(engineNumber:Int):String {
    return "42"
}

//fun engineStatus(engineNumber:Int): String{
//    try {
//        return rawEngineStatus(engineNumber)
//    }
//    catch (e:EngineNotFoundException) {return "engine ${engineNumber} not found"}
//    catch (e:SensorsMeltException) {return "engine ${engineNumber} offline"}
//
//
//    // Call rawEngineStatus(engineNumber)
//    // If exception EngineNotFoundException -  "engine <number> not found"
//    // If exception SensorsMeltException - "engine <number> offline"
//    // If no exceptions  - return rawEngineStatus output
//
//
//    return "I don't know anything about space engines!"
//
//}

fun getLength1(str: String?):Int? = str?.length

fun getLength2(str: String?):Int = str?.length ?:0

fun getLength(str: String?):Int = str!!.length

fun calcNullValues(input: Array<Int?>):Array<Int>{
    var notnull: Int = 0
    var itsnull: Int = input.count { it == null}
    for (word in input) {
        if (word != null) {
            notnull += word
        }
    }
    return arrayOf(itsnull, notnull)
}

fun calcNullValues1(input: Array<Int?>) = arrayOf(input.count{ it == null}, input.sumBy { it ?: 0 })

fun main(args: Array<String>) {
    println(calcNullValues(arrayOf(82, null, null, null, null, null, 7, 55, null, 59, 4, 25, null, null, 66, null, 3, 62, 55, null, 42, 5, 35, 8,null)))


//    println(getLength("MT3C0V5IA7EN2VLEAJYU3PWHJ6X4OGGXIHBHHKLYQZH5738HNVZRTGO0MHGRZGZDKDS9SIQ7S3Q5L9L2QISAXDRW1W7F156SYM"))
//    println(getLength("7VWRKJS1WDNP60772JLVL3SJCZADUIGQ0WGOYYHQ4I0XMMM7OZBXIZJWUG5X8J44YVPGO1396TG0EENYJ8YSNG"))
//    println(getLength(null))
//      println(calculateWordStat("PDDPEM MXWHL XJID XJID XJID DTQEHGC DTQEHGC MXWHL XJID DTQEHGC DTQEHGC MXWHL PDDPEM QUCO DTQEHGC MXWHL DTQEHGC MXWHL PDDPEM XJID MXWHL DTQEHGC DTQEHGC XJID XJID XJID MXWHL MXWHL MXWHL MXWHL DTQEHGC PDDPEM DTQEHGC DTQEHGC PDDPEM"))
//      println(calculateWordStat("KTTKAP ZSAC RKSLNFE LYAB ZSAC ZSAC NQUZKL LYAB ZSAC KTTKAP ZSAC ZSAC KTTKAP RKSLNFE ZSAC ZSAC RKSLNFE LYAB ZSAC RKSLNFE KTTKAP LYAB RKSLNFE NQUZKL RKSLNFE LYAB RKSLNFE RKSLNFE LYAB RKSLNFE KTTKAP ZSAC RKSLNFE KTTKAP ZSAC LYAB LYAB LYAB RKSLNFE ZSAC"))
//      println(calculateWordStat("BAMMWC ZTSKPZ LLXMOU BAMMWC BAMMWC BAMMWC IFYXBAB GSLXNL GSLXNL GSLXNL IFYXBAB IFYXBAB LLXMOU GSLXNL BAMMWC GSLXNL LLXMOU GSLXNL IFYXBAB GSLXNL LLXMOU GSLXNL IFYXBAB GSLXNL GSLXNL GSLXNL IFYXBAB IFYXBAB IFYXBAB GSLXNL IFYXBAB LLXMOU BAMMWC IFYXBAB ZTSKPZ BAMMWC BAMMWC BAMMWC IFYXBAB LLXMOU"))
//    println(getCubeList(6))

//    val bug = Bug(8, "War-lord")
//    showAllYourSugar(bug)
//
//    val bugCivil = BugCivilian(8, "Peace-duke")
//    showAllYourSugar(bugCivil)
//
//    var p1: Player = Player(str = 2)
//    val instance: MagicWeapon = MagicWeapon(1, 1.0)
//    println("Damage = ${instance.calcDamage()}")
//
//    p1.recieveXP(10)
//    p1.recieveXP(100)
//    p1.recieveXP(100)




//    var rct: rectangle1 = rectangle1(4,5)
//    println(rct.h)
//    println(rct.w)
//    println(
//        calculateBugMentions(
//            "KLPQYM BUG KHQR KLPQYM JVOJTD JVOJTD BUG BUG KHQR BUG KLPQYM JVOJTD KLPQYM JVOJTD QLSPA KHQR JVOJTD KLPQYM JVOJTD KLPQYM KLPQYM JVOJTD JVOJTD BUG KLPQYM KHQR JVOJTD KHQR KLPQYM KLPQYM JVOJTD KLPQYM BUG BUG BUG".split(
//                " "
//            )
//        )
//    )
    //println(calculateEvenDigits("660308340"))
    //println(calcBugMoneyValue(10, 2, 25))
//    val xs: String? = readLine()
//    if (xs == null) return
//    val x = xs.toInt()
//    println(getYearEra(x))
//    when {
//        x == 5 -> println("1")
//        x%5 == 0 -> println("2")
//
//    }

//    val bugs: String? = readLine()
//    if (bugs == null) return
//    val bugs_int = bugs.toInt()
//    println("${calcChair(bugs_int)} Chair for ${bugs} Bugs")

    //val firstname: String? = readLine()
    //val lastname: String? = readLine()
//    val sum_user: String? = readLine()
//
//    if (sum_user == null) return
//    val sum_: Int = sum_user.toInt()
//    val tax: Double = calsTax(sum_)
//    println("For ${sum_user} Tax = ${tax}")

    //println("Hello ${firstname} ${lastname}!")

    //println("Oh mighty ruler of Bug Kingdom, the earthling called ${firstname} seeks for your wisdom!")
    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    //println("Program arguments: ${args.joinToString()}")
}
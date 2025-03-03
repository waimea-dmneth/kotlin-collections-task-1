/**
 * =====================================================
 * Kotlin Collections Task 1 - Monkeys
 *
 *    __v__
 *   ( o o )   __v__
 *    (---)   ( o o )
 *             (---)
 *
 * Oh, no! There are monkeys loose in your house. You
 * had better collect all their names so that you can
 * report them to the authorities!
 */


fun main() {
    println("Kotlin Collections Task 1 - Monkeys")
    println("-----------------------------------")
    println()

    // Create a list to store monkey names
    val monkeys = mutableListOf<String>()  // FIXME!

    // Add in some test monkeys
    monkeys.add("Dave")
    monkeys.add("Jimmy")
    monkeys.add("Amy")

    // Show the monkeys
    showMonkeys(monkeys)
    println(monkeyCounter(monkeys))

    // Check the list
    check(monkeys.count() == 3)
    check(monkeyCounter(monkeys) == "\nThere are 3 Monkeys")

    // See which monkey has the longest name
    println(longestMonkeyName(monkeys))
    check(longestMonkeyName(monkeys) == "Monkeys with the Longest name is [Jimmy] each having 5 characters")

    // Adding Monkeys --------------------------------------------

    // Ask the user for three new monkey names and add to the list
    for (i in 1..3) {
        getNewMonkey(monkeys)
    }

    // Show the monkeys
    showMonkeys(monkeys)
    println(monkeyCounter(monkeys))
    println(longestMonkeyName(monkeys))

    // Check the list
    check(monkeys.count() == 6)
    check(monkeyCounter(monkeys) == "\nThere are 6 Monkeys")

    // Removing Monkeys --------------------------------------------

    // Delete the first monkey
    deleteFirstMonkey(monkeys)

    // Show the monkeys
    showMonkeys(monkeys)
    println(monkeyCounter(monkeys))
    println(longestMonkeyName(monkeys))

    // Check the list
    check(monkeys.count() == 5)
    check(monkeyCounter(monkeys) == "\nThere are 5 Monkeys")

    // Delete the last monkey
    deleteLastMonkey(monkeys)

    // Show the monkeys
    showMonkeys(monkeys)
    println(monkeyCounter(monkeys))
    println(longestMonkeyName(monkeys))

    // Check the list
    check(monkeys.count() == 4)
    check(monkeyCounter(monkeys) == "\nThere are 4 Monkeys")

    // Try to delete 10 monkeys
    for (i in 1..10) {
        if (monkeys.isNotEmpty()) deleteFirstMonkey(monkeys)

    }

    // Show the monkeys
    showMonkeys(monkeys)
    println(monkeyCounter(monkeys))
    println(longestMonkeyName(monkeys))

    // Check the list
    check(monkeys.count() == 0)
    check(monkeyCounter(monkeys) == "There are no Monkeys!")
}


/**
 * Show a given list of monkeys in the format
 * Monkey List
 * -------------------
 * Monkey 1: Dave
 * Monkey 2: Jimmy
 * Monkey 3: Sally
 * etc.
 */
fun showMonkeys(monkeyList: List<String>) {
    println("Monkey List")
    println("-------------------")

    // Loop through the given list and show each monkey
    for ((i, item) in monkeyList.withIndex()) {
        println("Monkey ${i + 1}: $item")
    }    // FIXME: Remove this line and add your code
}


/**
 * Get a monkey name from the user (no blanks allowed)
 * and then add it to the given monkey list
 */
fun getNewMonkey(monkeyList: MutableList<String>) {
    // Ask the user for a monkey name (no blanks)
    val newMonkey = getString("Report a Monkey. What is its name? write here ->:")
    monkeyList.add(newMonkey)
    // Show some feedback
    println("Added new monkey: $newMonkey")
}


/**
 * Returns the number of monkeys in the given list
 * in the format:
 *   There are N monkeys!
 * If there are no monkeys, it should return:
 *   There are no monkeys!
 */
fun monkeyCounter(monkeyList: List<String>): String {
    // return the number of monkeys in the list
    var monkeyCount = monkeyList.size
    if (monkeyList.count() == 0) {
        return "There are no Monkeys!"
    } else {
        return "\nThere are $monkeyCount Monkeys"
    }
}


/**
 * Returns the name of the monkey
 */
fun longestMonkeyName(monkeyList: List<String>): String {
    if (monkeyList.isEmpty()) {
        return "no monkeys"
    } else {
        var longestName: Int = monkeyList[0].length
        for ((_, monkey) in monkeyList.withIndex()) {
            if (monkey.length > longestName) longestName = monkey.length
        }

        val LongestNames = mutableListOf<String>()
        for ((_, monkey) in monkeyList.withIndex()) {
            if (monkey.length == longestName) LongestNames.add(monkey.toString())
        }

        return "Monkeys with the Longest name is $LongestNames each having $longestName characters"   // FIXME!
    }
}


/**
 * Removes the first monkey from the given list
 * if the list is not empty
 */
fun deleteFirstMonkey(monkeyList: MutableList<String>) {
    // Remove the first one from the list
    println("Removing monkey: ${monkeyList.first()}")
    monkeyList.removeFirst()
    // Show some feedback

}


/**
 * Removes the last monkey from the given list
 * if the list is not empty
 */
fun deleteLastMonkey(monkeyList: MutableList<String>) {
    // Remove the last one from the list
    println("Removing monkey: ${monkeyList.last()}")
    monkeyList.removeLast()
}

fun getString(prompt: String): String {
    var userInput: String
    while (true) {
        print(prompt)

        userInput = readln()
        if (userInput.isNotBlank()) break
    }
    return userInput
}

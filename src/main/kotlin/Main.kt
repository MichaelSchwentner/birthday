import java.time.LocalDate
import java.time.Month


fun main() {
    println("Bitte Gib Das Jahr ein in dem du geboren wurdest")
    val year = readln().toInt()

    println("Bitte Gib den Monat ein in dem du geboren wurdest")
    val month = readln().toInt()

    println("Bitte Gib den Tag ein an dem du geboren wurdest")
    val dayOfMonth = readln().toInt()
    val daysUntilNextBirthday = daysUntilNextBirthday(year, month, dayOfMonth)
    println("Days until next birthday: $daysUntilNextBirthday")

}

fun daysUntilNextBirthday(year: Int, month: Int, dayOfMonth: Int): Long {
    val currentDate = LocalDate.now()
    val currentYear = currentDate.year
    val birthday = LocalDate.of(currentYear, month, dayOfMonth)

    return if (birthday.isBefore(currentDate) || birthday.isEqual(currentDate)) {
        val nextBirthday = birthday.plusYears(1)
        nextBirthday.toEpochDay() - currentDate.toEpochDay()
    } else {
        birthday.toEpochDay() - currentDate.toEpochDay()
    }
}
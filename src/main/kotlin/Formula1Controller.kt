import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import kotlin.random.Random

@RestController
@RequestMapping("/api/formula1")
class Formula1Controller {

    @GetMapping("/races")
    fun getFormula1Races(): List<Formula1Race> {
        // Générer des données aléatoires pour les courses de Formule 1
        val races = mutableListOf<Formula1Race>()
        for (i in 1..10) { // Générer 10 courses de Formule 1 pour l'exemple
            val id = i.toLong()
            val name = "Grand Prix ${getRandomCountry()}"

            // Générer une date aléatoire pour la course (entre aujourd'hui et 1 an dans le futur)
            val startDate = LocalDate.now()
            val endDate = LocalDate.now().plusDays(365)
            val date = LocalDate.ofEpochDay(Random.nextLong(startDate.toEpochDay(), endDate.toEpochDay()))

            races.add(Formula1Race(id, name, date))
        }
        return races
    }

    // Fonction pour générer aléatoirement un pays pour le nom de la course
    private fun getRandomCountry(): String {
        val countries = listOf("France", "Germany", "Italy", "Spain", "USA", "Japan", "Brazil", "Australia", "Canada", "China")
        return countries.random()
    }
}
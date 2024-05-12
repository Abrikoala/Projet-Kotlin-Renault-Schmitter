// Importation des classes nécessaires
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

// Annotation déclarant que cette classe est une application Spring Boot
@SpringBootApplication
class RacingCalendarApplication

// Annotation déclarant que cette classe est un contrôleur REST
@RestController
class RacingController {

    // Définition de la route pour la page d'accueil
    @GetMapping("/")
    fun home(): String {
        return "Bienvenue sur l'application de calendrier de courses !"
    }

    // Définition de la route pour afficher les catégories de courses
    @GetMapping("/categories")
    fun categories(): String {
        val categories = listOf("F1", "F2", "F3", "F4", "LMP1", "LMP2", "GTR3")
        val menu = StringBuilder()
        menu.append("<h1>Choisissez une catégorie :</h1>")
        categories.forEach {
            menu.append("<a href=\"/calendar/$it\">$it</a><br>")
        }
        return menu.toString()
    }

    // Définition de la route pour afficher le calendrier d'une catégorie spécifique
    @GetMapping("/calendar/{category}")
    fun calendar(category: String): String {
        // Dans cet exemple, nous allons simplement afficher un calendrier factice
        val calendar = StringBuilder()
        calendar.append("<h1>Calendrier des courses de la catégorie $category :</h1>")
        calendar.append("<p>Calendrier à venir...</p>")
        return calendar.toString()
    }
}

// Fonction principale qui démarre l'application Spring Boot
fun main(args: Array<String>) {
    runApplication<RacingCalendarApplication>(*args)
}

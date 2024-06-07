//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val fitnessTracker = FitnessTracker()

    fitnessTracker.logWorkout(Workout("Running", 30, 300.0))
    fitnessTracker.logWorkout(Workout("Cycling", 45, 400.0))
    fitnessTracker.logWorkout(Workout("Running", 60, 600.0))

    println("Total calories burned: ${fitnessTracker.calculateCaloriesBurned()}")

    val activityProgress = fitnessTracker.getActivityProgress()
    println("Activity progress:")
    activityProgress.forEach { (activity, count) ->
        println("$activity: $count times")
        val employee = Employee(
            name = "John Doe",
            age = 30,
            position = "Senior Developer",
            salary = 80000.0,
            performanceRating = 3
        )

        val annualBonus = employee.calculateAnnualBonus()
        println("Annual bonus for ${employee.name}: $annualBonus")
    }

    }





//Develop a class called "FitnessTracker" that tracks and records fitness activities.
// Implement methods to log workouts, calculate calories burned, and provide statistics on activity progress.

class FitnessTracker {
    private val workouts = mutableListOf<Workout>()

    fun logWorkout(workout: Workout) {
        workouts.add(workout)
    }

    fun calculateCaloriesBurned(): Double {
        return workouts.sumOf { it.caloriesBurned }
    }

    fun getActivityProgress(): Map<String, Int> {
        val activityCount = mutableMapOf<String, Int>()
        workouts.forEach { workout ->
            activityCount[workout.activity] = (activityCount[workout.activity] ?: 0) + 1
        }
        return activityCount
    }
}

data class Workout(
    val activity: String,
    val duration: Int,
    val caloriesBurned: Double
)
//Create a class called "Employee" with properties for name, age, position, and salary.
// Implement a method that calculates and returns the annual bonus amount for the employee based on their position and performance.

class Employee(
    val name: String,
    val age: Int,
    val position: String,
    val salary: Double,
    val performanceRating: Int
) {
    fun calculateAnnualBonus(): Double {
        val bonusPercentage = when (position) {
            "Manager" -> 0.15
            "Senior Developer" -> 0.12
            "Developer" -> 0.10
            else -> 0.05
        }

        val performanceBonus = when (performanceRating) {
            1 -> 0.05
            2 -> 0.10
            3 -> 0.15
            else -> 0.00
        }

        return salary * (bonusPercentage + performanceBonus)
    }
}
class Product(val name:String,val price:Double,val quantity:Double,category: CharCategory){
    fun calculateCost() :Double{
       return price * quantity


    }
}
class ShopingCart{
    val products = mutableListOf<Product>()
    fun addProduct(product: Product){
        products.add(product)
    }
    fun calculateTotalCost() :Double{
        return products.sumOf { it.calculateCost() }
    }
}

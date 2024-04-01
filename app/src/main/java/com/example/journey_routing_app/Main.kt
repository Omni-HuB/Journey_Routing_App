//package com.example.journey_routing_app
//
//import android.os.Bundle
//import android.view.View
//import android.widget.*
//import androidx.appcompat.app.AppCompatActivity
//
//class Main: AppCompatActivity() {
//
//    private lateinit var detailsTextView: TextView
//    private lateinit var detailsNextTextView: TextView
//    private lateinit var progressBar: ProgressBar
//    private lateinit var stopsListView: ListView
//    private lateinit var switchUnitsButton: Button
//    private lateinit var nextStopButton: Button
//
//    private val stops = listOf("Stop 1", "Stop 2", "Stop 3", "Stop 4", "Stop 5",
//        "Stop 6", "Stop 7", "Stop 8", "Stop 9", "Stop 10")
//
//    private var currentStopIndex = 0
//    private var totalDistanceCovered = 0.0
//    private var totalDistanceLeft = calculateTotalDistanceLeft()
//
//    private var isKilometers = true // Default to kilometers
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // Initialize UI components
//        detailsTextView = findViewById(R.id.detailsTxtView)
//        detailsNextTextView = findViewById(R.id.detailsTextView)
//        progressBar = findViewById(R.id.progressBar)
//        stopsListView = findViewById(R.id.stopsListView)
//        switchUnitsButton = findViewById(R.id.switchUnitsButton)
//        nextStopButton = findViewById(R.id.nextStopButton)
//
//        // Set initial values
//        updateDetails()
//        updateProgressBar()
//
//        // Set adapters for the ListView
//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, stops)
//        stopsListView.adapter = adapter
//
//        // Set click listeners for buttons
//        switchUnitsButton.setOnClickListener { switchUnits() }
//        nextStopButton.setOnClickListener { nextStop() }
//    }
//
//    private fun switchUnits() {
//        isKilometers = !isKilometers
//        updateDetails()
//    }
//
//    private fun nextStop() {
//        if (currentStopIndex < stops.size - 1) {
//            currentStopIndex++
//            totalDistanceCovered += calculateDistance(currentStopIndex - 1, currentStopIndex)
//            totalDistanceLeft = calculateTotalDistanceLeft()
//            updateDetails()
//            updateProgressBar()
//        } else {
//            Toast.makeText(this, "Journey completed!", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    private fun updateDetails() {
//        val currentStop = stops[currentStopIndex]
//        val nextStop = if (currentStopIndex < stops.size - 1) stops[currentStopIndex + 1] else "Destination"
//        val distanceToNext = calculateDistance(currentStopIndex, currentStopIndex + 1)
//
//        val distanceUnit = if (isKilometers) "km" else "miles"
//        val totalDistanceCoveredText = String.format("%.2f $distanceUnit", totalDistanceCovered)
//        val totalDistanceLeftText = String.format("%.2f $distanceUnit", totalDistanceLeft)
//
//        detailsTextView.text = "Current Stop: $currentStop\n" +
//                "Distance to Next: $distanceToNext $distanceUnit\n" +
//                "Total Distance Covered: $totalDistanceCoveredText"
//        detailsNextTextView.text = "Next Stop: $nextStop\n" +
//                "Total Distance Left: $totalDistanceLeftText"
//    }
//
//    private fun updateProgressBar() {
//        val progress = ((totalDistanceCovered / calculateTotalDistance()) * 100).toInt()
//        progressBar.progress = progress
//    }
//
//    private fun calculateTotalDistance(): Double {
//        var total = 0.0
//        for (i in 0 until stops.size - 1) {
//            total += calculateDistance(i, i + 1)
//        }
//        return total
//    }
//
//    private fun calculateTotalDistanceLeft(): Double {
//        return calculateTotalDistance() - totalDistanceCovered
//    }
//
//    private fun calculateDistance(fromIndex: Int, toIndex: Int): Double {
//        // You should implement your distance calculation logic here based on your app's requirement
//        // For simplicity, let's assume a constant distance for demonstration purposes
//        return 10.0
//    }
//}

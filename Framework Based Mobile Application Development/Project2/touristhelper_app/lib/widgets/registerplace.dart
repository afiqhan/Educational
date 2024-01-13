import 'package:flutter/material.dart';

class RegisterPlacePage extends StatefulWidget {
  @override
  _RegisterPlacePageState createState() => _RegisterPlacePageState();
}

class _RegisterPlacePageState extends State<RegisterPlacePage> {
  // Create an instance of PlaceDatabase
  final PlaceDatabase placeDatabase = PlaceDatabase();

  @override
  Widget build(BuildContext context) {
    // Get the list of registered places
    List<String> registeredPlaces = placeDatabase.getAllRegisteredPlaces();

    return Scaffold(
      appBar: AppBar(
        title: Text('Registered Places'),
      ),
      body: Center(
        child: registeredPlaces.isEmpty
            ? Text('No places registered yet.')
            : ListView.builder(
                itemCount: registeredPlaces.length,
                itemBuilder: (context, index) {
                  return ListTile(
                    title: Text(registeredPlaces[index]),
                    // You can customize the ListTile as needed
                  );
                },
              ),
      ),
    );
  }
}

class PlaceDatabase {
  // A list to simulate a database
  List<String> registeredPlaces = [];

  // Create: Method to register a place
  void registerPlace(String placeName) {
    registeredPlaces.add(placeName);
  }

  // Read: Method to get all registered places
  List<String> getAllRegisteredPlaces() {
    return List.from(registeredPlaces);
  }

  // Update: Method to update the name of a registered place
  void updatePlaceName(String oldName, String newName) {
    int index = registeredPlaces.indexOf(oldName);
    if (index != -1) {
      registeredPlaces[index] = newName;
    }
  }

  // Delete: Method to unregister a place
  void unregisterPlace(String placeName) {
    registeredPlaces.remove(placeName);
  }
}

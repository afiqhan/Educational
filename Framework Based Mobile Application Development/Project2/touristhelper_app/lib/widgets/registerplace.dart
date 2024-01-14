import 'package:flutter/material.dart';

class RegisterPlacePage extends StatefulWidget {
  @override
  _RegisterPlacePageState createState() => _RegisterPlacePageState();
}

class _RegisterPlacePageState extends State<RegisterPlacePage> {
  // Create an instance of PlaceDatabase
  final PlaceDatabase placeDatabase = PlaceDatabase();

  // Controller for the text field
  final TextEditingController _placeNameController = TextEditingController();

  // Controller for the text field used for updating place name
  final TextEditingController _updatePlaceNameController =
      TextEditingController();

  // Index of the place to be updated
  int? updateIndex;

  @override
  Widget build(BuildContext context) {
    // Get the list of registered places
    List<String> registeredPlaces = placeDatabase.getAllRegisteredPlaces();

    return Scaffold(
      appBar: AppBar(
        title: Text('Registered Places'),
      ),
      body: Center(
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            // Text field for entering a new place name
            Padding(
              padding: const EdgeInsets.all(16.0),
              child: TextField(
                controller: _placeNameController,
                decoration: InputDecoration(
                  hintText: 'Enter place name',
                ),
              ),
            ),
            // Button to register a new place
            ElevatedButton(
              onPressed: () {
                // Register a new place
                String newPlaceName = _placeNameController.text;
                placeDatabase.registerPlace(newPlaceName);

                // Clear the text field
                _placeNameController.clear();

                // Update the UI to reflect the new registered places
                setState(() {});
              },
              child: Text('Register Now'),
            ),
            // Display the list of registered places
            registeredPlaces.isEmpty
                ? Text('No places registered yet.')
                : Expanded(
                    child: ListView.builder(
                      itemCount: registeredPlaces.length,
                      itemBuilder: (context, index) {
                        return ListTile(
                          title: Text(registeredPlaces[index]),
                          // You can customize the ListTile as needed
                          trailing: Row(
                            mainAxisSize: MainAxisSize.min,
                            children: [
                              IconButton(
                                icon: Icon(Icons.edit),
                                onPressed: () {
                                  // Set the index and text field for updating
                                  setState(() {
                                    updateIndex = index;
                                    _updatePlaceNameController.text =
                                        registeredPlaces[index];
                                  });
                                },
                              ),
                              IconButton(
                                icon: Icon(Icons.delete),
                                onPressed: () {
                                  // Delete the place
                                  placeDatabase.unregisterPlace(
                                      registeredPlaces[index]);

                                  // Update the UI to reflect the changes
                                  setState(() {});
                                },
                              ),
                            ],
                          ),
                        );
                      },
                    ),
                  ),
            // Text field for updating a place name
            if (updateIndex != null)
              Padding(
                padding: const EdgeInsets.all(16.0),
                child: Column(
                  children: [
                    TextField(
                      controller: _updatePlaceNameController,
                      decoration: InputDecoration(
                        hintText: 'Enter updated place name',
                      ),
                    ),
                    ElevatedButton(
                      onPressed: () {
                        // Update the place name
                        String updatedPlaceName =
                            _updatePlaceNameController.text;
                        placeDatabase.updatePlaceName(
                            registeredPlaces[updateIndex!], updatedPlaceName);

                        // Clear the text field and reset the updateIndex
                        _updatePlaceNameController.clear();
                        setState(() {
                          updateIndex = null;
                        });
                      },
                      child: Text('Update Place Name'),
                    ),
                  ],
                ),
              ),
          ],
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

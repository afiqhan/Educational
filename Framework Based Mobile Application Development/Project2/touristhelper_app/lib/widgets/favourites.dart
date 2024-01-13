import 'package:flutter/material.dart';
import 'package:touristhelper_app/home_bottom_bar.dart';

class FavoritesPage extends StatelessWidget {
  final List<String> favoritedLocations; // Assume these are the names of favorited locations

  FavoritesPage({Key? key, required this.favoritedLocations}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Favorites'),
      ),
      bottomNavigationBar: HomeBottomBar(),
      backgroundColor:Colors.indigo[400],
      body: favoritedLocations.isEmpty
          ? Center(
              child: Text('No favorites yet.'),
            )
          : ListView.builder(
              itemCount: favoritedLocations.length,
              itemBuilder: (context, index) {
                return Padding(
                  padding: const EdgeInsets.all(8.0),
                  child: Container(
                    decoration: BoxDecoration(
                      color: Colors.white,
                      borderRadius: BorderRadius.circular(8.0),
                      boxShadow: [
                        BoxShadow(
                          color: Colors.grey.withOpacity(0.5),
                          spreadRadius: 2,
                          blurRadius: 5,
                          offset: Offset(0, 2),
                        ),
                      ],
                    ),
                    child: ListTile(
                      title: Text(favoritedLocations[index]),
                      // Add more details if needed
                    ),
                  ),
                );
              },
            ),
    );
  }
}


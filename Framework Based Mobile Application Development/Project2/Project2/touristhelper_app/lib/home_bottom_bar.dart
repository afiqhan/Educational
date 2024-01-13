import 'package:curved_navigation_bar/curved_navigation_bar.dart';
import 'package:flutter/material.dart';
import 'package:touristhelper_app/widgets/favourites.dart';
import 'package:touristhelper_app/widgets/person.dart';
import 'package:touristhelper_app/widgets/Q&A.dart';


class HomeBottomBar extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return CurvedNavigationBar(
      backgroundColor: Colors.transparent,
      index: 2,
      items: [
        Icon(Icons.person, size: 30),
        Icon(Icons.favorite_outline, size: 30),
        Icon(Icons.home, size: 30, color: Colors.redAccent),
        Icon(Icons.location_city_outlined, size: 30),
        Icon(Icons.list, size: 30),
      ],

      // profile page
      onTap: (index) {
        // Handle the onTap event for each icon
        switch (index) {
          case 0:
            // Navigate to the PersonPage
            Navigator.push(
                          context,
                          MaterialPageRoute(
                            builder: (context) => PersonPage(), //when click this get started it will go to the sign up
                          ));
            break;

           case 1: // Index for the "location_city_outlined" button
            // Navigate to the LocationPage
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => FavoritesPage(favoritedLocations: [],)),
            );
            break;

          
           case 3: // Index for the "location_city_outlined" button
            // Navigate to the LocationPage
            Navigator.push(
              context,
              MaterialPageRoute(builder: (context) => TouristQAPage()),
            );
            break;
          // Handle other cases if needed
        }
      },
    );
  }
}





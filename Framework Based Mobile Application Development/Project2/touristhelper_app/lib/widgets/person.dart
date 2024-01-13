import 'package:flutter/material.dart';
import 'package:touristhelper_app/home_bottom_bar.dart';

class PersonPage extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        
        title: Text('Person Page'),
        
      ),
      bottomNavigationBar: HomeBottomBar(),
      backgroundColor:Colors.indigo[400],
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.center,
          children: [
            CircleAvatar(
              radius: 50,
              backgroundImage: AssetImage('assets/person_image.jpg'), // Add your image asset
            ),
            SizedBox(height: 20),
            Text(
              'Welcome to the Person Page!',
              style: TextStyle(
                fontSize: 20,
                fontWeight: FontWeight.bold,
              ),
            ),
            SizedBox(height: 10),
            Text(
              'Here you can add your person-related content.',
              textAlign: TextAlign.center,
            ),
          ],
        ),
      ),
    );
  }
}

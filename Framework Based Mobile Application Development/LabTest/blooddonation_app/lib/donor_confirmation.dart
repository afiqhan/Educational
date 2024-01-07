import 'package:flutter/material.dart';

class DonorConfirmation extends StatelessWidget {
  final String name;
  final String matricNumber;
  final String bloodType;

  DonorConfirmation({
    required this.name,
    required this.matricNumber,
    required this.bloodType,
  });

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Student Records'),
         backgroundColor: Colors.red,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Text('Full Name: $name'),
            SizedBox(height: 10),
            Text('Matric Number: $matricNumber'),
            SizedBox(height: 10),
            Text('Blood Type: $bloodType'),
          ],
        ),
      ),
    );
  }
}

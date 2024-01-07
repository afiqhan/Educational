import 'package:flutter/material.dart';
import 'donor_confirmation.dart';

class DonorForm extends StatefulWidget {
  @override
  _DonorFormState createState() => _DonorFormState();
}

class _DonorFormState extends State<DonorForm> {
  final TextEditingController nameController = TextEditingController();
  final TextEditingController matricController = TextEditingController();
  String bloodType = 'A';

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('Donor Registration'),
        backgroundColor: Colors.red,
      ),
      body: Padding(
        padding: const EdgeInsets.all(16.0),
        child: Column(
          mainAxisAlignment: MainAxisAlignment.center,
          children: [
            TextField(
              controller: nameController,
              decoration: InputDecoration(labelText: 'Full Name'),
            ),
            SizedBox(height: 20),
            TextField(
              controller: matricController,
              decoration: InputDecoration(labelText: 'Matric Number'),
            ),
            SizedBox(height: 20),
            DropdownButton<String>(
              value: bloodType,
              onChanged: (String? newValue) {
                setState(() {
                  bloodType = newValue!;
                });
              },
              items: ['A', 'B', 'AB', 'O', 'A-', 'B-', 'AB-', 'O-']
                  .map<DropdownMenuItem<String>>((String value) {
                return DropdownMenuItem<String>(
                  value: value,
                  child: Text(value),
                );
              }).toList(),
            ),
            SizedBox(height: 20),
            ElevatedButton(
              onPressed: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(
                    builder: (context) => DonorConfirmation(
                      name: nameController.text,
                      matricNumber: matricController.text,
                      bloodType: bloodType,
                    ),
                  ),
                );
              },
              style: ElevatedButton.styleFrom(
                primary: Colors.red,
              ),
              child: Text('Register'),
            ),
          ],
        ),
      ),
    );
  }
}

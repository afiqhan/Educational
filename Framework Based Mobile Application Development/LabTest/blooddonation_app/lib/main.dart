//author : afiq hanif 

import 'package:flutter/material.dart';
import 'donor_form.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'UMT Blood Donation Mobile App',
      home: DonorForm(),
      theme: ThemeData()
    );
  }
}



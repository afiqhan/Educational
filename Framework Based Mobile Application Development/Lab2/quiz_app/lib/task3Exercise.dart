/*
Name: Afiq Hanif
Matrix Number:S62993
Date: 10/10/2023
*/

import 'package:flutter/material.dart';

void main() {
  runApp(const MyDiscountApp());
}

class MyDiscountApp extends StatefulWidget {
  @override
  const MyDiscountApp({super.key});
  State<StatefulWidget> createState() {
    return MyDiscountAppState();
    throw UnimplementedError();
  }
}

class MyDiscountAppState extends State<MyDiscountApp> {
  // var questionIndex = 0;
  // void answerQuestion() {
  //   // print('Answer chosen ..!');
    
  //   setState(() {
  //     questionIndex =(questionIndex < 1)? questionIndex +1:questionIndex = 0;
  //   }); 
  //   print(questionIndex); 
  // }

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    var questions = 'What type of discount do you want?';
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('My Discount App'),
        ),
        body: Column(
          children: [
            Text(questions),
            ElevatedButton(onPressed: ()=> {print('type 1 is clicked')}, child: const Text('Type 1')),
            ElevatedButton(onPressed: ()=> {print('type 2 is clicked')}, child: const Text('Type 2')),
            
          ],
        ),
      ),
    );
  }
}